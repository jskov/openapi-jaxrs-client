/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.regression.alloflookup.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Request body for interest rate fixation.
 */
@Schema(description = "Request body for interest rate fixation")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class InterestRateFixationRequest {
  public static final String JSON_PROPERTY_LOAN_TYPE = "loanType";
  @JsonbProperty(JSON_PROPERTY_LOAN_TYPE)
  private String loanType;

  public static final String JSON_PROPERTY_REGISTRATION_NUMBER = "registrationNumber";
  @JsonbProperty(JSON_PROPERTY_REGISTRATION_NUMBER)
  private Short registrationNumber;

  public InterestRateFixationRequest loanType(String loanType) {
    this.loanType = loanType;
    return this;
  }

  /**
   * Get loanType
   * @return loanType
   **/
  public String getLoanType() {
    return loanType;
  }

  public void setLoanType(String loanType) {
    this.loanType = loanType;
  }

  public InterestRateFixationRequest registrationNumber(Short registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

  /**
   * Get registrationNumber
   * @return registrationNumber
   **/
  public Short getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(Short registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InterestRateFixationRequest)) {
      return false;
    }
    InterestRateFixationRequest other = (InterestRateFixationRequest) o;
    return Objects.equals(this.loanType, other.loanType) &&
        Objects.equals(this.registrationNumber, other.registrationNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loanType, registrationNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterestRateFixationRequest {");
    sb.append("\n    loanType: ").append(toIndentedString(loanType));
    sb.append("\n    registrationNumber: ").append(toIndentedString(registrationNumber));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
