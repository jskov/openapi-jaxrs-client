/*
 * Swagger Petstore
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.examples.petstore.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Error
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Error {
  public static final String JSON_PROPERTY_CODE = "code";
  @JsonbProperty(JSON_PROPERTY_CODE)
  @Schema(required = true)
  private Integer code;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  @Schema(required = true)
  private String message;

  public Error code(Integer code) {
    this.code = Objects.requireNonNull(code, "Property code is required, cannot be null");
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @NotNull
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = Objects.requireNonNull(code, "Property code is required, cannot be null");
  }

  public Error message(String message) {
    this.message = Objects.requireNonNull(message, "Property message is required, cannot be null");
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @NotNull
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = Objects.requireNonNull(message, "Property message is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Error)) {
      return false;
    }
    Error other = (Error) o;
    return Objects.equals(this.code, other.code) &&
        Objects.equals(this.message, other.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {");
    sb.append("\n    code: ").append(toIndentedString(code));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
