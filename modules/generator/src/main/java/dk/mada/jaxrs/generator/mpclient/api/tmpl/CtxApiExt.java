package dk.mada.jaxrs.generator.mpclient.api.tmpl;

import java.util.List;
import java.util.Optional;

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

    /** {@return the optional micro profile rest client config key} */
    Optional<String> mpRestClientConfigKey();

    /** {@return fully qualified class names of MP providers} */
    List<String> mpProviders();

    /** {@return true if jspecify Nullable annotations should be used} */
    boolean isJspecify();
}
