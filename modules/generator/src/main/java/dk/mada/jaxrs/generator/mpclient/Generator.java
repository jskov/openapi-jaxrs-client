package dk.mada.jaxrs.generator.mpclient;

import dk.mada.jaxrs.generator.api.ClientContext;
import dk.mada.jaxrs.generator.api.GeneratorLogLevel;
import dk.mada.jaxrs.generator.api.GeneratorService;
import dk.mada.jaxrs.generator.api.exceptions.GeneratorBadInputException;
import dk.mada.jaxrs.generator.api.exceptions.GeneratorException;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts.LeakedParserOpts;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.options.OptionReader;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.openapi.Parser;
import dk.mada.jaxrs.openapi.Parser.LeakedGeneratorOpts;
import dk.mada.jaxrs.openapi.ParserOpts;
import dk.mada.jaxrs.utils.DirectoryDeleter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Properties;

/**
 * Generates JAX-RS code.
 */
public final class Generator implements GeneratorService {
    /** Constructs new instance. */
    public Generator() {
        // empty
    }

    @Override
    public void generateClient(
            ClientContext clientContext, Path openapiDocument, final Properties options, Path destinationDir) {
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

            LeakedParserOpts leakedParserOpts = new LeakedParserOpts(
                    parserOpts.isJseOffsetDateTime(), parserOpts.isJseLocalDateTime(), parserOpts.isJseLocalDate());
            var generatorOpts = new GeneratorOpts(optionReader, leakedParserOpts);
            var naming = new Naming(optionReader);

            defineLatePrimitives(generatorOpts);

            assertDestinationDir(clientContext, generatorOpts, destinationDir);

            TypeNames typeNames = new TypeNames();

            Type noFormatNumberType = getNoFormatType(typeNames, generatorOpts);
            var leakedGeneratorOpts = new LeakedGeneratorOpts(
                    TypeDateTime.get(generatorOpts.getDateTimeVariant()),
                    generatorOpts.dtoPackage(),
                    generatorOpts.isApiUseMultipartForm(),
                    noFormatNumberType);
            Model model = new Parser(clientContext.showParserInfo(), typeNames, naming, parserOpts, leakedGeneratorOpts)
                    .parse(openapiDocument);

            new JavaMPClientGenerator().generate(model, generatorOpts, clientContext, destinationDir);
        } catch (IllegalArgumentException e) {
            throw new GeneratorBadInputException(e.getMessage(), e);
        } catch (GeneratorException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneratorException(e.getMessage(), e);
        }
    }

    private Type getNoFormatType(TypeNames typeNames, GeneratorOpts opts) {
        String name = opts.getNoFormatNumberType();
        TypeName tn = typeNames.find(name);
        if (TypeNames.BIG_DECIMAL.equals(tn)) {
            return TypeBigDecimal.get();
        } else if (TypeNames.FLOAT.equals(tn) || TypeNames.FLOAT_WRAPPER.equals(tn)) {
            return Primitive.FLOAT;
        } else if (TypeNames.DOUBLE.equals(tn) || TypeNames.DOUBLE_WRAPPER.equals(tn)) {
            return Primitive.DOUBLE;
        } else {
            throw new GeneratorBadInputException(
                    name + " is not a supported type for no-format number",
                    GeneratorOpts.GENERATOR_TYPE_NO_FORMAT_NUMBER);
        }
    }

    private void defineLatePrimitives(GeneratorOpts genOpts) {
        Primitive desiredNoFormatIntType =
                Primitive.valueOf(genOpts.getNoFormatIntegerType().toUpperCase(Locale.ROOT));
        Primitive.NOFORMAT_INT.setNoformatIntTypes(desiredNoFormatIntType);
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
