/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions_doc.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * Collisions
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Collisions {
  public static final String JSON_PROPERTY_LOWER_CASE_A = "lowerCaseA";
  @JsonbProperty(JSON_PROPERTY_LOWER_CASE_A)
  private Collisiona lowerCaseA;

  public static final String JSON_PROPERTY_UPPER_CASE_A = "upperCaseA";
  @JsonbProperty(JSON_PROPERTY_UPPER_CASE_A)
  private CollisionAX upperCaseA;

  public Collisions lowerCaseA(Collisiona lowerCaseA) {
    this.lowerCaseA = lowerCaseA;
    return this;
  }

  /**
   * Get lowerCaseA
   * @return lowerCaseA
   **/
  @Valid
  public Collisiona getLowerCaseA() {
    return lowerCaseA;
  }

  public void setLowerCaseA(Collisiona lowerCaseA) {
    this.lowerCaseA = lowerCaseA;
  }

  public Collisions upperCaseA(CollisionAX upperCaseA) {
    this.upperCaseA = upperCaseA;
    return this;
  }

  /**
   * Get upperCaseA
   * @return upperCaseA
   **/
  @Valid
  public CollisionAX getUpperCaseA() {
    return upperCaseA;
  }

  public void setUpperCaseA(CollisionAX upperCaseA) {
    this.upperCaseA = upperCaseA;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Collisions)) {
      return false;
    }
    Collisions other = (Collisions) o;
    return Objects.equals(this.lowerCaseA, other.lowerCaseA) &&
        Objects.equals(this.upperCaseA, other.upperCaseA);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lowerCaseA, upperCaseA);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Collisions {");
    sb.append("\n    lowerCaseA: ").append(toIndentedString(lowerCaseA));
    sb.append("\n    upperCaseA: ").append(toIndentedString(upperCaseA));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
