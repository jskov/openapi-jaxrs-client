/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jsonb.dto;

import java.util.Objects;
import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.Valid;

/**
 * EnumsDto
 */
@JsonbPropertyOrder({
  EnumsDto.JSON_PROPERTY_PROPERTY_ENUM_STRING,
  EnumsDto.JSON_PROPERTY_INNER,
  EnumsDto.JSON_PROPERTY_EXTERNAL,
  EnumsDto.JSON_PROPERTY_INTEGER_ENUM
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class EnumsDto   {
  public enum PropertyEnumStringEnum {
    O("O"),
    M("M");

    private final String value;

    PropertyEnumStringEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class PropertyEnumStringEnumAdapter implements JsonbAdapter<PropertyEnumStringEnum, JsonString> {
      @Override
      public JsonString adaptToJson(PropertyEnumStringEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public PropertyEnumStringEnum adaptFromJson(JsonString value) throws Exception {
        for (PropertyEnumStringEnum b : PropertyEnumStringEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type PropertyEnumStringEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_PROPERTY_ENUM_STRING = "propertyEnumString";
  @JsonbProperty(JSON_PROPERTY_PROPERTY_ENUM_STRING)
  @JsonbTypeAdapter(mada.tests.e2e.dto.enums.jsonb.dto.EnumsDto.PropertyEnumStringEnum.PropertyEnumStringEnumAdapter.class)
  private PropertyEnumStringEnum propertyEnumString;

  public static final String JSON_PROPERTY_INNER = "inner";
  @JsonbProperty(JSON_PROPERTY_INNER)
  private InnerEnum inner;

  public static final String JSON_PROPERTY_EXTERNAL = "external";
  @JsonbProperty(JSON_PROPERTY_EXTERNAL)
  private ExternalEnum external;

  public static final String JSON_PROPERTY_INTEGER_ENUM = "integerEnum";
  @JsonbProperty(JSON_PROPERTY_INTEGER_ENUM)
  private IntEnum integerEnum;

  public EnumsDto propertyEnumString(PropertyEnumStringEnum propertyEnumString) {
    this.propertyEnumString = propertyEnumString;
    return this;
  }

  /**
   * Get propertyEnumString
   * @return propertyEnumString
   **/
  public PropertyEnumStringEnum getPropertyEnumString() {
    return propertyEnumString;
  }

  public void setPropertyEnumString(PropertyEnumStringEnum propertyEnumString) {
    this.propertyEnumString = propertyEnumString;
  }

  public EnumsDto inner(InnerEnum inner) {
    this.inner = inner;
    return this;
  }

  /**
   * Get inner
   * @return inner
   **/
  @Valid
  public InnerEnum getInner() {
    return inner;
  }

  public void setInner(InnerEnum inner) {
    this.inner = inner;
  }

  public EnumsDto external(ExternalEnum external) {
    this.external = external;
    return this;
  }

  /**
   * Get external
   * @return external
   **/
  @Valid
  public ExternalEnum getExternal() {
    return external;
  }

  public void setExternal(ExternalEnum external) {
    this.external = external;
  }

  public EnumsDto integerEnum(IntEnum integerEnum) {
    this.integerEnum = integerEnum;
    return this;
  }

  /**
   * Get integerEnum
   * @return integerEnum
   **/
  @Valid
  public IntEnum getIntegerEnum() {
    return integerEnum;
  }

  public void setIntegerEnum(IntEnum integerEnum) {
    this.integerEnum = integerEnum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnumsDto other = (EnumsDto) o;
    return Objects.equals(this.propertyEnumString, other.propertyEnumString) &&
        Objects.equals(this.inner, other.inner) &&
        Objects.equals(this.external, other.external) &&
        Objects.equals(this.integerEnum, other.integerEnum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyEnumString, inner, external, integerEnum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnumsDto {");
    sb.append("\n    propertyEnumString: ").append(toIndentedString(propertyEnumString));
    sb.append("\n    inner: ").append(toIndentedString(inner));
    sb.append("\n    external: ").append(toIndentedString(external));
    sb.append("\n    integerEnum: ").append(toIndentedString(integerEnum));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
