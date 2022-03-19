/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RefreshToken
 */
@JsonbPropertyOrder({
  RefreshToken.JSON_PROPERTY_REFRESH_TOKEN
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class RefreshToken {
  public static final String JSON_PROPERTY_REFRESH_TOKEN = "refresh_token";
  @JsonbProperty(JSON_PROPERTY_REFRESH_TOKEN)
  @Schema(description = "The refresh token to be used for generating access tokens")
  private String refresh_token;

  public RefreshToken refresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
    return this;
  }

  /**
   * The refresh token to be used for generating access tokens.
   *
   * @return refresh_token
   **/
  public String getRefreshToken() {
    return refresh_token;
  }

  public void setRefreshToken(String refresh_token) {
    this.refresh_token = refresh_token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefreshToken other = (RefreshToken) o;
    return Objects.equals(this.refresh_token, other.refresh_token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refresh_token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefreshToken {");
    sb.append("\n    refresh_token: ").append(toIndentedString(refresh_token));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
