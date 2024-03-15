/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: 1.0.0+openapi_API_Version
 */

package mada.tests.e2e.dto.discriminator_invalid.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * SMSMailIdentification
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SMSMailIdentification extends Identification {
  public static final String JSON_PROPERTY_COUNTRY_CODE = "countryCode";
  @JsonbProperty(JSON_PROPERTY_COUNTRY_CODE)
  private String countryCode;

  public SMSMailIdentification countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
   **/
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SMSMailIdentification)) {
      return false;
    }
    SMSMailIdentification other = (SMSMailIdentification) o;
    return Objects.equals(this.countryCode, other.countryCode) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SMSMailIdentification {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n    countryCode: ").append(toIndentedString(countryCode));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
