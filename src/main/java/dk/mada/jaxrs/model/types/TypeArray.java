package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.Stream;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.Imports;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Type representing an array schema.
 */
@Immutable
public interface TypeArray extends TypeContainer {
    /**
     * Creates a type for an array (list).
     *
     * @param types the types instance
     * @param innerType the type contained in the array
     * @return an array type
     */
    static TypeArray of(Types types, Type innerType) {
        return ImmutableTypeArray.builder().types(types).innerType(innerType).build();
    }

    /** {@return the types instance} */
    Types types();

    @Override
    default String containerImplementation() {
        return "ArrayList";
    }

    @Override
    default TypeName typeName() {
        String innerName = mappedInnerType().wrapperTypeName().name();
        return TypeNames.of("List<" + innerName + ">");
    }

    @Override
    default Set<String> neededImports() {
        return Stream.concat(
                mappedInnerType().neededImports().stream(),
                Imports.LIST_TYPES.stream())
                .collect(toSet());
    }

    @Override
    default Type mappedInnerType() {
        return types().map(innerType());
    }
}
