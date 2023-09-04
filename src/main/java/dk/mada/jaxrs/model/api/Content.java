package dk.mada.jaxrs.model.api;

import java.util.List;
import java.util.Map;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Reference;

/**
 * Models the content of a request body.
 */
@Immutable
public interface Content {
    /** {@return a builder for this type} */
    static ImmutableContent.Builder builder() {
        return ImmutableContent.builder();
    }

    /** {@return the content media types supported and their associated types} */
    Map<String, Reference> mediaTypes();

    /** {@return the list of form parameters} */
    List<Parameter> formParameters();
}
