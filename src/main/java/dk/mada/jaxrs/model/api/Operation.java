package dk.mada.jaxrs.model.api;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Operation {
    public static ImmutableOperation.Builder builder() {
        return ImmutableOperation.builder();
    }

    String path();
    HttpMethod httpMethod();
    List<String> tags();

    @Nullable
    String operationId();
    String codegenOpId();

    @Nullable
    String description();
    boolean deprecated();

    List<Response> responses();
    List<Parameter> parameters();
    Optional<RequestBody> requestBody();

    boolean addAuthorizationHeader();
}
