/*
 * Swagger Petstore - OpenAPI 3.0
 * This is a sample Pet Store Server based on the OpenAPI 3.0 specification.  You can find out more about
Swagger at [https://swagger.io](https://swagger.io). In the third iteration of the pet store, we've switched to the design first approach!
You can now help us improve the API whether it's by making changes to the definition itself or to the code.
That way, with time, we can improve the API in general, and expose some of the new features in OAS3.

Some useful links:
- [The Pet Store repository](https://github.com/swagger-api/swagger-petstore)
- [The source API definition for the Pet Store](https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml)
 *
 * The version of the OpenAPI document: 1.0.27-SNAPSHOT
 * Contact: apiteam@swagger.io
 */

package mada.tests.e2e.examples.petstore.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;

/**
 * ApiResponse
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ApiResponse {
  public static final String JSON_PROPERTY_CODE = "code";
  @JsonbProperty(JSON_PROPERTY_CODE)
  private Integer code;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  private String message;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  private String type;

  public ApiResponse code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ApiResponse message(String message) {
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

  public ApiResponse type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApiResponse)) {
      return false;
    }
    ApiResponse other = (ApiResponse) o;
    return Objects.equals(this.code, other.code) &&
        Objects.equals(this.message, other.message) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiResponse {");
    sb.append("\n    code: ").append(toIndentedString(code));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
