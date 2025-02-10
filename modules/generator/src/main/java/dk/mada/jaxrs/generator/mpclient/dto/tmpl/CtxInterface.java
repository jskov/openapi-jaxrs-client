package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import io.jstach.jstache.JStache;
import java.util.Optional;
import java.util.SortedSet;
import org.immutables.value.Value.Immutable;

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

    /** {@return the optional application description} */
    Optional<String> appDescription();

    /** {@return the optional application contact email} */
    Optional<String> infoEmail();

    /** {@return the imports needed in the template} */
    SortedSet<String> getImports();

    /** {@return true if there are imports to render, otherwise false} */
    default boolean hasImports() {
        return !getImports().isEmpty();
    }

    /** {@return an optional description of the class} */
    Optional<String> description();

    /** {@return the package name for the class} */
    String packageName();

    /** {@return the classname for the class} */
    String classname();

    /** {@return the name of the Generated annotation class} */
    String generatedAnnotationClass();

    /** {@return the name of the generator class} */
    String generatorClass();

    /** {@return the optional date of the generation} */
    Optional<String> generatedDate();

    /** {@return a string list of implementation DTOs} */
    String implementations();

    /** {@return true if OpenApi schema information should be rendered} */
    boolean renderSchema();
}
