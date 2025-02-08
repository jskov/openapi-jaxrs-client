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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * DtoE
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class DtoE {
  public static final String JSON_PROPERTY_MEMBER_IN_E = "member-in-E";
  @JsonbProperty(JSON_PROPERTY_MEMBER_IN_E)
  @Schema(required = true, description = "enum in E")
  private EnumDescription memberInE;

  public DtoE memberInE(EnumDescription memberInE) {
    this.memberInE = Objects.requireNonNull(memberInE, "Property memberInE is required, cannot be null");
    return this;
  }

  /**
   * enum in E.
   *
   * @return memberInE
   **/
  @NotNull @Valid
  public EnumDescription getMemberInE() {
    return memberInE;
  }

  public void setMemberInE(EnumDescription memberInE) {
    this.memberInE = Objects.requireNonNull(memberInE, "Property memberInE is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DtoE)) {
      return false;
    }
    DtoE other = (DtoE) o;
    return Objects.equals(this.memberInE, other.memberInE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberInE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DtoE {");
    sb.append("\n    memberInE: ").append(toIndentedString(memberInE));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
