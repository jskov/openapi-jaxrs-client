package dk.mada.jaxrs;

import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.api.ApiGenerator;
import dk.mada.jaxrs.generator.dto.DtoGenerator;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.openapi.Parser;
import dk.mada.jaxrs.openapi.ParserOpts;

/**
 * Generates JAX-RS code.
 */
public class Generator {
    /**
     * Generates JAX-RS code based on input OpenApi specification and user options.
     *
     * @param input     OpenApi specification for code to generate.
     * @param options   Options controlling code generation.
     * @param outputDir Directory to write the generated code to.
     */
    public void generate(final Path input, final Properties options, final Path outputDir) {
        var parserOpts = new ParserOpts(options);
        var generatorOpts = new GeneratorOpts(options, parserOpts);
        var naming = new Naming(options);

        Model model = new Parser(naming, parserOpts, generatorOpts).parse(input);

        try {
            Path apiDir = outputDir.resolve(generatorOpts.apiPackageDir());
            Path dtoDir = outputDir.resolve(generatorOpts.dtoPackageDir());

            var templates = new Templates(generatorOpts);
            new DtoGenerator(naming, generatorOpts, templates, model).generateDtoClasses(dtoDir);
            new ApiGenerator(naming, generatorOpts, templates, model).generateApiClasses(apiDir);

        } catch (Exception e) {
            throw new GeneratorException("Failed", e);
        }
    }
}
