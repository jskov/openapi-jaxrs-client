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
 * RestRequiredBuildConditionExemptRefMatcherType
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRequiredBuildConditionExemptRefMatcherType {
  public enum IdEnum {
    ANY_REF("ANY_REF"),
    BRANCH("BRANCH"),
    PATTERN("PATTERN"),
    MODEL_CATEGORY("MODEL_CATEGORY"),
    MODEL_BRANCH("MODEL_BRANCH");

    private final String value;

    IdEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class IdEnumAdapter implements JsonbAdapter<IdEnum, JsonString> {
      @Override
      public JsonString adaptToJson(IdEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public IdEnum adaptFromJson(JsonString value) throws Exception {
        for (IdEnum b : IdEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type IdEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestRequiredBuildConditionExemptRefMatcherType.IdEnum.IdEnumAdapter.class)
  private IdEnum id;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "Branch")
  private String name;

  public RestRequiredBuildConditionExemptRefMatcherType id(IdEnum id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public IdEnum getId() {
    return id;
  }

  public void setId(IdEnum id) {
    this.id = id;
  }

  public RestRequiredBuildConditionExemptRefMatcherType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRequiredBuildConditionExemptRefMatcherType)) {
      return false;
    }
    RestRequiredBuildConditionExemptRefMatcherType other = (RestRequiredBuildConditionExemptRefMatcherType) o;
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.name, other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRequiredBuildConditionExemptRefMatcherType {");
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
