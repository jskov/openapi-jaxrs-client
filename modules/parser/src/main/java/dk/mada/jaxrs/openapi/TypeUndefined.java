package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import org.jspecify.annotations.Nullable;

/**
 * Special type for marking properties without type definition.
 */
public final class TypeUndefined implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeUndefined instance;

    private TypeUndefined() {
        // empty
    }

    /** {@return the undefined type} */
    public static synchronized TypeUndefined get() {
        if (instance == null) {
            instance = new TypeUndefined();
        }
        return instance;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.MARKER_UNDEFINED;
    }

    @Override
    public String toString() {
        return "TypeUndefined";
    }
}
