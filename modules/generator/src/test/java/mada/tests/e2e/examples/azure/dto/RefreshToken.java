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
 * RefreshToken
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RefreshToken {
    public static final String JSON_PROPERTY_REFRESH_TOKEN = "refresh_token";
    @JsonbProperty(JSON_PROPERTY_REFRESH_TOKEN)
    @Schema(description = "The refresh token to be used for generating access tokens")
    private String refreshToken;

    public RefreshToken refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    /**
     * The refresh token to be used for generating access tokens.
     * 
     * @return refreshToken
     **/
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RefreshToken)) {
            return false;
        }
        RefreshToken other = (RefreshToken) o;
        return Objects.equals(this.refreshToken, other.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshToken);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefreshToken {");
        sb.append("\n    refreshToken: ").append(toIndentedString(refreshToken));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
