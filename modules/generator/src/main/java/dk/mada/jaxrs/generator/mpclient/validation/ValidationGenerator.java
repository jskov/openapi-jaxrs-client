package dk.mada.jaxrs.generator.mpclient.validation;

import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxValidation;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.validation.ValidationTransformer.State;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jspecify.annotations.Nullable;

/**
 * Validation generator.
 *
 * Prepare Java Bean validation contexts for template rendering.
 */
public class ValidationGenerator {
    /** The platform line separator. */
    static final String NL = System.lineSeparator();
    /** Generator options. */
    private final GeneratorOpts opts;

    /** The fallback transformers. These were the original transformers. */
    private static final List<ValidationTransformer> FALLBACK_TRANSFORMERS = List.of(
            StandardTransformers::transformPattern,
            StandardTransformers::transformSizeItems,
            StandardTransformers::transformSizeLength,
            StandardTransformers::transformDecimalMin,
            StandardTransformers::transformDecimalMax,
            StandardTransformers::transformMin,
            StandardTransformers::transformMax);

    /** Additional transformers used by MicroProfile. */
    private static final List<ValidationTransformer> MICROPROFILE_TRANSFORMERS =
            List.of(MicroProfileTransformers::transformNotEmpty,
                    MicroProfileTransformers::transformNegative,
                    MicroProfileTransformers::transformNegativeOrZero,
                    MicroProfileTransformers::transformPositive,
                    MicroProfileTransformers::transformPositiveOrZero,
                    MicroProfileTransformers::transformNotBlank);

    /** The transformers configured for use. */
    private final List<ValidationTransformer> activeTransformers;

    /**
     * Constructs new instance.
     *
     * @param opts the generator options
     */
    public ValidationGenerator(GeneratorOpts opts) {
        this.opts = opts;

        activeTransformers = new ArrayList<>();
        if (opts.isUseMpValidationRules()) {
            activeTransformers.addAll(MICROPROFILE_TRANSFORMERS);
        }
        activeTransformers.addAll(FALLBACK_TRANSFORMERS);
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
        state = StandardTransformers.transformNullable(state);
        state = StandardTransformers.transformValid(state);

        for (var transformer : activeTransformers) {
            if (state.isCompleted()) {
                break;
            }
            state = transformer.apply(state);
        }
        return Optional.of(state.build());
    }
}
