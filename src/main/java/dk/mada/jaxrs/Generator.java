package dk.mada.jaxrs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.GeneratorOpts.LeakedParserOpts;
import dk.mada.jaxrs.generator.JavaClientGenerator;
import dk.mada.jaxrs.generator.api.ClientContext;
import dk.mada.jaxrs.generator.api.GeneratorLogLevel;
import dk.mada.jaxrs.generator.api.GeneratorService;
import dk.mada.jaxrs.generator.api.exceptions.GeneratorBadInputException;
import dk.mada.jaxrs.generator.api.exceptions.GeneratorException;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.openapi.Parser;
import dk.mada.jaxrs.openapi.Parser.LeakedGeneratorOpts;
import dk.mada.jaxrs.openapi.ParserOpts;
import dk.mada.jaxrs.utils.DirectoryDeleter;
import dk.mada.jaxrs.utils.OptionReader;
import dk.mada.logging.LoggerConfig;

/**
 * Generates JAX-RS code.
 */
public final class Generator implements GeneratorService {
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

            var optionReader = new OptionReader(options);
            var parserOpts = new ParserOpts(optionReader);

            LeakedParserOpts leakedParserOpts = new LeakedParserOpts(parserOpts.isJseOffsetDateTime(), parserOpts.isJseLocalDateTime(),
                    parserOpts.isJseLocalDate());
            var generatorOpts = new GeneratorOpts(optionReader, leakedParserOpts);
            var naming = new Naming(options);

            assertDestinationDir(clientContext, generatorOpts, destinationDir);

            var leakedGeneratorOpts = new LeakedGeneratorOpts(TypeDateTime.get(generatorOpts.getDateTimeVariant()),
                    generatorOpts.dtoPackage());
            Model model = new Parser(clientContext.showParserInfo(), naming, parserOpts, leakedGeneratorOpts)
                    .parse(openapiDocument);

            new JavaClientGenerator().generate(model, generatorOpts, clientContext, destinationDir);
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
