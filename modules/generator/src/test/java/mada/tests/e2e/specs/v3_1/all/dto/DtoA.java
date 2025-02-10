/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * DtoA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class DtoA {
  public static final String JSON_PROPERTY_MEMBER_A = "memberA";
  @JsonbProperty(JSON_PROPERTY_MEMBER_A)
  private Boolean memberA;

  public static final String JSON_PROPERTY_REF_B = "refB";
  @JsonbProperty(JSON_PROPERTY_REF_B)
  @Schema(description = "ref to object")
  private DtoB refB;

  public static final String JSON_PROPERTY_REF_E = "refE";
  @JsonbProperty(JSON_PROPERTY_REF_E)
  private DtoE refE;

  public DtoA memberA(Boolean memberA) {
    this.memberA = memberA;
    return this;
  }

  /**
   * Get memberA
   * @return memberA
   **/
  public Boolean isMemberA() {
    return memberA;
  }

  public void setMemberA(Boolean memberA) {
    this.memberA = memberA;
  }

  public DtoA refB(DtoB refB) {
    this.refB = refB;
    return this;
  }

  /**
   * ref to object.
   *
   * @return refB
   **/
  @Valid
  public DtoB getRefB() {
    return refB;
  }

  public void setRefB(DtoB refB) {
    this.refB = refB;
  }

  public DtoA refE(DtoE refE) {
    this.refE = refE;
    return this;
  }

  /**
   * Get refE
   * @return refE
   **/
  @Valid
  public DtoE getRefE() {
    return refE;
  }

  public void setRefE(DtoE refE) {
    this.refE = refE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DtoA)) {
      return false;
    }
    DtoA other = (DtoA) o;
    return Objects.equals(this.memberA, other.memberA) &&
        Objects.equals(this.refB, other.refB) &&
        Objects.equals(this.refE, other.refE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberA, refB, refE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DtoA {");
    sb.append("\n    memberA: ").append(toIndentedString(memberA));
    sb.append("\n    refB: ").append(toIndentedString(refB));
    sb.append("\n    refE: ").append(toIndentedString(refE));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
