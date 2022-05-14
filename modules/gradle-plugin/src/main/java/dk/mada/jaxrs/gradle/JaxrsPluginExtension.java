package dk.mada.jaxrs.gradle;

import org.gradle.api.provider.Property;

public abstract class JaxrsPluginExtension {
    public abstract Property<String> getGeneratorGAV();
}
