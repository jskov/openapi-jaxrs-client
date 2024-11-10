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

/**
 * RestPullRequestAssignParticipantRoleRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestAssignParticipantRoleRequest {
    public enum RoleEnum {
      AUTHOR("AUTHOR"),
      REVIEWER("REVIEWER"),
      PARTICIPANT("PARTICIPANT");

      private final String value;

      RoleEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class RoleEnumAdapter implements JsonbAdapter<RoleEnum, JsonString> {
          @Override
          public JsonString adaptToJson(RoleEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public RoleEnum adaptFromJson(JsonString value) throws Exception {
            for (RoleEnum b : RoleEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RoleEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_ROLE = "role";
    @JsonbProperty(JSON_PROPERTY_ROLE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPullRequestAssignParticipantRoleRequest.RoleEnum.RoleEnumAdapter.class)
    private RoleEnum role;

    public static final String JSON_PROPERTY_USER = "user";
    @JsonbProperty(JSON_PROPERTY_USER)
    private RestPullRequestAssignParticipantRoleRequestUser user;

    public RestPullRequestAssignParticipantRoleRequest role(RoleEnum role) {
        this.role = role;
        return this;
    }

    /**
     * Get role
     *
     * @return role
     **/
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public RestPullRequestAssignParticipantRoleRequest user(RestPullRequestAssignParticipantRoleRequestUser user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     *
     * @return user
     **/
    public @Valid RestPullRequestAssignParticipantRoleRequestUser getUser() {
        return user;
    }

    public void setUser(RestPullRequestAssignParticipantRoleRequestUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPullRequestAssignParticipantRoleRequest)) {
            return false;
        }
        RestPullRequestAssignParticipantRoleRequest other = (RestPullRequestAssignParticipantRoleRequest) o;
        return Objects.equals(this.role, other.role) &&
                Objects.equals(this.user, other.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPullRequestAssignParticipantRoleRequest {");
        sb.append("\n    role: ").append(toIndentedString(role));
        sb.append("\n    user: ").append(toIndentedString(user));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
