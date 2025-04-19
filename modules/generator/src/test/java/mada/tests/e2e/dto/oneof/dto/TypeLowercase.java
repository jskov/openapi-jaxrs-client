/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.dto.oneof.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * TypeLowercase
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TypeLowercase {
  public static final String JSON_PROPERTY_VALUE_ENUM = "valueEnum";
  @JsonProperty(JSON_PROPERTY_VALUE_ENUM)
  private OtherEnum valueEnum;

  public static final String JSON_PROPERTY_VALUE_FOO_LONG = "valueFooLong";
  @JsonProperty(JSON_PROPERTY_VALUE_FOO_LONG)
  private Long valueFooLong;

  public static final String JSON_PROPERTY_VALUE_INTEGER = "valueInteger";
  @JsonProperty(JSON_PROPERTY_VALUE_INTEGER)
  @Schema(required = true)
  private Integer valueInteger;

  public static final String JSON_PROPERTY_VALUE_STRING = "valueString";
  @JsonProperty(JSON_PROPERTY_VALUE_STRING)
  private String valueString;

  public TypeLowercase valueEnum(OtherEnum valueEnum) {
    this.valueEnum = valueEnum;
    return this;
  }

  /**
   * Get valueEnum
   * @return valueEnum
   **/
  @Valid
  public OtherEnum getValueEnum() {
    return valueEnum;
  }

  public void setValueEnum(OtherEnum valueEnum) {
    this.valueEnum = valueEnum;
  }

  public TypeLowercase valueFooLong(Long valueFooLong) {
    this.valueFooLong = valueFooLong;
    return this;
  }

  /**
   * Get valueFooLong
   * @return valueFooLong
   **/
  public Long getValueFooLong() {
    return valueFooLong;
  }

  public void setValueFooLong(Long valueFooLong) {
    this.valueFooLong = valueFooLong;
  }

  public TypeLowercase valueInteger(Integer valueInteger) {
    this.valueInteger = Objects.requireNonNull(valueInteger, "Property valueInteger is required, cannot be null");
    return this;
  }

  /**
   * Get valueInteger
   * @return valueInteger
   **/
  @NotNull
  public Integer getValueInteger() {
    return valueInteger;
  }

  public void setValueInteger(Integer valueInteger) {
    this.valueInteger = Objects.requireNonNull(valueInteger, "Property valueInteger is required, cannot be null");
  }

  public TypeLowercase valueString(String valueString) {
    this.valueString = valueString;
    return this;
  }

  /**
   * Get valueString
   * @return valueString
   **/
  public String getValueString() {
    return valueString;
  }

  public void setValueString(String valueString) {
    this.valueString = valueString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TypeLowercase)) {
      return false;
    }
    TypeLowercase other = (TypeLowercase) o;
    return Objects.equals(this.valueEnum, other.valueEnum) &&
        Objects.equals(this.valueFooLong, other.valueFooLong) &&
        Objects.equals(this.valueInteger, other.valueInteger) &&
        Objects.equals(this.valueString, other.valueString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueEnum, valueFooLong, valueInteger, valueString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TypeLowercase {");
    sb.append("\n    valueEnum: ").append(toIndentedString(valueEnum));
    sb.append("\n    valueFooLong: ").append(toIndentedString(valueFooLong));
    sb.append("\n    valueInteger: ").append(toIndentedString(valueInteger));
    sb.append("\n    valueString: ").append(toIndentedString(valueString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
