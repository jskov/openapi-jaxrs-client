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
    
    // https://download.eclipse.org/microprofile/microprofile-open-api-3.1.1/microprofile-openapi-spec-3.1.1.html#_jakarta_bean_validation_annotations

    //    * @param {{paramName}} {{#description}}{{description}}{{/description}}{{#validation}}{{#notNull}} (not null){{/notNull}}{{^notNull}} (optional{{#defaultValue}}, default to {{{.}}}{{/defaultValue}}){{/notNull}}{{/validation}}

    
    /*
    
{{#renderAnnotations}}{{#notNull}}@NotNull {{/notNull}}{{#valid}}@Valid {{/valid}}{{#pattern}}@Pattern(regexp = "{{{pattern}}}") {{/pattern}}{{!
minLength && maxLength set
}}{{#minLength}}{{#maxLength}}@Size(min = {{minLength}}, max = {{maxLength}}) {{/maxLength}}{{/minLength}}{{!
minLength set, maxLength not
}}{{#minLength}}{{^maxLength}}@Size(min = {{minLength}}) {{/maxLength}}{{/minLength}}{{!
minLength not set, maxLength set
}}{{^minLength}}{{#maxLength}}@Size(max = {{.}}) {{/maxLength}}{{/minLength}}{{!
}}{{#minimum}}@Min({{.}}) {{/minimum}}{{#decimalMinimum}}@DecimalMin({{{.}}}) {{/decimalMinimum}}{{#maximum}}@Max({{.}}) {{/maximum}}{{#decimalMaximum}}@DecimalMax({{{.}}}) {{/decimalMaximum}}{{/renderAnnotations}}

    
    */
    
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
        boolean isNotNull = !isNullable && isRequired;
        if (isNotNull) {
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

        //pattern = validation.pattern().map(StringRenderer::encodeRegexp);
        if (validation._pattern() != null) {
            String pattern = StringRenderer.encodeRegexp(validation._pattern());
            imports.add(ValidationApi.PATTERN);
            renderedValidation += "@Pattern(regexp = \"" + pattern + "\") ";
        }

        // Note that OpenApi specification xItems/xLength both map to @Size
        String min = validation
                .minItems()
                .or(validation::minLength)
                .map(i -> Integer.toString(i)) // NOSONAR - not enough information to select variant
                .orElse(null);
        String max = validation
                .maxItems()
                .or(validation::maxLength)
                .map(i -> Integer.toString(i)) // NOSONAR - not enough information to select variant
                .orElse(null);

        if (min != null || max != null) {
            imports.add(ValidationApi.SIZE);
            if (min != null && max != null) {
                renderedValidation += "@Size(min = " + min + ", max = " + max + ") "; 
            } else if (min != null) {
                renderedValidation += "@Size(min = " + min + ") ";
            } else {
                renderedValidation += "@Size(max = " + max + ") ";
            }
        }
/*        
        if (type.isBigDecimal()) {
            if (min != null) {
                javadoc += " * minimum: " + min + NL;
            }
            if (max != null) {
                javadoc += " * maximum: " + max + NL;
            }
        } else {
            
        }
        */
/*
        if (type.isBigDecimal()) {
            decimalMinimum = validation.minimum().map(min -> "\"" + min.toString() + "\"");
            decimalMaximum = validation.maximum().map(max -> "\"" + max.toString() + "\"");
        } else {
            minimum = validation.minimum().map(min -> Long.toString(min.longValue()) + "L");
            maximum = validation.maximum().map(max -> Long.toString(max.longValue()) + "L");
        }
        if (decimalMinimum.isPresent()) {
            imports.add(ValidationApi.DECIMAL_MIN);
        }
        if (minimum.isPresent()) {
            imports.add(ValidationApi.MIN);
        }
        if (decimalMaximum.isPresent()) {
            imports.add(ValidationApi.DECIMAL_MAX);
        }
        if (maximum.isPresent()) {
            imports.add(ValidationApi.MAX);
        }
*/
        return Optional.of(new CtxValidation(renderedValidation, javadocPropertyComment, javadoc));
    }

    /** {@return a validation context for required values} */
    public CtxValidation makeRequired() {
        return new CtxValidation("", "", "");
    }
}
