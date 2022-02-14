package mada.fixture;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.presentation.StandardRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputDiff {
    private static final Logger logger = LoggerFactory.getLogger(OutputDiff.class);
    protected static final Set<String> IGNORED_FILENAMES = new HashSet<>();

    private final String testName;

    protected boolean skipDirs = false;
    protected Set<String> onlyFilePaths = new HashSet<>();
    protected String diffOpts = "-u";

    protected String runFromDir = ".";

    public OutputDiff(String testName) {
        this.testName = testName;
    }

    public void compareDirs(Path generated, Path expected) {
        String actualTree = makeDirTree(generated);
        String expectedTree = makeDirTree(expected);

        if (!skipDirs) {
            assertThat(actualTree)
                .isEqualTo(expectedTree);
        }

        getTreeFiles(expected).stream()
            .map(expected::relativize)
            .forEach(f -> compareExpectedAndActualFile(testName, expected, generated, f));
    }

    private void compareExpectedAndActualFile(String testName, Path expectedDir, Path actualDir, Path a) {
        logger.debug("Look at {} {} {}", expectedDir, actualDir, a);

        if (!onlyFilePaths.isEmpty() && !onlyFilePaths.contains(a.toString())) {
            logger.debug(" - skipped");
            return;
        }

        Path expected = expectedDir.resolve(a);
        Path actual = actualDir.resolve(a);

        String expectedStr = readFileToString(expected).replace("\r\n", "\n");
        String actualStr = readFileToString(actual).replace("\r\n", "\n");

        StandardRepresentation representation = new StandardRepresentation() {
            private boolean diffPrinted;

            @Override
            protected String toStringOf(String str) {
                if (!diffPrinted) {
                    runExternalDiff(expected, actual);
                    diffPrinted = true;
                }
                return str;
            }
        };

        assertThat(actualStr)
            .as("Test %s file %s", testName, a.toString().replace('\\', '/'))
            .withRepresentation(representation)
            .isEqualTo(expectedStr);
    }

    private String readFileToString(Path expected) {
        try {
            return new String(Files.readAllBytes(expected), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(")Failed to read " + expected, e);
        }
    }

    private void runExternalDiff(Path exp, Path actual) {
        try {
            String expAbs = exp.toAbsolutePath().toString();
            String actualAbs = actual.toAbsolutePath().toString();

            Process p = new ProcessBuilder()
                    .command("diff", diffOpts, expAbs, actualAbs)
                    .redirectErrorStream(true)
                    .start();

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ProcessHelper.waitForProcessOutput(p, output);

            System.out.println("Files differ");
            System.out.println("Expected " + expAbs);
            System.out.println("Expected " + actualAbs);
            System.out.println("---");
            System.out.println(output.toString());
        } catch (IOException e) {
            throw new UncheckedIOException("Failed external diff", e);
        }
    }

    private String makeDirTree(Path dir) {
        if (!Files.isDirectory(dir)) { // NOSONAR
            return "";
        }
        int trimPrefix = dir.toString().length() + 1;

        return getTreeFiles(dir).stream()
                .map(Path::toString)
                .map(p -> p.replace('\\', '/').substring(trimPrefix))
                .collect(joining("\n"));
    }

    private List<Path> getTreeFiles(Path dir) {
        if (!Files.exists(dir)) {
            throw new IllegalStateException("Did not find expected dir " + dir);
        }

        List<Path> treeFiles = new ArrayList<>();
        try {
            Files.walkFileTree(dir, new FileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (skipFile(dir)) {
                        return FileVisitResult.SKIP_SUBTREE;
                    } else {
                        return FileVisitResult.CONTINUE;
                    }
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!skipFile(file)) {
                        treeFiles.add(file);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    throw new IllegalStateException("Failed to visit " + file, exc);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        Collections.sort(treeFiles);
        return treeFiles;
    }

    private boolean skipFile(Path p) {
        return IGNORED_FILENAMES.contains(p.getFileName().toString());
    }
}
