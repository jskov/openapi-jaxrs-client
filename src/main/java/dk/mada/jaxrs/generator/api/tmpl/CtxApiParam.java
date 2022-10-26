package dk.mada.jaxrs.generator.api.tmpl;

import javax.annotation.Nullable;

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
    /** {@return a parameter description, or null} */
    @Nullable
    String description();
    /** {@return a default value for the parameter, or null} */
    @Nullable
    String defaultValue();
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
    /** {@return validation minimum length, or null} */
    @Nullable
    String minLength();
    /** {@return validation maximum length, or null} */
    @Nullable
    String maxLength();
    /** {@return validation minimum, or null} */
    @Nullable
    String minimum();
    /** {@return validation maximum, or null} */
    @Nullable
    String maximum();
    /** {@return validation decimalMinimum, or null} */
    @Nullable
    String decimalMinimum();
    /** {@return validation decimalMaximum, or null} */
    @Nullable
    String decimalMaximum();
    /** {@return validation pattern, or null} */
    @Nullable
    String pattern();

    /** {@return additional custom template data for the parameter} */
    CtxApiParamExt madaParam();
}
