/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.Objects;

/**
 * ExampleFiles
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleFiles {
    public static final String JSON_PROPERTY_FILES = "files";
    @JsonbProperty(JSON_PROPERTY_FILES)
    private ExampleJsonLastModifiedCallback files;

    public ExampleFiles files(ExampleJsonLastModifiedCallback files) {
        this.files = files;
        return this;
    }

    /**
     * Get files
     *
     * @return files
     **/
    public @Valid ExampleJsonLastModifiedCallback getFiles() {
        return files;
    }

    public void setFiles(ExampleJsonLastModifiedCallback files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExampleFiles)) {
            return false;
        }
        ExampleFiles other = (ExampleFiles) o;
        return Objects.equals(this.files, other.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(files);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExampleFiles {");
        sb.append("\n    files: ").append(toIndentedString(files));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
