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
 * RestErasedUser
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestErasedUser {
    public static final String JSON_PROPERTY_NEW_IDENTIFIER = "newIdentifier";
    @JsonbProperty(JSON_PROPERTY_NEW_IDENTIFIER)
    @Schema(example = "user-123ab")
    private String newIdentifier;

    public RestErasedUser newIdentifier(String newIdentifier) {
        this.newIdentifier = newIdentifier;
        return this;
    }

    /**
     * Get newIdentifier
     *
     * @return newIdentifier
     **/
    public String getNewIdentifier() {
        return newIdentifier;
    }

    public void setNewIdentifier(String newIdentifier) {
        this.newIdentifier = newIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestErasedUser)) {
            return false;
        }
        RestErasedUser other = (RestErasedUser) o;
        return Objects.equals(this.newIdentifier, other.newIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newIdentifier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestErasedUser {");
        sb.append("\n    newIdentifier: ").append(toIndentedString(newIdentifier));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
