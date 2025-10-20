/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.additional_properties.dto;

import java.util.HashMap;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * FreeFormObject
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class FreeFormObject extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_ADDITIONAL_PROPERTY = "additional-property";
  @JsonbProperty(JSON_PROPERTY_ADDITIONAL_PROPERTY)
  private String additionalProperty;

  public FreeFormObject additionalProperty(String additionalProperty) {
    this.additionalProperty = additionalProperty;
    return this;
  }

  /**
   * Get additionalProperty
   * @return additionalProperty
   **/
  public String getAdditionalProperty() {
    return additionalProperty;
  }

  public void setAdditionalProperty(String additionalProperty) {
    this.additionalProperty = additionalProperty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FreeFormObject)) {
      return false;
    }
    FreeFormObject other = (FreeFormObject) o;
    return Objects.equals(this.additionalProperty, other.additionalProperty) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalProperty, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FreeFormObject {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    additionalProperty: ").append(toIndentedString(additionalProperty));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
