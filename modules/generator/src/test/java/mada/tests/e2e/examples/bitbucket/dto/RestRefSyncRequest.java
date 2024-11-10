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
 * RestRefSyncRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRefSyncRequest {
    public enum ActionEnum {
      DISCARD("DISCARD"),
      MERGE("MERGE"),
      REBASE("REBASE");

      private final String value;

      ActionEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class ActionEnumAdapter implements JsonbAdapter<ActionEnum, JsonString> {
          @Override
          public JsonString adaptToJson(ActionEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public ActionEnum adaptFromJson(JsonString value) throws Exception {
            for (ActionEnum b : ActionEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ActionEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_ACTION = "action";
    @JsonbProperty(JSON_PROPERTY_ACTION)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestRefSyncRequest.ActionEnum.ActionEnumAdapter.class)
    @Schema(example = "MERGE")
    private ActionEnum action;

    public static final String JSON_PROPERTY_CONTEXT = "context";
    @JsonbProperty(JSON_PROPERTY_CONTEXT)
    private Context context;

    public static final String JSON_PROPERTY_REF_ID = "refId";
    @JsonbProperty(JSON_PROPERTY_REF_ID)
    @Schema(example = "refs/heads/master")
    private String refId;

    public RestRefSyncRequest action(ActionEnum action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     *
     * @return action
     **/
    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public RestRefSyncRequest context(Context context) {
        this.context = context;
        return this;
    }

    /**
     * Get context
     *
     * @return context
     **/
    public @Valid Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RestRefSyncRequest refId(String refId) {
        this.refId = refId;
        return this;
    }

    /**
     * Get refId
     *
     * @return refId
     **/
    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRefSyncRequest)) {
            return false;
        }
        RestRefSyncRequest other = (RestRefSyncRequest) o;
        return Objects.equals(this.action, other.action) &&
                Objects.equals(this.context, other.context) &&
                Objects.equals(this.refId, other.refId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, context, refId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRefSyncRequest {");
        sb.append("\n    action: ").append(toIndentedString(action));
        sb.append("\n    context: ").append(toIndentedString(context));
        sb.append("\n    refId: ").append(toIndentedString(refId));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
