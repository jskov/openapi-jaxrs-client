package dk.mada.jaxrs.gradle;

import java.util.List;

import org.gradle.api.provider.ListProperty;

public abstract class JaxrsExtension {
    public abstract ListProperty<String> getClasspath();
    
    public JaxrsExtension() {
        getClasspath().convention(List.of());
    }
}
