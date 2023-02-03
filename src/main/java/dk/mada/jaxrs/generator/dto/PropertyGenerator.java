package dk.mada.jaxrs.generator.dto;

import static dk.mada.jaxrs.generator.StringRenderer.consumeNonBlankEncoded;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.StringRenderer;
import dk.mada.jaxrs.generator.ValidationGenerator;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.dto.tmpl.CtxPropertyExt;
import dk.mada.jaxrs.generator.dto.tmpl.CtxValidation;
import dk.mada.jaxrs.generator.imports.Imports;
import dk.mada.jaxrs.generator.imports.Jackson;
import dk.mada.jaxrs.generator.imports.JavaMath;
import dk.mada.jaxrs.generator.imports.JavaUtil;
import dk.mada.jaxrs.generator.imports.UserMappedImport;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeEnum;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.openapi.OpenapiGeneratorUtils;

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
     * @param dtoImports the imports for the parent DTO
     * @param prop       the property to make context for
     * @return the property context
     */
    public CtxProperty toCtxProperty(Imports dtoImports, Property prop) {
        final Names names = getNames(prop);
        logger.debug("Property {}", names);

        TypeInfo ti = decodeTypeInfo(dtoImports, prop);
        EnumInfo ei = decodeEnumInfo(dtoImports, ti);

        Type propType = ti.propType();
        logger.trace(" {}", propType);

//        CtxEnum ctxEnum = null;
//        String enumClassName = ti.typeName();
//        String enumTypeName = ti.typeName();
//        Optional<String> enumSchema = Optional.empty();
        /*
         * if (prop.name().equals("type")) { logger.warn("Bad {}", prop); logger.warn("typeName: {}, innerTypeName: {}",
         * typeName, innerTypeName); // throw new IllegalStateException("Bad conversion"); }
         */
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
        if (ti.isRequired()) {
            schemaEntries.add("required = true");
        }
        if (prop.validation().isNullable().orElse(false)) {
            schemaEntries.add("nullable = true");
        }
        if (prop.validation().isReadonly().orElse(false)) {
            schemaEntries.add("readOnly = true");
        }
        consumeNonBlankEncoded(description, d -> schemaEntries.add("description = \"" + d + "\""));
        consumeNonBlankEncoded(prop.example(), e -> schemaEntries.add("example = \"" + e + "\""));

        Optional<String> schemaOptions = Optional.empty();
        if (!schemaEntries.isEmpty()) {
            schemaOptions = Optional.of(String.join(", ", schemaEntries));
            dtoImports.addMicroProfileSchema();
        }

        Optional<CtxValidation> beanValidation = validationGenerator.makeValidation(dtoImports, propType, prop.validation());

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

        String camelized = OpenapiGeneratorUtils.camelize(varName);
        final String snaked = OpenapiGeneratorUtils.underscore(camelized).toUpperCase();
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

    private EnumInfo decodeEnumInfo(Imports dtoImports, TypeInfo ti) {
        CtxEnum ctxEnum = null;
        String enumClassName = ti.typeName();
        String enumTypeName = ti.typeName();
        Optional<String> enumSchema = Optional.empty();

        if (getDereferencedInnerEnumType(ti.innerType())instanceof TypeEnum te) {
            Type enumType = te.innerType();
            enumTypeName = enumType.typeName().name();
            enumClassName = te.typeName().name();
            dtoImports.addEnumImports(!ti.isContainer(), !enumType.isPrimitive(Primitive.INT));

            ctxEnum = enumGenerator.toCtxEnum(enumType, te.values());
            enumSchema = enumGenerator.buildEnumSchema(dtoImports, enumType, ctxEnum);

            logger.debug(" enum {} : {}", ti.innerTypeName(), te.values());
        }

        return new EnumInfo(ctxEnum, enumClassName, enumTypeName, enumSchema.orElse(null));
    }

    private TypeInfo decodeTypeInfo(Imports dtoImports, Property prop) {
        Type propType = prop.reference().refType();
        Type innerType = null;
        String defaultValue = null;
        final boolean isRequired = prop.validation().isRequired().orElse(false);
        boolean isByteArray = false;
        boolean isArray = false;
        boolean isMap = false;
        boolean isSet = false;
        String innerTypeName = null;

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

        return new TypeInfo(propType, typeName, innerType, innerTypeName, defaultValue,
                isRequired, isContainer,
                isByteArray, isArray, isMap, isSet);
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
