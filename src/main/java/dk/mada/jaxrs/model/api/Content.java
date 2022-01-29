package dk.mada.jaxrs.model.api;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Type;

@Immutable
public interface Content {
    static ImmutableContent.Builder builder() {
        return ImmutableContent.builder();
    }

    Set<String> mediaTypes();
    Type type();
    // todo: per-media type example
}
