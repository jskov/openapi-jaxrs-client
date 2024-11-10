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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestDiffSegment
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDiffSegment {
    public static final String JSON_PROPERTY_LINES = "lines";
    @JsonbProperty(JSON_PROPERTY_LINES)
    private List<RestDiffLine> lines;

    public static final String JSON_PROPERTY_TRUNCATED = "truncated";
    @JsonbProperty(JSON_PROPERTY_TRUNCATED)
    private Boolean truncated;

    public enum TypeEnum {
      ADDED("ADDED"),
      CONTEXT("CONTEXT"),
      REMOVED("REMOVED");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestDiffSegment.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public RestDiffSegment lines(List<RestDiffLine> lines) {
        this.lines = lines;
        return this;
    }

    public RestDiffSegment addLinesItem(RestDiffLine linesItem) {
        if (this.lines == null) {
            this.lines = new ArrayList<>();
        }
        this.lines.add(linesItem);
        return this;
    }

    /**
     * Get lines
     *
     * @return lines
     **/
    @Valid public List<RestDiffLine> getLines() {
        return lines;
    }

    public void setLines(List<RestDiffLine> lines) {
        this.lines = lines;
    }

    public RestDiffSegment truncated(Boolean truncated) {
        this.truncated = truncated;
        return this;
    }

    /**
     * Get truncated
     *
     * @return truncated
     **/
    public Boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public RestDiffSegment type(TypeEnum type) {
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
        if (!(o instanceof RestDiffSegment)) {
            return false;
        }
        RestDiffSegment other = (RestDiffSegment) o;
        return Objects.equals(this.lines, other.lines) &&
                Objects.equals(this.truncated, other.truncated) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, truncated, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDiffSegment {");
        sb.append("\n    lines: ").append(toIndentedString(lines));
        sb.append("\n    truncated: ").append(toIndentedString(truncated));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
