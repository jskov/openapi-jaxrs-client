package dk.mada.jaxrs.gradle.client;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;

import org.gradle.workers.WorkAction;

import dk.mada.jaxrs.generator.api.ClientContext;
import dk.mada.jaxrs.generator.api.GeneratorLogLevel;
import dk.mada.jaxrs.generator.api.GeneratorService;

/**
 * Worker which runs with a custom classpath where the generator service can be looked up.
 *
 * The Gradle worker arguments are rearranged to be suitable for the service, which is then invoked.
 */
public abstract class GenerateClientWorker implements WorkAction<GenerateClientWorkerArgs> {
    /** Flag controlling crude log output for worker. */
    private boolean echoWorkerInfo;

    /**
     * Executes the action.
     */
    @Override
    public void execute() {
        GenerateClientWorkerArgs params = getParameters();

        echoWorkerInfo = Boolean.TRUE.equals(params.getEchoFlag().get());

        log("Worker generator");

        Path openapiDoc = params.getOpenapiDocument().getAsFile().get().toPath();
        Path config = params.getGeneratorConfig().getAsFile().get().toPath();
        Path destDir = params.getOutputDirectory().getAsFile().get().toPath();

        Properties options = loadConfig(config);

        log(" OpenApi doc: " + openapiDoc);
        log(" Dest dir: " + destDir);
        log(" Config file: " + config);
        log(" Options: " + options);

        List<GeneratorService> services = new ArrayList<>();
        ServiceLoader<GeneratorService> loader = ServiceLoader.load(GeneratorService.class);
        for (GeneratorService service : loader) {
            log("Found service " + service.getClass().getName());
            services.add(service);
        }
        log("Total " + services.size() + " services");

        if (services.isEmpty()) {
            throw new IllegalStateException("Did not find a required GeneratorService. Please review generatorGAV option!");
        }
        if (services.size() > 1) {
            throw new IllegalStateException("Cannot handle multiple GeneratorService implementations: " + services);
        }

        GeneratorService activeService = services.get(0);

        boolean overwrite = true;
        GeneratorLogLevel logLevel = GeneratorLogLevel.DEFAULT;
        boolean skipApi = false;
        boolean skipDto = false;
        ClientContext cc = new ClientContext(overwrite, logLevel, skipApi, skipDto);
        activeService.generateClient(cc, openapiDoc, options, destDir);
    }

    private Properties loadConfig(Path configFile) {
        var props = new Properties();
        if (Files.exists(configFile)) {
            log("Reading config from " + configFile);
            try (Reader r = Files.newBufferedReader(configFile)) {
                props.load(r);
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to load config from " + configFile, e);
            }
        } else {
            log("No configuration file found");
        }
        return props;
    }

    private void log(String message) {
        if (echoWorkerInfo) {
            System.out.println(message); // NOSONAR
        }
    }
}
