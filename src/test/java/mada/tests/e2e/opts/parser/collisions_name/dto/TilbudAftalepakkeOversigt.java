/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions_name.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * TilbudAftalepakkeOversigt
 */
@JsonbPropertyOrder({
  TilbudAftalepakkeOversigt.JSON_PROPERTY_AFTALEPAKKE_ID_PARTNER_SALG
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TilbudAftalepakkeOversigt {
  public static final String JSON_PROPERTY_AFTALEPAKKE_ID_PARTNER_SALG = "aftalepakkeIdPartnerSalg";
  @JsonbProperty(JSON_PROPERTY_AFTALEPAKKE_ID_PARTNER_SALG)
  private String aftalepakkeIdPartnerSalg;

  public TilbudAftalepakkeOversigt aftalepakkeIdPartnerSalg(String aftalepakkeIdPartnerSalg) {
    this.aftalepakkeIdPartnerSalg = aftalepakkeIdPartnerSalg;
    return this;
  }

  /**
   * Get aftalepakkeIdPartnerSalg
   * @return aftalepakkeIdPartnerSalg
   **/
  public String getAftalepakkeIdPartnerSalg() {
    return aftalepakkeIdPartnerSalg;
  }

  public void setAftalepakkeIdPartnerSalg(String aftalepakkeIdPartnerSalg) {
    this.aftalepakkeIdPartnerSalg = aftalepakkeIdPartnerSalg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TilbudAftalepakkeOversigt other = (TilbudAftalepakkeOversigt) o;
    return Objects.equals(this.aftalepakkeIdPartnerSalg, other.aftalepakkeIdPartnerSalg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aftalepakkeIdPartnerSalg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TilbudAftalepakkeOversigt {");
    sb.append("\n    aftalepakkeIdPartnerSalg: ").append(toIndentedString(aftalepakkeIdPartnerSalg));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
