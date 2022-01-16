package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.ImmutableDto;
import dk.mada.jaxrs.model.ImmutableProperty;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.Types;
import dk.mada.jaxrs.naming.Naming;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

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

	private final Naming naming;
	private final ParserOpts opts;
	private final GeneratorOpts generatorOpts;
	private final Types types;

	public DtoTransformer(Naming naming, ParserOpts opts, GeneratorOpts generatorOpts, Types types) {
		this.naming = naming;
		this.opts = opts;
		this.generatorOpts = generatorOpts;
		this.types = types;
	}

	public void transform(OpenAPI specification) {
		readSpec(specification);
		
		types.consolidateDtos();
	}

	@SuppressWarnings("unused")
	private void printTypes() {
		types.getActiveDtos().stream()
			.sorted((a, b) -> a.name().compareTo(b.name()))
			.forEach(d -> logger.info(" {} {}", d.name(), d.openapiId()));
	}
	
	private void readSpec(OpenAPI specification) {
		@SuppressWarnings("rawtypes")
		Map<String, Schema> allDefinitions = _OpenapiGenerator.getSchemas(specification);
    	logger.info("See schemas: {}", allDefinitions.keySet());
    	
    	allDefinitions.forEach((schemaName, schema) -> {
    		String modelName = getModelName(schemaName, schema);

    		Type dtoType = getType(schema);
    		
    		List<Property> props = readProperties(schema);
    		
    		List<String> enumValues = getEnumValues(schema);
    		
    		Dto dto = ImmutableDto.builder()
    			.name(modelName)
    			.dtoType(dtoType)
    			.properties(props)
    			.openapiId(TypeNames.of(schemaName))
    			.enumValues(enumValues)
    			.build();
    		
    		types.addDto(dto);
		});
    	
    	types.parsingCompleted();
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
    		
    		boolean isReadOnly = (propSchema.getReadOnly() != null) && propSchema.getReadOnly();
    		boolean isNullable = (propSchema.getNullable() != null) && propSchema.getNullable();

			props.add(ImmutableProperty.builder()
    			.name(name)
    			.type(type)
    			.description(propSchema.getDescription())
    			.example(exampleStr)
    			.isNullable(isNullable)
    			.isReadonly(isReadOnly)
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

		type = findDto(schema.get$ref());

		if (type != null) {
			return type;
		}
		
		if (schema instanceof ArraySchema a) {
			Type innerType = getType(a.getItems());

			Boolean isUnique = a.getUniqueItems();
			if (isUnique != null && isUnique.booleanValue()) {
				return TypeSet.of(innerType);
			}
			
			if (innerType instanceof TypeByteArray && opts.isUnwrapByteArrayList()) {
				return TypeByteArray.getArray();
			}
			
			return TypeArray.of(types, innerType);
		}

		if (schema instanceof BinarySchema || schema instanceof FileSchema) {
			return TypeByteArray.getArray();
		}
		
		if (schema instanceof MapSchema m) {
			Object additionalProperties = m.getAdditionalProperties();
			if (additionalProperties instanceof Schema<?> innerSchema) {
				Type innerType = getType(innerSchema);
				return TypeMap.of(innerType);
			}
		}
		
		if (schema instanceof NumberSchema ns) {
			return TypeBigDecimal.get();
		}
		
		if (schema instanceof DateTimeSchema) {
			return TypeDateTime.get(generatorOpts);
		}

		if (schema instanceof DateSchema) {
			logger.info(" {} : TypeDate", schema.getName());
			return TypeDate.get();
		}
		
		if (schema instanceof ObjectSchema o) {
			return TypeObject.get();
		}
		
		if (schema instanceof StringSchema s) {
			return Primitive.STRING;
		}

		throw new IllegalStateException("No type found for " + schema);
    }

    private Type findDto(String ref) {
		if (ref != null && ref.startsWith(REF_COMPONENTS_SCHEMAS)) {
			String openapiId = ref.substring(REF_COMPONENTS_SCHEMAS.length());
			return types.findDto(openapiId);
		}
		return null;
    }
    
    private String getModelName(String schemaName, Schema<?> schema) {
		String name = schema.getTitle();
    	if (name == null) {
    		name = schemaName;
    	}
   	
    	return naming.convertTypeName(name);
    }
}
