package dk.mada.jaxrs.model;

import java.util.List;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Model of a DTO object.
 */
@Immutable
public interface Dto extends Type {
    /** {@return a builder for this type} */
    static ImmutableDto.Builder builder() {
        return ImmutableDto.builder();
    }

    /** {@return the DTO name} */
    String name();

    /** {@return the type of the DTO object} */
    Reference reference();

    /** {@return the DTO description, or null} */
    @Nullable
    String description();

    @Override
    default boolean isDto() {
        return true;
    }

    @Override
    default TypeName typeName() {
        return TypeNames.of(name());
    }

    /** {@return the name the DTO was identified by in the schema} */
    TypeName openapiId();

    /** {@return the properties on the DTO} */
    List<Property> properties();

    /** {@return the enumeration values on the DTO} */
    @Nullable
    List<String> enumValues();

    /** {@return true if this is an enumeration, otherwise false} */
    @Override
    default boolean isEnum() {
        return enumValues() != null;
    }
}
