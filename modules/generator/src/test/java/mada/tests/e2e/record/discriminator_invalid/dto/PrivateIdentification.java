/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: 1.0.0+openapi_API_Version
 */

package mada.tests.e2e.record.discriminator_invalid.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * PrivateIdentification
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class PrivateIdentification extends Identification {
  public static final String JSON_PROPERTY_SEVEN_FIRST_CPR_DIGITS = "sevenFirstCprDigits";
  @JsonbProperty(JSON_PROPERTY_SEVEN_FIRST_CPR_DIGITS)
  private String sevenFirstCprDigits;

  public PrivateIdentification sevenFirstCprDigits(String sevenFirstCprDigits) {
    this.sevenFirstCprDigits = sevenFirstCprDigits;
    return this;
  }

  /**
   * Get sevenFirstCprDigits
   * @return sevenFirstCprDigits
   **/
  public String getSevenFirstCprDigits() {
    return sevenFirstCprDigits;
  }

  public void setSevenFirstCprDigits(String sevenFirstCprDigits) {
    this.sevenFirstCprDigits = sevenFirstCprDigits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PrivateIdentification)) {
      return false;
    }
    PrivateIdentification other = (PrivateIdentification) o;
    return Objects.equals(this.sevenFirstCprDigits, other.sevenFirstCprDigits) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sevenFirstCprDigits, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrivateIdentification {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    sevenFirstCprDigits: ").append(toIndentedString(sevenFirstCprDigits));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
