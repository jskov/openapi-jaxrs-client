package dk.mada.jaxrs.generator.mpclient;

import dk.mada.jaxrs.generator.api.ClientContext;
import dk.mada.jaxrs.generator.api.exceptions.GeneratorException;
import dk.mada.jaxrs.generator.mpclient.api.ApiGenerator;
import dk.mada.jaxrs.generator.mpclient.dto.DtoGenerator;
import dk.mada.jaxrs.model.Model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Generate Java MicroProfile client classes.
 */
public final class JavaMPClientGenerator {
    /** Constructs new instance. */
    public JavaMPClientGenerator() {
        // empty
    }

    /**
     * Generates classes for java MP client.
     *
     * @param model          the model of the OpenApi document
     * @param opts           the generator options
     * @param clientContext  the client context
     * @param destinationDir the destination directory
     */
    public void generate(Model model, GeneratorOpts opts, ClientContext clientContext, Path destinationDir) {
        Path dtoDir = destinationDir.resolve(opts.dtoPackageDir());

        var templates = new Templates(opts, dtoDir);
        if (!clientContext.skipApi() && !opts.isSkipApiClasses()) {
            Path apiDir = destinationDir.resolve(opts.apiPackageDir());
            createDirs(apiDir);
            new ApiGenerator(opts, templates, model).generateApiClasses(apiDir);
        }
        if (!clientContext.skipDto()) {
            createDirs(dtoDir);
            new DtoGenerator(opts, templates, model).generateDtoClasses();
        }
    }

    private void createDirs(Path p) {
        try {
            Files.createDirectories(p);
        } catch (IOException e) {
            throw new GeneratorException("Failed to create directory " + p, e);
        }
    }
}
