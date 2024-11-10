/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * SMSMailIdentification
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SMSMailIdentification extends Identification {
    public static final String JSON_PROPERTY_COUNTRY_CODE = "countryCode";
    @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
    @Schema(description = "DA: Landekode for telefonnummeret<br/>The country code of the phone number", example = "45")
    private String countryCode;

    public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";
    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    @Schema(description = "DA: Telefonnummer til brug ved SMS login<br/>The phone number to use for SMS login. Maximum of 30 digits excluding spaces allowed.", example = "12345678")
    private String phoneNumber;

    public SMSMailIdentification countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * DA: Landekode for telefonnummeret<br/>The country code of the phone number.
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public SMSMailIdentification phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * DA: Telefonnummer til brug ved SMS login<br/>The phone number to use for SMS login. Maximum of 30 digits excluding
   * spaces allowed.
     * @return phoneNumber
     **/
    public @Size(max = 40) String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
                Objects.equals(this.phoneNumber, other.phoneNumber) &&
              super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, phoneNumber, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SMSMailIdentification {");
        sb.append("\n    ").append(toIndentedString(super.toString()));
        sb.append("\n    countryCode: ").append(toIndentedString(countryCode));
        sb.append("\n    phoneNumber: ").append(toIndentedString(phoneNumber));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
