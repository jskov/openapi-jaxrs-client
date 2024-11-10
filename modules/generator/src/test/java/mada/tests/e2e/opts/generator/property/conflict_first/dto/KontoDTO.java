/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.opts.generator.property.conflict_first.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * KontoDTO
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class KontoDTO extends FacilitetDTO {
    public static final String JSON_PROPERTY_AENDRING = "aendring";
    @JsonProperty(JSON_PROPERTY_AENDRING)
    private String aendring;

    public KontoDTO aendring(String aendring) {
        this.aendring = aendring;
        return this;
    }

    /**
     * Get aendring
     *
     * @return aendring
     **/
    public String getAendring() {
        return aendring;
    }

    public void setAendring(String aendring) {
        this.aendring = aendring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KontoDTO)) {
            return false;
        }
        KontoDTO other = (KontoDTO) o;
        return Objects.equals(this.aendring, other.aendring) &&
              super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aendring, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KontoDTO {");
        sb.append("\n    ").append(toIndentedString(super.toString()));
        sb.append("\n    aendring: ").append(toIndentedString(aendring));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
