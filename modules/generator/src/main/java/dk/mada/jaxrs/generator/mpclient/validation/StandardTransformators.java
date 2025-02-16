package dk.mada.jaxrs.generator.mpclient.validation;

import dk.mada.jaxrs.generator.mpclient.imports.ValidationApi;
import dk.mada.jaxrs.generator.mpclient.validation.ValidationTransformer.State;
import dk.mada.jaxrs.model.types.TypeContainer;

public class StandardTransformators {

    /**
     * Transforms @Nullable annotation.
     *
     * This transformer does not clear the source state, so should
     * not be rerun.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformNullable(State state) {
        if (state.isRequired && !state.isNullable) {
            state.addValidation("@NotNull ");
            state.addPropComment(" (not null)");
            state.addImport(ValidationApi.NOT_NULL);
        } else {
            state.addPropComment(" (optional)");
            // FIXME: missing default value here
        }
        return state;
    }

    /**
     * Transforms @Valid annotation.
     *
     * This transformer does not clear the source state, so should
     * not be rerun.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformValid(State state) {
        // Decide where to put @Valid. I expect this to be too simple...
        if (state.type.isDto()
                || (state.type instanceof TypeContainer tc && tc.innerType().isDto())) {
            state.addValidation("@Valid ");
            state.addImport(ValidationApi.VALID);
        }
        return state;
    }

    /**
     * Transforms @Pattern annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformPattern(State state) {
        if (state.pattern != null) {
            state.addValidation("@Pattern(regexp = \"" + state.pattern + "\") ");

            state.pattern = null;
            state.addImport(ValidationApi.PATTERN);
        }
        return state;
    }

    /**
     * Transforms @Size annotation from min/maxItems.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformSizeItems(State state) {
        if (state.minItems != null || state.maxItems != null) {
            state.addImport(ValidationApi.SIZE);
            if (state.minItems != null && state.maxItems != null) {
                state.addValidation("@Size(min = " + state.minItems + ", max = " + state.maxItems + ") ");
            } else if (state.minItems != null) {
                state.addValidation("@Size(min = " + state.minItems + ") ");
            } else {
                state.addValidation("@Size(max = " + state.maxItems + ") ");
            }
            state.minItems = null;
            state.maxItems = null;
        }
        return state;
    }

    /**
     * Transforms @Size annotation from min/maxLength.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformSizeLength(State state) {
        if (state.minLength != null || state.maxLength != null) {
            state.addImport(ValidationApi.SIZE);
            if (state.minLength != null && state.maxLength != null) {
                state.addValidation("@Size(min = " + state.minLength + ", max = " + state.maxLength + ") ");
            } else if (state.minLength != null) {
                state.addValidation("@Size(min = " + state.minLength + ") ");
            } else {
                state.addValidation("@Size(max = " + state.maxLength + ") ");
            }
            state.minLength = null;
            state.maxLength = null;
        }
        return state;
    }

    /**
     * Transforms @DecimalMin annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformDecimalMin(State state) {
        if (state.minimum != null && state.type.isBigDecimal()) {
            state.addValidation("@DecimalMin(" + state.minimum + ") ");
            state.addImport(ValidationApi.DECIMAL_MIN);
            state.addJavadoc("   * minimum: " + state.minimum);
            state.minimum = null;
        }
        return state;
    }

    /**
     * Transforms @DecimalMax annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformDecimalMax(State state) {
        if (state.maximum != null && state.type.isBigDecimal()) {
            state.addValidation("@DecimalMax(" + state.maximum + ") ");
            state.addImport(ValidationApi.DECIMAL_MAX);
            state.addJavadoc("   * maximum: " + state.maximum);
            state.maximum = null;
        }
        return state;
    }

    /**
     * Transforms @Min annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformMin(State state) {
        if (state.minimum != null && !state.type.isBigDecimal()) {
            state.addValidation("@Min(" + state.minimum + ") ");
            state.addImport(ValidationApi.MIN);
            state.addJavadoc("   * minimum: " + state.minimum);
            state.minimum = null;
        }
        return state;
    }

    /**
     * Transforms @Max annotation.
     *
     * @param state the previous state
     * @return the updated state
     */
    public static State transformMax(State state) {
        if (state.maximum != null && !state.type.isBigDecimal()) {
            state.addValidation("@Max(" + state.maximum + ") ");
            state.addImport(ValidationApi.MAX);
            state.addJavadoc("   * maximum: " + state.maximum);
            state.maximum = null;
        }
        return state;
    }
}
