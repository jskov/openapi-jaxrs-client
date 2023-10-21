package dk.mada.jaxrs.generator.mpclient.api.tmpl;

import java.util.Optional;

import org.immutables.value.Value.Immutable;
import org.jspecify.annotations.Nullable;

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
    @Nullable String baseType();

    /** {@return the container type of this response, or null} */
    @Nullable String containerType();

    /** {@return the media-type of this response if necessary} */
    Optional<String> mediaType();

    /** {@return true if the container is a set (array with unique elements)} */
    boolean isUnique();
}
