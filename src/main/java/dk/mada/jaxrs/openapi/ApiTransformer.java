package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.toList;
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
import dk.mada.jaxrs.model.api.ImmutableResponse;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.api.Parameter;
import dk.mada.jaxrs.model.api.RequestBody;
import dk.mada.jaxrs.model.api.Response;
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

/**
 * Transforms OpenApi operations to local model objects.
 * 
 * DefaultGenerator:processOperation
 */
public class ApiTransformer {
    private static final Logger logger = LoggerFactory.getLogger(ApiTransformer.class);

    private final TypeConverter typeConverter;
    private final List<SecurityScheme> securitySchemes;

    private List<Operation> ops;


    public ApiTransformer(TypeConverter typeConverter, List<SecurityScheme> securitySchemes) {
        this.typeConverter = typeConverter;
        this.securitySchemes = securitySchemes;
    }

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
                .collect(toList());

        String codegenOpId = OpenapiGeneratorUtils.getOrGenerateOperationId(op, resourcePath, OpenapiGeneratorUtils.camelize(httpMethod.name().toLowerCase()));

        ops.add(Operation.builder()
                .tags(tags)
                .description(op.getDescription())
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

    // TODO: map to actual HTTP constants, map default to maybe 0?
    private ImmutableResponse toResponse(String resourcePath, String code, ApiResponse resp) {
        return Response.builder()
                .code(Integer.parseInt(code))
                .description(resp.getDescription())
                .content(getContent(resourcePath, resp.getContent()))
                .build();
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
    private boolean shouldAddAuthHeader(io.swagger.v3.oas.models.Operation op) {
        boolean hasSecurity = !securitySchemes.isEmpty();
        boolean isOpSecurityDisabled = op.getSecurity() != null && op.getSecurity().isEmpty();
        return hasSecurity && !isOpSecurityDisabled;
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
                .isRequired(param.getRequired())
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
