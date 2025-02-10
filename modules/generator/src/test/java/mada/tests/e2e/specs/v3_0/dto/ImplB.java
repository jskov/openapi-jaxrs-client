/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * ImplB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ImplB implements ImplAImplB {
  public static final String JSON_PROPERTY_BAR = "bar";
  @JsonbProperty(JSON_PROPERTY_BAR)
  private Integer bar;

  public static final String JSON_PROPERTY_IMPL_NAME = "implName";
  @JsonbProperty(JSON_PROPERTY_IMPL_NAME)
  private String implName;

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

  public ImplB implName(String implName) {
    this.implName = implName;
    return this;
  }

  /**
   * Get implName
   * @return implName
   **/
  public String getImplName() {
    return implName;
  }

  public void setImplName(String implName) {
    this.implName = implName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ImplB)) {
      return false;
    }
    ImplB other = (ImplB) o;
    return Objects.equals(this.bar, other.bar) &&
        Objects.equals(this.implName, other.implName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bar, implName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImplB {");
    sb.append("\n    bar: ").append(toIndentedString(bar));
    sb.append("\n    implName: ").append(toIndentedString(implName));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
