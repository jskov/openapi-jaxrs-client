package dk.mada.jaxrs.gradle;

import java.util.ArrayList;
import java.util.List;
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
    }
}
