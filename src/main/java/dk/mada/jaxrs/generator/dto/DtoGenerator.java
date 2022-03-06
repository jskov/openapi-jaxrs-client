package dk.mada.jaxrs.generator.dto;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.ExtraTemplate;
import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Imports;
import dk.mada.jaxrs.generator.StringRenderer;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDto;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDtoExt;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum.CtxEnumEntry;
import dk.mada.jaxrs.generator.dto.tmpl.CtxExtra;
import dk.mada.jaxrs.generator.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.dto.tmpl.CtxPropertyExt;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeContainer;
import dk.mada.jaxrs.model.types.TypeEnum;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.naming.EnumNamer;
import dk.mada.jaxrs.naming.EnumNamer.EnumNameValue;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.openapi.OpenapiGeneratorUtils;

/**
 * DTO generator.
 *
 * Processes the model's DTOs and prepares DTO contexts
 * for template rendering.
 */
public class DtoGenerator {
    private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

    /** Naming. */
    private final Naming naming;
    /** Types. */
    private final Dtos types;
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
    private final Map<String, String> externalTypeMapping;

    /**
     * Constructs a new generator.
     *
     * @param naming the naming instance
     * @param opts the generator options
     * @param templates the templates instance
     * @param model the data model
     */
    public DtoGenerator(Naming naming, GeneratorOpts opts, Templates templates, Model model) {
        this.naming = naming;
        this.opts = opts;
        this.templates = templates;
        this.model = model;

        types = model.dtos();
        externalTypeMapping = opts.getExternalTypeMapping();
    }

    /**
     * Generate all DTO classes.
     */
    public void generateDtoClasses() {
        types.getActiveDtos().stream()
        .sorted((a, b) -> a.name().compareTo(b.name()))
        .forEach(type -> {
            String name = type.name();

            String mappedToExternalType = externalTypeMapping.get(name);
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

            CtxExtra ctx = makeCtxExtra(tmpl);
            templates.renderExtraTemplate(tmpl, ctx);
        });
    }

    private CtxExtra makeCtxExtra(ExtraTemplate tmpl) {
        var imports = Imports.newExtras(types, opts, tmpl);

        Info info = model.info();
        return CtxExtra.builder()
                .appName(info.title())
                .appDescription(info.description())
                .version(info.version())
                .infoEmail(info.contact().email())
                .generatedDate(opts.getGeneratedAtTime())
                .generatorClass(opts.generatorId())
                .imports(imports.get())
                .jacksonCodehaus(opts.isJacksonCodehaus())
                .jacksonFasterxml(opts.isJacksonFasterxml())
                .jsonb(opts.isJsonb())
                .packageName(opts.dtoPackage())
                .cannedLocalDateSerializerDTF(opts.getJacksonLocalDateWireFormat())
                .build();
    }

