/*
 * jboss-helloworld
 *
 * The version of the OpenAPI document: 1.0
 */

package mada.tests.e2e.dto.allof_dups.dto;

import java.math.BigDecimal;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * AfregningCalculationResponse
 */
@JsonbPropertyOrder({
  AfregningCalculationResponse.JSON_PROPERTY_LAAN_NR,
  AfregningCalculationResponse.JSON_PROPERTY_PRODUKT_AFTALE_NR,
  AfregningCalculationResponse.JSON_PROPERTY_INDFRIELSES_METODE,
  AfregningCalculationResponse.JSON_PROPERTY_INDFRIELSES_DATO,
  AfregningCalculationResponse.JSON_PROPERTY_LAAN_RESTGAELD,
  AfregningCalculationResponse.JSON_PROPERTY_OBL_RESTGAELD,
  AfregningCalculationResponse.JSON_PROPERTY_RESTGAELDS_DATO,
  AfregningCalculationResponse.JSON_PROPERTY_OPSIGELSES_DATO,
  AfregningCalculationResponse.JSON_PROPERTY_OPSIGELSES_FRIST,
  AfregningCalculationResponse.JSON_PROPERTY_FORFALD,
  AfregningCalculationResponse.JSON_PROPERTY_INDFRIELSES_KURS,
  AfregningCalculationResponse.JSON_PROPERTY_INDFRIELSESKURS_TYPE,
  AfregningCalculationResponse.JSON_PROPERTY_KURSVAERDI,
  AfregningCalculationResponse.JSON_PROPERTY_GODTGOERELSESRENTE,
  AfregningCalculationResponse.JSON_PROPERTY_INDFRIELSES_BELOEB,
  AfregningCalculationResponse.JSON_PROPERTY_OMKOSTNINGER
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AfregningCalculationResponse {
  public static final String JSON_PROPERTY_LAAN_NR = "LaanNr";
  @JsonbProperty(JSON_PROPERTY_LAAN_NR)
  private Long laanNr;

  public static final String JSON_PROPERTY_PRODUKT_AFTALE_NR = "ProduktAftaleNr";
  @JsonbProperty(JSON_PROPERTY_PRODUKT_AFTALE_NR)
  private Long produktAftaleNr;

  public static final String JSON_PROPERTY_INDFRIELSES_METODE = "IndfrielsesMetode";
  @JsonbProperty(JSON_PROPERTY_INDFRIELSES_METODE)
  private String indfrielsesMetode;

  public static final String JSON_PROPERTY_INDFRIELSES_DATO = "IndfrielsesDato";
  @JsonbProperty(JSON_PROPERTY_INDFRIELSES_DATO)
  private String indfrielsesDato;

  public static final String JSON_PROPERTY_LAAN_RESTGAELD = "LaanRestgaeld";
  @JsonbProperty(JSON_PROPERTY_LAAN_RESTGAELD)
  private BigDecimal laanRestgaeld;

  public static final String JSON_PROPERTY_OBL_RESTGAELD = "OblRestgaeld";
  @JsonbProperty(JSON_PROPERTY_OBL_RESTGAELD)
  private BigDecimal oblRestgaeld;

  public static final String JSON_PROPERTY_RESTGAELDS_DATO = "RestgaeldsDato";
  @JsonbProperty(JSON_PROPERTY_RESTGAELDS_DATO)
  private String restgaeldsDato;

  public static final String JSON_PROPERTY_OPSIGELSES_DATO = "OpsigelsesDato";
  @JsonbProperty(JSON_PROPERTY_OPSIGELSES_DATO)
  private String opsigelsesDato;

  public static final String JSON_PROPERTY_OPSIGELSES_FRIST = "OpsigelsesFrist";
  @JsonbProperty(JSON_PROPERTY_OPSIGELSES_FRIST)
  private String opsigelsesFrist;

  public static final String JSON_PROPERTY_FORFALD = "Forfald";
  @JsonbProperty(JSON_PROPERTY_FORFALD)
  private Boolean forfald;

  public static final String JSON_PROPERTY_INDFRIELSES_KURS = "IndfrielsesKurs";
  @JsonbProperty(JSON_PROPERTY_INDFRIELSES_KURS)
  private BigDecimal indfrielsesKurs;

  public static final String JSON_PROPERTY_INDFRIELSESKURS_TYPE = "IndfrielseskursType";
  @JsonbProperty(JSON_PROPERTY_INDFRIELSESKURS_TYPE)
  private String indfrielseskursType;

  public static final String JSON_PROPERTY_KURSVAERDI = "Kursvaerdi";
  @JsonbProperty(JSON_PROPERTY_KURSVAERDI)
  private BigDecimal kursvaerdi;

  public static final String JSON_PROPERTY_GODTGOERELSESRENTE = "Godtgoerelsesrente";
  @JsonbProperty(JSON_PROPERTY_GODTGOERELSESRENTE)
  private BigDecimal godtgoerelsesrente;

  public static final String JSON_PROPERTY_INDFRIELSES_BELOEB = "IndfrielsesBeloeb";
  @JsonbProperty(JSON_PROPERTY_INDFRIELSES_BELOEB)
  private Double indfrielsesBeloeb;

  public static final String JSON_PROPERTY_OMKOSTNINGER = "Omkostninger";
  @JsonbProperty(JSON_PROPERTY_OMKOSTNINGER)
  private Omkostninger omkostninger;

  public AfregningCalculationResponse laanNr(Long laanNr) {
    this.laanNr = laanNr;
    return this;
  }

  /**
   * Get laanNr
   * @return laanNr
   **/
  public Long getLaanNr() {
    return laanNr;
  }

  public void setLaanNr(Long laanNr) {
    this.laanNr = laanNr;
  }

  public AfregningCalculationResponse produktAftaleNr(Long produktAftaleNr) {
    this.produktAftaleNr = produktAftaleNr;
    return this;
  }

  /**
   * Get produktAftaleNr
   * @return produktAftaleNr
   **/
  public Long getProduktAftaleNr() {
    return produktAftaleNr;
  }

  public void setProduktAftaleNr(Long produktAftaleNr) {
    this.produktAftaleNr = produktAftaleNr;
  }

  public AfregningCalculationResponse indfrielsesMetode(String indfrielsesMetode) {
    this.indfrielsesMetode = indfrielsesMetode;
    return this;
  }

  /**
   * Get indfrielsesMetode
   * @return indfrielsesMetode
   **/
  public String getIndfrielsesMetode() {
    return indfrielsesMetode;
  }

  public void setIndfrielsesMetode(String indfrielsesMetode) {
    this.indfrielsesMetode = indfrielsesMetode;
  }

  public AfregningCalculationResponse indfrielsesDato(String indfrielsesDato) {
    this.indfrielsesDato = indfrielsesDato;
    return this;
  }

  /**
   * Get indfrielsesDato
   * @return indfrielsesDato
   **/
  public String getIndfrielsesDato() {
    return indfrielsesDato;
  }

  public void setIndfrielsesDato(String indfrielsesDato) {
    this.indfrielsesDato = indfrielsesDato;
  }

  public AfregningCalculationResponse laanRestgaeld(BigDecimal laanRestgaeld) {
    this.laanRestgaeld = laanRestgaeld;
    return this;
  }

  /**
   * Get laanRestgaeld
   * @return laanRestgaeld
   **/
  public BigDecimal getLaanRestgaeld() {
    return laanRestgaeld;
  }

  public void setLaanRestgaeld(BigDecimal laanRestgaeld) {
    this.laanRestgaeld = laanRestgaeld;
  }

  public AfregningCalculationResponse oblRestgaeld(BigDecimal oblRestgaeld) {
    this.oblRestgaeld = oblRestgaeld;
    return this;
  }

  /**
   * Get oblRestgaeld
   * @return oblRestgaeld
   **/
  public BigDecimal getOblRestgaeld() {
    return oblRestgaeld;
  }

  public void setOblRestgaeld(BigDecimal oblRestgaeld) {
    this.oblRestgaeld = oblRestgaeld;
  }

  public AfregningCalculationResponse restgaeldsDato(String restgaeldsDato) {
    this.restgaeldsDato = restgaeldsDato;
    return this;
  }

  /**
   * Get restgaeldsDato
   * @return restgaeldsDato
   **/
  public String getRestgaeldsDato() {
    return restgaeldsDato;
  }

  public void setRestgaeldsDato(String restgaeldsDato) {
    this.restgaeldsDato = restgaeldsDato;
  }

  public AfregningCalculationResponse opsigelsesDato(String opsigelsesDato) {
    this.opsigelsesDato = opsigelsesDato;
    return this;
  }

  /**
   * Get opsigelsesDato
   * @return opsigelsesDato
   **/
  public String getOpsigelsesDato() {
    return opsigelsesDato;
  }

  public void setOpsigelsesDato(String opsigelsesDato) {
    this.opsigelsesDato = opsigelsesDato;
  }

  public AfregningCalculationResponse opsigelsesFrist(String opsigelsesFrist) {
    this.opsigelsesFrist = opsigelsesFrist;
    return this;
  }

  /**
   * Get opsigelsesFrist
   * @return opsigelsesFrist
   **/
  public String getOpsigelsesFrist() {
    return opsigelsesFrist;
  }

  public void setOpsigelsesFrist(String opsigelsesFrist) {
    this.opsigelsesFrist = opsigelsesFrist;
  }

  public AfregningCalculationResponse forfald(Boolean forfald) {
    this.forfald = forfald;
    return this;
  }

  /**
   * Get forfald
   * @return forfald
   **/
  public Boolean isForfald() {
    return forfald;
  }

  public void setForfald(Boolean forfald) {
    this.forfald = forfald;
  }

  public AfregningCalculationResponse indfrielsesKurs(BigDecimal indfrielsesKurs) {
    this.indfrielsesKurs = indfrielsesKurs;
    return this;
  }

  /**
   * Get indfrielsesKurs
   * @return indfrielsesKurs
   **/
  public BigDecimal getIndfrielsesKurs() {
    return indfrielsesKurs;
  }

  public void setIndfrielsesKurs(BigDecimal indfrielsesKurs) {
    this.indfrielsesKurs = indfrielsesKurs;
  }

  public AfregningCalculationResponse indfrielseskursType(String indfrielseskursType) {
    this.indfrielseskursType = indfrielseskursType;
    return this;
  }

  /**
   * Get indfrielseskursType
   * @return indfrielseskursType
   **/
  public String getIndfrielseskursType() {
    return indfrielseskursType;
  }

  public void setIndfrielseskursType(String indfrielseskursType) {
    this.indfrielseskursType = indfrielseskursType;
  }

  public AfregningCalculationResponse kursvaerdi(BigDecimal kursvaerdi) {
    this.kursvaerdi = kursvaerdi;
    return this;
  }

  /**
   * Get kursvaerdi
   * @return kursvaerdi
   **/
  public BigDecimal getKursvaerdi() {
    return kursvaerdi;
  }

  public void setKursvaerdi(BigDecimal kursvaerdi) {
    this.kursvaerdi = kursvaerdi;
  }

  public AfregningCalculationResponse godtgoerelsesrente(BigDecimal godtgoerelsesrente) {
    this.godtgoerelsesrente = godtgoerelsesrente;
    return this;
  }

  /**
   * Get godtgoerelsesrente
   * @return godtgoerelsesrente
   **/
  public BigDecimal getGodtgoerelsesrente() {
    return godtgoerelsesrente;
  }

  public void setGodtgoerelsesrente(BigDecimal godtgoerelsesrente) {
    this.godtgoerelsesrente = godtgoerelsesrente;
  }

  public AfregningCalculationResponse indfrielsesBeloeb(Double indfrielsesBeloeb) {
    this.indfrielsesBeloeb = indfrielsesBeloeb;
    return this;
  }

  /**
   * Get indfrielsesBeloeb
   * @return indfrielsesBeloeb
   **/
  public Double getIndfrielsesBeloeb() {
    return indfrielsesBeloeb;
  }

  public void setIndfrielsesBeloeb(Double indfrielsesBeloeb) {
    this.indfrielsesBeloeb = indfrielsesBeloeb;
  }

  public AfregningCalculationResponse omkostninger(Omkostninger omkostninger) {
    this.omkostninger = omkostninger;
    return this;
  }

  /**
   * Get omkostninger
   * @return omkostninger
   **/
  public Omkostninger getOmkostninger() {
    return omkostninger;
  }

  public void setOmkostninger(Omkostninger omkostninger) {
    this.omkostninger = omkostninger;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AfregningCalculationResponse other = (AfregningCalculationResponse) o;
    return Objects.equals(this.laanNr, other.laanNr) &&
        Objects.equals(this.produktAftaleNr, other.produktAftaleNr) &&
        Objects.equals(this.indfrielsesMetode, other.indfrielsesMetode) &&
        Objects.equals(this.indfrielsesDato, other.indfrielsesDato) &&
        Objects.equals(this.laanRestgaeld, other.laanRestgaeld) &&
        Objects.equals(this.oblRestgaeld, other.oblRestgaeld) &&
        Objects.equals(this.restgaeldsDato, other.restgaeldsDato) &&
        Objects.equals(this.opsigelsesDato, other.opsigelsesDato) &&
        Objects.equals(this.opsigelsesFrist, other.opsigelsesFrist) &&
        Objects.equals(this.forfald, other.forfald) &&
        Objects.equals(this.indfrielsesKurs, other.indfrielsesKurs) &&
        Objects.equals(this.indfrielseskursType, other.indfrielseskursType) &&
        Objects.equals(this.kursvaerdi, other.kursvaerdi) &&
        Objects.equals(this.godtgoerelsesrente, other.godtgoerelsesrente) &&
        Objects.equals(this.indfrielsesBeloeb, other.indfrielsesBeloeb) &&
        Objects.equals(this.omkostninger, other.omkostninger);
  }

  @Override
  public int hashCode() {
    return Objects.hash(laanNr, produktAftaleNr, indfrielsesMetode, indfrielsesDato, laanRestgaeld, oblRestgaeld, restgaeldsDato, opsigelsesDato, opsigelsesFrist, forfald, indfrielsesKurs, indfrielseskursType, kursvaerdi, godtgoerelsesrente, indfrielsesBeloeb, omkostninger);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AfregningCalculationResponse {");
    sb.append("\n    laanNr: ").append(toIndentedString(laanNr));
    sb.append("\n    produktAftaleNr: ").append(toIndentedString(produktAftaleNr));
    sb.append("\n    indfrielsesMetode: ").append(toIndentedString(indfrielsesMetode));
    sb.append("\n    indfrielsesDato: ").append(toIndentedString(indfrielsesDato));
    sb.append("\n    laanRestgaeld: ").append(toIndentedString(laanRestgaeld));
    sb.append("\n    oblRestgaeld: ").append(toIndentedString(oblRestgaeld));
    sb.append("\n    restgaeldsDato: ").append(toIndentedString(restgaeldsDato));
    sb.append("\n    opsigelsesDato: ").append(toIndentedString(opsigelsesDato));
    sb.append("\n    opsigelsesFrist: ").append(toIndentedString(opsigelsesFrist));
    sb.append("\n    forfald: ").append(toIndentedString(forfald));
    sb.append("\n    indfrielsesKurs: ").append(toIndentedString(indfrielsesKurs));
    sb.append("\n    indfrielseskursType: ").append(toIndentedString(indfrielseskursType));
    sb.append("\n    kursvaerdi: ").append(toIndentedString(kursvaerdi));
    sb.append("\n    godtgoerelsesrente: ").append(toIndentedString(godtgoerelsesrente));
    sb.append("\n    indfrielsesBeloeb: ").append(toIndentedString(indfrielsesBeloeb));
    sb.append("\n    omkostninger: ").append(toIndentedString(omkostninger));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
