package dk.mada.jaxrs.model.types;

import java.util.Set;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * A reference to a sibling DTO used during parsing.
 *
 * The sibling may not have been processed yet,
 * hence this type which acts as a lazy delegation.
 *
 * The reference may be extended with validation requirements
 * which apply for this particular reference (think of it as
 * requirements that apply to the parameter/property that
 * references the type).
 * I am not at all sure this is a good way to model this,
 * but it is a start...
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

    /**
     * Extends a reference with validation information.
     *
     * @param ref the type reference
     * @param validation the validation information
     * @return a new reference with validation information
     */
    static TypeRef withValidation(TypeRef ref, Validation validation) {
        return ImmutableTypeRef.builder().from(ref)
                .validation(validation)
                .build();
    }

    /**
     * Validation information that applies to this
     * particular reference of the type.
     *
     * @return the validation information, or null.
     */
    @Nullable
    Validation validation();

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
        return types().dereference(this).type();
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
