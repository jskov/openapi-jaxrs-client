package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.Imports;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Keys in a map must be a scalar string.
 * 
 * https://swagger.io/specification/#format
 */
@Immutable
public interface TypeMap extends Type {
    public static TypeMap of(Type innerType) {
        return ImmutableTypeMap.builder().innerType(innerType).build();
    }

    Type innerType();

    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return TypeNames.of("Map<String, " + innerName + ">");
    }

    @Override
    default Set<String> neededImports() {
        return Imports.MAP_TYPES;
    }
}
