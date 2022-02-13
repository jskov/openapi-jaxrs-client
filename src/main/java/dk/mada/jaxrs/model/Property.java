package dk.mada.jaxrs.model;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Type;

@Immutable
public interface Property {
    /** {@return a builder for this type} */
    static ImmutableProperty.Builder builder() {
        return ImmutableProperty.builder();
    }

    String name();
    Type type();
    @Nullable
    String description();
    @Nullable
    String example();

    boolean isNullable();
    boolean isRequired();
    boolean isReadonly();
}
