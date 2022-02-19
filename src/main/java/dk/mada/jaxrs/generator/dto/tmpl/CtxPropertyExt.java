package dk.mada.jaxrs.generator.dto.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Custom extensions. In separate (mada.) context so they are
 * easier to spot in the templates.
 */
@Immutable
public interface CtxPropertyExt {
    /** {@return a builder for this type} */
    static ImmutableCtxPropertyExt.Builder builder() {
        return ImmutableCtxPropertyExt.builder();
    }

    /** {@return the java inner type, or null} */
    @Nullable
    String innerDatatypeWithEnum();

    /** {@return the schema options (for use in @Schema), or null} */
    @Nullable
    String schemaOptions();

    /** {@return true to use BigDecimal, false to use Double} */
    boolean isUseBigDecimalForDouble();
    /** {@return true to initialize collections, false to leave as null} */
    boolean isUseEmptyCollections();

    /** {@return the getter name} **/
    String getter();
    /** {@return the setter name} **/
    String setter();

    /** {@return true if rendering for jsonb, false otherwise} */
    boolean jsonb();

    /** {@return true if the property must be valid, otherwise false} */
    boolean valid();

    /** {@return the summary as a java string, or null} */
    @Nullable
    String descriptionString();

    /** {@return true if a spacer is needed before javadoc macros} */
    boolean renderJavadocMacroSpacer();
}
