/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.types_mapped.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * ProjectDTO
 */
@JsonbPropertyOrder({
  ProjectDTO.JSON_PROPERTY_DESCRIPTION
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ProjectDTO {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
  private String description;

  public ProjectDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectDTO other = (ProjectDTO) o;
    return Objects.equals(this.description, other.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectDTO {");
    sb.append("\n    description: ").append(toIndentedString(description));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
