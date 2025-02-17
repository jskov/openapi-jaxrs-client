package dk.mada.jaxrs.generator.mpclient.validation;

import dk.mada.jaxrs.generator.mpclient.imports.ValidationApi;
import dk.mada.jaxrs.generator.mpclient.validation.ValidationTransformer.State;
import dk.mada.jaxrs.model.types.TypeArray;

/**
 * MicroProfile transformers.
 *
 * These provide transformers matching <a href="https://download.eclipse.org/microprofile/microprofile-open-api-3.1.1/microprofile-openapi-spec-3.1.1.html#_jakarta_bean_validation_annotations"/>.
 * These are additions to the StandardTransformers so cannot stand alone.
 */
public class MicroProfileTransformers {
    /**
     * Transforms @NotEmpty annotation for strings.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformNotEmptyString(State state) {
        if (state.isString() && "1".equals(state.minLength) && state.maxLength == null) {
            state.addValidation("@NotEmpty ");
            state.addImport(ValidationApi.NOT_EMPTY);
            state.minLength = null;
        }
        return state;
    }

    /**
     * Transforms @NotEmpty annotation for arrays.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformNotEmptyArray(State state) {
        if (state.type instanceof TypeArray && "1".equals(state.minItems) && state.maxItems == null) {
            state.addValidation("@NotEmpty ");
            state.addImport(ValidationApi.NOT_EMPTY);
            state.minItems = null;
        }
        return state;
    }

    /**
     * Transforms @Negative annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformNegative(State state) {
        if (state.isNumberOrInteger() && state.minimum == null && state.exclusiveMaximum && state.maximumIsZero) {
            state.addValidation("@Negative ");
            state.addImport(ValidationApi.NEGATIVE);
            state.maximum = null;
        }
        return state;
    }

    /**
     * Transforms @NegativeOrZero annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformNegativeOrZero(State state) {
        if (state.isNumberOrInteger() && state.minimum == null && !state.exclusiveMaximum && state.maximumIsZero) {
            state.addValidation("@NegativeOrZero ");
            state.addImport(ValidationApi.NEGATIVE_OR_ZERO);
            state.maximum = null;
        }
        return state;
    }

    /**
     * Transforms @Positive annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformPositive(State state) {
        if (state.isNumberOrInteger() && state.maximum == null && state.exclusiveMinimum && state.minimumIsZero) {
            state.addValidation("@Positive ");
            state.addImport(ValidationApi.POSITIVE);
            state.minimum = null;
        }
        return state;
    }

    /**
     * Transforms @PositiveOrZero annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformPositiveOrZero(State state) {
        if (state.isNumberOrInteger() && state.maximum == null && !state.exclusiveMinimum && state.minimumIsZero) {
            state.addValidation("@PositiveOrZero ");
            state.addImport(ValidationApi.POSITIVE_OR_ZERO);
            state.minimum = null;
        }
        return state;
    }

    /**
     * Transforms @NotBlank annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformNotBlank(State state) {
        if (state.isString() && "\\\\S".equals(state.pattern)) {
            state.addValidation("@NotBlank ");
            state.addImport(ValidationApi.NOT_BLANK);
            state.pattern = null;
        }
        return state;
    }
}
