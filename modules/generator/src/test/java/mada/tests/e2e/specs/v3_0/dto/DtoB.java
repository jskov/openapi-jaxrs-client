/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.specs.v3_0.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * DtoB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class DtoB {
  public static final String JSON_PROPERTY_MEMBER_B = "memberB";
  @JsonbProperty(JSON_PROPERTY_MEMBER_B)
  private Integer memberB;

  public DtoB memberB(Integer memberB) {
    this.memberB = memberB;
    return this;
  }

  /**
   * Get memberB
   * @return memberB
   **/
  public Integer getMemberB() {
    return memberB;
  }

  public void setMemberB(Integer memberB) {
    this.memberB = memberB;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DtoB)) {
      return false;
    }
    DtoB other = (DtoB) o;
    return Objects.equals(this.memberB, other.memberB);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberB);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DtoB {");
    sb.append("\n    memberB: ").append(toIndentedString(memberB));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
