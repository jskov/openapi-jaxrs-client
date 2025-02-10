/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * TypeBar
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TypeBar extends AbstractType {
  public static final String JSON_PROPERTY_VALUE_BAR_STRING = "valueBarString";
  @JsonbProperty(JSON_PROPERTY_VALUE_BAR_STRING)
  @Schema(required = true)
  private String valueBarString;

  public TypeBar valueBarString(String valueBarString) {
    this.valueBarString = Objects.requireNonNull(valueBarString, "Property valueBarString is required, cannot be null");
    return this;
  }

  /**
   * Get valueBarString
   * @return valueBarString
   **/
  @NotNull
  public String getValueBarString() {
    return valueBarString;
  }

  public void setValueBarString(String valueBarString) {
    this.valueBarString = Objects.requireNonNull(valueBarString, "Property valueBarString is required, cannot be null");
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
        super.equals(o);
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
    sb.append("\n    valueBarString: ").append(toIndentedString(valueBarString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
