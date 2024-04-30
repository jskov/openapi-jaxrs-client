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
 * RestEnhancedEntityLink
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestEnhancedEntityLink {
  public static final String JSON_PROPERTY_APPLICATION_LINK_ID = "applicationLinkId";
  @JsonbProperty(JSON_PROPERTY_APPLICATION_LINK_ID)
  @Schema(example = "a1b54cs4wsd45")
  private String applicationLinkId;

  public static final String JSON_PROPERTY_DISPLAY_URL = "displayUrl";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_URL)
  @Schema(example = "example.com/jira")
  private String displayUrl;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";
  @JsonbProperty(JSON_PROPERTY_PROJECT_ID)
  @Schema(example = "10000")
  private Long projectId;

  public static final String JSON_PROPERTY_PROJECT_KEY = "projectKey";
  @JsonbProperty(JSON_PROPERTY_PROJECT_KEY)
  @Schema(example = "MPROJ")
  private String projectKey;

  public static final String JSON_PROPERTY_PROJECT_NAME = "projectName";
  @JsonbProperty(JSON_PROPERTY_PROJECT_NAME)
  @Schema(example = "My Project")
  private String projectName;

  public RestEnhancedEntityLink applicationLinkId(String applicationLinkId) {
    this.applicationLinkId = applicationLinkId;
    return this;
  }

  /**
   * Get applicationLinkId
   * @return applicationLinkId
   **/
  public String getApplicationLinkId() {
    return applicationLinkId;
  }

  public void setApplicationLinkId(String applicationLinkId) {
    this.applicationLinkId = applicationLinkId;
  }

  public RestEnhancedEntityLink displayUrl(String displayUrl) {
    this.displayUrl = displayUrl;
    return this;
  }

  /**
   * Get displayUrl
   * @return displayUrl
   **/
  public String getDisplayUrl() {
    return displayUrl;
  }

  public void setDisplayUrl(String displayUrl) {
    this.displayUrl = displayUrl;
  }

  public RestEnhancedEntityLink projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * Get projectId
   * @return projectId
   **/
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public RestEnhancedEntityLink projectKey(String projectKey) {
    this.projectKey = projectKey;
    return this;
  }

  /**
   * Get projectKey
   * @return projectKey
   **/
  public String getProjectKey() {
    return projectKey;
  }

  public void setProjectKey(String projectKey) {
    this.projectKey = projectKey;
  }

  public RestEnhancedEntityLink projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * Get projectName
   * @return projectName
   **/
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestEnhancedEntityLink)) {
      return false;
    }
    RestEnhancedEntityLink other = (RestEnhancedEntityLink) o;
    return Objects.equals(this.applicationLinkId, other.applicationLinkId) &&
        Objects.equals(this.displayUrl, other.displayUrl) &&
        Objects.equals(this.projectId, other.projectId) &&
        Objects.equals(this.projectKey, other.projectKey) &&
        Objects.equals(this.projectName, other.projectName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationLinkId, displayUrl, projectId, projectKey, projectName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestEnhancedEntityLink {");
    sb.append("\n    applicationLinkId: ").append(toIndentedString(applicationLinkId));
    sb.append("\n    displayUrl: ").append(toIndentedString(displayUrl));
    sb.append("\n    projectId: ").append(toIndentedString(projectId));
    sb.append("\n    projectKey: ").append(toIndentedString(projectKey));
    sb.append("\n    projectName: ").append(toIndentedString(projectName));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
