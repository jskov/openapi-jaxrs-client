/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.validation.allof.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * OwnerDTO
 */
@JsonbPropertyOrder({
  OwnerDTO.JSON_PROPERTY_AD_GROUP,
  OwnerDTO.JSON_PROPERTY_EMAIL
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class OwnerDTO {
  public static final String JSON_PROPERTY_AD_GROUP = "ad-group";
  @JsonbProperty(JSON_PROPERTY_AD_GROUP)
  @Schema(required = true)
  private String adGroup;

  public static final String JSON_PROPERTY_EMAIL = "email";
  @JsonbProperty(JSON_PROPERTY_EMAIL)
  @Schema(required = true)
  private String email;

  public OwnerDTO adGroup(String adGroup) {
    this.adGroup = Objects.requireNonNull(adGroup, "Property adGroup is required, cannot be null");
    return this;
  }

  /**
   * Get adGroup
   * @return adGroup
   **/
  @NotNull @Size(min = 1, max = 100)
  public String getAdGroup() {
    return adGroup;
  }

  public void setAdGroup(String adGroup) {
    this.adGroup = Objects.requireNonNull(adGroup, "Property adGroup is required, cannot be null");
  }

  public OwnerDTO email(String email) {
    this.email = Objects.requireNonNull(email, "Property email is required, cannot be null");
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @NotNull @Size(min = 1, max = 100)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = Objects.requireNonNull(email, "Property email is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OwnerDTO other = (OwnerDTO) o;
    return Objects.equals(this.adGroup, other.adGroup) &&
        Objects.equals(this.email, other.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adGroup, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OwnerDTO {");
    sb.append("\n    adGroup: ").append(toIndentedString(adGroup));
    sb.append("\n    email: ").append(toIndentedString(email));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
