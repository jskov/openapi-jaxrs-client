package dk.mada.jaxrs.generator.mpclient.dto;

import static dk.mada.jaxrs.generator.mpclient.StringRenderer.consumeNonBlankEncoded;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.MediaTypes;
import dk.mada.jaxrs.generator.mpclient.StringRenderer;
import dk.mada.jaxrs.generator.mpclient.ValidationGenerator;
import dk.mada.jaxrs.generator.mpclient.dto.DtoSubjectDefiner.DtoSubjectBase;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxPropertyExt;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxValidation;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.Jackson;
import dk.mada.jaxrs.generator.mpclient.imports.JavaMath;
import dk.mada.jaxrs.generator.mpclient.imports.JavaUtil;
import dk.mada.jaxrs.generator.mpclient.imports.JaxRs;
import dk.mada.jaxrs.generator.mpclient.imports.RestEasy;
import dk.mada.jaxrs.generator.mpclient.imports.UserMappedImport;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeEnum;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;

/**
 * Property generator.
 *
 * Prepares a property context for template rendering.
 */
public class PropertyGenerator {
    private static final Logger logger = LoggerFactory.getLogger(PropertyGenerator.class);

    /** Naming. */
    private final Naming naming;
    /** Generator options. */
    private final GeneratorOpts opts;

    /** External type mapping. */
    private final Map<String, UserMappedImport> externalTypeMapping;

    /** Enumeration generator. */
    private final EnumGenerator enumGenerator;
    /** Validation generator. */
    private final ValidationGenerator validationGenerator;

    /**
     * Constructs a new generator.
     *
     * @param naming        the naming instance
     * @param opts          the generator options
     * @param enumGenerator the enumeration generator
     */
    public PropertyGenerator(Naming naming, GeneratorOpts opts, EnumGenerator enumGenerator) {
        this.naming = naming;
        this.opts = opts;
        this.enumGenerator = enumGenerator;

        externalTypeMapping = opts.getExternalTypeMapping();
        validationGenerator = new ValidationGenerator(opts);
    }

