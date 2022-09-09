package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.imports.JavaUtil;
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
     * @param typeNames the type names instance
     * @param innerType the type of the map values
     * @return a new map-type.
     */
    static TypeMap of(TypeNames typeNames, Type innerType) {
        String innerName = innerType.wrapperTypeName().name();
        TypeName typeName = typeNames.of("Map<String, " + innerName + ">");
        return ImmutableTypeMap.builder().innerType(innerType).typeName(typeName).build();
    }

    @Override
    default String containerImplementation() {
        return "HashMap";
    }

    @Override
    default Set<JavaUtil> containerImports() {
        return JavaUtil.containerMapTypes();
    }
}
