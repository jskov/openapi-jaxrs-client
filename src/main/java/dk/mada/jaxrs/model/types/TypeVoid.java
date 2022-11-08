package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.Validation;

/**
 * Special type for handing void type.
 */
public final class TypeVoid implements Type {
    /** The single instance of this object. */
    private static final TypeVoid INSTANCE = new TypeVoid();

    /** The single reference instance of this object. */
    private static final TypeReference REF_INSTANCE = TypeReference.of(INSTANCE, Validation.NO_VALIDATION);

    private TypeVoid() {
    }

    /** {@return the type object representing void} */
    public static TypeVoid get() {
        return INSTANCE;
    }

    /** {@return the reference to void} */
    public static TypeReference getRef() {
        return REF_INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.VOID;
    }

    @Override
    public boolean isVoid() {
        return true;
    }
}
