package dk.mada.jaxrs.model.types;

import java.util.Set;

/**
 * Special type for handing byte[] type.
 *
 * In resources this would be treated as a stream, while it
 * it treated as an array in DTOs.
 */
public final class TypeByteArray implements Type {
    /** As used in resource operations. */
    private static final TypeByteArray INSTANCE_STREAM = new TypeByteArray(TypeNames.INPUT_STREAM, Set.of("java.io.InputStream"));
    /** As used in DTOs. */
    private static final TypeByteArray INSTANCE_ARRAY = new TypeByteArray(TypeNames.BYTE_ARRAY, Set.of());

    /** The type name. */
    private final TypeName tn;
    /** The needed imports. */
    private final Set<String> neededImports;

    private TypeByteArray(TypeName tn, Set<String> neededImports) {
        this.tn = tn;
        this.neededImports = neededImports;
    }

    /** {@return the byte-array instance} */
    public static TypeByteArray getArray() {
        return INSTANCE_ARRAY;
    }

    /** {@return the stream instance} */
    public static TypeByteArray getStream() {
        return INSTANCE_STREAM;
    }

    /** {@return true if this is the stream instance, otherwise false} */
    public boolean isStream() {
        return this == INSTANCE_STREAM;
    }

    /** {@return true if this is the byte-array instance, otherwise false} */
    public boolean isArray() {
        return this == INSTANCE_ARRAY;
    }

    @Override
    public TypeName typeName() {
        return tn;
    }

    @Override
    public String toString() {
        return tn.name();
    }

    @Override
    public Set<String> neededImports() {
        return neededImports;
    }
}
