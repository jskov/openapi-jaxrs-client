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
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestBranchCreateRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBranchCreateRequest {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(description = "Name of the branch to be created")
  private String name;

  public static final String JSON_PROPERTY_START_POINT = "startPoint";
  @JsonbProperty(JSON_PROPERTY_START_POINT)
  @Schema(description = "Commit ID from which the branch is created")
  private String startPoint;

  public RestBranchCreateRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the branch to be created.
   *
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RestBranchCreateRequest startPoint(String startPoint) {
    this.startPoint = startPoint;
    return this;
  }

  /**
   * Commit ID from which the branch is created.
   *
   * @return startPoint
   **/
  @Size(max = 40)
  public String getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(String startPoint) {
    this.startPoint = startPoint;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestBranchCreateRequest)) {
      return false;
    }
    RestBranchCreateRequest other = (RestBranchCreateRequest) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.startPoint, other.startPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, startPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestBranchCreateRequest {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    startPoint: ").append(toIndentedString(startPoint));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
