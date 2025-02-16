package dk.mada.jaxrs.generator.mpclient.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.mpclient.imports.ValidationApi;
import dk.mada.jaxrs.generator.mpclient.validation.ValidationTransformer.State;
import dk.mada.jaxrs.model.types.Primitive;

/**
 * MicroProfile transformers.
 *
 * These provide transformers matching <a href="https://download.eclipse.org/microprofile/microprofile-open-api-3.1.1/microprofile-openapi-spec-3.1.1.html#_jakarta_bean_validation_annotations"/>.
 * These are additions to the StandardTransformers so cannot stand alone.
 */
public class MicroProfileTransformers {
    private static final Logger logger = LoggerFactory.getLogger(MicroProfileTransformers.class);

    /**
     * Transforms @NotEmpty annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformNotEmpty(State state) {
        if (state.type.isPrimitive(Primitive.STRING) && "1".equals(state.minLength) && state.maxLength == null) {
            state.addValidation("@NotEmpty ");
            state.addImport(ValidationApi.NOT_EMPTY);
            state.minLength = null;
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
        if (state.isNumberOrInteger()
                && state.exclusiveMaximum
                && ("\"0\"".equals(state.maximum) || "0L".equals(state.maximum))) {
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
        if (state.isNumberOrInteger()
                && !state.exclusiveMaximum
                && ("\"0\"".equals(state.maximum) || "0L".equals(state.maximum))) {
            state.addValidation("@NegativeOrZero ");
            state.addImport(ValidationApi.NEGATIVE_OR_ZERO);
            state.maximum = null;
        }
        return state;
    }

}
