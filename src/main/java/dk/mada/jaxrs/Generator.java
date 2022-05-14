package dk.mada.jaxrs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.api.ApiGenerator;
import dk.mada.jaxrs.generator.dto.DtoGenerator;
import dk.mada.jaxrs.gradle.GeneratorService;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.openapi.Parser;
import dk.mada.jaxrs.openapi.ParserOpts;
import dk.mada.jaxrs.openapi.ParserTypeRefs;
import dk.mada.logging.LoggerConfig;

/**
 * Generates JAX-RS code.
 */
public final class Generator implements GeneratorService {
    /** Flag to show parser info. */
    private final boolean showParserInfo;

    /**
     * Create new instance.
     */
    public Generator() {
        this(false);
    }

    /**
     * Create new instance.
     *
     * @param showParserInfo true to show parser info
     */
    public Generator(boolean showParserInfo) {
        this.showParserInfo = showParserInfo;
    }

    @Override
    public void generateClient(ClientContext clientContext, Path openapiDocument, final Properties options, Path destinationDir) {
        System.out.println("Generate client");
        System.out.println(" Context: " + clientContext);
        System.out.println(" OpenApi doc: " + openapiDocument);
        System.out.println(" Dest dir: " + destinationDir);
        System.out.println(" Options: " + options);

        setLogLevels(clientContext.logLevel());
        assertInputFile(openapiDocument);
        assertDestinationDir(clientContext, destinationDir);

        var parserOpts = new ParserOpts(options);
        var generatorOpts = new GeneratorOpts(options, parserOpts);
        var naming = new Naming(options);
        var parserRefs = new ParserTypeRefs();

        Model model = new Parser(showParserInfo, naming, parserRefs, parserOpts, generatorOpts).parse(openapiDocument);

        try {
            Path apiDir = destinationDir.resolve(generatorOpts.apiPackageDir());
            Files.createDirectories(apiDir);

            Path dtoDir = destinationDir.resolve(generatorOpts.dtoPackageDir());
            Files.createDirectories(dtoDir);

            var templates = new Templates(apiDir, dtoDir);
            if (!clientContext.skipApi()) {
                new ApiGenerator(naming, generatorOpts, templates, model).generateApiClasses();
            }
            if (!clientContext.skipDto()) {
                new DtoGenerator(naming, generatorOpts, templates, model).generateDtoClasses();
            }
        } catch (Exception e) {
            throw new GeneratorException("Failed", e);
        }
    }

    private void assertDestinationDir(ClientContext clientContext, Path destinationDir) {
        if (Files.exists(destinationDir) && !clientContext.overwrite()) {
            throw new IllegalArgumentException("Will not write to existing output directory '" + destinationDir + "'");
        }
    }

    /**
     * Changes logging level for caller.
     *
     * Note that for DEFAULT nothing is changed, meaning
     * that unit testing logging gets controlled by
     * logging-test.properties.
     *
     * @param logLevel the desired log level
     */
    private void setLogLevels(GeneratorLogLevel logLevel) {
        if (logLevel == GeneratorLogLevel.DEBUG) {
            LoggerConfig.enableDebugLogOutput();
        } else if (logLevel == GeneratorLogLevel.TRACE) {
            LoggerConfig.enableTraceLogOutput();
        }
    }

    private void assertInputFile(final Path input) {
        if (!Files.isRegularFile(input)) {
            throw new IllegalArgumentException("The OpenApi document '" + input + "' is not a regular file!");
        }
    }
}
