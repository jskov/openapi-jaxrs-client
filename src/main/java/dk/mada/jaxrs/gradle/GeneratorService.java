package dk.mada.jaxrs.gradle;

// FIXME: copy of file in gradle-plugin, cannot get compile dep working

import java.nio.file.Path;

/**
 * Generator service.
 *
 * Allows decoupling the service from the two invocation
 * methods CLI and Gradle.
 */
public interface GeneratorService {
    /** Log level to use when generating code. */
    enum GeneratorLogLevel {
        /** Info logging. */
        INFO,
        /** Debug logging. */
        DEBUG,
        /** Trace logging. */
        TRACE
    }

    /**
     * Options to client generator.
     *
     * @param overwrite a flag to allow overwriting existing data in destination dir
     * @param logLevel the log level to use
     * @param skipApi a flag to allow disabling generation of API classes
     * @param skipDto a flag to allow disabling generation of DTO classes
     */
    record ClientOptions(
            boolean overwrite,
            GeneratorLogLevel logLevel,
            boolean skipApi,
            boolean skipDto) {
    }

    /**
     * Generate client code.
     *
     * @param opts the caller options to control generation
     * @param openapiDocument the OpenAPI document
     * @param generatorConfig the generator configuration
     * @param destinationDir the destination directory
     */
    void generateClient(ClientOptions opts, Path openapiDocument, Path generatorConfig, Path destinationDir);
}
