package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.ByteArray;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.ImmutableContainerArray;
import dk.mada.jaxrs.model.ImmutableContainerMap;
import dk.mada.jaxrs.model.ImmutableDto;
import dk.mada.jaxrs.model.ImmutableProperty;
import dk.mada.jaxrs.model.Primitive;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.Type;
import dk.mada.jaxrs.model.TypeBigDecimal;
import dk.mada.jaxrs.model.TypeObject;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
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
	private static final String REF_COMPONENTS_SCHEMAS = "#/components/schemas/";
	private static final Logger logger = LoggerFactory.getLogger(DtoTransformer.class);

	private final Dtos dtos;
	@SuppressWarnings("rawtypes")
	private final Map<String, Schema> allDefinitions;
	private final ParserOpts opts;

	public DtoTransformer(ParserOpts opts, OpenAPI specification) {
		this.opts = opts;
		
    	allDefinitions = _OpenapiGenerator.getSchemas(specification);
    	
    	dtos = new Dtos(allDefinitions.keySet());
	}

	public Dtos transform() {
    	Map<String, Dto> types = new HashMap<>();
    	
    	logger.info("See schemas: {}", allDefinitions.keySet());
    	
    	allDefinitions.forEach((schemaName, schema) -> {
    		String modelName = getModelName(schemaName, schema);

    		List<Property> props = readProperties(schema);
    		
    		List<String> enumValues = getEnumValues(schema);
    		
    		Dto dto = ImmutableDto.builder()
    			.name(modelName)
    			.properties(props)
    			.openapiName(schemaName)
    			.enumValues(enumValues)
    			.build();
    		
    		dtos.addDto(dto);
		});
    	logger.info("Types {}: {}", allDefinitions.size(), types);
    	
    	return dtos;
    }

	private List<String> getEnumValues(@SuppressWarnings("rawtypes") Schema schema) {
		List<?> schemaEnumValues = schema.getEnum();
		if (schemaEnumValues == null) {
			return null;
		}
		
		List<String> enumValues = null;
		if (schemaEnumValues != null) {
			enumValues = schemaEnumValues.stream()
				.map(Object::toString)
				.collect(toList());
		}
		return enumValues;
	}

    private List<Property> readProperties(Schema<?> schema) {
    	@SuppressWarnings("rawtypes")
		Map<String, Schema> schemaProps = schema.getProperties();
    	if (schemaProps == null || schemaProps.isEmpty()) {
    		return List.of();
    	}
    	
    	Set<String> requiredProperyNames = new HashSet<>();
    	if (schema.getRequired() != null) {
    		requiredProperyNames.addAll(schema.getRequired());
    	}
    	
    	List<Property> props = new ArrayList<>();
		for (var e : schemaProps.entrySet()) {
    		String name = e.getKey();
    		Schema<?> propSchema = e.getValue();
    		
    		Type type = getType(propSchema);
    		
    		String exampleStr = Objects.toString(propSchema.getExample(), null);
    		
			props.add(ImmutableProperty.builder()
    			.name(name)
    			.type(type)
    			.description(propSchema.getDescription())
    			.example(exampleStr)
    			.isRequired(requiredProperyNames.contains(name))
    			.build());
    	}

    	logger.info(" props: {}", props);
    	
    	return props;
    }
    
    private Type getType(Schema<?> schema) {
		String schemaType = schema.getType();
		String schemaFormat = schema.getFormat();

		logger.debug("type/format: {}/{}", schemaType, schemaFormat);
		logger.debug("ref {}", schema.get$ref());
		
		Type type = Primitive.find(schemaType, schemaFormat);
		if (type != null) {
			return type;
		}

		type = findSiblingType(schema.get$ref());
		if (type != null) {
			return type;
		}
		
		if (schema instanceof ArraySchema a) {
			Type innerType = getType(a.getItems());
			
			if (innerType instanceof ByteArray && opts.isUnwrapByteArrayList()) {
				return ByteArray.getArray();
			}
			
			return ImmutableContainerArray.builder()
				.innerType(innerType)
				.build();
		}

		if (schema instanceof BinarySchema || schema instanceof FileSchema) {
			return ByteArray.getArray();
		}
		
		if (schema instanceof MapSchema m) {
			Object additionalProperties = m.getAdditionalProperties();
			if (additionalProperties instanceof Schema<?> innerSchema) {
				Type innerType = getType(innerSchema);
				return ImmutableContainerMap.builder()
						.innerType(innerType)
						.build();
			}
		}
		
		if (schema instanceof NumberSchema ns) {
			return TypeBigDecimal.get();
		}
		
		if (schema instanceof ObjectSchema o) {
			return TypeObject.get();
		}

		throw new IllegalStateException("No type found for " + schema);
    }
    
    private Type findSiblingType(String ref) {
		if (ref != null && ref.startsWith(REF_COMPONENTS_SCHEMAS)) {
			String refName = ref.substring(REF_COMPONENTS_SCHEMAS.length());
			return dtos.findSibling(refName);
		}
		return null;
    }
    
    private String getModelName(String schemaName, Schema<?> schema) {
		String name = schema.getTitle();
    	if (name == null) {
    		name = schemaName;
    	}
   	
    	return _OpenapiGenerator.camelize(name);
    }
}
