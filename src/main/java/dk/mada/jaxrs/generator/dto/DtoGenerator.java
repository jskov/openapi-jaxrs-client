package dk.mada.jaxrs.generator.dto;

import static dk.mada.jaxrs.generator.StringRenderer.consumeNonBlankEncoded;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.ExtraTemplate;
import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.GeneratorOpts.PropertyOrder;
import dk.mada.jaxrs.generator.StringRenderer;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDto;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDtoDiscriminator;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDtoExt;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.dto.tmpl.CtxExtraDateSerializer;
import dk.mada.jaxrs.generator.dto.tmpl.CtxInterface;
import dk.mada.jaxrs.generator.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.dto.tmpl.CtxPropertyExt;
import dk.mada.jaxrs.generator.imports.Imports;
import dk.mada.jaxrs.generator.imports.Jackson;
import dk.mada.jaxrs.generator.imports.JavaIo;
import dk.mada.jaxrs.generator.imports.JavaMath;
import dk.mada.jaxrs.generator.imports.JavaUtil;
import dk.mada.jaxrs.generator.imports.UserMappedImport;
import dk.mada.jaxrs.generator.imports.ValidationApi;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.SubtypeSelector;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeContainer;
import dk.mada.jaxrs.model.types.TypeEnum;
import dk.mada.jaxrs.model.types.TypeInterface;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.openapi.OpenapiGeneratorUtils;

/**
 * DTO generator.
 *
 * Processes the model's DTOs and prepares DTO contexts for template rendering.
 */
public class DtoGenerator {
    private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

    /** Naming. */
    private final Naming naming;
    /** Types. */
    private final Dtos dtos;
    /** Generator options. */
    private final GeneratorOpts opts;
    /** Templates. */
    private final Templates templates;
    /** The data model. */
    private final Model model;

    /**
     * The extra templates to render.
     *
     * New templates are added as DTOs are generated.
     **/
    private final EnumSet<ExtraTemplate> extraTemplates = EnumSet.noneOf(ExtraTemplate.class);

    /** External type mapping. */
    private final Map<String, UserMappedImport> externalTypeMapping;

    /** Enumeration generator. */
    private final EnumGenerator enumGenerator;

    /**
     * Constructs a new generator.
     *
     * @param naming    the naming instance
     * @param opts      the generator options
     * @param templates the templates instance
     * @param model     the data model
     */
    public DtoGenerator(Naming naming, GeneratorOpts opts, Templates templates, Model model) {
        this.naming = naming;
        this.opts = opts;
        this.templates = templates;
        this.model = model;

        dtos = model.dtos();
        externalTypeMapping = opts.getExternalTypeMapping();

        enumGenerator = new EnumGenerator(naming, opts);
    }

    /**
     * Generate all DTO classes.
     */
    public void generateDtoClasses() {
        dtos.getActiveDtos().stream()
                .sorted((a, b) -> a.name().compareTo(b.name()))
                .forEach(type -> {
                    String name = type.name();

                    UserMappedImport mappedToExternalType = externalTypeMapping.get(name);
                    if (mappedToExternalType != null) {
                        logger.info(" skipped DTO  {}, mapped to {}", name, mappedToExternalType);
                    } else {
                        logger.info(" generate DTO {}", name);

                        CtxDto ctx = toCtx(type);
                        logger.debug("{} ctx: {}", name, ctx);

                        templates.renderDtoTemplate(ctx);
                    }
                });

        extraTemplates.forEach(tmpl -> {
            logger.info(" generate extra {}", tmpl);

            CtxExtraDateSerializer ctx = makeCtxExtra(tmpl);
            templates.renderExtraTemplate(tmpl, ctx);
        });

        model.interfaces().forEach(ti -> {
            logger.info(" generate interface {}", ti.typeName().name());

            CtxInterface ctx = makeCtxInterface(ti);
            templates.renderInterfaceTemplate(ctx);
        });
    }

    private CtxInterface makeCtxInterface(TypeInterface ti) {
        var imports = Imports.newInterface(opts);

        String implementations = ti.implementations().stream()
                .map(tn -> tn.name() + ".class")
                .sorted()
                .collect(joining(", "));

        Info info = model.info();
        return CtxInterface.builder()
                .classname(ti.typeName().name())
                .appDescription(info.description())
                .appName(info.title())
                .version(info.version())
                .infoEmail(info.contact().email())
                .generatedAnnotationClass(opts.getGeneratorAnnotationClass())
                .generatedDate(opts.getGeneratedAtTime())
                .generatorClass(opts.generatorId())
                .imports(imports.get())
                .packageName(opts.dtoPackage())
                .implementations(implementations)
                .build();
    }

