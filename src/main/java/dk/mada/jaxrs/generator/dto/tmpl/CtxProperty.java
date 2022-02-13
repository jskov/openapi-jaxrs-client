package dk.mada.jaxrs.generator.dto.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context for a DTO property.
 */
@Immutable
public interface CtxProperty {
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

    boolean isArray();
    boolean isMap();
    boolean isSet();
    boolean isContainer();
    boolean isDate();
    boolean isDateTime();
    /** {@return true if this property should render an enumeration} */
    boolean isEnum();

    boolean required();

    @Nullable
    String example();

    CtxPropertyExt madaProp();
}
