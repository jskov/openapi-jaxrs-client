package dk.mada.jaxrs.gradle.client;

import dk.mada.jaxrs.gradle.JaxrsPlugin;
import javax.inject.Inject;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;
import org.gradle.workers.WorkQueue;
import org.gradle.workers.WorkerExecutor;

/**
 * Generate JAX-RS client code from an OpenApi document.
 *
 * The task contains the Gradle configuration wiring. On action this is used to generate a new classpath which includes
 * the generator GAV (from the plugin extension).
 *
 * The task configuration and classpath is used to start a worker action which makes the actual call to the generator
 * service implementation.
 */
public abstract class GenerateClient extends DefaultTask {
    /** {@return the injected worker executor} */
    @SuppressWarnings("JavaxInjectOnAbstractMethod") // This is the Gradle way
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

    /**
     * {@return the generator version}
     *
     * This is not used as such by the task, but having it ensures that code is regenerated, if the GAV is updated.
     */
    @Input
    public abstract Property<String> getGeneratorGav();

    /** The combined plugin and configured classpath. */
    private final FileCollection combined;
    /** Flag for echoing output. */
    private final boolean echoEnabled;

    /** Create new instance. */
    public GenerateClient() { // NOSONAR - must be public for Gradle to be happy
        Project project = getProject();
        FileCollection pluginClasspath = project.getBuildscript()
                .getConfigurations()
                .findByName("classpath")
                .filter(s -> s.getName().contains("plugin") || s.getName().contains("jaxrs"));
        Configuration generatorClasspath = project.getConfigurations().getByName(JaxrsPlugin.CONFIGURATION_NAME);
        combined = generatorClasspath.plus(pluginClasspath);

        echoEnabled = project.getLogger().isInfoEnabled();
    }

    /**
     * Generates the code.
     */
    @TaskAction
    void generate() {
        WorkQueue workQueue = getWorkerExecutor()
                .classLoaderIsolation(workerSpec -> workerSpec.getClasspath().from(combined));

        workQueue.submit(GenerateClientWorker.class, p -> {
            p.getEchoFlag().set(echoEnabled);
            p.getOutputDirectory().set(getOutputDirectory());
            p.getOpenapiDocument().set(getOpenApiDocument());
            p.getGeneratorConfig().set(getGeneratorProperties());
        });
    }
}
