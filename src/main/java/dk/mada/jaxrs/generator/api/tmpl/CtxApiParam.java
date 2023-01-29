package dk.mada.jaxrs.generator.api.tmpl;

import java.util.Optional;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.dto.tmpl.CtxValidation;

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

    /** {@return context for bean validation if relevant for this parameter} */
    Optional<CtxValidation> validation();
}
