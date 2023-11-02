package dk.mada.jaxrs.model.api;

import java.util.List;
import java.util.Optional;

import org.immutables.value.Value.Immutable;

/**
 * Information about an operation's request body.
 */
@Immutable
public interface RequestBody {
    /** {@return a builder for this type} */
    static ImmutableRequestBody.Builder builder() {
        return ImmutableRequestBody.builder();
    }

    /** {@return the request body content} */
    Content content();

    /** {@return the list of form parameters} */
    List<Parameter> formParameters();

    /** {@return true if this body is a synthetic multipart body} */
    boolean isMultipartForm();

    /** {@return the an optional description of the request body} */
    Optional<String> description();
}
