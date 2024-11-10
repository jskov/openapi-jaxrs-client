/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: 1.0.0+openapi_API_Version
 */

package mada.tests.e2e.record.discriminator_invalid.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import org.jspecify.annotations.NullUnmarked;

/**
 * VirkPersonIdentification
 */
@NullUnmarked
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class VirkPersonIdentification extends Identification {
    public static final String JSON_PROPERTY_VIRK_UNIT_NUMBER = "virkUnitNumber";
    @JsonbProperty(JSON_PROPERTY_VIRK_UNIT_NUMBER)
    private String virkUnitNumber;

    public VirkPersonIdentification virkUnitNumber(String virkUnitNumber) {
        this.virkUnitNumber = virkUnitNumber;
        return this;
    }

    /**
     * Get virkUnitNumber
     *
     * @return virkUnitNumber
     **/
    public String getVirkUnitNumber() {
        return virkUnitNumber;
    }

    public void setVirkUnitNumber(String virkUnitNumber) {
        this.virkUnitNumber = virkUnitNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VirkPersonIdentification)) {
            return false;
        }
        VirkPersonIdentification other = (VirkPersonIdentification) o;
        return Objects.equals(this.virkUnitNumber, other.virkUnitNumber) &&
              super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(virkUnitNumber, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VirkPersonIdentification {");
        sb.append("\n    ").append(toIndentedString(super.toString()));
        sb.append("\n    virkUnitNumber: ").append(toIndentedString(virkUnitNumber));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
