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
import dk.mada.jaxrs.generator.imports.Imports;
import dk.mada.jaxrs.generator.imports.Jackson;
import dk.mada.jaxrs.generator.imports.JavaIo;
import dk.mada.jaxrs.generator.imports.UserMappedImport;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.SubtypeSelector;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeInterface;

/**
 * DTO generator.
 *
 * Processes the model's DTOs and prepares DTO contexts for template rendering.
 */
public class DtoGenerator {
    private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

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
    /** List of DTO types to skip when generating. */
    private final List<String> skippedDtoClasses;
    /** Enumeration generator. */
    private final EnumGenerator enumGenerator;
    /** Property generator. */
    private PropertyGenerator propertyGenerator;

    /**
     * Constructs a new generator.
     *
     * @param opts      the generator options
     * @param templates the templates instance
     * @param model     the data model
     */
    public DtoGenerator(GeneratorOpts opts, Templates templates, Model model) {
        this.opts = opts;
        this.templates = templates;
        this.model = model;

        dtos = model.dtos();
        externalTypeMapping = opts.getExternalTypeMapping();
        skippedDtoClasses = opts.getSkippedDtoClasses();

        Naming naming = model.naming();
        enumGenerator = new EnumGenerator(naming, opts);
        propertyGenerator = new PropertyGenerator(naming, opts, enumGenerator);
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

                    if (skippedDtoClasses.contains(name)) {
                        logger.info(" skipped DTO  {}", name);
                    } else if (mappedToExternalType != null) {
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
                .jacksonFasterxml(opts.isJackson())
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

        DtoSubject ds = new DtoSubject(dto, dtoType, findRenderedProperties(dto), dtoImports);

        Optional<String> extendsName = getExtends(dto);

        List<CtxProperty> props = createCtxProps(ds);
        // in original order
        List<CtxProperty> propsOpenapiOrder = getPropsOpenApiOrder(ds, props);

        dtoImports.addPropertyImports(ds.properties());

        CustomSerializers localDateSerializers = defineLocalDateSerializer(ds);
        CustomSerializers customOffsetDateSerializers = customDateTimeSerializers(ds);

        Optional<String> description = dto.description();

        Optional<String> enumSchema = Optional.empty();
        CtxEnum ctxEnum = null;
        if (isEnum) {
            List<String> enumValues = dto.enumValues();
            ctxEnum = enumGenerator.toCtxEnum(dtoType, enumValues);
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

        if (discriminator.isPresent() && opts.isJackson()) {
            // Needs adaptor for jsonb
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
                .varsOpenapiOrder(propsOpenapiOrder)
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
                .parent(extendsName)
                .isNullable(false)
                .vendorExtensions(null)

                .vars(props)

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

    /**
     * Compute if the Dto should extend a parent.
     *
     * This is only relevant if the Dto has exactly one parent Dto.
     *
     * Otherwise the properties of parent Dtos will be folded into the Dto.
     *
     * @param dto the Dto to compute extends for.
     * @return an optional parent Dto name
     * @see findRenderedProperties
     */
    private Optional<String> getExtends(Dto dto) {
        if (dto.extendsParents().size() == 1) {
            return Optional.of(dto.extendsParents().get(0).name());
        }
        return Optional.empty();
    }

    /**
     * Returns list of properties to render for the Dto.
     *
     * If the Dto has multiple parents, the properties of these parents are folded into this Dto's properties (because it
     * cannot extend multiple parents).
     *
     * @param dto the Dto to get properties for
     * @return the properties to be rendered for the Dto
     */
    private List<Property> findRenderedProperties(Dto dto) {
        List<Property> combinedProps = new ArrayList<>(dto.properties());

        // If this Dto extends more than one other Dto
        // it cannot be done in Java. So fold properties
        // from the parents into this Dto.
        List<Dto> externalDtos = dto.extendsParents();
        if (externalDtos.size() > 1) {
            externalDtos.stream()
                    .map(Dto::properties)
                    .forEach(combinedProps::addAll);

            if (logger.isDebugEnabled()) {
                List<String> extendsParentNames = externalDtos.stream()
                        .map(Dto::name)
                        .toList();

                logger.debug(" - {} now comines properties from {}", dto.name(), extendsParentNames);
            }
        }

        return combinedProps;
    }

    private List<CtxProperty> createCtxProps(DtoSubject ds) {
        Comparator<? super CtxProperty> propertySorter = propertySorter();

        Stream<CtxProperty> props = ds.properties().stream()
                .map(p -> propertyGenerator.toCtxProperty(ds.imports(), p));

        if (propertySorter != null) {
            props = props.sorted(propertySorter);
        }
        return props.toList();
    }

    private List<CtxProperty> getPropsOpenApiOrder(DtoSubject ds, List<CtxProperty> props) {
        // Make the context properties accessible by name
        Map<String, CtxProperty> byName = props.stream()
                .collect(Collectors.toMap(CtxProperty::baseName, p -> p));

        // Then map the openapi properties to context properties, keeping the order
        return ds.properties().stream()
                .map(p -> byName.get(p.name()))
                .toList();
    }

    private record CustomSerializers(@SuppressWarnings("unused") Optional<String> deserializer,
            @SuppressWarnings("unused") Optional<String> serializer) {
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

    private boolean isTypePrimitiveEquals(Type t) {
        return t.isPrimitive(Primitive.INT);
    }
}
