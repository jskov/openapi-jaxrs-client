package dk.mada.jaxrs.generator.mpclient.dto;

import static java.util.stream.Collectors.joining;

import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.StringRenderer;
import dk.mada.jaxrs.generator.mpclient.dto.DtoSubjectDefiner.DtoSubjectBase;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxEnum.CtxEnumEntry;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.MicroProfile;
import dk.mada.jaxrs.model.naming.EnumNamer;
import dk.mada.jaxrs.model.naming.EnumNamer.EnumNameValue;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import org.jspecify.annotations.Nullable;

/**
 * Enumeration generator.
 *
 * Prepares an enumeration context for template rendering.
 */
public class EnumGenerator {
    /** Enumeration name for unknown values. */
    private static final String ENUM_UNKNOWN_DEFAULT_OPEN_API = "unknown_default_open_api";
    /** Enumeration values for unknown entries. */
    private static final Map<Primitive, String> ENUM_UNKNOWN_DEFAULT_VALUE_STR = Map.of(
            Primitive.SHORT, Short.toString((short) 0xdead),
            Primitive.INT, Integer.toString(0x7eaddead),
            Primitive.LONG, Long.toString(0x07eaddeaddeaddeadL));

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
        @Nullable String unknownDefault = findValidUnknownDefault(enumType, values);

        List<String> renderValues = new ArrayList<>();
        renderValues.addAll(values);
        if (unknownDefault != null) {
            renderValues.add(unknownDefault);
        }

        List<CtxEnumEntry> entries = new EnumNamer(naming, enumType, renderValues)
                .getEntries().stream()
                        .map(e -> toEnumEntry(enumType, e, unknownDefault))
                        .toList();

        return new CtxEnum(entries);
    }

    /**
     * If the enumeration values are not represented correctly by the constants, define a schema with the proper values.
     *
     * @param dsb     the DTO subject
     * @param type    the type to define schema for (which may differ from the subject's!)
     * @param ctxEnum enumeration constants and values
     * @return optional schema enumeration arguments
     */
    public Optional<String> buildEnumSchemaForType(DtoSubjectBase dsb, Type type, CtxEnum ctxEnum) {
        if (!opts.getUseOpenapiSchema()) {
            return Optional.empty();
        }

        Imports dtoImports = dsb.imports();

        boolean namesMatchValues =
                ctxEnum.enumVars().stream().allMatch(e -> e.name().equals(e.wireValue()));
        if (namesMatchValues) {
            return Optional.empty();
        }

        String values = ctxEnum.enumVars().stream()
                .map(e -> StringRenderer.quote(e.wireValue()))
                .collect(joining(", "));

        String typeStr = "";
        if (type.isPrimitive(Primitive.STRING)) {
            typeStr = ", type = SchemaType.STRING";
        } else if (type.isPrimitive(Primitive.INT)) {
            typeStr = ", type = SchemaType.INTEGER, format = \"int32\"";
        }
        if (!typeStr.isEmpty()) {
            dtoImports.add(MicroProfile.SCHEMA_TYPE);
        }
        dtoImports.addMicroProfileSchema();

        return Optional.of("enumeration = {" + values + "}" + typeStr);
    }

    /**
     * Find (if possible) a value that can serve as an undefined default.
     *
     * @param enumType the type of the enumeration
     * @param values the known values
     * @return a value that is valid for the type and does not appear in the known values, or null if this is not possible
     */
    private @Nullable String findValidUnknownDefault(Type enumType, List<String> values) {
        if (!opts.isUseEnumUnknownDefault()) {
            return null;
        }
        if (values.contains(ENUM_UNKNOWN_DEFAULT_OPEN_API)) {
            return null;
        }
        if (enumType instanceof Primitive p && p.isNumber()) {
            p = p.getResolvedPrimitive();
            return ENUM_UNKNOWN_DEFAULT_VALUE_STR.getOrDefault(p, "unknown_" + p.name());
        } else {
            return ENUM_UNKNOWN_DEFAULT_OPEN_API;
        }
    }

    private CtxEnumEntry toEnumEntry(Type enumType, EnumNameValue e, @Nullable String unknownDefault) {
        String name = e.name();
        if (e.value().equals(unknownDefault)) {
            name = ENUM_UNKNOWN_DEFAULT_OPEN_API.toUpperCase(Locale.ROOT);
        }

        String value = e.value();
        if (enumType instanceof Primitive p && p.isNumber()) {
            p = p.getResolvedPrimitive();
            if (p == Primitive.SHORT) {
                value = "(short)" + value;
            } else if (p == Primitive.LONG) {
                value = value + "L";
            }
        } else {
            value = StringRenderer.quote(value);
        }

        return new CtxEnumEntry(name, value, e.value());
    }
}
