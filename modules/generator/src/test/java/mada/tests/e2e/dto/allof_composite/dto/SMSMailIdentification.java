/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * SMSMailIdentification
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SMSMailIdentification {
  public static final String JSON_PROPERTY_COUNTRY_CODE = "countryCode";
  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @Schema(description = "DA: Landekode for telefonnummeret<br/>The country code of the phone number", example = "45")
  private String countryCode;

  public static final String JSON_PROPERTY_LOCKED = "locked";
  @JsonProperty(JSON_PROPERTY_LOCKED)
  @Schema(readOnly = true, description = "If identification is protected by a secret, this field is true.<br>When true the following operations can only be done when the known secret is supplied in header x-locked-secret.<ul><li>PATCH of contact with a different identification type than already set.</li></ul>")
  private Boolean locked;

  public static final String JSON_PROPERTY_LOGIN_ID = "loginId";
  @JsonProperty(JSON_PROPERTY_LOGIN_ID)
  @Schema(readOnly = true, description = "DA: Login id<br/>Login id, from the security token.")
  private String loginId;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @Schema(description = "DA: Telefonnummer til brug ved SMS login<br/>The phone number to use for SMS login. Maximum of 30 digits excluding spaces allowed.", example = "12345678")
  private String phoneNumber;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonProperty(JSON_PROPERTY_TYPE)
  @Schema(required = true)
  private IdentificationType type;

  public SMSMailIdentification countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * DA: Landekode for telefonnummeret<br/>The country code of the phone number.
   *
   * @return countryCode
   **/
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public SMSMailIdentification locked(Boolean locked) {
    this.locked = locked;
    return this;
  }

  /**
   * If identification is protected by a secret, this field is true.<br>When true the following operations can only be done when the known secret is supplied in header x-locked-secret.<ul><li>PATCH of contact with a different identification type than already set.</li></ul>
   *
   * @return locked
   **/
  public Boolean isLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public SMSMailIdentification loginId(String loginId) {
    this.loginId = loginId;
    return this;
  }

  /**
   * DA: Login id<br/>Login id, from the security token.
   *
   * @return loginId
   **/
  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public SMSMailIdentification phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * DA: Telefonnummer til brug ved SMS login<br/>The phone number to use for SMS login. Maximum of 30 digits excluding spaces allowed.
   *
   * @return phoneNumber
   **/
  @Size(max = 40)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public SMSMailIdentification type(IdentificationType type) {
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
    if (!(o instanceof SMSMailIdentification)) {
      return false;
    }
    SMSMailIdentification other = (SMSMailIdentification) o;
    return Objects.equals(this.countryCode, other.countryCode) &&
        Objects.equals(this.locked, other.locked) &&
        Objects.equals(this.loginId, other.loginId) &&
        Objects.equals(this.phoneNumber, other.phoneNumber) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, locked, loginId, phoneNumber, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SMSMailIdentification {");
    sb.append("\n    countryCode: ").append(toIndentedString(countryCode));
    sb.append("\n    locked: ").append(toIndentedString(locked));
    sb.append("\n    loginId: ").append(toIndentedString(loginId));
    sb.append("\n    phoneNumber: ").append(toIndentedString(phoneNumber));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
