package dk.mada.jaxrs.gradle;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.Directory;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;

import dk.mada.jaxrs.gradle.client.GenerateClient;

/**
 * Plugin for JAX-RS generator.
 *
 * Allows configuration of plugin-wide settings via the
 * extension.
 * Allows registration of client generator tasks via
 * simple DSL.
 */
public class JaxrsPlugin implements Plugin<Project> {
    /** The task group name used for client generator tasks. */
    private static final String CLIENT_TASK_GROUP = "JAX-RS Client";
    /** The Configuration name used for the generator classpath. */
    public static final String CONFIGURATION_NAME = "dk.mada.jaxrs";

    @Override
    public void apply(Project project) {
        ObjectFactory objects = project.getObjects();
        ExtensionContainer extensions = project.getExtensions();
        JaxrsPluginExtension jaxrsExtension = extensions.create("jaxrs", JaxrsPluginExtension.class);
        
        project.getPlugins().apply(JavaPlugin.class);
        SourceSetContainer sourceSets = extensions.getByType(SourceSetContainer.class);
        SourceSet mainSrcSet = sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME);
        
        project.getConfigurations().create(CONFIGURATION_NAME);
        project.getDependencies().addProvider(CONFIGURATION_NAME, jaxrsExtension.getGeneratorGAV());
        
        NamedDomainObjectContainer<DslClient> clientContainer =
            objects.domainObjectContainer(DslClient.class, name -> objects.newInstance(DslClient.class, name));
        extensions.add("clients", clientContainer);

        clientContainer.all(client -> {
            String docName = client.getName();

            Provider<Directory> taskOutputDir = jaxrsExtension.getRootOutputDirectory().dir(docName);
            mainSrcSet.getJava().srcDir(taskOutputDir);

            project.getTasks().register("generateClient" + toPartialTaskName(docName), GenerateClient.class, t -> {
                t.setDescription("Generates JAX-RS client " + docName);
                t.setGroup(CLIENT_TASK_GROUP);
                t.getOutputDirectory().set(taskOutputDir);
                t.getOpenApiDocument().set(jaxrsExtension.getOpenApiDocDirectory().file(docName + ".yaml"));
                t.getGeneratorProperties().set(jaxrsExtension.getOpenApiDocDirectory().file(docName + ".properties"));
            });
        });
    }

    // Should probably use some variant of Identifiers:makeValid
    private String toPartialTaskName(String input) {
        String s = input
                .replaceAll("[^a-zA-Z0-9]", "");
        if (s.length() == 1) {
            return s.toUpperCase();
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
