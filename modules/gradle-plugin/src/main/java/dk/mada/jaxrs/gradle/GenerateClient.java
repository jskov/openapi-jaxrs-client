package dk.mada.jaxrs.gradle;

import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.JavaExec;
import org.gradle.api.tasks.TaskAction;

public abstract class GenerateClient extends JavaExec {
    
    @Input
    abstract Property<String> getText();
    
    public GenerateClient() {
        Project project = getProject();
        Logger logger = project.getLogger();
        
        
        String mainName = MainWrapper.class.getName();
        logger.lifecycle("Set main name: {}", mainName);
        getMainClass().set(mainName);

        doFirst(t -> {
            logger.lifecycle("Run task: {}", getText().get());
            setClasspath(project.getConfigurations().getByName(JaxrsPlugin.CONFIGURATION_NAME));
        });
    }
}
