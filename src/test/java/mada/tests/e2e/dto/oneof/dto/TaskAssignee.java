/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * The assignee of a task. If the assignee is ADVISOR, the task is intended for any employee within the bank. If the assignee is CUSTOMER, the task is intended for any contact person in the room on behalf of the customer.
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.oneof.dto.TaskAssignee.TaskAssigneeAdapter.class)
@Schema(description = "The assignee of a task. If the assignee is ADVISOR, the task is intended for any employee within the bank. If the assignee is CUSTOMER, the task is intended for any contact person in the room on behalf of the customer.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum TaskAssignee {
  ADVISOR("ADVISOR"),
  CUSTOMER("CUSTOMER");

  private final String value;

  TaskAssignee(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class TaskAssigneeAdapter implements JsonbAdapter<TaskAssignee, JsonString> {
      @Override
      public JsonString adaptToJson(TaskAssignee e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public TaskAssignee adaptFromJson(JsonString value) throws Exception {
          for (TaskAssignee b : TaskAssignee.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type TaskAssignee");
      }
  }
}
