package dk.mada.jaxrs.gradle;

import javax.inject.Inject;

import org.gradle.api.file.Directory;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.provider.Property;

public abstract class JaxrsPluginExtension {
    public abstract Property<String> getGeneratorGAV();
    public abstract DirectoryProperty getRootOutputDirectory();
    public abstract DirectoryProperty getOpenApiDocDirectory();

    @Inject
    public JaxrsPluginExtension(ProjectLayout pl) {
        Directory projectDirectory = pl.getProjectDirectory();
        getRootOutputDirectory()
            .convention(projectDirectory.dir("src/main/java-jaxrs"));
        getOpenApiDocDirectory()
            .convention(projectDirectory.dir("src/openapi"));
    }
}
