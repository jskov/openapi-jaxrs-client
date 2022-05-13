package dk.mada.jaxrs;

import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.gradle.GeneratorService;

public class GradleService implements GeneratorService {
    @Override
    public void generate(Path openapiDocument, Path generatorConfig, Path toDir, Properties options) {
        System.out.println("Gradle Service");
    }
}
