package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import java.util.List;
import java.util.Optional;
import org.immutables.value.Value.Immutable;
import org.jspecify.annotations.Nullable;

/**
 * Custom extensions. In separate (mada.) context so they are easier to spot in the templates.
 */
@Immutable
public interface CtxDtoExt {
    /** {@return a builder for this type} */
    static ImmutableCtxDtoExt.Builder builder() {
        return ImmutableCtxDtoExt.builder();
    }

    /** {@return optional custom jackson @JsonSerialize options} */
    Optional<String> jacksonJsonSerializeOptions();

    /** {@return the optional name of a custom LocalDateDeserializer} */
    Optional<String> customLocalDateDeserializer();

    /** {@return the optional name of a custom LocalDateSerializer} */
    Optional<String> customLocalDateSerializer();

    /** {@return the optional name of a custom OffsetDateDeserializer} */
    Optional<String> customOffsetDateTimeDeserializer();

    /** {@return the optional name of a custom OffsetDateSerializer} */
    Optional<String> customOffsetDateTimeSerializer();

    /** {@return true if rendering for jsonb, false otherwise} */
    boolean jsonb();

    /** {@return schema options, or null} */
    @Nullable String schemaOptions();

    /** {@return an optional string containing the interfaces implemented by this DTO} */
    Optional<String> implementsInterfaces();

    /** {@return true if enumeration data type is primitive and can use == for equals} */
    boolean isEqualsPrimitive();

    /** {@return true if enumeration should deserialize unknown input to the last enumeration entry} */
    boolean isEnumUnknownDefault();

    /** {@return true if DTO should render @RegisterForReflection} */
    boolean quarkusRegisterForReflection();

    /** {@return true if the property order annotation should be rendered} */
    boolean isRenderPropertyOrderAnnotation();

    /** {@return the properties of the class, in openapi document order} */
    List<CtxProperty> varsOpenapiOrder();

    /** {@return the optional class modifiers} */
    Optional<String> classModifiers();

    /** {@return true if the toString should create a single-line string} */
    boolean isRenderSingleLineToString();

    /** {@return true if the toString indentation helper method should be rendered} */
    boolean isRenderToStringHelper();

    /** {@return true if a canonical constructor should be added to the record} */
    boolean isRecordCanonicalConstructor();

    /** {@return true if a builder should be added to the record} */
    boolean isRecordBuilder();

    /** {@return true if jspecify Nullable annotations should be used} */
    boolean isJspecify();

    /** {@return true if type is jspecify NullUnmarked - note, not the opposite of isJspecify} */
    boolean isJspecifyNullUnmarked();
}
