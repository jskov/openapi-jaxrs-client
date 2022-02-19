package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.SecurityScheme;
import dk.mada.jaxrs.model.api.Content;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.api.Parameter;
import dk.mada.jaxrs.model.api.RequestBody;
import dk.mada.jaxrs.model.api.Response;
import dk.mada.jaxrs.model.api.StatusCode;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeVoid;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.parameters.PathParameter;
import io.swagger.v3.oas.models.parameters.QueryParameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;

/**
 * Transforms OpenApi operations to local model objects.
 *
 * DefaultGenerator:processOperation
 */
public class ApiTransformer {
    private static final Logger logger = LoggerFactory.getLogger(ApiTransformer.class);

    /** Parser options. */
    private final ParserOpts parseOpts;
    /** Type converter. */
    private final TypeConverter typeConverter;
    /** Security schemes. */
    private final List<SecurityScheme> securitySchemes;

    /** List of operations added as the api is traversed. */
    private List<Operation> ops;

    /**
     * Constructs a new API transformer instance.
     *
     * @param parseOpts Parser options
     * @param typeConverter Type converter
     * @param securitySchemes Security schemes
     */
    public ApiTransformer(ParserOpts parseOpts, TypeConverter typeConverter, List<SecurityScheme> securitySchemes) {
        this.parseOpts = parseOpts;
        this.typeConverter = typeConverter;
        this.securitySchemes = securitySchemes;
    }

    /**
     * Transforms OpenApi specification to operations.
     *
     * @param specification the OpenApi specification
     * @return Operations in the API
     */
    public Operations transform(OpenAPI specification) {
        ops = new ArrayList<>();

        Paths paths = specification.getPaths();
        if (paths != null) {
            Set<Entry<String, PathItem>> pathEntries = paths.entrySet();
            if (pathEntries != null) {
                for (Map.Entry<String, PathItem> pathsEntry : pathEntries) {
                    String resourcePath = pathsEntry.getKey();
                    PathItem path = pathsEntry.getValue();
                    processPath(resourcePath, path);
                }
            }
        }
        return new Operations(ops);
    }

    private void processPath(String resourcePath, PathItem path) {
        logger.info("Process path {}", resourcePath);
        path.readOperationsMap()
            .forEach((httpMethod, op) -> processOp(resourcePath, httpMethod, op));
    }

    private void processOp(String resourcePath, HttpMethod httpMethod, io.swagger.v3.oas.models.Operation op) {
        List<String> tags = op.getTags();
        if (tags == null) {
            tags = List.of();
        }

        List<Parameter> parameters = getParameters(op);

        List<Response> responses = op.getResponses().entrySet().stream()
                .map(e -> {
                    String code = e.getKey();
                    ApiResponse resp = e.getValue();
                    return toResponse(resourcePath, code, resp);
                })
                .toList();

        String methodSuffix = OpenapiGeneratorUtils.camelize(httpMethod.name().toLowerCase());
        String codegenOpId = OpenapiGeneratorUtils.getOrGenerateOperationId(op, resourcePath, methodSuffix);

        ops.add(Operation.builder()
                .tags(tags)
                .description(op.getDescription())
                .summary(op.getSummary())
                .deprecated(toBool(op.getDeprecated()))
                .operationId(op.getOperationId())
                .codegenOpId(codegenOpId)
                .httpMethod(toModelHttpMethod(httpMethod))
                .path(resourcePath)
                .responses(responses)
                .parameters(parameters)
                .requestBody(getRequestBody(resourcePath, op))
                .addAuthorizationHeader(shouldAddAuthHeader(op))
                .build());
    }

    private Response toResponse(String resourcePath, String code, ApiResponse resp) {
        Response r = Response.builder()
                .code(StatusCode.of(code))
                .description(resp.getDescription())
                .content(getContent(resourcePath, resp.getContent()))
                .build();

        if (parseOpts.isFixupVoid200to204()
                && r.code() == StatusCode.HTTP_OK
                && r.content().type() instanceof TypeVoid) {
            logger.info("Fixing broken 200/void response on path '{}' to 204", resourcePath);
            r = Response.builder().from(r)
                    .code(StatusCode.HTTP_NO_CONTENT)
                    .description("No Content")
                    .build();
        }
        return r;
    }

