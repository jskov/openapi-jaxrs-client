/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import javax.validation.Valid;

/**
 * EnumsDto
 */
@JsonPropertyOrder({
  EnumsDto.JSON_PROPERTY_PROPERTY_ENUM_STRING,
  EnumsDto.JSON_PROPERTY_INNER,
  EnumsDto.JSON_PROPERTY_EXTERNAL,
  EnumsDto.JSON_PROPERTY_INTEGER_ENUM,
  EnumsDto.JSON_PROPERTY_STRING_INTEGER_ENUM
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class EnumsDto {
  public enum PropertyEnumStringEnum {
    O("O"),
    M("M");

    private final String value;

    PropertyEnumStringEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PropertyEnumStringEnum fromValue(String value) {
      for (PropertyEnumStringEnum b : PropertyEnumStringEnum.values()) {
        if (Objects.equals(b.value, value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PROPERTY_ENUM_STRING = "propertyEnumString";
  @JsonProperty(JSON_PROPERTY_PROPERTY_ENUM_STRING)
  private PropertyEnumStringEnum propertyEnumString;

  public static final String JSON_PROPERTY_INNER = "inner";
  @JsonProperty(JSON_PROPERTY_INNER)
  private InnerEnum inner;

  public static final String JSON_PROPERTY_EXTERNAL = "external";
  @JsonProperty(JSON_PROPERTY_EXTERNAL)
  private ExternalEnum external;

  public static final String JSON_PROPERTY_INTEGER_ENUM = "integerEnum";
  @JsonProperty(JSON_PROPERTY_INTEGER_ENUM)
  private IntEnum integerEnum;

  public static final String JSON_PROPERTY_STRING_INTEGER_ENUM = "stringIntegerEnum";
  @JsonProperty(JSON_PROPERTY_STRING_INTEGER_ENUM)
  private StringIntEnum stringIntegerEnum;

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

  public EnumsDto stringIntegerEnum(StringIntEnum stringIntegerEnum) {
    this.stringIntegerEnum = stringIntegerEnum;
    return this;
  }

  /**
   * Get stringIntegerEnum
   * @return stringIntegerEnum
   **/
  @Valid
  public StringIntEnum getStringIntegerEnum() {
    return stringIntegerEnum;
  }

  public void setStringIntegerEnum(StringIntEnum stringIntegerEnum) {
    this.stringIntegerEnum = stringIntegerEnum;
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
        Objects.equals(this.integerEnum, other.integerEnum) &&
        Objects.equals(this.stringIntegerEnum, other.stringIntegerEnum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyEnumString, inner, external, integerEnum, stringIntegerEnum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnumsDto {");
    sb.append("\n    propertyEnumString: ").append(toIndentedString(propertyEnumString));
    sb.append("\n    inner: ").append(toIndentedString(inner));
    sb.append("\n    external: ").append(toIndentedString(external));
    sb.append("\n    integerEnum: ").append(toIndentedString(integerEnum));
    sb.append("\n    stringIntegerEnum: ").append(toIndentedString(stringIntegerEnum));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
