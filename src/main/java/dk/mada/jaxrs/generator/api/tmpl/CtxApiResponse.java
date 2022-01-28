package dk.mada.jaxrs.generator.api.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CtxApiResponse {
    public static ImmutableCtxApiResponse.Builder builder() {
        return ImmutableCtxApiResponse.builder();
    }

    String code();
    String description();
    @Nullable
    String baseType();
    @Nullable
    String containerType();
    boolean isUnique();
}