    private Content getContent(String resourcePath, io.swagger.v3.oas.models.media.Content c) {
        Type t;
        Set<String> mediaTypes;

        if (c == null) {
            t = TypeVoid.get();
            mediaTypes = Set.of();
        } else {
            mediaTypes = c.keySet();

            @SuppressWarnings("rawtypes")
            Set<Schema> schemas = c.values().stream()
                .map(MediaType::getSchema)
                .collect(toSet());

            if (schemas.isEmpty()) {
                t = TypeVoid.get();
            } else if (schemas.size() == 1) {
                t = typeConverter.toType(schemas.iterator().next());
            } else {
                // The assumption is that the underlying type must be the same.
                // But there may be different examples/descriptions whatnot to collect.
                throw new IllegalStateException("Cannot handle multiple schemas yet: " + resourcePath);
            }
        }
        logger.debug("GOT TYPE {}", t);

        return Content.builder()
                .mediaTypes(mediaTypes)
                .type(t)
                .build();
    }

    private Optional<RequestBody> getRequestBody(String resourcePath, io.swagger.v3.oas.models.Operation op) {
        io.swagger.v3.oas.models.parameters.RequestBody body = op.getRequestBody();
        if (body == null) {
            return Optional.empty();
        }
        Content content = getContent(resourcePath, body.getContent());

        return Optional.of(
                RequestBody.builder()
                .description(body.getDescription())
                .isRequired(toBool(body.getRequired()))
                .content(content)
                .build());
    }

    // Just a shortcut to determine if auth header should be added
    /**
     * Determines if the operation should be given an authorization
     * header parameter.
     *
     * If there is global security on the entire API, the operation
     * can still override by using an empty security set.
     *
     * @see <a href="https://swagger.io/specification/#securityRequirementObject">OpenApi securityRequirementObject</a>
     *
     * @param op the operation to consider
     * @return true if the operation needs an auth header parameter
     */
    private boolean shouldAddAuthHeader(io.swagger.v3.oas.models.Operation op) {
        boolean apiHasSecurity = !securitySchemes.isEmpty();
        List<SecurityRequirement> opSecurity = op.getSecurity();
        boolean isOpSecurityDisabled = opSecurity != null && opSecurity.isEmpty();
        boolean isOpSecurityEnabled = opSecurity != null && !opSecurity.isEmpty();
        return isOpSecurityEnabled || (apiHasSecurity && !isOpSecurityDisabled);
    }

    private List<Parameter> getParameters(io.swagger.v3.oas.models.Operation op) {
        List<io.swagger.v3.oas.models.parameters.Parameter> params = op.getParameters();
        if (params == null) {
            return List.of();
        }

        return params.stream()
                .map(this::toParam)
                .toList();
    }

    private Parameter toParam(io.swagger.v3.oas.models.parameters.Parameter param) {
        boolean isHeaderParam = param instanceof HeaderParameter;
        boolean isPathParam = param instanceof PathParameter;
        boolean isQueryParam = param instanceof QueryParameter;

        return Parameter.builder()
                .name(param.getName())
                .description(param.getDescription())
                .isRequired(toBool(param.getRequired()))
                .type(typeConverter.toType(param.getSchema()))
                .isHeaderParam(isHeaderParam)
                .isPathParam(isPathParam)
                .isQueryParam(isQueryParam)
                .build();
    }

    private boolean toBool(Boolean b) {
        return b == Boolean.TRUE;
    }

    private dk.mada.jaxrs.model.api.HttpMethod toModelHttpMethod(HttpMethod m) {
        return dk.mada.jaxrs.model.api.HttpMethod.valueOf(m.name());
    }
}
