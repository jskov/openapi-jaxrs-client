package dk.mada.jaxrs.generator.mpclient.validation;

import dk.mada.jaxrs.generator.mpclient.StringRenderer;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxValidation;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.ValidationApi;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Transforms validation state to rendered state if applicable.
 */
@FunctionalInterface
interface ValidationTransformer extends Function<ValidationTransformer.State, ValidationTransformer.State> {

    /**
     * State of validation input while being transformed to rendered output.
     */
    public final class State {
        /** The DTO/API imports. */
        public final Imports imports;
        /** The type the validation is for. */
        public final Type type;
        /** Flag for type being number or integer. */
        private final boolean numberOrInteger;
        /** The type's nullable state. */
        final boolean isNullable;
        /** The type's required state. */
        final boolean isRequired;
        /** The validation's flag for exclusive minimum. */
        public final boolean exclusiveMinimum;
        /** The validation's flag for exclusive maximum. */
        public final boolean exclusiveMaximum;

        /** The validation in rendered form. Changed as transformers operate on the state. */
        private String rendered = "";
        /** The javadoc property comment in rendered form. Changed as transformers operate on the state. */
        private String propComment = "";
        /** The javadoc comment in rendered form. Changed as transformers operate on the state. */
        private String javadoc = "";

        /** The pattern. */
        @Nullable String pattern;
        /** The minimum items. */
        @Nullable String minItems;
        /** The maximum items. */
        @Nullable String maxItems;
        /** The minimum length. */
        @Nullable String minLength;
        /** The maximum length. */
        @Nullable String maxLength;
        /** The minimum. */
        @Nullable String minimum;
        /** The maxmimum. */
        @Nullable String maximum;

        /**
         * Creates a new instance, making initial translation of entries to string.
         *
         * @param imports    the DTO/API imports.
         * @param type       the type
         * @param validation the validation
         */
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
            exclusiveMinimum = validation._exclusiveMinimum() == Boolean.TRUE;
            exclusiveMaximum = validation._exclusiveMaximum() == Boolean.TRUE;

            boolean numberOrInteger = type.isBigDecimal();
            if (type instanceof Primitive p) {
                numberOrInteger |= p.isNumber();
            }
            this.numberOrInteger = numberOrInteger;
        }

        /** {@return true if the type is a number or integer} */
        public boolean isNumberOrInteger() {
            return numberOrInteger;
        }
        
        /** {@return true if all the variable validations fields have been processed} */
        public boolean isCompleted() {
            return pattern == null
                    && minItems == null
                    && maxItems == null
                    && minLength == null
                    && maxLength == null
                    && minimum == null
                    && maximum == null;
        }

        /**
         * Add validation part.
         *
         * @param part the part
         */
        public void addValidation(String part) {
            rendered += part;
        }

        /**
         * Add javadoc property comment part.
         *
         * @param part the part
         */
        public void addPropComment(String part) {
            propComment += part;
        }

        /**
         * Add accessor javadoc part.
         *
         * @param part the part
         */
        public void addJavadoc(String part) {
            javadoc += ValidationGenerator.NL + part;
        }

        /** {@return completed CtxValidation from the processed state} */
        public CtxValidation build() {
            if (!isCompleted()) {
                throw new IllegalStateException("All state was not properly processed!");
            }

            String j = null;
            if (!javadoc.isEmpty()) {
                // Trim initial newline
                j = javadoc.substring(1);
            }
            return new CtxValidation(rendered, propComment, j);
        }

        /**
         * Adds import to the imports.
         *
         * @param typedImport the import to add
         */
        public void addImport(ValidationApi typedImport) {
            imports.add(typedImport);
        }
    }
}
