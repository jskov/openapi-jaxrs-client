package dk.mada.jaxrs.openapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.openapitools.codegen.utils.ModelUtils;
import org.openapitools.codegen.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.ImmutableDto;
import dk.mada.jaxrs.model.ImmutableProperty;
import dk.mada.jaxrs.model.Primitive;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.Type;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Transforms OpenApi dtos (models) to local model objects.
 * 
 * 	DefaultGenerator:processModels
 *	DefaultCodegen:fromModel
 *	DefaultCodegen:fromProperty
 *
 */
public class DtoTransformer {
	private static final Logger logger = LoggerFactory.getLogger(DtoTransformer.class);
	private static final SortedSet<String> DTO_TEMPLATE_IMPORTS = new TreeSet<>(Set.of(
			"java.util.Objects",
			"io.swagger.annotations.ApiModelProperty"
			));

	public Dtos transform(OpenAPI specification) {
		
		Map<String, Dto> types = extractDtos(specification);

		return new Dtos(types.values());
	}

    public Map<String, Dto> extractDtos(OpenAPI openApi) {
    	Map<String, Dto> types = new HashMap<>();
    	
    	@SuppressWarnings("rawtypes")
		Map<String, Schema> allDefinitions = ModelUtils.getSchemas(openApi);
    	allDefinitions.forEach((schemaName, schema) -> {
    		String modelName = getModelName(schemaName, schema);
    		
    		List<Property> props = readProperties(schema);
    		
    		Dto dto = ImmutableDto.builder()
    			.name(modelName)
    			.imports(new TreeSet<>(DTO_TEMPLATE_IMPORTS))
    			.properties(props)
    			.build();
    		types.put(schemaName, dto);
    		});
    	logger.info("Types {}: {}", allDefinitions.size(), types);
    	
    	return types;
    }

    private List<Property> readProperties(Schema<?> schema) {
    	List<Property> props = new ArrayList<>();
    	
    	for (var e : schema.getProperties().entrySet()) {
    		String name = e.getKey();
    		Schema<?> propSchema = e.getValue();
    		
    		String schemaType = propSchema.getType();
    		String schemaFormat = propSchema.getFormat();

    		Type type = Primitive.find(schemaType, schemaFormat);
    		
    		props.add(ImmutableProperty.builder()
    			.name(name)
    			.nameCamelized(StringUtils.camelize(name))
    			.typeStr(schemaType + ":" + schemaFormat)
    			.type(type)
    			.description(propSchema.getDescription())
    			.build());
    	}

    	logger.info(" props: {}", props);
    	
    	return props;
    }
    
    
    private String getModelName(String schemaName, Schema<?> schema) {
		String name = schema.getTitle();
    	if (name == null) {
    		name = schemaName;
    	}
   	
    	return StringUtils.camelize(name);
    }
}
