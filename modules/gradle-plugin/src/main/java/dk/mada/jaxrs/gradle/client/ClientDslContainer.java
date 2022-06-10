package dk.mada.jaxrs.gradle.client;

import javax.inject.Inject;

import org.gradle.api.provider.Property;

/**
 * DSL container for specification of client generation.
 */
public abstract class ClientDslContainer {
    /** The client name. */
    private final String name;

    /** {@return the OpenApi document file extension. Defaults to .yaml} */
    public abstract Property<String> getDocumentExtension();

    /** {@return the flag to controls if code is generated to the source folder} */ 
    public abstract Property<Boolean> getPersistentSource();

    /** {@return the origin URL of the OpenApi document} */ 
    public abstract Property<String> getDocumentDownloadUrl();

    /**
     * Constructs a new instance.
     *
     * @param name the client name captured by this container instance
     */
    @Inject
    public ClientDslContainer(String name) { // NOSONAR - must be public to be found by Gradle 
        this.name = name;
        getDocumentExtension().convention(".yaml");
        getPersistentSource().convention(true);
    }
    
    /** {@return the name of the client} */
    public String getName() {
        return name;
    }

    /** Mark client for use of transient source code. */
    public void transientSource() {
        getPersistentSource().set(false);
    }

    /**
     * Simpler DSL method for setting download URL.
     *
     * @param url the download URL for the OpenApi document
     */
    public void download(String url) {
        getDocumentDownloadUrl().set(url);
    }
}
