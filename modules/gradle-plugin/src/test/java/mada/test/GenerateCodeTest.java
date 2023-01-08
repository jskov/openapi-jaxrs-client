package mada.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 */
class GenerateCodeTest {
    @TempDir Path testProjectDir;
    
    @Test
    void canRun() throws IOException {
        createBuildFile("""
           jaxrs {
             clients {
               petstore {
                 download("https://raw.githubusercontent.com/OAI/OpenAPI-Specification/main/examples/v3.0/petstore.yaml")
               }
             }
           }
           """);
        
        createPropertiesFile(testProjectDir.resolve("src/openapi/petstore.properties"), """
                
            """);
        
        BuildResult result = GradleRunner.create()
                .withProjectDir(testProjectDir.toFile())
//                .withArguments("tasks")
                .withArguments("generateClientPetstore")
                .withPluginClasspath()
                .build();
        
        assertThat(result.getOutput())
            .contains("hello");
    }

    private void createPropertiesFile(Path file, String body) throws IOException {
        Files.createDirectories(file.getParent());
        Files.writeString(file, body);
    }

    private void createBuildFile(String body) throws IOException {
        String pre = """
            plugins {
                id 'dk.mada.jaxrs'
            }
        """;
        Path buildFile = testProjectDir.resolve("build.gradle");
        Files.writeString(buildFile, pre + body);
    }
    
}
