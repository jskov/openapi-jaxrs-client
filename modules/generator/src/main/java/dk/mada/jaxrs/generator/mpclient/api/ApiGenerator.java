package dk.mada.jaxrs.generator.mpclient.api;

import dk.mada.jaxrs.generator.mpclient.CommonPathFinder;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts.AuthHeader;
import dk.mada.jaxrs.generator.mpclient.MediaTypes;
import dk.mada.jaxrs.generator.mpclient.StringRenderer;
import dk.mada.jaxrs.generator.mpclient.Templates;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApi;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApi.CtxOperationRef;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApiExt;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApiOp;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApiOpExt;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApiParam;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.CtxApiResponse;
import dk.mada.jaxrs.generator.mpclient.api.tmpl.ImmutableCtxApiParam;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxValidation;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.Jspecify;
import dk.mada.jaxrs.generator.mpclient.imports.MicroProfile;
import dk.mada.jaxrs.generator.mpclient.imports.RestEasy;
import dk.mada.jaxrs.generator.mpclient.validation.ValidationGenerator;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.api.Content;
import dk.mada.jaxrs.model.api.ContentSelector.ContentContext;
import dk.mada.jaxrs.model.api.ContentSelector.Location;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Parameter;
import dk.mada.jaxrs.model.api.Response;
import dk.mada.jaxrs.model.api.StatusCode;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeContainer;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeVoid;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * API generator.
 *
 * Processes the model's APIs and prepares API contexts for template rendering.
 */
