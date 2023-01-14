package dk.mada.jaxrs.openapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.SubtypeSelector;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeEnum;
import dk.mada.jaxrs.model.types.TypeInterface;
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypePlainObject;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeUUID;
import dk.mada.jaxrs.model.types.TypeValidation;
import dk.mada.jaxrs.naming.Naming;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.Discriminator;
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

    /** Type names. */
    private final TypeNames typeNames;
    /** Naming. */
    private final Naming naming;
    /** Parser references. */
    private final ParserTypeRefs parserRefs;
    /** Parser options. */
    private final ParserOpts parserOpts;
    /** Generator options. */
    private final GeneratorOpts generatorOpts;
    /** Parser types. */
    private final ParserTypes parserTypes;

    /** Validation instances to make sure we only get one of each. */
    private final Set<Validation> validationInstances = new HashSet<>(Set.of(Validation.NO_VALIDATION));

    /**
     * Constructs a new type converter.
     *
     * This operated by looking up types, creating if missing, in the types instance.
     *
     * @param typeNames     the type names
     * @param parserTypes   the parser types
     * @param parserRefs    the parser references
     * @param naming        the naming instance
     * @param parserOpts    the parser options
     * @param generatorOpts the generator options
     */
    public TypeConverter(TypeNames typeNames, ParserTypes parserTypes, ParserTypeRefs parserRefs,
            Naming naming, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
        this.typeNames = typeNames;
        this.parserTypes = parserTypes;
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
        return reference(schema, null, null);
    }

    private record RefInfo(Schema<?> schema, @Nullable String propertyName, @Nullable String parentDtoName, Validation validation) {
    }

    private interface TypeMapper extends Function<RefInfo, ParserTypeRef> {};
    
    /**
     * Converts a OpenApi schema to parser type reference.
     *
     * This serves as a lazy reference to something that will eventually be resolved to a type in the model.
     *
     * @param schema        the OpenApi schema to convert
     * @param propertyName  the name of the property the type is associated with, or null
     * @param parentDtoName the name of the DTO this schema is part of, or null
     * @return the found/created parser type reference
     */
    public ParserTypeRef reference(Schema<?> schema, @Nullable String propertyName, @Nullable String parentDtoName) {
        String schemaType = schema.getType();
        String schemaFormat = schema.getFormat();
        String schemaRef = schema.get$ref();

        logger.debug("type/format: {}:{} {}/{} {}", parentDtoName, propertyName, schemaType, schemaFormat, schema.getClass());
        logger.debug("ref {}", schemaRef);

        Validation validation = extractValidation(schema);
        logger.debug("validation {}", validation);

        RefInfo ri = new RefInfo(schema, propertyName, parentDtoName, validation);

        ParserTypeRef ref = Stream.<TypeMapper>of(
                this::createPrimitiveTypeRef,
                this::createDtoRef,
                this::createArrayRef,
                this::createByteArrayRef,
                this::createMapRef,
                this::createComposedRef,
                this::createNumberRef,
                this::createDateTimeRef,
                this::createDateRef,
                this::createUUIDRef,
                this::createStringRef
                )
            .map(tm -> tm.apply(ri))
            .filter(Objects::nonNull)
            .findFirst()
            .orElse(null);

        if (ref != null) {
            return ref;
        }

        boolean noSchemaType = schemaType == null; // seen in manually created files

        // In no type and reference, assume it is supplemental validation
        // information for the other type in a ComposedSchema.
        if (noSchemaType && schemaRef == null
                && (schema.getProperties() == null || schema.getProperties().isEmpty())) {
            // FIXME: Gets double wrapped
            return parserRefs.of(TypeValidation.of(validation), validation);
        }

        if (schema instanceof ObjectSchema || noSchemaType) {
            boolean isPlainObject = schema.getProperties() == null || schema.getProperties().isEmpty();
            if (propertyName == null) {
                if (isPlainObject) {
                    logger.debug(" plain Object, no properties");
                    return parserRefs.of(TypePlainObject.get(), validation);
                } else {
                    logger.debug(" plain Object?");
                    return parserRefs.of(TypeObject.get(), validation);
                }
            }
            logger.debug(" inner-object for property {}", propertyName);
            String dtoNamePrefix = isPlainObject ? "" : parentDtoName;
            String syntheticDtoName = dtoNamePrefix + naming.convertTypeName(propertyName);
            Dto dto = createDto(syntheticDtoName, schema);
            return parserRefs.of(dto, validation);
        }

        // TODO: the schema for a form has properties, but is otherwise void
        // not sure if this is a good general handling of the case - in particular
        // because those properties are ignored by this.
        // return parserRefs.of(TypeVoid.getRef(), validation);

        throw new IllegalStateException("No type found for " + schema);
    }

    /**
     * Creates reference to a primitive or a property enumeration (of a primitive).
     *
     * @param schema the schema to look for
     * @param propertyName the property for which to look for
     * @param validation the reference validation
     * @return the found reference or null
     */
    @Nullable
    private ParserTypeRef createPrimitiveTypeRef(RefInfo ri) {
        Type type = Primitive.find(ri.schema);
        if (type == null) {
            return null;
        }
        List<?> enumeration = ri.schema.getEnum();
        if (enumeration == null || ri.propertyName == null) {
            return parserRefs.of(type, ri.validation);
        }

        String enumTypeName = naming.convertPropertyEnumTypeName(ri.propertyName);
        TypeName typeName = typeNames.of(enumTypeName);

        List<String> enumValues = enumeration.stream()
                .map(Objects::toString)
                .toList();
        logger.debug(" ENUM: {} {} {}", typeName, type, enumValues);
        return parserRefs.of(TypeEnum.of(typeName, type, enumValues), ri.validation);
    }

    
    @Nullable
    private ParserTypeRef createArrayRef(RefInfo ri) {
        if (ri.schema instanceof ArraySchema a) {
            ParserTypeRef innerType = reference(a.getItems(), ri.propertyName, ri.parentDtoName);
            logger.debug(" array of {}", innerType);

            Boolean isUnique = a.getUniqueItems();
            if (isUnique != null && isUnique.booleanValue()) {
                return parserRefs.of(TypeSet.of(typeNames, innerType), ri.validation);
            }

            if (innerType.refType() instanceof TypeByteArray && parserOpts.isUnwrapByteArrayList()) {
                return parserRefs.of(TypeByteArray.getArray(), ri.validation);
            }

            return parserRefs.of(TypeArray.of(typeNames, innerType), ri.validation);
        }
        return null;
    }

    @Nullable
    private ParserTypeRef createByteArrayRef(RefInfo ri) {
        if (!(ri.schema instanceof BinarySchema || ri.schema instanceof FileSchema)) {
            return null;
        }
        logger.debug(" binary/file schema");
        boolean isBodyArgument = ri.propertyName == null;
        TypeByteArray impl = isBodyArgument ? TypeByteArray.getStream() : TypeByteArray.getArray();
        return parserRefs.of(impl, ri.validation);
    }

    @Nullable
    private ParserTypeRef createMapRef(RefInfo ri) {
        if (ri.schema instanceof MapSchema m) {
            logger.debug(" map schema");
            Object additionalProperties = m.getAdditionalProperties();
            if (additionalProperties instanceof Schema<?> innerSchema) {
                Type innerType = toReference(innerSchema);
                return parserRefs.of(TypeMap.of(typeNames, innerType), ri.validation);
            }
        }
        return null;
    }

    @Nullable
    private ParserTypeRef createComposedRef(RefInfo ri) {
        if (ri.schema instanceof ComposedSchema cs) {
            logger.debug(" composed schema");
            // anyOf is classes implementing an interface
            @SuppressWarnings("rawtypes")
            List<Schema> anyOf = cs.getAnyOf();
            if (anyOf != null && !anyOf.isEmpty()) {
                logger.debug("  anyof");
                List<ParserTypeRef> anyOfRefs = anyOf.stream()
                        .map(this::toReference)
                        .toList();
                List<String> anyOfNames = anyOfRefs.stream()
                        .map(ParserTypeRef::typeName)
                        .map(TypeName::name)
                        .sorted()
                        .toList();
    
                String interfaceName = cs.getName();
                if (interfaceName == null) {
                    interfaceName = String.join("", anyOfNames);
                }
    
                TypeName tn = typeNames.of(interfaceName);
    
                logger.debug(" interface {} : {}", tn, anyOfRefs);
    
                TypeInterface ti = parserTypes.getOrMakeInterface(tn, anyOfRefs);
                return parserRefs.of(ti, ri.validation);
            }
    
            @SuppressWarnings("rawtypes")
            List<Schema> allOf = cs.getAllOf();
            if (allOf != null && !allOf.isEmpty()) {
                logger.debug("  allof");
    
                // Note the removal of duplicates, necessary for the allof_dups test
                List<ParserTypeRef> allOfRefs = allOf.stream()
                        .map(this::toReference)
                        .distinct() // remove duplicates
                        .toList();
    
                if (allOfRefs.size() == 1) {
                    logger.debug("   shortcut for duplicate");
                    return parserRefs.of(allOfRefs.get(0), ri.validation);
                }
            }
    
            @SuppressWarnings("rawtypes")
            List<Schema> oneOf = cs.getOneOf();
            if (oneOf != null && !oneOf.isEmpty()) {
                List<String> oneOfNames = oneOf.stream()
                        .map(Schema::getName)
                        .toList();
                logger.info("  oneof {}", oneOfNames);
    
                // regular object, but for now assumes there will
                // be supplementary discriminator information
                return parserRefs.of(TypeObject.get(), ri.validation);
            }
    
            // allOf is the combination of schemas (subclassing and/or validation)
            Type typeWithValidation = findTypeValidation(cs);
            if (typeWithValidation != null) {
                if (typeWithValidation instanceof ParserTypeRef ptr) {
                    return ptr;
                } else {
                    return parserRefs.of(typeWithValidation, ri.validation);
                }
            }
        }

        return null;
    }

    @Nullable
    private ParserTypeRef createNumberRef(RefInfo ri) {
        if (ri.schema instanceof NumberSchema) {
            return parserRefs.of(TypeBigDecimal.get(), ri.validation);
        }
        
        return null;
    }

    @Nullable
    private ParserTypeRef createDateTimeRef(RefInfo ri) {
        if (isDateTimeType(ri.schema)) {
            return parserRefs.of(TypeDateTime.get(generatorOpts), ri.validation);
        }

        return null;
    }

    @Nullable
    private ParserTypeRef createDateRef(RefInfo ri) {
        if (isDateType(ri.schema)) {
            return parserRefs.of(TypeDate.get(), ri.validation);
        }

        return null;
    }

    @Nullable
    private ParserTypeRef createUUIDRef(RefInfo ri) {
        if (ri.schema instanceof UUIDSchema) {
            return parserRefs.of(TypeUUID.get(), ri.validation);
        }
        return null;
    }

    @Nullable
    private ParserTypeRef createStringRef(RefInfo ri) {
        if (ri.schema instanceof StringSchema) {
            if (TypeLocalTime.OPENAPI_CUSTOM_FORMAT.equals(ri.schema.getFormat())) {
                return parserRefs.of(TypeLocalTime.get(), ri.validation);
            }
    
            return parserRefs.of(Primitive.STRING, ri.validation);
        }

        return null;
    }


    
    private boolean isDateType(Schema<?> schema) {
        return schema instanceof DateSchema
                || isBrokenDateTimeType(schema, "date");
    }

    private boolean isDateTimeType(Schema<?> schema) {
        return schema instanceof DateTimeSchema
                || isBrokenDateTimeType(schema, "date-time");
    }

    private boolean isBrokenDateTimeType(Schema<?> schema, String format) {
        return parserOpts.isFixupNullTypeDates()
                && schema.getType() == null
                && format.equals(schema.getFormat());
    }

    /**
     * Handle (only) allOf-use for assigning validation to a type.
     *
     * @param cs the composed schema
     * @return a referenced type with validation added, or null
     */
    private @Nullable Type findTypeValidation(ComposedSchema cs) {
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
            if (ptr.refType()instanceof TypeValidation tv) {
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

    @Nullable
    private ParserTypeRef createDtoRef(RefInfo ri) {
        return createDtoRef(ri.schema.get$ref(), ri.validation);
    }

    @Nullable
    private ParserTypeRef createDtoRef(String ref, Validation validation) {
        if (ref == null || !ref.startsWith(REF_COMPONENTS_SCHEMAS)) {
            return null;
        }
        String openapiId = ref.substring(REF_COMPONENTS_SCHEMAS.length());
        return parserRefs.makeDtoRef(openapiId, validation);
    }

    private Validation extractValidation(@SuppressWarnings("rawtypes") Schema s) {
        Validation candidate = Validation.builder()
                .isNullable(Optional.ofNullable(s.getNullable()))
                .isReadonly(Optional.ofNullable(s.getReadOnly()))
                .isRequired(false)
                .maximum(Optional.ofNullable(s.getMaximum()))
                .maxItems(Optional.ofNullable(s.getMaxItems()))
                .maxLength(Optional.ofNullable(s.getMaxLength()))
                .minimum(Optional.ofNullable(s.getMinimum()))
                .minItems(Optional.ofNullable(s.getMinItems()))
                .minLength(Optional.ofNullable(s.getMinLength()))
                .pattern(Optional.ofNullable(s.getPattern()))
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

    /**
     * Creates a DTO from an Object schema.
     *
     * @param dtoName the DTO name
     * @param schema  the schema of the DTO
     * @return the create DTO
     */
    public Dto createDto(String dtoName, Schema<?> schema) {
        String modelName = naming.convertTypeName(dtoName);
        // FIXME: original dtoName should be stored in the Dto
        // and used to generate mpSchema name in the Generator.
        // But maybe keep it since it is a distinct namespace
        // that needs name-conflict-resolution.
        String mpSchemaName = naming.convertMpSchemaName(dtoName);

        logger.info("creating dto {}", dtoName);
        ParserTypeRef dtoType = reference(schema, null, dtoName);

        List<Property> props = readProperties(schema, modelName);

        SubtypeSelector selector = null;
        Discriminator disc = schema.getDiscriminator();
        if (disc != null && disc.getMapping() != null) {
            Map<String, Reference> mapping = new HashMap<>();
            for (var e : disc.getMapping().entrySet()) {
                String discName = e.getKey();
                mapping.put(discName, createDtoRef(e.getValue(), Validation.NO_VALIDATION));
            }
            selector = SubtypeSelector.of(disc.getPropertyName(), mapping);
        }

        Dto dto = Dto.builder(modelName, typeNames.of(modelName))
                .mpSchemaName(mpSchemaName)
                .description(Optional.ofNullable(schema.getDescription()))
                .reference(dtoType)
                .properties(props)
                .openapiId(typeNames.of(dtoName))
                .enumValues(getEnumValues(schema))
                .implementsInterfaces(List.of())
                .subtypeSelector(Optional.ofNullable(selector))
                .build();

        parserTypes.addDto(dto);

        return dto;
    }

    private List<String> getEnumValues(@SuppressWarnings("rawtypes") Schema schema) {
        List<?> schemaEnumValues = schema.getEnum();
        if (schemaEnumValues == null) {
            return List.of();
        }

        return schemaEnumValues.stream()
                .map(Object::toString)
                .toList();
    }

    private List<Property> readProperties(Schema<?> schema, String parentDtoName) {
        logger.debug("Read properties of schema {}/{}", parentDtoName, schema.getName());
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
            String propertyName = e.getKey();
            Schema<?> propSchema = e.getValue();
            logger.debug(" - property {}", propertyName);

            Reference ref = reference(propSchema, propertyName, parentDtoName);

            Optional<String> exampleStr = Optional.ofNullable(Objects.toString(propSchema.getExample(), null));

            boolean isReadOnly = (propSchema.getReadOnly() != null) && propSchema.getReadOnly();
            boolean isNullable = (propSchema.getNullable() != null) && propSchema.getNullable();

            props.add(Property.builder()
                    .name(propertyName)
                    .reference(ref)
                    .description(Optional.ofNullable(propSchema.getDescription()))
                    .example(exampleStr)
                    .isNullable(isNullable)
                    .isReadonly(isReadOnly)
                    .isRequired(requiredProperyNames.contains(propertyName))
                    .minItems(Optional.ofNullable(propSchema.getMinItems()))
                    .maxItems(Optional.ofNullable(propSchema.getMaxItems()))
                    .minLength(Optional.ofNullable(propSchema.getMinLength()))
                    .maxLength(Optional.ofNullable(propSchema.getMaxLength()))
                    .minimum(Optional.ofNullable(propSchema.getMinimum()))
                    .maximum(Optional.ofNullable(propSchema.getMaximum()))
                    .pattern(Optional.ofNullable(propSchema.getPattern()))
                    .build());
        }

        logger.debug(" props: {}", props);

        return props;
    }
}
