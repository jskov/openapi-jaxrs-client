package mada.tests.main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import static org.assertj.core.api.Assertions.assertThat;

import dk.mada.jaxrs.Main;

class CliHandlingTest {

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
     * Runs the generator via the command-line interface.
     *
     * @param args the arguments to pass
     * @return the result, exit code and output
     */
    private Result run(String... args) {
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        PrintStream testOutputStream = new PrintStream(testOutput);

        PrintStream oldOut = System.out;
        PrintStream oldErr = System.err;

        try {
            System.setOut(testOutputStream);
            System.setErr(testOutputStream);

            int exitCode = Main.mainNoExit(args);
            return new Result(exitCode, testOutput.toString());
        } finally {
            System.setOut(oldOut);
            System.setErr(oldErr);
        }
    }

    record Result(int exitCode, String output) {
    }
}
