package dk.mada.jaxrs.model.types;

import org.jspecify.annotations.Nullable;

/**
 * Special type for handing object type.
 */
public final class TypeObject implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeObject instance;

    private TypeObject() {}

    /** {@return the type object representing a base object} */
    public static synchronized TypeObject get() {
        if (instance == null) {
            instance = new TypeObject();
        }
        return instance;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.OBJECT;
    }

    @Override
    public String toString() {
        return "TypeObject";
    }
}
