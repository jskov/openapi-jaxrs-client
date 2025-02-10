package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.Validation;
import java.util.Set;
import org.immutables.value.Value.Immutable;

/**
 * A reference to type with validation requirements.
 *
 * The validation requirements apply for this particular reference (think of it as requirements that apply to the
 * parameter/property that references the type).
 */
@Immutable
public interface TypeReference extends Reference {
    /**
     * Creates a new type reference.
     *
     * @param refType    the type referenced
     * @param validation the validation requirements of the reference
     * @return a reference to the type
     */
    static TypeReference of(Type refType, Validation validation) {
        return ImmutableTypeReference.builder()
                .refType(refType)
                .validation(validation)
                .build();
    }

    @Override
    default TypeName typeName() {
        return refType().typeName();
    }

    @Override
    default Set<String> neededImports() {
        return refType().neededImports();
    }

    @Override
    default boolean isDto() {
        return refType().isDto();
    }

    @Override
    default TypeName wrapperTypeName() {
        return refType().wrapperTypeName();
    }

    @Override
    default boolean isVoid() {
        return refType().isVoid();
    }

    @Override
    default boolean isEnum() {
        return refType().isEnum();
    }

    @Override
    default boolean isBigDecimal() {
        return refType().isBigDecimal();
    }

    @Override
    default boolean isContainer() {
        return refType().isContainer();
    }

    @Override
    default boolean isDate() {
        return refType().isDate();
    }

    @Override
    default boolean isDateTime() {
        return refType().isDateTime();
    }

    @Override
    default boolean isTime() {
        return refType().isTime();
    }

    @Override
    default boolean isPrimitive(Primitive primitive) {
        return refType().isPrimitive(primitive);
    }
}
