/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * _RequestOauth2Exchange
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _RequestOauth2Exchange {
  public static final String JSON_PROPERTY_ACCESS_TOKEN = "access_token";
  @JsonbProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @Schema(description = "AAD access token, mandatory when grant_type is access_token_refresh_token or access_token.")
  private String accessToken;

  /**
   * Can take a value of access_token_refresh_token, or access_token, or refresh_token.
   */
  @Schema(enumeration = {"access_token_refresh_token", "access_token", "refresh_token"}, type = SchemaType.STRING)
  public enum Grant_typeEnum {
    ACCESS_TOKEN_REFRESH_TOKEN("access_token_refresh_token"),
    ACCESS_TOKEN("access_token"),
    REFRESH_TOKEN("refresh_token");

    private final String value;

    Grant_typeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class Grant_typeEnumAdapter implements JsonbAdapter<Grant_typeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(Grant_typeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public Grant_typeEnum adaptFromJson(JsonString value) throws Exception {
        for (Grant_typeEnum b : Grant_typeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type Grant_typeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_GRANT_TYPE = "grant_type";
  @JsonbProperty(JSON_PROPERTY_GRANT_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.azure.dto._RequestOauth2Exchange.Grant_typeEnum.Grant_typeEnumAdapter.class)
  @Schema(required = true, description = "Can take a value of access_token_refresh_token, or access_token, or refresh_token")
  private Grant_typeEnum grantType;

  public static final String JSON_PROPERTY_REFRESH_TOKEN = "refresh_token";
  @JsonbProperty(JSON_PROPERTY_REFRESH_TOKEN)
  @Schema(description = "AAD refresh token, mandatory when grant_type is access_token_refresh_token or refresh_token")
  private String refreshToken;

  public static final String JSON_PROPERTY_SERVICE = "service";
  @JsonbProperty(JSON_PROPERTY_SERVICE)
  @Schema(required = true, description = "Indicates the name of your Azure container registry.")
  private String service;

  public static final String JSON_PROPERTY_TENANT = "tenant";
  @JsonbProperty(JSON_PROPERTY_TENANT)
  @Schema(description = "AAD tenant associated to the AAD credentials.")
  private String tenant;

  public _RequestOauth2Exchange accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * AAD access token, mandatory when grant_type is access_token_refresh_token or access_token.
   *
   * @return accessToken
   **/
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public _RequestOauth2Exchange grantType(Grant_typeEnum grantType) {
    this.grantType = Objects.requireNonNull(grantType, "Property grantType is required, cannot be null");
    return this;
  }

  /**
   * Can take a value of access_token_refresh_token, or access_token, or refresh_token.
   *
   * @return grantType
   **/
  @NotNull
  public Grant_typeEnum getGrantType() {
    return grantType;
  }

  public void setGrantType(Grant_typeEnum grantType) {
    this.grantType = Objects.requireNonNull(grantType, "Property grantType is required, cannot be null");
  }

  public _RequestOauth2Exchange refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * AAD refresh token, mandatory when grant_type is access_token_refresh_token or refresh_token.
   *
   * @return refreshToken
   **/
  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public _RequestOauth2Exchange service(String service) {
    this.service = Objects.requireNonNull(service, "Property service is required, cannot be null");
    return this;
  }

  /**
   * Indicates the name of your Azure container registry.
   *
   * @return service
   **/
  @NotNull
  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = Objects.requireNonNull(service, "Property service is required, cannot be null");
  }

  public _RequestOauth2Exchange tenant(String tenant) {
    this.tenant = tenant;
    return this;
  }

  /**
   * AAD tenant associated to the AAD credentials.
   *
   * @return tenant
   **/
  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof _RequestOauth2Exchange)) {
      return false;
    }
    _RequestOauth2Exchange other = (_RequestOauth2Exchange) o;
    return Objects.equals(this.accessToken, other.accessToken) &&
        Objects.equals(this.grantType, other.grantType) &&
        Objects.equals(this.refreshToken, other.refreshToken) &&
        Objects.equals(this.service, other.service) &&
        Objects.equals(this.tenant, other.tenant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, grantType, refreshToken, service, tenant);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class _RequestOauth2Exchange {");
    sb.append("\n    accessToken: ").append(toIndentedString(accessToken));
    sb.append("\n    grantType: ").append(toIndentedString(grantType));
    sb.append("\n    refreshToken: ").append(toIndentedString(refreshToken));
    sb.append("\n    service: ").append(toIndentedString(service));
    sb.append("\n    tenant: ").append(toIndentedString(tenant));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
