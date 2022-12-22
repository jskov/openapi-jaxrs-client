package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import io.jstach.jstache.JStache;

/**
 * Context passed to Mustache when compiling a model.
 */
@JStache(path = "model")
@Immutable
public interface CtxDto {
    /** {@return a builder for this type} */
    static ImmutableCtxDto.Builder builder() {
        return ImmutableCtxDto.builder();
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
    /** {@return the class name used in equals method} */
    String classVarName();

    /** {@return the properties of the class} */
    List<CtxProperty> vars();

    /** {@return true if there are properties to render, otherwise false} */
    default boolean hasVars() {
        return !vars().isEmpty();
    }

    /** {@return true if this is an enumeration, otherwise false} */
    default boolean isEnum() {
        return allowableValues() != null;
    }

    /** {@return the enumeration constants/values, or null} */
    @Nullable
    CtxEnum allowableValues();
    /** {@return the data type of an enumeration, or null} */
    @Nullable
    String dataType();
    /** {@return unknown, kept from upstream template} */
    @Nullable
    String datatypeWithEnum();
    /** {@return true if the is an enumeration that can be deserialized as null} */
    boolean isNullable();
    /** {@return the optional name of a parent class} */
    Optional<String> parent();
    /** {@return optional vendor extensions} */
    @Nullable
    Map<String, String> vendorExtensions();

    /** {@return true if a jackson serializer is used, otherwise false} */
    boolean jackson();

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

    /** {@return discriminator for sub-class selection, or null} */
    @Nullable
    CtxDtoDiscriminator discriminator();

    /** {@return additional custom template data for the dto} */
    CtxDtoExt madaDto();
}
