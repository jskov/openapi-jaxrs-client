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
 * RestImportRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestImportRequest {
  public static final String JSON_PROPERTY_ARCHIVE_PATH = "archivePath";
  @JsonbProperty(JSON_PROPERTY_ARCHIVE_PATH)
  @Schema(example = "Bitbucket_export_1.tar")
  private String archivePath;

  public RestImportRequest archivePath(String archivePath) {
    this.archivePath = archivePath;
    return this;
  }

  /**
   * Get archivePath
   * @return archivePath
   **/
  public String getArchivePath() {
    return archivePath;
  }

  public void setArchivePath(String archivePath) {
    this.archivePath = archivePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestImportRequest)) {
      return false;
    }
    RestImportRequest other = (RestImportRequest) o;
    return Objects.equals(this.archivePath, other.archivePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(archivePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestImportRequest {");
    sb.append("\n    archivePath: ").append(toIndentedString(archivePath));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
