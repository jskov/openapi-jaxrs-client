package dk.mada.jaxrs.generator.mpclient;

import java.util.Optional;

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
 * Prepared bean validation contexts for template rendering.
 */
public class ValidationGenerator {
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
        if (validation == null) {
            return Optional.empty();
        }

        boolean renderAnnotations = opts.isUseBeanValidation();
        boolean valid = false;
        Optional<String> minLength;
        Optional<String> maxLength;
        Optional<String> minimum = Optional.empty();
        Optional<String> maximum = Optional.empty();
        Optional<String> decimalMinimum = Optional.empty();
        Optional<String> decimalMaximum = Optional.empty();
        Optional<String> pattern;
        boolean isRequired = validation.isRequired().orElse(false);
        if (isRequired) {
            imports.add(renderAnnotations, ValidationApi.NOT_NULL);
        }
        // Decide where to put @Valid. I expect this to be too simple...
        if (type.isDto()
                || (type instanceof TypeContainer tc && tc.innerType().isDto())) {
            valid = true;
            imports.add(renderAnnotations, ValidationApi.VALID);
        }

        // Note that OpenApi specification xItems/xLength both map to @Size
        minLength = validation.minItems()
                .or(validation::minLength)
                .map(i -> Integer.toString(i)); // NOSONAR - not enough information to select variant
        if (minLength.isPresent()) {
            imports.add(renderAnnotations, ValidationApi.SIZE);
        }
        maxLength = validation.maxItems()
                .or(validation::maxLength)
                .map(i -> Integer.toString(i)); // NOSONAR - not enough information to select variant
        if (maxLength.isPresent()) {
            imports.add(renderAnnotations, ValidationApi.SIZE);
        }

        if (type.isBigDecimal()) {
            decimalMinimum = validation.minimum()
                    .map(min -> "\"" + min.toString() + "\"");
            decimalMaximum = validation.maximum()
                    .map(max -> "\"" + max.toString() + "\"");
        } else {
            minimum = validation.minimum()
                    .map(min -> Long.toString(min.longValue()) + "L");
            maximum = validation.maximum()
                    .map(max -> Long.toString(max.longValue()) + "L");
        }
        if (decimalMinimum.isPresent()) {
            imports.add(renderAnnotations, ValidationApi.DECIMAL_MIN);
        }
        if (minimum.isPresent()) {
            imports.add(renderAnnotations, ValidationApi.MIN);
        }
        if (decimalMinimum.isPresent()) {
            imports.add(renderAnnotations, ValidationApi.DECIMAL_MAX);
        }
        if (maximum.isPresent()) {
            imports.add(renderAnnotations, ValidationApi.MAX);
        }

        pattern = validation.pattern()
                .map(StringRenderer::encodeRegexp);
        if (pattern.isPresent()) {
            imports.add(renderAnnotations, ValidationApi.PATTERN);
        }

        CtxValidation valCtx = CtxValidation.builder()
                .minLength(minLength)
                .maxLength(maxLength)
                .minimum(minimum)
                .maximum(maximum)
                .decimalMinimum(decimalMinimum)
                .decimalMaximum(decimalMaximum)
                .pattern(pattern)
                .valid(valid)
                .required(isRequired)
                .renderAnnotations(renderAnnotations)
                .build();

        return Optional.of(valCtx);
    }

    /** {@return a validation context for required values} */
    public CtxValidation makeRequired() {
        return CtxValidation.builder()
                .minLength(Optional.empty())
                .maxLength(Optional.empty())
                .minimum(Optional.empty())
                .maximum(Optional.empty())
                .decimalMinimum(Optional.empty())
                .decimalMaximum(Optional.empty())
                .pattern(Optional.empty())
                .valid(false)
                .required(true)
                .renderAnnotations(opts.isUseBeanValidation())
                .build();
    }
}
