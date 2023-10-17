package dk.mada.jaxrs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.api.ApiGenerator;
import dk.mada.jaxrs.generator.api.ClientContext;
import dk.mada.jaxrs.generator.api.ContentSelector;
import dk.mada.jaxrs.generator.api.GeneratorLogLevel;
import dk.mada.jaxrs.generator.api.GeneratorService;
import dk.mada.jaxrs.generator.dto.DtoGenerator;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.openapi.Parser;
import dk.mada.jaxrs.openapi.ParserOpts;
import dk.mada.jaxrs.openapi.ParserTypeRefs;
import dk.mada.jaxrs.utils.DirectoryDeleter;
import dk.mada.jaxrs.utils.OptionReader;
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
        Console.println("Generate client");
        Console.println(" Context: " + clientContext);
        Console.println(" OpenApi doc: " + openapiDocument);
        Console.println(" Dest dir: " + destinationDir);
        Console.println(" Options: " + options);

        try {
            setLogLevels(clientContext.logLevel());
            assertInputFile(openapiDocument);

            var typeNames = new TypeNames();
            var optionReader = new OptionReader(options);
            var parserOpts = new ParserOpts(optionReader);
            var generatorOpts = new GeneratorOpts(optionReader, parserOpts);
            var naming = new Naming(options);
            var parserRefs = new ParserTypeRefs(typeNames);
            var contentSelector = new ContentSelector(parserOpts);

            assertDestinationDir(clientContext, generatorOpts, destinationDir);

            Model model = new Parser(showParserInfo, typeNames, naming, parserRefs, parserOpts, generatorOpts).parse(openapiDocument);

            Path dtoDir = destinationDir.resolve(generatorOpts.dtoPackageDir());

            var templates = new Templates(dtoDir);
            if (!clientContext.skipApi() && !generatorOpts.isSkipApiClasses()) {
                Path apiDir = destinationDir.resolve(generatorOpts.apiPackageDir());
                Files.createDirectories(apiDir);
                new ApiGenerator(naming, contentSelector, generatorOpts, templates, model).generateApiClasses(apiDir);
            }
            if (!clientContext.skipDto()) {
                Files.createDirectories(dtoDir);
                new DtoGenerator(naming, generatorOpts, templates, model).generateDtoClasses();
            }
        } catch (IllegalArgumentException e) {
            throw new GeneratorBadInputException(e.getMessage(), e);
        } catch (Exception e) {
            throw new GeneratorException("Failed", e);
        }
    }

    private void assertDestinationDir(ClientContext clientContext, GeneratorOpts generatorOpts, Path destinationDir) {
        if (Files.exists(destinationDir) && !clientContext.overwrite()) {
            throw new IllegalArgumentException("Will not write to existing output directory '" + destinationDir + "'");
        }
        if (!generatorOpts.isTestingKeepDestination()) {
            DirectoryDeleter.delete(destinationDir);
        }
    }

    /**
     * Changes logging level for caller.
     *
     * Note that for DEFAULT nothing is changed, meaning that unit testing logging gets controlled by
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
