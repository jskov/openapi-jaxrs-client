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

/**
 * TypeFoo
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TypeFoo extends AbstractType {
  public static final String JSON_PROPERTY_VALUE_FOO_LONG = "valueFooLong";
  @JsonbProperty(JSON_PROPERTY_VALUE_FOO_LONG)
  private Long valueFooLong;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TypeFoo)) {
      return false;
    }
    TypeFoo other = (TypeFoo) o;
    return Objects.equals(this.valueFooLong, other.valueFooLong) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueFooLong, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TypeFoo {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    valueFooLong: ").append(toIndentedString(valueFooLong));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
