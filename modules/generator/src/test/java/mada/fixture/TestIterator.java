package mada.fixture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.suite.api.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.mpclient.LoggerConfig;
import dk.mada.jaxrs.utils.DirectoryDeleter;

@Suite
class TestIterator {
    private static final Logger logger = LoggerFactory.getLogger(TestIterator.class);

    /** Directory where all test output is placed. */
    private static final Path OUTPUT_DIR = Paths.get("build/e2e");

    @BeforeAll
    static void logging() {
        LoggerConfig.loadConfig("/logging-test.properties");
    }

    /**
     * Make output dir at exit, so it is present, even if no test executes.
     * Otherwise Eclipse gets sad...
     */
    @AfterAll
    static void createOutputDir() throws IOException {
        Files.createDirectories(OUTPUT_DIR);
    }

    @TestFactory
    List<DynamicTest> makeTests() throws IOException {
        Path testSrcDir = Paths.get("src/test/java").toAbsolutePath();
        Path rootDir = testSrcDir.resolve("mada/tests/e2e");
        logger.info("Scanning for tests in {}", rootDir);

        String testDir = System.getProperty("testDir", "");

        // Replace with partial test name (or empty to run all tests)
        // Handy when working on a single test
//        String testNameContains = "opts/generator/validation/body";
//        String testNameContains = "unknown_enum";
        String testNameContains = "dto/oneof/";
//        String testNameContains = "e2e/specs/v3_0";
//        String testNameContains = "e2e/specs/v3_1/all";
//        String testNameContains = "e2e/specs/v3_1/anyof";

        boolean runAllTests = Boolean.parseBoolean(System.getProperty("run_all_tests"));
        Predicate<? super Path> filterByProperty = p -> testDir.isEmpty() || p.toString().contains(testDir);
        Predicate<? super Path> filterByName = p ->
            runAllTests || p.toString().contains(testNameContains);

        Predicate<? super Path> testFilter = testDir.isEmpty() ? filterByName : filterByProperty;

        DirectoryDeleter.delete(OUTPUT_DIR);
        Files.createDirectories(OUTPUT_DIR);

        try (Stream<Path> files = Files.walk(rootDir)) {
            return files
                .filter(p -> {
                    String filename = p.getFileName().toString();
                    return "openapi.yaml".equals(filename)
                            || "openapi.json".equals(filename);
                })
                .filter(p -> !runAllTests || !p.toString().contains("/manual/"))
                .filter(testFilter)
                .map(testInput -> {
                    Path testRootDir = testInput.getParent();
                    Path testPath = testSrcDir.relativize(testRootDir);
                    Path testOutputDir = OUTPUT_DIR.resolve(testPath);

                    String name = testPath.toString().replace("/", ".");

                    String pkgPrefix = testSrcDir.relativize(testRootDir).toString().replace("/", ".");

                    return DynamicTest.dynamicTest(name, () ->
                        new EndToEndTester().runTest(OUTPUT_DIR, pkgPrefix, testRootDir, testOutputDir));
                })
                .sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName()))
                .toList();
        }
    }
}
