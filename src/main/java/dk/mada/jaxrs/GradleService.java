package dk.mada.jaxrs;

import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.gradle.GeneratorService;

public class GradleService implements GeneratorService {
    @Override
    public void generate(Path openapiDocument, Path generatorConfig, Path toDir, Properties options) {
        System.out.println("Gradle Service");

        System.out.println(" OpenApi doc: " + openapiDocument);
        System.out.println(" Config: " + generatorConfig);
        System.out.println(" Dest dir: " + toDir);

        System.out.println("Options:");
        options.stringPropertyNames().stream()
            .sorted()
            .forEach(opt -> System.out.println(" " + opt + " = '" + options.getProperty(opt) + "'"));
    }
}
