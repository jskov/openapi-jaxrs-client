package dk.mada.jaxrs.generator.dto.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context for a DTO property.
 */
@Immutable
public interface CtxProperty {
    /** {@return a builder for this type} */
    static ImmutableCtxProperty.Builder builder() {
        return ImmutableCtxProperty.builder();
    }
    String name();
    String baseName();
    String nameInCamelCase();
    String nameInSnakeCase();
    String datatypeWithEnum();
    String getter();
    String setter();

    /** {@return dataType in an enumeration or null} */
    @Nullable
    String dataType();
    /** {@return allowable enumeration values or null} */
    @Nullable
    CtxEnum allowableValues();

    @Nullable
    String defaultValue();

    @Nullable
    String description();

    /** {@return true if bean validation should be used for this property, otherwise false} */
    boolean useBeanValidation();

    /** {@return validation mimimum length, or null} */
    @Nullable
    String minLength();
    /** {@return validation maximum length, or null} */
    @Nullable
    String maxLength();
    /** {@return validation minimum, or null} */
    @Nullable
    String minimum();
    /** {@return validation maximum, or null} */
    @Nullable
    String maximum();
    /** {@return validation pattern, or null} */
    @Nullable
    String pattern();

    boolean isArray();
    boolean isMap();
    boolean isSet();
    boolean isContainer();
    boolean isDate();
    boolean isDateTime();
    /** {@return true if this property should render an enumeration} */
    boolean isEnum();

    /** {@return true if this property is required} */
    boolean required();

    @Nullable
    String example();

    CtxPropertyExt madaProp();
}
