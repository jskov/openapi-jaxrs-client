package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.TypeVoid;
import dk.mada.jaxrs.naming.Naming;
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

    /** Naming. */
    private final Naming naming;
    /** Parser options. */
    private final ParserOpts parseOpts;
    /** Type converter. */
    private final TypeConverter typeConverter;
    /** Security schemes. */
    private final List<SecurityScheme> securitySchemes;

    /** List of operations added as the api is traversed. */
    private final List<Operation> ops = new ArrayList<>();

    /**
     * Constructs a new API transformer instance.
     *
     * @param naming          the naming instance
     * @param parseOpts       the parser options
     * @param typeConverter   the type converter
     * @param securitySchemes the security schemes
     */
    public ApiTransformer(Naming naming, ParserOpts parseOpts, TypeConverter typeConverter, List<SecurityScheme> securitySchemes) {
        this.naming = naming;
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
        logger.debug(" process op {} : {}", resourcePath, httpMethod);
        List<String> tags = op.getTags();
        if (tags == null) {
            tags = List.of();
        }

        List<Parameter> parameters = new ArrayList<>(getParameters(op));

        Optional<RequestBody> requestBody = getRequestBody(resourcePath, op);
        requestBody.ifPresent(rb -> parameters.addAll(rb.content().formParameters()));

        List<Response> responses;
        if (op.getResponses() != null) {
            responses = op.getResponses().entrySet().stream()
                    .map(e -> {
                        String code = e.getKey();
                        ApiResponse resp = e.getValue();
                        return toResponse(resourcePath, code, resp);
                    })
                    .toList();
        } else {
            responses = List.of();
        }

        ops.add(Operation.builder()
                .tags(tags)
                .description(Optional.ofNullable(op.getDescription()))
                .summary(Optional.ofNullable(op.getSummary()))
                .deprecated(toBool(op.getDeprecated()))
                .operationId(naming.convertOperationIdName(op.getOperationId()))
                .syntheticOpId(generateSyntheticOpId(resourcePath, httpMethod))
                .httpMethod(toModelHttpMethod(httpMethod))
                .path(resourcePath)
                .responses(responses)
                .parameters(parameters)
                .requestBody(requestBody)
                .addAuthorizationHeader(shouldAddAuthHeader(op))
                .build());
    }

    private String generateSyntheticOpId(String resourcePath, HttpMethod httpMethod) {
        String opPath = resourcePath
                .replaceAll("[{}/_]", "-")
                .replaceFirst("^-", "")
                .replaceFirst("-$", "");
        String syntheticOpId = opPath + "-" + httpMethod.name().toLowerCase(Locale.ROOT);

        return naming.convertOperationName(syntheticOpId);
    }

    private Response toResponse(String resourcePath, String code, ApiResponse resp) {
        Response r = Response.builder()
                .code(StatusCode.of(code))
                .description(Optional.ofNullable(resp.getDescription()))
                .content(getContent(resourcePath, resp.getContent(), false))
                .build();

        if (r.code() == StatusCode.HTTP_OK && r.content().reference().isVoid()) {
            if (parseOpts.isFixupVoid200to204()) {
                logger.info("Fixing broken 200/void response on path '{}' to 204", resourcePath);
                r = Response.builder().from(r)
                        .code(StatusCode.HTTP_NO_CONTENT)
                        .description("No Content")
                        .build();
            } else {
                throw new IllegalArgumentException("The path '" + resourcePath
                        + "' does not provide a return type. Either fix the API, or enable the option parser-fixup-void-200-to-204.");
            }
        }
        return r;
    }

    private Content getContent(String resourcePath, io.swagger.v3.oas.models.media.Content c, boolean isRequired) {
        Reference ref;
        Set<String> mediaTypes;
        List<Parameter> formParameters = List.of();

        if (c == null) {
            ref = TypeVoid.getRef();
            mediaTypes = Set.of();
        } else {
            mediaTypes = c.keySet();

            @SuppressWarnings("rawtypes")
            Set<Schema> schemas = c.values().stream()
                    .map(MediaType::getSchema)
                    .collect(toSet());

            if (schemas.isEmpty()) {
                ref = TypeVoid.getRef();
            } else if (schemas.size() > 1) {
                // The assumption is that the underlying type must be the same.
                // But there may be different examples/descriptions whatnot to collect.
                throw new IllegalStateException("Cannot handle multiple schemas yet: " + resourcePath);
            } else {
                Schema<?> ss = schemas.iterator().next();
                if (ss == null) {
                    // This happens in some documents
                    ref = TypeVoid.getRef();
                } else {
                    ref = typeConverter.toReference(ss, isRequired);

                    // form parameters via properties on body
                    @SuppressWarnings({ "rawtypes" })
                    Map<String, Schema> props = ss.getProperties();
                    if (props != null) {
                        formParameters = props.entrySet().stream()
                                .map(e -> toFormParameter(e.getKey(), e.getValue()))
                                .toList();
                    }
                }
            }
        }
        logger.debug("Content reference {}", ref);

        return Content.builder()
                .mediaTypes(mediaTypes)
                .reference(ref)
                .formParameters(formParameters)
                .build();
    }

    // At least an enum parameter may have to be rendered as a standalone
    // type (DTO). This does not happen with this code alone.
    private Parameter toFormParameter(String name, @SuppressWarnings("rawtypes") Schema schema) {
        ParserTypeRef dtoPtr = typeConverter.reference(schema, name, null);
        logger.debug("Parse form param {} : {}", name, dtoPtr);

        return Parameter.builder()
                .name(name)
                .isHeaderParam(false)
                .isPathParam(false)
                .isQueryParam(false)
                .isFormParam(true)
                .reference(dtoPtr)
                .build();
    }

    private Optional<RequestBody> getRequestBody(String resourcePath, io.swagger.v3.oas.models.Operation op) {
        io.swagger.v3.oas.models.parameters.RequestBody body = op.getRequestBody();
        if (body == null) {
            return Optional.empty();
        }
        boolean isRequired = toBool(body.getRequired());
        Content content = getContent(resourcePath, body.getContent(), isRequired);

        return Optional.of(
                RequestBody.builder()
                        .description(Optional.ofNullable(body.getDescription()))
                        .content(content)
                        .build());
    }

    // Just a shortcut to determine if auth header should be added
    /**
     * Determines if the operation should be given an authorization header parameter.
     *
     * If there is global security on the entire API, the operation can still override by using an empty security set.
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
        String name = param.getName();
        String paramIn = param.getIn();

        boolean isPathParam = param instanceof PathParameter || "path".equals(paramIn);
        boolean isHeaderParam = param instanceof HeaderParameter || "header".equals(paramIn);
        boolean isQueryParam = param instanceof QueryParameter || "query".equals(paramIn);

        boolean isParamRequired = toBool(param.getRequired());
        Reference ref = typeConverter.toReference(param.getSchema(), isParamRequired);

        logger.debug("Parse param {} : {}", name, ref);

        return Parameter.builder()
                .name(name)
                .description(Optional.ofNullable(param.getDescription()))
                .reference(ref)
                .isHeaderParam(isHeaderParam)
                .isPathParam(isPathParam)
                .isQueryParam(isQueryParam)
                .isFormParam(false)
                .build();
    }

    private boolean toBool(Boolean b) {
        return Boolean.TRUE.equals(b);
    }

    private dk.mada.jaxrs.model.api.HttpMethod toModelHttpMethod(HttpMethod m) {
        return dk.mada.jaxrs.model.api.HttpMethod.valueOf(m.name());
    }
}
