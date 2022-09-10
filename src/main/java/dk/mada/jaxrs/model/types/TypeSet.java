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
     * @param typeNames the type names instance
     * @param innerType the type contained in the array
     * @return a set type
     */
    static TypeSet of(TypeNames typeNames, Type innerType) {
        return ImmutableTypeSet.builder().typeNames(typeNames).innerType(innerType).build();
    }

    /** {@return the type names instance} */
    TypeNames typeNames();

    @Override
    default String containerImplementation() {
        return "LinkedHashSet";
    }

    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return typeNames().of("Set<" + innerName + ">");
    }

    @Override
    default Set<JavaUtil> containerImports() {
        return JavaUtil.containerSetTypes();
    }
}
