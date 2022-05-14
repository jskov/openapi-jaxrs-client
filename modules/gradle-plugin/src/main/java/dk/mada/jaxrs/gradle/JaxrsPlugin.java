package dk.mada.jaxrs.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JaxrsPlugin implements Plugin<Project> {
    

    public static final String CONFIGURATION_NAME = "dk.mada.jaxrs";

    @Override
    public void apply(Project project) {
        JaxrsPluginExtension extension = project.getExtensions().create("jaxrs", JaxrsPluginExtension.class);
        
        project.getConfigurations().create(CONFIGURATION_NAME);
        project.getDependencies().addProvider(CONFIGURATION_NAME, extension.getGeneratorGAV());
        
        project.getTasks().register("gen", GenerateClient.class);
    }
}