    private CtxDto toCtx(Dto dto) {
        Info info = model.info();

        boolean isEnum = dto.isEnum();
        var dtoImports = isEnum ? Imports.newEnum(types, opts) : Imports.newPojo(types, opts);

        List<CtxProperty> vars = dto.properties().stream()
                .map(p -> toCtxProperty(dtoImports, p))
                .toList();

        Type dtoType = dto.reference().refType();
        CtxEnum ctxEnum = null;
        if (isEnum) {
            ctxEnum = buildEnumEntries(dtoType, dto.enumValues());
        }

        dtoImports.addPropertyImports(dto.properties());

        String customLocalDateDeserializer = null;
        String customLocalDateSerializer = null;

        if (opts.isUseJacksonLocalDateSerializer()
                && (dtoType.isDate()
                        || dto.properties().stream().anyMatch(p -> p.reference().isDate()))) {
            if (opts.isAddJacksonLocalDateDeserializerTemplate()) {
                extraTemplates.add(ExtraTemplate.LOCAL_DATE_JACKSON_DESERIALIZER);
            }
            customLocalDateDeserializer = opts.getJacksonLocalDateDeserializer();

            if (opts.isAddJacksonLocalDateSerializerTemplate()) {
                extraTemplates.add(ExtraTemplate.LOCAL_DATE_JACKSON_SERIALIZER);
            }
            customLocalDateSerializer = opts.getJacksonLocalDateSerializer();

            dtoImports.jackson("JsonDeserialize", "JsonSerialize");
        }

        String customOffsetDateTimeDeserializer = null;
        String customOffsetDateTimeSerializer = null;

        if (opts.isUseJacksonDateTimeSerializer()
                && (dtoType.isDateTime()
                        || dto.properties().stream().anyMatch(p -> p.reference().isDateTime()))) {
            if (opts.isUseLocalDateTime()) {
                extraTemplates.add(ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER);
                extraTemplates.add(ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER);
                customOffsetDateTimeDeserializer = ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER.classname();
                customOffsetDateTimeSerializer = ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER.classname();
            } else {
                extraTemplates.add(ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER);
                extraTemplates.add(ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER);
                customOffsetDateTimeDeserializer = ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER.classname();
                customOffsetDateTimeSerializer = ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER.classname();
            }

            dtoImports.jackson("JsonDeserialize", "JsonSerialize");
        }

        String description = dto.description();
        if (description != null) {
            dtoImports.addSchema();
        }

        CtxDtoExt mada = CtxDtoExt.builder()
                .jacksonJsonSerializeOptions(opts.getJsonSerializeOptions())
                .jsonb(opts.isJsonb())
                .customLocalDateDeserializer(customLocalDateDeserializer)
                .customLocalDateSerializer(customLocalDateSerializer)
                .customOffsetDateTimeDeserializer(customOffsetDateTimeDeserializer)
                .customOffsetDateTimeSerializer(customOffsetDateTimeSerializer)
                .build();

        return CtxDto.builder()
                .appName(info.title())
                .appDescription(info.description())
                .version(info.version())
                .infoEmail(info.contact().email())

                .imports(dtoImports.get())

                .description(description)
                .packageName(opts.dtoPackage())
                .classname(dto.name())
                .classVarName("other")

                .vars(vars)

                .allowableValues(ctxEnum)
                .dataType(dtoType.typeName().name())

                .jackson(opts.isJackson())

                .generatorClass(opts.generatorId())
                .generatedDate(opts.getGeneratedAtTime())

                .madaDto(mada)

                .build();
    }

    @Nullable
    private CtxEnum buildEnumEntries(Type enumType, List<String> values) {
        List<CtxEnumEntry> entries = new EnumNamer(naming, opts, enumType, values)
                .getEntries().stream()
                .map(e -> toEnumEntry(enumType, e))
                .toList();

        return new CtxEnum(entries);
    }

    private CtxEnumEntry toEnumEntry(Type enumType, EnumNameValue e) {
        String strValue = e.value();
        if (enumType != Primitive.INT) {
            strValue = "\"" + strValue + "\"";
        }
        return new CtxEnumEntry(e.name(), strValue);
    }

