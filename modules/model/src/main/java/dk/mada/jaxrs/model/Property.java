package dk.mada.jaxrs.model;

import dk.mada.jaxrs.model.types.Reference;
import java.util.Optional;
import org.immutables.value.Value.Immutable;

/**
 * Models a property in a DTO.
 */
@Immutable
public interface Property {
    /** {@return a builder for this type} */
    static ImmutableProperty.Builder builder() {
        return ImmutableProperty.builder();
    }

    /**
     * {@return a builder for this type}
     *
     * @param other the existing Property to create a builder from
     */
    static ImmutableProperty.Builder builderFrom(Property other) {
        return ImmutableProperty.builder().from(other);
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
