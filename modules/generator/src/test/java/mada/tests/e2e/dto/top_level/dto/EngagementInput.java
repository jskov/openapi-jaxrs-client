/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.top_level.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Input for creating engagement for existing legal entity.
 */
@Schema(description = "Input for creating engagement for existing legal entity")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EngagementInput {
  public static final String JSON_PROPERTY_ADDRESS_PROTECTION = "addressProtection";
  @JsonbProperty(JSON_PROPERTY_ADDRESS_PROTECTION)
  @Schema(description = "Protected address")
  private Boolean addressProtection;

  public EngagementInput addressProtection(Boolean addressProtection) {
    this.addressProtection = addressProtection;
    return this;
  }

  /**
   * Protected address.
   *
   * @return addressProtection
   **/
  public Boolean isAddressProtection() {
    return addressProtection;
  }

  public void setAddressProtection(Boolean addressProtection) {
    this.addressProtection = addressProtection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EngagementInput)) {
      return false;
    }
    EngagementInput other = (EngagementInput) o;
    return Objects.equals(this.addressProtection, other.addressProtection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressProtection);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EngagementInput {");
    sb.append("\n    addressProtection: ").append(toIndentedString(addressProtection));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
