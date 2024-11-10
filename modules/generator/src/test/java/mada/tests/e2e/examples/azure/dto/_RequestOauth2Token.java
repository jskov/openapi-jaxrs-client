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
 * _RequestOauth2Token
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _RequestOauth2Token {
    /**
     * Grant type is expected to be refresh_token.
     */
    @Schema(enumeration = {"refresh_token"}, type = SchemaType.STRING)
    public enum Grant_typeEnum {
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
    @JsonbTypeAdapter(mada.tests.e2e.examples.azure.dto._RequestOauth2Token.Grant_typeEnum.Grant_typeEnumAdapter.class)
    @Schema(required = true, description = "Grant type is expected to be refresh_token")
    private Grant_typeEnum grantType;

    public static final String JSON_PROPERTY_REFRESH_TOKEN = "refresh_token";
    @JsonbProperty(JSON_PROPERTY_REFRESH_TOKEN)
    @Schema(required = true, description = "Must be a valid ACR refresh token")
    private String refreshToken;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    @Schema(required = true, description = "Which is expected to be a valid scope, and can be specified more than once for multiple scope requests. You obtained this from the Www-Authenticate response header from the challenge.")
    private String scope;

    public static final String JSON_PROPERTY_SERVICE = "service";
    @JsonbProperty(JSON_PROPERTY_SERVICE)
    @Schema(required = true, description = "Indicates the name of your Azure container registry.")
    private String service;

    public _RequestOauth2Token grantType(Grant_typeEnum grantType) {
        this.grantType = Objects.requireNonNull(grantType, "Property grantType is required, cannot be null");
        return this;
    }

    /**
     * Grant type is expected to be refresh_token.
     * @return grantType
     **/
    public @NotNull Grant_typeEnum getGrantType() {
        return grantType;
    }

    public void setGrantType(Grant_typeEnum grantType) {
        this.grantType = Objects.requireNonNull(grantType, "Property grantType is required, cannot be null");
    }

    public _RequestOauth2Token refreshToken(String refreshToken) {
        this.refreshToken = Objects.requireNonNull(refreshToken, "Property refreshToken is required, cannot be null");
        return this;
    }

    /**
     * Must be a valid ACR refresh token.
     * @return refreshToken
     **/
    public @NotNull String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = Objects.requireNonNull(refreshToken, "Property refreshToken is required, cannot be null");
    }

    public _RequestOauth2Token scope(String scope) {
        this.scope = Objects.requireNonNull(scope, "Property scope is required, cannot be null");
        return this;
    }

    /**
     * Which is expected to be a valid scope, and can be specified more than once for multiple scope requests. You
   * obtained this from the Www-Authenticate response header from the challenge.
     * @return scope
     **/
    public @NotNull String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = Objects.requireNonNull(scope, "Property scope is required, cannot be null");
    }

    public _RequestOauth2Token service(String service) {
        this.service = Objects.requireNonNull(service, "Property service is required, cannot be null");
        return this;
    }

    /**
     * Indicates the name of your Azure container registry.
     * @return service
     **/
    public @NotNull String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = Objects.requireNonNull(service, "Property service is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof _RequestOauth2Token)) {
            return false;
        }
        _RequestOauth2Token other = (_RequestOauth2Token) o;
        return Objects.equals(this.grantType, other.grantType) &&
                Objects.equals(this.refreshToken, other.refreshToken) &&
                Objects.equals(this.scope, other.scope) &&
                Objects.equals(this.service, other.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grantType, refreshToken, scope, service);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class _RequestOauth2Token {");
        sb.append("\n    grantType: ").append(toIndentedString(grantType));
        sb.append("\n    refreshToken: ").append(toIndentedString(refreshToken));
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n    service: ").append(toIndentedString(service));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
