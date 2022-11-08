package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.imports.JavaUtil;

/**
 * Type representing an array schema.
 */
@Immutable
public interface TypeArray extends TypeContainer {
    /**
     * Creates a type for an array (list).
     *
     * @param typeNames the type names instance
     * @param innerType the type contained in the array
     * @return an array type
     */
    static TypeArray of(TypeNames typeNames, Type innerType) {
        return ImmutableTypeArray.builder().typeNames(typeNames).innerType(innerType).build();
    }

    @Override
    default String containerImplementation() {
        return "ArrayList";
    }

    /** {@return the type name}
    *
    * Note that this needs to be resolved late (when accessed)
    * and not when created. This ensures that conflict-renaming
    * of the inner-type is reflected in the final type name.
    */
    @Override
    default TypeName typeName() {
        String innerName = innerType().wrapperTypeName().name();
        return typeNames().of("List<" + innerName + ">");
    }

    @Override
    default Set<JavaUtil> containerImports() {
        return JavaUtil.containerListTypes();
    }
}
