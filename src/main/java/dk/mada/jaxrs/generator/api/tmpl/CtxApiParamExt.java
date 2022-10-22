package dk.mada.jaxrs.generator.api.tmpl;

import org.immutables.value.Value.Immutable;

/**
 * Extended template data for an API operation parameter.
 */
@Immutable
public interface CtxApiParamExt {
    /** {@return a builder for this type} */
    static ImmutableCtxApiParamExt.Builder builder() {
        return ImmutableCtxApiParamExt.builder();
    }

    /** {@return true if there are non-body parameters. Helps rendering quality} */
    boolean renderBodySpacing();

    /** {@return always false - used to mark template parts as to-do} */
    default boolean todo() {
        return false;
    }
}
