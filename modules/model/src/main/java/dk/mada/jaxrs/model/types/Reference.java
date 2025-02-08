package dk.mada.jaxrs.model.types;

import org.jspecify.annotations.Nullable;

import dk.mada.jaxrs.model.AdditionalInfo;
import dk.mada.jaxrs.model.Validation;

/**
 * A reference to a type with validation requirements.
 *
 * The validation requirements apply for this particular reference (think of it as requirements that apply to the
 * parameter/property that references the type).
 */
public interface Reference extends Type {
    /**
     * Validation information that applies to this particular reference of the type.
     *
     * @return the validation information.
     */
    Validation validation();

    /** {@return the referenced type} */
    Type refType();

    /** {@return additional information provided on the reference} */
    @Nullable AdditionalInfo additionalInfo();
}
