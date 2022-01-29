package dk.mada.jaxrs.generator.dto.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Custom extensions. In separate (mada.) context so they are
 * easier to spot in the templates.
 */
@Immutable
public interface CtxPropertyExt {
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
}
