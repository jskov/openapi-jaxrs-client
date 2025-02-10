package dk.mada.jaxrs.generator.mpclient.api.tmpl;

import java.util.Optional;
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
     * {@return the optional @Produces value for the operation}
     */
    Optional<String> produces();

    /**
     * {@return the optional @Consumes value for the operation}
     */
    Optional<String> consumes();

    /**
     * Use simpler @APIResponseSchema instead of @APIResponses+@APIResponse.
     *
     * Only possible for simple classes (not containers).
     *
     * @return true if the shorter ApiResponseSchema annotation should be used
     */
    boolean responseSchema();

    /** {@return true if the operation has any responses, otherwise false} */
    boolean hasResponses();

    /** {@return an optional summary as a java string} */
    Optional<String> summaryString();
}
