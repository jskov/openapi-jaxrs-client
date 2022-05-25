package dk.mada.jaxrs.gradle;

import javax.inject.Inject;

/**
 * DSL container for specification of client generation.
 */
public abstract class DslClient {
    private final String name;

    @Inject
    public DslClient(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
