package dk.mada.jaxrs.model.types;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Validation;

/**
 * Validation annotations for a type.
 *
 * This is not a proper type, but just a carrier
 */
@Immutable
public interface TypeValidation extends Type {
    /**
     * Creates a new validation carrier type.
     *
     * @param validation the validation object
     * @return a dummy type carrying a validation
     */
    static TypeValidation of(Validation validation) {
        return ImmutableTypeValidation.builder()
                .validation(validation).typeName(TypeNames.MARKER_VALIDATION).build();
    }

    /** {@return the validation carried by this dummy type} */
    Validation validation();

    @Override
    default boolean isValidation() {
        return true;
    }
}
