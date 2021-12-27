package dk.mada.jaxrs.openapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.ImmutableOperation;
import dk.mada.jaxrs.model.Operation;
import dk.mada.jaxrs.model.Operations;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;

/**
 * Transforms OpenApi operations to local model objects.
 * 
 * DefaultGenerator:processOperation
 */
public class OpsTransformer {
	private static final Logger logger = LoggerFactory.getLogger(OpsTransformer.class);

	public Operations transform(OpenAPI specification) {
		List<Operation> ops = new ArrayList<>();
	    Paths paths = specification.getPaths();
	//    logger.info("paths: {}", paths);
	    for (Map.Entry<String, PathItem> pathsEntry : paths.entrySet()) {
	        String resourcePath = pathsEntry.getKey();
	        PathItem path = pathsEntry.getValue();
	        
	        io.swagger.v3.oas.models.Operation op = path.getGet();
	        if (op != null) {
	        	ops.add(ImmutableOperation.builder()
	        			.group("GroupFixme")
	        			.path(resourcePath)
	        			.build());
	        }
	        
	        logger.debug(" {}", resourcePath);
	    }
	    
	    return new Operations(ops);
	}

}
