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
 * AccessToken
 */
@JsonbPropertyOrder({
  AccessToken.JSON_PROPERTY_ACCESS_TOKEN
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class AccessToken {
  public static final String JSON_PROPERTY_ACCESS_TOKEN = "access_token";
  @JsonbProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @Schema(description = "The access token for performing authenticated requests")
  private String access_token;

  public AccessToken access_token(String access_token) {
    this.access_token = access_token;
    return this;
  }

  /**
   * The access token for performing authenticated requests.
   *
   * @return access_token
   **/
  public String getAccessToken() {
    return access_token;
  }

  public void setAccessToken(String access_token) {
    this.access_token = access_token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessToken other = (AccessToken) o;
    return Objects.equals(this.access_token, other.access_token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(access_token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessToken {");
    sb.append("\n    access_token: ").append(toIndentedString(access_token));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
