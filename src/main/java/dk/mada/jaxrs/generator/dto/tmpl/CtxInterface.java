package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.SortedSet;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import io.jstach.annotation.JStache;

/**
 * Context passed to Mustache when compiling an interface.
 */
@JStache(path = "interface")
@Immutable
public interface CtxInterface {
    /** {@return a builder for this type} */
    static ImmutableCtxInterface.Builder builder() {
        return ImmutableCtxInterface.builder();
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

    /** {@return the description for the class, or null} */
    @Nullable
    String description();
    /** {@return the package name for the class} */
    String packageName();
    /** {@return the classname for the class} */
    String classname();

    /** {@return the name of the Generated annotation class} */
    String generatedAnnotationClass();
    /** {@return the name of the generator class} */
    String generatorClass();
    /** {@return the date of the generation, or null} */
    @Nullable
    String generatedDate();

    /** {@return true if the generation timestamp should be hidden, otherwise false} */
    default boolean hideGenerationTimestamp() {
        return generatedDate() == null;
    }

    /** {@return a string list of implementation DTOs} */
    String implementations();
}
