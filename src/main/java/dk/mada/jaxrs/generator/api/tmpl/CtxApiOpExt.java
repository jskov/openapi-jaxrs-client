package dk.mada.jaxrs.generator.api.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CtxApiOpExt {
    /** {@return a new builder of this class} */
    static ImmutableCtxApiOpExt.Builder builder() {
        return ImmutableCtxApiOpExt.builder();
    }

    /**
     * {@return the @Produces value for the operation} If null it is not rendered.
     */
    @Nullable
    String produces();

    /**
     * {@return the @Consumes value for the operation} If null it is not rendered.
     */
    @Nullable
    String consumes();

    /**
     * Use simpler @APIResponseSchema instead of @APIResponses+@APIResponse.
     *
     * Only possible for simple classes (not containers).
     *
     * @return true if the shorter ApiResponseSchema annotation should be used
     */
    boolean responseSchema();
}
