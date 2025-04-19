package dk.mada.jaxrs.generator.mpclient.api.tmpl;

import java.util.List;
import java.util.Optional;

/**
 * Extended template data for a resource class.
 *
 * @param mpRestClientConfigKey the optional micro profile rest client config key
 * @param mpProviders the fully qualified class names of MP providers
 * @param isJspecify true if jspecify Nullable annotations should be used
 * @param additionalAnnotations a list of additional annotation lines
 */
public record CtxApiExt(
        Optional<String> mpRestClientConfigKey,
        List<String> mpProviders,
        boolean isJspecify,
        List<String> additionalAnnotations) {}
