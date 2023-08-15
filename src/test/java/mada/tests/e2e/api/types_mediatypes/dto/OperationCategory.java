/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * OperationCategory
 */
@JsonbTypeAdapter(mada.tests.e2e.api.types_mediatypes.dto.OperationCategory.OperationCategoryAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum OperationCategory {
  CREATE("CREATE"),
  READ("READ"),
  UPDATE("UPDATE"),
  DELETE("DELETE");

  private final String value;

  OperationCategory(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class OperationCategoryAdapter implements JsonbAdapter<OperationCategory, JsonString> {
      @Override
      public JsonString adaptToJson(OperationCategory e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public OperationCategory adaptFromJson(JsonString value) throws Exception {
          for (OperationCategory b : OperationCategory.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type OperationCategory");
      }
  }
}
