package dk.mada.jaxrs.model;

import java.math.BigDecimal;
import java.util.Optional;

import javax.annotation.Nullable;

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

    /** {@return true if the property can be null, otherwise false} */
    boolean isNullable();
    /** {@return true if the property is required, otherwise false} */
    boolean isRequired();
    /** {@return true if the property is read-only, otherwise false} */
    boolean isReadonly();

    /** {@return validation minimum items, or null} */
    @Nullable
    Integer minItems();
    /** {@return validation maximum items, or null} */
    @Nullable
    Integer maxItems();
    /** {@return validation minimum length, or null} */
    @Nullable
    Integer minLength();
    /** {@return validation maximum length, or null} */
    @Nullable
    Integer maxLength();
    /** {@return validation minimum, or null} */
    @Nullable
    BigDecimal minimum();
    /** {@return validation maximum, or null} */
    @Nullable
    BigDecimal maximum();
    /** {@return validation pattern, or null} */
    @Nullable
    String pattern();
}
