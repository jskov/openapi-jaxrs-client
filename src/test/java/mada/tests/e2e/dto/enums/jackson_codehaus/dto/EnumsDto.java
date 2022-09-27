/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jackson_codehaus.dto;

import java.util.Objects;
import javax.validation.Valid;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonValue;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * EnumsDto
 */
@JsonPropertyOrder({
  EnumsDto.JSON_PROPERTY_PROPERTY_ENUM_STRING,
  EnumsDto.JSON_PROPERTY_INNER,
  EnumsDto.JSON_PROPERTY_LOWER,
  EnumsDto.JSON_PROPERTY_MIXED,
  EnumsDto.JSON_PROPERTY_EXTERNAL,
  EnumsDto.JSON_PROPERTY_EXTERNAL_LOWER,
  EnumsDto.JSON_PROPERTY_EXTERNAL_MIXED,
  EnumsDto.JSON_PROPERTY_INTEGER_ENUM,
  EnumsDto.JSON_PROPERTY_STRING_INTEGER_ENUM
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EnumsDto {
  @Schema(enumeration = {"O", "M", "nexT"}, type = SchemaType.STRING)
  public enum PropertyEnumStringEnum {
    O("O"),
    M("M"),
    NEXT("nexT");

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

  public static final String JSON_PROPERTY_LOWER = "lower";
  @JsonProperty(JSON_PROPERTY_LOWER)
  private InnerLowerEnum lower;

  public static final String JSON_PROPERTY_MIXED = "mixed";
  @JsonProperty(JSON_PROPERTY_MIXED)
  private InnerMixedEnum mixed;

  public static final String JSON_PROPERTY_EXTERNAL = "external";
  @JsonProperty(JSON_PROPERTY_EXTERNAL)
  private ExternalEnum external;

  public static final String JSON_PROPERTY_EXTERNAL_LOWER = "externalLower";
  @JsonProperty(JSON_PROPERTY_EXTERNAL_LOWER)
  private ExternalLowerEnum externalLower;

  public static final String JSON_PROPERTY_EXTERNAL_MIXED = "externalMixed";
  @JsonProperty(JSON_PROPERTY_EXTERNAL_MIXED)
  private ExternalMixedEnum externalMixed;

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

  public EnumsDto lower(InnerLowerEnum lower) {
    this.lower = lower;
    return this;
  }

  /**
   * Get lower
   * @return lower
   **/
  @Valid
  public InnerLowerEnum getLower() {
    return lower;
  }

  public void setLower(InnerLowerEnum lower) {
    this.lower = lower;
  }

  public EnumsDto mixed(InnerMixedEnum mixed) {
    this.mixed = mixed;
    return this;
  }

  /**
   * Get mixed
   * @return mixed
   **/
  @Valid
  public InnerMixedEnum getMixed() {
    return mixed;
  }

  public void setMixed(InnerMixedEnum mixed) {
    this.mixed = mixed;
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

  public EnumsDto externalLower(ExternalLowerEnum externalLower) {
    this.externalLower = externalLower;
    return this;
  }

  /**
   * Get externalLower
   * @return externalLower
   **/
  @Valid
  public ExternalLowerEnum getExternalLower() {
    return externalLower;
  }

  public void setExternalLower(ExternalLowerEnum externalLower) {
    this.externalLower = externalLower;
  }

  public EnumsDto externalMixed(ExternalMixedEnum externalMixed) {
    this.externalMixed = externalMixed;
    return this;
  }

  /**
   * Get externalMixed
   * @return externalMixed
   **/
  @Valid
  public ExternalMixedEnum getExternalMixed() {
    return externalMixed;
  }

  public void setExternalMixed(ExternalMixedEnum externalMixed) {
    this.externalMixed = externalMixed;
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
        Objects.equals(this.lower, other.lower) &&
        Objects.equals(this.mixed, other.mixed) &&
        Objects.equals(this.external, other.external) &&
        Objects.equals(this.externalLower, other.externalLower) &&
        Objects.equals(this.externalMixed, other.externalMixed) &&
        Objects.equals(this.integerEnum, other.integerEnum) &&
        Objects.equals(this.stringIntegerEnum, other.stringIntegerEnum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyEnumString, inner, lower, mixed, external, externalLower, externalMixed, integerEnum, stringIntegerEnum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnumsDto {");
    sb.append("\n    propertyEnumString: ").append(toIndentedString(propertyEnumString));
    sb.append("\n    inner: ").append(toIndentedString(inner));
    sb.append("\n    lower: ").append(toIndentedString(lower));
    sb.append("\n    mixed: ").append(toIndentedString(mixed));
    sb.append("\n    external: ").append(toIndentedString(external));
    sb.append("\n    externalLower: ").append(toIndentedString(externalLower));
    sb.append("\n    externalMixed: ").append(toIndentedString(externalMixed));
    sb.append("\n    integerEnum: ").append(toIndentedString(integerEnum));
    sb.append("\n    stringIntegerEnum: ").append(toIndentedString(stringIntegerEnum));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
