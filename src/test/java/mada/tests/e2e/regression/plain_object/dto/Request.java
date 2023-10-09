/*
 * Naked Object Test
 *
 * The version of the OpenAPI document: v1
 */

package mada.tests.e2e.regression.plain_object.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Request
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Request {
  public static final String JSON_PROPERTY_ID = "Id";
  @JsonbProperty(JSON_PROPERTY_ID)
  private Long id;

  public Request id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    return Objects.equals(this.id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {");
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