    /**
     * Prepares property context for rendering.
     *
     * @param dsb  the DTO subject base
     * @param prop the property to make context for
     * @return the property context
     */
    public CtxProperty toCtxProperty(DtoSubjectBase dsb, Property prop) {
        Imports dtoImports = dsb.imports();
        Dto parentDto = dsb.dto();

        final Names names = getNames(prop);
        logger.debug("Property {}", names);

        TypeInfo ti = decodeTypeInfo(dsb, prop);
        EnumInfo ei = decodeEnumInfo(dsb, ti);

        Type propType = ti.propType();
        logger.trace(" {}", propType);

        // Add import if required
        addTypeImports(dtoImports, ti.typeName());
        addTypeImports(dtoImports, ti.innerTypeName());

        String getterPrefix = getterPrefix(prop);
        String getter = getterPrefix + names.camelized();
        String setter = "set" + names.camelized();
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

        Optional<String> description = prop.description();

        boolean isUseEmptyCollections = opts.isUseEmptyCollections()
                && ti.isContainer()
                && !ti.isRequired();
        if (isUseEmptyCollections) {
            dtoImports.add(Jackson.JSON_IGNORE);
            getter = getter + "Nullable";
        }

        List<String> schemaEntries = new ArrayList<>();
        boolean isRequired = ti.isRequired();
        boolean isJaxrsNullable = prop.validation().isNullable().orElse(false);
        boolean isImpliedNullable = !isRequired;
        boolean isNotNull = !isJaxrsNullable && isRequired;
        // See #707 - bean validation NotNull should apparently only relate to
        // !isNullable
        boolean beanValidationNotNull = !isJaxrsNullable;
        logger.info("XX {} implied nullable : {} -> {}", getter, isImpliedNullable, isImpliedNullable || isJaxrsNullable);
        logger.info("XX {} jaxrsNullable:{} notNull:{}", getter, isJaxrsNullable, beanValidationNotNull);
        if (isRequired) {
            schemaEntries.add("required = true");
        }
        if (isJaxrsNullable) {
            schemaEntries.add("nullable = true");
        }
        if (prop.validation().isReadonly().orElse(false)) {
            schemaEntries.add("readOnly = true");
        }
        consumeNonBlankEncoded(description, d -> schemaEntries.add("description = \"" + d + "\""));
        consumeNonBlankEncoded(prop.example(), e -> schemaEntries.add("example = \"" + e + "\""));

        Optional<String> schemaOptions = Optional.empty();
        if (opts.getUseOpenapiSchema() && !schemaEntries.isEmpty()) {
            schemaOptions = Optional.of(String.join(", ", schemaEntries));
            dtoImports.addMicroProfileSchema();
        }

        Optional<CtxValidation> beanValidation = validationGenerator.makeValidation(dtoImports, propType, prop.validation());

        String jsonPropertyConst = null;
        if (opts.isJackson() || opts.isJsonb() || parentDto.isMultipartForm()) {
            jsonPropertyConst = "JSON_PROPERTY_" + names.snaked();
        }

        String multipartType = null;
        if (parentDto.isMultipartForm()) {
            String useType = ti.isStream() ? "application/octet-stream" : "application/json";
            multipartType = MediaTypes.toMediaType(dtoImports, useType);

            dtoImports.add(RestEasy.MULTIPART_PARTTYPE);
            dtoImports.add(JaxRs.FORM_PARAM, JaxRs.MEDIA_TYPE);
        }

        CtxPropertyExt mada = CtxPropertyExt.builder()
                .innerDatatypeWithEnum(ti.innerTypeName())
                .enumClassName(ei.enumClassName())
                .enumTypeName(ei.enumTypeName())
                .enumSchemaOptions(Optional.ofNullable(ei.enumSchema()))
                .schemaOptions(schemaOptions)
                .isUseBigDecimalForDouble(isUseBigDecimalForDouble)
                .isUseEmptyCollections(isUseEmptyCollections)
                .isByteArray(ti.isByteArray())
                .isEqualsPrimitive(isTypePrimitiveEquals(propType))
                .getter(extGetter)
                .setter(extSetter)
                .jsonb(opts.isJsonb())
                .renderJavadocMacroSpacer(description.isPresent())
                .multipartType(multipartType)
                .jsonPropertyConstant(jsonPropertyConst)
                .isNullable(isJaxrsNullable || isImpliedNullable)
                .isRequireNonNull(isNotNull && opts.isUsePojoRequireNonNull())
                .build();

        String propertyName = names.propertyName();
        CtxProperty ctx = CtxProperty.builder()
                .baseName(propertyName)
                .datatypeWithEnum(ti.typeName())
                .dataType(ti.innerTypeName())
                .name(names.variableName())
                .nameInCamelCase(names.camelized())
                .nameInSnakeCase(names.snaked())
                .getter(getter)
                .setter(setter)
                .description(description.flatMap(StringRenderer::makeValidPropertyJavadocSummary))
                .isArray(ti.isArray())
                .isEnum(ei.isEnum())
                .isMap(ti.isMap())
                .isSet(ti.isSet())
                .isContainer(ti.isContainer())
                .isDate(propType.isDate())
                .isDateTime(propType.isDateTime())
                .defaultValue(ti.defaultValue())
                .required(ti.isRequired())
                .notNull(isNotNull)
                .example(prop.example())
                .allowableValues(ei.ctxEnum())
                .validation(beanValidation)
                .madaProp(mada)
                .build();

        logger.debug("property {} : {}", propertyName, ctx);
        return ctx;
    }

    record Names(String propertyName, String variableName, String camelized, String snaked) {
    }

