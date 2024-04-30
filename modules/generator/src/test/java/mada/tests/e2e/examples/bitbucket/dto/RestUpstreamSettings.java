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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RestUpstreamSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestUpstreamSettings {
  public enum ModeEnum {
    ALL_PROJECTS("ALL_PROJECTS"),
    SELECTED_PROJECTS("SELECTED_PROJECTS");

    private final String value;

    ModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class ModeEnumAdapter implements JsonbAdapter<ModeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(ModeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public ModeEnum adaptFromJson(JsonString value) throws Exception {
        for (ModeEnum b : ModeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ModeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_MODE = "mode";
  @JsonbProperty(JSON_PROPERTY_MODE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestUpstreamSettings.ModeEnum.ModeEnumAdapter.class)
  private ModeEnum mode;

  public static final String JSON_PROPERTY_PROJECT_IDS = "projectIds";
  @JsonbProperty(JSON_PROPERTY_PROJECT_IDS)
  private Set<String> projectIds;

  public RestUpstreamSettings mode(ModeEnum mode) {
    this.mode = mode;
    return this;
  }

  /**
   * Get mode
   * @return mode
   **/
  public ModeEnum getMode() {
    return mode;
  }

  public void setMode(ModeEnum mode) {
    this.mode = mode;
  }

  public RestUpstreamSettings projectIds(Set<String> projectIds) {
    this.projectIds = projectIds;
    return this;
  }

  public RestUpstreamSettings addProjectIdsItem(String projectIdsItem) {
    if (this.projectIds == null) {
      this.projectIds = new LinkedHashSet<>();
    }
    this.projectIds.add(projectIdsItem);
    return this;
  }

  /**
   * Get projectIds
   * @return projectIds
   **/
  public Set<String> getProjectIds() {
    return projectIds;
  }

  public void setProjectIds(Set<String> projectIds) {
    this.projectIds = projectIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestUpstreamSettings)) {
      return false;
    }
    RestUpstreamSettings other = (RestUpstreamSettings) o;
    return Objects.equals(this.mode, other.mode) &&
        Objects.equals(this.projectIds, other.projectIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mode, projectIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestUpstreamSettings {");
    sb.append("\n    mode: ").append(toIndentedString(mode));
    sb.append("\n    projectIds: ").append(toIndentedString(projectIds));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
