package dk.mada.jaxrs.model.types;

import java.util.Set;
import org.jspecify.annotations.Nullable;

/**
 * Special type for handing byte[] type.
 *
 * In resources this would be treated as a stream, while it it treated as an array in DTOs.
 */
public final class TypeByteArray implements Type {
    /** As used in resource operations. */
    @Nullable private static TypeByteArray instanceStream;
    /** As used in DTOs. */
    @Nullable private static TypeByteArray instanceArray;

    /** The type name. */
    private final TypeName tn;
    /** The needed imports. */
    private final Set<String> neededImports;

    private TypeByteArray(TypeName tn, Set<String> neededImports) {
        this.tn = tn;
        this.neededImports = neededImports;
    }

    /** {@return the byte-array instance} */
    public static synchronized TypeByteArray getArray() {
        if (instanceArray == null) {
            instanceArray = new TypeByteArray(TypeNames.BYTE_ARRAY, Set.of());
        }
        return instanceArray;
    }

    /** {@return the stream instance} */
    public static synchronized TypeByteArray getStream() {
        if (instanceStream == null) {
            instanceStream = new TypeByteArray(TypeNames.INPUT_STREAM, Set.of("java.io.InputStream"));
        }
        return instanceStream;
    }

    /** {@return true if this is the stream instance, otherwise false} */
    public boolean isStream() {
        return this == instanceStream;
    }

    /** {@return true if this is the byte-array instance, otherwise false} */
    public boolean isArray() {
        return this == instanceArray;
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
