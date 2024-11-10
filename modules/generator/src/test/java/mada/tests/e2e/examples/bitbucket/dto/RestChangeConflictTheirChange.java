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
import jakarta.validation.Valid;
import java.util.Objects;

/**
 * RestChangeConflictTheirChange
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestChangeConflictTheirChange {
    public static final String JSON_PROPERTY_PATH = "path";
    @JsonbProperty(JSON_PROPERTY_PATH)
    private RestChangeConflictTheirChangePath path;

    public static final String JSON_PROPERTY_SRC_PATH = "srcPath";
    @JsonbProperty(JSON_PROPERTY_SRC_PATH)
    private RestChangeConflictTheirChangeSrcPath srcPath;

    public enum TypeEnum {
      ADD("ADD"),
      COPY("COPY"),
      DELETE("DELETE"),
      MODIFY("MODIFY"),
      MOVE("MOVE"),
      UNKNOWN("UNKNOWN");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestChangeConflictTheirChange.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public RestChangeConflictTheirChange path(RestChangeConflictTheirChangePath path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     *
     * @return path
     **/
    public @Valid RestChangeConflictTheirChangePath getPath() {
        return path;
    }

    public void setPath(RestChangeConflictTheirChangePath path) {
        this.path = path;
    }

    public RestChangeConflictTheirChange srcPath(RestChangeConflictTheirChangeSrcPath srcPath) {
        this.srcPath = srcPath;
        return this;
    }

    /**
     * Get srcPath
     *
     * @return srcPath
     **/
    public @Valid RestChangeConflictTheirChangeSrcPath getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(RestChangeConflictTheirChangeSrcPath srcPath) {
        this.srcPath = srcPath;
    }

    public RestChangeConflictTheirChange type(TypeEnum type) {
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
        if (!(o instanceof RestChangeConflictTheirChange)) {
            return false;
        }
        RestChangeConflictTheirChange other = (RestChangeConflictTheirChange) o;
        return Objects.equals(this.path, other.path) &&
                Objects.equals(this.srcPath, other.srcPath) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, srcPath, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestChangeConflictTheirChange {");
        sb.append("\n    path: ").append(toIndentedString(path));
        sb.append("\n    srcPath: ").append(toIndentedString(srcPath));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
