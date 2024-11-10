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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestMirrorRepositorySynchronizationStatusHashes
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMirrorRepositorySynchronizationStatusHashes {
    public static final String JSON_PROPERTY_CONTENT = "content";
    @JsonbProperty(JSON_PROPERTY_CONTENT)
    @Schema(example = "677513e1f2a93ff50e7b709e3c96454c23a3fcd40046ab385c4093e30809500a")
    private String content;

    public static final String JSON_PROPERTY_METADATA = "metadata";
    @JsonbProperty(JSON_PROPERTY_METADATA)
    @Schema(example = "677513e1f2a93ff50e7b709e3c96454c23a3fcd40046ab385c4093e30809500a")
    private String metadata;

    public RestMirrorRepositorySynchronizationStatusHashes content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     **/
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public RestMirrorRepositorySynchronizationStatusHashes metadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     *
     * @return metadata
     **/
    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMirrorRepositorySynchronizationStatusHashes)) {
            return false;
        }
        RestMirrorRepositorySynchronizationStatusHashes other = (RestMirrorRepositorySynchronizationStatusHashes) o;
        return Objects.equals(this.content, other.content) &&
                Objects.equals(this.metadata, other.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMirrorRepositorySynchronizationStatusHashes {");
        sb.append("\n    content: ").append(toIndentedString(content));
        sb.append("\n    metadata: ").append(toIndentedString(metadata));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
