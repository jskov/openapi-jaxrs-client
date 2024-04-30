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
import jakarta.validation.Valid;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestAutoMergeRestrictedSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAutoMergeRestrictedSettings {
  public static final String JSON_PROPERTY_ENABLED = "enabled";
  @JsonbProperty(JSON_PROPERTY_ENABLED)
  @Schema(example = "false")
  private Boolean enabled;

  /**
   * The restriction state of this scope's project.
   */
  public enum RestrictionStateEnum {
    NONE("NONE"),
    RESTRICTED_UNMODIFIABLE("RESTRICTED_UNMODIFIABLE"),
    RESTRICTED_MODIFIABLE("RESTRICTED_MODIFIABLE");

    private final String value;

    RestrictionStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class RestrictionStateEnumAdapter implements JsonbAdapter<RestrictionStateEnum, JsonString> {
      @Override
      public JsonString adaptToJson(RestrictionStateEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public RestrictionStateEnum adaptFromJson(JsonString value) throws Exception {
        for (RestrictionStateEnum b : RestrictionStateEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RestrictionStateEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_RESTRICTION_STATE = "restrictionState";
  @JsonbProperty(JSON_PROPERTY_RESTRICTION_STATE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeRestrictedSettings.RestrictionStateEnum.RestrictionStateEnumAdapter.class)
  @Schema(description = "The restriction state of this scope's project.")
  private RestrictionStateEnum restrictionState;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  @JsonbProperty(JSON_PROPERTY_SCOPE)
  @Schema(description = "The scope that these settings apply to.")
  private RestAutoMergeRestrictedSettingsScope scope;

  public RestAutoMergeRestrictedSettings enabled(Boolean enabled) {
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

  public RestAutoMergeRestrictedSettings restrictionState(RestrictionStateEnum restrictionState) {
    this.restrictionState = restrictionState;
    return this;
  }

  /**
   * The restriction state of this scope's project.
   *
   * @return restrictionState
   **/
  public RestrictionStateEnum getRestrictionState() {
    return restrictionState;
  }

  public void setRestrictionState(RestrictionStateEnum restrictionState) {
    this.restrictionState = restrictionState;
  }

  public RestAutoMergeRestrictedSettings scope(RestAutoMergeRestrictedSettingsScope scope) {
    this.scope = scope;
    return this;
  }

  /**
   * The scope that these settings apply to.
   *
   * @return scope
   **/
  @Valid
  public RestAutoMergeRestrictedSettingsScope getScope() {
    return scope;
  }

  public void setScope(RestAutoMergeRestrictedSettingsScope scope) {
    this.scope = scope;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestAutoMergeRestrictedSettings)) {
      return false;
    }
    RestAutoMergeRestrictedSettings other = (RestAutoMergeRestrictedSettings) o;
    return Objects.equals(this.enabled, other.enabled) &&
        Objects.equals(this.restrictionState, other.restrictionState) &&
        Objects.equals(this.scope, other.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, restrictionState, scope);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestAutoMergeRestrictedSettings {");
    sb.append("\n    enabled: ").append(toIndentedString(enabled));
    sb.append("\n    restrictionState: ").append(toIndentedString(restrictionState));
    sb.append("\n    scope: ").append(toIndentedString(scope));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
