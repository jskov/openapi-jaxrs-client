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
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * RestHookScript
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestHookScript {
  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
  private OffsetDateTime createdDate;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
  private String description;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  private Long id;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  private String name;

  public static final String JSON_PROPERTY_PLUGIN_KEY = "pluginKey";
  @JsonbProperty(JSON_PROPERTY_PLUGIN_KEY)
  private String pluginKey;

  public enum TypeEnum {
    POST("POST"),
    PRE("PRE");

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
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestHookScript.TypeEnum.TypeEnumAdapter.class)
  private TypeEnum type;

  public static final String JSON_PROPERTY_UPDATED_DATE = "updatedDate";
  @JsonbProperty(JSON_PROPERTY_UPDATED_DATE)
  private OffsetDateTime updatedDate;

  public static final String JSON_PROPERTY_VERSION = "version";
  @JsonbProperty(JSON_PROPERTY_VERSION)
  private Integer version;

  public RestHookScript createdDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
   **/
  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public RestHookScript description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RestHookScript id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RestHookScript name(String name) {
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

  public RestHookScript pluginKey(String pluginKey) {
    this.pluginKey = pluginKey;
    return this;
  }

  /**
   * Get pluginKey
   * @return pluginKey
   **/
  public String getPluginKey() {
    return pluginKey;
  }

  public void setPluginKey(String pluginKey) {
    this.pluginKey = pluginKey;
  }

  public RestHookScript type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public RestHookScript updatedDate(OffsetDateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  /**
   * Get updatedDate
   * @return updatedDate
   **/
  public OffsetDateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(OffsetDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public RestHookScript version(Integer version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   **/
  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestHookScript)) {
      return false;
    }
    RestHookScript other = (RestHookScript) o;
    return Objects.equals(this.createdDate, other.createdDate) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.pluginKey, other.pluginKey) &&
        Objects.equals(this.type, other.type) &&
        Objects.equals(this.updatedDate, other.updatedDate) &&
        Objects.equals(this.version, other.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdDate, description, id, name, pluginKey, type, updatedDate, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestHookScript {");
    sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
    sb.append("\n    description: ").append(toIndentedString(description));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    pluginKey: ").append(toIndentedString(pluginKey));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n    updatedDate: ").append(toIndentedString(updatedDate));
    sb.append("\n    version: ").append(toIndentedString(version));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
