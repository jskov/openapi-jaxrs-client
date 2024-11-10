/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * StamOpl
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class StamOpl {
    public static final String JSON_PROPERTY_AFSENDER_NGL = "afsenderNgl";
    @JsonProperty(JSON_PROPERTY_AFSENDER_NGL)
    @Schema(description = "Description afsenderNgl in StamOpl")
    private String afsenderNgl;

    public static final String JSON_PROPERTY_KUNDE_REFNR = "kundeRefnr";
    @JsonProperty(JSON_PROPERTY_KUNDE_REFNR)
    @Schema(required = true, description = "Description kundeRefnr in StamOpl")
    private Integer kundeRefnr;

    public StamOpl afsenderNgl(String afsenderNgl) {
        this.afsenderNgl = afsenderNgl;
        return this;
    }

    /**
     * Description afsenderNgl in StamOpl.
     * 
     * @return afsenderNgl
     **/
    public String getAfsenderNgl() {
        return afsenderNgl;
    }

    public void setAfsenderNgl(String afsenderNgl) {
        this.afsenderNgl = afsenderNgl;
    }

    public StamOpl kundeRefnr(Integer kundeRefnr) {
        this.kundeRefnr = Objects.requireNonNull(kundeRefnr, "Property kundeRefnr is required, cannot be null");
        return this;
    }

    /**
     * Description kundeRefnr in StamOpl.
     * 
     * @return kundeRefnr
     **/
    @NotNull @Size(max = 7)
    public Integer getKundeRefnr() {
        return kundeRefnr;
    }

    public void setKundeRefnr(Integer kundeRefnr) {
        this.kundeRefnr = Objects.requireNonNull(kundeRefnr, "Property kundeRefnr is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StamOpl)) {
            return false;
        }
        StamOpl other = (StamOpl) o;
        return Objects.equals(this.afsenderNgl, other.afsenderNgl) &&
                Objects.equals(this.kundeRefnr, other.kundeRefnr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(afsenderNgl, kundeRefnr);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StamOpl {");
        sb.append("\n    afsenderNgl: ").append(toIndentedString(afsenderNgl));
        sb.append("\n    kundeRefnr: ").append(toIndentedString(kundeRefnr));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
