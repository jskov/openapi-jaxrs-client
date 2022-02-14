package dk.mada.jaxrs.generator.api.tmpl;

import java.util.List;
import java.util.SortedSet;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context passed to Mustache when compiling an api.
 */
@Immutable
public interface CtxApi {
    /** {@return a builder for this type} */
    static ImmutableCtxApi.Builder builder() {
        return ImmutableCtxApi.builder();
    }

    /** {@return the application name} */
    String appName();
    /** {@return the application version} */
    String version();
    /** {@return the application description, or null} */
    @Nullable
    String appDescription();
    /** {@return the information email, or null} */
    @Nullable
    String infoEmail();

    /** {@return the imports needed for this API class} */
    SortedSet<String> getImports();

    /**
     * A reference to an operation.
     *
     * Needed because the standard template uses 'operations' as
     * a nesting element.
     *
     * @param operation the operation context to reference
     */
    record CtxOperationRef(CtxApiOp operation) {
    }
    /** {@return the operation contexts in this API class} */
    List<CtxOperationRef> operations();

    /** {@return the package name} */
    String packageName();
    /** {@return the class name} */
    String classname();

    /** {@return the name of the generator} */
    String generatorClass();
    /** {@return the generation date, or null} */
    @Nullable
    String generatedDate();

    /** {@return the common REST path for all operations in this API class} */
    String commonPath();

    /** {@return true if the generation timestamp should be hidden, otherwise false} */
    default boolean hideGenerationTimestamp() {
        return generatedDate() == null;
    }
}
