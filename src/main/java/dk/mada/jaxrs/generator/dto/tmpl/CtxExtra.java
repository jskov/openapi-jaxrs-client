package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.SortedSet;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context passed to Mustache when compiling an extra template.
 */
@Immutable
public interface CtxExtra {
    /** {@return a builder for this type} */
    static ImmutableCtxExtra.Builder builder() {
        return ImmutableCtxExtra.builder();
    }

    /** {@return the application name} */
    String appName();
    /** {@return the application version} */
    String version();
    /** {@return the application description, or null} */
    @Nullable
    String appDescription();
    /** {@return the application contact email, or null} */
    @Nullable
    String infoEmail();

    /** {@return the imports needed in the template} */
    SortedSet<String> getImports();

    /** {@return true if there are imports to render, otherwise false} */
    default boolean hasImports() {
        return !getImports().isEmpty();
    }

    /** {@return the package name for the class} */
    String packageName();

    /** {@return true if jackson codehaus serializer is used, otherwise false} */
    boolean jacksonCodehaus();
    /** {@return true if jackson fasterxml serializer is used, otherwise false} */
    boolean jacksonFasterxml();
    /** {@return true if jsonb serializer is used, otherwise false} */
    boolean jsonb();

    /** {@return the name of the generator class} */
    String generatorClass();
    /** {@return the date of the generation, or null} */
    @Nullable
    String generatedDate();

    /** {@return true if the generation timestamp should be hidden, otherwise false} */
    default boolean hideGenerationTimestamp() {
        return generatedDate() == null;
    }

    /** {@return the date format used by the LocalDate serializer, or null} */
    @Nullable
    String cannedLocalDateSerializerDTF();

    /** {@return the date time format used by the LocalDateTime serializer, or null} */
    @Nullable
    String cannedLocalDateTimeSerializerDTF();
}
