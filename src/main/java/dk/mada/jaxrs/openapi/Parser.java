package dk.mada.jaxrs.openapi;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.SecurityScheme;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.types.TypeInterface;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.naming.Naming;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.AuthorizationValue;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

/**
 * Parses OpenAPI specification and transforms to local
 * model classes.
 */
public class Parser {
    private static final Logger logger = LoggerFactory.getLogger(Parser.class);

    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** Flag for showing parser info. */
    private boolean showInfo;
    /** Naming. */
    private final Naming naming;
    /** Parser options. */
    private final ParserOpts parserOpts;
    /** Generator options. */
    private final GeneratorOpts generatorOpts;
    /** Parser references. */
    private final ParserTypeRefs parserRefs;
    /** Type names. */
    private final TypeNames typeNames;

    /**
     * Constructs a new parser.
     *
     * @param showInfo flag to enable parser info output
     * @param typeNames the type names instance
     * @param naming the naming instance
     * @param parserRefs the parser references
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     */
    public Parser(boolean showInfo,
            TypeNames typeNames, Naming naming, ParserTypeRefs parserRefs,
            ParserOpts parserOpts, GeneratorOpts generatorOpts) {
        this.showInfo = showInfo;
        this.typeNames = typeNames;
        this.naming = naming;
        this.parserRefs = parserRefs;
        this.parserOpts = parserOpts;
        this.generatorOpts = generatorOpts;
    }

    /**
     * Parse the specified OpenApi specification.
     *
     * @param spec the specification file to parse
     * @return the local model representation of the specification
     */
    public Model parse(Path spec) {
        final List<AuthorizationValue> authorizationValues = List.of();
        var swaggerParseOpts = new ParseOptions();
        swaggerParseOpts.setResolve(true);

        String inputSpec = spec.toAbsolutePath().toString();

        SwaggerParseResult result = new OpenAPIParser().readLocation(inputSpec, authorizationValues, swaggerParseOpts);
        OpenAPI specification = result.getOpenAPI();
        if (specification == null) {
            throw new IllegalStateException("No output from parsing document " + spec);
        }

        ParserTypes parserTypes = new ParserTypes(typeNames, parserOpts, generatorOpts);
        var typeConverter = new TypeConverter(typeNames, parserTypes, parserRefs, naming, parserOpts, generatorOpts);

        Info info = new InfoTransformer().transform(specification);
        List<SecurityScheme> securitySchemes = new SecurityTransformer().transform(specification);
        Operations operations = new ApiTransformer(parserOpts, typeConverter, securitySchemes).transform(specification);
        new DtoTransformer(typeConverter).transform(specification);

        if (showInfo) {
            String infoParsing = new StringBuilder("============== PARSING DONE =====").append(NL)
                    .append(typeNames.info()).append(NL)
                    .append(parserTypes.info()).append(NL)
                    .append(parserRefs.info()).append(NL)
                    .append(operations.info())
                    .toString();
             logger.info("{}", infoParsing);
        }

        parserTypes.consolidateDtos();
        List<String> schemaNamesDeclarationOrder = getSchemaOrder(specification);
        ConflictRenamer cr = new ConflictRenamer(typeNames, naming, schemaNamesDeclarationOrder);

        Resolver resolver = new Resolver(typeNames, parserTypes, cr);
        Operations derefOps = resolver.operations(operations);


        //parserTypes.renameConflictingDtos(cr);
        
        // This converts the parser references to model type references
        List<Dto> activeDtos = resolver.getDtos();

//        parserTypes.getActiveDtos();
        // This wants to rename the types
//        Dtos dtos = new ConflictRenamer(typeNames, naming, schemaNamesDeclarationOrder)
//                .renameDtos(activeDtos);
        Dtos dtos = new Dtos(activeDtos);
        

        if (showInfo) {
            String infoResolved = new StringBuilder("============== RESOLVED =====").append(NL)
                       .append(dtos.info()).append(NL)
                       .append(derefOps.info())
                       .toString();
            logger.info("{}", infoResolved);
        }

        Set<TypeInterface> interfaces = parserTypes.getInterfaces();
        return new Model(info, derefOps, dtos, interfaces, securitySchemes);
    }

    /**
     * Gets openapiIds for schemas in their declaration order (in the
     * OpenApi document).
     *
     * @param specification the OpenApi spec
     * @return the schema names in declaration order
     */
    private List<String> getSchemaOrder(OpenAPI specification) {
        Components components = specification.getComponents();
        if (components == null || components.getSchemas() == null) {
            return List.of();
        }
        return new ArrayList<>(components.getSchemas().keySet());
    }
}
