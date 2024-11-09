/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Omkostning
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Omkostning {
  public static final String JSON_PROPERTY_NOTANR = "notanr";
  @JsonProperty(JSON_PROPERTY_NOTANR)
  @Schema(description = "Nummeret på gebyrnotaen, som de underliggende gebyrer hører til.<br>Hvis pakken er fra boligvejviseren, vil rådgiveren IKKE kunne ændre på omkostningerne i Kreditsagen. Derfor er det et krav, at alle oplysninger omkring omkostninger bliver sendt ind via API’et, hvis der skal bogføres omkostninger på den enkelte facilitet.<br>Format: Number(3)")
  private Integer notanr;

  public Omkostning notanr(Integer notanr) {
    this.notanr = notanr;
    return this;
  }

  /**
   * Nummeret på gebyrnotaen, som de underliggende gebyrer hører til.<br>Hvis pakken er fra boligvejviseren, vil
   * rådgiveren IKKE kunne ændre på omkostningerne i Kreditsagen. Derfor er det et krav, at alle oplysninger omkring
   * omkostninger bliver sendt ind via API’et, hvis der skal bogføres omkostninger på den enkelte facilitet.<br>Format:
   * Number(3)
   *
   * @return notanr
   **/
  @Pattern(regexp = "^\\d{1,3}$")
  public Integer getNotanr() {
    return notanr;
  }

  public void setNotanr(Integer notanr) {
    this.notanr = notanr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Omkostning)) {
      return false;
    }
    Omkostning other = (Omkostning) o;
    return Objects.equals(this.notanr, other.notanr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notanr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Omkostning {");
    sb.append("\n    notanr: ").append(toIndentedString(notanr));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
