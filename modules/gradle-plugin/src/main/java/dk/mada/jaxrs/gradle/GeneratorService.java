package dk.mada.jaxrs.gradle;

import java.nio.file.Path;
import java.util.Properties;

public interface GeneratorService {
    void generate(Path openapiDocument, Path generatorConfig, Path toDir, Properties options);
}
