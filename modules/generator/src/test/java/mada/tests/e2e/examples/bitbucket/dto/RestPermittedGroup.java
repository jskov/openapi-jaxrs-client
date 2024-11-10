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
import jakarta.validation.Valid;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestPermittedGroup
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPermittedGroup {
    public static final String JSON_PROPERTY_GROUP = "group";
    @JsonbProperty(JSON_PROPERTY_GROUP)
    private RestPermittedGroupGroup group;

    public static final String JSON_PROPERTY_PERMISSION = "permission";
    @JsonbProperty(JSON_PROPERTY_PERMISSION)
    @Schema(example = "ADMIN")
    private String permission;

    public RestPermittedGroup group(RestPermittedGroupGroup group) {
        this.group = group;
        return this;
    }

    /**
     * Get group
     *
     * @return group
     **/
    @Valid public RestPermittedGroupGroup getGroup() {
        return group;
    }

    public void setGroup(RestPermittedGroupGroup group) {
        this.group = group;
    }

    public RestPermittedGroup permission(String permission) {
        this.permission = permission;
        return this;
    }

    /**
     * Get permission
     *
     * @return permission
     **/
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPermittedGroup)) {
            return false;
        }
        RestPermittedGroup other = (RestPermittedGroup) o;
        return Objects.equals(this.group, other.group) &&
                Objects.equals(this.permission, other.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, permission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPermittedGroup {");
        sb.append("\n    group: ").append(toIndentedString(group));
        sb.append("\n    permission: ").append(toIndentedString(permission));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
