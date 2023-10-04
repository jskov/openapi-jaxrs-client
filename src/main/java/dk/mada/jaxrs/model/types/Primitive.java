package dk.mada.jaxrs.model.types;

import java.util.Objects;

import org.jspecify.annotations.Nullable;

import io.swagger.v3.oas.models.media.Schema;

/**
 * Primitive types of the java language (plus String).
 */
public enum Primitive implements Type {
    /** The boolean. */
    BOOLEAN("boolean:", TypeNames.BOOLEAN, TypeNames.BOOLEAN_WRAPPER),
    /** The byte. */
    BYTE("string:byte", TypeNames.BYTE, TypeNames.BYTE_WRAPPER),
    /** The short. */
    SHORT("integer:", TypeNames.SHORT, TypeNames.SHORT_WRAPPER),
    /** The integer. */
    INT("integer:int32", TypeNames.INTEGER, TypeNames.INTEGER_WRAPPER),
    /** The long. */
    LONG("integer:int64", TypeNames.LONG, TypeNames.LONG_WRAPPER),
    /** The float. */
    FLOAT("number:float", TypeNames.FLOAT, TypeNames.FLOAT_WRAPPER),
    /** The double. */
    DOUBLE("number:double", TypeNames.DOUBLE, TypeNames.DOUBLE_WRAPPER),
    /** The string (not a primitive, but basically). */
    STRING("string:", TypeNames.STRING, TypeNames.STRING);

    /** The OpenApi type:format **/
    private final String typeFormat;
    /** The Java language primitive name */
    private final TypeName javaPrimitive;
    /** Java language wrapper type */
    private final TypeName wrapperType;

    Primitive(String typeFormat, TypeName javaPrimitive, TypeName wrapperType) {
        this.typeFormat = typeFormat;
        this.javaPrimitive = javaPrimitive;
        this.wrapperType = wrapperType;
    }

    /** {@return the type name of this type} */
    @Override
    public TypeName typeName() {
        return javaPrimitive;
    }

    /** {@return the type name of the wrapper of this type} */
    @Override
    public TypeName wrapperTypeName() {
        return wrapperType;
    }

    /**
     * Finds a primitive type matching the given type name.
     *
     * @param tn the type name to look for
     * @return the matching primitive, or null if no matches found
     */
    public static @Nullable Primitive find(TypeName tn) {
        for (var p : Primitive.values()) {
            if (tn.equals(p.javaPrimitive) || tn.equals(p.wrapperType)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean isPrimitive(Primitive primitive) {
        return this == primitive;
    }

    @Override
    public boolean isPrimitive() {
        return true;
    }

    /**
     * Finds a primitive type matching the given OpenApi schema.
     *
     * @param schema the schema to look for type/format for
     * @return the matching primitive, or null if no matches found
     */
    public static @Nullable Primitive find(Schema<?> schema) {
        String typeFormat = schema.getType() + ":" + Objects.toString(schema.getFormat(), "");
        for (var p : Primitive.values()) {
            if (p.typeFormat.equals(typeFormat)) {
                return p;
            }
        }
        return null;
    }
}
