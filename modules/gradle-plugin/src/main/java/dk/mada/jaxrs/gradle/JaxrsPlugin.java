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

        Configuration pluginClasspath = project.getBuildscript().getConfigurations().findByName("classpath");
        logger.lifecycle("Plugin classpath: {}", pluginClasspath);
        
        project.getConfigurations().create(CONFIGURATION_NAME, c -> {
//            c.defaultDependencies(d-> d.add(project.getDependencies().create("dk.mada:openapi-jaxrs-client:0.9.0")));
            c.extendsFrom(pluginClasspath);
            c.setCanBeResolved(true);
        });
        project.getDependencies().addProvider(CONFIGURATION_NAME, extension.getGeneratorGAV());
        

        project.afterEvaluate(p -> {
            logger.lifecycle("Parent: {}", pluginClasspath.getAsPath());
            logger.lifecycle("Classpath {}", project.getConfigurations().getByName(JaxrsPlugin.CONFIGURATION_NAME).getAsPath());
            
        });
        
        
        project.getTasks().register("gen", GenerateClient.class)
            .configure(gc -> gc.getText().convention("hello" + extension.getGeneratorGAV().get()));
    }

}
