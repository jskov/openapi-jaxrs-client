package dk.mada.jaxrs.generator.api;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.openapi.ContentSelector.ContentContext;
import dk.mada.jaxrs.openapi.ContentSelector.Location;
import dk.mada.jaxrs.openapi.ParserOpts;

/**
 * Selects content based on configuration.
 *
 * Some requests or responses may contain multiple media-types.
 *
 * The options parser-api-preferred-response-mediatypes and parser-api-preferred-reply-mediatypes can be used to control
 * which type is selected.
 *
 * TODO: clone of code in .openapi. Need to converge somehow. Maybe delay selection to render time instead.
 */
public class ContentSelector {
    private static final Logger logger = LoggerFactory.getLogger(ContentSelector.class);

    /** Preferred request media types. */
    private final List<Pattern> preferredRequestMediaTypes;
    /** Preferred response media types. */
    private final List<Pattern> preferredResponseMediaTypes;

    /**
     * Constructs a new selector instance.
     *
     * @param parseOpts the parser options
     */
    public ContentSelector(ParserOpts parseOpts) {
        preferredRequestMediaTypes = parseOpts.getPreferredRequestMediaTypes().stream()
                .map(Pattern::compile)
                .toList();
        preferredResponseMediaTypes = parseOpts.getPreferredResponseMediaTypes().stream()
                .map(Pattern::compile)
                .toList();
    }

    /**
     * Select preferred media type,
     *
     * @param mediaTypes the possible media types
     * @param context    the selection context
     * @return the selected context
     */
    public Optional<String> selectPreferredMediaType(List<String> mediaTypes, ContentContext context) {
        if (mediaTypes.isEmpty()) {
            return Optional.empty();
        }
        if (mediaTypes.size() == 1) {
            return Optional.of(mediaTypes.get(0));
        }

        List<Pattern> preferredMediaTypes = context.location() == Location.REQUEST ? preferredRequestMediaTypes
                : preferredResponseMediaTypes;

        // Find first match in preference order
        for (Pattern p : preferredMediaTypes) {
            for (String mediaType : mediaTypes) {
                if (p.matcher(mediaType).matches()) {
                    return Optional.of(mediaType);
                }
            }
        }

        logger.warn("Preferred patterns: {}", preferredMediaTypes);
        logger.warn("Media types: {}", mediaTypes);

        throw new IllegalStateException(
                "Path " + context.resourcePath() + " has multiple content types. Use " + context.location().optionName() + " to select");
    }
}
