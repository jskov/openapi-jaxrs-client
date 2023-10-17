package dk.mada.jaxrs.generator.api;

/**
 * Context for client generator.
 *
 * @param overwrite a flag to allow overwriting existing data in destination directory
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
