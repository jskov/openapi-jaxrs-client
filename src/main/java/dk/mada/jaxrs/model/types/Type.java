package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

public interface Type {
    TypeName typeName();
    default TypeName wrapperTypeName() {
        return typeName();
    }

    default Set<String> neededImports() {
        return Set.of();
    }

    /** {@return true if this type represents a custom type dto} */
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
}
