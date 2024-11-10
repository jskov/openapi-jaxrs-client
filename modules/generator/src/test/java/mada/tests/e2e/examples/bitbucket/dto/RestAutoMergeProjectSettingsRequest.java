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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestAutoMergeProjectSettingsRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAutoMergeProjectSettingsRequest {
    public static final String JSON_PROPERTY_ENABLED = "enabled";
    @JsonbProperty(JSON_PROPERTY_ENABLED)
    @Schema(example = "false")
    private Boolean enabled;

    public enum RestrictionActionEnum {
      CREATE("CREATE"),
      DELETE("DELETE"),
      NONE("NONE");

      private final String value;

      RestrictionActionEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class RestrictionActionEnumAdapter implements JsonbAdapter<RestrictionActionEnum, JsonString> {
          @Override
          public JsonString adaptToJson(RestrictionActionEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public RestrictionActionEnum adaptFromJson(JsonString value) throws Exception {
            for (RestrictionActionEnum b : RestrictionActionEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RestrictionActionEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_RESTRICTION_ACTION = "restrictionAction";
    @JsonbProperty(JSON_PROPERTY_RESTRICTION_ACTION)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeProjectSettingsRequest.RestrictionActionEnum.RestrictionActionEnumAdapter.class)
    @Schema(example = "CREATE")
    private RestrictionActionEnum restrictionAction;

    public RestAutoMergeProjectSettingsRequest enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     **/
    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RestAutoMergeProjectSettingsRequest restrictionAction(RestrictionActionEnum restrictionAction) {
        this.restrictionAction = restrictionAction;
        return this;
    }

    /**
     * Get restrictionAction
     *
     * @return restrictionAction
     **/
    public RestrictionActionEnum getRestrictionAction() {
        return restrictionAction;
    }

    public void setRestrictionAction(RestrictionActionEnum restrictionAction) {
        this.restrictionAction = restrictionAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestAutoMergeProjectSettingsRequest)) {
            return false;
        }
        RestAutoMergeProjectSettingsRequest other = (RestAutoMergeProjectSettingsRequest) o;
        return Objects.equals(this.enabled, other.enabled) &&
                Objects.equals(this.restrictionAction, other.restrictionAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, restrictionAction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestAutoMergeProjectSettingsRequest {");
        sb.append("\n    enabled: ").append(toIndentedString(enabled));
        sb.append("\n    restrictionAction: ").append(toIndentedString(restrictionAction));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
