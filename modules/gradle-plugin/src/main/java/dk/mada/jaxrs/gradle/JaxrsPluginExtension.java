package dk.mada.jaxrs.gradle;

import javax.inject.Inject;

import org.gradle.api.file.Directory;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.provider.Property;

/**
 * The JAXRS plugin extensions.
 *
 * Contains plugin-global configuration properties.
 */
public abstract class JaxrsPluginExtension {
    /** The GAV used to procure the generator with. */
    public abstract Property<String> getGeneratorGAV();
    /** The output directory for non-persisted sources. */
    public abstract DirectoryProperty getBuildOutputDirectory();
    /** The output directory for persisted sources. */
    public abstract DirectoryProperty getSrcOutputDirectory();
    /** The directory containing OpenApi documents. */
    public abstract DirectoryProperty getOpenApiDocDirectory();

    /**
     * Constructs a new extension instance with convention defaults.
     *
     * @param pl the Gradle project layout
     */
    @Inject
    public JaxrsPluginExtension(ProjectLayout pl) { // NOSONAR - must be public to be found by Gradle
        Directory projectDirectory = pl.getProjectDirectory();
        getBuildOutputDirectory()
            .convention(pl.getBuildDirectory().dir("java-jaxrs"));
        getSrcOutputDirectory()
            .convention(projectDirectory.dir("src/main/java-jaxrs"));
        getOpenApiDocDirectory()
            .convention(projectDirectory.dir("src/openapi"));
    }
}
