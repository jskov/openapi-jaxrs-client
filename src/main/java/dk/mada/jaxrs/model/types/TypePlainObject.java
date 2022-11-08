package dk.mada.jaxrs.model.types;

/**
 * Special type for handing an object type - that maps to java's Object
 */
public final class TypePlainObject implements Type {
    /** The single instance of this object. */
    private static final TypePlainObject INSTANCE = new TypePlainObject();

    private TypePlainObject() {
    }

    /** {@return the type object representing a plain Object} */
    public static TypePlainObject get() {
        return INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.OBJECT;
    }

    @Override
    public String toString() {
        return "TypePlainObject";
    }
}
