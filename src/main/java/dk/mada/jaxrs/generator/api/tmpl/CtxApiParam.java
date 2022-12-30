package dk.mada.jaxrs.generator.api.tmpl;

import java.util.Optional;

import org.immutables.value.Value.Immutable;

/**
 * Template data for an API operation parameter.
 */
@Immutable
public interface CtxApiParam {
    /** {@return a builder for this type} */
    static ImmutableCtxApiParam.Builder builder() {
        return ImmutableCtxApiParam.builder();
    }

    /** {@return true if the parameter is a container} */
    boolean isContainer();

    /** {@return an optional description of the parameter} */
    Optional<String> description();

    /** {@return an optional default value for the parameter} */
    Optional<String> defaultValue();

    /** {@return base name of a path parameter} */
    String baseName();

    /** {@return the name given to the parameter in the function} */
    String paramName();

    /** {@return the java type of the parameter} */
    String dataType();

    /** {@return true if this is the body parameter, otherwise false} */
    boolean isBodyParam();

    /** {@return true if this is a header parameter, otherwise false} */
    boolean isHeaderParam();

    /** {@return true if this is a path parameter, otherwise false} */
    boolean isPathParam();

    /** {@return true if this is a query parameter, otherwise false} */
    boolean isQueryParam();

    /** {@return true if this is a form parameter, otherwise false} */
    boolean isFormParam();

    /** {@return true if bean validation should be used for this parameter, otherwise false} */
    boolean useBeanValidation();

    /** {@return true if the parameter is required, otherwise false} */
    boolean required();

    /** {@return true if the parameter must be valid, otherwise false} */
    boolean valid();

    /** {@return an optional validation minimum length} */
    Optional<String> minLength();

    /** {@return an optional validation maximum length} */
    Optional<String> maxLength();

    /** {@return an optional validation minimum} */
    Optional<String> minimum();

    /** {@return an optional validation maximum} */
    Optional<String> maximum();

    /** {@return an optional validation decimalMinimum} */
    Optional<String> decimalMinimum();

    /** {@return an optional validation decimalMaximum} */
    Optional<String> decimalMaximum();

    /** {@return an optional validation pattern} */
    Optional<String> pattern();
}
