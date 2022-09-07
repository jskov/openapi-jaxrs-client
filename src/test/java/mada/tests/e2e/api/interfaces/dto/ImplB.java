/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.interfaces.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * ImplB
 */
@JsonbPropertyOrder({
  ImplB.JSON_PROPERTY_BAR
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ImplB implements ImplAImplB {
  public static final String JSON_PROPERTY_BAR = "bar";
  @JsonbProperty(JSON_PROPERTY_BAR)
  private Integer bar;

  public ImplB bar(Integer bar) {
    this.bar = bar;
    return this;
  }

  /**
   * Get bar
   * @return bar
   **/
  public Integer getBar() {
    return bar;
  }

  public void setBar(Integer bar) {
    this.bar = bar;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImplB other = (ImplB) o;
    return Objects.equals(this.bar, other.bar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImplB {");
    sb.append("\n    bar: ").append(toIndentedString(bar));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
