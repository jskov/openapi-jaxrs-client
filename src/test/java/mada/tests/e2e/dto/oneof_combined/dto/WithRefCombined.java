/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof_combined.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * WithRefCombined
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class WithRefCombined {
  public static final String JSON_PROPERTY_VALUE_BAR_STRING = "valueBarString";
  @JsonProperty(JSON_PROPERTY_VALUE_BAR_STRING)
  @Schema(nullable = true)
  private String valueBarString;

  public static final String JSON_PROPERTY_VALUE_FOO_LONG = "valueFooLong";
  @JsonProperty(JSON_PROPERTY_VALUE_FOO_LONG)
  @Schema(nullable = true)
  private Long valueFooLong;

  public static final String JSON_PROPERTY_VALUE_INTEGER = "valueInteger";
  @JsonProperty(JSON_PROPERTY_VALUE_INTEGER)
  @Schema(nullable = true)
  private Integer valueInteger;

  public static final String JSON_PROPERTY_VALUE_STRING = "valueString";
  @JsonProperty(JSON_PROPERTY_VALUE_STRING)
  @Schema(nullable = true)
  private String valueString;

  public WithRefCombined valueBarString(String valueBarString) {
    this.valueBarString = valueBarString;
    return this;
  }

  /**
   * Get valueBarString
   * @return valueBarString
   **/
  public String getValueBarString() {
    return valueBarString;
  }

  public void setValueBarString(String valueBarString) {
    this.valueBarString = valueBarString;
  }

  public WithRefCombined valueFooLong(Long valueFooLong) {
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

  public WithRefCombined valueInteger(Integer valueInteger) {
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

  public WithRefCombined valueString(String valueString) {
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
    if (!(o instanceof WithRefCombined)) {
      return false;
    }
    WithRefCombined other = (WithRefCombined) o;
    return Objects.equals(this.valueBarString, other.valueBarString) &&
        Objects.equals(this.valueFooLong, other.valueFooLong) &&
        Objects.equals(this.valueInteger, other.valueInteger) &&
        Objects.equals(this.valueString, other.valueString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueBarString, valueFooLong, valueInteger, valueString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WithRefCombined {");
    sb.append("\n    valueBarString: ").append(toIndentedString(valueBarString));
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
