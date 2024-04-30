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
 * RestPullRequestRebaseResult
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestRebaseResult {
  public static final String JSON_PROPERTY_REF_CHANGE = "refChange";
  @JsonbProperty(JSON_PROPERTY_REF_CHANGE)
  private RestPullRequestRebaseResultRefChange refChange;

  public RestPullRequestRebaseResult refChange(RestPullRequestRebaseResultRefChange refChange) {
    this.refChange = refChange;
    return this;
  }

  /**
   * Get refChange
   * @return refChange
   **/
  @Valid
  public RestPullRequestRebaseResultRefChange getRefChange() {
    return refChange;
  }

  public void setRefChange(RestPullRequestRebaseResultRefChange refChange) {
    this.refChange = refChange;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestPullRequestRebaseResult)) {
      return false;
    }
    RestPullRequestRebaseResult other = (RestPullRequestRebaseResult) o;
    return Objects.equals(this.refChange, other.refChange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refChange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPullRequestRebaseResult {");
    sb.append("\n    refChange: ").append(toIndentedString(refChange));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
