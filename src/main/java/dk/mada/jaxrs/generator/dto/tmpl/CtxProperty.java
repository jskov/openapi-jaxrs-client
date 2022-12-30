package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.Optional;

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

    /** {@return the java field name} */
    String name();

    /** {@return the OpenApi property name} */
    String baseName();

    /** {@return the java field name in camel case, used to construct method names} */
    String nameInCamelCase();

    /** {@return the java field name in snake case, used to construct constant names} */
    String nameInSnakeCase();

    /** {@return the java type name} */
    String datatypeWithEnum();

    /** {@return the name of the getter} */
    String getter();

    /** {@return the name of the setter} */
    String setter();

    /** {@return dataType in an enumeration or null} */
    @Nullable String dataType();

    /** {@return allowable enumeration values or null} */
    @Nullable CtxEnum allowableValues();

    /** {@return the property default value, or null} */
    @Nullable String defaultValue();

    /** {@return the optional description of the property} */
    Optional<String> description();

    /** {@return true if bean validation should be used for this property, otherwise false} */
    boolean useBeanValidation();

    /** {@return optional validation minimum length} */
    Optional<String> minLength();

    /** {@return optional validation maximum length} */
    Optional<String> maxLength();

    /** {@return optional validation minimum} */
    Optional<String> minimum();

    /** {@return optional validation maximum} */
    Optional<String> maximum();

    /** {@return optional validation decimalMinimum} */
    Optional<String> decimalMinimum();

    /** {@return optional validation decimalMaximum} */
    Optional<String> decimalMaximum();

    /** {@return optional validation pattern} */
    Optional<String> pattern();

    /** {@return true if this property should be rendered as an array, otherwise false} */
    boolean isArray();

    /** {@return true if this property should be rendered as a map, otherwise false} */
    boolean isMap();

    /** {@return true if this property should be rendered as a set, otherwise false} */
    boolean isSet();

    /** {@return true if this property is a container, otherwise false} */
    boolean isContainer();

    /** {@return true if this property should be rendered as a date, otherwise false} */
    boolean isDate();

    /** {@return true if this property should be rendered as a date-time, otherwise false} */
    boolean isDateTime();

    /** {@return true if this property should render an enumeration, otherwise false} */
    boolean isEnum();

    /** {@return true if this property is required} */
    boolean required();

    /** {@return an optional property example} */
    Optional<String> example();

    /** {@return additional custom template data for the property} */
    CtxPropertyExt madaProp();
}
