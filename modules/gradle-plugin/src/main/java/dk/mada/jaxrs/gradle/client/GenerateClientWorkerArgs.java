package dk.mada.jaxrs.gradle.client;

import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.workers.WorkParameters;

/**
 * Parameters that need to be passed from the Gradle
 * generator task to the generator service.
 *
 * @see GenerateClientWorker
 */
public interface GenerateClientWorkerArgs extends WorkParameters {
    /** {@return the OpenAPI document read by the generator} */
    RegularFileProperty getOpenapiDocument();
    /** {@return the generator properties} */
    RegularFileProperty getGeneratorConfig();
    /** {@return the output directory for the generator} */
    DirectoryProperty getOutputDirectory();
}
