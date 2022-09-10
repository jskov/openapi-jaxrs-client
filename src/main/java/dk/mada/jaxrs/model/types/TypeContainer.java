package dk.mada.jaxrs.model.types;

import java.util.HashSet;
import java.util.Set;

import dk.mada.jaxrs.generator.imports.JavaUtil;

/**
 * Type representing a container.
 */
public interface TypeContainer extends Type {
    /** {@return the type of data in the container} */
    Type innerType();

    /** {@return the java implementation used to instantiate this container} */
    String containerImplementation();

    /** {@return the type names instance} */
    TypeNames typeNames();

    @Override
    default boolean isContainer() {
        return true;
    }

    /** {@return the containter-specific imports} */
    Set<JavaUtil> containerImports();

    @Override
    default Set<String> neededImports() {
        Set<String> combined = new HashSet<>(innerType().neededImports());
        containerImports().
            forEach(ui -> combined.add(ui.path()));
        return combined;
    }
}
