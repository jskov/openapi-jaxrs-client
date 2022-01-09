package dk.mada.jaxrs.openapi;

import java.nio.file.Path;
import java.util.List;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Operations;
import dk.mada.jaxrs.model.types.Types;
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
	private final ParserOpts opts;
	private final GeneratorOpts generatorOpts;

	public Parser(ParserOpts opts, GeneratorOpts generatorOpts) {
		this.opts = opts;
		this.generatorOpts = generatorOpts;
	}
	
	public Model parse(Path input) {
	    final List<AuthorizationValue> authorizationValues = List.of();
	    ParseOptions parseOpts = new ParseOptions();
	    parseOpts.setResolve(true);
	    
	    String inputSpec = input.toAbsolutePath().toString();
	    
	    SwaggerParseResult result = new OpenAPIParser().readLocation(inputSpec, authorizationValues, parseOpts);
	    OpenAPI specification = result.getOpenAPI();

	    Types types = new Types(opts, generatorOpts);

	    Info info = new InfoTransformer().transform(specification);
	    Operations ops = new OpsTransformer().transform(specification);
	    new DtoTransformer(opts, generatorOpts, types).transform(specification);
	    
	    return new Model(info, ops, types);
	}
}
