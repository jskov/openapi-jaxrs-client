package dk.mada.jaxrs.openapi;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.SecurityScheme;
import dk.mada.jaxrs.model.api.ContentSelector;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.types.TypeDateTime;
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
 * Parses OpenAPI specification and transforms to local model classes.
 */
public final class Parser {
    private static final Logger logger = LoggerFactory.getLogger(Parser.class);

    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** Flag for showing parser info. */
    private boolean showInfo;
    /** Naming. */
    private final Naming naming;
    /** Parser options. */
    private final ParserOpts parserOpts;
    /** Leaked generator options. */
    private final LeakedGeneratorOpts leakedGenOpts;
    /** Parser references. */
    private final ParserTypeRefs parserRefs;
    /** Type names. */
    private final TypeNames typeNames;
    /** Content selector. This should probably only be used in the generator (when model captures all the state). */
    private ContentSelector contentSelector;

    /**
     * Constructs a new parser.
     *
     * @param showInfo      flag to enable parser info output
     * @param naming        the naming instance
     * @param parserOpts    the parser options
     * @param leakedGenOpts the leaked generator options
     */
    public Parser(boolean showInfo, Naming naming, ParserOpts parserOpts, LeakedGeneratorOpts leakedGenOpts) {
        this.showInfo = showInfo;
        this.naming = naming;
        this.parserOpts = parserOpts;
        this.leakedGenOpts = leakedGenOpts;

        typeNames = new TypeNames();
        parserRefs = new ParserTypeRefs(typeNames);

        List<Pattern> preferredRequestMediaTypes = parserOpts.getPreferredRequestMediaTypes().stream()
                .map(Pattern::compile)
                .toList();
        List<Pattern> preferredResponseMediaTypes = parserOpts.getPreferredResponseMediaTypes().stream()
                .map(Pattern::compile)
                .toList();

        this.contentSelector = new ContentSelector(preferredRequestMediaTypes, preferredResponseMediaTypes);
    }

    /**
     * Generator options that have leaked into the parser. These should be eventually be removed when possible.
     *
     * @param dateTimeType the type used to represent OpenApi date-time
     * @param dtoPackage   the DTO package
     */
    public record LeakedGeneratorOpts(TypeDateTime dateTimeType, String dtoPackage) {
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

        ParserTypes parserTypes = new ParserTypes(typeNames, parserOpts, leakedGenOpts);
        var typeConverter = new TypeConverter(typeNames, parserTypes, parserRefs, naming, parserOpts, leakedGenOpts);

        Info info = new InfoTransformer().transform(specification);
        List<SecurityScheme> securitySchemes = new SecurityTransformer().transform(specification);
        Operations operations = new ApiTransformer(naming, parserOpts, typeConverter, contentSelector, securitySchemes)
                .transform(specification);
        new DtoTransformer(typeConverter).transform(specification);

        if (showInfo) {
            String infoParsing = "============== PARSING DONE =====" + NL
                    + typeNames.info() + NL
                    + parserTypes.info() + NL
                    + parserRefs.info() + NL
                    + operations.info();
            logger.info("{}", infoParsing);
        }

        parserTypes.consolidateContainerDtos();
        List<String> schemaNamesDeclarationOrder = getSchemaOrder(specification);
        ConflictRenamer cr = new ConflictRenamer(typeNames, naming, schemaNamesDeclarationOrder);

        Resolver resolver = new Resolver(parserOpts, typeNames, parserTypes, cr);

        // This converts the parser references to model type references
        Dtos dtos = new Dtos(resolver.getDtos());
        // Convert operations after DTOs to get finally resolved/mapped DTOs
        Operations derefOps = resolver.operations(operations);

        if (showInfo) {
            String infoResolved = "============== RESOLVED =====" + NL
                    + dtos.info() + NL
                    + derefOps.info();
            logger.info("{}", infoResolved);
        }

        Set<TypeInterface> interfaces = parserTypes.getInterfaces();
        return new Model(naming, info, derefOps, dtos, interfaces, securitySchemes, contentSelector);
    }

    /**
     * Gets openapiIds for schemas in their declaration order (in the OpenApi document).
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
