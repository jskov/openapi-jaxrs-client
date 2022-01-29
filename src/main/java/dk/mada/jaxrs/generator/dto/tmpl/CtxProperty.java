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

    boolean required();

    @Nullable
    String example();

    CtxPropertyExt madaProp();
}
