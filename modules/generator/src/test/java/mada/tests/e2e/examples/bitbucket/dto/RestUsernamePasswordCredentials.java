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
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestUsernamePasswordCredentials
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestUsernamePasswordCredentials {
    public static final String JSON_PROPERTY_PASSWORD = "password";
    @JsonbProperty(JSON_PROPERTY_PASSWORD)
    @Schema(required = true, example = "secr3t")
    private String password;

    public static final String JSON_PROPERTY_USERNAME = "username";
    @JsonbProperty(JSON_PROPERTY_USERNAME)
    @Schema(required = true, example = "user1")
    private String username;

    public RestUsernamePasswordCredentials password(String password) {
        this.password = Objects.requireNonNull(password, "Property password is required, cannot be null");
        return this;
    }

    /**
     * Get password
     *
     * @return password
     **/
    @NotNull public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password, "Property password is required, cannot be null");
    }

    public RestUsernamePasswordCredentials username(String username) {
        this.username = Objects.requireNonNull(username, "Property username is required, cannot be null");
        return this;
    }

    /**
     * Get username
     *
     * @return username
     **/
    @NotNull public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = Objects.requireNonNull(username, "Property username is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestUsernamePasswordCredentials)) {
            return false;
        }
        RestUsernamePasswordCredentials other = (RestUsernamePasswordCredentials) o;
        return Objects.equals(this.password, other.password) &&
                Objects.equals(this.username, other.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestUsernamePasswordCredentials {");
        sb.append("\n    password: ").append(toIndentedString(password));
        sb.append("\n    username: ").append(toIndentedString(username));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
