package dk.mada.jaxrs.generator.mpclient;

import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxValidation;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.ValidationApi;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeContainer;
import java.util.Optional;
import org.jspecify.annotations.Nullable;

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

        String renderedValidation = "";
        String javadocPropertyComment = "";
        String javadoc = "";

        boolean isNullable = validation.nullable();
        boolean isRequired = validation.required();
        if (isRequired && !isNullable) {
            renderedValidation += "@NotNull ";
            javadocPropertyComment += " (not null)";
            imports.add(ValidationApi.NOT_NULL);
        } else {
            javadocPropertyComment += " (optional)";
            // FIXME: missing default value here
        }
        // Decide where to put @Valid. I expect this to be too simple...
        if (type.isDto() || (type instanceof TypeContainer tc && tc.innerType().isDto())) {
            renderedValidation += "@Valid ";
            imports.add(ValidationApi.VALID);
        }

        // pattern = validation.pattern().map(StringRenderer::encodeRegexp);
        if (validation._pattern() != null) {
            String pattern = StringRenderer.encodeRegexp(validation._pattern());
            imports.add(ValidationApi.PATTERN);
            renderedValidation += "@Pattern(regexp = \"" + pattern + "\") ";
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
                renderedValidation += "@Size(min = " + sizeMin + ", max = " + sizeMax + ") ";
            } else if (sizeMin != null) {
                renderedValidation += "@Size(min = " + sizeMin + ") ";
            } else {
                renderedValidation += "@Size(max = " + sizeMax + ") ";
            }
        }

        String min = null;
        String max = null;
        if (validation._minimum() != null) {
            if (type.isBigDecimal()) {
                min = "\"" + validation._minimum().toString() + "\"";
                renderedValidation += "@DecimalMin(" + min + ") ";
                imports.add(ValidationApi.DECIMAL_MIN);
            } else {
                min = Long.toString(validation._minimum().longValue()) + "L";
                renderedValidation += "@Min(" + min + ") ";
                imports.add(ValidationApi.MIN);
            }
            javadoc += NL + "   * minimum: " + min;
        }
        if (validation._maximum() != null) {
            if (type.isBigDecimal()) {
                max = "\"" + validation._maximum().toString() + "\"";
                renderedValidation += "@DecimalMax(" + max + ") ";
                imports.add(ValidationApi.DECIMAL_MAX);
            } else {
                max = Long.toString(validation._maximum().longValue()) + "L";
                renderedValidation += "@Max(" + max + ") ";
                imports.add(ValidationApi.MAX);
            }
            javadoc += NL + "   * maximum: " + max;
        }

        if (javadoc.isEmpty()) {
            javadoc = null;
        } else {
            // Trim initial newline
            javadoc = javadoc.substring(1);
        }

        return Optional.of(new CtxValidation(renderedValidation, javadocPropertyComment, javadoc));
    }
}
