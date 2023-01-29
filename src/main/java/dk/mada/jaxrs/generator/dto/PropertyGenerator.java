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
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.dto.tmpl.CtxPropertyExt;
import dk.mada.jaxrs.generator.imports.Imports;
import dk.mada.jaxrs.generator.imports.Jackson;
import dk.mada.jaxrs.generator.imports.JavaMath;
import dk.mada.jaxrs.generator.imports.JavaUtil;
import dk.mada.jaxrs.generator.imports.UserMappedImport;
import dk.mada.jaxrs.generator.imports.ValidationApi;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeContainer;
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
    }

    /**
     * Prepares property context for rendering.
     *
     * @param dtoImports the imports for the parent DTO
     * @param prop       the property to make context for
     * @return the property context
     */
    public CtxProperty toCtxProperty(Imports dtoImports, Property prop) {
        final String name = prop.name();
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

        TypeInfo ti = decodeTypeInfo(dtoImports, prop);
        EnumInfo ei = decodeEnumInfo(dtoImports, ti);

        Type propType = ti.propType();
        logger.trace(" {}", propType);

//        CtxEnum ctxEnum = null;
//        String enumClassName = ti.typeName();
//        String enumTypeName = ti.typeName();
//        Optional<String> enumSchema = Optional.empty();
/*
        if (prop.name().equals("type")) {
            logger.warn("Bad {}", prop);
            logger.warn("typeName: {}, innerTypeName: {}", typeName, innerTypeName);
//            throw new IllegalStateException("Bad conversion");
        }
*/
        // Add import if required
        addTypeImports(dtoImports, ti.typeName());
        addTypeImports(dtoImports, ti.innerTypeName());

        String getterPrefix = getterPrefix(prop);
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
        if (prop.isNullable()) {
            schemaEntries.add("nullable = true");
        }
        if (prop.isReadonly()) {
            schemaEntries.add("readOnly = true");
        }
        consumeNonBlankEncoded(description, d -> schemaEntries.add("description = \"" + d + "\""));
        consumeNonBlankEncoded(prop.example(), e -> schemaEntries.add("example = \"" + e + "\""));

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
            if (prop.isRequired()) {
                dtoImports.add(ValidationApi.NOT_NULL);
            }
            // Decide where to put @Valid. I expect this to be too simple...
            if (propType.isDto()
                    || (propType instanceof TypeContainer tc && tc.innerType().isDto())) {
                valid = true;
                dtoImports.add(ValidationApi.VALID);
            }

            // Note that OpenApi specification xItems/xLength both map to @Size
            minLength = prop.minItems()
                    .or(prop::minLength)
                    .map(i -> Integer.toString(i)); // NOSONAR - not enough information to select variant
            if (minLength.isPresent()) {
                dtoImports.add(ValidationApi.SIZE);
            }
            maxLength = prop.maxItems()
                    .or(prop::maxLength)
                    .map(i -> Integer.toString(i)); // NOSONAR - not enough information to select variant
            if (maxLength.isPresent()) {
                dtoImports.add(ValidationApi.SIZE);
            }

            if (propType.isBigDecimal()) {
                decimalMinimum = prop.minimum()
                        .map(min -> "\"" + min.toString() + "\"");
                decimalMaximum = prop.maximum()
                        .map(max -> "\"" + max.toString() + "\"");
            } else {
                minimum = prop.minimum()
                        .map(min -> Long.toString(min.longValue()));
                maximum = prop.maximum()
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

            pattern = prop.pattern()
                    .map(StringRenderer::encodeRegexp);
            if (pattern.isPresent()) {
                dtoImports.add(ValidationApi.PATTERN);
            }
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
                .valid(valid)
                .renderJavadocMacroSpacer(description.isPresent())
                .build();

        CtxProperty ctx = CtxProperty.builder()
                .baseName(name)
                .datatypeWithEnum(ti.typeName())
                .dataType(ti.innerTypeName())
                .name(varName)
                .nameInCamelCase(nameCamelized)
                .nameInSnakeCase(nameSnaked)
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

        logger.debug("property {} : {}", name, ctx);
        return ctx;
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
        final boolean isRequired = prop.isRequired();
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
