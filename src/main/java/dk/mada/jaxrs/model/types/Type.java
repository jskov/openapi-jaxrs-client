package dk.mada.jaxrs.model.types;

import java.util.Set;

/**
 * Types in the model.
 *
 * These model the OpenApi types, so represent both java primitives,
 * containers and some specific java library classes (e.g. for dates).
 * Plus all the specification-specific DTO types.
 */
public interface Type {
    /** {@return the type name} */
    TypeName typeName();

    /** {@return the wrapper type name} */
    default TypeName wrapperTypeName() {
        return typeName();
    }

    /** {@return the set of imports needed to use this type in a DTO} */
    default Set<String> neededImports() {
        return Set.of();
    }

    /** {@return true if this type represents a custom type DTO} */
    default boolean isDto() {
        return false;
    }

    /** {@return true if this type represents big-decimal} */
    default boolean isBigDecimal() {
        return false;
    }

    /** {@return true if this type represents date} */
    default boolean isDate() {
        return false;
    }

    /** {@return true if this type represents date-time} */
    default boolean isDateTime() {
        return false;
    }

    /** {@return true if this type represents time} */
    default boolean isTime() {
        return false;
    }

    /** {@return true if this type represents void} */
    default boolean isVoid() {
        return false;
    }

    /** {@return true if this type represents an enumeration} */
    default boolean isEnum() {
        return false;
    }

    /** {@return true if this type represents a container, otherwise false} */
    default boolean isContainer() {
        return false;
    }

    /** {@return true if this type represents validation information, otherwise false} */
    default boolean isValidation() {
        return false;
    }

    /**
     * Return true if this type is the given primitive.
     *
     * @param primitive the primitive to compare against
     * @return true if the same primitive, otherwise false
     */
    default boolean isPrimitive(Primitive primitive) {
        return false;
    }
}
