package dk.mada.jaxrs.model.types;

import java.util.List;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.openapi.ParserTypeRef;
import dk.mada.jaxrs.openapi.TypeConverter;

/**
 * Type representing a composite class (schema with allOf).
 * Since java does not allow extending multiple super classes,
 * this will instead aggregate the properties from all of
 * the referenced types.
 *
 * Ideally, for with one reference and additional properties, this could
 * be modeled as extending+extra properties.
 *
 * The composite may include both internal properties (basically
 * modeled as an anonymous placeholder DTO that will not get directly rendered)
 * and references to types that have not been resolved yet.
 * So a TypeComposite DTO needs to be constructed in two steps;
 * 
 * (1) during parsing, where the internal properties can be copied
 * from the placeholder DTO, and
 * (2) during consolidation, where the referenced DTOs are now known,
 * and can be used for copying their properties (or extension).
 */
@Immutable
public interface TypeComposite extends Type {
    /**
     * Creates a type for a composite class.
     *
     * @param typeName        the class type name
     * @param containsTypes   the parser reference aggregated in this type
     * @return an composite type
     */
    static TypeComposite of(TypeName typeName, List<ParserTypeRef> containsTypes) {
        return ImmutableTypeComposite.builder()
                .typeName(typeName)
                .containsTypes(containsTypes).build();
    }

    /** {@return the parser references to the composite parts of this type} */
    List<ParserTypeRef> containsTypes();

    /**
     * Returns a list of the internal DTOs in this composite.
     *
     * This can be called during parsing.
     *
     * @return a list of the internal DTOs in this composite
     */
    default List<Dto> internalDtos() {
        return containsTypes().stream()
            .filter(ptr -> ptr.refTypeName().name().contains(TypeConverter.INTERNAL_PROPERTIES_NAME_MARKER))
            .map(ptr -> ptr.refType())
            .filter(Dto.class::isInstance)
            .map(Dto.class::cast)
            .toList();
    }

    /** {@return a list of the externally referenced type names} */
    default List<TypeName> externalDtoReferences() {
        return containsTypes().stream()
                .map(ptr -> ptr.refTypeName())
                .filter(tn -> !tn.name().contains(TypeConverter.INTERNAL_PROPERTIES_NAME_MARKER))
                .toList();
    }
}