    private CtxExtraDateSerializer makeCtxExtra(ExtraTemplate tmpl) {
        var imports = Imports.newExtras(opts, tmpl);

        Info info = model.info();
        String classname = tmpl.classname();
        return CtxExtraDateSerializer.builder()
                .className(classname)
                .deserializer(tmpl.isDeserializer())
                .renderLocalDate(tmpl.isLocalDate())
                .renderLocalDateTime(tmpl.isLocalDateTime())
                .renderOffsetDateTime(tmpl.isOffsetDateTime())
                .appName(info.title())
                .appDescription(info.description())
                .version(info.version())
                .infoEmail(info.contact().email())
                .generatedAnnotationClass(opts.getGeneratorAnnotationClass())
                .generatedDate(opts.getGeneratedAtTime())
                .generatorClass(opts.generatorId())
                .imports(imports.get())
                .jacksonCodehaus(opts.isJacksonCodehaus())
                .jacksonFasterxml(opts.isJacksonFasterxml())
                .jsonb(opts.isJsonb())
                .packageName(opts.dtoPackage())
                .cannedLocalDateSerializerDTF(opts.getJacksonLocalDateWireFormat())
                .cannedLocalDateTimeSerializerDTF(opts.getJacksonLocalDateTimeWireFormat())
                .cannedOffsetDateTimeSerializerDTF(opts.getJacksonOffsetDateTimeWireFormat())
                .build();
    }

    record DtoSubject(Dto dto, Type type, List<Property> properties, Imports imports) {
    }

    private CtxDto toCtx(Dto dto) {
        Info info = model.info();
        Type dtoType = dto.reference().refType();

        boolean isEnum = dto.isEnum();
        var dtoImports = isEnum ? Imports.newEnum(opts, !isTypePrimitiveEquals(dtoType)) : Imports.newDto(opts);

        DtoSubject ds = new DtoSubject(dto, dtoType, dto.properties(), dtoImports);

        List<CtxProperty> vars = getVars(ds);
        // in original order
        List<CtxProperty> varsOpenapiOrder = getVarsOpenApiOrder(ds, vars);

        dtoImports.addPropertyImports(dto.properties());

        CustomSerializers localDateSerializers = defineLocalDateSerializer(ds);
        CustomSerializers customOffsetDateSerializers = customDateTimeSerializers(ds);

        Optional<String> description = dto.description();

        Optional<String> enumSchema = Optional.empty();
        CtxEnum ctxEnum = null;
        if (isEnum) {
            List<String> enumValues = dto.enumValues();
            ctxEnum = enumGenerator.buildEnumEntries(dtoType, enumValues);
            enumSchema = enumGenerator.buildEnumSchema(dtoImports, dtoType, ctxEnum);
        }

        List<String> schemaEntries = new ArrayList<>();
        if (!Objects.equals(dto.mpSchemaName(), dto.name())) {
            schemaEntries.add("name = \"" + dto.mpSchemaName() + "\"");
        }
        enumSchema.ifPresent(schemaEntries::add);

        consumeNonBlankEncoded(description, d -> schemaEntries.add("description = \"" + d + "\""));

        String schemaOptions = null;
        if (!schemaEntries.isEmpty()) {
            schemaOptions = String.join(", ", schemaEntries);
            dtoImports.addMicroProfileSchema();
        }

        Optional<String> implementsInterfaces = defineInterfaces(dto, dtoImports);

        Optional<SubtypeSelector> subtypeSelector = dto.subtypeSelector();

        String classModifiers = null;
        if (subtypeSelector.isPresent()) {
            classModifiers = "abstract ";
        }

        Optional<CtxDtoDiscriminator> discriminator = subtypeSelector
                .map(this::buildSubtypeDiscriminator);

        if (discriminator.isPresent()
                && opts.isJacksonFasterxml()) {
            // Needs adaptor for jsonb and tweaks for codehaus
            dtoImports.add(Jackson.JSON_IGNORE_PROPERTIES, Jackson.JSON_SUB_TYPES, Jackson.JSON_TYPE_INFO);
        }

        CtxDtoExt mada = CtxDtoExt.builder()
                .jacksonJsonSerializeOptions(opts.getJsonSerializeOptions())
                .jsonb(opts.isJsonb())
                .customLocalDateDeserializer(localDateSerializers.deserializer())
                .customLocalDateSerializer(localDateSerializers.serializer())
                .customOffsetDateTimeDeserializer(customOffsetDateSerializers.deserializer())
                .customOffsetDateTimeSerializer(customOffsetDateSerializers.serializer())
                .schemaOptions(schemaOptions)
                .implementsInterfaces(implementsInterfaces)
                .isEqualsPrimitive(isTypePrimitiveEquals(dtoType))
                .quarkusRegisterForReflection(opts.isUseRegisterForReflection())
                .varsOpenapiOrder(varsOpenapiOrder)
                .classModifiers(Optional.ofNullable(classModifiers))
                .isEnumUnknownDefault(opts.isUseEnumUnknownDefault())
                .isRenderPropertyOrderAnnotation(opts.isUsePropertyOrderAnnotation())
                .build();

        return CtxDto.builder()
                .appName(info.title())
                .appDescription(info.description())
                .version(info.version())
                .infoEmail(info.contact().email())

                .imports(dtoImports.get())

                .description(description.flatMap(StringRenderer::makeValidDtoJavadocSummary))
                .packageName(opts.dtoPackage())
                .classname(dto.name())
                .classVarName("other")
                .datatypeWithEnum(null)
                .parent(dto.parent().map(Dto::name))
                .isNullable(false)
                .vendorExtensions(null)

                .vars(vars)

                .allowableValues(ctxEnum)
                .dataType(dtoType.typeName().name())

                .jackson(opts.isJackson())

                .generatedAnnotationClass(opts.getGeneratorAnnotationClass())
                .generatorClass(opts.generatorId())
                .generatedDate(opts.getGeneratedAtTime())

                .madaDto(mada)
                .discriminator(discriminator)

                .build();
    }

