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
 * RestAnalyticsSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAnalyticsSettings {
  public static final String JSON_PROPERTY_CAN_COLLECT_ANALYTICS = "canCollectAnalytics";
  @JsonbProperty(JSON_PROPERTY_CAN_COLLECT_ANALYTICS)
  private Boolean canCollectAnalytics;

  public static final String JSON_PROPERTY_SERVER_TIME = "serverTime";
  @JsonbProperty(JSON_PROPERTY_SERVER_TIME)
  @Schema(example = "1640390400000")
  private Long serverTime;

  public static final String JSON_PROPERTY_SUPPORT_ENTITLEMENT_NUMBER = "supportEntitlementNumber";
  @JsonbProperty(JSON_PROPERTY_SUPPORT_ENTITLEMENT_NUMBER)
  @Schema(example = "SEN-500")
  private String supportEntitlementNumber;

  public RestAnalyticsSettings canCollectAnalytics(Boolean canCollectAnalytics) {
    this.canCollectAnalytics = canCollectAnalytics;
    return this;
  }

  /**
   * Get canCollectAnalytics
   * @return canCollectAnalytics
   **/
  public Boolean isCanCollectAnalytics() {
    return canCollectAnalytics;
  }

  public void setCanCollectAnalytics(Boolean canCollectAnalytics) {
    this.canCollectAnalytics = canCollectAnalytics;
  }

  public RestAnalyticsSettings serverTime(Long serverTime) {
    this.serverTime = serverTime;
    return this;
  }

  /**
   * Get serverTime
   * @return serverTime
   **/
  public Long getServerTime() {
    return serverTime;
  }

  public void setServerTime(Long serverTime) {
    this.serverTime = serverTime;
  }

  public RestAnalyticsSettings supportEntitlementNumber(String supportEntitlementNumber) {
    this.supportEntitlementNumber = supportEntitlementNumber;
    return this;
  }

  /**
   * Get supportEntitlementNumber
   * @return supportEntitlementNumber
   **/
  public String getSupportEntitlementNumber() {
    return supportEntitlementNumber;
  }

  public void setSupportEntitlementNumber(String supportEntitlementNumber) {
    this.supportEntitlementNumber = supportEntitlementNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestAnalyticsSettings)) {
      return false;
    }
    RestAnalyticsSettings other = (RestAnalyticsSettings) o;
    return Objects.equals(this.canCollectAnalytics, other.canCollectAnalytics) &&
        Objects.equals(this.serverTime, other.serverTime) &&
        Objects.equals(this.supportEntitlementNumber, other.supportEntitlementNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(canCollectAnalytics, serverTime, supportEntitlementNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestAnalyticsSettings {");
    sb.append("\n    canCollectAnalytics: ").append(toIndentedString(canCollectAnalytics));
    sb.append("\n    serverTime: ").append(toIndentedString(serverTime));
    sb.append("\n    supportEntitlementNumber: ").append(toIndentedString(supportEntitlementNumber));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
