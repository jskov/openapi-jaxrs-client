package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing byte[] type.
 *
 * In resources this would be treated as a stream, while it
 * it treated as an array in DTOs.
 */
public final class TypeByteArray implements Type {
    /** As used in resource operations. */
    private static final TypeByteArray INSTANCE_STREAM = new TypeByteArray();
    /** As used in DTOs. */
    private static final TypeByteArray INSTANCE_ARRAY = new TypeByteArray();

    private TypeByteArray() {
    }

    public static TypeByteArray getArray() {
        return INSTANCE_ARRAY;
    }

    public static TypeByteArray getStream() {
        return INSTANCE_STREAM;
    }

    public boolean isStream() {
        return this == INSTANCE_STREAM;
    }

    public boolean isArray() {
        return this == INSTANCE_ARRAY;
    }


    @Override
    public TypeName typeName() {
        return TypeNames.of("byte[]");
    }

    @Override
    public String toString() {
        return isArray() ? "ByteArray[]" : "Stream";
    }
}
