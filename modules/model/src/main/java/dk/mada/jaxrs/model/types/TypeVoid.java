package dk.mada.jaxrs.model.types;

import org.jspecify.annotations.Nullable;

import dk.mada.jaxrs.model.Validation;

/**
 * Special type for handing void type.
 */
public final class TypeVoid implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeVoid instance;

    /** The single reference instance of this object. */
    @Nullable private static TypeReference refInstance;

    private TypeVoid() {
    }

    /** {@return the type object representing void} */
    public static synchronized TypeVoid get() {
        if (instance == null) {
            instance = new TypeVoid();
        }
        return instance;
    }

    /** {@return the reference to void} */
    public static TypeReference getRef() {
        if (refInstance == null) {
            refInstance = TypeReference.of(get(), Validation.NO_VALIDATION);
        }
        return refInstance;
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
