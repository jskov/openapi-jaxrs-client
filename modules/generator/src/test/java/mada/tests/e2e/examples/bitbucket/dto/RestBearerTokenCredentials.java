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
 * RestBearerTokenCredentials
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBearerTokenCredentials {
    public static final String JSON_PROPERTY_TOKEN = "token";
    @JsonbProperty(JSON_PROPERTY_TOKEN)
    @Schema(required = true, example = "safe-secret")
    private String token;

    public RestBearerTokenCredentials token(String token) {
        this.token = Objects.requireNonNull(token, "Property token is required, cannot be null");
        return this;
    }

    /**
     * Get token
     *
     * @return token
     **/
    @NotNull public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = Objects.requireNonNull(token, "Property token is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBearerTokenCredentials)) {
            return false;
        }
        RestBearerTokenCredentials other = (RestBearerTokenCredentials) o;
        return Objects.equals(this.token, other.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBearerTokenCredentials {");
        sb.append("\n    token: ").append(toIndentedString(token));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
