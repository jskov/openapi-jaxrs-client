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
 * RestAttachmentMetadata
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAttachmentMetadata {
    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "1")
    private Long id;

    public static final String JSON_PROPERTY_METADATA = "metadata";
    @JsonbProperty(JSON_PROPERTY_METADATA)
    @Schema(example = "{\\\"A\\\":\\\"B\\\"}")
    private String metadata;

    public static final String JSON_PROPERTY_URL = "url";
    @JsonbProperty(JSON_PROPERTY_URL)
    @Schema(example = "test.com/test")
    private String url;

    public RestAttachmentMetadata id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestAttachmentMetadata metadata(String metadata) {
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

    public RestAttachmentMetadata url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestAttachmentMetadata)) {
            return false;
        }
        RestAttachmentMetadata other = (RestAttachmentMetadata) o;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.metadata, other.metadata) &&
                Objects.equals(this.url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metadata, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestAttachmentMetadata {");
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    metadata: ").append(toIndentedString(metadata));
        sb.append("\n    url: ").append(toIndentedString(url));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
