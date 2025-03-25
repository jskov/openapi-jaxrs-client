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
 * BadName_ImplA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class BadName_ImplA {
  public static final String JSON_PROPERTY_FOO = "foo";
  @JsonbProperty(JSON_PROPERTY_FOO)
  private Integer foo;

  public BadName_ImplA foo(Integer foo) {
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
    if (!(o instanceof BadName_ImplA)) {
      return false;
    }
    BadName_ImplA other = (BadName_ImplA) o;
    return Objects.equals(this.foo, other.foo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(foo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadName_ImplA {");
    sb.append("\n    foo: ").append(toIndentedString(foo));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
