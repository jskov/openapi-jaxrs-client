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
 * ExampleStatus
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleStatus {
    public static final String JSON_PROPERTY_CURRENT_NUMBER_OF_USERS = "currentNumberOfUsers";
    @JsonbProperty(JSON_PROPERTY_CURRENT_NUMBER_OF_USERS)
    @Schema(example = "2")
    private Integer currentNumberOfUsers;

    public static final String JSON_PROPERTY_SERVER_ID = "serverId";
    @JsonbProperty(JSON_PROPERTY_SERVER_ID)
    @Schema(example = "<actual server ID>")
    private String serverId;

    public ExampleStatus currentNumberOfUsers(Integer currentNumberOfUsers) {
        this.currentNumberOfUsers = currentNumberOfUsers;
        return this;
    }

    /**
     * Get currentNumberOfUsers
     *
     * @return currentNumberOfUsers
     **/
    public Integer getCurrentNumberOfUsers() {
        return currentNumberOfUsers;
    }

    public void setCurrentNumberOfUsers(Integer currentNumberOfUsers) {
        this.currentNumberOfUsers = currentNumberOfUsers;
    }

    public ExampleStatus serverId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    /**
     * Get serverId
     *
     * @return serverId
     **/
    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExampleStatus)) {
            return false;
        }
        ExampleStatus other = (ExampleStatus) o;
        return Objects.equals(this.currentNumberOfUsers, other.currentNumberOfUsers) &&
                Objects.equals(this.serverId, other.serverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentNumberOfUsers, serverId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExampleStatus {");
        sb.append("\n    currentNumberOfUsers: ").append(toIndentedString(currentNumberOfUsers));
        sb.append("\n    serverId: ").append(toIndentedString(serverId));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
