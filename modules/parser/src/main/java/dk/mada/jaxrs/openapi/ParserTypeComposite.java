package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;
import java.util.List;

/**
 * Type representing a composite class (schema with allOf) during parsing.
 *
 * The composite may include both internal properties (basically captured as an
 * anonymous placeholder DTO that will not be part of the final model) and
 * references to types that have not been resolved yet. So a TypeComposite DTO
 * needs to be constructed in two steps;
 *
 * (1) during parsing, where the internal properties can be copied from the
 * placeholder DTO, and (2) during resolving, where the referenced DTOs are now
 * known, and can be used for copying their properties (or extension).
 *
 * @param typeName      the type name
 * @param containsTypes the parser references to the composite parts of this
 *                      type
 */
public record ParserTypeComposite(TypeName typeName, List<ParserTypeRef> containsTypes) implements Type {
    /**
     * Creates a type for a composite class.
     *
     * @param typeName      the class type name
     * @param containsTypes the parser reference aggregated in this type
     * @return a composite type
     */
    static ParserTypeComposite of(TypeName typeName, List<ParserTypeRef> containsTypes) {
        return new ParserTypeComposite(typeName, containsTypes);
    }

    /**
     * Returns a list of the internal DTOs in this composite.
     *
     * This can be called during parsing.
     *
     * @return a list of the internal DTOs in this composite
     */
    public List<Dto> internalDtos() {
        return containsTypes().stream()
                .filter(ptr -> ptr.refTypeName().name().contains(Naming.PARSER_INTERNAL_PROPERTIES_NAME_MARKER))
                .map(ParserTypeRef::refType)
                .filter(Dto.class::isInstance)
                .map(Dto.class::cast)
                .toList();
    }

    /** {@return a list of the externally referenced type names} */
    public List<TypeName> externalDtoReferences() {
        return containsTypes().stream()
                .map(ptr -> ptr.refTypeName())
                .filter(tn -> !tn.name().contains(Naming.PARSER_INTERNAL_PROPERTIES_NAME_MARKER))
                .toList();
    }
}
