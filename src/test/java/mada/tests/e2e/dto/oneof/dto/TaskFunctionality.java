/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * The functionality the task belongs to.
 */
@Schema(description = "The functionality the task belongs to.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum TaskFunctionality {
  DOCUMENTS("DOCUMENTS"),
  PURPOSE_AND_SCOPE("PURPOSE_AND_SCOPE"),
  STATEMENT_OF_TRUTH("STATEMENT_OF_TRUTH"),
  TAX_INFO("TAX_INFO");

  private final String value;

  TaskFunctionality(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TaskFunctionality fromValue(String value) {
    for (TaskFunctionality b : TaskFunctionality.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
