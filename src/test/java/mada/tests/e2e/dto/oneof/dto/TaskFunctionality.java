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
 * The functionality the task belongs to.
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.oneof.dto.TaskFunctionality.TaskFunctionalityAdapter.class)
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

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class TaskFunctionalityAdapter implements JsonbAdapter<TaskFunctionality, JsonString> {
      @Override
      public JsonString adaptToJson(TaskFunctionality e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public TaskFunctionality adaptFromJson(JsonString value) throws Exception {
          for (TaskFunctionality b : TaskFunctionality.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type TaskFunctionality");
      }
  }
}
