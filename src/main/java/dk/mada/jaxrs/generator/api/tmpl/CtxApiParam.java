package dk.mada.jaxrs.generator.api.tmpl;

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

    /** {@return base name of a path parameter} */
    String baseName();
    /** {@return the name given to the parameter in the function} */
    String paramName();
    /** {@return the java type of the parameter} */
    String dataType();
    /** {@return true if the parameter is required, otherwise false} */
    boolean required();

    /** {@return true if this is the body parameter, otherwise false} */
    boolean isBodyParam();
    /** {@return true if this is a header parameter, otherwise false} */
    boolean isHeaderParam();
    /** {@return true if this is a path parameter, otherwise false} */
    boolean isPathParam();
    /** {@return true if this is a query parameter, otherwise false} */
    boolean isQueryParam();

    /** {@return true if bean validation should be used for this paramater, otherwise false} */
    boolean useBeanValidation();

    /** {@return additional custom template data for the parameter} */
    CtxApiParamExt madaParam();
}
