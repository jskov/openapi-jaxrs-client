package dk.mada.jaxrs.openapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
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
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeVoid;

/**
 * Works through a parsed model that contains parser type references and resolves them to pure model types.
 */
public final class Resolver {
    private static final Logger logger = LoggerFactory.getLogger(Resolver.class);

    /** The unknown type. */
    private static final TypeUnknownAtParseTime UNKNOWN_TYPE = TypeUnknownAtParseTime.get();
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
     * @param typeNames       the type names instance
     * @param parserTypes     the types collected during parsing
     * @param conflictRenamer the conflict renamer
     */
    public Resolver(TypeNames typeNames, ParserTypes parserTypes, ConflictRenamer conflictRenamer) {
        this.typeNames = typeNames;
        this.parserTypes = parserTypes;
        this.conflictRenamer = conflictRenamer;
    }

    /**
     * Converts the ParserTypes into finally resolved and mapped DTOs for the model.
     *
     * First the DTOs are renamed (if necessary) to resolve name conflicts. Then references to DTOs are resolved, changing
     * parser- references to model-references.
     *
     * @return DTOs for the model
     */
    public List<Dto> getDtos() {
        Set<Dto> unresolvedDtos = parserTypes.getActiveDtos();

        // Rename DTOs as a separate pass so there are stable
        // targets for dereferencing during the resolve pass.
        Collection<Dto> renamedDtos = conflictRenamer.resolveNameConflicts(unresolvedDtos);

        Collection<Dto> expandedDtos = extractCompositeDtos(renamedDtos);
        
        Collection<Dto> foldedDtos = foldInheritance(expandedDtos);

        List<Dto> dereferencedDtos = dereferenceDtos(foldedDtos);

        if (logger.isDebugEnabled()) {
            logger.debug("Resolved DTOs:");
            dereferencedDtos.stream()
                .sorted((a, b) -> a.name().compareToIgnoreCase(b.name()))
                .forEach(d -> logger.info(" - {}", d));
        }
        
        return dereferencedDtos;
    }

    private Collection<Dto> extractCompositeDtos(Collection<Dto> dtos) {
        logger.debug("Look for composite DTOs");
        return dtos.stream()
            .map(dto -> extractIfCompositeDto(dto, dtos))
            .toList();
    }

    private Dto extractIfCompositeDto(Dto dto, Collection<Dto> dtos) {
        Type type = dto.reference().refType();

        if (type instanceof ParserTypeComposite tc) {
            return extractCompositeDto(dtos, dto, tc);
        }

        return dto;
    }
    
    /**
     * Extract composite Dto information.
     *
     * A composite DTOs (schema is allOf) has the (assumed) Dto types it expands declared
     * as name references in the type.
     *
     * Now that parsing is complete, all Dto types are known.
     *
     * So find the referenced Dtos and store it in directly in the Dto's data.
     *
     * The Dto's type is replaced later during dereferencing (since
     * all the information captured in ParserTypeComposite has
     * now been moved into the Dto model).
     *
     * @param dtos all the known Dtos.
     * @param dto the Dto to store data in
     * @param tc tge composite type information
     * @return the updated dto
     */
    private Dto extractCompositeDto(Collection<Dto> dtos, Dto dto, ParserTypeComposite tc) {
        String openapiName = dto.openapiId().name();
        logger.debug(" - expand composite DTO {}", openapiName);
        
        List<Dto> externalDtos = tc.externalDtoReferences().stream()
            .map(tn -> {
                return dtos.stream()
                    .filter(d -> d.typeName().equals(tn))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Did not find referenced DTO " + tn));
            })
            .toList();
        
        if (logger.isDebugEnabled()) {
            List<String> extendsNames = externalDtos.stream()
                .map(Dto::name)
                .sorted()
                .toList();
            logger.debug("    extends {}", extendsNames);
        }
        
        return Dto.builderFrom(dto)
                .extendsParents(externalDtos)
                .build();
    }

    private List<Dto> dereferenceDtos(Collection<Dto> foldedDtos) {
        logger.debug("Dereference DTOs");
        return foldedDtos.stream()
                .map(this::derefDto)
                .toList();
    }

    /**
     * Reconstructs the inheritance between DTOs as expressed by oneof-discriminator information.
     *
     * This removes fields from sub-classes that are also present in the super class. Without any form of validation though.
     *
     * @param dtos the DTOs containing discriminator information
     * @return dtos with inheritance information
     */
    private List<Dto> foldInheritance(Collection<Dto> dtos) {
        logger.debug("Look for DTO implements");
        Map<TypeName, Dto> dtosWithSuper = new HashMap<>();

        for (Dto dto : dtos) {
            dto.subtypeSelector().ifPresent(subtypes -> {
                for (Reference r : subtypes.typeMapping().values()) {
                    dtosWithSuper.put(r.typeName(), dto);
                }
            });
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
     * @param dto    the dto to change
     * @param parent the parent dto, or null
     * @return the updated dto
     */
    private Dto adjustToParentExtension(Dto dto, @Nullable Dto parent) {
        if (parent == null) {
            return dto;
        }

        String parentName = parent.name();
        String dtoName = dto.name();
        logger.debug(" {} extends {}", dtoName, parentName);
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
     * All incoming references may point to the initially parsed DTO instances. All returned references point to the final
     * model DTO instances that have been renamed as required.
     *
     * @param ptr the reference to resolve
     * @return the model reference
     */
    private TypeReference resolve(ParserTypeRef ptr) {
        Type t = ptr.refType() == UNKNOWN_TYPE ? parserTypes.get(ptr.refTypeName()) : ptr.refType();
        Type resolvedT = resolveInner(t);
        TypeReference res = dereferencedTypes.computeIfAbsent(ptr, p -> TypeReference.of(resolvedT, ptr.validation()));

        logger.debug("  resolve {} -> {}", ptr, res);
        return res;
    }

    /**
     * Inner-most resolve of types (that can be parsed DTOs) to model types. May call itself recursively.
     *
     * @param type the type to resolve
     * @return the final model type
     */
    private Type resolveInner(Type type) {
        if (type instanceof Dto) {
            // See if DTO has been remapped to something else
            Type remappedDto = parserTypes.find(type.typeName()).orElse(type);
            if (remappedDto instanceof Dto dto) {
                remappedDto = conflictRenamer.getConflictRenamedDto(dto);
            }

            // Convert parser DTO instance to model DTO instance
            // Wrap in a reference - or cyclic DTOs will not be possible
            return TypeReference.of(remappedDto, Validation.NO_VALIDATION);
        } else if (type instanceof ParserTypeComposite ptc) {
            return resolveCompositeDto(ptc);
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

    /**
     * Resolves a composite DTO reference.
     *
     * The composite reference contains local properties
     * and/or external DTO references. These have all been
     * moved into the Dto object in expandCompositeDtos.
     *
     * So replace with a plain Object reference.
     * @param ptc 
     *
     * @return the simplified object reference
     */
    private TypeReference resolveCompositeDto(ParserTypeComposite ptc) {
        TypeName dtoName = ptc.typeName();
        // See if DTO has been remapped to something else
        Type remappedDto = parserTypes.get(dtoName);
        if (remappedDto instanceof Dto dto) {
            remappedDto = conflictRenamer.getConflictRenamedDto(dto);
        }

        // Convert parser DTO instance to model DTO instance
        // Wrap in a reference - or cyclic DTOs will not be possible
        return TypeReference.of(remappedDto, Validation.NO_VALIDATION);
    }
}
