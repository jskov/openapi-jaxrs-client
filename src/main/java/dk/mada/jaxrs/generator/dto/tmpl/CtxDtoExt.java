package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.List;
import java.util.Optional;

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

    /** {@return optional custom jackson @JsonSerialize options} */
    Optional<String> jacksonJsonSerializeOptions();

    /** {@return the name of a custom LocalDateDeserializer, or null} */
    @Nullable
    String customLocalDateDeserializer();
    /** {@return the name of a custom LocalDateSerializer, or null} */
    @Nullable
    String customLocalDateSerializer();

    /** {@return the name of a custom OffsetDateDeserializer, or null} */
    @Nullable
    String customOffsetDateTimeDeserializer();
    /** {@return the name of a custom OffsetDateSerializer, or null} */
    @Nullable
    String customOffsetDateTimeSerializer();

    /** {@return true if rendering for jsonb, false otherwise} */
    boolean jsonb();

    /** {@return schema options, or null} */
    @Nullable
    String schemaOptions();

    /** {@return an optional string containing the interfaces implemented by this DTO} */
    Optional<String> implementsInterfaces();

    /** {@return true if enumeration data type is primitive and can use == for equals} */
    boolean isEqualsPrimitive();

    /** {@return true if DTO should render @RegisterForReflection} */
    boolean quarkusRegisterForReflection();

    /** {@return the properties of the class, in openapi document order} */
    List<CtxProperty> varsOpenapiOrder();
}
