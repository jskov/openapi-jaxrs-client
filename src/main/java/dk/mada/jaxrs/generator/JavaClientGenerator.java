package dk.mada.jaxrs.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import dk.mada.jaxrs.generator.api.ApiGenerator;
import dk.mada.jaxrs.generator.api.ClientContext;
import dk.mada.jaxrs.generator.api.exceptions.GeneratorException;
import dk.mada.jaxrs.generator.dto.DtoGenerator;
import dk.mada.jaxrs.model.Model;

/**
 * Generate Java client classes.
 */
public class JavaClientGenerator {
    public void generate(Model model, GeneratorOpts opts, ClientContext clientContext, Path destinationDir) {
        Path dtoDir = destinationDir.resolve(opts.dtoPackageDir());

        var templates = new Templates(dtoDir);
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
