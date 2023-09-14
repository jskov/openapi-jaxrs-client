package dk.mada.jaxrs.model.api;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Reference;

/**
 * Models the content of a request or response.
 *
 * See https://swagger.io/docs/specification/describing-request-body/multipart-requests/
 *
 * The form-parameters are extracted and moved up to the RequestBody since that makes more sense to me at present.
 */
@Immutable
public interface Content {
    /** {@return a builder for this type} */
    static ImmutableContent.Builder builder() {
        return ImmutableContent.builder();
    }

    /** {@return the content media types supported} */
    Set<String> mediaTypes();

    /** {@return the content type} */
    Reference reference();
}
