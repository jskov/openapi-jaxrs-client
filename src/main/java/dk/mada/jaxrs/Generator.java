package dk.mada.jaxrs;

import java.nio.file.Files;
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
import dk.mada.jaxrs.openapi.ParserTypeRefs;

/**
 * Generates JAX-RS code.
 */
public class Generator {
    /** Flag to show parser info. */
    private final boolean showParserInfo;

    /**
     * Create new instance.
     *
     * @param showParserInfo true to show parser info
     */
    public Generator(boolean showParserInfo) {
        this.showParserInfo = showParserInfo;
    }

    /**
     * Generates JAX-RS code based on input OpenApi specification and user options.
     *
     * @param input     OpenApi specification for code to generate.
     * @param options   Options controlling code generation.
     * @param outputDir Directory to write the generated code to.
     */
    public void generate(final Path input, final Properties options, final Path outputDir) {
        assertInputFile(input);

        var parserOpts = new ParserOpts(options);
        var generatorOpts = new GeneratorOpts(options, parserOpts);
        var naming = new Naming(options);
        var parserRefs = new ParserTypeRefs();

        Model model = new Parser(showParserInfo, naming, parserRefs, parserOpts, generatorOpts).parse(input);

        try {
            Path apiDir = outputDir.resolve(generatorOpts.apiPackageDir());
            Files.createDirectories(apiDir);

            Path dtoDir = outputDir.resolve(generatorOpts.dtoPackageDir());
            Files.createDirectories(dtoDir);

            var templates = new Templates(apiDir, dtoDir);
            new DtoGenerator(naming, generatorOpts, templates, model).generateDtoClasses();
            new ApiGenerator(naming, generatorOpts, templates, model).generateApiClasses();

        } catch (Exception e) {
            throw new GeneratorException("Failed", e);
        }
    }

    private void assertInputFile(final Path input) {
        if (!Files.isRegularFile(input)) {
            throw new IllegalArgumentException("The OpenApi document '" + input + "' is not a regular file!");
        }
    }
}
