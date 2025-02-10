package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import org.jspecify.annotations.Nullable;

/**
 * Special type for marking types unknown at parse time. In the Reference, these are identified only by their TypeName
 * instead.
 */
public final class TypeUnknownAtParseTime implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeUnknownAtParseTime instance;

    private TypeUnknownAtParseTime() {
        // empty
    }

    /** {@return the type representing a yet to be defined type} */
    public static synchronized TypeUnknownAtParseTime get() {
        if (instance == null) {
            instance = new TypeUnknownAtParseTime();
        }
        return instance;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.MARKER_UNKNOWN;
    }

    @Override
    public String toString() {
        return "TypeUnknown";
    }
}
