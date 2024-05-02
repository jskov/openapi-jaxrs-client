package dk.mada.jaxrs.model.api;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Selects content based on configuration.
 *
 * Some requests or responses may contain multiple media-types.
 *
 * The options parser-api-preferred-response-mediatypes and parser-api-preferred-reply-mediatypes can be used to control
 * which type is selected.
 */
public class ContentSelector {
    private static final Logger logger = LoggerFactory.getLogger(ContentSelector.class);

    /** Preferred request media types option name. Not a super placement! */
    public static final String PARSER_API_PREFERRED_REQUEST_MEDIATYPES = "parser-api-preferred-request-mediatypes";
    /** Preferred response media types option name. Not a super placement! */
    public static final String PARSER_API_PREFERRED_RESPONSE_MEDIATYPES = "parser-api-preferred-response-mediatypes";

    /** Preferred request media types. */
    private final List<Pattern> preferredRequestMediaTypes;
    /** Preferred response media types. */
    private final List<Pattern> preferredResponseMediaTypes;

    /**
     * Constructs a new selector instance.
     *
     * @param preferredRequestMediaTypes  a list of patterns for matching request media types
     * @param preferredResponseMediaTypes a list of patterns for matching response media types
     */
    public ContentSelector(List<Pattern> preferredRequestMediaTypes, List<Pattern> preferredResponseMediaTypes) {
        this.preferredRequestMediaTypes = preferredRequestMediaTypes;
        this.preferredResponseMediaTypes = preferredResponseMediaTypes;
    }

    /**
     * Select preferred media type,
     *
     * @param mediaTypes the possible media types
     * @param context    the selection context
     * @return the selected context
     */
    public Optional<String> selectPreferredMediaType(Collection<String> mediaTypes, ContentContext context) {
        if (mediaTypes.isEmpty()) {
            return Optional.empty();
        }
        if (mediaTypes.size() == 1) {
            return Optional.of(mediaTypes.iterator().next());
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

    /**
     * The context of a content lookup.
     *
     * @param resourcePath       the resource path where the content needs lookup. Used for error output only.
     * @param statuscode         the status code of the context (HTTP_DEFAULT for requests)
     * @param isRequired         true if the content is required
     * @param location           the location of the content
     * @param syntheticMultipart flag to communicate this context will get a synthetic multipart DTO created
     */
    public record ContentContext(String resourcePath, StatusCode statuscode, boolean isRequired, Location location,
            boolean syntheticMultipart) {
    }

    /** Location of the content to resolve. */
    public enum Location {
        /** Marks the request part of the operation. */
        REQUEST(PARSER_API_PREFERRED_REQUEST_MEDIATYPES),
        /** Marks the response part of the operation. */
        RESPONSE(PARSER_API_PREFERRED_RESPONSE_MEDIATYPES);

        /** The option name necessary to control selection at this location. */
        private final String optionName;

        Location(String optionName) {
            this.optionName = optionName;
        }

        /** {@return the option name necessary to control selection at this location} */
        public String optionName() {
            return optionName;
        }
    }
}
