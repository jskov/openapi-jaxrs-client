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
 * SubB
 */
@JsonPropertyOrder({
  SubB.JSON_PROPERTY_IMPL_DISCRIMINATOR,
  SubB.JSON_PROPERTY_SUPER_VALUE,
  SubB.JSON_PROPERTY_FOO
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SubB implements SubASubB {
  public static final String JSON_PROPERTY_FOO = "foo";
  @JsonProperty(JSON_PROPERTY_FOO)
  private Integer foo;

  public static final String JSON_PROPERTY_IMPL_DISCRIMINATOR = "implDiscriminator";
  @JsonProperty(JSON_PROPERTY_IMPL_DISCRIMINATOR)
  private String implDiscriminator;

  public static final String JSON_PROPERTY_SUPER_VALUE = "superValue";
  @JsonProperty(JSON_PROPERTY_SUPER_VALUE)
  private Integer superValue;

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

  public SubB implDiscriminator(String implDiscriminator) {
    this.implDiscriminator = implDiscriminator;
    return this;
  }

  /**
   * Get implDiscriminator
   * @return implDiscriminator
   **/
  public String getImplDiscriminator() {
    return implDiscriminator;
  }

  public void setImplDiscriminator(String implDiscriminator) {
    this.implDiscriminator = implDiscriminator;
  }

  public SubB superValue(Integer superValue) {
    this.superValue = superValue;
    return this;
  }

  /**
   * Get superValue
   * @return superValue
   **/
  public Integer getSuperValue() {
    return superValue;
  }

  public void setSuperValue(Integer superValue) {
    this.superValue = superValue;
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
        Objects.equals(this.implDiscriminator, other.implDiscriminator) &&
        Objects.equals(this.superValue, other.superValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(foo, implDiscriminator, superValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubB {");
    sb.append("\n    foo: ").append(toIndentedString(foo));
    sb.append("\n    implDiscriminator: ").append(toIndentedString(implDiscriminator));
    sb.append("\n    superValue: ").append(toIndentedString(superValue));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
