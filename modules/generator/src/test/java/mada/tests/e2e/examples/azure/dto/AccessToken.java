/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * AccessToken
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AccessToken {
    public static final String JSON_PROPERTY_ACCESS_TOKEN = "access_token";
    @JsonbProperty(JSON_PROPERTY_ACCESS_TOKEN)
    @Schema(description = "The access token for performing authenticated requests")
    private String accessToken;

    public AccessToken accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * The access token for performing authenticated requests.
     * @return accessToken
     **/
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessToken)) {
            return false;
        }
        AccessToken other = (AccessToken) o;
        return Objects.equals(this.accessToken, other.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccessToken {");
        sb.append("\n    accessToken: ").append(toIndentedString(accessToken));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
