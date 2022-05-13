package dk.mada.jaxrs;

import java.nio.file.Path;
import java.util.Map;

import dk.mada.jaxrs.gradle.GeneratorService;

public class GradleService implements GeneratorService {
    @Override
    public void generate(Path openapiDocument, Path generatorConfig, Path toDir, Map<String, String> options) {
        System.out.println("Gradle Service");

        System.out.println(" OpenApi doc: " + openapiDocument);
        System.out.println(" Config: " + generatorConfig);
        System.out.println(" Dest dir: " + toDir);

        System.out.println("Options:");
        options.keySet().stream()
            .sorted()
            .forEach(opt -> System.out.println(" " + opt + " = '" + options.get(opt) + "'"));
    }
}