    private List<CtxProperty> getVars(DtoSubject ds) {
        Comparator<? super CtxProperty> propertySorter = propertySorter();

        Stream<CtxProperty> props = ds.properties().stream()
                .map(p -> toCtxProperty(ds.imports(), p));

        if (propertySorter != null) {
            props = props.sorted(propertySorter);
        }
        return props.toList();
    }

    private List<CtxProperty> getVarsOpenApiOrder(DtoSubject ds, List<CtxProperty> vars) {
        // Make the context properties accessible by name
        Map<String, CtxProperty> byName = vars.stream()
                .collect(Collectors.toMap(CtxProperty::baseName, p -> p));

        // Then map the openapi properties to context properties, keeping the order
        return ds.properties().stream()
                .map(p -> byName.get(p.name()))
                .toList();
    }

    private record CustomSerializers(Optional<String> deserializer, Optional<String> serializer) {
    }

    private CustomSerializers defineLocalDateSerializer(DtoSubject ds) {
        Optional<String> deserializer = Optional.empty();
        Optional<String> serializer = Optional.empty();

        if (opts.isUseJacksonLocalDateSerializer()
                && (ds.type().isDate()
                        || ds.dto().properties().stream().anyMatch(p -> p.reference().isDate()))) {
            if (opts.isAddJacksonLocalDateDeserializerTemplate()) {
                extraTemplates.add(ExtraTemplate.LOCAL_DATE_JACKSON_DESERIALIZER);
            }
            deserializer = opts.getJacksonLocalDateDeserializer();

            if (opts.isAddJacksonLocalDateSerializerTemplate()) {
                extraTemplates.add(ExtraTemplate.LOCAL_DATE_JACKSON_SERIALIZER);
            }
            serializer = opts.getJacksonLocalDateSerializer();

            ds.imports().add(Jackson.JSON_DESERIALIZE, Jackson.JSON_SERIALIZE);
        }

        return new CustomSerializers(deserializer, serializer);
    }

    private CustomSerializers customDateTimeSerializers(DtoSubject ds) {
        if (opts.isUseJacksonDateTimeSerializer()
                && (ds.type().isDateTime()
                        || ds.properties().stream().anyMatch(p -> p.reference().isDateTime()))) {

            ds.imports().add(Jackson.JSON_DESERIALIZE, Jackson.JSON_SERIALIZE);

            if (opts.isUseLocalDateTime()) {
                return customLocalDateTimeSerializers();
            } else { // is UseOffsetDateTime
                return customOffsetDateTimeSerializers();
            }
        }

        return new CustomSerializers(Optional.empty(), Optional.empty());
    }

