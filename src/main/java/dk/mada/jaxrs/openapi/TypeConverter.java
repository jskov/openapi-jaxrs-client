package dk.mada.jaxrs.openapi;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeEnum;
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypeRef;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeUUID;
import dk.mada.jaxrs.model.types.TypeValidation;
import dk.mada.jaxrs.model.types.Types;
import dk.mada.jaxrs.naming.Naming;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.media.UUIDSchema;

/**
 * Converts a specification schema to an internal model type.
 */
public final class TypeConverter {
    private static final Logger logger = LoggerFactory.getLogger(TypeConverter.class);
    /** Component schema prefix. */
    private static final String REF_COMPONENTS_SCHEMAS = "#/components/schemas/";

    /** Types. */
    private final Types types;
    /** Naming. */
    private final Naming naming;
    /** Parser options. */
    private final ParserOpts parserOpts;
    /** Generator options. */
    private final GeneratorOpts generatorOpts;

    /**
     * Constructs a new type converter.
     *
     * This operated by looking up types, creating if missing, in the
     * types instance.
     *
     * @param types the types instance
     * @param naming the naming instance
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     */
    public TypeConverter(Types types, Naming naming, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
        this.types = types;
        this.naming = naming;
        this.parserOpts = parserOpts;
        this.generatorOpts = generatorOpts;
    }

    /**
     * Converts a OpenApi schema to an internal model type.
     *
     * @param schema the OpenApi schema to convert
     * @return the found/created internal model type
     */
    public Type toType(Schema<?> schema) {
        return toType(schema, null);
    }

    /**
     * Converts a OpenApi schema to an internal model type.
     *
     * @param schema the OpenApi schema to convert
     * @param propertyName name of the property the type is associated with, or null
     * @return the found/created internal model type
     */
    public Type toType(Schema<?> schema, String propertyName) {
        String schemaType = schema.getType();
        String schemaFormat = schema.getFormat();
        String schemaRef = schema.get$ref();

        logger.info("type/format: {}/{} {}", schemaType, schemaFormat, schema.getClass());
        logger.info("ref {}", schemaRef);

        Type type = Primitive.find(schemaType, schemaFormat);

        if (schema.getEnum() != null) {
            if (propertyName == null || type == null) {
                logger.warn("Found enumaration type but no property name provided");
            } else {
                String enumTypeName = naming.convertPropertyEnumTypeName(propertyName);
                TypeName typeName = TypeNames.of(enumTypeName);

                List<String> enumValues = schema.getEnum().stream()
                        .map(Objects::toString)
                        .toList();
                logger.info(" ENUM: {} {} {}", typeName, type, enumValues);
                return TypeEnum.of(typeName, type, enumValues);
            }
        }

        if (type != null) {
            return type;
        }

        type = findDto(schema.get$ref());

        if (type != null) {
            return type;
        }

        if (schema instanceof ArraySchema a) {
            Type innerType = toType(a.getItems());

            Boolean isUnique = a.getUniqueItems();
            if (isUnique != null && isUnique.booleanValue()) {
                return TypeSet.of(innerType);
            }

            if (innerType instanceof TypeByteArray && parserOpts.isUnwrapByteArrayList()) {
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
                Type innerType = toType(innerSchema);
                return TypeMap.of(innerType);
            }
        }

        if (schema instanceof ComposedSchema cs) {
            // TODO: oneOff -> interface implementation selection

            // allOf is the combination of schemas (subclassing and/or validation)
            Type typeWithValidation = findTypeValidation(cs);
            if (typeWithValidation != null) {
                return typeWithValidation;
            }
        }

        if (schema instanceof NumberSchema) {
            return TypeBigDecimal.get();
        }

        if (schema instanceof DateTimeSchema) {
            return TypeDateTime.get(generatorOpts);
        }

        if (schema instanceof DateSchema) {
            logger.debug(" {} : TypeDate", schema.getName());
            return TypeDate.get();
        }

        if (schema instanceof UUIDSchema) {
            return TypeUUID.get();
        }

        if (schema instanceof ObjectSchema) {
            return TypeObject.get();
        }

        if (schema instanceof StringSchema) {
            if (TypeLocalTime.OPENAPI_CUSTOM_FORMAT.equals(schemaFormat)) {
                return TypeLocalTime.get();
            }

            return Primitive.STRING;
        }

        // In no type and reference, assume it is supplemental validation
        // information for the other type in a ComposedSchema.
        if (schemaType == null && schemaRef == null) {
            Validation v = extractValidation(schema);
            logger.debug("VALIDATION {}", v);
            return TypeValidation.of(v);
        }

        throw new IllegalStateException("No type found for " + schema);
    }

    /**
     * Handle (only) allOf-use for assigning validation to a type.
     *
     * @param cs the composed schema
     * @return a referenced type with validation added, or null
     */
    private Type findTypeValidation(ComposedSchema cs) {
        @SuppressWarnings("rawtypes")
        List<Schema> allOf = cs.getAllOf();
        if (allOf == null) {
            return null;
        }

        logger.info("ALL OF {}", allOf.size());
        List<Type> allOfTypes = allOf.stream()
            .map(this::toType)
            .toList();
        allOfTypes.forEach(t -> logger.info(" {}", t));

        List<TypeValidation> validations = allOfTypes.stream()
            .filter(TypeValidation.class::isInstance)
            .map(TypeValidation.class::cast)
            .toList();
        List<TypeRef> refs = allOfTypes.stream()
                .filter(TypeRef.class::isInstance)
                .map(TypeRef.class::cast)
                .toList();

        if (validations.size() != 1 && refs.size() != 1) {
            logger.warn("Unabled to handle allOf for {} with {}", refs, validations);
            // bail for now
            return TypeObject.get();
        }

        TypeRef ref = refs.get(0);
        Validation validation = validations.get(0).validation();

        logger.info("TODO: missing {} validations {}", ref, validation);
        return ref;
    }

    private Type findDto(String ref) {
        if (ref != null && ref.startsWith(REF_COMPONENTS_SCHEMAS)) {
            String openapiId = ref.substring(REF_COMPONENTS_SCHEMAS.length());
            return types.findDto(openapiId);
        }
        return null;
    }

    private Validation extractValidation(@SuppressWarnings("rawtypes") Schema s) {
        return Validation.builder()
                .isNullable(s.getNullable())
                .isReadonly(s.getReadOnly())
                .isRequired(false)
                .maximum(s.getMaximum())
                .maxLength(s.getMaxLength())
                .minimum(s.getMinimum())
                .minLength(s.getMinLength())
                .pattern(s.getPattern())
                .build();
    }
}
