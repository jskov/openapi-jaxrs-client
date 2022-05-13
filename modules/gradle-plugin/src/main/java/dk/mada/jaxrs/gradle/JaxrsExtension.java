package dk.mada.jaxrs.gradle;

import org.gradle.api.provider.Property;

public abstract class JaxrsExtension {
    public abstract Property<String> getGeneratorGAV();
    
    public JaxrsExtension() {
    }
}
