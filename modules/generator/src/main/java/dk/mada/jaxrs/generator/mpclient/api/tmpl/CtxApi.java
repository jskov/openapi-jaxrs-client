package dk.mada.jaxrs.generator.mpclient.api.tmpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;

import org.immutables.value.Value.Immutable;
import org.jspecify.annotations.Nullable;

import io.jstach.jstache.JStache;

/**
 * Context passed to Mustache when compiling an api.
 */
@JStache(path = "api")
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

    /** {@return the optional application description} */
    Optional<String> appDescription();

    /** {@return the optional information email} */
    Optional<String> infoEmail();

    /**
     * External documentation reference.
     *
     * @param description a description of the reference
     * @param url         the URL reference
     * @param summary     a summary of the documentation
     */
    record CtxOperationExternalDoc(String description, String url, String summary) {
    }

    /** {@return a list of external documentation references} */
    List<CtxOperationExternalDoc> externalDocs();

    /** {@return the return type information for containers. This is wrong.} */
    @Nullable Map<String, String> returnContainer();

    /** {@return the imports needed for this API class} */
    SortedSet<String> getImports();

    /**
     * A reference to an operation.
     *
     * Needed because the standard template uses 'operations' as a nesting element.
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

    /** {@return the name of the Generated annotation class} */
    String generatedAnnotationClass();

    /** {@return the name of the generator} */
    String generatorClass();

    /** {@return the optional generation date} */
    Optional<String> generatedDate();

    /** {@return the common REST path for all operations in this API class} */
    String commonPath();

    /** {@return additional custom template data for the api} */
    CtxApiExt madaApi();
}
