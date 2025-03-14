package mada.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Runs the generator on Petstore.yaml to generate code, via the Gradle plugin.
 */
class GenerateCodeTest {
    @TempDir Path testProjectDir;

    @Test
    void canRun() throws IOException {
        String version = System.getProperty("releaseVersion", "0.0.0-SNAPSHOT");

        createBuildFile("""
           repositories {
             mavenLocal()
             mavenCentral()
           }
           jaxrs {
             generatorGAV = "dk.mada.jaxrs:openapi-jaxrs-client:@VERSION@"
             clients {
               petstore {
                 download("https://raw.githubusercontent.com/OAI/OpenAPI-Specification/main/tests/v3.0/pass/petstore.yaml")
               }
             }
           }
           """.replace("@VERSION@", version));
        
        createFile(testProjectDir.resolve("src/openapi/petstore.properties"), """
generator-api-package = dk.mada.petstore.api
generator-dto-package = dk.mada.petstore.dto
            """);
        
        BuildResult result = GradleRunner.create()
                .withProjectDir(testProjectDir.toFile())
                .withArguments("-s", "generateClientPetstore")
                .withPluginClasspath()
                .withDebug(true)
                .build();
        
        assertThat(result.getOutput())
            .contains("Generate client");
        
        assertThat(testProjectDir.resolve("src/main/java-jaxrs/petstore"))
            .isDirectoryRecursivelyContaining("glob:**/api/PetsApi.java")
            .isDirectoryRecursivelyContaining("glob:**/dto/Pet.java");
    }

    private void createFile(Path file, String body) throws IOException {
        Files.createDirectories(file.getParent());
        Files.writeString(file, body);
    }

    private void createBuildFile(String body) throws IOException {
        Path rootDir = Paths.get(".").resolve("../..").toRealPath();
        String classesDir = rootDir.resolve("build/classes/java/main").toString();
        String resourcesDir = rootDir.resolve("build/resources/main").toString();
        String pre = """
            plugins {
                id 'dk.mada.jaxrs'
            }
        """.replace("@CLASSES_DIR@", classesDir)
        .replace("@RESOURCES_DIR@", resourcesDir);
        Path buildFile = testProjectDir.resolve("build.gradle");
        String buildFileText = pre + body;
        Files.writeString(buildFile, buildFileText);
    }
}
