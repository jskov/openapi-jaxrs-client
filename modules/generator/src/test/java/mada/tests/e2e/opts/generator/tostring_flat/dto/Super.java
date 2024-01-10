/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.tostring_flat.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Super
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public abstract class Super {
  public static final String JSON_PROPERTY_IMPL_DISCRIMINATOR = "implDiscriminator";
  @JsonbProperty(JSON_PROPERTY_IMPL_DISCRIMINATOR)
  private String implDiscriminator;

  public static final String JSON_PROPERTY_SUPER_VALUE = "superValue";
  @JsonbProperty(JSON_PROPERTY_SUPER_VALUE)
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
    if (!(o instanceof Super)) {
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
    sb.append("Super {");
    sb.append("implDiscriminator: ").append(toSingleLineString(implDiscriminator));
    sb.append(", ").append("superValue: ").append(toSingleLineString(superValue));
    sb.append("}");
    return sb.toString();
  }

  private String toSingleLineString(Object o) {
    return Objects.toString(o).replace("\n", "\\n").replace("\r", "\\r");
  }
}
