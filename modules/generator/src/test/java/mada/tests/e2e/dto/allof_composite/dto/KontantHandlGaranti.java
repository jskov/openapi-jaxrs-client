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
import javax.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * KontantHandlGaranti
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class KontantHandlGaranti {
    public static final String JSON_PROPERTY_AFSENDER_NGL = "afsenderNgl";
    @JsonProperty(JSON_PROPERTY_AFSENDER_NGL)
    private String afsenderNgl;

    public static final String JSON_PROPERTY_EJENDOM = "ejendom";
    @JsonProperty(JSON_PROPERTY_EJENDOM)
    private EjendomMini ejendom;

    public static final String JSON_PROPERTY_KUNDE_REFNR = "kundeRefnr";
    @JsonProperty(JSON_PROPERTY_KUNDE_REFNR)
    private Integer kundeRefnr;

    public static final String JSON_PROPERTY_OMKOSTNING = "omkostning";
    @JsonProperty(JSON_PROPERTY_OMKOSTNING)
    private Omkostning omkostning;

    public static final String JSON_PROPERTY_PRODNR = "prodnr";
    @JsonProperty(JSON_PROPERTY_PRODNR)
    @Schema(required = true, description = "Description prodnr in Kontanthandelsgaranti")
    private Integer prodnr;

    public static final String JSON_PROPERTY_REFNR = "refnr";
    @JsonProperty(JSON_PROPERTY_REFNR)
    @Schema(required = true, description = "Description refnr in Kontanthandelsgaranti")
    private Integer refnr;

    public static final String JSON_PROPERTY_SAGSTYPE = "sagstype";
    @JsonProperty(JSON_PROPERTY_SAGSTYPE)
    private Integer sagstype;

    public KontantHandlGaranti afsenderNgl(String afsenderNgl) {
        this.afsenderNgl = afsenderNgl;
        return this;
    }

    /**
     * Get afsenderNgl
     *
     * @return afsenderNgl
     **/
    public String getAfsenderNgl() {
        return afsenderNgl;
    }

    public void setAfsenderNgl(String afsenderNgl) {
        this.afsenderNgl = afsenderNgl;
    }

    public KontantHandlGaranti ejendom(EjendomMini ejendom) {
        this.ejendom = ejendom;
        return this;
    }

    /**
     * Get ejendom
     *
     * @return ejendom
     **/
    @Valid
    public EjendomMini getEjendom() {
        return ejendom;
    }

    public void setEjendom(EjendomMini ejendom) {
        this.ejendom = ejendom;
    }

    public KontantHandlGaranti kundeRefnr(Integer kundeRefnr) {
        this.kundeRefnr = kundeRefnr;
        return this;
    }

    /**
     * Get kundeRefnr
     *
     * @return kundeRefnr
     **/
    public Integer getKundeRefnr() {
        return kundeRefnr;
    }

    public void setKundeRefnr(Integer kundeRefnr) {
        this.kundeRefnr = kundeRefnr;
    }

    public KontantHandlGaranti omkostning(Omkostning omkostning) {
        this.omkostning = omkostning;
        return this;
    }

    /**
     * Get omkostning
     *
     * @return omkostning
     **/
    @Valid
    public Omkostning getOmkostning() {
        return omkostning;
    }

    public void setOmkostning(Omkostning omkostning) {
        this.omkostning = omkostning;
    }

    public KontantHandlGaranti prodnr(Integer prodnr) {
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

    public KontantHandlGaranti refnr(Integer refnr) {
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

    public KontantHandlGaranti sagstype(Integer sagstype) {
        this.sagstype = sagstype;
        return this;
    }

    /**
     * Get sagstype
     *
     * @return sagstype
     **/
    public Integer getSagstype() {
        return sagstype;
    }

    public void setSagstype(Integer sagstype) {
        this.sagstype = sagstype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KontantHandlGaranti)) {
            return false;
        }
        KontantHandlGaranti other = (KontantHandlGaranti) o;
        return Objects.equals(this.afsenderNgl, other.afsenderNgl) &&
                Objects.equals(this.ejendom, other.ejendom) &&
                Objects.equals(this.kundeRefnr, other.kundeRefnr) &&
                Objects.equals(this.omkostning, other.omkostning) &&
                Objects.equals(this.prodnr, other.prodnr) &&
                Objects.equals(this.refnr, other.refnr) &&
                Objects.equals(this.sagstype, other.sagstype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(afsenderNgl, ejendom, kundeRefnr, omkostning, prodnr, refnr, sagstype);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KontantHandlGaranti {");
        sb.append("\n    afsenderNgl: ").append(toIndentedString(afsenderNgl));
        sb.append("\n    ejendom: ").append(toIndentedString(ejendom));
        sb.append("\n    kundeRefnr: ").append(toIndentedString(kundeRefnr));
        sb.append("\n    omkostning: ").append(toIndentedString(omkostning));
        sb.append("\n    prodnr: ").append(toIndentedString(prodnr));
        sb.append("\n    refnr: ").append(toIndentedString(refnr));
        sb.append("\n    sagstype: ").append(toIndentedString(sagstype));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
