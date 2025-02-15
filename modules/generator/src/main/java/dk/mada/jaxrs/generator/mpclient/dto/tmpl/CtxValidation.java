package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import org.jspecify.annotations.Nullable;

/**
 * Context for bean validation.
 */
public record CtxValidation(String renderedValidation, String javadocPropertyComment, @Nullable String javadoc) {}
