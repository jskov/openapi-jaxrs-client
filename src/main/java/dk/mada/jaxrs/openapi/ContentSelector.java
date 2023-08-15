package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.api.Content;
import dk.mada.jaxrs.model.api.Parameter;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.TypeVoid;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Selects content based on configuration.
 *
 * Some requests or responses may contain multiple media-types.
 *
 * The options parser-api-preferred-response-mediatypes and
 * parser-api-preferred-reply-mediatypes can be used to control
 * which type is selected.
 */
public class ContentSelector {
	private static final Logger logger = LoggerFactory.getLogger(ContentSelector.class);

    /** Type converter. */
    private final TypeConverter typeConverter;
    /** Preferred request media types. */
	private final List<Pattern> preferredRequestMediaTypes;
    /** Preferred response media types. */
	private final List<Pattern> preferredResponseMediaTypes;

    /**
     * Constructs a new selector instance.
     *
     * @param parseOpts       the parser options
     * @param typeConverter   the type converter
     */
    public ContentSelector(ParserOpts parseOpts, TypeConverter typeConverter) {
        this.typeConverter = typeConverter;
        
        preferredRequestMediaTypes = parseOpts.getPreferredRequestMediaTypes().stream()
        	.map(Pattern::compile)
        	.toList();
        preferredResponseMediaTypes = parseOpts.getPreferredResponseMediaTypes().stream()
            	.map(Pattern::compile)
            	.toList();
    }

    /** Location of the content to resolve. */
    public enum Location {
    	REQUEST(ParserOpts.PARSER_API_PREFERRED_REQUEST_MEDIATYPES),
    	RESPONSE(ParserOpts.PARSER_API_PREFERRED_RESPONSE_MEDIATYPES);
    	
    	public final String optionName;

		private Location(String optionName) {
			this.optionName = optionName;
		}
    }

    /**
     * The context of a content lookup.
     *
     * @param resourcePath the resource path where the content needs lookup. Used for error output only.
     * @param isRequired   true if the content is required
     * @param location     the location of the content
     */
    public record ContentContext(String resourcePath, boolean isRequired, Location location) {
    }

    /**
     * Selects desired content implementation from context and configuration.
     *
     * @param c       the OpenApi content to select from
     * @param context the context where the content is looked up from
     * @return the selected (model) content
     */
    public Content selectContent(io.swagger.v3.oas.models.media.Content c, ContentContext context) {
        Reference ref;
        Set<String> mediaTypes;
        List<Parameter> formParameters = List.of();

        if (c == null) {
            ref = TypeVoid.getRef();
            mediaTypes = Set.of();
        } else {
            mediaTypes = c.keySet();

            @SuppressWarnings("rawtypes")
            Set<Schema> schemas = c.values().stream()
                    .map(MediaType::getSchema)
                    .collect(toSet());

            if (schemas.isEmpty()) {
                ref = TypeVoid.getRef();
            } else {
            	Schema<?> ss = getPreferredSchema(c, context);

                if (ss == null) {
                    // This happens in some documents
                    ref = TypeVoid.getRef();
                } else {
                    ref = typeConverter.toReference(ss, context.isRequired());

                    // form parameters via properties on body
                    @SuppressWarnings({ "rawtypes" })
                    Map<String, Schema> props = ss.getProperties();
                    if (props != null) {
                        formParameters = props.entrySet().stream()
                                .map(e -> toFormParameter(e.getKey(), e.getValue()))
                                .toList();
                    }
                }
            }
        }
        logger.debug("Content reference {}", ref);

        return Content.builder()
                .mediaTypes(mediaTypes)
                .reference(ref)
                .formParameters(formParameters)
                .build();
	}
    
    private Schema<?> getPreferredSchema(io.swagger.v3.oas.models.media.Content c, ContentContext context) {
    	// Selection implied when only one media type
    	if (c.size() == 1) {
    		return c.values().iterator().next().getSchema();
    	}

    	List<Pattern> preferredMediaTypes = context.location == Location.REQUEST ? preferredRequestMediaTypes : preferredResponseMediaTypes;

    	// Find first match in preference order
    	for (Pattern p : preferredMediaTypes) {
    		for (var e : c.entrySet()) {
    			String mediaType = e.getKey();
    			if (p.matcher(mediaType).matches()) {
    				return e.getValue().getSchema();
    			}
    		}
    	}

		throw new IllegalStateException("Path " + context.resourcePath + " has multiple content types. Use " + context.location.optionName + " to select");
    }
    
    // At least an enum parameter may have to be rendered as a standalone
    // type (DTO). This does not happen with this code alone.
    private Parameter toFormParameter(String name, @SuppressWarnings("rawtypes") Schema schema) {
        ParserTypeRef dtoPtr = typeConverter.reference(schema, name, null);
        logger.debug("Parse form param {} : {}", name, dtoPtr);

        return Parameter.builder()
                .name(name)
                .isHeaderParam(false)
                .isPathParam(false)
                .isQueryParam(false)
                .isFormParam(true)
                .reference(dtoPtr)
                .build();
    }
}
