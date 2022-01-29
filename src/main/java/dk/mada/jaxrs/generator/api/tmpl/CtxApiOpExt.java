package dk.mada.jaxrs.generator.api.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CtxApiOpExt {
    static ImmutableCtxApiOpExt.Builder builder() {
        return ImmutableCtxApiOpExt.builder();
    }

    @Nullable
    String produces();
    @Nullable
    String consumes();

    /**
     * Use simpler @APIResponseSchema instead of @APIResponses+@APIResponse.
     *
     * Only possible for simple classes (not containers).
     *
     * {@return whether to use the shorter ApiResponseSchema annotation}
     */
    boolean responseSchema();
}
