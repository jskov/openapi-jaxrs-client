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
    Validation NO_VALIDATION = Validation.builder()
            .isRequired(false)
            .isRelaxed(false)
            .build();

    /** Simple required validation. */
    Validation REQUIRED_VALIDATION = Validation.builder()
            .isRequired(true)
            .isRelaxed(false)
            .build();

    /** {@return a builder for this type} */
    static ImmutableValidation.Builder builder() {
        return ImmutableValidation.builder();
    }

    /** {@return true if this is an empty validation, otherwise false} */
    default boolean isEmptyValidation() {
        return this == NO_VALIDATION;
    }

    /** {@return optional required state for the reference} */
    Optional<Boolean> isRequired();

    /** {@return optional nullable state for the reference} */
    Optional<Boolean> isNullable();

    /** {@return optional read-only state for the reference} */
    Optional<Boolean> isReadonly();

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

    /**
     * Flag to tell that a validation is relaxed to appear in a combined DTO.
     *
     * FIXME: should be kept and resolved in the parser!
     * @return true if this validation is intentionally relaxed
     */
    boolean isRelaxed();
}
