/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.api.responses_ref.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * CustomerDetailsResponse
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CustomerDetailsResponse {
  public static final String JSON_PROPERTY_GUARDIANSHIP = "guardianship";
  @JsonbProperty(JSON_PROPERTY_GUARDIANSHIP)
  private String guardianship;

  public CustomerDetailsResponse guardianship(String guardianship) {
    this.guardianship = guardianship;
    return this;
  }

  /**
   * Get guardianship
   * @return guardianship
   **/
  public String getGuardianship() {
    return guardianship;
  }

  public void setGuardianship(String guardianship) {
    this.guardianship = guardianship;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CustomerDetailsResponse)) {
      return false;
    }
    CustomerDetailsResponse other = (CustomerDetailsResponse) o;
    return Objects.equals(this.guardianship, other.guardianship);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guardianship);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDetailsResponse {");
    sb.append("\n    guardianship: ").append(toIndentedString(guardianship));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
