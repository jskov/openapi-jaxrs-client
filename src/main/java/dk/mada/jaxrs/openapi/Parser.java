package dk.mada.jaxrs.openapi;

import java.nio.file.Path;
import java.util.List;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.types.Types;
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
	private final Naming naming;
	private final ParserOpts parserOpts;
	private final GeneratorOpts generatorOpts;

	public Parser(Naming naming, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
		this.naming = naming;
		this.parserOpts = parserOpts;
		this.generatorOpts = generatorOpts;
	}
	
	public Model parse(Path input) {
	    final List<AuthorizationValue> authorizationValues = List.of();
	    var parseOpts = new ParseOptions();
	    parseOpts.setResolve(true);
	    
	    String inputSpec = input.toAbsolutePath().toString();
	    
	    SwaggerParseResult result = new OpenAPIParser().readLocation(inputSpec, authorizationValues, parseOpts);
	    OpenAPI specification = result.getOpenAPI();

	    var types = new Types(parserOpts, generatorOpts);
		var typeConverter = new TypeConverter(types, parserOpts, generatorOpts);
		
	    Info info = new InfoTransformer().transform(specification);
	    Operations operations = new ApiTransformer(typeConverter).transform(specification);
	    new DtoTransformer(naming, types, typeConverter).transform(specification);
	    
	    return new Model(info, operations, types);
	}
}
