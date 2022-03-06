package mada.tests.path;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dk.mada.jaxrs.generator.CommonPathFinder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

/**
 * Test of common path finder.
 */
class CommonPathTest {
    /** Subject under test. */
    private CommonPathFinder sut = new CommonPathFinder();

    @ParameterizedTest
    @CsvSource(textBlock = """
            'foo, bar',                          /

            'path, path/simple',                 path

            'path/foo, path/bar',                path
            'path/foo, path/foo-bar',            path
            'x/path/foo, x/path/foo-bar',        x/path

            'common, common',                    common
    """)
    void runTests(String paths, String expected) {
        List<String> input = toList(paths);
        assertThat(sut.findCommonPath(input))
            .isEqualTo(expected);
    }

    private List<String> toList(String paths) {
        List<String> input = Stream.of(paths.split(","))
                .map(String::trim)
                .toList();
        return input;
    }
}
