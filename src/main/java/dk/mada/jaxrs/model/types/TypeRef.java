package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * A reference to a sibling DTO used during parsing.
 *
 * The sibling may not have been processed yet,
 * hence this type which acts as a lazy delegation.
 */
@Immutable
public interface TypeRef extends Type {
    /**
     * Creates a new type reference.
     *
     * @param refTypeName the type name
     * @param types the types instance
     * @return a reference to the type name
     */
    static TypeRef of(TypeName refTypeName, Types types) {
        return ImmutableTypeRef.builder().refTypeName(refTypeName).types(types).build();
    }

    /** {@return the referenced type name} */
    TypeName refTypeName();
    /** {@return the types instance} */
    Types types();

    /**
     * Accesses the type behind this reference.
     *
     * This asserts that conversion has completed and
     * thus that the referenced type should now be
     * accessible.
     *
     * @return the referenced type
     */
    default Type dereference() {
        types().assertDereferencingSafe();
        return types().get(refTypeName());
    }

    @Override
    default TypeName typeName() {
        return dereference().typeName();
    }

    @Override
    default Set<String> neededImports() {
        return dereference().neededImports();
    }

    @Override
    default boolean isBigDecimal() {
        return dereference().isBigDecimal();
    }

    @Override
    default boolean isDate() {
        return dereference().isDate();
    }

    @Override
    default boolean isDateTime() {
        return dereference().isDateTime();
    }

    @Override
    default boolean isDto() {
        return dereference().isDto();
    }

    @Override
    default boolean isTime() {
        return dereference().isTime();
    }
}
