package mada.fixture;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.api.ClientContext;
import dk.mada.jaxrs.generator.api.GeneratorLogLevel;
import dk.mada.jaxrs.generator.api.exceptions.GeneratorBadInputException;
import dk.mada.jaxrs.generator.mpclient.Generator;
import dk.mada.jaxrs.utils.DirectoryDeleter;

/**
 * Runs end-to-end test from specified directory.
 *
 * The input is the OpenApi file (openapi.yaml) and
 * the test options (test.props).
 *
 * The expected output is the api and dto folders (both
 * optional depending on the test options).
 *
 * The test is executed by generating code from the test
 * input and comparing it to the expected output.
 *
 * If the generated code does not match the expected output,
 * a diff is run on the folders to help diagnostics.
 */
public class EndToEndTester {
    private static final Logger logger = LoggerFactory.getLogger(EndToEndTester.class);

    /**
     * Runs a single end-to-end test.
     *
     * @param outputDir the directory where files are generated to
     * @param pkgPrefix the package prefix for the test
     * @param expectedFilesDir the directory containing expected files for the test
     * @param generatedFilesRootDir the directory where the generated api/dto folders are generated
     *
     * @throws IOException if there is an IO problem
     */
    public void runTest(Path outputDir, String pkgPrefix, Path expectedFilesDir, Path generatedFilesRootDir)
            throws IOException {
        String testName = expectedFilesDir.getFileName().toString();
        Path input = expectedFilesDir.resolve("openapi.yaml");
        if (!Files.exists(input)) {
            input = expectedFilesDir.resolve("openapi.json");
        }

        Properties testOptions = readTestOptions(expectedFilesDir);

        testOptions.setProperty("generator-api-package", pkgPrefix + ".api");
        testOptions.setProperty("generator-dto-package", pkgPrefix + ".dto");
        testOptions.setProperty("generator-testing-keep-destination", "true");

        System.out.println("testDir: " + expectedFilesDir);
        System.out.println("outputDir: " + generatedFilesRootDir);

        System.out.println("PROPS:" + testOptions.toString());
        System.out.println("Output : " + generatedFilesRootDir);

        boolean skipApi = Boolean.parseBoolean(testOptions.getProperty("test-skip-api-comparison"))
                || Boolean.parseBoolean(testOptions.getProperty("generator-api-skip"));
        boolean skipDto = Boolean.parseBoolean(testOptions.getProperty("test-skip-dto-comparison"));
        boolean showParserInfo = false;
        ClientContext cc = new ClientContext(true, GeneratorLogLevel.DEFAULT, skipApi, skipDto, showParserInfo);
        try {
            new Generator().generateClient(cc, input, testOptions, outputDir);
        } catch (GeneratorBadInputException e) {
            logger.info("BAD INPUT (enable FINE for stacktrace): {}", e.getMessage());
            logger.debug("BAD INPUT", e);

            String badInputMessageContains = testOptions.getProperty("expected-bad-input-contains");
            assertThat(badInputMessageContains)
                .withFailMessage("test.properties should include expected-bad-input-contains property")
                .isNotBlank();

            assertThat(e.getMessage())
                .contains(badInputMessageContains);
            return;
        } finally {
            deleteUnwantedOutput(testOptions, generatedFilesRootDir);
        }

        logger.info("Generator returned");
        logger.info("Expected dir {}", input);
        logger.info("Actual dir   {}", generatedFilesRootDir);

        OutputDiff differ = new OutputDiff(testName);
        Path outputApiDir = generatedFilesRootDir.resolve("api");
        if (skipApi) {
            DirectoryDeleter.delete(outputApiDir);
        } else {
            logger.info("Comparing APIs");
            differ.compareDirs(outputApiDir, expectedFilesDir.resolve("api"));
        }
        Path outputDtoDir = generatedFilesRootDir.resolve("dto");
        if (skipDto) {
            DirectoryDeleter.delete(outputDtoDir);
        } else {
            logger.info("Comparing DTOs");
            differ.compareDirs(outputDtoDir, expectedFilesDir.resolve("dto"));
        }
    }

    private void deleteUnwantedOutput(Properties testOptions, Path output) throws IOException {
        String deleteFiles = testOptions.getProperty("test-delete-files");
        if (deleteFiles != null) {
            for (String p : deleteFiles.split(",", -1)) {
                Path f = output.resolve(p.trim());
                logger.info("DELETE test file {}", f);
                Files.delete(f);
            }
        }
    }

    private Properties readTestOptions(Path testDir) throws IOException {
        var props = new Properties();
        Path optionsInput = testDir.resolve("test.properties");

        if (Files.exists(optionsInput)) {
            try (Reader r = Files.newBufferedReader(optionsInput)) {
                props.load(r);
            }
        }

        return props;
    }
}
