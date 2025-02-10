/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.parser.collisions_name.dto;

import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * AftalePakkeId
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AftalePakkeId {
  public static final String JSON_PROPERTY_VAERDI = "Vaerdi";
  @JsonbProperty(JSON_PROPERTY_VAERDI)
  @Schema(example = "00000000-0000-0000-0000-000000000000")
  private UUID vaerdi;

  public AftalePakkeId vaerdi(UUID vaerdi) {
    this.vaerdi = vaerdi;
    return this;
  }

  /**
   * Get vaerdi
   * @return vaerdi
   **/
  @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")
  public UUID getVaerdi() {
    return vaerdi;
  }

  public void setVaerdi(UUID vaerdi) {
    this.vaerdi = vaerdi;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AftalePakkeId)) {
      return false;
    }
    AftalePakkeId other = (AftalePakkeId) o;
    return Objects.equals(this.vaerdi, other.vaerdi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vaerdi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AftalePakkeId {");
    sb.append("\n    vaerdi: ").append(toIndentedString(vaerdi));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
