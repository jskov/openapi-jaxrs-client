package dk.mada.jaxrs.generator.api.tmpl;

import java.util.Optional;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Template data for an API operation response.
 */
@Immutable
public interface CtxApiResponse {
    /** {@return a builder for this type} */
    static ImmutableCtxApiResponse.Builder builder() {
        return ImmutableCtxApiResponse.builder();
    }

    /** {@return the HTTP response of this response (or 'default')} */
    String code();
    /** {@return the optional description of this response} */
    Optional<String> description();
    /** {@return the type of this response, or null} */
    @Nullable
    String baseType();
    /** {@return the container type of this response, or null} */
    @Nullable
    String containerType();
    /** {@return true if the container is a set (array with unique elements)} */
    boolean isUnique();
}
