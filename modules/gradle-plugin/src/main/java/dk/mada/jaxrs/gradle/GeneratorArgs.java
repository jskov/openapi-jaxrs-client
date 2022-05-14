package dk.mada.jaxrs.gradle;

import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.MapProperty;
import org.gradle.workers.WorkParameters;

public interface GeneratorArgs extends WorkParameters {
    RegularFileProperty getOpenapiDocument();
    RegularFileProperty getGeneratorConfig();
    DirectoryProperty getOutputDirectory();
    MapProperty<String, String> getOptions();
}
