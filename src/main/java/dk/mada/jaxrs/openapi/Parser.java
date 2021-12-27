package dk.mada.jaxrs.openapi;

import java.nio.file.Path;
import java.util.List;

import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Operations;
import dk.mada.jaxrs.model.Types;
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
	public Model parse(Path input) {
	    final List<AuthorizationValue> authorizationValues = List.of();
	    ParseOptions parseOpts = new ParseOptions();
	    parseOpts.setResolve(true);
	    
	    String inputSpec = input.toAbsolutePath().toString();
	    
	    SwaggerParseResult result = new OpenAPIParser().readLocation(inputSpec, authorizationValues, parseOpts);
	    OpenAPI specification = result.getOpenAPI();

	    Info info = new InfoTransformer().transform(specification);
	    Operations ops = new OpsTransformer().transform(specification);
	    Types types = new TypeTransformer().transform(specification);
	    
	    return new Model(info, ops, types);
	}
}
