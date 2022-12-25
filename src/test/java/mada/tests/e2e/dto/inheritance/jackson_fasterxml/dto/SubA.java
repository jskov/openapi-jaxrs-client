/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.inheritance.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * SubA
 */
@JsonPropertyOrder({
  SubA.JSON_PROPERTY_BAR
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SubA extends Super implements SubASubB {
  public static final String JSON_PROPERTY_BAR = "bar";
  @JsonProperty(JSON_PROPERTY_BAR)
  private Integer bar;

  public SubA bar(Integer bar) {
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
    if (!(o instanceof SubA)) {
      return false;
    }
    SubA other = (SubA) o;
    return Objects.equals(this.bar, other.bar) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bar, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubA {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    bar: ").append(toIndentedString(bar));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
