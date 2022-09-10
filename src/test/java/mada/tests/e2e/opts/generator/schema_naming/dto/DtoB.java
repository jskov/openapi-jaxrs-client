/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.schema_naming.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * DtoB
 */
@JsonbPropertyOrder({
  DtoB.JSON_PROPERTY_MEMBER_B
})
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
    if (o == null || getClass() != o.getClass()) {
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
