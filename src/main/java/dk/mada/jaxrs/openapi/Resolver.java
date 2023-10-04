package dk.mada.jaxrs.openapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

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
import dk.mada.jaxrs.model.types.Primitive;
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
    /** Configuration to abort on resolver failure. */
    private final boolean abortOnResolverFailure;

    /**
     * Create new instance.
     *
     * @param parserOpts      the parser options
     * @param typeNames       the type names instance
     * @param parserTypes     the types collected during parsing
     * @param conflictRenamer the conflict renamer
     */
    public Resolver(ParserOpts parserOpts, TypeNames typeNames, ParserTypes parserTypes, ConflictRenamer conflictRenamer) {
        this.typeNames = typeNames;
        this.parserTypes = parserTypes;
        this.conflictRenamer = conflictRenamer;

        abortOnResolverFailure = parserOpts.isAbortOnResolverFailure();
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

        if (logger.isDebugEnabled()) {
            logger.debug("Parsed DTOs:");
            unresolvedDtos.stream()
                    .forEach(dto -> logger.debug(" - {}:{}", dto.openapiId(), dto.name()));
        }

        Collection<Dto> withoutTypeRefDtos = loopedDtoRemapping("typeRef", unresolvedDtos, this::filterAndRemapTypeRefDto);
        
        Collection<Dto> flattenedDtos = flattenDtos(withoutTypeRefDtos);

        if (logger.isDebugEnabled()) {
            logger.debug("Flattened DTOs:");
            flattenedDtos.stream()
                    .forEach(dto -> logger.debug(" - {}:{}", dto.openapiId(), dto.name()));
        }

        // Rename DTOs as a separate pass so there are stable
        // targets for dereferencing during the resolve pass.
        Collection<Dto> renamedDtos = conflictRenamer.resolveNameConflicts(flattenedDtos);

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

    /**
     * Remaps DTOs in a loop as long as there are changes.
     *
     * @param dtos the DTOs to remap
     * @return the (remaining) remapped DTOs
     */
    private Collection<Dto> loopedDtoRemapping(String title, Collection<Dto> dtos, Predicate<Dto> filter) {
        Collection<Dto> output = dtos;

        logger.debug("DTO filtering {}", title);

        boolean runAnotherPass;
        int pass = 1;
        do {
            logger.debug(" {} pass {}, {} dtos", title, pass, output.size());
            
            List<Dto> updated = output.stream()
                    .filter(filter::test)
                    .toList();
            runAnotherPass = output.size() != updated.size();
            output = updated;
            pass++;
        } while (runAnotherPass);

        logger.debug(" completed {} {}->{} dtos", title, dtos.size(), output.size());
        return output;
    }

    /**
     * It is valid for a type references (just a plain $ref) to be represented in
     * OpenApi documents,but there is no good way to express it in Java (unless you
     * want to consider extension).
     *
     * So filter out these DTOs, replacing they with whatever it points to.
     *
     * Note that this predicate has side effects (namely the remapping).
     *
     * @param dto the DTO to consider
     * @return false if the DTO has been remapped and should be filtered out
     */
    private boolean filterAndRemapTypeRefDto(Dto dto) {
        String name = dto.name();
        logger.trace(" - {} {}", name, dto);
        
        if (isReferenceOnly(dto)) {
            TypeReference ref = resolve(dto.reference());
            Type newType = parserTypes.remapDto(dto.typeName(), ref);
            logger.info("   : remap {} to {}", name, newType);
            return false;
        }
        
        logger.info("   : keep {}", name);
        return true;
    }

    /** {@return true if this DTO is only a reference to some other DTO} */
    private static boolean isReferenceOnly(Dto dto) {
        return dto.reference() != null
                && (dto.reference().refType() == UNKNOWN_TYPE || dto.reference().isDto())
                && dto.properties().isEmpty()
                && !dto.isEnum()
                && dto.implementsInterfaces().isEmpty()
                && !dto.subtypeSelector().isPresent()
                && dto.extendsParents().isEmpty();
    }

    
    private Collection<Dto> flattenDtos(Collection<Dto> dtos) {
        Collection<Dto> output = dtos;
        logger.debug("Look for DTOs to flatten");

        boolean runAnotherPass;
        int pass = 1;
        do {
            logger.debug(" Pass {}, {} dtos", pass, output.size());
            boolean hack = pass > 1;
            
            List<Dto> updated = output.stream()
                    .filter(d -> flattenAndFilterDto(d, hack))
                    .toList();
            runAnotherPass = output.size() != updated.size();
            output = updated;
            pass++;
        } while (runAnotherPass);

        logger.debug(" flattened to {} dtos", output.size());
        return output;
    }
    
    // FIXME: so what happens when a reference imparts extra validation?
    // only flatten non-object targets
    //  - hacked two passes:
    //    1-n: remove $ref-only links
    //    n: remove dtos that just wrap a primitive with validation (should end up being a TypeReference)
    //
    // fixme: requires further flattening of nested typereferences
//    Types:
//        DTOs: 
//         KlarTilBeslutningsGrundlagResponse: TypeReference{validation=Validation{isRequired=false}, refType=TypeObject}
//           senestOpdat: TypeReference{validation=Validation{isRequired=false}, refType=TypeReference{validation=Validation{isRequired=false}, refType=TypeReference{validation=Validation{isRequired=false}, refType=TypeReference{validation=Validation{isRequired=false}, refType=Dto{typeName=TypeName[name=BdwsTimestamp], name=BdwsTimestamp, mpSchemaName=BdwsTimestamp, reference=ParserTypeRef{validation=Validation{isRequired=false, pattern=^(\d{4}-\d{2}-\d{2}-\d{2}.\d{2}.\d{2}.\d{6})$}, refTypeName=TypeName[name=String], refType=STRING}, openapiId=TypeName[name=bdws-timestamp], properties=[], enumValues=[], implementsInterfaces=[], extendsParents=[]}}}}}

    private boolean flattenAndFilterDto(Dto dto, boolean hack) {
        boolean keepDto = true;
        String name = dto.name();
        logger.debug(" - {} {}", name, dto);
        
        Reference ref = dto.reference();
        if (isReferenceOnly(dto)) {
            logger.info("XXX {}", dto);
            
            TypeReference x = resolve(dto.reference());
            logger.info("   : ref flatten {} to {}", name, x);
            parserTypes.remapDto(dto.typeName(), x);
            return false;
        } else if (hack && isPrimitiveWrapperOnly(dto)) {
            TypeReference x = resolve(dto.reference());
            parserTypes.remapDto(dto.typeName(), x);
            logger.info("   : wrapper flatten {} to {}", name, ref);
            return false;
        } else {
            logger.info("   : keep {}", name);
        }
        
        return keepDto;
    }

    // flatten DTOs that are only wrappers over primitives
    // so client-site should inherit the validation
    private static boolean isPrimitiveWrapperOnly(Dto dto) {
        return dto.reference().refType().isPrimitive(Primitive.STRING);
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
        if (type instanceof ParserTypeCombined tc) {
            return extractCombinedDto(dtos, dto, tc);
        }

        return dto;
    }

    /**
     * Extract composite Dto information.
     *
     * A composite DTOs (schema is allOf) has the (assumed) Dto types it expands declared as name references in the type.
     *
     * Now that parsing is complete, all Dto types are known.
     *
     * So find the referenced Dtos and store it in directly in the Dto's data.
     *
     * The Dto's type is replaced later during dereferencing (since all the information captured in ParserTypeComposite has
     * now been moved into the Dto model).
     *
     * @param dtos all the known Dtos.
     * @param dto  the Dto to store data in
     * @param tc   tge composite type information
     * @return the updated dto
     */
    private Dto extractCompositeDto(Collection<Dto> dtos, Dto dto, ParserTypeComposite tc) {
        String openapiName = dto.openapiId().name();
        logger.debug(" - expand composite DTO {}", openapiName);
        logger.info(" tc: contains: {}", tc.containsTypes());
        logger.info(" tc: external: {}", tc.externalDtoReferences());

        List<Dto> externalDtos = tc.externalDtoReferences().stream()
                .map(tn -> getDtoWithOpenapiId(dtos, tn))
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

    /**
     * Extract composite Dto information.
     *
     * A composite DTOs (schema is allOf) has the (assumed) Dto types it expands declared as name references in the type.
     *
     * Now that parsing is complete, all Dto types are known.
     *
     * So find the referenced Dtos and store it in directly in the Dto's data.
     *
     * The Dto's type is replaced later during dereferencing (since all the information captured in ParserTypeComposite has
     * now been moved into the Dto model).
     *
     * @param dtos all the known Dtos.
     * @param dto  the Dto to store data in
     * @param tc   tge composite type information
     * @return the updated dto
     */
    private Dto extractCombinedDto(Collection<Dto> dtos, Dto dto, ParserTypeCombined tc) {
        String openapiName = dto.openapiId().name();
        logger.debug(" - expand combined DTO {}", openapiName);

        List<Dto> combinesDtos = tc.externalDtoReferences().stream()
                .map(tn -> getDtoWithOpenapiId(dtos, tn))
                .toList();

        if (logger.isDebugEnabled()) {
            List<String> combinesNames = combinesDtos.stream()
                    .map(Dto::name)
                    .sorted()
                    .toList();
            logger.debug("    combines {}", combinesNames);
        }

        List<Property> combinedProps = combinesDtos.stream()
                .flatMap(d -> d.properties().stream())
                .sorted((a, b) -> a.name().compareTo(b.name()))
                .toList();

        Set<String> seenPropertyNames = new HashSet<>();
        List<Property> selectedProps = combinedProps.stream()
                .filter(p -> seenPropertyNames.add(p.name()))
                .map(this::relaxPropertyValidation)
                .toList();

        return Dto.builderFrom(dto)
                .properties(selectedProps)
                .build();
    }

    /**
     * Ensures that the validation of the property allows for it to be null/not required. The combined DTO will have to be
     * able to deserialize any subset of the combined DTOs. So this relaxation of validation is necessary.
     *
     * @param prop the property to relax validation for
     * @return property without null
     */
    private Property relaxPropertyValidation(Property prop) {
        Validation flattenedValidation = Validation.builder().from(prop.validation())
                .isNullable(true)
                .isRequired(false)
                .build();
        return Property.builder().from(prop)
                .validation(flattenedValidation)
                .build();
    }

    private Dto getDtoWithOpenapiId(Collection<Dto> dtos, TypeName tn) {
        return dtos.stream()
                .filter(d -> d.openapiId().equals(tn))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Did not find referenced DTO " + tn));
    }

    /**
     * This dereferences the name-based parser-type-references into
     * the actual target types.
     *
     * FIXME: This is where simple types may get replaced.
     *
     * @param dtos the collection of DTOs still using ptrs
     * @return dereferenced DTOs
     */
    private List<Dto> dereferenceDtos(Collection<Dto> dtos) {
        logger.debug("==== Dereference DTOs");
        return dtos.stream()
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

        ArrayList<Dto> newParents = new ArrayList<>(dto.extendsParents());
        newParents.add(parent);

        return Dto.builderFrom(dto)
                .extendsParents(newParents)
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
        String propName = property.name();
        logger.info("    prop: {}", propName);
        TypeReference resolvedRef = resolve(property.reference());
        logger.info("    deref prop {}\n     from: {}\n     to: {}", propName, property.reference(), resolvedRef);
        return Property.builder().from(property)
                .reference(resolvedRef)
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
                .formParameters(derefParams(requestBody.formParameters()))
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

        // Terminate parsing early if the type cannot be resolve
        // so nobody gets confused at compile time instead
        if (abortOnResolverFailure && t == UNKNOWN_TYPE) {
            throw new IllegalStateException(
                    "Failed to resolve a pointer:\n " + ptr + "\nThis is probably a bug in openapi-jaxrs-client - please report!");
        }

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
        logger.debug(" resolveInner {}", type);
        if (type instanceof Dto dto) {
            return resolveDto(dto);
        } else if (type instanceof ParserTypeComposite ptc) {
            return resolveCompositeDto(ptc);
        } else if (type instanceof ParserTypeCombined ptc) {
            return resolveCombinedDto(ptc);
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
        } else if (type instanceof TypeReference tr) {
            logger.info("   / see tr {}", tr);
            if (tr.validation().isEmptyValidation()) {
                Type refType = tr.refType();
                if (refType instanceof TypeReference) {
                    logger.debug(" flatten empty typeref {} -> {}", tr, refType);
                    return refType;
                }
            }
            return type;
        } else {
            logger.debug("NOT dereferencing {}", type);
            return type;
        }
    }

    /**
     * Resolves a composite DTO reference.
     *
     * The composite reference contains local properties and/or external DTO references. These have all been moved into the
     * Dto object in expandCompositeDtos.
     *
     * @param ptc the composite parser type
     * @return the simplified object reference
     */
    private TypeReference resolveCompositeDto(ParserTypeComposite ptc) {
        TypeName dtoName = ptc.typeName();
        // There is no reference to the real DTO type, but it does not matter, as the name
        // lookup is guaranteed to find it.
        Dto dto = null;
        return resolveDto(dtoName, dto);
    }

    /**
     * Resolves a combined DTO reference.
     *
     * The combined reference contains local properties and/or external DTO references. These have all been moved into the
     * Dto object in expandCombinedDtos.
     *
     * @param ptc the combined parser type
     * @return the simplified object reference
     */
    private TypeReference resolveCombinedDto(ParserTypeCombined ptc) {
        TypeName dtoName = ptc.typeName();
        // There is no reference to the real DTO type, but it does not matter, as the name
        // lookup is guaranteed to find it.
        Dto dto = null;
        return resolveDto(dtoName, dto);
    }

    /**
     * Resolve a Dto.
     *
     * The Dto may have been mapped to another types. If so, the replacement happens here.
     *
     * @param dto the dto to possibly replace
     * @return the final type reference for the Dto
     */
    private TypeReference resolveDto(Dto dto) {
        return resolveDto(dto.typeName(), dto);
    }

    private TypeReference resolveDto(TypeName dtoName, @Nullable Type fallbackDto) {
        // See if DTO has been remapped to something else
        Type remappedDto = parserTypes.find(dtoName).orElse(fallbackDto);
        if (remappedDto == null) {
            throw new IllegalStateException("Did not find a dto named " + dtoName);
        }
        
        // FIXME: catches 2-level remapped dtos
        if (remappedDto instanceof Dto dto) {
            remappedDto = conflictRenamer.getConflictRenamedDto(dto);
        }

        // Convert parser DTO instance to model DTO instance
        // Wrap in a reference - or cyclic DTOs will not be possible
        return TypeReference.of(remappedDto, Validation.NO_VALIDATION);
    }
}
