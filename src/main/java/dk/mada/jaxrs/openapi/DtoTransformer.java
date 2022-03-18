package dk.mada.jaxrs.openapi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.naming.Naming;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Transforms OpenApi dtos (models) to local model objects.
 *
 *  DefaultGenerator:processModels
 *  DefaultCodegen:fromModel
 *  DefaultCodegen:fromProperty
 */
public class DtoTransformer {
    private static final Logger logger = LoggerFactory.getLogger(DtoTransformer.class);

    /** Naming. */
    private final Naming naming;
    /** Parser types. */
    private final ParserTypes parserTypes;
    /** Type converter. */
    private final TypeConverter typeConverter;

    /**
     * Constructs new DTO transformer.
     *
     * @param naming the naming instance
     * @param parserTypes the parser types instance
     * @param typeConverter the type converter instance
     */
    public DtoTransformer(Naming naming, ParserTypes parserTypes, TypeConverter typeConverter) {
        this.naming = naming;
        this.parserTypes = parserTypes;
        this.typeConverter = typeConverter;
    }

    /**
     * Transforms OpenApi specification to types model.
     *
     * The types are added to the Types instance as the specification
     * is processed.
     *
     * @param specification the OpenApi specification
     */
    public void transform(OpenAPI specification) {
        readSpec(specification);
    }

    private void readSpec(OpenAPI specification) {
        @SuppressWarnings("rawtypes")
        Map<String, Schema> allDefinitions = OpenapiGeneratorUtils.getSchemas(specification);
        logger.debug("See schemas: {}", allDefinitions.keySet());

        allDefinitions.forEach((schemaName, schema) -> {
            String modelName = naming.convertTypeName(schemaName);

            ParserTypeRef dtoType = typeConverter.toReference(schema);

            List<Property> props = readProperties(schema);

            @Nullable
            List<String> enumValues = getEnumValues(schema);

            Dto dto = Dto.builder()
                    .name(modelName)
                    .description(schema.getDescription())
                    .reference(dtoType)
                    .properties(props)
                    .openapiId(TypeNames.of(schemaName))
                    .enumValues(enumValues)
                    .implementsInterfaces(List.of())
                    .build();

            parserTypes.addDto(dto);
        });
    }

    @Nullable
    private List<String> getEnumValues(@SuppressWarnings("rawtypes") Schema schema) {
        List<?> schemaEnumValues = schema.getEnum();
        if (schemaEnumValues == null) {
            return null;
        }

        return schemaEnumValues.stream()
                    .map(Object::toString)
                    .toList();
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

            Reference ref = typeConverter.reference(propSchema, name);

            String exampleStr = Objects.toString(propSchema.getExample(), null);

            boolean isReadOnly = (propSchema.getReadOnly() != null) && propSchema.getReadOnly();
            boolean isNullable = (propSchema.getNullable() != null) && propSchema.getNullable();

            props.add(Property.builder()
                    .name(name)
                    .reference(ref)
                    .description(propSchema.getDescription())
                    .example(exampleStr)
                    .isNullable(isNullable)
                    .isReadonly(isReadOnly)
                    .isRequired(requiredProperyNames.contains(name))
                    .minLength(propSchema.getMinLength())
                    .maxLength(propSchema.getMaxLength())
                    .minimum(propSchema.getMinimum())
                    .maximum(propSchema.getMaximum())
                    .pattern(propSchema.getPattern())
                    .build());
        }

        logger.debug(" props: {}", props);

        return props;
    }
}
