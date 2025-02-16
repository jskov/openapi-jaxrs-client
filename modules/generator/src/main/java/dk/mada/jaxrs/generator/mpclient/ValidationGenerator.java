package dk.mada.jaxrs.generator.mpclient;

import java.util.Optional;
import java.util.function.Function;

import org.jspecify.annotations.Nullable;

import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxValidation;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.ValidationApi;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeContainer;

/**
 * Validation generator.
 *
 * Prepare Java Bean validation contexts for template rendering.
 */
public class ValidationGenerator {
    /** The platform line separator. */
    private static final String NL = System.lineSeparator();
    /** Generator options. */
    private final GeneratorOpts opts;

    /**
     * Constructs new instance.
     *
     * @param opts the generator options
     */
    public ValidationGenerator(GeneratorOpts opts) {
        this.opts = opts;
    }

    private final static class State {
        final Imports imports;
        final Type type;
        final boolean isNullable;
        final boolean isRequired;

        private String rendered = "";
        private String propComment = "";
        private String javadoc = "";
        
        @Nullable String pattern;
        @Nullable String minItems;
        @Nullable String maxItems;
        @Nullable String minLength;
        @Nullable String maxLength;
        @Nullable String minimum;
        @Nullable String maximum;
        
        public State(Imports imports, Type type, Validation validation) {
            this.imports = imports;
            this.type = type;
            isNullable = validation.nullable();
            isRequired = validation.required();
            
            if (validation._pattern() != null) {
                pattern = StringRenderer.encodeRegexp(validation._pattern());
            }
            
            if (validation._minItems() != null) {
                minItems = Integer.toString(validation._minItems());
            }
            if (validation._maxItems() != null) {
                maxItems = Integer.toString(validation._maxItems());
            }

            if (validation._minLength() != null) {
                minLength = Integer.toString(validation._minLength());
            }
            if (validation._maxLength() != null) {
                maxLength = Integer.toString(validation._maxLength());
            }

            if (validation._minimum() != null) {
                if (type.isBigDecimal()) {
                    minimum = "\"" + validation._minimum().toString() + "\"";
                } else {
                    minimum = Long.toString(validation._minimum().longValue()) + "L";
                }
            }

            if (validation._maximum() != null) {
                if (type.isBigDecimal()) {
                    maximum = "\"" + validation._maximum().toString() + "\"";
                } else {
                    maximum = Long.toString(validation._maximum().longValue()) + "L";
                }
            }
        }
        
        public boolean isCompleted() {
            return pattern == null
                    && minItems == null
                    && maxItems == null
                    && minLength == null
                    && maxLength == null
                    && minimum == null
                    && maximum == null;
        }
        
        public void addValidation(String s) {
            rendered += s;
        }
        public void addPropComment(String s) {
            propComment += s;
        }
        public void addJavadoc(String s) {
            javadoc += NL + s;
        }
        
        public CtxValidation build() {
            String j = null;
            if (!javadoc.isEmpty()) {
                // Trim initial newline
                j = javadoc.substring(1);
            }
            return new CtxValidation(rendered, propComment, j);
        }

        public void addImport(ValidationApi typedImport) {
            imports.add(typedImport);
        }
    }
    
    /**
     * Transforms validation state to rendered state if applicable.
     */
    @FunctionalInterface
    interface ValidationTransformer extends Function<State, State> {
    }
    
    /**
     * Generate validation rendering context from type and validation information.
     *
     * @param imports    the api/dto imports
     * @param type       the type to make validation for
     * @param validation the reference validation information
     * @return an optional validation rendering context
     */
    public Optional<CtxValidation> makeValidation(Imports imports, Type type, @Nullable Validation validation) {
        if (validation == null || !opts.isUseBeanValidation()) {
            return Optional.empty();
        }

        State state = new State(imports, type, validation);
        state = transformNullable(state);
        state = transformValid(state);
        state = transformPattern(state);
        state = transformSizeItems(state);
        state = transformSizeLength(state);
        state = transformDecimalMin(state);
        state = transformDecimalMax(state);
        state = transformMin(state);
        state = transformMax(state);

        return Optional.of(state.build());
    }
    
    private State transformNullable(State state) {
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

    private State transformValid(State state) {
        // Decide where to put @Valid. I expect this to be too simple...
        if (state.type.isDto() || (state.type instanceof TypeContainer tc && tc.innerType().isDto())) {
            state.addValidation("@Valid ");
            state.addImport(ValidationApi.VALID);
        }
        return state;
    }

    private State transformPattern(State state) {
        if (state.pattern != null) {
            state.addValidation("@Pattern(regexp = \"" + state.pattern + "\") ");;
            state.pattern = null;
            state.addImport(ValidationApi.PATTERN);
        }
        return state;
    }

    
    private State transformSizeItems(State state) {
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

    private State transformSizeLength(State state) {
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

    private State transformDecimalMin(State state) {
        if (state.minimum != null && state.type.isBigDecimal()) {
            state.addValidation("@DecimalMin(" + state.minimum + ") ");
            state.addImport(ValidationApi.DECIMAL_MIN);
            state.addJavadoc("   * minimum: " + state.minimum);
            state.minimum = null;
        }
        return state;
    }

    private State transformDecimalMax(State state) {
        if (state.maximum != null && state.type.isBigDecimal()) {
            state.addValidation("@DecimalMax(" + state.maximum + ") ");
            state.addImport(ValidationApi.DECIMAL_MAX);
            state.addJavadoc("   * maximum: " + state.maximum);
            state.maximum = null;
        }
        return state;
    }

    private State transformMin(State state) {
        if (state.minimum != null && !state.type.isBigDecimal()) {
            state.addValidation("@Min(" + state.minimum + ") ");
            state.addImport(ValidationApi.MIN);
            state.addJavadoc("   * minimum: " + state.minimum);
            state.minimum = null;
        }
        return state;
    }

    private State transformMax(State state) {
        if (state.maximum != null && !state.type.isBigDecimal()) {
            state.addValidation("@Max(" + state.maximum + ") ");
            state.addImport(ValidationApi.MAX);
            state.addJavadoc("   * maximum: " + state.maximum);
            state.maximum = null;
        }
        return state;
    }

    private State transform(State state) {
        return state;
    }
}
