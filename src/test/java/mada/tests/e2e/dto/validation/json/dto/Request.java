/*
 * Some title Api
 *
 * The version of the OpenAPI document: v1
 */

package mada.tests.e2e.dto.validation.json.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * x.
 */
@JsonPropertyOrder({
  Request.JSON_PROPERTY_TAXATION
})
@Schema(description = "x")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Request {
  public static final String JSON_PROPERTY_TAXATION = "Taxation";
  @JsonProperty(JSON_PROPERTY_TAXATION)
  private Integer taxation;

  public Request taxation(Integer taxation) {
    this.taxation = taxation;
    return this;
  }

  /**
   * Get taxation
   * minimum: 100
   * maximum: 999
   * @return taxation
   **/
  @Min(100) @Max(999)
  public Integer getTaxation() {
    return taxation;
  }

  public void setTaxation(Integer taxation) {
    this.taxation = taxation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Request)) {
      return false;
    }
    Request other = (Request) o;
    return Objects.equals(this.taxation, other.taxation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {");
    sb.append("\n    taxation: ").append(toIndentedString(taxation));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
