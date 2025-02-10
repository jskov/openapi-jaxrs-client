package dk.mada.jaxrs.model.types;

import org.jspecify.annotations.Nullable;

/**
 * Special type for handing an object type - that maps to java's Object
 */
public final class TypePlainObject implements Type {
    /** The single instance of this object. */
    @Nullable private static TypePlainObject instance;

    private TypePlainObject() {
        // empty
    }

    /** {@return the type object representing a plain Object} */
    public static synchronized TypePlainObject get() {
        if (instance == null) {
            instance = new TypePlainObject();
        }
        return instance;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.OBJECT;
    }

    @Override
    public boolean isPlainObject() {
        return true;
    }

    @Override
    public String toString() {
        return "TypePlainObject";
    }
}
