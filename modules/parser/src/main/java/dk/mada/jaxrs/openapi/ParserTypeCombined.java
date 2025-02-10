package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;
import java.util.List;

/**
 * Type representing a synthetic combined class during parsing.
 *
 * This comes from properties that may have oneof-references to multiple DTOs but no discriminator. Solve by
 * (inelegantly) combining all properties from referenced DTOs into a synthetic DTO.
 *
 * May be able to merge with ParserTypeComposite.
 *
 * @param typeName      the class type name
 * @param combinesTypes the parser references combined in this type
 */
public record ParserTypeCombined(TypeName typeName, List<ParserTypeRef> combinesTypes) implements Type {
    /**
     * Returns a list of the referenced DTOs in this combined DTO.
     *
     * This can be called during parsing.
     *
     * @return a list of the referenced DTOs in this combined DTO
     */
    public List<Dto> internalDtos() {
        return combinesTypes().stream()
                // .filter(ptr -> ptr.refTypeName().name().contains(TypeConverter.INTERNAL_PROPERTIES_NAME_MARKER))
                .map(ParserTypeRef::refType)
                .filter(Dto.class::isInstance)
                .map(Dto.class::cast)
                .toList();
    }

    /** {@return a list of the externally referenced type names} */
    public List<TypeName> externalDtoReferences() {
        return combinesTypes().stream()
                .map(ptr -> ptr.refTypeName())
                // .filter(tn -> !tn.name().contains(TypeConverter.INTERNAL_PROPERTIES_NAME_MARKER))
                .toList();
    }
}
