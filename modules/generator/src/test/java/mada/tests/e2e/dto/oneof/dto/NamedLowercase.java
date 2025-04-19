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

/**
 * NamedLowercase
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class NamedLowercase {
  public static final String JSON_PROPERTY_VALUE_STRING = "valueString";
  @JsonProperty(JSON_PROPERTY_VALUE_STRING)
  private String valueString;

  public NamedLowercase valueString(String valueString) {
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
    if (!(o instanceof NamedLowercase)) {
      return false;
    }
    NamedLowercase other = (NamedLowercase) o;
    return Objects.equals(this.valueString, other.valueString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NamedLowercase {");
    sb.append("\n    valueString: ").append(toIndentedString(valueString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
