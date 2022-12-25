package dk.mada.jaxrs.model;

import java.math.BigDecimal;
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

    /** {@return true if the property can be null, otherwise false} */
    boolean isNullable();
    /** {@return true if the property is required, otherwise false} */
    boolean isRequired();
    /** {@return true if the property is read-only, otherwise false} */
    boolean isReadonly();

    /** {@return optional validation minimum items} */
    Optional<Integer> minItems();
    /** {@return optional validation maximum items} */
    Optional<Integer> maxItems();
    /** {@return optional validation minimum length} */
    Optional<Integer> minLength();
    /** {@return optional validation maximum length} */
    Optional<Integer> maxLength();
    /** {@return optional validation minimum} */
    Optional<BigDecimal> minimum();
    /** {@return optional validation maximum} */
    Optional<BigDecimal> maximum();
    /** {@return optional validation pattern} */
    Optional<String> pattern();
}
