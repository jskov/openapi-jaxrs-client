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
 * Account information.
 */
@Schema(description = "Account information")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Account {
    public static final String JSON_PROPERTY_REGISTRATION_NUMBER = "registrationNumber";
    @JsonbProperty(JSON_PROPERTY_REGISTRATION_NUMBER)
    private Short registrationNumber;

    public Account registrationNumber(Short registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    /**
     * Get registrationNumber
     *
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
        if (!(o instanceof Account)) {
            return false;
        }
        Account other = (Account) o;
        return Objects.equals(this.registrationNumber, other.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {");
        sb.append("\n    registrationNumber: ").append(toIndentedString(registrationNumber));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
