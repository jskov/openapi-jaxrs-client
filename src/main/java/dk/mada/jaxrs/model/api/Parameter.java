package dk.mada.jaxrs.model.api;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeRef;

/**
 * Information about a single parameter.
 */
@Immutable
public interface Parameter {
    /** {@return a builder for this type} */
    static ImmutableParameter.Builder builder() {
        return ImmutableParameter.builder();
    }

    /** {@return parameter name} */
    String name();
    /** {@return parameter type} */
    Type type();

    /** {@return validation requirements for the parameter, or null} */
    @Nullable
    default Validation validation() {
        Type t = type();
        if (t instanceof TypeRef tr) {
            return tr.validation();
        }
        return null;
    }

    /** {@return parameter description, or null} */
    @Nullable
    String description();
    /** {@return true if the parameter is required, otherwise false} */
    boolean isRequired();

    /** {@return true if the parameter is a header parameter, otherwise false} */
    boolean isHeaderParam();
    /** {@return true if the parameter is a path parameter, otherwise false} */
    boolean isPathParam();
    /** {@return true if the parameter is a query parameter, otherwise false} */
    boolean isQueryParam();
}
