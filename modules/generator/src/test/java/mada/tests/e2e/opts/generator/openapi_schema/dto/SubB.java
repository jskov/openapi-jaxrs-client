/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.openapi_schema.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * SubB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SubB extends Super {
  public static final String JSON_PROPERTY_FOO = "foo";
  @JsonbProperty(JSON_PROPERTY_FOO)
  private Integer foo;

  public SubB foo(Integer foo) {
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
    if (!(o instanceof SubB)) {
      return false;
    }
    SubB other = (SubB) o;
    return Objects.equals(this.foo, other.foo) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(foo, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubB {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    foo: ").append(toIndentedString(foo));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
