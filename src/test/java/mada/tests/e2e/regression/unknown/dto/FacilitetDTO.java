/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.regression.unknown.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * FacilitetDTO
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class FacilitetDTO {
  public static final String JSON_PROPERTY_ELEM_ID = "elemId";
  @JsonProperty(JSON_PROPERTY_ELEM_ID)
  private String elemId;

  public FacilitetDTO elemId(String elemId) {
    this.elemId = elemId;
    return this;
  }

  /**
   * Get elemId
   * @return elemId
   **/
  public String getElemId() {
    return elemId;
  }

  public void setElemId(String elemId) {
    this.elemId = elemId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FacilitetDTO)) {
      return false;
    }
    FacilitetDTO other = (FacilitetDTO) o;
    return Objects.equals(this.elemId, other.elemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elemId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FacilitetDTO {");
    sb.append("\n    elemId: ").append(toIndentedString(elemId));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
