package dk.mada.jaxrs.model.api;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Information about an operation's request body.
 */
@Immutable
public interface RequestBody {
    /** {@return a builder for this type} */
    static ImmutableRequestBody.Builder builder() {
        return ImmutableRequestBody.builder();
    }

    /** {@return the request body content} */
    Content content();

    /** {@return the request body description, or null} */
    @Nullable
    String description();
    /** {@return true if the request body is required, otherwise false} */
    boolean isRequired();
}
