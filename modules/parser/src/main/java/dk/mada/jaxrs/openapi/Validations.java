package dk.mada.jaxrs.openapi;

import java.util.HashSet;
import java.util.Set;

import dk.mada.jaxrs.model.Validation;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Validation factory.
 */
public final class Validations {
    /** The empty validation instance. */
    private static final Validation EMPTY_VALIDATION = Validation.empty();
    /** The required validation instance. */
    private static final Validation REQUIRED_VALIDATION = Validation.validationRequired();

    /** Validation instances to make sure we only get one of each. */
    private static final Set<Validation> VALID_INSTANCES = new HashSet<>(Set.of(EMPTY_VALIDATION, REQUIRED_VALIDATION));

    /** Creates new instance. */
    private Validations() {
        // empty
    }

    /** {@return the simplest empty validation instance} */
    public static Validation emptyValidation() {
        return EMPTY_VALIDATION;
    }

    /** {@return the simplest required validation instance} */
    public static Validation requiredValidation() {
        return REQUIRED_VALIDATION;
    }

    /**
     * Get a local Validation model objects from a schema.
     *
     * @param s        the schema
     * @param required the required state
     * @return a model validation instance
     */
    public static Validation extractValidation(@SuppressWarnings("rawtypes") Schema s, boolean required) {
        Boolean nullableObj = s.getNullable();
        boolean nullable = nullableObj != null && nullableObj.booleanValue();
        Validation candidate = new Validation(required, nullable, s.getReadOnly(),
                s.getMinItems(), s.getMaxItems(),
                s.getMinLength(), s.getMaxLength(),
                s.getMinimum(), s.getMaximum(),
                s.getPattern());

        return getInstance(candidate);
    }

    /**
     * {@return a more relaxed validation; not required and nullable}
     *
     * @param v the validation to relax
     */
    public static Validation makeRelaxed(Validation v) {
        Validation candidate = new Validation(false, true, v.readonly(),
                v._minItems(), v._maxItems(), v._minLength(), v._maxLength(), v._minimum(), v._maximum(), v._pattern());
        return getInstance(candidate);
    }

    /**
     * {@return a validation that requires the type}
     *
     * @param v the validation to enable require on
     */
    public static Validation makeRequired(Validation v) {
        Validation candidate = new Validation(true, v.nullable(), v.readonly(),
                v._minItems(), v._maxItems(), v._minLength(), v._maxLength(), v._minimum(), v._maximum(), v._pattern());
        return getInstance(candidate);
    }

    /**
     * {@return a validation that allows the type to be null}
     *
     * @param v the validation to enable require on
     */
    public static Validation makeNullable(Validation v) {
        Validation candidate = new Validation(v.required(), true, v.readonly(),
                v._minItems(), v._maxItems(), v._minLength(), v._maxLength(), v._minimum(), v._maximum(), v._pattern());
        return getInstance(candidate);
    }

    private static synchronized Validation getInstance(Validation candidate) {
        for (Validation v : VALID_INSTANCES) {
            if (v.equals(candidate)) {
                return v;
            }
        }

        // New instance
        VALID_INSTANCES.add(candidate);
        return candidate;
    }
}
