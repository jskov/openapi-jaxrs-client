package dk.mada.jaxrs.openapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.api.Content;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.api.Response;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeVoid;
import dk.mada.jaxrs.model.types.Types;

/**
 * Works through a parsed model that contains parser type
 * references and resolves them to pure model types.
 */
public class Resolver {
    private static final Logger logger = LoggerFactory.getLogger(Resolver.class);

    /** Parser types to their dereferenced model type. */
    private final Map<ParserTypeRef, TypeReference> dereferencedTypes = new HashMap<>();

    /** Types. */
    private final Types types;

    /**
     * Create new instance.
     *
     * @param types the types instance
     */
    public Resolver(Types types) {
        this.types = types;
    }

    /**
     * Resolves parser type references in operations.
     *
     * @param ops the operations to resolve types in
     * @return operations with pure model types
     */
    public Operations operations(Operations ops) {
        List<Operation> dereferenced = ops.getAll().stream()
            .map(this::derefOp)
            .toList();
        return new Operations(dereferenced);
    }

    private Operation derefOp(Operation op) {
        return Operation.builder().from(op)
                .responses(derefResponses(op.responses()))
                .build();
    }

    private List<Response> derefResponses(List<Response> responses) {
        return responses.stream()
                .map(this::derefResponse)
                .toList();
    }

    private Response derefResponse(Response response) {
        Content content = response.content();
        Content newContent = Content.builder().from(content)
                        .type(resolve(content.type()))
                        .build();

        return Response.builder().from(response)
                .content(newContent)
                .build();
    }

    // FIXME: maybe this should return only TypeRef with validation? But nice that void maps directly
    private Type resolve(Type type) {
        if (type instanceof ParserTypeRef ptr) {
            Type t = types.get(ptr.refTypeName());
            return dereferencedTypes.computeIfAbsent(ptr, p -> TypeReference.of(t, ptr.validation()));
        } else if (type instanceof TypeVoid) {
            return type;
        } else {
            logger.warn("NOT dereferencing {}", type);
            return type;
        }
    }
}
