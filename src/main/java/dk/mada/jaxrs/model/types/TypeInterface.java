package dk.mada.jaxrs.model.types;

import java.util.List;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Type representing an interface (schema with anyOf).
 */
@Immutable
public interface TypeInterface extends Type {
    /**
     * Creates a type for an interface.
     *
     * @param typeName the interface type name
     * @param implementations the types implementing the interface
     * @return an interface type
     */
    static TypeInterface of(TypeName typeName, List<? extends Reference> implementations) {
        return ImmutableTypeInterface.builder()
                .typeName(typeName)
                .implementations(implementations).build();
    }

    /** {@return the types implementing this interface} */
    List<Reference> implementations();
}
