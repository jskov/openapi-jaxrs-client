package dk.mada.jaxrs.model.api;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Response {
    public static ImmutableResponse.Builder builder() {
        return ImmutableResponse.builder();
    }

    int code();
    Content content();

    @Nullable
    String description();
}
