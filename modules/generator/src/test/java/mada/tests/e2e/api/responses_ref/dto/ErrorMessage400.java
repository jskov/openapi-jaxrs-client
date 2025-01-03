/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.api.responses_ref.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Messages with HTTP error code 400  on operational issues related to path and header variables.
 */
@Schema(description = "Messages with HTTP error code 400  on operational issues related to path and header variables.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ErrorMessage400 {
  public static final String JSON_PROPERTY_CODE = "code";
  @JsonbProperty(JSON_PROPERTY_CODE)
  private MessageCode400 code;

  public static final String JSON_PROPERTY_ERROR_TEXT = "errorText";
  @JsonbProperty(JSON_PROPERTY_ERROR_TEXT)
  private String errorText;

  public ErrorMessage400 code(MessageCode400 code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Valid
  public MessageCode400 getCode() {
    return code;
  }

  public void setCode(MessageCode400 code) {
    this.code = code;
  }

  public ErrorMessage400 errorText(String errorText) {
    this.errorText = errorText;
    return this;
  }

  /**
   * Get errorText
   * @return errorText
   **/
  @Size(max = 512)
  public String getErrorText() {
    return errorText;
  }

  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ErrorMessage400)) {
      return false;
    }
    ErrorMessage400 other = (ErrorMessage400) o;
    return Objects.equals(this.code, other.code) &&
        Objects.equals(this.errorText, other.errorText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, errorText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessage400 {");
    sb.append("\n    code: ").append(toIndentedString(code));
    sb.append("\n    errorText: ").append(toIndentedString(errorText));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
