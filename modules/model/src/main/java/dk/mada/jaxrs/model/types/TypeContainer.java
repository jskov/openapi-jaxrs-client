package dk.mada.jaxrs.model.types;

import java.util.Set;

/**
 * Type representing a container.
 */
public interface TypeContainer extends Type {
    /** {@return the type of data in the container} */
    Type innerType();

    /** {@return the java implementation used to instantiate this container} */
    String containerImplementation();

    /** {@return the java implementation declaration with generic types} */
    String containerImplementationDeclaration();

    /** {@return the type names instance} */
    TypeNames typeNames();

    @Override
    default boolean isContainer() {
        return true;
    }

    @Override
    default Set<String> neededImports() {
        return innerType().neededImports();
    }
}
