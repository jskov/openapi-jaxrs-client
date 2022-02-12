package dk.mada.jaxrs.model.api;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

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

    /** {@return the operation id or null} */
    @Nullable
    String operationId();
    /** {@return the operation id as would be defined by codegen} */
    String codegenOpId();

    /** {@return the operation description or null} */
    @Nullable
    String description();
    /** {@return the operation summary or null} */
    @Nullable
    String summary();
    /** {@return true if the operation is deprecated} */
    boolean deprecated();

    /** {@return the operation responses} */
    List<Response> responses();
    /** {@return the operation parameters} */
    List<Parameter> parameters();
    /** {@return the optional request body} */
    Optional<RequestBody> requestBody();

    /** {@return true if this operation requires an authentication parameter} */
    boolean addAuthorizationHeader();
}
