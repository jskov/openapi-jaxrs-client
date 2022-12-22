/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * TypeBar
 */
@JsonPropertyOrder({
  TypeBar.JSON_PROPERTY_VALUE_ENUM,
  TypeBar.JSON_PROPERTY_VALUE_INTEGER,
  TypeBar.JSON_PROPERTY_VALUE_STRING,
  TypeBar.JSON_PROPERTY_VALUE_BAR_STRING
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TypeBar extends AbstractType {
  public static final String JSON_PROPERTY_VALUE_BAR_STRING = "valueBarString";
  @JsonProperty(JSON_PROPERTY_VALUE_BAR_STRING)
  private String valueBarString;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TypeBar)) {
      return false;
    }
    TypeBar other = (TypeBar) o;
    return super.equals(o) &&
    		Objects.equals(this.valueBarString, other.valueBarString);
    
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueBarString, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TypeBar {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
