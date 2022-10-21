package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

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
}
