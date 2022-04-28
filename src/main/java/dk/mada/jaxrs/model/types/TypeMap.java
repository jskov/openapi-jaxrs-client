package dk.mada.jaxrs.model.types;

import java.util.HashSet;
import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.imports.UtilImport;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Keys in a map must be a scalar string.
 *
 * https://swagger.io/specification/#format
 */
@Immutable
public interface TypeMap extends TypeContainer {
    /**
     * Creates a new map-type instance.
     *
     * The key-type is hardwired to String, but the inner-type is
     * as specified.
     *
     * @param innerType the type of the map values
     * @return a new map-type.
     */
    static TypeMap of(Type innerType) {
        return ImmutableTypeMap.builder().innerType(innerType).build();
    }

    @Override
    default String containerImplementation() {
        return "HashMap";
    }

    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return TypeNames.of("Map<String, " + innerName + ">");
    }

    @Override
    default Set<String> neededImports() {
        Set<String> combined = new HashSet<>(innerType().neededImports());
        UtilImport.containerMapTypes()
            .forEach(ui -> combined.add(ui.importPath()));
        return combined;
    }
}
