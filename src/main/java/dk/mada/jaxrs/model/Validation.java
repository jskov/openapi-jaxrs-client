package dk.mada.jaxrs.model;

import java.math.BigDecimal;

import javax.annotation.Nullable;

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

    /** {@return true if the property can be null, otherwise false. Null if not specified} */
    @Nullable
    Boolean isNullable();
    /** {@return true if the property is read-only, otherwise false. Null if not specified} */
    @Nullable
    Boolean isReadonly();
    /** {@return true if the property is required, otherwise false} */
    boolean isRequired();

    /** {@return validation minimum items, or null} */
    @Nullable
    Integer minItems();
    /** {@return validation maximum items, or null} */
    @Nullable
    Integer maxItems();
    /** {@return validation minimum, or null} */
    /** {@return validation minimum length, or null} */
    @Nullable
    Integer minLength();
    /** {@return validation maximum length, or null} */
    @Nullable
    Integer maxLength();
    /** {@return validation minimum, or null} */
    @Nullable
    BigDecimal minimum();
    /** {@return validation maximum, or null} */
    @Nullable
    BigDecimal maximum();
    /** {@return validation pattern, or null} */
    @Nullable
    String pattern();
}
