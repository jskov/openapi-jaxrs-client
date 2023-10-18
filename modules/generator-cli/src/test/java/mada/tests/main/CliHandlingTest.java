package mada.tests.main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import dk.mada.jaxrs.generator.cli.Main;

import static org.assertj.core.api.Assertions.assertThat;

class CliHandlingTest {
    /** Output buffer used for all tests. */
    static final ByteArrayOutputStream TEST_OUTPUT_BUFFER = new ByteArrayOutputStream();

    /** Test output dir. */
    @TempDir
    private Path outputDir;

    /**
     * If no properties file is specified, assume location based
     * on input file. Required if no API+DTO packages provided.
     */
    @Test
    void willAssumePropertiesFromInput() {
        String dir = outputDir.resolve("new").toAbsolutePath().toString();
        Result res = run(
                "--input", "src/test/java/mada/tests/main/openapi-no-props.yaml",
                "--output-directory", dir);

        assertThat(res.exitCode)
            .isEqualTo(2);
        assertThat(res.output)
            .contains("openapi-no-props.properties' is not a regular file");
    }

    /**
     * If API+DTO packages provided as arguments, does not need properties.
     */
    @Test
    void canUseApiAndDtoPackageArguments() {
        String dir = outputDir.resolve("new").toAbsolutePath().toString();
        Result res = run(
                "--input", "src/test/java/mada/tests/main/openapi-no-props.yaml",
                "--output-directory", dir,
                "--api-package", "dk.mada.api",
                "--dto-package", "dk.mada.dto"
                );

        assertThat(res.exitCode)
            .isZero();
    }

    /**
     * If API+DTO packages provided as arguments, does not need properties.
     */
    @Test
    void canUseApiAndDtoPackageProperties() {
        String dir = outputDir.resolve("new").toAbsolutePath().toString();
        Result res = run(
                "--input", "src/test/java/mada/tests/main/openapi.yaml",
                "--output-directory", dir);

        assertThat(res.exitCode)
            .isZero();
    }

    /**
     * Exercise info code using --debug flag.
     */
    @Test
    void canPrintParserInfo() {
        String dir = outputDir.resolve("new").toAbsolutePath().toString();
        Result res = run(
                "--show-parser-info",
                "--input", "src/test/java/mada/tests/main/openapi.yaml",
                "--output-directory", dir);

        assertThat(res.exitCode)
            .isZero();
        // have to assume the output is written. cannot make it work reliably with all tests
    }

    /**
     * If return type is missing, should fail and recommend use of parser-fixup-void-200-to-204 property.
     */
    @Test
    void shouldRecommendVoidFix() {
        String dir = outputDir.resolve("new").toAbsolutePath().toString();
        Result res = run(
                "--show-parser-info",
                "--input", "src/test/java/mada/tests/main/openapi-no-return-type.yaml",
                "--output-directory", dir);
        
        assertThat(res.exitCode)
            .isEqualTo(1);
        assertThat(res.output)
            .contains("does not provide a return type")
            .contains("parser-fixup-void-200-to-204");
    }

    /**
     * Runs the generator via the command-line interface.
     *
     * Uses a static byte buffer to collect output. This is necessary
     * since JUL will keep writing to the same stream.
     *
     * @param args the arguments to pass
     * @return the result, exit code and output
     */
    private Result run(String... args) {
        TEST_OUTPUT_BUFFER.reset();
        PrintStream testOutputStream = new PrintStream(TEST_OUTPUT_BUFFER, true, StandardCharsets.UTF_8);

        PrintStream oldOut = System.out;
        PrintStream oldErr = System.err;

        try {
            System.setOut(testOutputStream);
            System.setErr(testOutputStream);

            int exitCode = Main.mainNoExit(args);
            return new Result(exitCode, TEST_OUTPUT_BUFFER.toString(StandardCharsets.UTF_8));
        } finally {
            System.setOut(oldOut);
            System.setErr(oldErr);
        }
    }

    record Result(int exitCode, String output) {
    }
}
