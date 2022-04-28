package dk.mada.jaxrs.model.types;

import java.util.HashSet;
import java.util.Set;

import dk.mada.jaxrs.generator.imports.UtilImport;

/**
 * Type representing a container.
 */
public interface TypeContainer extends Type {
    /** {@return the type of data in the container} */
    Type innerType();

    /** {@return the java implementation used to instantiate this container} */
    String containerImplementation();

    @Override
    default boolean isContainer() {
        return true;
    }

    /** {@return the containter-specific imports} */
    Set<UtilImport> containerImports();

    @Override
    default Set<String> neededImports() {
        Set<String> combined = new HashSet<>(innerType().neededImports());
        containerImports().forEach(ui -> combined.add(ui.importPath()));
        return combined;
    }
}
