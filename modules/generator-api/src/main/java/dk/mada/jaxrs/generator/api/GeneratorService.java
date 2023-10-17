package dk.mada.jaxrs.generator.api;

import java.nio.file.Path;
import java.util.Properties;

/**
 * Generator service.
 *
 * Allows decoupling the generator service from the two ways of invoking it (CLI and Gradle).
 */
public interface GeneratorService {
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
