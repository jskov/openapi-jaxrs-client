/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.form.simple.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * TemplateDTO
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TemplateDTO {
  public static final String JSON_PROPERTY_A_BOOLEAN = "aBoolean";
  @JsonbProperty(JSON_PROPERTY_A_BOOLEAN)
  private Boolean aBoolean;

  public TemplateDTO aBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
    return this;
  }

  /**
   * Get aBoolean
   * @return aBoolean
   **/
  public Boolean isaBoolean() {
    return aBoolean;
  }

  public void setaBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TemplateDTO)) {
      return false;
    }
    TemplateDTO other = (TemplateDTO) o;
    return Objects.equals(this.aBoolean, other.aBoolean);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBoolean);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateDTO {");
    sb.append("\n    aBoolean: ").append(toIndentedString(aBoolean));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
