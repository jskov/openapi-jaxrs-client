package dk.mada.jaxrs.model;

import java.util.List;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

@Immutable
public interface Dto extends Type {
    String name();

    /** The type of the DTO object */
    Type dtoType();

    @Override
    default boolean isDto() { return true; }

    @Override
    default TypeName typeName() {
        return TypeNames.of(name());
    }

    /** The name the DTO was identified by in the schema */
    TypeName openapiId();

    List<Property> properties();

    @Nullable
    List<String> enumValues();
    default boolean isEnum() {
        return enumValues() != null;
    }
}
