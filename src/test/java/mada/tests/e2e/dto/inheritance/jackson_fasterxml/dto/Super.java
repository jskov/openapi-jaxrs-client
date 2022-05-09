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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

/**
 * Super
 */
@JsonPropertyOrder({
  Super.JSON_PROPERTY_IMPL_DISCRIMINATOR,
  Super.JSON_PROPERTY_SUPER_VALUE
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "implDiscriminator", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = SubA.class, name = "subtype-A"),
  @JsonSubTypes.Type(value = SubB.class, name = "subtype-B"),
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class Super {
  public static final String JSON_PROPERTY_IMPL_DISCRIMINATOR = "implDiscriminator";
  @JsonProperty(JSON_PROPERTY_IMPL_DISCRIMINATOR)
  private String implDiscriminator;

  public static final String JSON_PROPERTY_SUPER_VALUE = "superValue";
  @JsonProperty(JSON_PROPERTY_SUPER_VALUE)
  private Integer superValue;

  public Super implDiscriminator(String implDiscriminator) {
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

  public Super superValue(Integer superValue) {
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Super other = (Super) o;
    return Objects.equals(this.implDiscriminator, other.implDiscriminator) &&
        Objects.equals(this.superValue, other.superValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(implDiscriminator, superValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Super {");
    sb.append("\n    implDiscriminator: ").append(toIndentedString(implDiscriminator));
    sb.append("\n    superValue: ").append(toIndentedString(superValue));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
