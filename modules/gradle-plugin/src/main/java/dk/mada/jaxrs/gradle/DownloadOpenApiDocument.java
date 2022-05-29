package dk.mada.jaxrs.gradle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
			deleteExistingDocuments(toPath);

			try ( InputStream is = new URL(url).openStream() ) {
				Files.copy(is, toPath, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			throw new UncheckedIOException("Failed to download file from " + url + " to " + toPath, e);
		}
	}

	/**
	 * Deletes any existing documents with same name but any of a number of extensions.
	 *
	 * This is done to gracefully handle if the user changes the document
	 * extension.
	 *
	 * @param doc the document (and extension-siblings) to delete 
	 */
    private void deleteExistingDocuments(Path doc) throws IOException {
        // Delete with any suffix
        Path dir = doc.getParent();
        String baseName = doc.getFileName().toString();
        for (String s: DELETE_SUFFIXES) {
        	baseName = baseName.replace(s, "");
        }
        for (String s: DELETE_SUFFIXES) {
        	Path f = dir.resolve(baseName + s);
        	if (Files.exists(f) && !Files.deleteIfExists(f)) {
        		throw new IOException("Failed to delete target file " + f);
        	}
        }
    }
}
