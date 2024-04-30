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
 * RestProperties
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestProperties {
  public static final String JSON_PROPERTY_CONTENT_HASH = "contentHash";
  @JsonbProperty(JSON_PROPERTY_CONTENT_HASH)
  @Schema(example = "457389a0b871fb61012a7351d09aefc0cf1c57c306449d4b5df4d2f381df8433")
  private String contentHash;

  public static final String JSON_PROPERTY_DEFAULT_BRANCH_ID = "defaultBranchId";
  @JsonbProperty(JSON_PROPERTY_DEFAULT_BRANCH_ID)
  @Schema(example = "refs/heads/master")
  private String defaultBranchId;

  public static final String JSON_PROPERTY_METADATA_HASH = "metadataHash";
  @JsonbProperty(JSON_PROPERTY_METADATA_HASH)
  @Schema(example = "11e5cd17e8d74d84a11f2c8a6bbc6ae0a2b69059e54030f49214c94d980364c1")
  private String metadataHash;

  public RestProperties contentHash(String contentHash) {
    this.contentHash = contentHash;
    return this;
  }

  /**
   * Get contentHash
   * @return contentHash
   **/
  public String getContentHash() {
    return contentHash;
  }

  public void setContentHash(String contentHash) {
    this.contentHash = contentHash;
  }

  public RestProperties defaultBranchId(String defaultBranchId) {
    this.defaultBranchId = defaultBranchId;
    return this;
  }

  /**
   * Get defaultBranchId
   * @return defaultBranchId
   **/
  public String getDefaultBranchId() {
    return defaultBranchId;
  }

  public void setDefaultBranchId(String defaultBranchId) {
    this.defaultBranchId = defaultBranchId;
  }

  public RestProperties metadataHash(String metadataHash) {
    this.metadataHash = metadataHash;
    return this;
  }

  /**
   * Get metadataHash
   * @return metadataHash
   **/
  public String getMetadataHash() {
    return metadataHash;
  }

  public void setMetadataHash(String metadataHash) {
    this.metadataHash = metadataHash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestProperties)) {
      return false;
    }
    RestProperties other = (RestProperties) o;
    return Objects.equals(this.contentHash, other.contentHash) &&
        Objects.equals(this.defaultBranchId, other.defaultBranchId) &&
        Objects.equals(this.metadataHash, other.metadataHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentHash, defaultBranchId, metadataHash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestProperties {");
    sb.append("\n    contentHash: ").append(toIndentedString(contentHash));
    sb.append("\n    defaultBranchId: ").append(toIndentedString(defaultBranchId));
    sb.append("\n    metadataHash: ").append(toIndentedString(metadataHash));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
