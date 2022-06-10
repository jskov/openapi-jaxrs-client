package dk.mada.jaxrs.gradle;

import javax.inject.Inject;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.file.Directory;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.provider.Property;

import dk.mada.jaxrs.gradle.client.ClientDslContainer;

/**
 * The JAXRS plugin extensions.
 *
 * Contains plugin-global configuration properties.
 */
public abstract class JaxrsPluginExtension {
    /** {@return the GAV used to procure the generator with} */
    public abstract Property<String> getGeneratorGAV();
    /** {@return the output directory for non-persisted sources} */
    public abstract DirectoryProperty getBuildOutputDirectory();
    /** {@return the output directory for persisted sources} */
    public abstract DirectoryProperty getSrcOutputDirectory();
    /** {@return the directory containing OpenApi documents} */
    public abstract DirectoryProperty getOpenApiDocDirectory();
    /** {@return the nested client definitions} */
    public abstract NamedDomainObjectContainer<ClientDslContainer> getClients();

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
