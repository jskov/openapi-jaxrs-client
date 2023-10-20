/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;

/**
 * Violation
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Violation {
  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  private String message;

  public static final String JSON_PROPERTY_PROPERTY_PATH = "property-path";
  @JsonbProperty(JSON_PROPERTY_PROPERTY_PATH)
  private String propertyPath;

  public static final String JSON_PROPERTY_ROOT_BEAN_CLASS = "root-bean-class";
  @JsonbProperty(JSON_PROPERTY_ROOT_BEAN_CLASS)
  private String rootBeanClass;

  public Violation message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Violation propertyPath(String propertyPath) {
    this.propertyPath = propertyPath;
    return this;
  }

  /**
   * Get propertyPath
   * @return propertyPath
   **/
  public String getPropertyPath() {
    return propertyPath;
  }

  public void setPropertyPath(String propertyPath) {
    this.propertyPath = propertyPath;
  }

  public Violation rootBeanClass(String rootBeanClass) {
    this.rootBeanClass = rootBeanClass;
    return this;
  }

  /**
   * Get rootBeanClass
   * @return rootBeanClass
   **/
  public String getRootBeanClass() {
    return rootBeanClass;
  }

  public void setRootBeanClass(String rootBeanClass) {
    this.rootBeanClass = rootBeanClass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Violation)) {
      return false;
    }
    Violation other = (Violation) o;
    return Objects.equals(this.message, other.message) &&
        Objects.equals(this.propertyPath, other.propertyPath) &&
        Objects.equals(this.rootBeanClass, other.rootBeanClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, propertyPath, rootBeanClass);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Violation {");
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n    propertyPath: ").append(toIndentedString(propertyPath));
    sb.append("\n    rootBeanClass: ").append(toIndentedString(rootBeanClass));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
