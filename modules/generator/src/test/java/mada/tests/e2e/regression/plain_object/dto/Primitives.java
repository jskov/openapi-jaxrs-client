/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.regression.plain_object.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Primitives
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Primitives {
  public static final String JSON_PROPERTY_AN_OBJECT = "anObject";
  @JsonbProperty(JSON_PROPERTY_AN_OBJECT)
  private Object anObject;

  public static final String JSON_PROPERTY_A_STRING = "aString";
  @JsonbProperty(JSON_PROPERTY_A_STRING)
  private String aString;

  public static final String JSON_PROPERTY_OBJECT = "object";
  @JsonbProperty(JSON_PROPERTY_OBJECT)
  private Object object;

  public static final String JSON_PROPERTY_PLAIN_OBJECT = "plainObject";
  @JsonbProperty(JSON_PROPERTY_PLAIN_OBJECT)
  private Object plainObject;

  public Primitives anObject(Object anObject) {
    this.anObject = anObject;
    return this;
  }

  /**
   * Get anObject
   * @return anObject
   **/
  public Object getAnObject() {
    return anObject;
  }

  public void setAnObject(Object anObject) {
    this.anObject = anObject;
  }

  public Primitives aString(String aString) {
    this.aString = aString;
    return this;
  }

  /**
   * Get aString
   * @return aString
   **/
  public String getaString() {
    return aString;
  }

  public void setaString(String aString) {
    this.aString = aString;
  }

  public Primitives object(Object object) {
    this.object = object;
    return this;
  }

  /**
   * Get object
   * @return object
   **/
  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

  public Primitives plainObject(Object plainObject) {
    this.plainObject = plainObject;
    return this;
  }

  /**
   * Get plainObject
   * @return plainObject
   **/
  public Object getPlainObject() {
    return plainObject;
  }

  public void setPlainObject(Object plainObject) {
    this.plainObject = plainObject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Primitives)) {
      return false;
    }
    Primitives other = (Primitives) o;
    return Objects.equals(this.anObject, other.anObject) &&
        Objects.equals(this.aString, other.aString) &&
        Objects.equals(this.object, other.object) &&
        Objects.equals(this.plainObject, other.plainObject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(anObject, aString, object, plainObject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Primitives {");
    sb.append("\n    anObject: ").append(toIndentedString(anObject));
    sb.append("\n    aString: ").append(toIndentedString(aString));
    sb.append("\n    object: ").append(toIndentedString(object));
    sb.append("\n    plainObject: ").append(toIndentedString(plainObject));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
