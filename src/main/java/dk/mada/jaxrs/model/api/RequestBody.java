package dk.mada.jaxrs.model.api;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface RequestBody {
    static ImmutableRequestBody.Builder builder() {
        return ImmutableRequestBody.builder();
    }

    Content content();

    @Nullable
    String description();
    boolean isRequired();
}
