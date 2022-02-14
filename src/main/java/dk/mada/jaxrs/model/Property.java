package dk.mada.jaxrs.model;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Type;

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
    Type type();
    /** {@return the property description, or null} */
    @Nullable
    String description();
    /** {@return the property example, or null} */
    @Nullable
    String example();

    /** {@return true if the property can be null, otherwise false} */
    boolean isNullable();
    /** {@return true if the property is required, otherwise false} */
    boolean isRequired();
    /** {@return true if the property is read-only, otherwise false} */
    boolean isReadonly();
}
