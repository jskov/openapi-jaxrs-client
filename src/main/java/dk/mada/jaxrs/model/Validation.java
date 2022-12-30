package dk.mada.jaxrs.model;

import java.math.BigDecimal;
import java.util.Optional;

import org.immutables.value.Value.Immutable;

/**
 * Models the validation requirements for a type/property/parameter.
 */
@Immutable
public interface Validation {
    /** No validation input. */
    Validation NO_VALIDATION = Validation.builder().isRequired(false).build();

    /** {@return a builder for this type} */
    static ImmutableValidation.Builder builder() {
        return ImmutableValidation.builder();
    }

    /** {@return true if this is an empty validation, otherwise false} */
    default boolean isEmptyValidation() {
        return this == NO_VALIDATION;
    }

    /** {@return optional nullable state for the reference} */
    Optional<Boolean> isNullable();

    /** {@return optional read-only state for the reference} */
    Optional<Boolean> isReadonly();

    /** {@return true if the property is required, otherwise false} */
    boolean isRequired();

    /** {@return optional validation minimum items} */
    Optional<Integer> minItems();

    /** {@return optional validation maximum items} */
    Optional<Integer> maxItems();

    /** {@return optional validation minimum length} */
    Optional<Integer> minLength();

    /** {@return optional validation maximum length} */
    Optional<Integer> maxLength();

    /** {@return optional validation minimum} */
    Optional<BigDecimal> minimum();

    /** {@return optional validation maximum} */
    Optional<BigDecimal> maximum();

    /** {@return optional validation pattern} */
    Optional<String> pattern();
}
