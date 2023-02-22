/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof_combined.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.Valid;

/**
 * WithRef
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class WithRef {
  public static final String JSON_PROPERTY_COMBINED = "combined";
  @JsonProperty(JSON_PROPERTY_COMBINED)
  private WithRefCombined combined;

  public WithRef combined(WithRefCombined combined) {
    this.combined = combined;
    return this;
  }

  /**
   * Get combined
   * @return combined
   **/
  @Valid
  public WithRefCombined getCombined() {
    return combined;
  }

  public void setCombined(WithRefCombined combined) {
    this.combined = combined;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WithRef)) {
      return false;
    }
    WithRef other = (WithRef) o;
    return Objects.equals(this.combined, other.combined);
  }

  @Override
  public int hashCode() {
    return Objects.hash(combined);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WithRef {");
    sb.append("\n    combined: ").append(toIndentedString(combined));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
