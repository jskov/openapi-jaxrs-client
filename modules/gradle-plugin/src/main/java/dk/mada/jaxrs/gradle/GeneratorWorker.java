package dk.mada.jaxrs.gradle;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import org.gradle.workers.WorkAction;

public abstract class GeneratorWorker implements WorkAction<GeneratorArgs> {

    @Override
    public void execute() {
        System.out.println("Worker generator");
        
        GeneratorArgs params = getParameters();
        Path openapiDoc = params.getOpenapiDocument().getAsFile().get().toPath();
        Path config = params.getGeneratorConfig().getAsFile().get().toPath();
        Path destDir = params.getOutputDirectory().getAsFile().get().toPath();
        Map<String, String> opts = params.getOptions().get();

        System.out.println(" OpenApi doc: " + openapiDoc);
        System.out.println(" Config: " + config);
        System.out.println(" Dest dir: " + destDir);

        System.out.println("Options:");
        opts.keySet().stream()
            .sorted()
            .forEach(opt -> System.out.println(" " + opt + " = '" + opts.get(opt) + "'"));
        
        
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
        
        activeService.generate(openapiDoc, config, destDir, opts);
    }
}
