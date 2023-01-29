package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.Optional;

import org.immutables.value.Value.Immutable;

/**
 * Context for bean validation.
 */
@Immutable
public interface CtxValidation {
    /** {@return a builder for this type} */
    static ImmutableCtxValidation.Builder builder() {
        return ImmutableCtxValidation.builder();
    }

    /** {@return true if bean validation annotations should be rendered, otherwise false} */
    boolean renderAnnotations();

    /** {@return true if the property must be valid, otherwise false} */
    boolean valid();

    /** {@return true if the value is required (NotNull), otherwise false} */
    boolean required();

    /** {@return optional validation minimum length} */
    Optional<String> minLength();

    /** {@return optional validation maximum length} */
    Optional<String> maxLength();

    /** {@return optional validation minimum} */
    Optional<String> minimum();

    /** {@return optional validation maximum} */
    Optional<String> maximum();

    /** {@return optional validation decimalMinimum} */
    Optional<String> decimalMinimum();

    /** {@return optional validation decimalMaximum} */
    Optional<String> decimalMaximum();

    /** {@return optional validation pattern} */
    Optional<String> pattern();
}
