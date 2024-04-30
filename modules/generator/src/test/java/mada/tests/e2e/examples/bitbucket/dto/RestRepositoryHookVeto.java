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
 * RestRepositoryHookVeto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoryHookVeto {
  public static final String JSON_PROPERTY_DETAILED_MESSAGE = "detailedMessage";
  @JsonbProperty(JSON_PROPERTY_DETAILED_MESSAGE)
  @Schema(example = "You have insufficient permissions to rebase 'refs/heads/feature-branch'.")
  private String detailedMessage;

  public static final String JSON_PROPERTY_SUMMARY_MESSAGE = "summaryMessage";
  @JsonbProperty(JSON_PROPERTY_SUMMARY_MESSAGE)
  @Schema(example = "Insufficient branch permissions")
  private String summaryMessage;

  public RestRepositoryHookVeto detailedMessage(String detailedMessage) {
    this.detailedMessage = detailedMessage;
    return this;
  }

  /**
   * Get detailedMessage
   * @return detailedMessage
   **/
  public String getDetailedMessage() {
    return detailedMessage;
  }

  public void setDetailedMessage(String detailedMessage) {
    this.detailedMessage = detailedMessage;
  }

  public RestRepositoryHookVeto summaryMessage(String summaryMessage) {
    this.summaryMessage = summaryMessage;
    return this;
  }

  /**
   * Get summaryMessage
   * @return summaryMessage
   **/
  public String getSummaryMessage() {
    return summaryMessage;
  }

  public void setSummaryMessage(String summaryMessage) {
    this.summaryMessage = summaryMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRepositoryHookVeto)) {
      return false;
    }
    RestRepositoryHookVeto other = (RestRepositoryHookVeto) o;
    return Objects.equals(this.detailedMessage, other.detailedMessage) &&
        Objects.equals(this.summaryMessage, other.summaryMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detailedMessage, summaryMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRepositoryHookVeto {");
    sb.append("\n    detailedMessage: ").append(toIndentedString(detailedMessage));
    sb.append("\n    summaryMessage: ").append(toIndentedString(summaryMessage));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
