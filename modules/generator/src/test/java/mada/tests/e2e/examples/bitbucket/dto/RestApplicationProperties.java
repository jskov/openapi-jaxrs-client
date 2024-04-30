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
 * RestApplicationProperties
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestApplicationProperties {
  public static final String JSON_PROPERTY_BUILD_DATE = "buildDate";
  @JsonbProperty(JSON_PROPERTY_BUILD_DATE)
  @Schema(example = "1358897885952000")
  private String buildDate;

  public static final String JSON_PROPERTY_BUILD_NUMBER = "buildNumber";
  @JsonbProperty(JSON_PROPERTY_BUILD_NUMBER)
  @Schema(example = "20220123103656677")
  private String buildNumber;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
  @Schema(example = "Example.com Bitbucket")
  private String displayName;

  public static final String JSON_PROPERTY_VERSION = "version";
  @JsonbProperty(JSON_PROPERTY_VERSION)
  @Schema(example = "2.1.0")
  private String version;

  public RestApplicationProperties buildDate(String buildDate) {
    this.buildDate = buildDate;
    return this;
  }

  /**
   * Get buildDate
   * @return buildDate
   **/
  public String getBuildDate() {
    return buildDate;
  }

  public void setBuildDate(String buildDate) {
    this.buildDate = buildDate;
  }

  public RestApplicationProperties buildNumber(String buildNumber) {
    this.buildNumber = buildNumber;
    return this;
  }

  /**
   * Get buildNumber
   * @return buildNumber
   **/
  public String getBuildNumber() {
    return buildNumber;
  }

  public void setBuildNumber(String buildNumber) {
    this.buildNumber = buildNumber;
  }

  public RestApplicationProperties displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   **/
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public RestApplicationProperties version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   **/
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestApplicationProperties)) {
      return false;
    }
    RestApplicationProperties other = (RestApplicationProperties) o;
    return Objects.equals(this.buildDate, other.buildDate) &&
        Objects.equals(this.buildNumber, other.buildNumber) &&
        Objects.equals(this.displayName, other.displayName) &&
        Objects.equals(this.version, other.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buildDate, buildNumber, displayName, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestApplicationProperties {");
    sb.append("\n    buildDate: ").append(toIndentedString(buildDate));
    sb.append("\n    buildNumber: ").append(toIndentedString(buildNumber));
    sb.append("\n    displayName: ").append(toIndentedString(displayName));
    sb.append("\n    version: ").append(toIndentedString(version));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
