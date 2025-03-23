package dk.mada.jaxrs.generator.mpclient.api.tmpl;

import java.util.Optional;
import org.jspecify.annotations.Nullable;

/**
 * Template data for an API operation response.
 *
 * @param code          the HTTP response of this response (or 'default')
 * @param description   the description of this response
 * @param baseType      the type of this response, or null
 * @param containerType the container type of this response, or null
 * @param mediaType     the media-type of this response if necessary
 * @param isUnique      true if the container is a set (array with unique
 *                      elements)
 */
public record CtxApiResponse(
        String code,
        String description,
        @Nullable String baseType,
        @Nullable String containerType,
        Optional<String> mediaType,
        boolean isUnique) {}
