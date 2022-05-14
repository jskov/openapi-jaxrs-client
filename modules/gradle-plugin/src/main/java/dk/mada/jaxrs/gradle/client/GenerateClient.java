package dk.mada.jaxrs.gradle.client;

import javax.inject.Inject;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.tasks.TaskAction;
import org.gradle.workers.WorkQueue;
import org.gradle.workers.WorkerExecutor;

import dk.mada.jaxrs.gradle.JaxrsPlugin;

public abstract class GenerateClient extends DefaultTask {
    @Inject
    public abstract WorkerExecutor getWorkerExecutor();

    @TaskAction
    void generate() {
        Project project = getProject();
        
        FileCollection pluginClasspath = project.getBuildscript().getConfigurations().findByName("classpath")
                .filter(s -> s.getName().contains("plugin") || s.getName().contains("jaxrs"));
        Configuration generatorClasspath = project.getConfigurations().getByName(JaxrsPlugin.CONFIGURATION_NAME);
        FileCollection combined = generatorClasspath.plus(pluginClasspath);
        
        WorkQueue workQueue = getWorkerExecutor().classLoaderIsolation(workerSpec -> {
            workerSpec.getClasspath().from(combined); 
        });
        ProjectLayout layout = getProject().getLayout();
        
        workQueue.submit(GenerateClientWorker.class, p -> {
           p.getOutputDirectory().set(layout.getBuildDirectory().dir("xx"));
           p.getOpenapiDocument().set(layout.getBuildDirectory().file("openapi.yaml"));
           p.getGeneratorConfig().set(layout.getBuildDirectory().file("openapi.properties"));
        });
    }
}
