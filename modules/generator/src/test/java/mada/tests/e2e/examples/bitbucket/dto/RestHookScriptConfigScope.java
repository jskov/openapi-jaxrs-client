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
 * RestHookScriptConfigScope
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestHookScriptConfigScope {
    public static final String JSON_PROPERTY_RESOURCE_ID = "resourceId";
    @JsonbProperty(JSON_PROPERTY_RESOURCE_ID)
    @Schema(example = "2")
    private Integer resourceId;

    public enum TypeEnum {
      GLOBAL("GLOBAL"),
      PROJECT("PROJECT"),
      REPOSITORY("REPOSITORY");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestHookScriptConfigScope.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public RestHookScriptConfigScope resourceId(Integer resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get resourceId
     *
     * @return resourceId
     **/
    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public RestHookScriptConfigScope type(TypeEnum type) {
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
        if (!(o instanceof RestHookScriptConfigScope)) {
            return false;
        }
        RestHookScriptConfigScope other = (RestHookScriptConfigScope) o;
        return Objects.equals(this.resourceId, other.resourceId) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestHookScriptConfigScope {");
        sb.append("\n    resourceId: ").append(toIndentedString(resourceId));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