    private Names getNames(Property prop) {
        final String name = prop.name();
        final String varName = naming.convertPropertyName(name);

        String camelized = OpenapiStringUtils.camelize(varName);
        final String snaked = OpenapiStringUtils.underscore(camelized).toUpperCase(Locale.ROOT);
        // Both Jackson (Fasterxml) and JsonBinding expect the getter
        // of a 'xX'-prefixed field to be named 'getxX'. Although
        // this is different from Bean Spec naming for getters/setters.
        //
        // See https://github.com/FasterXML/jackson-databind/blob/2.15...
        // /src/main/java/com/fasterxml/jackson/databind/introspect...
        // /DefaultAccessorNamingStrategy.java#L182
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1))) {
            camelized = Character.toLowerCase(name.charAt(0)) + camelized.substring(1);
        }

        return new Names(name, varName, camelized, snaked);
    }

    private void addTypeImports(Imports dtoImports, @Nullable String typeName) {
        if (typeName != null) {
            UserMappedImport externalType = externalTypeMapping.get(typeName);
            if (externalType != null) {
                dtoImports.add(externalType);
            }
        }
    }

    private String getterPrefix(Property p) {
        boolean isBoolean = p.reference().isPrimitive(Primitive.BOOLEAN);
        String getterPrefix = "get";
        if (isBoolean && !opts.isUseBooleanGetPrefix()) {
            getterPrefix = "is";
        }
        return getterPrefix;
    }

    private boolean isTypePrimitiveEquals(Type t) {
        return t.isPrimitive(Primitive.INT);
    }

    private EnumInfo decodeEnumInfo(DtoSubjectBase dsb, TypeInfo ti) {
        CtxEnum ctxEnum = null;
        String enumClassName = ti.typeName();
        String enumTypeName = ti.typeName();
        Optional<String> enumSchema = Optional.empty();

        if (getDereferencedInnerEnumType(ti.innerType()) instanceof TypeEnum te) {
            Type enumType = te.innerType();
            enumTypeName = enumType.typeName().name();
            enumClassName = te.typeName().name();
            dsb.imports().addEnumImports(!ti.isContainer(), !enumType.isPrimitive(Primitive.INT));

            ctxEnum = enumGenerator.toCtxEnum(enumType, te.values());
            enumSchema = enumGenerator.buildEnumSchemaForType(dsb, enumType, ctxEnum);

            logger.debug(" enum {} : {}", enumTypeName, te.values());
        }

        return new EnumInfo(ctxEnum, enumClassName, enumTypeName, enumSchema.orElse(null));
    }

    private TypeInfo decodeTypeInfo(DtoSubjectBase dsb, Property prop) {
        Imports dtoImports = dsb.imports();
        boolean addImportsForDefaultValues = !dsb.isRecord();

        Type propType = prop.reference().refType();
        Type innerType = null;
        String defaultValue = null;
        final boolean isRequired = prop.validation().isRequired().orElse(false);
        boolean isByteArray = false;
        boolean isStream = false;
        boolean isArray = false;
        boolean isMap = false;
        boolean isSet = false;
        String innerTypeName = null;

        if (propType instanceof TypeByteArray tba) {
            if (tba.isArray()) {
                isByteArray = true;
                // FIXME: This import should really live with the type handling in Imports
                dtoImports.add(addImportsForDefaultValues, JavaUtil.ARRAYS);
                if (isRequired) {
                    defaultValue = "new byte[] {}";
                }
            } else {
                isStream = true;
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

        return new TypeInfo(propType, typeName, innerType, innerTypeName, defaultValue,
                isRequired, isContainer,
                isByteArray, isStream, isArray, isMap, isSet);
    }

    record TypeInfo(
            Type propType,
            String typeName,
            @Nullable Type innerType,
            @Nullable String innerTypeName,
            @Nullable String defaultValue,
            boolean isRequired,
            boolean isContainer,
            boolean isByteArray,
            boolean isStream,
            boolean isArray,
            boolean isMap,
            boolean isSet) {
    }

    record EnumInfo(
            @Nullable CtxEnum ctxEnum,
            @Nullable String enumClassName,
            @Nullable String enumTypeName,
            @Nullable String enumSchema) {
        public boolean isEnum() {
            return ctxEnum != null;
        }
    }

    private static @Nullable Type getDereferencedInnerEnumType(@Nullable Type t) {
        if (t instanceof TypeReference tr) {
            return tr.refType();
        }
        return t;
    }
}
