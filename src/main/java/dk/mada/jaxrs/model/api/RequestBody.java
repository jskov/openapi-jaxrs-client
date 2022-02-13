package dk.mada.jaxrs.model.api;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface RequestBody {
    /** {@return a builder for this type} */
    static ImmutableRequestBody.Builder builder() {
        return ImmutableRequestBody.builder();
    }

    Content content();

    @Nullable
    String description();
    boolean isRequired();
}
