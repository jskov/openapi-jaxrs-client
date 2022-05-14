package dk.mada.jaxrs;

import java.nio.file.Path;

import dk.mada.jaxrs.gradle.GeneratorService;

public final class GradleService implements GeneratorService {
    @Override
    public void generateClient(ClientOptions options, Path openapiDocument, Path generatorConfig, Path toDir) {
        System.out.println("Gradle Service");

        System.out.println(" OpenApi doc: " + openapiDocument);
        System.out.println(" Config: " + generatorConfig);
        System.out.println(" Dest dir: " + toDir);

        System.out.println("Options: " + options);
    }
}
