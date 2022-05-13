package dk.mada.jaxrs.gradle;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;

import javax.inject.Inject;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.logging.Logger;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.gradle.workers.WorkQueue;
import org.gradle.workers.WorkerExecutor;

public abstract class GenerateClient extends DefaultTask {
    @Inject
    abstract public WorkerExecutor getWorkerExecutor();

    @Input
    abstract Property<String> getText();
    
    @TaskAction
    void generate() {
        Project project = getProject();
        Logger logger = project.getLogger();
        
        
        String mainName = MainWrapper.class.getName();
        logger.lifecycle("Set main name: {}", mainName);

        FileCollection pluginClasspath = project.getBuildscript().getConfigurations().findByName("classpath")
                .filter(s -> s.getName().contains("plugin") || s.getName().contains("jaxrs"));
        Configuration generatorClasspath = project.getConfigurations().getByName(JaxrsPlugin.CONFIGURATION_NAME);
        FileCollection combined = generatorClasspath.plus(pluginClasspath);
        
        WorkQueue workQueue = getWorkerExecutor().classLoaderIsolation(workerSpec -> {
            workerSpec.getClasspath().from(combined); 
        });
        ProjectLayout layout = getProject().getLayout();
        
        workQueue.submit(GeneratorWorker.class, p -> {
           p.getOptions().set(Map.of("unknown", "dummy"));
           p.getOutputDirectory().set(layout.getBuildDirectory().dir("xx"));
           p.getOpenapiDocument().set(layout.getBuildDirectory().file("openapi.yaml"));
           p.getGeneratorConfig().set(layout.getBuildDirectory().file("openapi.properties"));
        });
        
        
        /* hardwired classpath
        List<URL> urls = combined.getFiles().stream()
            .map(this::toUrl)
            .toList();

        URLClassLoader classloader = new URLClassLoader(urls.toArray(new URL[urls.size()]), Thread.currentThread().getContextClassLoader());
        
        try {
            Thread.currentThread().setContextClassLoader(classloader);
  
            
            List<GeneratorService> services = new ArrayList<>();
            ServiceLoader<GeneratorService> loader = ServiceLoader.load(GeneratorService.class);
            for (GeneratorService service : loader) {
                System.out.println(" found " + service.getClass().getName());
                services.add(service);
            }
            
            System.out.println("Total " + services.size() + " services");
        } finally {
            // cleanup?
        }
*/        
    }
    
    private URL toUrl(File f) {
        try {
            return f.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Failed to convert " + f + " to URL", e);
        }
    }
    
//
//    classLoader = new URLClassLoader(urls as URL[], Thread.currentThread().contextClassLoader)
//    Thread.currentThread().contextClassLoader = classLoader

}
