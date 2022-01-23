package dk.mada.jaxrs.generator.api;

import static java.util.stream.Collectors.toSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Imports;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.api.tmpl.CtxApi;
import dk.mada.jaxrs.generator.api.tmpl.CtxApi.CtxOperationRef;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiOp;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiOpExt;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiParam;
import dk.mada.jaxrs.generator.api.tmpl.CtxApiParamExt;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Parameter;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeVoid;
import dk.mada.jaxrs.model.types.Types;
import dk.mada.jaxrs.naming.Naming;

public class ApiGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ApiGenerator.class);

    private static final Map<String, String> MEDIA_TYPES = Map.of(
            "application/json", "APPLICATION_JSON",
            "text/plain", "TEXT_PLAIN"
            );

    private final Naming naming;
    private final Types types;
    private final GeneratorOpts opts;
    private final Templates templates;
    private final Model model;


    public ApiGenerator(Naming naming, GeneratorOpts generatorOpts, Templates templates, Model model) {
        this.naming = naming;
        this.opts = generatorOpts;
        this.templates = templates;
        this.model = model;

        this.types = model.types();
    }

    public void generateApiClasses(Path apiDir) throws IOException {
        Files.createDirectories(apiDir);

        model.operations().getByGroup().entrySet().stream()
        .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
        .forEach(ops -> {
            String group = ops.getKey();
            String classname = makeClassName(group);

            Path apiFile = apiDir.resolve(classname + ".java");
            logger.info(" generate API {}", classname);

            CtxApi ctx = toCtx(classname, ops.getValue());

            templates.writeApi(ctx, apiFile);
        });
    }

    private String makeClassName(String group) {
        String input = group.endsWith("Api") ? group : group + "Api";
        return naming.convertTypeName(input);
    }

    private CtxApi toCtx(String classname, List<Operation> operations) {
        var imports = Imports.newApi(types, opts);

        String commonPath = model.operations().findCommonPath(operations);
        int trimPathLength = commonPath.length();

        List<CtxOperationRef> ops = makeOperations(operations, imports, trimPathLength);

        imports.trimContainerImplementations();

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
                .build();
    }

    private List<CtxOperationRef> makeOperations(List<Operation> operations, Imports imports, int trimPathLength) {
        return operations.stream()
                .sorted((a, b) -> a.path().compareTo(b.path()))
                .map(op -> toCtxApiOperation(imports, trimPathLength, op))
                .toList();
    }

    private CtxOperationRef toCtxApiOperation(Imports imports, int trimPathLength, Operation op) {
        addOperationImports(imports, op);

        String nickname = op.operationId();
        if (nickname == null) {
            nickname = op.codegenOpId();
        }

        Type type = op.responses().stream()
                .filter(r -> r.code() == 200)
                .map(r -> r.content().type())
                .findFirst()
                .orElse(TypeVoid.get());

        String path = op.path().substring(trimPathLength);
        if (path.isEmpty()) {
            path = null;
        }

        List<CtxApiParam> allParams = getParams(imports, op);

        CtxApiOpExt ext = CtxApiOpExt.builder()
                .produces(makeProduces(imports, op))
                .build();

        return new CtxOperationRef(CtxApiOp.builder()
                .nickname(nickname)
                .returnType(type.typeName().name())
                .path(path)
                .httpMethod(op.httpMethod().name())
                .allParams(allParams)
                .madaOp(ext)
                .build());
    }

    private void addOperationImports(Imports imports, Operation op) {
        op.responses().stream()
        .map(r -> r.content().type())
        .forEach(imports::add);
    }

    /**
     * Note from https://docs.oracle.com/cd/E19776-01/820-4867/ghrst/index.html
     *  If @DefaultValue is not used in conjunction with @QueryParam, and the query parameter
     *  is not present in the request, then value will be an empty collection for List, Set,
     *  or SortedSet; null for other object types; and the Java-defined default for primitive types.
     *  
     * So the primitive types can be used instead of wrapper types.
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
                    .madaParam(madaParamEmpty)
                    .build());
        }

        for (Parameter p : op.parameters()) {
            imports.add(p.type());

            String paramName = naming.convertParameterName(p.name());

            params.add(CtxApiParam.builder()
                    .baseName(p.name())
                    .paramName(paramName)
                    .dataType(p.type().typeName().name())
                    .required(p.isRequired())
                    .isBodyParam(false)
                    .isHeaderParam(p.isHeaderParam())
                    .isQueryParam(p.isQueryParam())
                    .isPathParam(p.isPathParam())
                    .madaParam(madaParamEmpty)
                    .build());
        }

        op.requestBody().ifPresent(body -> {
            imports.add(body.content().type());

            params.add(CtxApiParam.builder()
                    .baseName("unused")
                    .paramName("dto")
                    .dataType(body.content().type().typeName().name())
                    .required(body.isRequired())
                    .isBodyParam(true)
                    .isHeaderParam(false)
                    .isPathParam(false)
                    .isQueryParam(false)
                    .madaParam(madaParamEmpty)
                    .build());
        });

        logger.info("Params: {}", params);

        return params;
    }

    private String makeProduces(Imports imports, Operation op) {
        Set<String> producesMediaTypes = op.responses().stream()
                .flatMap(r -> r.content().mediaTypes().stream())
                .map(mt -> toMediaType(imports, mt))
                .collect(toSet());

        String produces = String.join(", ", producesMediaTypes);
        if (producesMediaTypes.size() > 1) {
            produces = "{" + produces + "}";
        }
        if (producesMediaTypes.isEmpty()) {
            produces = null;
        }
        return produces;
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
