package dk.mada.jaxrs.model.types;

import java.util.List;
import java.util.Set;
import org.immutables.value.Value.Immutable;

/**
 * Type representing an interface (schema with anyOf).
 */
@Immutable
public interface TypeInterface extends Type {
    /**
     * Creates a type for an interface.
     *
     * I expect all the type names implementing the interface to be resolved as DTOs.
     *
     * @param packageName     the package name of DTOs
     * @param typeName        the interface type name
     * @param implementations the type names implementing the interface
     * @return an interface type
     */
    static TypeInterface of(String packageName, TypeName typeName, Set<TypeName> implementations) {
        return ImmutableTypeInterface.builder()
                .typeName(typeName)
                .packageName(packageName)
                .implementations(implementations)
                .build();
    }

    /** {@return the name of the package the interface is generated in} */
    String packageName();

    /** {@return the type names implementing this interface} */
    List<TypeName> implementations();

    @Override
    default Set<String> neededImports() {
        return Set.of(packageName() + "." + typeName().name());
    }
}
