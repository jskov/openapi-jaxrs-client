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
        
        // pattern = validation.pattern().map(StringRenderer::encodeRegexp);
        if (validation._pattern() != null) {
            String pattern = StringRenderer.encodeRegexp(validation._pattern());
            imports.add(ValidationApi.PATTERN);
            state.addValidation("@Pattern(regexp = \"" + pattern + "\") ");;
        }

        // Note that OpenApi specification xItems/xLength both map to @Size
        String sizeMin = validation
                .minItems()
                .or(validation::minLength)
                .map(i -> Integer.toString(i)) // NOSONAR - not enough information to select variant
                .orElse(null);
        String sizeMax = validation
                .maxItems()
                .or(validation::maxLength)
                .map(i -> Integer.toString(i)) // NOSONAR - not enough information to select variant
                .orElse(null);

        if (sizeMin != null || sizeMax != null) {
            imports.add(ValidationApi.SIZE);
            if (sizeMin != null && sizeMax != null) {
                state.addValidation("@Size(min = " + sizeMin + ", max = " + sizeMax + ") ");
            } else if (sizeMin != null) {
                state.addValidation("@Size(min = " + sizeMin + ") ");
            } else {
                state.addValidation("@Size(max = " + sizeMax + ") ");
            }
        }

        String min = null;
        String max = null;
        if (validation._minimum() != null) {
            if (type.isBigDecimal()) {
                min = "\"" + validation._minimum().toString() + "\"";
                state.addValidation("@DecimalMin(" + min + ") ");
                imports.add(ValidationApi.DECIMAL_MIN);
            } else {
                min = Long.toString(validation._minimum().longValue()) + "L";
                state.addValidation("@Min(" + min + ") ");
                imports.add(ValidationApi.MIN);
            }
            state.addJavadoc("   * minimum: " + min);
        }
        if (validation._maximum() != null) {
            if (type.isBigDecimal()) {
                max = "\"" + validation._maximum().toString() + "\"";
                state.addValidation("@DecimalMax(" + max + ") ");
                imports.add(ValidationApi.DECIMAL_MAX);
            } else {
                max = Long.toString(validation._maximum().longValue()) + "L";
                state.addValidation("@Max(" + max + ") ");
                imports.add(ValidationApi.MAX);
            }
            state.addJavadoc("   * maximum: " + max);
        }


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
}
