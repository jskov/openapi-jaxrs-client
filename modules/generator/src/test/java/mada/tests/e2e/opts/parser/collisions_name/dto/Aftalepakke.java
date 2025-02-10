/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.parser.collisions_name.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * Aftalepakke
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Aftalepakke {
  public static final String JSON_PROPERTY_AFTALE_PAKKE_ID_PARTNER_SALG = "AftalePakkeIdPartnerSalg";
  @JsonbProperty(JSON_PROPERTY_AFTALE_PAKKE_ID_PARTNER_SALG)
  private AftalePakkeId aftalePakkeIdPartnerSalg;

  public Aftalepakke aftalePakkeIdPartnerSalg(AftalePakkeId aftalePakkeIdPartnerSalg) {
    this.aftalePakkeIdPartnerSalg = aftalePakkeIdPartnerSalg;
    return this;
  }

  /**
   * Get aftalePakkeIdPartnerSalg
   * @return aftalePakkeIdPartnerSalg
   **/
  @Valid
  public AftalePakkeId getAftalePakkeIdPartnerSalg() {
    return aftalePakkeIdPartnerSalg;
  }

  public void setAftalePakkeIdPartnerSalg(AftalePakkeId aftalePakkeIdPartnerSalg) {
    this.aftalePakkeIdPartnerSalg = aftalePakkeIdPartnerSalg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Aftalepakke)) {
      return false;
    }
    Aftalepakke other = (Aftalepakke) o;
    return Objects.equals(this.aftalePakkeIdPartnerSalg, other.aftalePakkeIdPartnerSalg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aftalePakkeIdPartnerSalg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Aftalepakke {");
    sb.append("\n    aftalePakkeIdPartnerSalg: ").append(toIndentedString(aftalePakkeIdPartnerSalg));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
