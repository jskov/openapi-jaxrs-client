package dk.mada.jaxrs.model;

import java.math.BigDecimal;
import java.util.Optional;
import org.jspecify.annotations.Nullable;

/**
 * Models the validation requirements for a type or its reference.
 *
 * @param required   validation flag required
 * @param nullable   validation flag nullable
 * @param readonly   validation flag read-only
 * @param _minItems  optional validation minimal items
 * @param _maxItems  optional validation maxmimal items
 * @param _minLength optional validation minimal length
 * @param _maxLength optional validation maxmimal length
 * @param _minimum   optional validation minimum
 * @param _maximum   optional validation maximum
 * @param _pattern   optional validation pattern
 */
public record Validation(
        boolean required,
        boolean nullable,
        @Nullable Boolean readonly,
        @Nullable Integer _minItems,
        @Nullable Integer _maxItems,
        @Nullable Integer _minLength,
        @Nullable Integer _maxLength,
        @Nullable BigDecimal _minimum,
        @Nullable BigDecimal _maximum,
        @Nullable String _pattern) {

    private static Validation EMPTY_VALIDATION =
            new Validation(false, false, null, null, null, null, null, null, null, null);
    private static Validation REQUIRED_VALIDATION =
            new Validation(true, false, null, null, null, null, null, null, null, null);

    /** {@return an empty validation} */
    public static Validation empty() {
        return EMPTY_VALIDATION;
    }

    /** {@return a validation which required set} */
    public static Validation validationRequired() {
        return REQUIRED_VALIDATION;
    }

    /** {@return true if this is a simple empty/no validation} */
    public boolean isEmptyValidation() {
        return this.equals(EMPTY_VALIDATION);
    }

    /** {@return true if read-only is set} */
    public boolean isReadOnly() {
        return readonly != null && readonly.booleanValue();
    }

    /** {@return the optional minimal items} */
    public Optional<Integer> minItems() {
        return Optional.ofNullable(_minItems);
    }

    /** {@return the optional maximal items} */
    public Optional<Integer> maxItems() {
        return Optional.ofNullable(_maxItems);
    }

    /** {@return the optional minimal length} */
    public Optional<Integer> minLength() {
        return Optional.ofNullable(_minLength);
    }

    /** {@return the optional maximal length} */
    public Optional<Integer> maxLength() {
        return Optional.ofNullable(_maxLength);
    }

    /** {@return the optional minimum} */
    public Optional<BigDecimal> minimum() {
        return Optional.ofNullable(_minimum);
    }

    /** {@return the optional maximum} */
    public Optional<BigDecimal> maximum() {
        return Optional.ofNullable(_maximum);
    }

    /** {@return the optional pattern} */
    public Optional<String> pattern() {
        return Optional.ofNullable(_pattern);
    }
}
