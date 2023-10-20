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
 * ExceptionInformation
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExceptionInformation {
  public static final String JSON_PROPERTY_CAUSE = "cause";
  @JsonbProperty(JSON_PROPERTY_CAUSE)
  private String cause;

  public static final String JSON_PROPERTY_EXCEPTION_CLASS = "exception-class";
  @JsonbProperty(JSON_PROPERTY_EXCEPTION_CLASS)
  private String exceptionClass;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  private String message;

  public ExceptionInformation cause(String cause) {
    this.cause = cause;
    return this;
  }

  /**
   * Get cause
   * @return cause
   **/
  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  public ExceptionInformation exceptionClass(String exceptionClass) {
    this.exceptionClass = exceptionClass;
    return this;
  }

  /**
   * Get exceptionClass
   * @return exceptionClass
   **/
  public String getExceptionClass() {
    return exceptionClass;
  }

  public void setExceptionClass(String exceptionClass) {
    this.exceptionClass = exceptionClass;
  }

  public ExceptionInformation message(String message) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExceptionInformation)) {
      return false;
    }
    ExceptionInformation other = (ExceptionInformation) o;
    return Objects.equals(this.cause, other.cause) &&
        Objects.equals(this.exceptionClass, other.exceptionClass) &&
        Objects.equals(this.message, other.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cause, exceptionClass, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExceptionInformation {");
    sb.append("\n    cause: ").append(toIndentedString(cause));
    sb.append("\n    exceptionClass: ").append(toIndentedString(exceptionClass));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
