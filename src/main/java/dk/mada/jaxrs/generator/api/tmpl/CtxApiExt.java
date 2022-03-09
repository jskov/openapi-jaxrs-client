package dk.mada.jaxrs.generator.api.tmpl;

import java.util.List;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Extended template data for a resource class.
 */
@Immutable
public interface CtxApiExt {
    /** {@return a builder for this type} */
    static ImmutableCtxApiExt.Builder builder() {
        return ImmutableCtxApiExt.builder();
    }

    /** {@return the micro profile rest client config key, or null} */
    @Nullable
    String mpRestClientConfigKey();

    /** {@return fully qualified class names of MP providers, or null} */
    List<String> mpProviders();
}
