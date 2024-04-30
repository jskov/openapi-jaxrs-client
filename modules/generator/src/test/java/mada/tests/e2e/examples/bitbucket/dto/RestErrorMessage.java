/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;

/**
 * RestErrorMessage
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestErrorMessage {
  public static final String JSON_PROPERTY_CONTEXT = "context";
  @JsonbProperty(JSON_PROPERTY_CONTEXT)
  private String context;

  public static final String JSON_PROPERTY_EXCEPTION_NAME = "exceptionName";
  @JsonbProperty(JSON_PROPERTY_EXCEPTION_NAME)
  private String exceptionName;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  private String message;

  public RestErrorMessage context(String context) {
    this.context = context;
    return this;
  }

  /**
   * Get context
   * @return context
   **/
  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public RestErrorMessage exceptionName(String exceptionName) {
    this.exceptionName = exceptionName;
    return this;
  }

  /**
   * Get exceptionName
   * @return exceptionName
   **/
  public String getExceptionName() {
    return exceptionName;
  }

  public void setExceptionName(String exceptionName) {
    this.exceptionName = exceptionName;
  }

  public RestErrorMessage message(String message) {
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
    if (!(o instanceof RestErrorMessage)) {
      return false;
    }
    RestErrorMessage other = (RestErrorMessage) o;
    return Objects.equals(this.context, other.context) &&
        Objects.equals(this.exceptionName, other.exceptionName) &&
        Objects.equals(this.message, other.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(context, exceptionName, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestErrorMessage {");
    sb.append("\n    context: ").append(toIndentedString(context));
    sb.append("\n    exceptionName: ").append(toIndentedString(exceptionName));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
