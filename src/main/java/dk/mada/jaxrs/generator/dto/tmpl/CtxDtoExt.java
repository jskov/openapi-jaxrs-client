package dk.mada.jaxrs.generator.dto.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Custom extensions. In separate (mada.) context so they are
 * easier to spot in the templates.
 */
@Immutable
public interface CtxDtoExt {
    /** {@return a builder for this type} */
    static ImmutableCtxDtoExt.Builder builder() {
        return ImmutableCtxDtoExt.builder();
    }

    /** {@return the jackson @JsonSerialize options, or null} */
    @Nullable
    String jacksonJsonSerializeOptions();

    /** {@return the name of a custom LocalDateDeserializer, or null} */
    @Nullable
    String customLocalDateDeserializer();
    /** {@return the name of a custom LocalDateSerializer, or null} */
    @Nullable
    String customLocalDateSerializer();

    /** {@return additional options to use with the LocalDate serializer, or null} */
    @Nullable
    String localDateSerializerOpts();

    /** {@return the name of a custom OffsetDateDeserializer, or null} */
    @Nullable
    String customOffsetDateTimeDeserializer();
    /** {@return the name of a custom OffsetDateSerializer, or null} */
    @Nullable
    String customOffsetDateTimeSerializer();

    /** {@return true if rendering for jsonb, false otherwise} */
    boolean jsonb();
}
