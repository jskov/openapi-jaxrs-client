package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.Stream;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.imports.Imports;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Type representing an array schema.
 */
@Immutable
public interface TypeArray extends TypeContainer {
    /**
     * Creates a type for an array (list).
     *
     * @param innerType the type contained in the array
     * @return an array type
     */
    static TypeArray of(Type innerType) {
        return ImmutableTypeArray.builder().innerType(innerType).build();
    }

    @Override
    default String containerImplementation() {
        return "ArrayList";
    }

    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return TypeNames.of("List<" + innerName + ">");
    }

    @Override
    default Set<String> neededImports() {
        return Stream.concat(
                innerType().neededImports().stream(),
                Imports.LIST_TYPES.stream())
                .collect(toSet());
    }
}
