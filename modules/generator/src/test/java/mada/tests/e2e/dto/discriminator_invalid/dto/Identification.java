/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: 1.0.0+openapi_API_Version
 */

package mada.tests.e2e.dto.discriminator_invalid.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Identification
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public abstract class Identification {
  public static final String JSON_PROPERTY_LOCKED = "locked";
  @JsonbProperty(JSON_PROPERTY_LOCKED)
  @Schema(readOnly = true)
  private Boolean locked;

  public static final String JSON_PROPERTY_LOGIN_ID = "loginId";
  @JsonbProperty(JSON_PROPERTY_LOGIN_ID)
  @Schema(readOnly = true)
  private String loginId;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @Schema(required = true)
  private IdentificationType type;

  public Identification locked(Boolean locked) {
    this.locked = locked;
    return this;
  }

  /**
   * Get locked
   * @return locked
   **/
  public Boolean isLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public Identification loginId(String loginId) {
    this.loginId = loginId;
    return this;
  }

  /**
   * Get loginId
   * @return loginId
   **/
  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public Identification type(IdentificationType type) {
    this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @NotNull @Valid
  public IdentificationType getType() {
    return type;
  }

  public void setType(IdentificationType type) {
    this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Identification)) {
      return false;
    }
    Identification other = (Identification) o;
    return Objects.equals(this.locked, other.locked) &&
        Objects.equals(this.loginId, other.loginId) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locked, loginId, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identification {");
    sb.append("\n    locked: ").append(toIndentedString(locked));
    sb.append("\n    loginId: ").append(toIndentedString(loginId));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
