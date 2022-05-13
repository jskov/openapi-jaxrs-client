package dk.mada.jaxrs.gradle;

import java.nio.file.Path;
import java.util.Map;

public interface GeneratorService {
    void generate(Path openapiDocument, Path generatorConfig, Path toDir, Map<String, String> options);
}
