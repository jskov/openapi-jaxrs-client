package dk.mada.jaxrs.model.types;

import javax.annotation.Nullable;

import dk.mada.jaxrs.model.Validation;

/**
 * A dereferenced type.
 *
 * Contains a (safe) model type and any validation requirements
 * specified in the reference.
 *
 * @param type the model type
 * @param validation the validation requirements, or null
 *
 * @deprecated Can be removed when all type references are via TypeReference, which can then provide this logic
 */
@Deprecated
public record DereferencedType(Type type, @Nullable Validation validation) {

    /**
     * Makes sure a type is dereferenced.
     *
     * @param type the type to dereference
     * @return the dereferenced type
     */
    public static DereferencedType of(Type type) {
        if (type instanceof TypeReference tr) {
            return new DereferencedType(tr.refType(), tr.validation());
        } else {
            return new DereferencedType(type, null);
        }
    }

    public boolean required() {
        return validation != null && validation.isNullable() != null && !validation.isNullable();
    }
}
