package mada.fixture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.logging.LoggerConfig;

// Using JunitPlatform is deprecated, but @Suite and @TestFactory does
// not appear to work in Eclipse.
@SuppressWarnings("deprecation")
@RunWith(JUnitPlatform.class)
class TestIterator {
	private static final Logger logger = LoggerFactory.getLogger(TestIterator.class);
	
	@TestFactory
	List<DynamicTest> makeTests() throws IOException {
		LoggerConfig.loadConfig("/logging-test.properties");
		
		Path testSrcDir = Paths.get("src/test/java").toAbsolutePath();
		Path rootDir = testSrcDir.resolve("mada/tests/e2e");
		Path outputDir = Paths.get("build/e2e");
		logger.info("Scanning for tests in {}", rootDir);
		
		String testDir = System.getProperty("testDir", "");
		
		// Replace with partial test name (or empty to run all tests)
		// Handy when working on a single test
		String testNameContains = "body";
		
		Predicate<? super Path> filterByProperty = p -> testDir.isEmpty() || p.toString().contains(testDir);
		Predicate<? super Path> filterByName = p -> p.toString().contains(testNameContains) || Boolean.parseBoolean(System.getProperty("run_all_tests"));
		
		Predicate<? super Path> testFilter = testDir.isEmpty() ? filterByName : filterByProperty;
		
		
		return Files.walk(rootDir)
			.filter(p -> {
				String filename = p.getFileName().toString();
				return "openapi.yaml".equals(filename);
			})
			.filter(testFilter)
			.map(testInput -> {
				Path testRootDir = testInput.getParent();
				Path testPath = testSrcDir.relativize(testRootDir);
				Path testOutputDir = outputDir.resolve(testPath);
				
				String name = testPath.toString().replace("/", ".");
				
				String pkgPrefix = testSrcDir.relativize(testRootDir).toString().replace("/", ".");
				
				return DynamicTest.dynamicTest(name, () -> new RunInputTest().runTest(pkgPrefix, testRootDir, testOutputDir));
			})
			.sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName()))
			.collect(Collectors.toList());
	}
}
