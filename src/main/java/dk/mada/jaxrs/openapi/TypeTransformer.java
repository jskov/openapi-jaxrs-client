package dk.mada.jaxrs.openapi;

import java.util.HashMap;
import java.util.Map;

import org.openapitools.codegen.utils.ModelUtils;
import org.openapitools.codegen.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.ImmutableType;
import dk.mada.jaxrs.model.Type;
import dk.mada.jaxrs.model.Types;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Transforms OpenApi types to local model objects.
 * 
 * 	DefaultGenerator:processModels
 *	DefaultCodegen:fromModel
 *	DefaultCodegen:fromProperty
 *
 */
public class TypeTransformer {
	private static final Logger logger = LoggerFactory.getLogger(TypeTransformer.class);

	public Types transform(OpenAPI specification) {
		
		Map<String, Type> types = extractTypes(specification);

		return new Types(types.values());
	}

    public Map<String, Type> extractTypes(OpenAPI openApi) {
    	Map<String, Type> types = new HashMap<>();
    	
    	@SuppressWarnings("rawtypes")
		Map<String, Schema> allDefinitions = ModelUtils.getSchemas(openApi);
    	allDefinitions.forEach((schemaName, schema) -> {
    		String modelName = getModelName(schemaName, schema);
    		
    		Type type = ImmutableType.builder()
    			.name(modelName)
    			.build();
    		types.put(schemaName, type);
    		});
    	logger.info("Types {}: {}", allDefinitions.size(), types);
    	
    	return types;
    }

    private String getModelName(String schemaName, Schema<?> schema) {
		String name = schema.getTitle();
    	if (name == null) {
    		name = schemaName;
    	}
   	
    	return StringUtils.camelize(name);
    }

}
