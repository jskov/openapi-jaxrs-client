/*
 * jboss-helloworld
 *
 * The version of the OpenAPI document: 1.0
 */

package mada.tests.e2e.dto.allof_dups.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;

/**
 * AfregningCalculationResponse
 */
@JsonbPropertyOrder({
  AfregningCalculationResponse.JSON_PROPERTY_OMKOSTNINGER
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AfregningCalculationResponse {
  public static final String JSON_PROPERTY_OMKOSTNINGER = "Omkostninger";
  @JsonbProperty(JSON_PROPERTY_OMKOSTNINGER)
  private Omkostninger omkostninger;

  public AfregningCalculationResponse omkostninger(Omkostninger omkostninger) {
    this.omkostninger = omkostninger;
    return this;
  }

  /**
   * Get omkostninger
   * @return omkostninger
   **/
  @Valid
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
    return Objects.equals(this.omkostninger, other.omkostninger);
  }

  @Override
  public int hashCode() {
    return Objects.hash(omkostninger);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AfregningCalculationResponse {");
    sb.append("\n    omkostninger: ").append(toIndentedString(omkostninger));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
