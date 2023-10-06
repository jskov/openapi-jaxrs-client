package dk.mada.jaxrs.openapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    /** The parser options. */
    private final ParserOpts parserOpts;
    /** Type names. */
    private final TypeNames typeNames;
    /** Types from parsing. */
    private final ParserTypes parserTypes;
    /** Conflict renamer. */
    private final ConflictRenamer conflictRenamer;
    /** Configuration to abort on resolver failure. */
    private final boolean abortOnResolverFailure;
    /** Dto-to-property-names that need validation to be relaxed. */
    private final Map<TypeName, Set<String>> dtoPropertiesToBeRelaxed = new HashMap<>();

    /**
     * Create new instance.
     *
     * @param parserOpts      the parser options
     * @param typeNames       the type names instance
     * @param parserTypes     the types collected during parsing
     * @param conflictRenamer the conflict renamer
     */
    public Resolver(ParserOpts parserOpts, TypeNames typeNames, ParserTypes parserTypes, ConflictRenamer conflictRenamer) {
        this.parserOpts = parserOpts;
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
            logger.debug("= Parsed DTOs:");
            unresolvedDtos.stream()
                    .forEach(dto -> logger.debug(" - {}:{}", dto.openapiId(), dto.name()));
        }

        Collection<Dto> withoutTypeRefDtos = loopedDtoRemapping("typeRef", unresolvedDtos, Resolver::isDtoReferenceOnly);
        Collection<Dto> withoutPrimitiveDtos = loopedDtoRemapping("primitive", withoutTypeRefDtos, Resolver::isDtoPrimitiveWrapperOnly);
        Collection<Dto> withoutModelTypes = loopedDtoRemapping("model types", withoutPrimitiveDtos, this::isDtoModelType);

        Collection<Dto> filteredDtos = withoutModelTypes;

        if (logger.isDebugEnabled()) {
            logger.debug("= Filtered DTOs:");
            filteredDtos.stream()
                    .forEach(dto -> logger.debug(" - {}:{}", dto.openapiId(), dto.name()));
        }

        // Rename DTOs as a separate pass so there are stable
        // targets for dereferencing during the resolve pass.
        Collection<Dto> renamedDtos = conflictRenamer.resolveNameConflicts(filteredDtos);

        Collection<Dto> expandedDtos = extractCompositeDtos(renamedDtos);

        Collection<Dto> foldedDtos = foldInheritance(expandedDtos);

        List<Dto> dereferencedDtos = dereferenceDtos(foldedDtos);

        if (logger.isDebugEnabled()) {
            logger.debug("= Resolved DTOs:");
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

        logger.debug("== DTO filtering {}", title);

        boolean runAnotherPass;
        int pass = 1;
        do {
            logger.debug(" {} pass {} with {} dtos", title, pass, output.size());

            List<Dto> updated = output.stream()
                    .filter(dto -> applyDtoFilter(filter, dto))
                    .toList();
            runAnotherPass = output.size() != updated.size();
            output = updated;
            pass++;
        } while (runAnotherPass);

        logger.debug(" completed {} DTO remapping with {}->{} dtos", title, dtos.size(), output.size());
        return output;
    }

    private boolean applyDtoFilter(Predicate<Dto> filter, Dto dto) {
        String name = dto.name();
        logger.trace(" - {} {}", name, dto);

        if (filter.test(dto)) {
            TypeReference ref = resolve(dto.reference());
            Type newType = parserTypes.remapDto(dto.typeName(), ref);
            logger.info("   : remap {} to {}", name, newType);
            return false;
        }

        logger.info("   : keep {}", name);
        return true;
    }

    /**
     * It is valid for type references (just a plain $ref) to be represented in OpenApi documents, but there is no good way
     * to express it in Java (unless you want to consider extension).
     *
     * So replace these DTOs with whatever they point to.
     *
     * @param dto the DTO to consider
     * @return true if this DTO is only a reference to some other DTO
     */
    private static boolean isDtoReferenceOnly(Dto dto) {
        return dto.reference() != null
                && (dto.reference().refType() == UNKNOWN_TYPE || dto.reference().isDto())
                && dto.properties().isEmpty()
                && !dto.isEnum()
                && dto.implementsInterfaces().isEmpty()
                && !dto.subtypeSelector().isPresent()
                && dto.extendsParents().isEmpty();
    }

    /**
     * It is valid for simple (non-Object) types to be represented in OpenApi documents as standalone DTOs. But there is no
     * good way to express it in Java.
     *
     * So filter out these DTOs, replacing them with whatever they point to. This will result in the types being represented
     * as property fields instead.
     *
     * TODO: this and isDtoModelType should be reworked to carry a new TypeDef object into the model. And then let the
     * generator decide if these should be inlined (so basically move this pass down).
     *
     * @param dto the DTO to consider
     * @return true if the DTO is a primitive (not object)
     */
    private static boolean isDtoPrimitiveWrapperOnly(Dto dto) {
        Type dtoType = dto.reference().refType();
        return !dto.isEnum()
                && (dtoType.isPrimitive() || dtoType.isPlainObject());
    }

    /**
     * Filter out DTOs that are of a known model type.
     *
     * TODO: see isDtoPrimitiveWrapperOnly TODO: this predicate clearly shows a lot of types/options *not* covered by tests
     *
     * @param dto the DTO to consider
     * @return true if the DTO is a known model type.
     */
    private boolean isDtoModelType(Dto dto) {
        Type dtoType = dto.reference().refType();
        return (dtoType.isDate() && parserOpts.isJseLocalDate())
                || (dtoType.isDateTime()
                        && (parserOpts.isJseLocalDateTime() || parserOpts.isJseOffsetDateTime() || parserOpts.isJseZonedDateTime()))
                || (dtoType.isTime() && parserOpts.isJseLocalTime());
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
                .toList();

        // Remember the property names for the resolver so their
        // validation requirements can be relaxed.
        Set<String> propNamesNeedingRelaxation = selectedProps.stream()
                .map(Property::name)
                .collect(Collectors.toSet());

        dtoPropertiesToBeRelaxed.put(dto.typeName(), propNamesNeedingRelaxation);

        return Dto.builderFrom(dto)
                .properties(selectedProps)
                .build();
    }

    private Dto getDtoWithOpenapiId(Collection<Dto> dtos, TypeName tn) {
        return dtos.stream()
                .filter(d -> d.openapiId().equals(tn))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Did not find referenced DTO " + tn));
    }

    /**
     * This dereferences the name-based parser-type-references into the actual target types.
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
                .properties(derefProperties(dto))
                .implementsInterfaces(implementsInterfaces)
                .build();
    }

    private List<Property> derefProperties(Dto dto) {
        return dto.properties().stream()
                .map(p -> derefProperty(dto, p))
                .toList();
    }

    private Property derefProperty(Dto parent, Property property) {
        String propName = property.name();
        logger.debug("    prop: {}", propName);
        TypeReference resolvedRef = resolve(property.reference());
        Validation resolvedValidation = property.validation();

        // The type may provide validation - use that if there is none on the property
        // TODO: If the property has validation, it should probably be attempted
        // merged with that of the type. If they conflict, fail (with some config to ignore)
        if (resolvedValidation.isEmptyValidation()) {
            resolvedValidation = resolvedRef.validation();
        } else if (resolvedValidation == Validation.REQUIRED_VALIDATION) {
            // handle simple required_validation since it is simplest - and probably enough for now
            resolvedValidation = Validation.builder().from(resolvedRef.validation())
                    .isRequired(true)
                    .build();
        }

        // allOf constructed DTOs need to be able to deserialize subsets
        // of their properties, so this part relaxes the validation
        // requirements for such properties.
        // This could probably be stricter, but I am unsure about the proper
        // semantics of such constructs.
        Set<String> relaxProps = dtoPropertiesToBeRelaxed.get(parent.typeName());
        if (relaxProps != null && relaxProps.contains(propName)) {
            logger.trace("     + relaxing validation");
            resolvedValidation = Validation.builder().from(resolvedValidation)
                    .isNullable(true)
                    .isRequired(false)
                    .build();
        }

        // TODO: get example from type, see mada.tests.e2e.regression.string_pattern.dto.KlarTilBeslutningsGrundlagResponse
        // is should have:
        // @Schema(required = true, example = "2022-02-18-09.18.12.788990")
        Optional<String> resolvedExample = property.example();

        logger.debug("    deref prop {}\n     from: {}\n           {}\n     to: {}\n         {}",
                propName,
                property.reference(), property.validation(),
                resolvedRef, resolvedValidation);
        return Property.builder().from(property)
                .example(resolvedExample)
                .reference(resolvedRef)
                .validation(resolvedValidation)
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
        TypeReference res;
        if (ref instanceof ParserTypeRef ptr) {
            res = resolve(ptr);
        } else if (ref instanceof TypeReference tr) {
            res = tr;
        } else {
            throw new IllegalStateException("Unhandled reference type " + ref.getClass());
        }

        // Remove empty validation chains
        while (res.validation().isEmptyValidation()
                && res.refType() instanceof TypeReference inner) {
            res = inner;
        }

        return res;
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
        logger.trace(" resolveInner {}", type);
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
            logger.trace(" array {} -> {}", it, newIt);
            return TypeArray.of(typeNames, newIt);
        } else if (type instanceof TypeSet ts) {
            Type it = ts.innerType();
            Type newIt = resolveInner(it);
            logger.trace(" set {} -> {}", it, newIt);
            return TypeSet.of(typeNames, newIt);
        } else if (type instanceof TypeMap tm) {
            Type it = tm.innerType();
            Type newIt = resolveInner(it);
            logger.trace(" map {} -> {}", it, newIt);
            return TypeMap.of(typeNames, newIt);
        } else if (type instanceof TypeReference tr) {
            logger.info("FIXME:  XXXX should probably be removed / see tr {}", tr);
            if (tr.validation().isEmptyValidation()) {
                Type refType = tr.refType();
                if (refType instanceof TypeReference) {
                    logger.debug(" flatten empty typeref {} -> {}", tr, refType);
                    return refType;
                }
            }
            return type;
        } else {
            logger.trace("NOT dereferencing {}", type);
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
