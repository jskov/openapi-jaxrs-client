package dk.mada.jaxrs.model.types;

import java.util.Objects;

import org.jspecify.annotations.Nullable;

/**
 * Primitive types of the java language (plus String).
 */
public enum Primitive implements Type {
    /** The boolean. */
    BOOLEAN("boolean:", TypeNames.BOOLEAN, TypeNames.BOOLEAN_WRAPPER),
    /**
     * An integer of unknown format. Generator decides how to render this.
     *
     * @see <a href="https://swagger.io/specification/#data-types">spec</a>
     */
    NOFORMAT_INT("integer:", TypeNames.MARKER_NOFORMAT_INT, TypeNames.MARKER_NOFORMAT_INT),
    /** The byte. */
    BYTE("string:byte", TypeNames.BYTE, TypeNames.BYTE_WRAPPER),
    /**
     * The short. This cannot be represented by spec's type/format.
     *
     * @see <a href="https://swagger.io/specification/#data-types">spec</a>
     */
    SHORT("undef", TypeNames.SHORT, TypeNames.SHORT_WRAPPER),
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
    private final String openapiTypeFormat;
    /** The Java language primitive name */
    private final TypeName javaPrimitive;
    /** Java language wrapper type */
    private final TypeName wrapperType;

    /** The primitive type to use for noformat-integers. */
    @Nullable private Primitive noformatIntPrimitive;

    Primitive(String typeFormat, TypeName javaPrimitive, TypeName wrapperType) {
        this.openapiTypeFormat = typeFormat;
        this.javaPrimitive = javaPrimitive;
        this.wrapperType = wrapperType;
    }

    /**
     * Sets the primitive to use in place of integers without format.
     *
     * This gets set by the generator, so technically changes the constant'ness of the type. Not sure how to do it better
     * without affecting all the call sites.
     *
     * @param wantedNoformatIntPrimitive the type to use for integers without format
     */
    public void setNoformatIntTypes(Primitive wantedNoformatIntPrimitive) { // NOSONAR: yes, ugly
        this.noformatIntPrimitive = wantedNoformatIntPrimitive;
    }

    /** {@return the type name of this type} */
    @Override
    public TypeName typeName() {
        if (this == NOFORMAT_INT) {
            return Objects.requireNonNull(noformatIntPrimitive, "No primitive type defined for noformat-int").javaPrimitive;
        }
        return javaPrimitive;
    }

    /** {@return the type name of the wrapper of this type} */
    @Override
    public TypeName wrapperTypeName() {
        if (this == NOFORMAT_INT) {
            return Objects.requireNonNull(noformatIntPrimitive, "No wrapper type defined for noformat-int").wrapperType;
        }
        return wrapperType;
    }

    /** {@return the OpenApi type:format of this primitive} */
    public String openapiTypeFormat() {
        return openapiTypeFormat;
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
}
