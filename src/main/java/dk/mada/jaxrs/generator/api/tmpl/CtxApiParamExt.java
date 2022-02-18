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
}