    private CustomSerializers customLocalDateTimeSerializers() {
        if (opts.isAddJacksonLocalDateTimeDeserializerTemplate()) {
            extraTemplates.add(ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER);
        }
        if (opts.isAddJacksonLocalDateTimeSerializerTemplate()) {
            extraTemplates.add(ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER);
        }
        return new CustomSerializers(opts.getJacksonLocalDateTimeDeserializer(), opts.getJacksonLocalDateTimeSerializer());
    }

    private CustomSerializers customOffsetDateTimeSerializers() {
        if (opts.isAddJacksonOffsetDateTimeDeserializerTemplate()) {
            extraTemplates.add(ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER);
        }
        if (opts.isAddJacksonOffsetDateTimeSerializerTemplate()) {
            extraTemplates.add(ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER);
        }
        return new CustomSerializers(opts.getJacksonOffsetDateTimeDeserializer(), opts.getJacksonOffsetDateTimeSerializer());
    }

    private CtxDtoDiscriminator buildSubtypeDiscriminator(SubtypeSelector subtypeSelector) {
        CtxDtoDiscriminator discriminator;
        Map<String, String> vendorExt = null;
        List<CtxDtoDiscriminator.ModelMapping> mapping = subtypeSelector.typeMapping().entrySet().stream()
                .map(e -> new CtxDtoDiscriminator.ModelMapping(e.getValue().typeName().name(), e.getKey(), vendorExt))
                .sorted((a, b) -> a.modelName().compareTo(b.modelName()))
                .toList();
        discriminator = CtxDtoDiscriminator.builder()
                .propertyBaseName(subtypeSelector.propertyName())
                .mappedModels(mapping)
                .build();
        return discriminator;
    }

    private @Nullable Comparator<? super CtxProperty> propertySorter() {
        PropertyOrder propertyOrder = opts.getPropertyOrder();
        switch (propertyOrder) {
        case DOCUMENT_ORDER:
            return null;
        case ALPHABETICAL_ORDER:
            return (a, b) -> a.name().compareTo(b.name());
        case ALPHABETICAL_NOCASE_ORDER:
            return (a, b) -> a.name().compareToIgnoreCase(b.name());
        default:
            throw new IllegalStateException("Unhandled ordering " + propertyOrder);
        }
    }

