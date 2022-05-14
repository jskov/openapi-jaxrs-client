package dk.mada.jaxrs.gradle.client;

import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.workers.WorkParameters;

public interface GenerateClientWorkerArgs extends WorkParameters {
    RegularFileProperty getOpenapiDocument();
    RegularFileProperty getGeneratorConfig();
    DirectoryProperty getOutputDirectory();
}
