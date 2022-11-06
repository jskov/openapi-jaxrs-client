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
  SubA.JSON_PROPERTY_IMPL_DISCRIMINATOR,
  SubA.JSON_PROPERTY_SUPER_VALUE,
  SubA.JSON_PROPERTY_BAR
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SubA implements SubASubB {
  public static final String JSON_PROPERTY_IMPL_DISCRIMINATOR = "implDiscriminator";
  @JsonProperty(JSON_PROPERTY_IMPL_DISCRIMINATOR)
  private String implDiscriminator;

  public static final String JSON_PROPERTY_SUPER_VALUE = "superValue";
  @JsonProperty(JSON_PROPERTY_SUPER_VALUE)
  private Integer superValue;

  public static final String JSON_PROPERTY_BAR = "bar";
  @JsonProperty(JSON_PROPERTY_BAR)
  private Integer bar;

  public SubA implDiscriminator(String implDiscriminator) {
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

  public SubA superValue(Integer superValue) {
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
    return Objects.equals(this.implDiscriminator, other.implDiscriminator) &&
        Objects.equals(this.superValue, other.superValue) &&
        Objects.equals(this.bar, other.bar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(implDiscriminator, superValue, bar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubA {");
    sb.append("\n    implDiscriminator: ").append(toIndentedString(implDiscriminator));
    sb.append("\n    superValue: ").append(toIndentedString(superValue));
    sb.append("\n    bar: ").append(toIndentedString(bar));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
