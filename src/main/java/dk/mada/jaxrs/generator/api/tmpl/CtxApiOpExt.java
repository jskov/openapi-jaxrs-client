package dk.mada.jaxrs.generator.api.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CtxApiOpExt {
    public static ImmutableCtxApiOpExt.Builder builder() {
        return ImmutableCtxApiOpExt.builder();
    }

    @Nullable
    String produces();
    @Nullable
    String consumes();
}
