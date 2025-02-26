/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Kontanthandelsgaranti
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Kontanthandelsgaranti {
  public static final String JSON_PROPERTY_AFDRAG_DATO = "afdragDato";
  @JsonProperty(JSON_PROPERTY_AFDRAG_DATO)
  @JsonDeserialize(using = mada.tests.support.serializers.CustomLocalDateDeserializer.class)
  @JsonSerialize(using = mada.tests.support.serializers.CustomLocalDateSerializer.class)
  @Schema(description = "Dato for næste afvikling")
  private LocalDate afdragDato;

  public static final String JSON_PROPERTY_EJENDOM = "ejendom";
  @JsonProperty(JSON_PROPERTY_EJENDOM)
  private EjendomMini ejendom;

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

  public Kontanthandelsgaranti afdragDato(LocalDate afdragDato) {
    this.afdragDato = afdragDato;
    return this;
  }

  /**
   * Dato for næste afvikling.
   *
   * @return afdragDato
   **/
  public LocalDate getAfdragDato() {
    return afdragDato;
  }

  public void setAfdragDato(LocalDate afdragDato) {
    this.afdragDato = afdragDato;
  }

  public Kontanthandelsgaranti ejendom(EjendomMini ejendom) {
    this.ejendom = ejendom;
    return this;
  }

  /**
   * Get ejendom
   * @return ejendom
   **/
  @Valid
  public EjendomMini getEjendom() {
    return ejendom;
  }

  public void setEjendom(EjendomMini ejendom) {
    this.ejendom = ejendom;
  }

  public Kontanthandelsgaranti omkostning(Omkostning omkostning) {
    this.omkostning = omkostning;
    return this;
  }

  /**
   * Get omkostning
   * @return omkostning
   **/
  @Valid
  public Omkostning getOmkostning() {
    return omkostning;
  }

  public void setOmkostning(Omkostning omkostning) {
    this.omkostning = omkostning;
  }

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
    return Objects.equals(this.afdragDato, other.afdragDato) &&
        Objects.equals(this.ejendom, other.ejendom) &&
        Objects.equals(this.omkostning, other.omkostning) &&
        Objects.equals(this.prodnr, other.prodnr) &&
        Objects.equals(this.refnr, other.refnr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(afdragDato, ejendom, omkostning, prodnr, refnr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Kontanthandelsgaranti {");
    sb.append("\n    afdragDato: ").append(toIndentedString(afdragDato));
    sb.append("\n    ejendom: ").append(toIndentedString(ejendom));
    sb.append("\n    omkostning: ").append(toIndentedString(omkostning));
    sb.append("\n    prodnr: ").append(toIndentedString(prodnr));
    sb.append("\n    refnr: ").append(toIndentedString(refnr));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
