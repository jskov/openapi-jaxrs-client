package dk.mada.jaxrs.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.logging.Logger;

public class JaxrsPlugin implements Plugin<Project> {
    

    public static final String CONFIGURATION_NAME = "dk.mada.jaxrs";

    @Override
    public void apply(Project project) {
        JaxrsExtension extension = project.getExtensions().create("jaxrs", JaxrsExtension.class);
        
        Logger logger = project.getLogger();

        project.getConfigurations().create(CONFIGURATION_NAME);
        project.getDependencies().addProvider(CONFIGURATION_NAME, extension.getGeneratorGAV());
        
        project.getTasks().register("gen", GenerateClient.class)
            .configure(gc -> gc.getText().convention("hello" + extension.getGeneratorGAV().get()));
    }

}
