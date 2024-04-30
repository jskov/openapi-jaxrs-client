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
 * RestTestResults
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestTestResults {
  public static final String JSON_PROPERTY_FAILED = "failed";
  @JsonbProperty(JSON_PROPERTY_FAILED)
  @Schema(example = "1")
  private Integer failed;

  public static final String JSON_PROPERTY_SKIPPED = "skipped";
  @JsonbProperty(JSON_PROPERTY_SKIPPED)
  @Schema(example = "5")
  private Integer skipped;

  public static final String JSON_PROPERTY_SUCCESSFUL = "successful";
  @JsonbProperty(JSON_PROPERTY_SUCCESSFUL)
  @Schema(example = "134")
  private Integer successful;

  public RestTestResults failed(Integer failed) {
    this.failed = failed;
    return this;
  }

  /**
   * Get failed
   * @return failed
   **/
  public Integer getFailed() {
    return failed;
  }

  public void setFailed(Integer failed) {
    this.failed = failed;
  }

  public RestTestResults skipped(Integer skipped) {
    this.skipped = skipped;
    return this;
  }

  /**
   * Get skipped
   * @return skipped
   **/
  public Integer getSkipped() {
    return skipped;
  }

  public void setSkipped(Integer skipped) {
    this.skipped = skipped;
  }

  public RestTestResults successful(Integer successful) {
    this.successful = successful;
    return this;
  }

  /**
   * Get successful
   * @return successful
   **/
  public Integer getSuccessful() {
    return successful;
  }

  public void setSuccessful(Integer successful) {
    this.successful = successful;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestTestResults)) {
      return false;
    }
    RestTestResults other = (RestTestResults) o;
    return Objects.equals(this.failed, other.failed) &&
        Objects.equals(this.skipped, other.skipped) &&
        Objects.equals(this.successful, other.successful);
  }

  @Override
  public int hashCode() {
    return Objects.hash(failed, skipped, successful);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestTestResults {");
    sb.append("\n    failed: ").append(toIndentedString(failed));
    sb.append("\n    skipped: ").append(toIndentedString(skipped));
    sb.append("\n    successful: ").append(toIndentedString(successful));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
