package dk.mada.jaxrs.model.api;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Models the response for a resource call.
 */
@Immutable
public interface Response {
    /** {@return a builder for this type} */
    static ImmutableResponse.Builder builder() {
        return ImmutableResponse.builder();
    }

    /** {@return the status code of this response} */
    StatusCode code();
    /** {@return the content of this response} */
    Content content();

    /** {@return the description of this response} */
    @Nullable
    String description();

    /** {@return true if this is a void-response} */
    default boolean isVoid() {
        return content().reference().isVoid();
    }
}
