package dk.mada.jaxrs.gradle;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;

public class MainWrapper {
    public static void main(String[] args) {
        System.out.println("Service loader");
        
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
        
        Properties options = new Properties();
        options.setProperty("unknown", "whatever");
        
        activeService.generate(null, null, null, options);
    }
}
