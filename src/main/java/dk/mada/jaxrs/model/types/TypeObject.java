package dk.mada.jaxrs.model.types;

/**
 * Special type for handing object type.
 */
public final class TypeObject implements Type {
    /** The single instance of this object. */
    private static final TypeObject INSTANCE = new TypeObject();

    private TypeObject() {
    }

    /** {@return the type object representing a base object} */
    public static TypeObject get() {
        return INSTANCE;
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
