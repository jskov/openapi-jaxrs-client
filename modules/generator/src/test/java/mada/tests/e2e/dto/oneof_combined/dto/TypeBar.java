/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.dto.oneof_combined.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * TypeBar
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TypeBar {
  public static final String JSON_PROPERTY_VALUE_BAR_STRING = "valueBarString";
  @JsonProperty(JSON_PROPERTY_VALUE_BAR_STRING)
  private String valueBarString;

  public static final String JSON_PROPERTY_VALUE_INTEGER = "valueInteger";
  @JsonProperty(JSON_PROPERTY_VALUE_INTEGER)
  private Integer valueInteger;

  public static final String JSON_PROPERTY_VALUE_STRING = "valueString";
  @JsonProperty(JSON_PROPERTY_VALUE_STRING)
  private String valueString;

  public TypeBar valueBarString(String valueBarString) {
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

  public TypeBar valueInteger(Integer valueInteger) {
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

  public TypeBar valueString(String valueString) {
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
    if (!(o instanceof TypeBar)) {
      return false;
    }
    TypeBar other = (TypeBar) o;
    return Objects.equals(this.valueBarString, other.valueBarString) &&
        Objects.equals(this.valueInteger, other.valueInteger) &&
        Objects.equals(this.valueString, other.valueString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueBarString, valueInteger, valueString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TypeBar {");
    sb.append("\n    valueBarString: ").append(toIndentedString(valueBarString));
    sb.append("\n    valueInteger: ").append(toIndentedString(valueInteger));
    sb.append("\n    valueString: ").append(toIndentedString(valueString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
