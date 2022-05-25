package dk.mada.jaxrs.gradle.client;

import javax.inject.Inject;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;
import org.gradle.workers.WorkQueue;
import org.gradle.workers.WorkerExecutor;

import dk.mada.jaxrs.gradle.JaxrsPlugin;

/**
 * Generate JAX-RS client code from an OpenApi document.
 *
 * The task contains the Gradle configuration wiring.
 * On action this is used to generate a new classpath which
 * includes the generator GAV (from the plugin extension).
 *
 * The task configuration and classpath is used to start
 * a worker action which makes the actual call to the
 * generator service implementation.
 */
public abstract class GenerateClient extends DefaultTask {
    /** {@return the injected worker executor} */
    @Inject
    public abstract WorkerExecutor getWorkerExecutor();

    /** {@return the output directory for the generator} */
    @OutputDirectory
    public abstract DirectoryProperty getOutputDirectory(); 

    /** {@return the OpenAPI document read by the generator} */
    @InputFile
    public abstract RegularFileProperty getOpenApiDocument(); 

    /** {@return the generator properties} */
    @InputFile
    public abstract RegularFileProperty getGeneratorProperties(); 

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

        workQueue.submit(GenerateClientWorker.class, p -> {
           p.getOutputDirectory().set(getOutputDirectory());
           p.getOpenapiDocument().set(getOpenApiDocument());
           p.getGeneratorConfig().set(getGeneratorProperties());
        });
    }
}