    private Optional<String> defineInterfaces(Dto dto, Imports dtoImports) {
        Stream<String> serializableInterface;
        if (opts.isUseSerializable() && !dto.isEnum()) {
            serializableInterface = Stream.of("Serializable");
            dtoImports.add(JavaIo.IO_SERIALIZABLE);
        } else {
            serializableInterface = Stream.of();
        }
        Stream<String> dtoInterfaces = dto.implementsInterfaces().stream()
                .map(ti -> ti.typeName().name());
        String implementsInterfaces = Stream.concat(serializableInterface, dtoInterfaces)
                .sorted()
                .collect(joining(", "));
        if (implementsInterfaces.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(implementsInterfaces);
    }


    private CtxProperty toCtxProperty(Imports dtoImports, Property p) {
        final String name = p.name();
        final String varName = naming.convertPropertyName(name);

        String nameCamelized = OpenapiGeneratorUtils.camelize(varName);
        String nameSnaked = OpenapiGeneratorUtils.underscore(nameCamelized).toUpperCase();
        // Both Jackson (Fasterxml) and JsonBinding expect the getter
        // of a 'xX'-prefixed field to be named 'getxX'. Although
        // this is different from Bean Spec naming for getters/setters.
        //
        // See https://github.com/FasterXML/jackson-databind/blob/2.15...
        // /src/main/java/com/fasterxml/jackson/databind/introspect...
        // /DefaultAccessorNamingStrategy.java#L182
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1))) {
            nameCamelized = Character.toLowerCase(name.charAt(0)) + nameCamelized.substring(1);
        }

        logger.debug("Property {} -> {} / {} / {}", name, varName, nameCamelized, nameSnaked);

        Type propType = p.reference().refType();
        logger.trace(" {}", propType);

        String defaultValue = null;
        boolean isRequired = p.isRequired();
        boolean isByteArray = false;
        boolean isArray = false;
        boolean isMap = false;
        boolean isSet = false;
        boolean isDate = propType.isDate();
        boolean isDateTime = propType.isDateTime();
        boolean isEnum = false;
        String innerTypeName = null;
        CtxEnum ctxEnum = null;
        Type innerType = null;

        if (propType instanceof TypeByteArray) {
            isByteArray = true;
            dtoImports.add(JavaUtil.ARRAYS);
            if (isRequired) {
                defaultValue = "new byte[] {}";
            }
        }
        if (propType instanceof TypeArray ca) {
            isArray = true;
            innerType = ca.innerType();
            defaultValue = "new " + ca.containerImplementation() + "<>()";
        }
        if (propType instanceof TypeMap cm) {
            isMap = true;
            innerType = cm.innerType();
            defaultValue = "new " + cm.containerImplementation() + "<>()";
        }
        if (propType instanceof TypeSet cs) {
            isSet = true;
            innerType = cs.innerType();
            defaultValue = "new " + cs.containerImplementation() + "<>()";

            // In templates, array is used for both set and list
            isArray = true;
        }
        if (propType.isEnum()) {
            innerType = propType;
        }

        if (innerType != null) {
            innerTypeName = innerType.typeName().name();
        }

        final String typeName = propType.wrapperTypeName().name();
        final boolean isContainer = isArray || isMap || isSet;
        String enumClassName = typeName;
        String enumTypeName = typeName;
        Optional<String> enumSchema = Optional.empty();

        if (getDereferencedInnerEnumType(innerType)instanceof TypeEnum te) {
            isEnum = true;
            Type enumType = te.innerType();
            enumTypeName = enumType.typeName().name();
            enumClassName = te.typeName().name();
            dtoImports.addEnumImports(!isContainer, !isTypePrimitiveEquals(enumType));

            ctxEnum = enumGenerator.buildEnumEntries(enumType, te.values());
            enumSchema = enumGenerator.buildEnumSchema(dtoImports, enumType, ctxEnum);

            logger.debug(" enum {} : {}", innerTypeName, te.values());
        }

        // Add import if required
        UserMappedImport externalType = externalTypeMapping.get(typeName);
        if (externalType != null) {
            dtoImports.add(externalType);
        }
        if (innerTypeName != null) {
            UserMappedImport innerExternalType = externalTypeMapping.get(innerTypeName);
            if (innerExternalType != null) {
                dtoImports.add(innerExternalType);
            }
        }

        String getterPrefix = getterPrefix(p);
        String getter = getterPrefix + nameCamelized;
        String setter = "set" + nameCamelized;
        String extGetter = getter;
        String extSetter = setter;
        boolean isUseBigDecimalForDouble = opts.isUseBigDecimalForDouble()
                && propType.isPrimitive(Primitive.DOUBLE);
        if (isUseBigDecimalForDouble) {
            getter = getter + "Double";
            setter = setter + "Double";

            dtoImports.add(Jackson.JSON_IGNORE);
            dtoImports.add(JavaMath.BIG_DECIMAL);
        }

        Optional<String> description = p.description();

        boolean isUseEmptyCollections = opts.isUseEmptyCollections()
                && isContainer
                && !isRequired;
        if (isUseEmptyCollections) {
            dtoImports.add(Jackson.JSON_IGNORE);
            getter = getter + "Nullable";
        }

        List<String> schemaEntries = new ArrayList<>();
        if (isRequired) {
            schemaEntries.add("required = true");
        }
        if (p.isNullable()) {
            schemaEntries.add("nullable = true");
        }
        if (p.isReadonly()) {
            schemaEntries.add("readOnly = true");
        }
        consumeNonBlankEncoded(description, d -> schemaEntries.add("description = \"" + d + "\""));
        consumeNonBlankEncoded(p.example(), e -> schemaEntries.add("example = \"" + e + "\""));

        Optional<String> schemaOptions = Optional.empty();
        if (!schemaEntries.isEmpty()) {
            schemaOptions = Optional.of(String.join(", ", schemaEntries));
            dtoImports.addMicroProfileSchema();
        }

        boolean useBeanValidation = opts.isUseBeanValidation();
        boolean valid = false;
        Optional<String> minLength = Optional.empty();
        Optional<String> maxLength = Optional.empty();
        Optional<String> minimum = Optional.empty();
        Optional<String> maximum = Optional.empty();
        Optional<String> decimalMinimum = Optional.empty();
        Optional<String> decimalMaximum = Optional.empty();
        Optional<String> pattern = Optional.empty();
        if (useBeanValidation) {
            if (p.isRequired()) {
                dtoImports.add(ValidationApi.NOT_NULL);
            }
            // Decide where to put @Valid. I expect this to be too simple...
            if (propType.isDto()
                    || (propType instanceof TypeContainer tc && tc.innerType().isDto())) {
                valid = true;
                dtoImports.add(ValidationApi.VALID);
            }

            // Note that OpenApi specification xItems/xLength both map to @Size
            minLength = p.minItems()
                    .or(p::minLength)
                    .map(i -> Integer.toString(i)); // NOSONAR - not enough information to select variant
            if (minLength.isPresent()) {
                dtoImports.add(ValidationApi.SIZE);
            }
            maxLength = p.maxItems()
                    .or(p::maxLength)
                    .map(i -> Integer.toString(i)); // NOSONAR - not enough information to select variant
            if (maxLength.isPresent()) {
                dtoImports.add(ValidationApi.SIZE);
            }

            if (propType.isBigDecimal()) {
                decimalMinimum = p.minimum()
                        .map(min -> "\"" + min.toString() + "\"");
                decimalMaximum = p.maximum()
                        .map(max -> "\"" + max.toString() + "\"");
            } else {
                minimum = p.minimum()
                        .map(min -> Long.toString(min.longValue()));
                maximum = p.maximum()
                        .map(max -> Long.toString(max.longValue()));
            }
            if (decimalMinimum.isPresent()) {
                dtoImports.add(ValidationApi.DECIMAL_MIN);
            }
            if (minimum.isPresent()) {
                dtoImports.add(ValidationApi.MIN);
            }
            if (decimalMinimum.isPresent()) {
                dtoImports.add(ValidationApi.DECIMAL_MAX);
            }
            if (maximum.isPresent()) {
                dtoImports.add(ValidationApi.MAX);
            }

            pattern = p.pattern()
                    .map(StringRenderer::encodeRegexp);
            if (pattern.isPresent()) {
                dtoImports.add(ValidationApi.PATTERN);
            }
        }

        CtxPropertyExt mada = CtxPropertyExt.builder()
                .innerDatatypeWithEnum(innerTypeName)
                .enumClassName(enumClassName)
                .enumTypeName(enumTypeName)
                .enumSchemaOptions(enumSchema)
                .schemaOptions(schemaOptions)
                .isUseBigDecimalForDouble(isUseBigDecimalForDouble)
                .isUseEmptyCollections(isUseEmptyCollections)
                .isByteArray(isByteArray)
                .isEqualsPrimitive(isTypePrimitiveEquals(propType))
                .getter(extGetter)
                .setter(extSetter)
                .jsonb(opts.isJsonb())
                .valid(valid)
                .renderJavadocMacroSpacer(description.isPresent())
                .build();

        CtxProperty prop = CtxProperty.builder()
                .baseName(name)
                .datatypeWithEnum(typeName)
                .dataType(innerTypeName)
                .name(varName)
                .nameInCamelCase(nameCamelized)
                .nameInSnakeCase(nameSnaked)
                .getter(getter)
                .setter(setter)
                .description(description.flatMap(StringRenderer::makeValidPropertyJavadocSummary))
                .isArray(isArray)
                .isEnum(isEnum)
                .isMap(isMap)
                .isSet(isSet)
                .isContainer(isContainer)
                .isDate(isDate)
                .isDateTime(isDateTime)
                .defaultValue(defaultValue)
                .required(isRequired)
                .example(p.example())
                .allowableValues(ctxEnum)
                .useBeanValidation(useBeanValidation)
                .minLength(minLength)
                .maxLength(maxLength)
                .minimum(minimum)
                .maximum(maximum)
                .decimalMinimum(decimalMinimum)
                .decimalMaximum(decimalMaximum)
                .pattern(pattern)
                .madaProp(mada)
                .build();

        logger.debug("property {} : {}", name, prop);
        return prop;
    }

    private boolean isTypePrimitiveEquals(Type t) {
        return t.isPrimitive(Primitive.INT);
    }

    private @Nullable Type getDereferencedInnerEnumType(@Nullable Type t) {
        if (t instanceof TypeReference tr) {
            return tr.refType();
        }
        return t;
    }

    private String getterPrefix(Property p) {
        boolean isBoolean = p.reference().isPrimitive(Primitive.BOOLEAN);
        String getterPrefix = "get";
        if (isBoolean && !opts.isUseBooleanGetPrefix()) {
            getterPrefix = "is";
        }
        return getterPrefix;
    }
}