public class ApiGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ApiGenerator.class);

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
    /** Validation generator. */
    private ValidationGenerator validationGenerator;

    /**
     * Constructs a new API generator.
     *
     * @param generatorOpts the generator options
     * @param templates     the templates instance
     * @param model         the data model
     */
    public ApiGenerator(GeneratorOpts generatorOpts, Templates templates, Model model) {
        this.naming = model.naming();
        this.opts = generatorOpts;
        this.templates = templates;
        this.model = model;

        validationGenerator = new ValidationGenerator(generatorOpts);
    }

    /**
     * Generates all API classes.
     *
     * @param apiDir the directory to generate API classes in
     */
    public void generateApiClasses(Path apiDir) {
        model.operations().getByGroup().entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(ops -> {
                    String group = ops.getKey();
                    String classname = makeClassName(group);

                    processApi(apiDir, ops, classname);
                });
    }

    private void processApi(Path apiDir, Entry<String, List<Operation>> ops, String classname) {
        CtxApi ctx = toCtx(classname, ops.getValue());
        templates.renderApiTemplate(apiDir, ctx);
    }

    private String makeClassName(String groupInput) {
        String defaultApiName = opts.getDefaultApiName().orElse(groupInput);

        String group = groupInput;
        if ("Default".equals(groupInput)) {
            group = defaultApiName;
        }
        String input = group.endsWith("Api") ? group : group + "Api";
        return naming.convertApiName(input);
    }

    private CtxApi toCtx(String classname, List<Operation> operations) {
        var imports = Imports.newApi(opts);

        List<String> paths = operations.stream().map(Operation::path).toList();
        String commonPath = commonPathFinder.findCommonPath(paths);

        int trimPathLength = commonPath.length();

        List<CtxOperationRef> ops = makeOperations(operations, imports, trimPathLength);

        imports.trimContainerImplementations();

        Optional<String> clientKey = opts.getMpClientConfigKey();
        if (clientKey.isPresent()) {
            imports.add(MicroProfile.REGISTER_REST_CLIENT);
        }

        List<String> mpProviders = opts.getMpProviders().stream().sorted().toList();
        if (!mpProviders.isEmpty()) {
            imports.add(MicroProfile.REGISTER_PROVIDER);
        }

        CtxApiExt apiExt = new CtxApiExt(clientKey, mpProviders, opts.isJspecify(), opts.getApiAdditionalAnnotations());

        Info info = model.info();
        return CtxApi.builder()
                .appDescription(info.description())
                .appName(info.title())
                .version(info.version())
                .infoEmail(info.contact().email())
                .generatedAnnotationClass(opts.getGeneratorAnnotationClass())
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

        String nickname = op.operationId().orElse(op.syntheticOpId());

        // Gets type for OK if present, or else default, or else void
        Reference returnTypeRef = getTypeForStatus(op, StatusCode.HTTP_OK)
                .or(() -> getTypeForStatus(op, StatusCode.HTTP_CREATED))
                .or(() -> getTypeForStatus(op, StatusCode.HTTP_DEFAULT))
                .orElse(TypeVoid.getRef());

        // If OK is declared as Void, replace with default type (if available)
        Content okContent = getContentForStatus(op, StatusCode.HTTP_OK).orElse(null);
        Content defaultContent =
                getContentForStatus(op, StatusCode.HTTP_DEFAULT).orElse(null);
        if (okContent != null && okContent.reference().isVoid() && defaultContent != null) {
            returnTypeRef = defaultContent.reference();
        }

        // Gets matching media types, check for input-stream replacement
        Set<String> mediaTypes = getMediaTypeForStatus(op, StatusCode.HTTP_OK)
                .or(() -> getMediaTypeForStatus(op, StatusCode.HTTP_CREATED))
                .or(() -> getMediaTypeForStatus(op, StatusCode.HTTP_DEFAULT))
                .orElse(Set.of());
        boolean replaceResponseWithInputStream =
                opts.getResponseInputStreamMediaTypes().stream().anyMatch(mediaTypes::contains);
        if (replaceResponseWithInputStream) {
            returnTypeRef = TypeReference.of(TypeByteArray.getStream(), returnTypeRef.validation());
            imports.add(returnTypeRef);
        }

        String path = op.path().substring(trimPathLength);
        if (path.isEmpty()) {
            path = null;
        }

        Optional<String> producesMediaType = makeProduces(imports, op, returnTypeRef);

        List<CtxApiParam> allParams = getParams(imports, op);
        List<CtxApiResponse> responses =
                getResponses(imports, op, producesMediaType.stream().toList());

        boolean onlySimpleResponse = addResponseImports(imports, op);

        boolean renderJavadocReturn = !returnTypeRef.isVoid();
        boolean renderJavadocMacroSpacer = renderJavadocReturn || !allParams.isEmpty();

        Optional<String> summary = op.summary();

        Optional<String> opSummaryString = StringRenderer.encodeForString(summary);
        if (summary.isPresent()) {
            imports.add(MicroProfile.OPERATION);
        }

        CtxApiOpExt ext = CtxApiOpExt.builder()
                .consumes(makeConsumes(imports, op))
                .produces(producesMediaType)
                .renderJavadocMacroSpacer(renderJavadocMacroSpacer)
                .renderJavadocReturn(renderJavadocReturn)
                .responseSchema(onlySimpleResponse)
                .hasResponses(!responses.isEmpty())
                .summaryString(opSummaryString)
                .build();

        Optional<String> description = op.description();

        return new CtxOperationRef(CtxApiOp.builder()
                .nickname(nickname)
                .returnType(returnTypeRef.typeName().name())
                .path(Optional.ofNullable(path))
                .httpMethod(op.httpMethod().name())
                .allParams(allParams)
                .responses(responses)
                .summary(summary.flatMap(StringRenderer::makeValidOperationJavadocSummary))
                .notes(description)
                .madaOp(ext)
                .build());
    }

    private Optional<Reference> getTypeForStatus(Operation op, StatusCode statusCode) {
        return getContentForStatus(op, statusCode).map(Content::reference);
    }

    private Optional<Set<String>> getMediaTypeForStatus(Operation op, StatusCode statusCode) {
        return getContentForStatus(op, statusCode).map(Content::mediaTypes);
    }

    private Optional<Content> getContentForStatus(Operation op, StatusCode statusCode) {
        return op.responses().stream()
                .filter(r -> r.code() == statusCode)
                .map(Response::content)
                .findFirst();
    }

    private boolean addResponseImports(Imports imports, Operation op) {
        if (op.responses().isEmpty()) {
            return false;
        }

        boolean onlySimpleResponse = isOnlySimpleResponse(op.responses());
        if (onlySimpleResponse) {
            imports.add(MicroProfile.API_RESPONSE_SCHEMA);
        } else {
            imports.add(MicroProfile.API_RESPONSE, MicroProfile.API_RESPONSES);

            if (!op.isVoid()) {
                imports.add(MicroProfile.CONTENT, MicroProfile.SCHEMA);
            }
        }
        return onlySimpleResponse;
    }

    /**
     * Determine if all the response types can be rendered via the simple @APIResponseSchema annotation.
     *
     * Probably needs to be more clever - must consider that description matches code(). But this will do for now.
     *
     * @param responses the responses
     */
    private boolean isOnlySimpleResponse(List<Response> responses) {
        if (responses.size() != 1) {
            return false;
        }

        Response r = responses.get(0);
        boolean isContainer = r.content().reference().isContainer();
        boolean isSimpleResponse = !isContainer && r.code() == StatusCode.HTTP_OK && !r.isVoid();
        logger.debug(" simple: {}", isSimpleResponse);
        return isSimpleResponse;
    }

    private void addOperationImports(Imports imports, Operation op) {
        op.responses().stream().map(r -> r.content().reference()).forEach(imports::add);
    }

    /**
     * Note from https://docs.oracle.com/cd/E19776-01/820-4867/ghrst/index.html If @DefaultValue is not used in conjunction
     * with @QueryParam, and the query parameter is not present in the request, then value will be an empty collection for
     * List, Set, or SortedSet; null for other object types; and the Java-defined default for primitive types.
     *
     * So the primitive types can be used instead of wrapper types.
     *
     * @param imports the imports for the API
     * @param op      the operation to extract parameters from
     */
    private List<CtxApiParam> getParams(Imports imports, Operation op) {
        List<CtxApiParam> params = new ArrayList<>();

        AuthHeader authHeaderPref = opts.getAuthHeaderSelection();
        boolean addAuthHeader =
                authHeaderPref == AuthHeader.ON || (authHeaderPref == AuthHeader.API && op.addAuthorizationHeader());

        if (addAuthHeader) {
            Primitive type = Primitive.STRING;
            Optional<CtxValidation> validation =
                    validationGenerator.makeValidation(imports, type, Validation.validationRequired());

            params.add(CtxApiParam.builder()
                    .baseName("Authorization")
                    .paramName("auth")
                    .dataType(type.typeName().name())
                    .isContainer(false)
                    .isBodyParam(false)
                    .isFormParam(false)
                    .isHeaderParam(true)
                    .isPathParam(false)
                    .isQueryParam(false)
                    .validation(validation)
                    .isMultipartForm(false)
                    .isNullable(false)
                    .build());
        }

        for (Parameter p : op.parameters()) {
            Reference ref = p.reference();
            imports.add(ref);

            String name = p.name();
            String paramName = naming.convertParameterName(name);

            Type type = ref.refType();
            String dataType = paramDataType(type);

            Validation validation = ref.validation();
            logger.debug("See param {} : {} : {}", paramName, type, validation);

            Optional<CtxValidation> valCtx;
            if (type.isPrimitive() && !opts.isUseApiWrappedPrimitives()) {
                valCtx = Optional.empty();
            } else {
                valCtx = validationGenerator.makeValidation(imports, type, validation);
            }

            boolean isNullableRef =
                    type.isPrimitive(Primitive.STRING) || (!type.isPrimitive() || opts.isUseApiWrappedPrimitives());
            boolean isBeanValidationNotNull = !validation.nullable() && validation.required();
            boolean validationAllowsNull = !isBeanValidationNotNull;
            boolean isNullable = validationAllowsNull && isNullableRef && (p.isQueryParam() || p.isHeaderParam());
            if (isNullable && opts.isJspecify()) {
                imports.add(Jspecify.NULLABLE);
            }

            ImmutableCtxApiParam param = CtxApiParam.builder()
                    .baseName(name)
                    .paramName(paramName)
                    .dataType(dataType)
                    .validation(valCtx)
                    .description(p.description())
                    .isContainer(false)
                    .isBodyParam(false)
                    .isFormParam(p.isFormParam())
                    .isHeaderParam(p.isHeaderParam())
                    .isQueryParam(p.isQueryParam())
                    .isPathParam(p.isPathParam())
                    .isMultipartForm(false)
                    .isNullable(isNullable)
                    .build();

            logger.debug("PARAM {} : {}", name, p.isFormParam());
            params.add(param);
        }

        op.requestBody().ifPresent(body -> {
            Reference ref = body.content().reference();
            imports.add(ref);

            String preferredDtoParamName =
                    naming.convertEntityName(ref.typeName().name());

            // Guard against (simple) conflict with other parameters
            boolean dtoParamNameNotUnique =
                    params.stream().anyMatch(p -> p.paramName().equals(preferredDtoParamName));
            String dtoParamName = dtoParamNameNotUnique ? preferredDtoParamName + "Entity" : preferredDtoParamName;

            Type type = ref.refType();
            String dataType = paramDataType(type);

            Optional<CtxValidation> valCtx;
            if (type.isPrimitive() && !opts.isUseApiWrappedPrimitives()) {
                valCtx = Optional.empty();
            } else {
                valCtx = validationGenerator.makeValidation(imports, type, ref.validation());
            }

            boolean isMultipartForm = body.isMultipartForm();
            if (isMultipartForm) {
                imports.add(RestEasy.MULTIPART_FORM);
            }
            CtxApiParam bodyParam = CtxApiParam.builder()
                    .baseName("unused")
                    .paramName(dtoParamName)
                    .dataType(dataType)
                    .validation(valCtx)
                    .description(body.description())
                    .isContainer(false)
                    .isBodyParam(true)
                    .isFormParam(false)
                    .isHeaderParam(false)
                    .isPathParam(false)
                    .isQueryParam(false)
                    .isMultipartForm(isMultipartForm)
                    .isNullable(false)
                    .build();

            // Only include body param if it is not void. It may be void
            // when there are form parameters.
            if (!ref.isVoid()) {
                params.add(bodyParam);
            }
            logger.debug("BODY {}", bodyParam);
        });

        logger.debug("Params: {}", params);

        return params;
    }

    private String paramDataType(Type type) {
        return opts.isUseApiWrappedPrimitives()
                ? type.wrapperTypeName().name()
                : type.typeName().name();
    }

    private List<CtxApiResponse> getResponses(Imports imports, Operation op, List<String> producesMediaTypes) {
        return op.responses().stream()
                .sorted((a, b) -> a.code().compareTo(b.code()))
                .map(r -> makeResponse(imports, op, r, producesMediaTypes))
                .toList();
    }

    private CtxApiResponse makeResponse(Imports imports, Operation op, Response r, List<String> opResponseMediaTypes) {
        String baseType;
        String containerType;
        Reference typeRef = r.content().reference();
        Type type = typeRef.refType();
        boolean isUnique = false;

        if (type instanceof TypeContainer tc) {
            baseType = tc.innerType().wrapperTypeName().name();
            containerType = "SchemaType.ARRAY";
            imports.add(MicroProfile.SCHEMA_TYPE);

            isUnique = type instanceof TypeSet;
        } else if (type.isVoid()) {
            baseType = null;
            containerType = null;
        } else {
            baseType = type.wrapperTypeName().name();
            containerType = null;
        }

        Set<String> responseMediaTypes = r.content().mediaTypes();

        // Only define an explicit media-type for the response, iff it is
        // not same media-type already declared for the operation
        ContentContext context = new ContentContext(op.path(), r.code(), true, Location.RESPONSE, false);
        Optional<String> mediaType = model.contentSelector()
                .selectPreferredMediaType(responseMediaTypes, context)
                .map(mt -> MediaTypes.toMediaType(imports, mt))
                .filter(mt -> !opResponseMediaTypes.contains(mt));

        String description = r.description().orElse("");

        return new CtxApiResponse(
                r.code().asOpenApiStatus(),
                StringRenderer.encodeForString(description),
                baseType,
                containerType,
                mediaType,
                isUnique);
    }

    // TODO: these should be combined smarter - base should take Content as argument instead, avoid use of streams

    private Optional<String> makeConsumes(Imports imports, Operation op) {
        List<String> mediaTypes = op.requestBody()
                .map(rb ->
                        rb.content().mediaTypes().stream().sorted().distinct().toList())
                .orElse(List.of());

        ContentContext context = new ContentContext(op.path(), StatusCode.HTTP_DEFAULT, false, Location.REQUEST, false);
        return model.contentSelector()
                .selectPreferredMediaType(mediaTypes, context)
                .map(mt -> MediaTypes.toMediaType(imports, mt));
    }

    /**
     * Makes list of media types for @Produces
     *
     * Note that the client's @Produces determines what it puts in the Accept-header.
     *
     * So while the operation's correct @Produces media-types will be the sum of the media-types from all return codes, it
     * needs to be set to the desired media-type of the primary return type.
     *
     * @param imports       the imports for the API
     * @param op            the operation
     * @param returnTypeRef the return type
     * @return the optional media-type of the return type
     */
    private Optional<String> makeProduces(Imports imports, Operation op, Reference returnTypeRef) {
        Optional<Response> mainResponse = getOperationMainResponse(op);

        List<String> potentialMediaTypes =
                mainResponse.map(r -> List.copyOf(r.content().mediaTypes())).orElse(List.of());

        // If there are no media types declared, and the return type is void
        // a produces media-type can be specified.
        if (potentialMediaTypes.isEmpty() && returnTypeRef.isVoid()) {
            return opts.getVoidProducesMediaType().map(mt -> MediaTypes.toMediaType(imports, mt));
        }

        StatusCode code = mainResponse.map(Response::code).orElse(StatusCode.HTTP_DEFAULT);

        ContentContext context = new ContentContext(op.path(), code, true, Location.RESPONSE, false);
        return model.contentSelector()
                .selectPreferredMediaType(potentialMediaTypes, context)
                .map(mt -> MediaTypes.toMediaType(imports, mt));
    }

    /**
     * Returns the main response of the operation.
     *
     * Not sure if that is always the result of 200. But assume so for now.
     *
     * @param op the operation
     * @return the main response of the operation
     */
    private Optional<Response> getOperationMainResponse(Operation op) {
        return op.responses().stream()
                .sorted((a, b) -> Integer.compare(a.code().code(), b.code().code()))
                .findFirst();
    }
}
