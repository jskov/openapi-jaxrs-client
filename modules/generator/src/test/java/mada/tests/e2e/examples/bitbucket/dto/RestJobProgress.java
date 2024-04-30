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
 * RestJobProgress
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestJobProgress {
  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  @Schema(example = "Working on it...")
  private String message;

  public static final String JSON_PROPERTY_PERCENTAGE = "percentage";
  @JsonbProperty(JSON_PROPERTY_PERCENTAGE)
  @Schema(example = "42")
  private Integer percentage;

  public RestJobProgress message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public RestJobProgress percentage(Integer percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Get percentage
   * @return percentage
   **/
  public Integer getPercentage() {
    return percentage;
  }

  public void setPercentage(Integer percentage) {
    this.percentage = percentage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestJobProgress)) {
      return false;
    }
    RestJobProgress other = (RestJobProgress) o;
    return Objects.equals(this.message, other.message) &&
        Objects.equals(this.percentage, other.percentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, percentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestJobProgress {");
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n    percentage: ").append(toIndentedString(percentage));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
