package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.imports.JavaUtil;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Type representing an array schema with unique elements (aka a set).
 */
@Immutable
public interface TypeSet extends TypeContainer {
    /**
     * Creates a type for a set.
     *
     * @param innerType the type contained in the array
     * @return a set type
     */
    static TypeSet of(Type innerType) {
        return ImmutableTypeSet.builder().innerType(innerType).build();
    }

    @Override
    default String containerImplementation() {
        return "LinkedHashSet";
    }

    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return TypeNames.of("Set<" + innerName + ">");
    }

    @Override
    default Set<JavaUtil> containerImports() {
        return JavaUtil.containerSetTypes();
    }
}
