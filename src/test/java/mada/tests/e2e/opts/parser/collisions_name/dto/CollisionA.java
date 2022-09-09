/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions_name.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * CollisionA
 */
@JsonbPropertyOrder({
  CollisionA.JSON_PROPERTY_A_CAPITAL_BOOLEAN
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CollisionA {
  public static final String JSON_PROPERTY_A_CAPITAL_BOOLEAN = "aCapitalBoolean";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_BOOLEAN)
  private Boolean aCapitalBoolean;

  public CollisionA aCapitalBoolean(Boolean aCapitalBoolean) {
    this.aCapitalBoolean = aCapitalBoolean;
    return this;
  }

  /**
   * Get aCapitalBoolean
   * @return aCapitalBoolean
   **/
  public Boolean isACapitalBoolean() {
    return aCapitalBoolean;
  }

  public void setACapitalBoolean(Boolean aCapitalBoolean) {
    this.aCapitalBoolean = aCapitalBoolean;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollisionA other = (CollisionA) o;
    return Objects.equals(this.aCapitalBoolean, other.aCapitalBoolean);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aCapitalBoolean);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollisionA {");
    sb.append("\n    aCapitalBoolean: ").append(toIndentedString(aCapitalBoolean));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
