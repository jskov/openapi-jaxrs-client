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
 * RestPullRequestSettingsMergeConfigDefaultStrategy
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestSettingsMergeConfigDefaultStrategy {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
  @Schema(readOnly = true, example = "Always create a merge commit")
  private String description;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  @JsonbProperty(JSON_PROPERTY_ENABLED)
  @Schema(readOnly = true)
  private Boolean enabled;

  public static final String JSON_PROPERTY_FLAG = "flag";
  @JsonbProperty(JSON_PROPERTY_FLAG)
  @Schema(readOnly = true, example = "--no-ff")
  private String flag;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "no-ff")
  private String id;

  public static final String JSON_PROPERTY_LINKS = "links";
  @JsonbProperty(JSON_PROPERTY_LINKS)
  private Object links;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(readOnly = true, example = "Merge commit")
  private String name;

  public RestPullRequestSettingsMergeConfigDefaultStrategy description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RestPullRequestSettingsMergeConfigDefaultStrategy enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
   **/
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public RestPullRequestSettingsMergeConfigDefaultStrategy flag(String flag) {
    this.flag = flag;
    return this;
  }

  /**
   * Get flag
   * @return flag
   **/
  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public RestPullRequestSettingsMergeConfigDefaultStrategy id(String id) {
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

  public RestPullRequestSettingsMergeConfigDefaultStrategy links(Object links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
   **/
  public Object getLinks() {
    return links;
  }

  public void setLinks(Object links) {
    this.links = links;
  }

  public RestPullRequestSettingsMergeConfigDefaultStrategy name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestPullRequestSettingsMergeConfigDefaultStrategy)) {
      return false;
    }
    RestPullRequestSettingsMergeConfigDefaultStrategy other = (RestPullRequestSettingsMergeConfigDefaultStrategy) o;
    return Objects.equals(this.description, other.description) &&
        Objects.equals(this.enabled, other.enabled) &&
        Objects.equals(this.flag, other.flag) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.links, other.links) &&
        Objects.equals(this.name, other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, enabled, flag, id, links, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPullRequestSettingsMergeConfigDefaultStrategy {");
    sb.append("\n    description: ").append(toIndentedString(description));
    sb.append("\n    enabled: ").append(toIndentedString(enabled));
    sb.append("\n    flag: ").append(toIndentedString(flag));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    links: ").append(toIndentedString(links));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
