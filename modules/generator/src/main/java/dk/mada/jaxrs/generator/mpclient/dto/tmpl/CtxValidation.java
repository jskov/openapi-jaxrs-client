package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import org.jspecify.annotations.Nullable;

/**
 * Context for bean validation.
 *
 * @param renderedValidation validation annotations
 * @param javadocParamComment comments to add to end of param description
 * @param javadoc additional javadoc for accessor methods
 */
public record CtxValidation(String renderedValidation, String javadocParamComment, @Nullable String javadoc) {}
