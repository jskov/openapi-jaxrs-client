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
 * RestNodeConnectivitySummarySummary
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestNodeConnectivitySummarySummary {
  public static final String JSON_PROPERTY_ERROR_MESSAGE = "errorMessage";
  @JsonbProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @Schema(example = "Unable to connect to the node.")
  private String errorMessage;

  public static final String JSON_PROPERTY_REACHABLE = "reachable";
  @JsonbProperty(JSON_PROPERTY_REACHABLE)
  @Schema(example = "true")
  private Boolean reachable;

  public static final String JSON_PROPERTY_ROUND_TRIP_TIME = "roundTripTime";
  @JsonbProperty(JSON_PROPERTY_ROUND_TRIP_TIME)
  @Schema(example = "100")
  private Long roundTripTime;

  public RestNodeConnectivitySummarySummary errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Get errorMessage
   * @return errorMessage
   **/
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public RestNodeConnectivitySummarySummary reachable(Boolean reachable) {
    this.reachable = reachable;
    return this;
  }

  /**
   * Get reachable
   * @return reachable
   **/
  public Boolean isReachable() {
    return reachable;
  }

  public void setReachable(Boolean reachable) {
    this.reachable = reachable;
  }

  public RestNodeConnectivitySummarySummary roundTripTime(Long roundTripTime) {
    this.roundTripTime = roundTripTime;
    return this;
  }

  /**
   * Get roundTripTime
   * @return roundTripTime
   **/
  public Long getRoundTripTime() {
    return roundTripTime;
  }

  public void setRoundTripTime(Long roundTripTime) {
    this.roundTripTime = roundTripTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestNodeConnectivitySummarySummary)) {
      return false;
    }
    RestNodeConnectivitySummarySummary other = (RestNodeConnectivitySummarySummary) o;
    return Objects.equals(this.errorMessage, other.errorMessage) &&
        Objects.equals(this.reachable, other.reachable) &&
        Objects.equals(this.roundTripTime, other.roundTripTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorMessage, reachable, roundTripTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestNodeConnectivitySummarySummary {");
    sb.append("\n    errorMessage: ").append(toIndentedString(errorMessage));
    sb.append("\n    reachable: ").append(toIndentedString(reachable));
    sb.append("\n    roundTripTime: ").append(toIndentedString(roundTripTime));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
