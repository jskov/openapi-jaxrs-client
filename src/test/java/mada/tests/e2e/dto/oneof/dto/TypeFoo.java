/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;
import javax.validation.Valid;

/**
 * TypeFoo
 */
@JsonPropertyOrder({
  TypeFoo.JSON_PROPERTY_VALUE_ENUM,
  TypeFoo.JSON_PROPERTY_VALUE_INTEGER,
  TypeFoo.JSON_PROPERTY_VALUE_STRING,
  TypeFoo.JSON_PROPERTY_VALUE_FOO_LONG
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TypeFoo {
  public static final String JSON_PROPERTY_VALUE_ENUM = "valueEnum";
  @JsonProperty(JSON_PROPERTY_VALUE_ENUM)
  private OtherEnum valueEnum;

  public static final String JSON_PROPERTY_VALUE_FOO_LONG = "valueFooLong";
  @JsonProperty(JSON_PROPERTY_VALUE_FOO_LONG)
  private Long valueFooLong;

  public static final String JSON_PROPERTY_VALUE_INTEGER = "valueInteger";
  @JsonProperty(JSON_PROPERTY_VALUE_INTEGER)
  private Integer valueInteger;

  public static final String JSON_PROPERTY_VALUE_STRING = "valueString";
  @JsonProperty(JSON_PROPERTY_VALUE_STRING)
  private String valueString;

  public TypeFoo valueEnum(OtherEnum valueEnum) {
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

  public TypeFoo valueFooLong(Long valueFooLong) {
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

  public TypeFoo valueInteger(Integer valueInteger) {
    this.valueInteger = valueInteger;
    return this;
  }

  /**
   * Get valueInteger
   * @return valueInteger
   **/
  public Integer getValueInteger() {
    return valueInteger;
  }

  public void setValueInteger(Integer valueInteger) {
    this.valueInteger = valueInteger;
  }

  public TypeFoo valueString(String valueString) {
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
    if (!(o instanceof TypeFoo)) {
      return false;
    }
    TypeFoo other = (TypeFoo) o;
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
    sb.append("class TypeFoo {");
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
