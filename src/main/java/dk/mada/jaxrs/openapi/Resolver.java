package dk.mada.jaxrs.openapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.api.Content;
import dk.mada.jaxrs.model.api.Operation;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.api.Parameter;
import dk.mada.jaxrs.model.api.RequestBody;
import dk.mada.jaxrs.model.api.Response;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeInterface;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;
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

    /** Type names. */
    private final TypeNames typeNames;
    /** Types from parsing. */
    private final ParserTypes parserTypes;

    private Map<String, String> renameTypes = Map.of();

    /**
     * Create new instance.
     *
     * @param typeNames the type names instance
     * @param parserTypes the types collected during parsing
     */
    public Resolver(TypeNames typeNames, ParserTypes parserTypes) {
        this.typeNames = typeNames;
        this.parserTypes = parserTypes;
    }

    /**
     * Converts the ParserTypes into finally resolved
     * and mapped DTOs for the model.
     *
     * @return DTOs for the model
     */
    public List<Dto> getDtos() {
        return parserTypes.getActiveDtos().stream()
                .map(this::derefDto)
                .toList();
    }

    private Dto derefDto(Dto dto) {
        Reference dtoTypeRef = dto.reference();
        String name = dto.name();
        String newName = renameTypes.getOrDefault(name, name);
        List<TypeInterface> implementsInterfaces = parserTypes.getInterfacesImplementedBy(dto.typeName());
        logger.debug(" - deref DTO {}->{} : {}", name, newName, dtoTypeRef);
        logger.debug(" - implements: {}", implementsInterfaces);
        return Dto.builderFrom(dto)
                .name(newName)
                .mpSchemaName(name)
                .reference(resolve(dtoTypeRef))
                .properties(derefProperties(dto.properties()))
                .implementsInterfaces(implementsInterfaces)
                .build();
    }

    private List<Property> derefProperties(List<Property> properties) {
        return properties.stream()
                    .map(this::derefProperty)
                    .toList();
    }

    private Property derefProperty(Property property) {
        return Property.builder().from(property)
                .reference(resolve(property.reference()))
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
                .parameters(derefParams(op.parameters()))
                .requestBody(op.requestBody().map(this::derefRequestBody))
                .build();
    }

    private RequestBody derefRequestBody(RequestBody requestBody) {
        return RequestBody.builder().from(requestBody)
                .content(derefContent(requestBody.content()))
                .build();
    }

    private List<Parameter> derefParams(List<Parameter> parameters) {
        return parameters.stream()
                .map(this::derefParam)
                .toList();
    }

    private Parameter derefParam(Parameter param) {
        return Parameter.builder().from(param)
                .reference(resolve(param.reference()))
                .build();
    }

    private List<Response> derefResponses(List<Response> responses) {
        return responses.stream()
                .map(this::derefResponse)
                .toList();
    }

    private Response derefResponse(Response response) {
        return Response.builder().from(response)
                .content(derefContent(response.content()))
                .build();
    }

    private Content derefContent(Content content) {
        return Content.builder().from(content)
                .reference(resolve(content.reference()))
                .formParameters(derefParams(content.formParameters()))
                .build();
    }

    private TypeReference resolve(Reference ref) {
        if (ref instanceof ParserTypeRef ptr) {
            return resolve(ptr);
        } else if (ref instanceof TypeReference tr) {
            return tr;
        }
        throw new IllegalStateException("Unhandled reference type " + ref.getClass());
    }

    private TypeReference resolve(ParserTypeRef ptr) {
        // This is where (unresolved) "forward" references are finally
        // resolved to the proper new type.
        Type t = ptr.refType() != null ? ptr.refType() : parserTypes.get(ptr.refTypeName());
        
        // Now we have a type (the parserRef is resolved)
        
        // May have to resolve inner if a container
        Type resolvedT = resolveInner(t);
        
        logger.info(" RES {} -> {}", t, resolvedT);
        
        // Now make a new, final, model reference to this type
        // This is where renaming can happen
        
        TypeReference res = dereferencedTypes.computeIfAbsent(ptr, p -> TypeReference.of(resolvedT, ptr.validation()));

        TypeName inType = t.typeName();
        String outTypeName = renameTypes.getOrDefault(inType.name(), inType.name());
        
        logger.debug("  resolve {} -> {}", ptr, res);
        logger.info("   rename {} -> {}/{}", inType, res.typeName(), outTypeName);
        return res;
    }

    private Type resolveInner(Type type) {
        if (type instanceof Dto dto) {
            // only have to rename here? only DTOs will ever be renamed, yes?

            Dto resolvedDto = parserTypes.getFinallyResolvedDto(dto);
            
            // Keep DTOs as references - or cyclic DTOs will not be possible
            return TypeReference.of(resolvedDto, Validation.NO_VALIDATION);
        } else if (type instanceof ParserTypeRef ptr) {
            return resolve(ptr);
        } else if (type instanceof TypeVoid) {
            return type;
        } else if (type instanceof TypeArray ta) {
            Type it = ta.innerType();
            Type newIt = resolveInner(it);
            logger.debug(" array {} -> {}", it, newIt);
            return TypeArray.of(typeNames, newIt);
        } else if (type instanceof TypeSet ts) {
            Type it = ts.innerType();
            Type newIt = resolveInner(it);
            logger.debug(" set {} -> {}", it, newIt);
            return TypeSet.of(typeNames, newIt);
        } else if (type instanceof TypeMap tm) {
            Type it = tm.innerType();
            Type newIt = resolveInner(it);
            logger.debug(" map {} -> {}", it, newIt);
            return TypeMap.of(typeNames, newIt);
        } else {
            logger.debug("NOT dereferencing {}", type);
            return type;
        }
    }
}
