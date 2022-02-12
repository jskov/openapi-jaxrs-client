package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing void type.
 */
public final class TypeVoid implements Type {
    /** The single instance of this object. */
    private static final TypeVoid INSTANCE = new TypeVoid();

    private TypeVoid() {
    }

    /** {@return the type object representing void} */
    public static TypeVoid get() {
        return INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.of("void");
    }

    @Override
    public boolean isVoid() {
        return true;
    }
}
