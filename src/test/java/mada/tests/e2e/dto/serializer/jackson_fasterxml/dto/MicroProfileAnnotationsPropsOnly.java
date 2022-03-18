/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.serializer.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * MicroProfileAnnotationsPropsOnly
 */
@JsonPropertyOrder({
  MicroProfileAnnotationsPropsOnly.JSON_PROPERTY_WITH_DESCRIPTION
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class MicroProfileAnnotationsPropsOnly {
  public static final String JSON_PROPERTY_WITH_DESCRIPTION = "withDescription";
  @JsonProperty(JSON_PROPERTY_WITH_DESCRIPTION)
  @Schema(description = "property description")
  private String withDescription;

  public MicroProfileAnnotationsPropsOnly withDescription(String withDescription) {
    this.withDescription = withDescription;
    return this;
  }

  /**
   * property description.
   *
   * @return withDescription
   **/
  public String getWithDescription() {
    return withDescription;
  }

  public void setWithDescription(String withDescription) {
    this.withDescription = withDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MicroProfileAnnotationsPropsOnly other = (MicroProfileAnnotationsPropsOnly) o;
    return Objects.equals(this.withDescription, other.withDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(withDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MicroProfileAnnotationsPropsOnly {");
    sb.append("\n    withDescription: ").append(toIndentedString(withDescription));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
