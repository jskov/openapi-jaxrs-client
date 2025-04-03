package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.SubtypeSelector;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.api.ContentSelector.ContentContext;
import dk.mada.jaxrs.model.api.StatusCode;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeDate;
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
import dk.mada.jaxrs.openapi.Parser.LeakedGeneratorOpts;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.Discriminator;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.UUIDSchema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    /** The type to use for date-time. */
    private final Type dateTimeType;
    /** The type to use for no-format numbers. */
    private final Type noFormatNumberType;
    /** Parser types. */
    private final ParserTypes parserTypes;

    /**
     * Constructs a new type converter.
     *
     * This operated by looking up types, creating if missing, in the types
     * instance.
     *
     * @param typeNames     the type names
     * @param parserTypes   the parser types
     * @param parserRefs    the parser references
     * @param naming        the naming instance
     * @param parserOpts    the parser options
     * @param leakedGenOpts the leaked generator options
     */
    public TypeConverter(
            TypeNames typeNames,
            ParserTypes parserTypes,
            ParserTypeRefs parserRefs,
            Naming naming,
            ParserOpts parserOpts,
            LeakedGeneratorOpts leakedGenOpts) {
        this.typeNames = typeNames;
        this.parserTypes = parserTypes;
        this.parserRefs = parserRefs;
        this.naming = naming;
        this.parserOpts = parserOpts;

        dateTimeType = leakedGenOpts.dateTimeType();
        noFormatNumberType = leakedGenOpts.noFormatNumberType();
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
     * This is used from parameters, where the required property comes from the
     * parameter.
     *
     * @param schema  the OpenApi schema to convert
     * @param context the context of the reference
     * @return the found/created internal model type
     */
    public ParserTypeRef toReferenceFromApi(Schema<?> schema, ContentContext context) {
        ParserTypeRef ptr = reference(schema, null, null, false, context);

        if (context.isRequired()) {
            logger.debug(" overriding ptr validation to force required");
            var withRequire = Validations.makeRequired(ptr.validation());
            return new ParserTypeRef(ptr.refType(), ptr.refTypeName(), withRequire);
        } else {
            return ptr;
        }
    }

    /**
     * Contains reference information when converting a schema to a type reference.
     *
     * @param schema        the OpenApi schema to convert
     * @param schemaParser  the schema parser
     * @param propertyName  the reference property
     * @param parentDtoName the optional name of the parent dto
     * @param context       the content context of the reference
     * @param validation    the validation requirements for the reference
     * @param isFormRef     true if reference is to a form parameter/field
     */
    record RefInfo(
            Schema<?> schema,
            SchemaParser schemaParser,
            @Nullable String propertyName,
            @Nullable String parentDtoName,
            @Nullable ContentContext context,
            Validation validation,
            boolean isFormRef) {}

    /**
     * The type mappers convert a schema configuration to a type refence if possible
     * (or null otherwise).
     */
    private interface TypeMapper extends Function<RefInfo, ParserTypeRef> {}

    /**
     * Converts a OpenApi schema to parser type reference.
     *
     * This serves as a lazy reference to something that will eventually be resolved
     * to a type in the model.
     *
     * @param schema        the schema
     * @param propertyName  the name of the property the type is associated with, or
     *                      null
     * @param parentDtoName the name of the DTO this schema is part of, or null
     * @return the found/created parser type reference
     */
    private ParserTypeRef reference(Schema<?> schema, @Nullable String propertyName, @Nullable String parentDtoName) {
        return reference(schema, propertyName, parentDtoName, false, null);
    }

    /**
     * Converts a OpenApi schema to parser type reference.
     *
     * This serves as a lazy reference to something that will eventually be resolved
     * to a type in the model.
     *
     * @param schema        the OpenApi schema to convert
     * @param propertyName  the name of the property the type is associated with, or
     *                      null
     * @param parentDtoName the name of the DTO this schema is part of, or null
     * @param isFormRef     true if the reference is a form parameter/field.
     * @param context       the content context, or null
     * @return the found/created parser type reference
     */
    public ParserTypeRef reference(
            Schema<?> schema,
            @Nullable String propertyName,
            @Nullable String parentDtoName,
            boolean isFormRef,
            @Nullable ContentContext context) {

        SchemaParser sp = SchemaParser.of(schema);

        String schemaType = sp.type();
        String schemaFormat = sp.format();

        logger.debug(
                "type/format: {}:{} {}/{} {}",
                parentDtoName,
                propertyName,
                schemaType,
                schemaFormat,
                schema.getClass());

        Validation validation = Validations.extractValidation(schema, false);
        logger.debug("validation {}", validation);

        RefInfo ri = new RefInfo(schema, sp, propertyName, parentDtoName, context, validation, isFormRef);

        ParserTypeRef refType = Stream.<TypeMapper>of(
                        this::createPrimitiveTypeRef,
                        this::createDtoRef,
                        this::createAnyofRef,
                        this::createArrayRef,
                        this::createByteArrayRef,
                        this::createMapRef,
                        this::createComposedValidation, // before allofRef, should be combined
                        this::createAllofRef,
                        this::createOneofRef,
                        this::createNumberRef,
                        this::createDateTimeRef,
                        this::createDateRef,
                        this::createTimeRef,
                        this::createUUIDRef,
                        this::createStringRef,
                        this::createSupplementalValidation,
                        this::createObjectRef)
                .map(tm -> tm.apply(ri))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No type found for " + schema));
        logger.debug(" converted to: {}", refType);
        return refType;
    }

    /**
     * Creates reference to a primitive or a property enumeration (of a primitive).
     *
     * @param ri the reference information
     * @return the found reference or null
     */
    @Nullable private ParserTypeRef createPrimitiveTypeRef(RefInfo ri) {
        SchemaParser schemaParser = ri.schemaParser;

        // V31 spec combines stuff on [string] which would match
        // String in the below. So bail out.
        if (schemaParser.isRef()) {
            return null;
        }

        // If the property declares a primitive type *and* allOf is defined
        // (as happens from Quarkus 3) ignore the found primitive. It is not
        // the full story.
        if (schemaParser.isAllOf()) {
            return null;
        }

        Type type = findPrimitive(schemaParser);
        if (type == null) {
            return null;
        }

        // As of OpenApi specification V3.1 the type encodes nullable - move it to the
        // validation
        Validation validation = ri.validation();
        if (schemaParser.isNullable()) {
            validation = Validations.makeNullable(validation);
        }

        if (!schemaParser.isEnumeration() || ri.propertyName == null) {
            String name = type.typeName().name();
            logger.trace(" - createPrimitiveTypeRef {}", name);
            return parserRefs.of(type, validation);
        }
        List<String> enumValues = schemaParser.enumerationValues();

        String enumTypeName = naming.convertPropertyEnumTypeName(ri.propertyName);
        TypeName typeName = typeNames.of(enumTypeName);

        String name = typeName.name();
        logger.trace(" - createPrimitiveTypeRef enum {} {} {}", name, type, enumValues);
        return parserRefs.of(TypeEnum.of(typeName, type, enumValues), validation);
    }

    /**
     * Finds a primitive type matching the given OpenApi schema.
     *
     * @param sp the schema parser
     * @return the matching primitive, or null if no matches found
     */
    private @Nullable Primitive findPrimitive(SchemaParser sp) {
        String typeFormat = sp.type() + ":" + Objects.toString(sp.format(), "");
        for (var p : Primitive.values()) {
            if (p.openapiTypeFormat().equals(typeFormat)) {
                return p;
            }
        }
        return null;
    }

    @Nullable private ParserTypeRef createArrayRef(RefInfo ri) {
        SchemaParser sp = ri.schemaParser;
        if (sp.isArray()) {
            ParserTypeRef innerType = reference(sp.itemsSchema(), ri.propertyName, ri.parentDtoName);
            logger.trace(" - createArrayRef {}", innerType);

            if (sp.isUnique()) {
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
        if (ri.schemaParser().isBinary()) {
            logger.trace(" - createByteArrayRef");
            boolean isStream = ri.isFormRef || ri.propertyName == null;
            TypeByteArray impl = isStream ? TypeByteArray.getStream() : TypeByteArray.getArray();
            return parserRefs.of(impl, ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createMapRef(RefInfo ri) {
        SchemaParser sp = ri.schemaParser();
        if (sp.isMap()) {
            Type innerType = reference(sp.mapInnerSchema(), ri.propertyName, ri.parentDtoName);
            logger.trace(" - createMapRef inner type: {}", innerType.typeName().name());
            return parserRefs.of(TypeMap.of(typeNames, innerType), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createComposedValidation(RefInfo ri) {
        // FIXME:schema-parser
        if (ri.schema instanceof ComposedSchema cs && findTypeValidation(cs) instanceof ParserTypeRef ptr) {
            logger.trace(" - createComposedValidation");
            return ptr;
        }
        return null;
    }

    @Nullable private ParserTypeRef createAnyofRef(RefInfo ri) {
        SchemaParser sp = ri.schemaParser();
        if (sp.isAnyOf()) {
            logger.info("TRIGGER");

            // anyOf is classes implementing an interface
            List<ParserTypeRef> anyOfRefs =
                    sp.anyOfSchemas().stream().map(this::toReference).toList();
            List<String> anyOfNames = anyOfRefs.stream()
                    .map(ParserTypeRef::typeName)
                    .map(TypeName::name)
                    .sorted()
                    .toList();

            String interfaceName = sp.name();
            if (interfaceName == null) {
                interfaceName = String.join("_", anyOfNames);
            }

            TypeName tn = typeNames.of(naming.convertTypeName(interfaceName));

            logger.trace(" - createAnyofRef interface {} : {}", tn, anyOfRefs);

            TypeInterface ti = parserTypes.getOrMakeInterface(tn, anyOfRefs);
            return parserRefs.of(ti, ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createAllofRef(RefInfo ri) {
        SchemaParser sp = ri.schemaParser();
        Schema<?> schema = sp.schema();
        // FIXME:schema-parser
        if (schema instanceof ComposedSchema cs) {
            @SuppressWarnings("rawtypes")
            List<Schema> allOf = cs.getAllOf();

            if (allOf != null && !allOf.isEmpty()) {
                logger.trace("PROCESSING allOf:");

                String dtoName = ri.parentDtoName();
                String internalPropertyName;
                if (dtoName == null) {
                    internalPropertyName = null;
                } else {
                    internalPropertyName = Naming.PARSER_INTERNAL_PROPERTIES_NAME_MARKER + dtoName;
                }

                // Note the removal of duplicates, necessary for the allof_dups test
                List<ParserTypeRef> allOfRefs = allOf.stream()
                        .map(s -> reference(s, internalPropertyName, dtoName))
                        .distinct() // remove duplicates
                        .toList();

                if (allOfRefs.size() == 1) {
                    logger.trace(" - createAllofRef, shortcut for duplicate");
                    return parserRefs.of(allOfRefs.get(0), ri.validation);
                }

                if (dtoName != null) {
                    logger.trace(" - createAllofRef, composite: {}", allOfRefs);

                    ParserTypeComposite composite = ParserTypeComposite.of(typeNames.of(dtoName), allOfRefs);
                    return parserRefs.of(composite, ri.validation);
                }
            }
        }
        return null;
    }

    @Nullable private ParserTypeRef createOneofRef(RefInfo ri) {
        SchemaParser sp = ri.schemaParser();

        Schema<?> schema = sp.schema();

        if (sp.isOneOf()) {

            @SuppressWarnings("rawtypes")
            List<Schema> oneOf = sp.oneOfSchemas();
            if (oneOf != null && !oneOf.isEmpty()) {
                List<ParserTypeRef> oneOfRefs = oneOf.stream()
                        .map(Schema::get$ref)
                        .map(ref -> createDtoRef(ref, Validations.emptyValidation()))
                        .filter(Objects::nonNull)
                        .toList();

                if (schema.getDiscriminator() == null && !oneOfRefs.isEmpty()) {
                    // Handle oneof without descriminator
                    return createCombinedDto(ri, oneOfRefs);
                } else {
                    List<String> oneOfNames =
                            oneOf.stream().map(Schema::getName).toList();
                    logger.trace(" - createOneofRef {}", oneOfNames);

                    // regular object, but for now assumes there will
                    // be supplementary discriminator information
                    return parserRefs.of(TypeObject.get(), ri.validation);
                }
            }
        }
        return null;
    }

    private ParserTypeRef createCombinedDto(RefInfo ri, List<ParserTypeRef> oneOfRefs) {
        String syntheticSchemaName = ri.parentDtoName() + "-" + ri.propertyName();
        String dtoName = naming.convertTypeName(syntheticSchemaName);
        String mpName = naming.convertMpSchemaName(syntheticSchemaName);
        TypeName tn = typeNames.of(dtoName);
        logger.trace(" - createOneofRef combined {}", oneOfRefs);

        ParserTypeCombined combined = new ParserTypeCombined(tn, oneOfRefs);
        ParserTypeRef combinedRef = parserRefs.of(combined, ri.validation);

        Dto dto = Dto.builder(dtoName, tn)
                .mpSchemaName(mpName)
                .reference(combinedRef)
                .openapiId(tn)
                .isMultipartForm(false)
                .build();
        parserTypes.addDto(dto);

        return parserRefs.of(dto, ri.validation);
    }

    @Nullable private ParserTypeRef createNumberRef(RefInfo ri) {
        if (ri.schemaParser().isNumber()) {
            logger.trace(" - createNumberRef");
            return parserRefs.of(noFormatNumberType, ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createDateTimeRef(RefInfo ri) {
        if (ri.schemaParser().isDateTime(parserOpts.isFixupNullTypeDates())) {
            logger.trace(" - createDateTimeRef");
            return parserRefs.of(dateTimeType, ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createDateRef(RefInfo ri) {
        if (ri.schemaParser().isDate(parserOpts.isFixupNullTypeDates())) {
            logger.trace(" - createDateRef");
            return parserRefs.of(TypeDate.get(), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createTimeRef(RefInfo ri) {
        if (ri.schemaParser().isTime()) {
            logger.trace(" - createTimeRef");
            return parserRefs.of(TypeLocalTime.get(), ri.validation);
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
        if (ri.schemaParser().isString()) {
            logger.trace(" - createStringRef");
            return parserRefs.of(Primitive.STRING, ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createSupplementalValidation(RefInfo ri) {
        Schema<?> schema = ri.schema;
        // If not part of a DTO, and no type and reference, assume it is supplemental validation
        // information for the other type in a ComposedSchema.
        if (ri.parentDtoName == null
                && ri.schemaParser.type() == null
                && (schema.getProperties() == null || schema.getProperties().isEmpty())) {
            logger.trace(" - createSupplementalValidation");
            return parserRefs.of(TypeValidation.of(ri.validation), ri.validation);
        }
        return null;
    }

    @Nullable private ParserTypeRef createObjectRef(RefInfo ri) {
        Schema<?> schema = ri.schema;

        SchemaParser sp = ri.schemaParser();

        if (sp.isObject() || sp.type() == null) {
            boolean isPlainObject =
                    schema.getProperties() == null || schema.getProperties().isEmpty();
            if (ri.propertyName == null) {
                if (isPlainObject) {
                    logger.trace(" - createObjectRef, plain Object, no properties");
                    return parserRefs.of(TypePlainObject.get(), ri.validation);
                } else {
                    if (treatAsApiInlineTypeRef(ri)) {
                        return makeApiInlineTypeRef(ri);
                    } else {
                        // This fallback is used when creating plain DTOs - or references to them.
                        // Explore a better understanding and cleanup at some time...
                        logger.info(" - createObjectRef, plain Object?");
                        return parserRefs.of(TypeObject.get(), ri.validation);
                    }
                }
            }
            logger.trace(" - createObjectRef, inner-object for property {}", ri.propertyName);
            String dtoNamePrefix = isPlainObject ? "" : ri.parentDtoName;
            String syntheticDtoName = dtoNamePrefix + naming.convertTypeName(ri.propertyName);
            Dto dto = createDto(syntheticDtoName, schema);
            return parserRefs.of(dto, ri.validation);
        }

        logger.info("XXX {}", sp.name());

        return null;
    }

    private boolean treatAsApiInlineTypeRef(RefInfo ri) {
        ContentContext context = ri.context();
        if (context == null) {
            return false;
        }

        // Synchronization with ApiTransformer which may generate a synthetic multipart
        // DTO
        return !context.syntheticMultipart();
    }

    private ParserTypeRef makeApiInlineTypeRef(RefInfo ri) {

        ContentContext apiContext = Objects.requireNonNull(ri.context);

        Schema<?> schema = ri.schema;
        String resourcePath = apiContext.resourcePath();
        String pathSimplified = resourcePath.replaceAll("[/_{}]", "-");
        String dtoRawName = apiContext.location().name().toLowerCase(Locale.ROOT) + "-" + pathSimplified;
        String statusSuffix = "";
        StatusCode statuscode = apiContext.statuscode();
        if (statuscode != StatusCode.HTTP_DEFAULT && statuscode != StatusCode.HTTP_OK) {
            statusSuffix = "_" + statuscode.code();
        }
        String syntheticDtoName = "_" + naming.convertTypeName(dtoRawName) + statusSuffix;
        logger.trace("Inline response object for path {}: {}", resourcePath, syntheticDtoName);
        Dto dto = createDto(syntheticDtoName, schema);
        return parserRefs.of(dto, ri.validation);
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

        List<ParserTypeRef> allOfTypes = allOf.stream().map(this::toReference).toList();

        List<ParserTypeRef> refs = new ArrayList<>();
        List<Validation> validations = new ArrayList<>();
        for (ParserTypeRef ptr : allOfTypes) {
            if (ptr.refType() instanceof TypeValidation tv) {
                validations.add(tv.validation());
            } else if (!ptr.validation().isEmptyValidation()) {
                validations.add(ptr.validation());
            } else {
                refs.add(ptr);
            }
        }

        if (validations.size() != 1 || refs.size() != 1) {
            logger.warn(
                    "Unabled to handle allOf for {}/{}: {} with {}",
                    refs.size(),
                    validations.size(),
                    refs,
                    validations);
            String debugText = allOfTypes.stream().map(ParserTypeRef::toString).collect(Collectors.joining("\n "));
            logger.trace("INPUT :\n {}", debugText);
            // bail for now
            return TypeObject.get();
        }

        ParserTypeRef ref = refs.getFirst();
        Validation validation = validations.getFirst();

        logger.trace(" OUT - {}", ref);
        logger.trace(" OUT - {}", validation);

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

    /**
     * Creates a synthetic DTO for passing multipart form parameters.
     *
     * The name is controlled by the name of the method needing the DTO.
     *
     * @param groupOpId the group-operationid of the parent resource method
     * @param schema    the schema of the DTO
     * @return a reference to the created DTO
     */
    public ParserTypeRef createMultipartDto(String groupOpId, @SuppressWarnings("rawtypes") Schema schema) {
        String syntheticDtoName = naming.convertMultipartTypeName(groupOpId);
        Validation requiredValidation = Validation.validationRequired();

        logger.trace(" - createObjectRef, multipartform");
        @Nullable ParserTypeRef dtoRef = createDtoRef(REF_COMPONENTS_SCHEMAS + syntheticDtoName, requiredValidation);
        if (dtoRef == null) {
            throw new IllegalStateException("Failed to ref multipart dto");
        }

        Dto dto = createDto(syntheticDtoName, dtoRef, true, schema);
        return parserRefs.of(dto, requiredValidation);
    }

    /**
     * Creates a DTO from an Object schema.
     *
     * @param dtoName the DTO name
     * @param schema  the schema of the DTO
     * @return the create DTO
     */
    public Dto createDto(String dtoName, Schema<?> schema) {
        ParserTypeRef dtoType = reference(schema, null, dtoName);
        return createDto(dtoName, dtoType, false, schema);
    }

    /**
     * Creates a DTO from an Object schema.
     *
     * @param dtoName         the DTO name
     * @param dtoType         the DTO type
     * @param isMultipartForm a flag for synthetic multipart DTO
     * @param schema          the schema of the DTO
     * @return the create DTO
     */
    private Dto createDto(String dtoName, ParserTypeRef dtoType, boolean isMultipartForm, Schema<?> schema) {
        String modelName = naming.convertTypeName(dtoName);
        String mpSchemaName = naming.convertMpSchemaName(dtoName);

        logger.info("Parsing DTO {}", dtoName);
        Type refType = dtoType.refType();

        List<Property> directProps = readProperties(schema, modelName, isMultipartForm);
        List<Property> combinedProps = addInternalDtoProperties(refType, directProps);

        SubtypeSelector selector = null;
        Discriminator disc = schema.getDiscriminator();
        if (disc != null && disc.getMapping() != null) {
            Map<String, Reference> mapping = new HashMap<>();
            for (var e : disc.getMapping().entrySet()) {
                String discName = e.getKey();
                mapping.put(discName, createDtoRef(e.getValue(), Validations.emptyValidation()));
            }
            selector = SubtypeSelector.of(disc.getPropertyName(), mapping);
        }

        Dto dto = Dto.builder(modelName, typeNames.of(modelName))
                .mpSchemaName(mpSchemaName)
                .description(Optional.ofNullable(schema.getDescription()))
                .reference(dtoType)
                .properties(combinedProps)
                .openapiId(typeNames.of(dtoName))
                .enumValues(getEnumValues(schema))
                .implementsInterfaces(List.of())
                .subtypeSelector(Optional.ofNullable(selector))
                .extendsParents(List.of())
                .isMultipartForm(isMultipartForm)
                .build();

        parserTypes.addDto(dto);

        return dto;
    }

    private List<Property> addInternalDtoProperties(Type refType, List<Property> directProps) {
        if (refType instanceof ParserTypeComposite tc) {
            List<Property> compositeProps = tc.internalDtos().stream()
                    .flatMap(dto -> dto.properties().stream())
                    .toList();

            List<Property> combinedProps = new ArrayList<>(directProps);
            combinedProps.addAll(compositeProps);
            return combinedProps;
        } else {
            return directProps;
        }
    }

    private List<String> getEnumValues(@SuppressWarnings("rawtypes") Schema schema) {
        List<?> schemaEnumValues = schema.getEnum();
        if (schemaEnumValues == null) {
            return List.of();
        }

        return schemaEnumValues.stream().map(Object::toString).toList();
    }

    private List<Property> readProperties(Schema<?> schema, String parentDtoName, boolean isMultipartForm) {
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

            Reference ref = reference(propSchema, propertyName, parentDtoName, isMultipartForm, null);

            Optional<String> exampleStr = Optional.ofNullable(Objects.toString(propSchema.getExample(), null));

            logger.debug("   ref: {}", ref);
            logger.debug("   example: {}", exampleStr);

            Validation validation =
                    Validations.extractValidation(propSchema, requiredProperyNames.contains(propertyName));

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
