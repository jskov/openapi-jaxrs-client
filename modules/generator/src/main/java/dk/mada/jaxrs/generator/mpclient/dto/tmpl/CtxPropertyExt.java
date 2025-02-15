package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import java.util.Optional;
import org.immutables.value.Value.Immutable;
import org.jspecify.annotations.Nullable;

/**
 * Custom extensions. In separate (mada.) context so they are easier to spot in the templates.
 */
@Immutable
public interface CtxPropertyExt {
    /** {@return a builder for this type} */
    static ImmutableCtxPropertyExt.Builder builder() {
        return ImmutableCtxPropertyExt.builder();
    }

    /** {@return the java inner type, or null} */
    @Nullable String innerDatatypeWithEnum();

    /**
     * Returns the (embedded) enumeration class name.
     *
     * Used in enumerations that are rendered next to the (only) property where they are referenced. See enumClass.mustache.
     *
     * This is handled separately from the standard dataType/datatypeWithEnum values because they are both used separately
     * by both containers and enumerations. Which prevents handling of enumerations in containers (or rather, I broke the
     * templates somehow to match behavior from openapi-generator - and this is easier to read for me).
     *
     * @return the enumeration class name
     */
    @Nullable String enumClassName();

    /** {@return the enumeration type name} */
    @Nullable String enumTypeName();

    /** {@return the optional schema options for an inline enumeration type} */
    Optional<String> enumSchemaOptions();

    /** {@return the optional schema options (for use in @Schema)} */
    Optional<String> schemaOptions();

    /** {@return true to use BigDecimal, false to use Double} */
    boolean isUseBigDecimalForDouble();

    /** {@return true to initialize collections, false to leave as null} */
    boolean isUseEmptyCollections();

    /** {@return true if this property is a byte array} */
    boolean isByteArray();

    /** {@return true if this property is primitive and can use == for equals} */
    boolean isEqualsPrimitive();

    /** {@return the getter name} **/
    String getter();

    /** {@return the setter name} **/
    String setter();

    /** {@return true if rendering for jsonb, false otherwise} */
    boolean jsonb();

    /** {@return the summary as a java string, or null} */
    @Nullable String descriptionString();

    /** {@return the multipart type associated with this property, or null} */
    @Nullable String multipartType();

    /** {@return a json property constant value, or null} */
    @Nullable String jsonPropertyConstant();

    /** {@return true if this property is nullable} */
    boolean isNullable();

    /** {@return true if this property should guard against nulls with Objects.requireNonNull} */
    boolean isRequireNonNull();
}
