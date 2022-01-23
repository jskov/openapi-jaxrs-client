package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.List;
import java.util.SortedSet;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context passed to Mustache when compiling a model.
 */
@Immutable
public interface CtxDto {
    public static ImmutableCtxDto.Builder builder() {
        return ImmutableCtxDto.builder();
    }

    String appName();
    String version();
    @Nullable
    String appDescription();
    @Nullable
    String infoEmail();

    SortedSet<String> getImports();
    default boolean hasImports() {
        return !getImports().isEmpty();
    }

    String packageName();
    String classname();
    /** used in equals method */
    String classVarName();

    List<CtxProperty> vars();
    default boolean hasVars() {
        return !vars().isEmpty();
    }

    @Nullable
    CtxEnum allowableValues();
    @Nullable
    String dataType();
    default boolean isEnum() {
        return allowableValues() != null;
    }

    boolean jackson();

    String generatorClass();
    @Nullable
    String generatedDate();

    default boolean hideGenerationTimestamp() {
        return generatedDate() == null;
    }

    CtxDtoExt madaDto();
}
