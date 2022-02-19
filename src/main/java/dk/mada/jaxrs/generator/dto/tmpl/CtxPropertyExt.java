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
    @Nullable
    String innerDatatypeWithEnum();

    @Nullable
    String schemaOptions();
    boolean isUseBigDecimalForDouble();
    boolean isUseEmptyCollections();

    String getter();
    String setter();

    /** {@return true if rendering for jsonb, false otherwise} */
    boolean jsonb();

    /** {@return true if the property must be valid, otherwise false} */
    boolean valid();
}
