package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.imports.JavaUtil;

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
     * The key-type is hardwired to String, but the inner-type is as specified.
     *
     * @param typeNames the type names instance
     * @param innerType the type of the map values
     * @return a new map-type.
     */
    static TypeMap of(TypeNames typeNames, Type innerType) {
        return ImmutableTypeMap.builder().typeNames(typeNames).innerType(innerType).build();
    }

    @Override
    default String containerImplementation() {
        return "HashMap";
    }

    /**
     * {@return the type name}
     *
     * Note that this needs to be resolved late (when accessed) and not when created. This ensures that conflict-renaming of
     * the inner-type is reflected in the final type name.
     */
    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return typeNames().of("Map<String, " + innerName + ">");
    }

    @Override
    default Set<JavaUtil> containerImports() {
        return JavaUtil.containerMapTypes();
    }
}
