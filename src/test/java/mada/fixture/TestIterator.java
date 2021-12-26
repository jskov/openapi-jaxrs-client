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

@RunWith(JUnitPlatform.class)
class TestIterator {
	private static final Logger logger = LoggerFactory.getLogger(TestIterator.class);
	@TestFactory
	List<DynamicTest> makeTests() throws IOException {
		Path rootDir = Paths.get("src/test/java/mada/tests/e2e").toAbsolutePath();
		Path outputDir = Paths.get("build/e2e");
		logger.info("Scanning for tests in {}", rootDir);
		
		String testDir = System.getProperty("testDir", "");
		
		// Replace with partial test name (or empty to run all tests)
		String testNameContains = "";
		
		Predicate<? super Path> filterByProperty = p -> testDir.isEmpty() || p.toString().contains(testDir);
		Predicate<? super Path> filterByName = p -> p.toString().contains(testNameContains) || !System.getProperty("user.name").contains("jskov");
		
		Predicate<? super Path> testFilter = testDir.isEmpty() ? filterByName : filterByProperty;
		
		
		return Files.walk(rootDir)
			.filter(p -> {
				String filename = p.getFileName().toString();
				return "openapi.yaml".equals(filename);
			})
			.filter(testFilter)
			.map(testInput -> {
				Path testRootDir = testInput.getParent();
				Path testPath = rootDir.relativize(testRootDir);
				Path testOutputDir = outputDir.resolve(testPath);
				
				String name = testPath.toString().replace("/", ".");
				return DynamicTest.dynamicTest(name, () -> new RunInputTest().runTest(testRootDir, testOutputDir));
			})
			.sorted((a, b) -> a.getDisplayName().compareTo(b.getDisplayName()))
			.collect(Collectors.toList());
	}
}
