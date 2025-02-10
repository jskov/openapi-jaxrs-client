package dk.mada.jaxrs.model.api;

import java.util.List;
import java.util.Optional;
import org.immutables.value.Value.Immutable;

/**
 * Information about a single operation.
 */
@Immutable
public interface Operation {
    /** {@return a builder for this type} */
    static ImmutableOperation.Builder builder() {
        return ImmutableOperation.builder();
    }

    /** {@return the operation resource path} */
    String path();

    /** {@return the operation HTTP method} */
    HttpMethod httpMethod();

    /** {@return the operation tags} */
    List<String> tags();

    /** {@return an optional operation id} */
    Optional<String> operationId();

    /** {@return a synthetic operation id computed by path and http type} */
    String syntheticOpId();

    /** {@return an optional description of the operation} */
    Optional<String> description();

    /** {@return an optional summary of the operation} */
    Optional<String> summary();

    /** {@return true if the operation is deprecated} */
    boolean deprecated();

    /** {@return the operation responses} */
    List<Response> responses();

    /** {@return the operation parameters} */
    List<Parameter> parameters();

    /** {@return the optional request body} */
    Optional<RequestBody> requestBody();

    /** {@return true if all responses on the operation are void} */
    default boolean isVoid() {
        return responses().stream().allMatch(Response::isVoid);
    }

    /** {@return true if this operation requires an authentication parameter} */
    boolean addAuthorizationHeader();

    /** {@return the (first) group of an operation} */
    default String group() {
        if (tags().isEmpty()) {
            return "Default";
        }
        return tags().get(0);
    }
}
