package dk.mada.jaxrs.generator.dto;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.StringRenderer;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum.CtxEnumEntry;
import dk.mada.jaxrs.generator.imports.Imports;
import dk.mada.jaxrs.generator.imports.MicroProfile;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.naming.EnumNamer;
import dk.mada.jaxrs.naming.EnumNamer.EnumNameValue;
import dk.mada.jaxrs.naming.Naming;

/**
 * Enumeration generator.
 *
 * Prepares an enumeration context for template rendering.
 */
public class EnumGenerator {
    /** Enumeration for unknown values. */
    private static final String ENUM_UNKNOWN_DEFAULT_OPEN_API = "unknown_default_open_api";
    /** Enumeration for unknown integer values. */
    private static final String ENUM_INT_UNKNOWN_DEFAULT_STR = Integer.toString(2125323949); // 0x7EADDEAD

    /** Naming. */
    private final Naming naming;
    /** Generator options. */
    private final GeneratorOpts opts;

    /**
     * Constructs a new generator.
     *
     * @param naming the naming instance
     * @param opts   the generator options
     */
    public EnumGenerator(Naming naming, GeneratorOpts opts) {
        this.naming = naming;
        this.opts = opts;
    }

    /**
     * Prepares enumeration context for rendering.
     *
     * @param enumType the enumeration type
     * @param values   the enumeration values
     * @return the enumeration context
     */
    public CtxEnum toCtxEnum(Type enumType, List<String> values) {
        List<String> renderValues = addUnknownDefault(enumType, values);
        List<CtxEnumEntry> entries = new EnumNamer(naming, enumType, renderValues)
                .getEntries().stream()
                .map(e -> toEnumEntry(enumType, e))
                .toList();

        return new CtxEnum(entries);
    }

    /**
     * If the enumeration values are not represented correctly by the constants, define a schema with the proper values.
     *
     * @param dtoImports the DTO imports
     * @param dtoType    type of the enumeration
     * @param ctxEnum    enumeration constants and values
     * @return optional schema enumeration arguments
     */
    public Optional<String> buildEnumSchema(Imports dtoImports, Type dtoType, CtxEnum ctxEnum) {
        boolean namesMatchValues = ctxEnum.enumVars().stream()
                .allMatch(e -> e.name().equals(e.wireValue()));
        if (namesMatchValues) {
            return Optional.empty();
        }

        String values = ctxEnum.enumVars().stream()
                .map(e -> StringRenderer.quote(e.wireValue()))
                .collect(joining(", "));

        String type = "";
        if (dtoType.isPrimitive(Primitive.STRING)) {
            type = ", type = SchemaType.STRING";
        } else if (dtoType.isPrimitive(Primitive.INT)) {
            type = ", type = SchemaType.INTEGER, format = \"int32\"";
        }
        if (!type.isEmpty()) {
            dtoImports.add(MicroProfile.SCHEMA_TYPE);
        }
        dtoImports.addMicroProfileSchema();

        return Optional.of("enumeration = {" + values + "}" + type);
    }

    /**
     * Adds unknown default enumeration if needed.
     *
     * A magic integer is used for integer types.
     *
     * @param enumType the enumeration type
     * @param values   the input enumeration values
     * @return the input values, plus unknown default if needed
     */
    private List<String> addUnknownDefault(Type enumType, List<String> values) {
        if (!opts.isUseEnumUnknownDefault()) {
            return values;
        }
        if (values.contains(ENUM_UNKNOWN_DEFAULT_OPEN_API)) {
            return values;
        }

        boolean isIntEnum = enumType.isPrimitive(Primitive.INT);

        if (isIntEnum
                && values.contains(ENUM_INT_UNKNOWN_DEFAULT_STR)) {
            return values;
        }

        List<String> renderValues = new ArrayList<>(values);
        if (isIntEnum) {
            renderValues.add(ENUM_INT_UNKNOWN_DEFAULT_STR);
        } else {
            renderValues.add(ENUM_UNKNOWN_DEFAULT_OPEN_API);
        }
        return renderValues;
    }

    private CtxEnumEntry toEnumEntry(Type enumType, EnumNameValue e) {
        String name = e.name();
        String value = e.value();
        if (enumType == Primitive.INT) {
            if (opts.isUseEnumUnknownDefault() && ENUM_INT_UNKNOWN_DEFAULT_STR.equals(value)) {
                name = ENUM_UNKNOWN_DEFAULT_OPEN_API.toUpperCase(Locale.ROOT);
            }
        } else {
            value = StringRenderer.quote(value);
        }
        return new CtxEnumEntry(name, value, e.value());
    }

}
