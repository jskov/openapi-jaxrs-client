package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import org.jspecify.annotations.Nullable;

/**
 * Context for bean validation.
 *
 * @param renderedValidation validation annotations for the type
 * @param renderedContainerValidation validation annotations for the outer container (if relevant - not used for rendering)
 * @param javadocParamComment comments to add to end of param description
 * @param javadoc additional javadoc for accessor methods
 */
public record CtxValidation(
        String renderedValidation,
        String renderedContainerValidation,
        String javadocParamComment,
        @Nullable String javadoc) {}
