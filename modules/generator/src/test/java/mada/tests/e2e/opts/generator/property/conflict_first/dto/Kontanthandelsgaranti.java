/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.opts.generator.property.conflict_first.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Kontanthandelsgaranti
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Kontanthandelsgaranti {
    public static final String JSON_PROPERTY_PRODNR = "prodnr";
    @JsonProperty(JSON_PROPERTY_PRODNR)
    @Schema(required = true, description = "Description prodnr in Kontanthandelsgaranti")
    private Integer prodnr;

    public static final String JSON_PROPERTY_REFNR = "refnr";
    @JsonProperty(JSON_PROPERTY_REFNR)
    @Schema(required = true, description = "Description refnr in Kontanthandelsgaranti")
    private Integer refnr;

    public Kontanthandelsgaranti prodnr(Integer prodnr) {
        this.prodnr = Objects.requireNonNull(prodnr, "Property prodnr is required, cannot be null");
        return this;
    }

    /**
     * Description prodnr in Kontanthandelsgaranti.
     * 
     * @return prodnr
     **/
    @NotNull @Pattern(regexp = "^\\d{1,5}$")
    public Integer getProdnr() {
        return prodnr;
    }

    public void setProdnr(Integer prodnr) {
        this.prodnr = Objects.requireNonNull(prodnr, "Property prodnr is required, cannot be null");
    }

    public Kontanthandelsgaranti refnr(Integer refnr) {
        this.refnr = Objects.requireNonNull(refnr, "Property refnr is required, cannot be null");
        return this;
    }

    /**
     * Description refnr in Kontanthandelsgaranti.
     * 
     * @return refnr
     **/
    @NotNull @Pattern(regexp = "^\\d{1,7}$")
    public Integer getRefnr() {
        return refnr;
    }

    public void setRefnr(Integer refnr) {
        this.refnr = Objects.requireNonNull(refnr, "Property refnr is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Kontanthandelsgaranti)) {
            return false;
        }
        Kontanthandelsgaranti other = (Kontanthandelsgaranti) o;
        return Objects.equals(this.prodnr, other.prodnr) &&
                Objects.equals(this.refnr, other.refnr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodnr, refnr);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Kontanthandelsgaranti {");
        sb.append("\n    prodnr: ").append(toIndentedString(prodnr));
        sb.append("\n    refnr: ").append(toIndentedString(refnr));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
