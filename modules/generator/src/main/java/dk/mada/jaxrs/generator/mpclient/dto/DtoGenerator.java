package dk.mada.jaxrs.generator.mpclient.dto;

import static dk.mada.jaxrs.generator.mpclient.StringRenderer.consumeNonBlankEncoded;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.mpclient.ExtraTemplate;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.StringRenderer;
import dk.mada.jaxrs.generator.mpclient.Templates;
import dk.mada.jaxrs.generator.mpclient.dto.DtoSubjectDefiner.DtoSubject;
import dk.mada.jaxrs.generator.mpclient.dto.DtoSubjectDefiner.DtoSubjectBase;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxDto;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxDtoDiscriminator;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxDtoExt;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxExtraDateSerializer;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxInterface;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.Jackson;
import dk.mada.jaxrs.generator.mpclient.imports.JavaIo;
import dk.mada.jaxrs.generator.mpclient.imports.JavaUtil;
import dk.mada.jaxrs.generator.mpclient.imports.UserMappedImport;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.SubtypeSelector;
import dk.mada.jaxrs.model.naming.Naming;
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
    /** DTO subject definer. */
    private DtoSubjectDefiner dtoSubjectDefiner;

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
        PropertyConverter propertyConverter = new PropertyConverter(opts, propertyGenerator);
        dtoSubjectDefiner = new DtoSubjectDefiner(opts, propertyConverter);
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
                        CtxDto ctx = toCtx(type);
                        logger.debug("{} ctx: {}", name, ctx);

                        templates.renderDtoTemplate(ctx);
                    }
                });

        extraTemplates.forEach(tmpl -> {
            CtxExtraDateSerializer ctx = makeCtxExtra(tmpl);
            templates.renderExtraTemplate(tmpl, ctx);
        });

        model.interfaces().forEach(ti -> {
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
                .renderSchema(opts.getUseOpenapiSchema())
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

    private CtxDto toCtx(Dto dto) {
        DtoSubject ds = dtoSubjectDefiner.defineDtoSubject(dto);
        DtoSubjectBase dsb = ds.base();

        CustomSerializers localDateSerializers = defineLocalDateSerializer(ds);
        CustomSerializers customOffsetDateSerializers = customDateTimeSerializers(ds);

        Optional<String> description = dto.description();

        Optional<String> enumSchema = Optional.empty();
        CtxEnum ctxEnum = null;
        if (dsb.isEnum()) {
            List<String> enumValues = dto.enumValues();
            ctxEnum = enumGenerator.toCtxEnum(ds.type(), enumValues);
            enumSchema = enumGenerator.buildEnumSchemaForType(ds.base(), ds.type(), ctxEnum);
        }

        List<String> schemaEntries = new ArrayList<>();
        if (!Objects.equals(dto.mpSchemaName(), dto.name())) {
            schemaEntries.add("name = \"" + dto.mpSchemaName() + "\"");
        }
        enumSchema.ifPresent(schemaEntries::add);

        consumeNonBlankEncoded(description, d -> schemaEntries.add("description = \"" + d + "\""));

        String schemaOptions = null;
        if (opts.getUseOpenapiSchema() && !schemaEntries.isEmpty()) {
            schemaOptions = String.join(", ", schemaEntries);
            ds.imports().addMicroProfileSchema();
        }

        Optional<String> implementsInterfaces = defineInterfaces(ds);

        String classModifiers = null;
        if (ds.subtypeSelector().isPresent()) {
            classModifiers = "abstract ";
        }

        Optional<CtxDtoDiscriminator> discriminator = ds.subtypeSelector()
                .map(this::buildSubtypeDiscriminator);

        if (discriminator.isPresent() && opts.isJackson()) {
            // Needs adaptor for jsonb
            ds.imports().add(Jackson.JSON_IGNORE_PROPERTIES, Jackson.JSON_SUB_TYPES, Jackson.JSON_TYPE_INFO);
        }

        boolean recordCanonicalConstructor =
                opts.isUseRecordsRequireNull()
                && ds.ctxProps().stream().anyMatch(CtxProperty::notNull);
        if (recordCanonicalConstructor) {
            ds.imports().add(JavaUtil.OBJECTS);
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
                .isEqualsPrimitive(ds.isPrimitiveEquals())
                .quarkusRegisterForReflection(opts.isUseRegisterForReflection())
                .varsOpenapiOrder(ds.ctxPropsOpenApiOrder())
                .classModifiers(Optional.ofNullable(classModifiers))
                .isEnumUnknownDefault(opts.isUseEnumUnknownDefault())
                .isRenderPropertyOrderAnnotation(opts.isUsePropertyOrderAnnotation())
                .isRenderSingleLineToString(opts.isUseSingleLineToString())
                .isRenderToStringHelper(ds.extendsName().isPresent() || !ds.ctxProps().isEmpty())
                .isRecordCanonicalConstructor(recordCanonicalConstructor)
                .build();

        Info info = model.info();
        return CtxDto.builder()
                .appName(info.title())
                .appDescription(info.description())
                .version(info.version())
                .infoEmail(info.contact().email())

                .imports(ds.imports().get())

                .description(description.flatMap(StringRenderer::makeValidDtoJavadocSummary))
                .packageName(opts.dtoPackage())
                .classname(dto.name())
                .classVarName("other")
                .datatypeWithEnum(null)
                .parent(ds.extendsName())
                .isNullable(false)
                .vendorExtensions(null)

                .vars(ds.ctxProps())

                .allowableValues(ctxEnum)
                .dataType(ds.type().typeName().name())

                .jackson(opts.isJackson())

                .generatedAnnotationClass(opts.getGeneratorAnnotationClass())
                .generatorClass(opts.generatorId())
                .generatedDate(opts.getGeneratedAtTime())

                .madaDto(mada)
                .discriminator(discriminator)

                .isRecord(dsb.isRecord())
                .build();
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
                        || ds.ctxProps().stream().anyMatch(p -> p.isDateTime()))) {

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

    private Optional<String> defineInterfaces(DtoSubject ds) {
        Dto dto = ds.dto();

        Stream<String> serializableInterface;
        if (opts.isUseSerializable() && !dto.isEnum()) {
            serializableInterface = Stream.of("Serializable");
            ds.imports().add(JavaIo.IO_SERIALIZABLE);
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
}
