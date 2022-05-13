package dk.mada.jaxrs.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public abstract class GenerateClient extends DefaultTask {
    
    @Input
    abstract Property<String> getText();
    
    
    @TaskAction
    public void run() {
        getProject().getLogger().lifecycle("Run task: {}", getText().get());
    }
}
