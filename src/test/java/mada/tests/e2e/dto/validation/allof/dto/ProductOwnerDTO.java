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
 * ProductOwnerDTO
 */
@JsonbPropertyOrder({
  ProductOwnerDTO.JSON_PROPERTY_EMAIL,
  ProductOwnerDTO.JSON_PROPERTY_NAME,
  ProductOwnerDTO.JSON_PROPERTY_USER_ID
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ProductOwnerDTO {
  public static final String JSON_PROPERTY_EMAIL = "email";
  @JsonbProperty(JSON_PROPERTY_EMAIL)
  @Schema(required = true)
  private String email;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(required = true)
  private String name;

  public static final String JSON_PROPERTY_USER_ID = "user-id";
  @JsonbProperty(JSON_PROPERTY_USER_ID)
  @Schema(required = true)
  private String userId;

  public ProductOwnerDTO email(String email) {
    this.email = Objects.requireNonNull(email, "Property email is required, cannot be null");
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @NotNull @Size(min = 1, max = 150)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = Objects.requireNonNull(email, "Property email is required, cannot be null");
  }

  public ProductOwnerDTO name(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @NotNull @Size(min = 1, max = 300)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
  }

  public ProductOwnerDTO userId(String userId) {
    this.userId = Objects.requireNonNull(userId, "Property userId is required, cannot be null");
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @NotNull @Size(min = 1, max = 100)
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = Objects.requireNonNull(userId, "Property userId is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductOwnerDTO)) {
      return false;
    }
    ProductOwnerDTO other = (ProductOwnerDTO) o;
    return Objects.equals(this.email, other.email) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.userId, other.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOwnerDTO {");
    sb.append("\n    email: ").append(toIndentedString(email));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    userId: ").append(toIndentedString(userId));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
