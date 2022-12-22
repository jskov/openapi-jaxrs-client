package dk.mada.jaxrs.openapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.SubtypeSelector;
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
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeVoid;

/**
 * Works through a parsed model that contains parser type
 * references and resolves them to pure model types.
 */
public final class Resolver {
    private static final Logger logger = LoggerFactory.getLogger(Resolver.class);

    /** Parser types to their dereferenced model type. */
    private final Map<ParserTypeRef, TypeReference> dereferencedTypes = new HashMap<>();

    /** Type names. */
    private final TypeNames typeNames;
    /** Types from parsing. */
    private final ParserTypes parserTypes;
    /** Conflict renamer. */
    private final ConflictRenamer conflictRenamer;

    /**
     * Create new instance.
     *
     * @param typeNames the type names instance
     * @param parserTypes the types collected during parsing
     * @param conflictRenamer the conflict renamer
     */
    public Resolver(TypeNames typeNames, ParserTypes parserTypes, ConflictRenamer conflictRenamer) {
        this.typeNames = typeNames;
        this.parserTypes = parserTypes;
        this.conflictRenamer = conflictRenamer;
    }

    /**
     * Converts the ParserTypes into finally resolved
     * and mapped DTOs for the model.
     *
     * First the DTOs are renamed (if necessary) to resolve
     * name conflicts.
     * Then references to DTOs are resolved, changing parser-
     * references to model-references.
     *
     * @return DTOs for the model
     */
    public List<Dto> getDtos() {
        Set<Dto> unresolvedDtos = parserTypes.getActiveDtos();

        // Rename DTOs as a separate pass so there are stable
        // targets for dereferencing during the resolve pass.
        Collection<Dto> renamedDtos = conflictRenamer.resolveNameConflicts(unresolvedDtos);

        Collection<Dto> foldedDtos = foldInheritance(renamedDtos);
        
        return dereferenceDtos(foldedDtos);
    }

    private List<Dto> dereferenceDtos(Collection<Dto> foldedDtos) {
        logger.debug("Dereference DTOs");
        return foldedDtos.stream()
                .map(this::derefDto)
                .toList();
    }

    /**
     * Reconstructs the inheritance between DTOs as expressed
     * by oneof-discriminator information.
     *
     * This removes fields from sub-classes that are also present
     * in the super class. Without any form of validation though.
     *
     * @param dtos the DTOs containing discriminator information
     * @return dtos with inheritance information
     */
    private List<Dto> foldInheritance(Collection<Dto> dtos) {
        logger.debug("Look for DTO inheritance");
        Map<TypeName, Dto> dtosWithSuper = new HashMap<>();
        
        for (Dto dto : dtos) {
            SubtypeSelector subtypes = dto.subtypeSelector();
            if (subtypes == null) {
                continue;
            }

            for (Reference r : subtypes.typeMapping().values()) {
                dtosWithSuper.put(r.typeName(), dto);
            }
        }

        return dtos.stream()
                .map(dto -> adjustToParentExtension(dto, dtosWithSuper.get(dto.typeName())))
                .toList();
    }

    /**
     * Change DTO if it extends a parent.
     *
     * Make a link to the parent and remove inherited properties.
     *
     * @param dto the dto to change
     * @param parent the parent dto, or null
     * @return the updated dto
     */
    private Dto adjustToParentExtension(Dto dto, Dto parent) {
        if (parent == null) {
            return dto;
        }

        logger.debug(" {} extends {}", dto.name(), parent.name());
        List<Property> localProperties = dto.properties()
                .stream()
                .filter(dtoProperty -> isLocalToDto(parent, dtoProperty.name()))
                .toList();

        return Dto.builderFrom(dto)
                .parent(parent)
                .properties(localProperties)
                .build();
    }

    private boolean isLocalToDto(Dto parent, String propertyName) {
        return parent.properties().stream()
                .noneMatch(prop -> propertyName.equals(prop.name()));
    }

    private Dto derefDto(Dto dto) {
        Reference dtoTypeRef = dto.reference();

        String name = dto.name();
        TypeName typeName = dto.typeName();

        List<TypeInterface> implementsInterfaces = parserTypes.getInterfacesImplementedBy(typeName);
        logger.debug(" - deref DTO {} : {}", name, dtoTypeRef);
        logger.debug(" - implements: {}", implementsInterfaces);
        return Dto.builderFrom(dto)
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

    /**
     * Resolve parser references into model references.
     *
     * All incoming references may point to the initially parsed
     * DTO instances.
     * All returned references point to the final model DTO instances
     * that have been renamed as required.
     *
     * @param ptr the reference to resolve
     * @return the model reference
     */
    private TypeReference resolve(ParserTypeRef ptr) {
        Type t = ptr.refType() != null ? ptr.refType() : parserTypes.get(ptr.refTypeName());
        Type resolvedT = resolveInner(t);
        TypeReference res = dereferencedTypes.computeIfAbsent(ptr, p -> TypeReference.of(resolvedT, ptr.validation()));

        logger.debug("  resolve {} -> {}", ptr, res);
        return res;
    }

    /**
     * Inner-most resolve of types (that can be parsed
     * DTOs) to model types.
     * May call itself recursively.
     *
     * @param type the type to resolve
     * @return the final model type
     */
    private Type resolveInner(Type type) {
        if (type instanceof Dto dto) {
            // Convert parser DTO instance to model DTO instance
            Dto resolvedDto = conflictRenamer.getConflictRenamedDto(dto);
            // But wrap in a reference - or cyclic DTOs will not be possible
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
