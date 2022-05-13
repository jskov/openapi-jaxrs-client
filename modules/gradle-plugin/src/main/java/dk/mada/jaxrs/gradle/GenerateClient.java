package dk.mada.jaxrs.gradle;

import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.file.FileCollection;
import org.gradle.api.logging.Logger;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.JavaExec;

public abstract class GenerateClient extends JavaExec {
    
    @Input
    abstract Property<String> getText();
    
    public GenerateClient() {
        Project project = getProject();
        Logger logger = project.getLogger();
        
        
        String mainName = MainWrapper.class.getName();
        logger.lifecycle("Set main name: {}", mainName);
        getMainClass().set(mainName);

        Configuration pluginClasspath = project.getBuildscript().getConfigurations().findByName("classpath");
        Configuration generatorClasspath = project.getConfigurations().getByName(JaxrsPlugin.CONFIGURATION_NAME);
        FileCollection combined = generatorClasspath.plus(pluginClasspath);
        setClasspath(combined);

        doFirst(t -> {
            logger.lifecycle("Run task: {}", getText().get());
            logger.lifecycle("Combined classpath is {}", combined.getAsPath());
        });
    }
}
