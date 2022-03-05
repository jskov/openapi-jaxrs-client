package dk.mada.jaxrs.openapi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.api.Content;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.api.Response;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeUUID;
import dk.mada.jaxrs.model.types.TypeVoid;

/**
 * Works through a parsed model that contains parser type
 * references and resolves them to pure model types.
 */
public class Resolver {
    private static final Logger logger = LoggerFactory.getLogger(Resolver.class);

    /**
     * Types mapped to JSE standard types.
     */
    private final Map<TypeName, Type> mappedToJseTypes = new HashMap<>();

    /**
     * JSE standard types that were not mapped (because the user opted
     * to keep them as DTOs).
     */
    private final Set<TypeName> unmappedToJseTypes = new HashSet<>();

    /**
     * Types that (via their type name) have been mapped to
     * some other types.
     */
    private final Map<TypeName, Type> remappedDtoTypes = new HashMap<>();

    /** Parser types to their dereferenced model type. */
    private final Map<ParserTypeRef, TypeReference> dereferencedTypes = new HashMap<>();

    /** Types from parsing. */
    private final ParserTypes parserTypes;

    /**
     * Create new instance.
     *
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     * @param parserTypes the types collected during parsing
     */
    public Resolver(ParserOpts parserOpts, GeneratorOpts generatorOpts, ParserTypes parserTypes) {
        this.parserTypes = parserTypes;
        TypeDateTime typeDateTime = TypeDateTime.get(generatorOpts);

        mapJse(parserOpts.isJseBigDecimal(),     TypeBigDecimal.TYPENAME_BIG_DECIMAL, TypeBigDecimal.get());
        mapJse(parserOpts.isJseUUID(),           TypeUUID.TYPENAME_UUID,              TypeUUID.get());
        mapJse(parserOpts.isJseLocalDate(),      TypeDate.TYPENAME_LOCAL_DATE,        TypeDate.get());
        mapJse(parserOpts.isJseLocalTime(),      TypeLocalTime.TYPENAME_LOCAL_TIME,   TypeLocalTime.get());
        mapJse(parserOpts.isJseLocalDateTime(),  TypeNames.of("LocalDateTime"),       typeDateTime);
        mapJse(parserOpts.isJseOffsetDateTime(), TypeNames.of("OffsetDateTime"),      typeDateTime);
        mapJse(parserOpts.isJseZonedDateTime(),  TypeNames.of("ZonedDateTime"),       typeDateTime);

        logger.info("JSE type overrides: {}", mappedToJseTypes.keySet());
        logger.info("JSE types kept: {}", unmappedToJseTypes);
    }

    private void mapJse(boolean doMap, TypeName tn, Type t) {
        if (doMap) {
            mappedToJseTypes.put(tn, t);
        } else {
            unmappedToJseTypes.add(tn);
        }
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
