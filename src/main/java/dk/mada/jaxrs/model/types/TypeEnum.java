package dk.mada.jaxrs.model.types;

import java.util.List;

import org.immutables.value.Value.Immutable;

/**
 * Enumeration type.
 *
 * It captures the value-type of the enumeration and its
 * values.
 */
@Immutable
public interface TypeEnum extends Type {
    /**
     * Creates a new enumeration type instance.
     *
     * @param typeName the type name
     * @param valueType the enumeration value-type
     * @param values the enumeration values
     * @return a type wrapping the enumeration data
     */
    static TypeEnum of(TypeName typeName, Type valueType, List<String> values) {
        return ImmutableTypeEnum.builder()
                .typeName(typeName)
                .innerType(valueType)
                .values(values)
                .build();
    }

    /** {@return the inner type of the enumeration} */
    Type innerType();

    /** {@return the enumeration values} */
    List<String> values();

    @Override
    default boolean isEnum() {
        return true;
    }
}
