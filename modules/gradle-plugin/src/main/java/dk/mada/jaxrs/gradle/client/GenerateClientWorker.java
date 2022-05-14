package dk.mada.jaxrs.gradle.client;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import javax.inject.Inject;

import org.gradle.api.model.ObjectFactory;
import org.gradle.workers.WorkAction;

import dk.mada.jaxrs.gradle.GeneratorService;
import dk.mada.jaxrs.gradle.GeneratorService.ClientOptions;
import dk.mada.jaxrs.gradle.GeneratorService.GeneratorLogLevel;

public abstract class GenerateClientWorker implements WorkAction<GenerateClientWorkerArgs> {

    @Inject
    public GenerateClientWorker(ObjectFactory of) {
        System.out.println("GOT P " + of);
    }
    
    @Override
    public void execute() {
        System.out.println("Worker generator");
        
        GenerateClientWorkerArgs params = getParameters();
        Path openapiDoc = params.getOpenapiDocument().getAsFile().get().toPath();
        Path config = params.getGeneratorConfig().getAsFile().get().toPath();
        Path destDir = params.getOutputDirectory().getAsFile().get().toPath();

        System.out.println(" OpenApi doc: " + openapiDoc);
        System.out.println(" Config: " + config);
        System.out.println(" Dest dir: " + destDir);

        List<GeneratorService> services = new ArrayList<>();
        ServiceLoader<GeneratorService> loader = ServiceLoader.load(GeneratorService.class);
        for (GeneratorService service : loader) {
            System.out.println(" found " + service.getClass().getName());
            services.add(service);
        }
        System.out.println("Total " + services.size() + " services");

        if (services.size() == 0) {
            throw new IllegalStateException("Did not find a required GeneratorService. Please review generatorGAV option!");
        }
        if (services.size() > 1) {
            throw new IllegalStateException("Cannot handle multiple GeneratorService implementations: " + services);
        }
        
        GeneratorService activeService = services.get(0);
        
        boolean overwrite = false;
        GeneratorLogLevel logLevel = GeneratorLogLevel.INFO;
        boolean skipApi = false;
        boolean skipDto = false;
        ClientOptions clientOpts = new ClientOptions(overwrite, logLevel, skipApi, skipDto);
        
        activeService.generateClient(clientOpts, openapiDoc, config, destDir);
    }
}
