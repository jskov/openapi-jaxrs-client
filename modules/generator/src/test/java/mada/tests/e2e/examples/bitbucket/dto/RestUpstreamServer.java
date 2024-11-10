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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestUpstreamServer
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestUpstreamServer {
    public static final String JSON_PROPERTY_API_BASE_URL = "apiBaseUrl";
    @JsonbProperty(JSON_PROPERTY_API_BASE_URL)
    @Schema(example = "https://bitbucket.example.com")
    private String apiBaseUrl;

    public static final String JSON_PROPERTY_BASE_URL = "baseUrl";
    @JsonbProperty(JSON_PROPERTY_BASE_URL)
    @Schema(example = "https://bitbucket.example.com")
    private String baseUrl;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "f76a35c5-4592-425d-bf85-b4d9db68e809")
    private String id;

    public enum StateEnum {
      INITIALIZING("INITIALIZING"),
      PENDING("PENDING"),
      INSTALLED("INSTALLED"),
      UNKNOWN("UNKNOWN"),
      REMOVED("REMOVED");

      private final String value;

      StateEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class StateEnumAdapter implements JsonbAdapter<StateEnum, JsonString> {
          @Override
          public JsonString adaptToJson(StateEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public StateEnum adaptFromJson(JsonString value) throws Exception {
            for (StateEnum b : StateEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StateEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_STATE = "state";
    @JsonbProperty(JSON_PROPERTY_STATE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestUpstreamServer.StateEnum.StateEnumAdapter.class)
    @Schema(example = "INSTALLED")
    private StateEnum state;

    public enum TypeEnum {
      BITBUCKET_SERVER("BITBUCKET_SERVER"),
      BITBUCKET_CLOUD("BITBUCKET_CLOUD");

      private final String value;

      TypeEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class TypeEnumAdapter implements JsonbAdapter<TypeEnum, JsonString> {
          @Override
          public JsonString adaptToJson(TypeEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public TypeEnum adaptFromJson(JsonString value) throws Exception {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type TypeEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestUpstreamServer.TypeEnum.TypeEnumAdapter.class)
    @Schema(example = "server")
    private TypeEnum type;

    public RestUpstreamServer apiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
        return this;
    }

    /**
     * Get apiBaseUrl
     *
     * @return apiBaseUrl
     **/
    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public RestUpstreamServer baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Get baseUrl
     *
     * @return baseUrl
     **/
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RestUpstreamServer id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestUpstreamServer state(StateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public RestUpstreamServer type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestUpstreamServer)) {
            return false;
        }
        RestUpstreamServer other = (RestUpstreamServer) o;
        return Objects.equals(this.apiBaseUrl, other.apiBaseUrl) &&
                Objects.equals(this.baseUrl, other.baseUrl) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.state, other.state) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiBaseUrl, baseUrl, id, state, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestUpstreamServer {");
        sb.append("\n    apiBaseUrl: ").append(toIndentedString(apiBaseUrl));
        sb.append("\n    baseUrl: ").append(toIndentedString(baseUrl));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
