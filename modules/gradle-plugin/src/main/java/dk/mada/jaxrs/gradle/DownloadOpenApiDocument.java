package dk.mada.jaxrs.gradle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.UncheckedIOException;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

/**
 * Task for downloading OpenApi documents.
 */
public abstract class DownloadOpenApiDocument extends DefaultTask {
    /** Sibling extensions deleted before a new document is downloaded. */
    private static final List<String> DELETE_SUFFIXES = List.of(".yaml", ".yml", ".json");

    /** {@return the URL to download the OpenAPI document from} */
    @Input
    public abstract Property<String> getDocumentUrl();

    /** {@return the file where the downloaded OpenApi document should be stored} */
    @OutputFile
    public abstract RegularFileProperty getOutputFile();

    /** Constructs new instance. */
    public DownloadOpenApiDocument() { // NOSONAR - must be public to be found by Gradle
        // The OpenApi document at the remote location can be
        // changed at any time - so it always needs to be downloaded when the task runs.
        // We assume the user knows when it is necessary to re-download the document.
        getOutputs().upToDateWhen(t -> false);

        // But only download if the URL is actually specified.
        onlyIf(t -> getDocumentUrl().isPresent());
    }

    /**
     * Task action for downloading the specified OpenApi document.
     */
    @TaskAction
    public void download() {
        Project project = getProject();

        String url = getDocumentUrl().get();
        Path toPath = getOutputFile().get().getAsFile().toPath();

        project.getLogger().info("Downloading OpenApi document {} to {}", url, toPath);

        try {
            Files.createDirectories(toPath.getParent());

            try (InputStream is = new URI(url).toURL().openStream()) {
                Files.copy(is, toPath, StandardCopyOption.REPLACE_EXISTING);
            }
            deleteSiblingDocuments(toPath);
        } catch (IOException | URISyntaxException e) {
            throw new UncheckedIOException("Failed to download file from " + url + " to " + toPath, e);
        }
    }

    /**
     * Deletes any existing sibling documents with same name but any of a number of extensions.
     *
     * This is done to gracefully handle if the user changes the document extension.
     *
     * @param keepDoc the document of which to delete extension-siblings
     */
    private void deleteSiblingDocuments(Path keepDoc) throws IOException {
        // Delete with any suffix
        Path dir = keepDoc.getParent();
        if (dir == null) {
            throw new IllegalStateException("Failed to find parent folder of " + keepDoc);
        }
        String baseName = keepDoc.getFileName().toString();
        for (String s : DELETE_SUFFIXES) {
            baseName = baseName.replace(s, "");
        }
        for (String s : DELETE_SUFFIXES) {
            Path f = dir.resolve(baseName + s);
            // Skip deletion of the actual document
            if (keepDoc.equals(f)) {
                continue;
            }
            if (Files.exists(f) && !Files.deleteIfExists(f)) {
                throw new IOException("Failed to delete target file " + f);
            }
        }
    }
}
