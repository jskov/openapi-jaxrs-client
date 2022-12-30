package dk.mada.jaxrs;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Callable;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.gradle.GeneratorService.ClientContext;
import dk.mada.jaxrs.gradle.GeneratorService.GeneratorLogLevel;
import dk.mada.logging.LoggerConfig;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Visibility;
import picocli.CommandLine.IDefaultValueProvider;
import picocli.CommandLine.IVersionProvider;
import picocli.CommandLine.Model.ArgSpec;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Model.OptionSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

/**
 * Main class for command line invocation.
 */
@Command(
        name = "ojc",
        header = "",
        mixinStandardHelpOptions = true,
        versionProvider = Main.Version.class,
        defaultValueProvider = Main.DefaultValues.class,
        description = "Generates API resource (interfaces) and DTO model (classes) from an OpenApi document."
                + " The output is suitable for use with a Micro Profile REST client.")
public final class Main implements Callable<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /** The picoCli spec. */
    @Nullable @Spec
    private CommandSpec spec;

    /** Flag to enable debug logging output. */
    @Option(names = "--debug", description = "Show debug-level log output.")
    private boolean debug;

    /** Flag to enable trace logging output. */
    @Option(names = "--trace", description = "Show trace-level log output.")
    private boolean trace;

    /** Flag to enable printing of parser info. */
    @Option(names = "--show-parser-info", description = "Show parser summary information.")
    private boolean showParserInfo;

    /** Output directory for generated classes. */
    @Nullable @Option(names = { "-o", "--output-directory" }, description = "Output directory for the generated classes.", required = true)
    private Path outputDir;

    /** Flag to enable writing to existing directory. */
    @Option(names = "--overwrite", description = "Write output to existing output directory, delete existing api/dto packages.")
    private boolean overwrite;

    /** Input document. */
    @Nullable @Option(names = { "-i", "--input" }, description = "OpenApi document input.", required = true)
    private Path inputDocument;

    /** Configuration properties. */
    @Nullable @Option(names = { "-c", "--config" }, description = "Configuration properties.", showDefaultValue = Visibility.ALWAYS)
    private Path configuration;

    /** Flag to disable generation of API classes. */
    @Option(names = "--skip-api-generation", description = "Skip generation of API classes.", defaultValue = "false")
    private boolean skipApiGeneration;

    /** Package to place the API classes in. */
    @Nullable @Option(names = "--api-package", description = "Package to place the API classes in.")
    private String apiPackage;

    /** Flag to disable generation of DTO classes. */
    @Option(names = "--skip-dto-generation", description = "Skip generation of DTO classes.", defaultValue = "false")
    private boolean skipDtoGeneration;

    /** Package to place the DTO classes in. */
    @Nullable @Option(names = "--dto-package", description = "Package to place the DTO classes in.")
    private String dtoPackage;

    private Main() {
    }

    static class Version implements IVersionProvider {
        @Override
        public String[] getVersion() throws Exception {
            try (InputStream is = Main.class.getResourceAsStream("/openapi-jaxrs-client-version.properties");
                    InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(isr)) {

                Properties resourceProps = new Properties();
                resourceProps.load(br);

                String version = "Version: " + resourceProps.getProperty("version");
                String builtOn = "Built on: " + resourceProps.getProperty("builtOn");
                return new String[] { version, builtOn };
            }
        }
    }

    /**
     * Provides default value for configuration input based on the inputDocument argument.
     */
    static class DefaultValues implements IDefaultValueProvider {
        @Nullable @Override
        public String defaultValue(ArgSpec argSpec) throws Exception {
            if (isNamedOption(argSpec, "-c")) {
                String inputDocument = getInputDocument(argSpec.command().args());
                if (inputDocument != null) {
                    String configDefault = inputDocument
                            .replaceFirst(".ya?ml$", ".properties")
                            .replaceFirst(".json$", ".properties");
                    if (!configDefault.equals(inputDocument)) {
                        return configDefault;
                    }
                }
            }
            return null;
        }

        /**
         * Get the input document argument.
         *
         * @param args all the arguments
         * @return the input document path or null if not specified.
         */
        @Nullable private String getInputDocument(List<ArgSpec> args) {
            return args.stream()
                    .filter(as -> isNamedOption(as, "-i"))
                    .findFirst()
                    .map(inputOption -> {
                        Object value = inputOption.getValue();
                        if (value == null) {
                            return null;
                        } else {
                            return Objects.toString(value);
                        }
                    })
                    .orElse(null);
        }

        /**
         * Determine if argument spec has the specified name.
         *
         * @param argSpec spec to look for names in
         * @param name    argument name to look for
         * @return true if the spec matches the name.
         */
        private boolean isNamedOption(ArgSpec argSpec, String name) {
            if (argSpec instanceof OptionSpec os) {
                for (String a : os.names()) {
                    if (name.equals(a)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public Integer call() throws Exception {
        GeneratorLogLevel logLevel = GeneratorLogLevel.DEFAULT;
        if (debug) {
            logLevel = GeneratorLogLevel.DEBUG;
        }
        if (trace) {
            logLevel = GeneratorLogLevel.TRACE;
        }

        // nullaway
        if (outputDir == null || inputDocument == null) {
            throw new IllegalArgumentException("Need input document and/or output directory");
        }

        validateArguments();

        logger.info("Reads OpenApi document from {}", inputDocument);
        logger.info("Generates files in {}", outputDir);
        Properties config = readConfiguration(configuration);

        ClientContext cc = new ClientContext(overwrite, logLevel, skipApiGeneration, skipDtoGeneration);
        new Generator(showParserInfo).generateClient(cc, inputDocument, config, outputDir);

        return 0;
    }

    private void validateArguments() {
        if (!Files.isRegularFile(inputDocument)) {
            argumentFail("The OpenApi document '" + inputDocument + "' is not a regular file!");
        }

        if (Files.exists(outputDir) && !overwrite) {
            argumentFail("Will not write to existing output directory '" + outputDir + "'");
        }

        boolean configFileRequired = apiPackage == null || dtoPackage == null;
        if (configFileRequired && !Files.isRegularFile(configuration)) {
            argumentFail("The configuration file '" + configuration + "' is not a regular file!");
        }
    }

    /**
     * Reads configuration from provided file (if present).
     *
     * Options for api- and dto-packages override the settings in the configuration file.
     *
     * @param configFile the file to read configuration from
     * @return the combined configuration properties
     */
    private Properties readConfiguration(@Nullable Path configFile) {
        var props = new Properties();
        if (configFile != null && Files.exists(configFile)) {
            logger.info("Reading config from {}", configFile);
            try (Reader r = Files.newBufferedReader(configFile)) {
                props.load(r);
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to load config from " + configFile, e);
            }
        } else {
            logger.info("No configuration file found");
        }

        if (apiPackage != null) {
            props.setProperty(GeneratorOpts.GENERATOR_API_PACKAGE, apiPackage);
        }
        if (dtoPackage != null) {
            props.setProperty(GeneratorOpts.GENERATOR_DTO_PACKAGE, dtoPackage);
        }

        if (logger.isDebugEnabled()) {
            String nl = System.lineSeparator();
            String config = props.stringPropertyNames().stream()
                    .sorted()
                    .map(n -> " " + n + " : " + props.getProperty(n))
                    .collect(joining(nl));
            logger.debug("Configuration properties:{}{}", nl, config);
        }

        return props;
    }

    private void argumentFail(String message) {
        throw new CommandLine.ParameterException(getCommandLine(), message);
    }

    private CommandLine getCommandLine() {
        if (spec == null) {
            throw new IllegalStateException("Missing spec, nullaway handling");
        }
        return spec.commandLine();
    }

    /**
     * Will (eventually) start the generator from command line.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int exitCode = mainNoExit(args);
        System.exit(exitCode);
    }

    /**
     * Run the generator from command line arguments without System.exit.
     *
     * @param args command line arguments
     * @return exit code
     */
    public static int mainNoExit(String[] args) {
        LoggerConfig.loadConfig();
        CommandLine commandLine = new CommandLine(new Main());
        commandLine.parseArgs(args);

        return commandLine.execute(args);
    }
}
