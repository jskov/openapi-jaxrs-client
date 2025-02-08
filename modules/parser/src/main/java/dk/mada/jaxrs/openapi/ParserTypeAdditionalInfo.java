package dk.mada.jaxrs.openapi;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.AdditionalInfo;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;

/**
 * Synthetic type only containing additional information provided with a type reference.
 */
@Immutable
public interface ParserTypeAdditionalInfo extends Type {
    /**
     * Creates an information type.
     *
     * @param typeName       the class type name
     * @param additionalInfo the addional information
     * @return a supplemental information type
     */
    static ParserTypeAdditionalInfo of(TypeName typeName, AdditionalInfo additionalInfo) {
        return ImmutableParserTypeAdditionalInfo.builder()
                .typeName(typeName)
                .additionalInfo(additionalInfo).build();
    }

    /** {@return the additional information} */
    AdditionalInfo additionalInfo();
}
