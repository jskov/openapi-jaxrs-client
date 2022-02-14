package dk.mada.jaxrs.model.types;

import java.util.Objects;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Primitive types of the java language (plus String).
 */
public enum Primitive implements Type {
    /** The boolean. */
    BOOLEAN("boolean:",     "boolean", "Boolean"),
    /** The byte. */
    BYTE("string:byte",     "byte",    "Byte"),
    /** The short. */
    SHORT("integer:",       "short",   "Short"),
    /** The integer. */
    INT("integer:int32",    "int",     "Integer"),
    /** The long. */
    LONG("integer:int64",   "long",    "Long"),
    /** The float. */
    FLOAT("number:float",   "float",   "Float"),
    /** The double. */
    DOUBLE("number:double", "double",  "Double"),
    /** The string (not a primitive, but basically). */
    STRING("string:",       "String",  "String");

    /** The OpenApi type:format **/
    private String typeFormat;
    /** The Java language primitive name */
    private TypeName javaPrimitive;
    /** Java language wrapper type */
    private TypeName wrapperType;

    Primitive(String typeFormat, String javaPrimitive, String wrapperType) {
        this.typeFormat = typeFormat;
        this.javaPrimitive = TypeNames.of(javaPrimitive);
        this.wrapperType = TypeNames.of(wrapperType);
    }

    /** {@return the type name of this type} */
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
    public static Primitive find(TypeName tn) {
        for (var p : Primitive.values()) {
            if (tn.equals(p.javaPrimitive) || tn.equals(p.wrapperType)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Finds a primitive type matching the given OpenApi type and format.
     *
     * @param type the type to look for
     * @param format the format to look for
     * @return the matching primitive, or null if no matches found
     */
    public static Primitive find(String type, String format) {
        String typeFormat = type + ":" + Objects.toString(format, "");
        for (var p : Primitive.values()) {
            if (p.typeFormat.equals(typeFormat)) {
                return p;
            }
        }
        return null;
    }
}
