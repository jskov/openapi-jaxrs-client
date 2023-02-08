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
import dk.mada.jaxrs.model.ImmutableValidation;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.SubtypeSelector;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeComposite;
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

    /**
     * Creates the schema reference, but overrides the required state.
     *
     * This is used from parameters, where the required property comes from the parameter.
     *
     * @param schema   the OpenApi schema to convert
     * @param required the required value to override in the reference
     * @return the found/created internal model type
     */
    public ParserTypeRef toReference(Schema<?> schema, boolean required) {
        ParserTypeRef ptr = reference(schema, null, null);

        if (required) {
            logger.debug(" overriding ptr validation to force required");
            var withRequire = ImmutableValidation.builder().from(ptr.validation())
                    .isRequired(true)
                    .build();
            return ImmutableParserTypeRef.builder().from(ptr)
                    .validation(withRequire)
                    .build();
        } else {
            return ptr;
        }
    }

    /**
     * Contains reference information when converting a schema to a type reference.
     */
    record RefInfo(Schema<?> schema, @Nullable String propertyName, @Nullable String parentDtoName, Validation validation) {
    }

    /**
     * The type mappers convert a schema configuration to a type refence if possible (or null otherwise).
     */
    private interface TypeMapper extends Function<RefInfo, ParserTypeRef> {
    }

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

        Validation validation = extractValidation(schema, false);
        logger.debug("validation {}", validation);

        RefInfo ri = new RefInfo(schema, propertyName, parentDtoName, validation);

        return Stream.<TypeMapper>of(
                this::createPrimitiveTypeRef,
                this::createDtoRef,
                this::createArrayRef,
                this::createByteArrayRef,
                this::createMapRef,
                this::createAnyofRef,
                this::createAllofRef,
                this::createOneofRef,
                this::createComposedValidation,
                this::createNumberRef,
                this::createDateTimeRef,
                this::createDateRef,
                this::createUUIDRef,
                this::createStringRef,
                this::createSupplementalValidation,
                this::createObjectRef)
                .map(tm -> tm.apply(ri))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No type found for " + schema));
    }

    /**
     * Creates reference to a primitive or a property enumeration (of a primitive).
     *
     * @param schema       the schema to look for
     * @param propertyName the property for which to look for
     * @param validation   the reference validation
     * @return the found reference or null
     */
    @Nullable private ParserTypeRef createPrimitiveTypeRef(RefInfo ri) {
        Type type = Primitive.find(ri.schema);
        if (type == null) {
            return null;
        }
        List<?> enumeration = ri.schema.getEnum();
        if (enumeration == null || ri.propertyName == null) {
            String name = type.typeName().name();
            logger.trace(" - createPrimitiveTypeRef {}", name);
            return parserRefs.of(type, ri.validation);
        }

        String enumTypeName = naming.convertPropertyEnumTypeName(ri.propertyName);
        TypeName typeName = typeNames.of(enumTypeName);

        List<String> enumValues = enumeration.stream()
                .map(Objects::toString)
                .toList();
        String name = typeName.name();
        logger.trace(" - createPrimitiveTypeRef enum {} {} {}", name, type, enumValues);
        return parserRefs.of(TypeEnum.of(typeName, type, enumValues), ri.validation);
    }

    @Nullable private ParserTypeRef createArrayRef(RefInfo ri) {
        if (ri.schema instanceof ArraySchema a) {
            ParserTypeRef innerType = reference(a.getItems(), ri.propertyName, ri.parentDtoName);
            logger.trace(" - createArrayRef {}", innerType);

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

    @Nullable private ParserTypeRef createByteArrayRef(RefInfo ri) {
        if (ri.schema instanceof BinarySchema || ri.schema instanceof FileSchema) {
            logger.trace(" - createByteArrayRef");
            boolean isBodyArgument = ri.propertyName == null;
            TypeByteArray impl = isBodyArgument ? TypeByteArray.getStream() : TypeByteArray.getArray();
            return parserRefs.of(impl, ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createMapRef(RefInfo ri) {
        if (ri.schema instanceof MapSchema m) {
            Object additionalProperties = m.getAdditionalProperties();
            if (additionalProperties instanceof Schema<?> innerSchema) {
                logger.trace(" - createMapRef");
                Type innerType = toReference(innerSchema);
                return parserRefs.of(TypeMap.of(typeNames, innerType), ri.validation);
            }
        }
        return null;
    }

    @Nullable private ParserTypeRef createComposedValidation(RefInfo ri) {
        if (ri.schema instanceof ComposedSchema cs
                && findTypeValidation(cs)instanceof ParserTypeRef ptr) {
            logger.trace(" - createComposedValidation");
            return ptr;
        }
        return null;
    }

    @Nullable private ParserTypeRef createAnyofRef(RefInfo ri) {
        if (ri.schema instanceof ComposedSchema cs) {
            // anyOf is classes implementing an interface
            @SuppressWarnings("rawtypes")
            List<Schema> anyOf = cs.getAnyOf();
            if (anyOf != null && !anyOf.isEmpty()) {
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

                logger.trace(" - createAnyofRef interface {} : {}", tn, anyOfRefs);

                TypeInterface ti = parserTypes.getOrMakeInterface(tn, anyOfRefs);
                return parserRefs.of(ti, ri.validation);
            }
        }
        return null;
    }

    @Nullable private ParserTypeRef createAllofRef(RefInfo ri) {
        if (ri.schema instanceof ComposedSchema cs) {
            @SuppressWarnings("rawtypes")
            List<Schema> allOf = cs.getAllOf();
            if (allOf != null && !allOf.isEmpty()) {

                // Note the removal of duplicates, necessary for the allof_dups test
                List<ParserTypeRef> allOfRefs = allOf.stream()
                        .map(this::toReference)
                        .distinct() // remove duplicates
                        .toList();

                if (allOfRefs.size() == 1) {
                    logger.trace(" - createAllofRef, shortcut for duplicate");
                    return parserRefs.of(allOfRefs.get(0), ri.validation);
                }
                
                List<TypeName> names = allOfRefs.stream()
                	.map(ptr -> ptr.typeName())
                	.toList();
                
                logger.info("See composite: {} : {}", names, allOfRefs);
                
                TypeComposite composite = TypeComposite.of("xx", typeNames.of("parent-" + ri.parentDtoName()), names);
				return parserRefs.of(composite, ri.validation);
            }
        }
        return null;
    }

    @Nullable private ParserTypeRef createOneofRef(RefInfo ri) {
        if (ri.schema instanceof ComposedSchema cs) {
            @SuppressWarnings("rawtypes")
            List<Schema> oneOf = cs.getOneOf();
            if (oneOf != null && !oneOf.isEmpty()) {
                List<String> oneOfNames = oneOf.stream()
                        .map(Schema::getName)
                        .toList();
                logger.trace(" - createOneofRef {}", oneOfNames);

                // regular object, but for now assumes there will
                // be supplementary discriminator information
                return parserRefs.of(TypeObject.get(), ri.validation);
            }
        }
        return null;
    }

    @Nullable private ParserTypeRef createNumberRef(RefInfo ri) {
        if (ri.schema instanceof NumberSchema) {
            logger.trace(" - createNumberRef");
            return parserRefs.of(TypeBigDecimal.get(), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createDateTimeRef(RefInfo ri) {
        if (isDateTimeType(ri.schema)) {
            logger.trace(" - createDateTimeRef");
            return parserRefs.of(TypeDateTime.get(generatorOpts), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createDateRef(RefInfo ri) {
        if (isDateType(ri.schema)) {
            logger.trace(" - createDateRef");
            return parserRefs.of(TypeDate.get(), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createUUIDRef(RefInfo ri) {
        if (ri.schema instanceof UUIDSchema) {
            logger.trace(" - createUUIDRef");
            return parserRefs.of(TypeUUID.get(), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createStringRef(RefInfo ri) {
        if (ri.schema instanceof StringSchema) {
            logger.trace(" - createStringRef");
            if (TypeLocalTime.OPENAPI_CUSTOM_FORMAT.equals(ri.schema.getFormat())) {
                return parserRefs.of(TypeLocalTime.get(), ri.validation);
            }

            return parserRefs.of(Primitive.STRING, ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createSupplementalValidation(RefInfo ri) {
        Schema<?> schema = ri.schema;
        // If no type and reference, assume it is supplemental validation
        // information for the other type in a ComposedSchema.
        if (schema.getType() == null && schema.get$ref() == null
                && (schema.getProperties() == null || schema.getProperties().isEmpty())) {
            logger.trace(" - createSupplementalValidation");
            return parserRefs.of(TypeValidation.of(ri.validation), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createObjectRef(RefInfo ri) {
        Schema<?> schema = ri.schema;
        if (schema instanceof ObjectSchema || schema.getType() == null) {
            boolean isPlainObject = schema.getProperties() == null || schema.getProperties().isEmpty();
            if (ri.propertyName == null) {
                if (isPlainObject) {
                    logger.trace(" - createObjectRef, plain Object, no properties");
                    return parserRefs.of(TypePlainObject.get(), ri.validation);
                } else {
                    logger.trace(" - createObjectRef, plain Object?");
                    return parserRefs.of(TypeObject.get(), ri.validation);
                }
            }
            logger.trace(" - createObjectRef, inner-object for property {}", ri.propertyName);
            String dtoNamePrefix = isPlainObject ? "" : ri.parentDtoName;
            String syntheticDtoName = dtoNamePrefix + naming.convertTypeName(ri.propertyName);
            Dto dto = createDto(syntheticDtoName, schema);
            return parserRefs.of(dto, ri.validation);
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

    @Nullable private ParserTypeRef createDtoRef(RefInfo ri) {
        return createDtoRef(ri.schema.get$ref(), ri.validation);
    }

    @Nullable private ParserTypeRef createDtoRef(String ref, Validation validation) {
        if (ref == null || !ref.startsWith(REF_COMPONENTS_SCHEMAS)) {
            return null;
        }
        logger.trace(" - createDtoRef");
        String openapiId = ref.substring(REF_COMPONENTS_SCHEMAS.length());
        return parserRefs.makeDtoRef(openapiId, validation);
    }

    private Validation extractValidation(@SuppressWarnings("rawtypes") Schema s, boolean required) {
        Validation candidate = Validation.builder()
                .isNullable(Optional.ofNullable(s.getNullable()))
                .isReadonly(Optional.ofNullable(s.getReadOnly()))
                .isRequired(Optional.of(required))
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

            Validation validation = extractValidation(propSchema, requiredProperyNames.contains(propertyName));

            props.add(Property.builder()
                    .name(propertyName)
                    .reference(ref)
                    .description(Optional.ofNullable(propSchema.getDescription()))
                    .example(exampleStr)
                    .validation(validation)
                    .build());
        }

        logger.debug(" props: {}", props);

        return props;
    }
}
