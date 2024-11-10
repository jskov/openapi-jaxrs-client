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
 * RestPermittedUser
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPermittedUser {
    public enum PermissionEnum {
      USER_ADMIN("USER_ADMIN"),
      PROJECT_VIEW("PROJECT_VIEW"),
      REPO_READ("REPO_READ"),
      REPO_WRITE("REPO_WRITE"),
      REPO_ADMIN("REPO_ADMIN"),
      PROJECT_READ("PROJECT_READ"),
      PROJECT_WRITE("PROJECT_WRITE"),
      REPO_CREATE("REPO_CREATE"),
      PROJECT_ADMIN("PROJECT_ADMIN"),
      LICENSED_USER("LICENSED_USER"),
      PROJECT_CREATE("PROJECT_CREATE"),
      ADMIN("ADMIN"),
      SYS_ADMIN("SYS_ADMIN");

      private final String value;

      PermissionEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class PermissionEnumAdapter implements JsonbAdapter<PermissionEnum, JsonString> {
          @Override
          public JsonString adaptToJson(PermissionEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public PermissionEnum adaptFromJson(JsonString value) throws Exception {
            for (PermissionEnum b : PermissionEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type PermissionEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_PERMISSION = "permission";
    @JsonbProperty(JSON_PROPERTY_PERMISSION)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPermittedUser.PermissionEnum.PermissionEnumAdapter.class)
    private PermissionEnum permission;

    public static final String JSON_PROPERTY_USER = "user";
    @JsonbProperty(JSON_PROPERTY_USER)
    private RestPermittedUserUser user;

    public RestPermittedUser permission(PermissionEnum permission) {
        this.permission = permission;
        return this;
    }

    /**
     * Get permission
     *
     * @return permission
     **/
    public PermissionEnum getPermission() {
        return permission;
    }

    public void setPermission(PermissionEnum permission) {
        this.permission = permission;
    }

    public RestPermittedUser user(RestPermittedUserUser user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     *
     * @return user
     **/
    @Valid public RestPermittedUserUser getUser() {
        return user;
    }

    public void setUser(RestPermittedUserUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPermittedUser)) {
            return false;
        }
        RestPermittedUser other = (RestPermittedUser) o;
        return Objects.equals(this.permission, other.permission) &&
                Objects.equals(this.user, other.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permission, user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPermittedUser {");
        sb.append("\n    permission: ").append(toIndentedString(permission));
        sb.append("\n    user: ").append(toIndentedString(user));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
