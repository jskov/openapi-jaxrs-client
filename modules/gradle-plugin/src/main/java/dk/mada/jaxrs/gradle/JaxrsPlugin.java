package dk.mada.jaxrs.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JaxrsPlugin implements Plugin<Project> {
    

    @Override
    public void apply(Project project) {
        JaxrsExtension extension = project.getExtensions().create("jaxrs", JaxrsExtension.class);
        
        project.getLogger().lifecycle("See classpath: {}", extension.getClasspath().get());

        
        project.getTasks().register("gen", GenerateClient.class)
            .configure(gc -> gc.getText().convention("hello" + extension.getClasspath().get()));
    }

}
