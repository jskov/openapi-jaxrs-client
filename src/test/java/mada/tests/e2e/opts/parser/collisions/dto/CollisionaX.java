/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * CollisionaX
 */
@JsonbPropertyOrder({
  CollisionaX.JSON_PROPERTY_A_BOOLEAN
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CollisionaX {
  public static final String JSON_PROPERTY_A_BOOLEAN = "aBoolean";
  @JsonbProperty(JSON_PROPERTY_A_BOOLEAN)
  private Boolean aBoolean;

  public CollisionaX aBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
    return this;
  }

  /**
   * Get aBoolean
   * @return aBoolean
   **/
  public Boolean isABoolean() {
    return aBoolean;
  }

  public void setABoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollisionaX other = (CollisionaX) o;
    return Objects.equals(this.aBoolean, other.aBoolean);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBoolean);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollisionaX {");
    sb.append("\n    aBoolean: ").append(toIndentedString(aBoolean));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
