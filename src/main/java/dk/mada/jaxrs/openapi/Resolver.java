package dk.mada.jaxrs.openapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.api.Content;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.api.Response;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeVoid;

/**
 * Works through a parsed model that contains parser type
 * references and resolves them to pure model types.
 */
public class Resolver {
    private static final Logger logger = LoggerFactory.getLogger(Resolver.class);

    /** Parser types to their dereferenced model type. */
    private final Map<ParserTypeRef, TypeReference> dereferencedTypes = new HashMap<>();

    /** Types from parsing. */
    private final ParserTypes parserTypes;

    /**
     * Create new instance.
     *
     * @param parserTypes the types collected during parsing
     */
    public Resolver(ParserTypes parserTypes) {
        this.parserTypes = parserTypes;
    }

    /**
     * Converts the ParserTypes into finally resolved
     * and mapped DTOs for the model.
     *
     * @return DTOs for the model
     */
    public List<TypeReference> getDtos() {
        return parserTypes.getDtos().stream()
                .map(this::derefDto)
                .map(dto -> TypeReference.of(dto, Validation.NO_VALIDATION))
                .toList();
    }

    private Dto derefDto(Dto dto) {
        logger.info(" - deref DTO {} : {}", dto.name(), dto.dtoType());
        return Dto.builder().from(dto)
                .dtoType(resolve(dto.dtoType()))
                .build();
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
            Type t = parserTypes.get(ptr.refTypeName());
            return dereferencedTypes.computeIfAbsent(ptr, p -> TypeReference.of(t, ptr.validation()));
        } else if (type instanceof TypeVoid) {
            return type;
        } else if (type instanceof TypeArray ta) {
            Type it = ta.innerType();
            Type newIt = resolve(it);
            logger.info(" array {} -> {}", it, newIt);
            return TypeArray.of(newIt);
        } else if (type instanceof TypeSet ts) {
            Type it = ts.innerType();
            Type newIt = resolve(it);
            logger.info(" set {} -> {}", it, newIt);
            return TypeSet.of(newIt);
        } else if (type instanceof TypeMap tm) {
            Type it = tm.innerType();
            Type newIt = resolve(it);
            logger.info(" map {} -> {}", it, newIt);
            return TypeMap.of(newIt);
        } else {
            logger.warn("NOT dereferencing {}", type);
            return type;
        }
    }
}
