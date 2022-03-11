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
 * ImplA
 */
@JsonbPropertyOrder({
  ImplA.JSON_PROPERTY_FOO
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class ImplA implements ImplAImplB  {
  public static final String JSON_PROPERTY_FOO = "foo";
  @JsonbProperty(JSON_PROPERTY_FOO)
  private Integer foo;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImplA other = (ImplA) o;
    return Objects.equals(this.foo, other.foo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(foo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImplA {");
    sb.append("\n    foo: ").append(toIndentedString(foo));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
