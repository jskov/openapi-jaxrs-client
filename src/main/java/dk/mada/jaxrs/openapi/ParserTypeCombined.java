package dk.mada.jaxrs.openapi;

import java.util.List;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;

/**
 * Type representing a synthetic combined class during parsing.
 *
 * This comes from properties that may have oneof-references to multiple
 * DTOs but no discriminator. Solve by (inelegantly) combining all properties
 * from referenced DTOs into a synthetic DTO.
 *
 * May be able to merge with ParserTypeComposite.
 */
@Immutable
public interface ParserTypeCombined extends Type {
    /**
     * Creates a type for a combined class.
     *
     * @param typeName      the class type name
     * @param combinesTypes the parser reference aggregated in this type
     * @return an composite type
     */
    static ParserTypeCombined of(TypeName typeName, List<ParserTypeRef> combinesTypes) {
        return ImmutableParserTypeCombined.builder()
                .typeName(typeName)
                .combinesTypes(combinesTypes).build();
    }

    /** {@return the parser references to the DTOs combined by this type} */
    List<ParserTypeRef> combinesTypes();

    /**
     * Returns a list of the referenced DTOs in this combined DTO.
     *
     * This can be called during parsing.
     *
     * @return a list of the referenced DTOs in this combined DTO
     */
    default List<Dto> internalDtos() {
        return combinesTypes().stream()
                //.filter(ptr -> ptr.refTypeName().name().contains(TypeConverter.INTERNAL_PROPERTIES_NAME_MARKER))
                .map(ParserTypeRef::refType)
                .filter(Dto.class::isInstance)
                .map(Dto.class::cast)
                .toList();
    }

    /** {@return a list of the externally referenced type names} */
    default List<TypeName> externalDtoReferences() {
        return combinesTypes().stream()
                .map(ptr -> ptr.refTypeName())
                //.filter(tn -> !tn.name().contains(TypeConverter.INTERNAL_PROPERTIES_NAME_MARKER))
                .toList();
    }
}
