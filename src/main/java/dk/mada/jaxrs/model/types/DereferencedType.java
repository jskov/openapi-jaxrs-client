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
 */
public record DereferencedType(Type type, @Nullable Validation validation) {
}
