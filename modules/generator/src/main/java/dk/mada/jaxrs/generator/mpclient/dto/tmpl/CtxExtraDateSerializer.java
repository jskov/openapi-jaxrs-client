package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import java.util.Optional;
import java.util.SortedSet;

import org.immutables.value.Value.Immutable;

import io.jstach.jstache.JStache;

/**
 * Context passed to Mustache when compiling an extra template.
 */
@JStache(path = "extraDateSerializers")
@Immutable

public interface CtxExtraDateSerializer {
    /** {@return a builder for this type} */
    static ImmutableCtxExtraDateSerializer.Builder builder() {
        return ImmutableCtxExtraDateSerializer.builder();
    }

    /** {@return the class name of the serializer} */
    String className();

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

    /** {@return the package name for the class} */
    String packageName();

    /** {@return true if jackson fasterxml serializer is used, otherwise false} */
    boolean jacksonFasterxml();

    /** {@return true if jsonb serializer is used, otherwise false} */
    boolean jsonb();

    /** {@return true if this should render as a deserializer} */
    boolean deserializer();

    /** {@return true if this should render LocalDate type handling} */
    boolean renderLocalDate();

    /** {@return true if this should render LocalDateTime type handling} */
    boolean renderLocalDateTime();

    /** {@return true if this should render OffsetDateTime type handling} */
    boolean renderOffsetDateTime();

    /** {@return the name of the Generated annotation class} */
    String generatedAnnotationClass();

    /** {@return the name of the generator class} */
    String generatorClass();

    /** {@return the optional date of the generation} */
    Optional<String> generatedDate();

    /** {@return the optional date format used by the LocalDate serializer} */
    Optional<String> cannedLocalDateSerializerDTF();

    /** {@return the optional date time format used by the LocalDateTime serializer} */
    Optional<String> cannedLocalDateTimeSerializerDTF();

    /** {@return the optional date time format used by the OffsetDateTime serializer} */
    Optional<String> cannedOffsetDateTimeSerializerDTF();
}
