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
 * RestRepositoryPolicy
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoryPolicy {
    /**
     * The permission required to delete repositories. Must be one of: "SYS_ADMIN", "ADMIN", "PROJECT_ADMIN", "REPO_ADMIN".
     */
    public enum PermissionEnum {
        SYS_ADMIN("SYS_ADMIN"),
        ADMIN("ADMIN"),
        PROJECT_ADMIN("PROJECT_ADMIN"),
        REPO_ADMIN("REPO_ADMIN");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestRepositoryPolicy.PermissionEnum.PermissionEnumAdapter.class)
    @Schema(
            description = "The permission required to delete repositories. Must be one of: \"SYS_ADMIN\", \"ADMIN\", \"PROJECT_ADMIN\", \"REPO_ADMIN\".",
            example = "ADMIN")
    private PermissionEnum permission;

    public RestRepositoryPolicy permission(PermissionEnum permission) {
        this.permission = permission;
        return this;
    }

    /**
     * The permission required to delete repositories. Must be one of: "SYS_ADMIN", "ADMIN", "PROJECT_ADMIN", "REPO_ADMIN".
     * 
     * @return permission
     **/
    public PermissionEnum getPermission() {
        return permission;
    }

    public void setPermission(PermissionEnum permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRepositoryPolicy)) {
            return false;
        }
        RestRepositoryPolicy other = (RestRepositoryPolicy) o;
        return Objects.equals(this.permission, other.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRepositoryPolicy {");
        sb.append("\n    permission: ").append(toIndentedString(permission));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
