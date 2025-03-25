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
 * ImplA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ImplA implements ImplA_ImplB {
  public static final String JSON_PROPERTY_FOO = "foo";
  @JsonbProperty(JSON_PROPERTY_FOO)
  private Integer foo;

  public static final String JSON_PROPERTY_IMPL_NAME = "implName";
  @JsonbProperty(JSON_PROPERTY_IMPL_NAME)
  private String implName;

  public ImplA foo(Integer foo) {
    this.foo = foo;
    return this;
  }

  /**
   * Get foo
   * @return foo
   **/
  public Integer getFoo() {
    return foo;
  }

  public void setFoo(Integer foo) {
    this.foo = foo;
  }

  public ImplA implName(String implName) {
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
    if (!(o instanceof ImplA)) {
      return false;
    }
    ImplA other = (ImplA) o;
    return Objects.equals(this.foo, other.foo) &&
        Objects.equals(this.implName, other.implName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(foo, implName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImplA {");
    sb.append("\n    foo: ").append(toIndentedString(foo));
    sb.append("\n    implName: ").append(toIndentedString(implName));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
