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
 * RestMinimalCommit
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMinimalCommit {
  public static final String JSON_PROPERTY_DISPLAY_ID = "displayId";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_ID)
  @Schema(example = "abcdef0")
  private String displayId;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "abcdef0123abcdef4567abcdef8987abcdef6543")
  private String id;

  public RestMinimalCommit displayId(String displayId) {
    this.displayId = displayId;
    return this;
  }

  /**
   * Get displayId
   * @return displayId
   **/
  public String getDisplayId() {
    return displayId;
  }

  public void setDisplayId(String displayId) {
    this.displayId = displayId;
  }

  public RestMinimalCommit id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestMinimalCommit)) {
      return false;
    }
    RestMinimalCommit other = (RestMinimalCommit) o;
    return Objects.equals(this.displayId, other.displayId) &&
        Objects.equals(this.id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayId, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestMinimalCommit {");
    sb.append("\n    displayId: ").append(toIndentedString(displayId));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
