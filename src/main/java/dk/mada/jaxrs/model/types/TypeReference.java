package dk.mada.jaxrs.model.types;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * A reference to type with validation requirements.
 *
 * The validation requirements apply for this particular
 * reference (think of it as requirements that apply to
 * the parameter/property that references the type).
 */
@Immutable
public interface TypeReference extends Type {
    /**
     * Creates a new type reference.
     *
     * @param refType the type referenced
     * @param validation the validation requirements of the reference
     * @return a reference to the type
     */
    static TypeReference of(Type refType, Validation validation) {
        return ImmutableTypeReference.builder().refType(refType).validation(validation).build();
    }

    /**
     * Validation information that applies to this
     * particular reference of the type.
     *
     * @return the validation information, or null.
     */
    @Nullable
    Validation validation();

    /** {@return the referenced type} */
    Type refType();

    @Override
    default TypeName typeName() {
        return refType().typeName();
    }
}
