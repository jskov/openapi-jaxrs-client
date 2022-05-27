package dk.mada.jaxrs.gradle.client;

import javax.inject.Inject;

import org.gradle.api.provider.Property;

/**
 * DSL container for specification of client generation.
 */
public abstract class ClientDslContainer {
    /** The client name. */
    private final String name;

    /**
     * Constructs a new instance.
     *
     * @param name the client name captured by this container instance
     */
    @Inject
    public ClientDslContainer(String name) { // NOSONAR - must be public to be found by Gradle 
        this.name = name;
    }
    
    /** {@return the name of the client} */
    public String getName() {
        return name;
    }

    /** {@return the OpenApi document file extension. Defaults to .yaml} */
    public abstract Property<String> getDocumentExtension();

    /** {@return the flag to controls if code is generated to the source folder} */ 
    public abstract Property<Boolean> getPersistentSource();

    /** Mark client for use of transient source code. */
    public void transientSource() {
        getPersistentSource().set(false);
    }
    
    /**
     * Fills out the container with default values.
     *
     * @return this instance
     */
    public ClientDslContainer withDefaults() {
        getDocumentExtension().convention(".yaml");
        getPersistentSource().convention(true);
        return this;
    }
}
