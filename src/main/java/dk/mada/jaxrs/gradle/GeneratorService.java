package dk.mada.jaxrs.gradle;

// FIXME: copy of file in gradle-plugin, cannot get compile dep working

import java.nio.file.Path;
import java.util.Properties;

/**
 * Generator service.
 *
 * Allows decoupling the generator service from the two ways of invoking it (from CLI and Gradle).
 */
public interface GeneratorService {
    /** Log level to use when generating code. */
    enum GeneratorLogLevel {
        /** Default logging - as controlled by code. */
        DEFAULT,
        /** Debug logging. */
        DEBUG,
        /** Trace logging. */
        TRACE
    }

    /**
     * Context for client generator.
     *
     * @param overwrite a flag to allow overwriting existing data in destination dir
     * @param logLevel  the log level to use
     * @param skipApi   a flag to allow disabling generation of API classes
     * @param skipDto   a flag to allow disabling generation of DTO classes
     */
    public record ClientContext(
            boolean overwrite,
            GeneratorLogLevel logLevel,
            boolean skipApi,
            boolean skipDto) {
    }

    /**
     * Generate client code.
     *
     * @param context         the context for the generator
     * @param openapiDocument the OpenAPI document
     * @param options         the generator options
     * @param destinationDir  the destination directory
     */
    void generateClient(ClientContext context, Path openapiDocument, Properties options, Path destinationDir);
}
