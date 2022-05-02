package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.imports.JavaUtil;
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
    default Set<JavaUtil> containerImports() {
        return JavaUtil.containerListTypes();
    }
}
