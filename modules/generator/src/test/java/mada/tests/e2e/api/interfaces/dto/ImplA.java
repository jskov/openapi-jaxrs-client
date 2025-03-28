/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.api.interfaces.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * ImplA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ImplA implements BadNameImplB_BadName_ImplA_ImplA_ImplB {
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
    if (!(o instanceof ImplA)) {
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
