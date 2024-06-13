package dk.mada.jaxrs.gradle;

import java.util.Locale;
import java.util.Set;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.file.Directory;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.TaskProvider;

import dk.mada.jaxrs.gradle.client.GenerateClient;

/**
 * Plugin for JAX-RS generator.
 *
 * Allows configuration of plugin-wide settings via the extension. Allows registration of client generator tasks via
 * simple DSL.
 */
public class JaxrsPlugin implements Plugin<Project> {
    /** The task group name used for client generator tasks. */
    private static final String CLIENT_TASK_GROUP = "JAX-RS Client";
    /** The Configuration name used for the generator classpath. */
    public static final String CONFIGURATION_NAME = "dk.mada.jaxrs";

    /**
     * Applies the plugin to the project.
     *
     * @param project the project
     */
    @Override
    public void apply(Project project) {
        project.getPlugins().apply(JavaPlugin.class);

        JaxrsPluginExtension jaxrsExtension = project.getExtensions().create("jaxrs", JaxrsPluginExtension.class);

        project.getConfigurations().create(CONFIGURATION_NAME);
        project.getDependencies().addProvider(CONFIGURATION_NAME, jaxrsExtension.getGeneratorGAV());

        createTasksFromDsl(project, jaxrsExtension);
    }

    /**
     * Uses DSL input to create download and generate tasks for each client.
     *
     * @param project        the gradle project
     * @param jaxrsExtension the jaxrs extension
     */
    private void createTasksFromDsl(Project project, JaxrsPluginExtension jaxrsExtension) {
        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
        SourceSet mainSrcSet = sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME);

        ProjectLayout pl = project.getLayout();
        DirectoryProperty extSrcOutputDirectory = jaxrsExtension.getSrcOutputDirectory()
                .convention(pl.getProjectDirectory().dir("src/main/java-jaxrs"));
        DirectoryProperty extBuildOutputDirectory = jaxrsExtension.getBuildOutputDirectory()
                .convention(pl.getBuildDirectory().dir("java-jaxrs"));
        DirectoryProperty extOpenApiDocDirectory = jaxrsExtension.getOpenApiDocDirectory()
                .convention(pl.getProjectDirectory().dir("src/openapi"));

        jaxrsExtension.getClients().all(client -> {
            String docName = client.getName();
            Provider<Directory> taskOutputDir = client.getPersistentSource()
                    .map(isPersistent -> Boolean.TRUE.equals(isPersistent)
                            ? extSrcOutputDirectory.dir(docName).get()
                            : extBuildOutputDirectory.dir(docName).get());
            mainSrcSet.getJava().srcDir(taskOutputDir);

            Provider<String> openapiDocumentName = client.getDocumentExtension().map(ext -> docName + ext);

            String partialTaskName = toPartialTaskName(docName);

            TaskProvider<DownloadOpenApiDocument> downloadTask = project.getTasks().register("downloadDoc" + partialTaskName,
                    DownloadOpenApiDocument.class, t -> {
                        Property<String> url = client.getDocumentDownloadUrl();

                        t.setDescription("Downloads OpenApi document for client " + docName);
                        t.setGroup(CLIENT_TASK_GROUP);
                        t.getDocumentUrl().set(url);
                        t.getOutputFile().set(extOpenApiDocDirectory.file(openapiDocumentName));
                    });

            TaskProvider<GenerateClient> generateTask = project.getTasks().register("generateClient" + partialTaskName,
                    GenerateClient.class, t -> {
                        t.setDescription("Generates JAX-RS client " + docName);
                        t.setGroup(CLIENT_TASK_GROUP);
                        t.getOutputDirectory().set(taskOutputDir);
                        t.getOpenApiDocument().set(extOpenApiDocDirectory.file(openapiDocumentName));
                        t.getGeneratorProperties().set(extOpenApiDocDirectory.file(docName + ".properties"));
                        t.getGeneratorGav().set(jaxrsExtension.getGeneratorGAV());
                        t.dependsOn(downloadTask);
                    });

            addAsJavaCompileDependency(project, client.getPersistentSource(), docName, generateTask);
        });
    }

    /**
     * Adds generator task as a dependency to 'compileJava' task.
     *
     * This is done lazy (so a little ugly), and only if the generator output is not persistent.
     *
     * @param project            the gradle project
     * @param isPersistentSource the flag for persistence
     * @param docName            the document name
     * @param tp                 the provider for the generator task
     */
    private void addAsJavaCompileDependency(Project project, Property<Boolean> isPersistentSource, String docName,
            TaskProvider<GenerateClient> tp) {
        TaskProvider<Task> compileTp = project.getTasks().named(JavaPlugin.COMPILE_JAVA_TASK_NAME);
        compileTp.configure(compileTask -> {
            Provider<Set<GenerateClient>> optionalTasks = project.provider(() -> {
                Set<GenerateClient> res = Set.of();
                if (Boolean.FALSE.equals(isPersistentSource.get())) {
                    res = Set.of(tp.get());
                }
                project.getLogger().info("Generator {} dependency {}", docName, res);
                return res;
            });

            compileTask.dependsOn(optionalTasks);
        });
    }

    // Should probably use some variant of Identifiers:makeValid
    private String toPartialTaskName(String input) {
        String s = input
                .replaceAll("[^a-zA-Z0-9]", "");
        if (s.length() == 1) {
            return s.toUpperCase(Locale.ROOT);
        }
        return s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1);
    }
}
