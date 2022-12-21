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
 * The assignee of a task. If the assignee is ADVISOR, the task is intended for any employee within the bank. If the assignee is CUSTOMER, the task is intended for any contact person in the room on behalf of the customer.
 */
@Schema(description = "The assignee of a task. If the assignee is ADVISOR, the task is intended for any employee within the bank. If the assignee is CUSTOMER, the task is intended for any contact person in the room on behalf of the customer.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum TaskAssignee {
  ADVISOR("ADVISOR"),
  CUSTOMER("CUSTOMER");

  private final String value;

  TaskAssignee(String value) {
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
  public static TaskAssignee fromValue(String value) {
    for (TaskAssignee b : TaskAssignee.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
