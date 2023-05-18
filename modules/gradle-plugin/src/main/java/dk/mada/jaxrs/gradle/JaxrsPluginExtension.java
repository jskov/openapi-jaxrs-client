package dk.mada.jaxrs.gradle;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.provider.Property;

import dk.mada.jaxrs.gradle.client.ClientDslContainer;

/**
 * The JAXRS plugin extensions.
 *
 * Contains plugin-global configuration properties.
 */
public interface JaxrsPluginExtension {
    /** {@return the GAV used to procure the generator with} */
    Property<String> getGeneratorGAV();

    /** {@return the output directory for non-persisted sources} */
    DirectoryProperty getBuildOutputDirectory();

    /** {@return the output directory for persisted sources} */
    DirectoryProperty getSrcOutputDirectory();

    /** {@return the directory containing OpenApi documents} */
    DirectoryProperty getOpenApiDocDirectory();

    /** {@return the nested client definitions} */
    NamedDomainObjectContainer<ClientDslContainer> getClients();
}
