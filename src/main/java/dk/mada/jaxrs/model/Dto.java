package dk.mada.jaxrs.model;

import java.util.List;
import java.util.Optional;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeInterface;
import dk.mada.jaxrs.model.types.TypeName;

/**
 * Model of a DTO object.
 */
@Immutable
public interface Dto extends Type {
    /** {@return a builder for this type}
     *
     * @param name the name of the DTO
     * @param typeName the type name of the DTO
     */
    static ImmutableDto.Builder builder(String name, TypeName typeName) {
        return ImmutableDto.builder().name(name).typeName(typeName);
    }

    /** {@return a builder for this type}
     *
     * @param other the existing DTO to create a builder from
     */
    static ImmutableDto.Builder builderFrom(Dto other) {
        return ImmutableDto.builder().from(other);
    }

    /** {@return the DTO name} */
    String name();

    /** {@return the MP Schema name} */
    String mpSchemaName();

    /** {@return the type of the DTO object} */
    Reference reference();

    /** {@return the optional description of the DTO} */
    Optional<String> description();

    @Override
    default boolean isDto() {
        return true;
    }

    /** {@return the name the DTO was identified by in the schema} */
    TypeName openapiId();

    /** {@return the properties on the DTO} */
    List<Property> properties();

    /** {@return the optional enumeration values on the DTO} */
    List<String> enumValues();

    /** {@return true if this is an enumeration, otherwise false} */
    @Override
    default boolean isEnum() {
        return !enumValues().isEmpty();
    }

    /** {@return the list of interfaces implemented by this DTO} */
    List<TypeInterface> implementsInterfaces();

    /** {@return an optional sub-type mapping} */
    Optional<SubtypeSelector> subtypeSelector();

    /** {@return the optional parent that this DTO extends} */
    Optional<Dto> parent();
}
