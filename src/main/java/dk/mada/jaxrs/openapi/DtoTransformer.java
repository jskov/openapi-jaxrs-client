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

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.ImmutableDto;
import dk.mada.jaxrs.model.ImmutableProperty;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.Types;
import dk.mada.jaxrs.naming.Naming;
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

	private final Naming naming;
	private final Types types;
	private final TypeConverter typeConverter;

	public DtoTransformer(Naming naming, Types types, TypeConverter typeConverter) {
		this.naming = naming;
		this.types = types;
		this.typeConverter = typeConverter;
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

    		Type dtoType = typeConverter.toType(schema);
    		
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
    		
    		Type type = typeConverter.toType(propSchema);
    		
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

    private String getModelName(String schemaName, Schema<?> schema) {
		String name = schema.getTitle();
    	if (name == null) {
    		name = schemaName;
    	}
   	
    	return naming.convertTypeName(name);
    }
}
