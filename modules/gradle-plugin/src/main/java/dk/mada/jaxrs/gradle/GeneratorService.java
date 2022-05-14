package dk.mada.jaxrs.gradle;

import java.nio.file.Path;

public interface GeneratorService {
    public enum GeneratorLogLevel {
        TRACE,
        DEBUG,
        INFO
    }
    
    public record ClientOptions(
            boolean overwrite,
            GeneratorLogLevel logLevel,
            boolean skipApi,
            boolean skipDto) {
    }
            
    void generateClient(ClientOptions opts, Path openapiDocument, Path generatorConfig, Path toDir);
}
