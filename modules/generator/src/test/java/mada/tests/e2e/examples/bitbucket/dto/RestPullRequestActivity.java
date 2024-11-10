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
 * RestPullRequestActivity
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestActivity {
    public enum ActionEnum {
      APPROVED("APPROVED"),
      AUTO_MERGE_CANCELLED("AUTO_MERGE_CANCELLED"),
      AUTO_MERGE_REQUESTED("AUTO_MERGE_REQUESTED"),
      COMMENTED("COMMENTED"),
      DECLINED("DECLINED"),
      DELETED("DELETED"),
      MERGED("MERGED"),
      OPENED("OPENED"),
      REOPENED("REOPENED"),
      RESCOPED("RESCOPED"),
      REVIEW_COMMENTED("REVIEW_COMMENTED"),
      REVIEW_DISCARDED("REVIEW_DISCARDED"),
      REVIEW_FINISHED("REVIEW_FINISHED"),
      REVIEWED("REVIEWED"),
      UNAPPROVED("UNAPPROVED"),
      UPDATED("UPDATED");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPullRequestActivity.ActionEnum.ActionEnumAdapter.class)
    private ActionEnum action;

    public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
    @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
    @Schema(example = "19990759200")
    private Long createdDate;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "1")
    private Long id;

    public static final String JSON_PROPERTY_USER = "user";
    @JsonbProperty(JSON_PROPERTY_USER)
    private RestPullRequestActivityUser user;

    public RestPullRequestActivity action(ActionEnum action) {
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

    public RestPullRequestActivity createdDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     **/
    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public RestPullRequestActivity id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestPullRequestActivity user(RestPullRequestActivityUser user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     *
     * @return user
     **/
    public @Valid RestPullRequestActivityUser getUser() {
        return user;
    }

    public void setUser(RestPullRequestActivityUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPullRequestActivity)) {
            return false;
        }
        RestPullRequestActivity other = (RestPullRequestActivity) o;
        return Objects.equals(this.action, other.action) &&
                Objects.equals(this.createdDate, other.createdDate) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.user, other.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, createdDate, id, user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPullRequestActivity {");
        sb.append("\n    action: ").append(toIndentedString(action));
        sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    user: ").append(toIndentedString(user));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
