package dk.mada.jaxrs.openapi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeUUID;
import dk.mada.jaxrs.model.types.TypeValidation;
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

    /** Naming. */
    private final Naming naming;
    /** Parser references. */
    private final ParserTypeRefs parserRefs;
    /** Parser options. */
    private final ParserOpts parserOpts;
    /** Generator options. */
    private final GeneratorOpts generatorOpts;

    /** Validation instances to make sure we only get one of each. */
    private final Set<Validation> validationInstances = new HashSet<>(Set.of(Validation.NO_VALIDATION));

    /**
     * Constructs a new type converter.
     *
     * This operated by looking up types, creating if missing, in the
     * types instance.
     *
     * @param parserRefs the parser references
     * @param naming the naming instance
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     */
    public TypeConverter(ParserTypeRefs parserRefs, Naming naming, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
        this.parserRefs = parserRefs;
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
    public ParserTypeRef toReference(Schema<?> schema) {
        return reference(schema, null);
    }

    /**
     * Converts a OpenApi schema to parser type reference.
     *
     * This serves as a lazy reference to something that will
     * eventually be resolved to a type in the model.
     *
     * @param schema the OpenApi schema to convert
     * @param propertyName name of the property the type is associated with, or null
     * @return the found/created parser type reference
     */
    public ParserTypeRef reference(Schema<?> schema, String propertyName) {
        String schemaType = schema.getType();
        String schemaFormat = schema.getFormat();
        String schemaRef = schema.get$ref();

        logger.debug("type/format: {}/{} {}", schemaType, schemaFormat, schema.getClass());
        logger.debug("ref {}", schemaRef);

        Validation validation = extractValidation(schema);

        Type type = Primitive.find(schemaType, schemaFormat);

        if (schema.getEnum() != null) {
            if (propertyName == null || type == null) {
                logger.warn("Found enumeration type but no property name provided");
            } else {
                String enumTypeName = naming.convertPropertyEnumTypeName(propertyName);
                TypeName typeName = TypeNames.of(enumTypeName);

                List<String> enumValues = schema.getEnum().stream()
                        .map(Objects::toString)
                        .toList();
                logger.debug(" ENUM: {} {} {}", typeName, type, enumValues);
                return parserRefs.of(TypeEnum.of(typeName, type, enumValues), validation);
            }
        }

        if (type != null) {
            return parserRefs.of(type, validation);
        }

        ParserTypeRef ref = findDto(schema.get$ref(), validation);
        if (ref != null) {
            return ref;
        }

        if (schema instanceof ArraySchema a) {
            ParserTypeRef innerType = toReference(a.getItems());

            Boolean isUnique = a.getUniqueItems();
            if (isUnique != null && isUnique.booleanValue()) {
                return parserRefs.of(TypeSet.of(innerType), validation);
            }

            if (innerType.refType() instanceof TypeByteArray && parserOpts.isUnwrapByteArrayList()) {
                return parserRefs.of(TypeByteArray.getArray(), validation);
            }

            return parserRefs.of(TypeArray.of(innerType), validation);
        }

        if (schema instanceof BinarySchema || schema instanceof FileSchema) {
            return parserRefs.of(TypeByteArray.getArray(), validation);
        }

        if (schema instanceof MapSchema m) {
            Object additionalProperties = m.getAdditionalProperties();
            if (additionalProperties instanceof Schema<?> innerSchema) {
                Type innerType = toReference(innerSchema);
                return parserRefs.of(TypeMap.of(innerType), validation);
            }
        }

        if (schema instanceof ComposedSchema cs) {
            // TODO: oneOff -> interface implementation selection

            // allOf is the combination of schemas (subclassing and/or validation)
            Type typeWithValidation = findTypeValidation(cs);
            if (typeWithValidation != null) {
                if (typeWithValidation instanceof ParserTypeRef ptr) {
                    return ptr;
                } else {
                    return parserRefs.of(typeWithValidation, validation);
                }
            }
        }

        if (schema instanceof NumberSchema) {
            return parserRefs.of(TypeBigDecimal.get(), validation);
        }

        if (schema instanceof DateTimeSchema) {
            return parserRefs.of(TypeDateTime.get(generatorOpts), validation);
        }

        if (schema instanceof DateSchema) {
            logger.debug(" {} : TypeDate", schema.getName());
            return parserRefs.of(TypeDate.get(), validation);
        }

        if (schema instanceof UUIDSchema) {
            return parserRefs.of(TypeUUID.get(), validation);
        }

        if (schema instanceof ObjectSchema) {
            return parserRefs.of(TypeObject.get(), validation);
        }

        if (schema instanceof StringSchema) {
            if (TypeLocalTime.OPENAPI_CUSTOM_FORMAT.equals(schemaFormat)) {
                return parserRefs.of(TypeLocalTime.get(), validation);
            }

            return parserRefs.of(Primitive.STRING, validation);
        }

        // In no type and reference, assume it is supplemental validation
        // information for the other type in a ComposedSchema.
        if (schemaType == null && schemaRef == null) {
            // FIXME: Gets double wrapped
            return parserRefs.of(TypeValidation.of(validation), validation);
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

        List<ParserTypeRef> allOfTypes = allOf.stream()
            .map(this::toReference)
            .toList();

        List<ParserTypeRef> refs = new ArrayList<>();
        List<Validation> validations = new ArrayList<>();
        for (ParserTypeRef ptr : allOfTypes) {
            logger.debug(" {}", ptr);
            if (ptr.refType() instanceof TypeValidation tv) {
                validations.add(tv.validation());
            } else if (!ptr.validation().isEmptyValidation()) {
                validations.add(ptr.validation());
            } else {
                refs.add(ptr);
            }
        }

        if (validations.size() != 1 || refs.size() != 1) {
            logger.warn("Unabled to handle allOf for {} with {}", refs, validations);
            // bail for now
            return TypeObject.get();
        }

        ParserTypeRef ref = refs.get(0);
        Validation validation = validations.get(0);

        return ParserTypeRef.of(ref.refTypeName(), validation);
    }

    private ParserTypeRef findDto(String ref, Validation validation) {
        if (ref != null && ref.startsWith(REF_COMPONENTS_SCHEMAS)) {
            String openapiId = ref.substring(REF_COMPONENTS_SCHEMAS.length());
            return parserRefs.makeDtoRef(openapiId, validation);
        }
        return null;
    }

    private Validation extractValidation(@SuppressWarnings("rawtypes") Schema s) {
        Validation candidate = Validation.builder()
                .isNullable(s.getNullable())
                .isReadonly(s.getReadOnly())
                .isRequired(false)
                .maximum(s.getMaximum())
                .maxLength(s.getMaxLength())
                .minimum(s.getMinimum())
                .minLength(s.getMinLength())
                .pattern(s.getPattern())
                .build();

        for (Validation v : validationInstances) {
            if (v.equals(candidate)) {
                return v;
            }
        }

        // New instance
        validationInstances.add(candidate);
        return candidate;
    }
}
