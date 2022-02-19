package dk.mada.jaxrs.generator.api.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Extended template data for an API operation.
 */
@Immutable
public interface CtxApiOpExt {
    /** {@return a builder for this type} */
    static ImmutableCtxApiOpExt.Builder builder() {
        return ImmutableCtxApiOpExt.builder();
    }

    /** {@return true if a spacer is needed before javadoc macros} */
    boolean renderJavadocMacroSpacer();

    /** {@return true if the javadoc @return statement should be rendered} */
    boolean renderJavadocReturn();

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

    /** {@return the summary as a java string, or null} */
    @Nullable
    String summaryString();
}
