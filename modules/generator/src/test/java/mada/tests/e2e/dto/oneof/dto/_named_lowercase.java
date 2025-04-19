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
 * _named_lowercase
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _named_lowercase extends AbstractTypeBySchemaName {
  public static final String JSON_PROPERTY_VALUE_STRING = "valueString";
  @JsonProperty(JSON_PROPERTY_VALUE_STRING)
  private String valueString;

  public _named_lowercase valueString(String valueString) {
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
    if (!(o instanceof _named_lowercase)) {
      return false;
    }
    _named_lowercase other = (_named_lowercase) o;
    return Objects.equals(this.valueString, other.valueString) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueString, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class _named_lowercase {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    valueString: ").append(toIndentedString(valueString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
