package dk.mada.jaxrs.openapi;

import java.nio.file.Path;
import java.util.List;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.SecurityScheme;
import dk.mada.jaxrs.model.api.Operations;
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
    public Parser(Naming naming, ParserTypeRefs parserRefs, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
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

//        System.out.println("============== PARSING DONE =====");
//
//        System.out.println(TypeNames.info());
//        System.out.println(parserTypes.info());
        System.out.println(parserRefs.info());
        System.out.println(operations.info());

        // FIXME: primitive param args INT etc must also be ParserTypeRefs to capture validation


        parserTypes.consolidateDtos();
        Resolver resolver = new Resolver(parserTypes);
        Operations derefOps = resolver.operations(operations);
        var dtos = resolver.getDtos();

//        System.out.println(dtos.info());
//        System.out.println(derefOps.info());

        return new Model(info, derefOps, dtos, securitySchemes);
    }
}
