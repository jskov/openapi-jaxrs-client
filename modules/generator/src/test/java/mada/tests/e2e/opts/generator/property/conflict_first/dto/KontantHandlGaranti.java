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
 * KontantHandlGaranti
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class KontantHandlGaranti {
  public static final String JSON_PROPERTY_AFSENDER_NGL = "afsenderNgl";
  @JsonProperty(JSON_PROPERTY_AFSENDER_NGL)
  @Schema(required = true, description = "Description afsenderNgl in KontantHandlGaranti")
  private String afsenderNgl;

  public static final String JSON_PROPERTY_KUNDE_REFNR = "kundeRefnr";
  @JsonProperty(JSON_PROPERTY_KUNDE_REFNR)
  @Schema(description = "Description kundeRefnr in KontantHandlGaranti")
  private Integer kundeRefnr;

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
    this.afsenderNgl = Objects.requireNonNull(afsenderNgl, "Property afsenderNgl is required, cannot be null");
    return this;
  }

  /**
   * Description afsenderNgl in KontantHandlGaranti.
   *
   * @return afsenderNgl
   **/
  @NotNull
  public String getAfsenderNgl() {
    return afsenderNgl;
  }

  public void setAfsenderNgl(String afsenderNgl) {
    this.afsenderNgl = Objects.requireNonNull(afsenderNgl, "Property afsenderNgl is required, cannot be null");
  }

  public KontantHandlGaranti kundeRefnr(Integer kundeRefnr) {
    this.kundeRefnr = kundeRefnr;
    return this;
  }

  /**
   * Description kundeRefnr in KontantHandlGaranti.
   *
   * @return kundeRefnr
   **/
  public Integer getKundeRefnr() {
    return kundeRefnr;
  }

  public void setKundeRefnr(Integer kundeRefnr) {
    this.kundeRefnr = kundeRefnr;
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
        Objects.equals(this.kundeRefnr, other.kundeRefnr) &&
        Objects.equals(this.prodnr, other.prodnr) &&
        Objects.equals(this.refnr, other.refnr) &&
        Objects.equals(this.sagstype, other.sagstype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(afsenderNgl, kundeRefnr, prodnr, refnr, sagstype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KontantHandlGaranti {");
    sb.append("\n    afsenderNgl: ").append(toIndentedString(afsenderNgl));
    sb.append("\n    kundeRefnr: ").append(toIndentedString(kundeRefnr));
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
