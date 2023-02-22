/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * WithRef
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class WithRef {
  public static final String JSON_PROPERTY_REF_TO_ABSTRACT = "refToAbstract";
  @JsonProperty(JSON_PROPERTY_REF_TO_ABSTRACT)
  private Object refToAbstract;

  public WithRef refToAbstract(Object refToAbstract) {
    this.refToAbstract = refToAbstract;
    return this;
  }

  /**
   * Get refToAbstract
   * @return refToAbstract
   **/
  public Object getRefToAbstract() {
    return refToAbstract;
  }

  public void setRefToAbstract(Object refToAbstract) {
    this.refToAbstract = refToAbstract;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WithRef)) {
      return false;
    }
    WithRef other = (WithRef) o;
    return Objects.equals(this.refToAbstract, other.refToAbstract);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refToAbstract);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WithRef {");
    sb.append("\n    refToAbstract: ").append(toIndentedString(refToAbstract));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