    private CtxProperty toCtxProperty(Imports dtoImports, Property p) {
        String name = p.name();
        String varName = naming.convertPropertyName(name);

        String nameCamelized = OpenapiGeneratorUtils.camelize(varName);
        String nameSnaked = OpenapiGeneratorUtils.underscore(nameCamelized).toUpperCase();

        logger.trace("Property {} -> {} / {} / {}", name, varName, nameCamelized, nameSnaked);

        Type propType = p.reference().refType();
        logger.trace(" {}", propType);

        String defaultValue = null;
        boolean isRequired = p.isRequired();
        boolean isArray = false;
        boolean isMap = false;
        boolean isSet = false;
        boolean isDate = propType.isDate();
        boolean isDateTime = propType.isDateTime();
        boolean isEnum = false;
        String innerTypeName = null;
        CtxEnum ctxEnum = null;

        if (propType instanceof TypeArray ca) {
            isArray = true;
            innerTypeName = ca.innerType().typeName().name();
            defaultValue = "new " + ca.containerImplementation() + "<>()";
        }
        if (propType instanceof TypeMap cm) {
            isMap = true;
            innerTypeName = cm.innerType().typeName().name();
            defaultValue = "new " + cm.containerImplementation() + "<>()";
        }
        if (propType instanceof TypeSet cs) {
            isSet = true;
            innerTypeName = cs.innerType().typeName().name();
            defaultValue = "new " + cs.containerImplementation() + "<>()";

            // In templates, array is used for both set and list
            isArray = true;
        }
        if (propType instanceof TypeEnum te) {
            innerTypeName = te.innerType().typeName().name();
            isEnum = true;

            ctxEnum = buildEnumEntries(te.innerType(), te.values());

            dtoImports.addEnumImports();
        }

        boolean isContainer = isArray || isMap || isSet;

        String typeName = propType.wrapperTypeName().name();

        // Add import if required
        String externalType = externalTypeMapping.get(typeName);
        if (externalType != null) {
            dtoImports.add(externalType);
        }
        if (innerTypeName != null) {
            String innerExternalType = externalTypeMapping.get(innerTypeName);
            if (innerExternalType != null) {
                dtoImports.add(innerExternalType);
            }
        }

        String getterPrefix = getterPrefix(p);
        String getter = getterPrefix + nameCamelized;
        String setter = "set" + nameCamelized;
        String extGetter = getter;
        String extSetter = setter;
        boolean isUseBigDecimalForDouble =
                opts.isUseBigDecimalForDouble()
                && propType.isPrimitive(Primitive.DOUBLE);
        if (isUseBigDecimalForDouble) {
            getter = getter + "Double";
            setter = setter + "Double";

            dtoImports.jackson("JsonIgnore");
            dtoImports.add("java.math.BigDecimal");
        }

        String description = p.description();

        boolean isUseEmptyCollections =
                opts.isUseEmptyCollections()
                && isContainer
                && !isRequired;
        if (isUseEmptyCollections) {
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
        if (isNotBlank(description)) {
            schemaEntries.add("description = \"" + StringRenderer.encodeForString(description) + "\"");
        }
        if (isNotBlank(p.example())) {
            schemaEntries.add("example = \"" + StringRenderer.encodeForString(p.example()) + "\"");
        }
        String schemaOptions = null;
        if (!schemaEntries.isEmpty()) {
            schemaOptions = String.join(", ", schemaEntries);
            dtoImports.addSchema();
        }

        boolean useBeanValidation = opts.isUseBeanValidation();
        boolean valid = false;
        String minLength = null;
        String maxLength = null;
        String minimum = null;
        String maximum = null;
        String pattern = null;
        if (useBeanValidation) {
            if (p.isRequired()) {
                dtoImports.add("javax.validation.constraints.NotNull");
            }
            // Decide where to put @Valid. I expect this to be too simple...
            if (propType.isDto()
                    || (propType instanceof TypeContainer tc && tc.innerType().isDto())) {
                valid = true;
                dtoImports.add("javax.validation.Valid");
            }

            if (p.minLength() != null) {
                minLength = Integer.toString(p.minLength());
                dtoImports.add("javax.validation.constraints.Size");
            }
            if (p.maxLength() != null) {
                maxLength = Integer.toString(p.maxLength());
                dtoImports.add("javax.validation.constraints.Size");
            }

            if (p.minimum() != null) {
                minimum = p.minimum().toString();
                dtoImports.add("javax.validation.constraints.Min");
            }
            if (p.maximum() != null) {
                maximum = p.maximum().toString();
                dtoImports.add("javax.validation.constraints.Max");
            }

            if (p.pattern() != null) {
                pattern = p.pattern();
                dtoImports.add("javax.validation.constraints.Pattern");
            }
        }

        CtxPropertyExt mada = CtxPropertyExt.builder()
                .innerDatatypeWithEnum(innerTypeName)
                .schemaOptions(schemaOptions)
                .isUseBigDecimalForDouble(isUseBigDecimalForDouble)
                .isUseEmptyCollections(isUseEmptyCollections)
                .getter(extGetter)
                .setter(extSetter)
                .jsonb(opts.isJsonb())
                .valid(valid)
                .renderJavadocMacroSpacer(description != null)
                .build();

        return CtxProperty.builder()
                .baseName(name)
                .datatypeWithEnum(typeName)
                .dataType(innerTypeName)
                .name(varName)
                .nameInCamelCase(nameCamelized)
                .nameInSnakeCase(nameSnaked)
                .getter(getter)
                .setter(setter)
                .description(StringRenderer.makeValidJavadocSummary(description))
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
                .pattern(pattern)
                .madaProp(mada)
                .build();
    }

    private String getterPrefix(Property p) {
        boolean isBoolean = p.reference().isPrimitive(Primitive.BOOLEAN);
        String getterPrefix = "get";
        if (isBoolean && !opts.isUseBooleanGetPrefix()) {
            getterPrefix = "is";
        }
        return getterPrefix;
    }

    private boolean isNotBlank(String s) {
        return s != null && !s.isBlank();
    }
}
