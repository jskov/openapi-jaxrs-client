package dk.mada.jaxrs.model;

import java.util.Optional;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Reference;

/**
 * Models a property in a DTO.
 */
@Immutable
public interface Property {
    /** {@return a builder for this type} */
    static ImmutableProperty.Builder builder() {
        return ImmutableProperty.builder();
    }

    /** {@return the property name} */
    String name();

    /** {@return the property type} */
    Reference reference();

    /** {@return an optional description of the property} */
    Optional<String> description();

    /** {@return an optional example for the property} */
    Optional<String> example();

    /** {@return the validation required for this property} */
    Validation validation();
}
