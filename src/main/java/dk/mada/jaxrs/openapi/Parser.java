package dk.mada.jaxrs.openapi;

import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.SecurityScheme;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.naming.Naming;
import io.swagger.parser.OpenAPIParser;
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


    /**
     * Constructs a new parser.
     *
     * @param naming the naming instance
     * @param parserRefs the parser references
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     */
    public Parser(boolean showInfo, Naming naming, ParserTypeRefs parserRefs, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
        this.showInfo = showInfo;
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

        var typeConverter = new TypeConverter(parserRefs, naming, parserOpts, generatorOpts);

        Info info = new InfoTransformer().transform(specification);
        List<SecurityScheme> securitySchemes = new SecurityTransformer().transform(specification);
        Operations operations = new ApiTransformer(parserOpts, typeConverter, securitySchemes).transform(specification);
        ParserTypes parserTypes = new ParserTypes(parserOpts, generatorOpts);
        new DtoTransformer(naming, parserTypes, typeConverter).transform(specification);

        if (showInfo) {
            logger.info("============== PARSING DONE =====");
            logger.info("{}", TypeNames.info());
            logger.info("{}", parserTypes.info());
            logger.info("{}", parserRefs.info());
            logger.info("{}", operations.info());
        }

        parserTypes.consolidateDtos();
        Resolver resolver = new Resolver(parserTypes);
        Operations derefOps = resolver.operations(operations);
        var dtos = resolver.getDtos();

        if (showInfo) {
            logger.info("============== RESOLVED =====");
            logger.info("{}", dtos.info());
            logger.info("{}", derefOps.info());
        }

        return new Model(info, derefOps, dtos, securitySchemes);
    }
}
