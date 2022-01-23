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

    default boolean isDto() { return false; }
    default boolean isBigDecimal() { return false; }
    default boolean isDate() { return false; }
    default boolean isDateTime() { return false; }
    default boolean isTime() { return false; }
}
