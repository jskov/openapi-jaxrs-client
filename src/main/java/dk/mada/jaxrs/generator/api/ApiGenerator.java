package dk.mada.jaxrs.generator.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.CommonPathFinder;
import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Imports;
import dk.mada.jaxrs.generator.StringRenderer;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.api.tmpl.CtxApi;
import dk.mada.jaxrs.generator.api.tmpl.CtxApi.CtxOperationRef;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiExt;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiOp;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiOpExt;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiParam;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiParamExt;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiResponse;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Parameter;
import dk.mada.jaxrs.model.api.Response;
import dk.mada.jaxrs.model.api.StatusCode;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeContainer;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeVoid;
import dk.mada.jaxrs.naming.Naming;

/**
 * API generator.
 *
 * Processes the model's APIs and prepares API contexts
 * for template rendering.
 */
public class ApiGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ApiGenerator.class);

    /**
     * Media types supported for now.
     */
    private static final Map<String, String> MEDIA_TYPES = Map.of(
            "application/json", "APPLICATION_JSON",
            "text/plain", "TEXT_PLAIN"
            );

    /** Naming. */
    private final Naming naming;
    /** Generator options. */
    private final GeneratorOpts opts;
    /** Templates. */
    private final Templates templates;
    /** The data model. */
    private final Model model;

    /** Common path finder. */
    private final CommonPathFinder commonPathFinder = new CommonPathFinder();

    /**
     * Constructs a new API generator.
     *
     * @param naming the naming instance
     * @param generatorOpts the generator options
     * @param templates the templates instance
     * @param model the data model
     */
    public ApiGenerator(Naming naming, GeneratorOpts generatorOpts, Templates templates, Model model) {
        this.naming = naming;
        this.opts = generatorOpts;
        this.templates = templates;
        this.model = model;
    }

    /**
     * Generates all API classes.
     */
    public void generateApiClasses() {
        model.operations().getByGroup().entrySet().stream()
            .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
            .forEach(ops -> {
                String group = ops.getKey();
                String classname = makeClassName(group);

                processApi(ops, classname);
        });
    }

    private void processApi(Entry<String, List<Operation>> ops, String classname) {
        CtxApi ctx = toCtx(classname, ops.getValue());
        templates.renderApiTemplate(ctx);
    }

    private String makeClassName(String group) {
        String input = group.endsWith("Api") ? group : group + "Api";
        return naming.convertTypeName(input);
    }

    private CtxApi toCtx(String classname, List<Operation> operations) {
        var imports = Imports.newApi(opts);

        List<String> paths = operations.stream()
                    .map(Operation::path)
                    .toList();
        String commonPath = commonPathFinder.findCommonPath(paths);

        int trimPathLength = commonPath.length();

        List<CtxOperationRef> ops = makeOperations(operations, imports, trimPathLength);

        imports.trimContainerImplementations();

        String clientKey = opts.getMpClientConfigKey();
        if (clientKey != null) {
            imports.add("org.eclipse.microprofile.rest.client.inject.RegisterRestClient");
        }

        List<String> mpProviders = opts.getMpProviders().stream()
                .sorted()
                .toList();
        if (!mpProviders.isEmpty()) {
            imports.add("org.eclipse.microprofile.rest.client.annotation.RegisterProvider");
        }

        CtxApiExt apiExt = CtxApiExt.builder()
                .mpRestClientConfigKey(clientKey)
                .mpProviders(mpProviders)
                .build();

        Info info = model.info();
        return CtxApi.builder()
                .appDescription(info.description())
                .appName(info.title())
                .version(info.version())
                .infoEmail(info.contact().email())
                .generatedDate(opts.getGeneratedAtTime())
                .generatorClass(opts.generatorId())
                .classname(classname)
                .operations(ops)
                .packageName(opts.apiPackage())
                .imports(imports.get())
                .commonPath(commonPath)
                .madaApi(apiExt)
                .build();
    }

    private List<CtxOperationRef> makeOperations(List<Operation> operations, Imports imports, int trimPathLength) {
        return operations.stream()
                .sorted(this::operatorOrdering)
                .map(op -> toCtxApiOperation(imports, trimPathLength, op))
                .toList();
    }

    private int operatorOrdering(Operation a, Operation b) {
        int pathComparison = a.path().compareTo(b.path());
        if (pathComparison != 0) {
            return pathComparison;
        }

        return a.httpMethod().compareTo(b.httpMethod());
    }

    private CtxOperationRef toCtxApiOperation(Imports imports, int trimPathLength, Operation op) {
        addOperationImports(imports, op);

        String nickname = op.operationId();
        if (nickname == null) {
            nickname = op.codegenOpId();
        }

        // Gets type for OK if present, or else default, or else void
        Reference typeRef = getTypeForStatus(op, StatusCode.HTTP_OK)
            .or(() -> getTypeForStatus(op, StatusCode.HTTP_DEFAULT))
            .orElse(TypeReference.of(TypeVoid.get(), Validation.NO_VALIDATION));

        String path = op.path().substring(trimPathLength);
        if (path.isEmpty()) {
            path = null;
        }

        List<CtxApiParam> allParams = getParams(imports, op);
        List<CtxApiResponse> responses = getResponses(imports, op);

        boolean onlySimpleResponse = addImports(imports, op);

        boolean renderJavadocReturn = !typeRef.isVoid();
        boolean renderJavadocMacroSpacer = renderJavadocReturn || !allParams.isEmpty();

        String summary = op.summary();

        String opSummaryString = StringRenderer.encodeForString(summary);
        if (opSummaryString != null) {
            imports.add("org.eclipse.microprofile.openapi.annotations.Operation");
        }

        CtxApiOpExt ext = CtxApiOpExt.builder()
                .consumes(makeConsumes(imports, op))
                .produces(makeProduces(imports, op))
                .renderJavadocMacroSpacer(renderJavadocMacroSpacer)
                .renderJavadocReturn(renderJavadocReturn)
                .responseSchema(onlySimpleResponse)
                .summaryString(opSummaryString)
                .build();

        String description = op.description();

        return new CtxOperationRef(CtxApiOp.builder()
                .nickname(nickname)
                .returnType(typeRef.typeName().name())
                .path(path)
                .httpMethod(op.httpMethod().name())
                .allParams(allParams)
                .responses(responses)
                .summary(StringRenderer.makeValidJavadocSummary(summary))
                .notes(description)
                .madaOp(ext)
                .build());
    }

    private Optional<Reference> getTypeForStatus(Operation op, StatusCode statusCode) {
        return op.responses().stream()
                .filter(r -> r.code() == statusCode)
                .map(r -> r.content().reference())
                .findFirst();
    }

    private boolean addImports(Imports imports, Operation op) {
        boolean onlySimpleResponse = isOnlySimpleResponse(op.responses());
        if (onlySimpleResponse) {
            imports.add("org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema");
        } else {
            imports.add("org.eclipse.microprofile.openapi.annotations.responses.APIResponse");
            imports.add("org.eclipse.microprofile.openapi.annotations.responses.APIResponses");

            if (!op.responses().stream().allMatch(r -> r.content().reference().isVoid())) {
                imports.add("org.eclipse.microprofile.openapi.annotations.media.Content");
                imports.add("org.eclipse.microprofile.openapi.annotations.media.Schema");
            }
        }
        return onlySimpleResponse;
    }

    /**
     * Determine if all the response types can be rendered via
     * the simple @APIResponseSchema annotation.
     *
     * @param responses the responses
     */
    // TODO: probably needs to be more clever - must consider that description matches code(). But this will do for now.
    private boolean isOnlySimpleResponse(List<Response> responses) {
        if (responses.size() != 1) {
            return false;
        }

        Response r = responses.get(0);
        boolean isContainer = r.content().reference().isContainer();
        boolean isSimpleResponse = !isContainer && r.code() == StatusCode.HTTP_OK;
        logger.debug(" simple: {}", isSimpleResponse);
        return isSimpleResponse;
    }

    private void addOperationImports(Imports imports, Operation op) {
        op.responses().stream()
            .map(r -> r.content().reference())
            .forEach(imports::add);
    }

    /**
     * Note from https://docs.oracle.com/cd/E19776-01/820-4867/ghrst/index.html
     *  If @DefaultValue is not used in conjunction with @QueryParam, and the query parameter
     *  is not present in the request, then value will be an empty collection for List, Set,
     *  or SortedSet; null for other object types; and the Java-defined default for primitive types.
     *
     * So the primitive types can be used instead of wrapper types.
     *
     * @param imports the imports for the API
     * @param op the operation to extract parameters from
     */
    private List<CtxApiParam> getParams(Imports imports, Operation op) {
        CtxApiParamExt madaParamEmpty = CtxApiParamExt.builder().build();

        List<CtxApiParam> params = new ArrayList<>();
        if (op.addAuthorizationHeader()) {
            params.add(CtxApiParam.builder()
                    .baseName("Authorization")
                    .paramName("auth")
                    .dataType(Primitive.STRING.typeName().name())
                    .required(true)
                    .isBodyParam(false)
                    .isHeaderParam(true)
                    .isPathParam(false)
                    .isQueryParam(false)
                    .useBeanValidation(opts.isUseBeanValidation())
                    .madaParam(madaParamEmpty)
                    .build());
        }

        for (Parameter p : op.parameters()) {
            Reference ref = p.reference();
            imports.add(ref);

            String paramName = naming.convertParameterName(p.name());

            Type type = ref.refType();
            String dataType = paramDataType(type);

            Validation validation = ref.validation();
            logger.debug("See param {} : {} : {}", paramName, type, validation);

            boolean required = validation.isRequired() || p.isRequired();
            if (opts.isUseBeanValidation() && required) {
                imports.add("javax.validation.constraints.NotNull");
            }

            params.add(CtxApiParam.builder()
                    .baseName(p.name())
                    .paramName(paramName)
                    .dataType(dataType)
                    .required(required)
                    .isBodyParam(false)
                    .isHeaderParam(p.isHeaderParam())
                    .isQueryParam(p.isQueryParam())
                    .isPathParam(p.isPathParam())
                    .madaParam(madaParamEmpty)
                    .useBeanValidation(opts.isUseBeanValidation())
                    .build());
        }

        op.requestBody().ifPresent(body -> {
            Reference ref = body.content().reference();
            imports.add(ref);

            String dtoParamName = naming.convertEntityName(ref.typeName().name());
            String dataType = paramDataType(ref);

            params.add(CtxApiParam.builder()
                    .baseName("unused")
                    .paramName(dtoParamName)
                    .dataType(dataType)
                    .required(body.isRequired())
                    .isBodyParam(true)
                    .isHeaderParam(false)
                    .isPathParam(false)
                    .isQueryParam(false)
                    .useBeanValidation(opts.isUseBeanValidation())
                    .madaParam(madaParamEmpty)
                    .build());
        });

        logger.debug("Params: {}", params);

        return params;
    }

    private String paramDataType(Type type) {
        return opts.isUseApiWrappedPrimitives()
                ? type.wrapperTypeName().name()
                : type.typeName().name();
    }

    private List<CtxApiResponse> getResponses(Imports imports, Operation op) {
        return op.responses().stream()
                .sorted((a, b) -> a.code().compareTo(b.code()))
                .map(r -> makeResponse(imports, r))
                .toList();
    }

    private CtxApiResponse makeResponse(Imports imports, Response r) {
        String baseType;
        String containerType;
        Reference typeRef = r.content().reference();
        Type type = typeRef.refType();
        boolean isUnique = false;

        if (type instanceof TypeContainer tc) {
            baseType = tc.innerType().wrapperTypeName().name();
            containerType = "SchemaType.ARRAY";
            imports.add("org.eclipse.microprofile.openapi.annotations.enums.SchemaType");

            isUnique = type instanceof TypeSet;
        } else if (type.isVoid()) {
            baseType = null;
            containerType = null;
        } else {
            baseType = type.wrapperTypeName().name();
            containerType = null;
        }

        return CtxApiResponse.builder()
                .baseType(baseType)
                .code(r.code().asOpenApiStatus())
                .containerType(containerType)
                .description(r.description())
                .isUnique(isUnique)
                .build();
    }

    private String makeConsumes(Imports imports, Operation op) {
        return op.requestBody()
                .map(rb -> makeMediaTypeArgs(imports, rb.content().mediaTypes().stream()))
                .orElse(null);
    }

    private String makeProduces(Imports imports, Operation op) {
        Stream<String> combinedMediaTypes = op.responses().stream()
                .flatMap(r -> r.content().mediaTypes().stream());
        return makeMediaTypeArgs(imports, combinedMediaTypes);
    }

    private String makeMediaTypeArgs(Imports imports, Stream<String> mediaTypes) {
        List<String> wrappedMediaTypes = mediaTypes
                .map(mt -> toMediaType(imports, mt))
                .sorted()
                .distinct()
                .toList();

        String arg = String.join(", ", wrappedMediaTypes);
        if (wrappedMediaTypes.size() > 1) {
            arg = "{" + arg + "}";
        }
        if (wrappedMediaTypes.isEmpty()) {
            arg = null;
        }
        return arg;
    }

    private String toMediaType(Imports imports, String mediaType) {
        String mtConstant = MEDIA_TYPES.get(mediaType);
        if (mtConstant == null) {
            return "\"" + mediaType + "\"";
        }

        imports.javax("javax.ws.rs.core.MediaType");

        return "MediaType." + mtConstant;
    }
}
