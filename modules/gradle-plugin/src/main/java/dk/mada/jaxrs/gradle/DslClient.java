package dk.mada.jaxrs.gradle;

import javax.inject.Inject;

import org.gradle.api.provider.Property;

/**
 * DSL container for specification of client generation.
 */
public abstract class DslClient {
    /** The client name. */
    private final String name;

    /**
     * Constructs a new instance.
     *
     * @param name the client name captured by this container instance
     */
    @Inject
    public DslClient(String name) { // NOSONAR - must be public to be found by Gradle 
        this.name = name;
    }
    
    /** {@return the name of the client} */
    public String getName() {
        return name;
    }

    /** {@return the OpenApi document file extension. Defaults to .yaml} */
    public abstract Property<String> getDocumentExtension();
    
    /**
     * Fills out the container with default values.
     *
     * @return this instance
     */
    DslClient withDefaults() {
        getDocumentExtension().convention(".yaml");
        return this;
    }
}
