/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * DA: Virk.dk registreret person-id. <br/>Virk.dk registered personId
 */
@Schema(description = "DA: Virk.dk registreret person-id. <br/>Virk.dk registered personId")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class VirkPersonIdentification extends Identification {
  public static final String JSON_PROPERTY_VIRK_UNIT_NUMBER = "virkUnitNumber";
  @JsonProperty(JSON_PROPERTY_VIRK_UNIT_NUMBER)
  @Schema(description = "DA: Virk.dk person id<br/>The id for a person at virk.dk")
  private String virkUnitNumber;

  public VirkPersonIdentification virkUnitNumber(String virkUnitNumber) {
    this.virkUnitNumber = virkUnitNumber;
    return this;
  }

  /**
   * DA: Virk.dk person id<br/>The id for a person at virk.dk
   *
   * @return virkUnitNumber
   **/
  public String getVirkUnitNumber() {
    return virkUnitNumber;
  }

  public void setVirkUnitNumber(String virkUnitNumber) {
    this.virkUnitNumber = virkUnitNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof VirkPersonIdentification)) {
      return false;
    }
    VirkPersonIdentification other = (VirkPersonIdentification) o;
    return Objects.equals(this.virkUnitNumber, other.virkUnitNumber) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(virkUnitNumber, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirkPersonIdentification {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    virkUnitNumber: ").append(toIndentedString(virkUnitNumber));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
