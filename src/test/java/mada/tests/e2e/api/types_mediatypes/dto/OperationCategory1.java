/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbTypeAdapter;

/**
 * OperationCategory1
 */
@JsonbTypeAdapter(mada.tests.e2e.api.types_mediatypes.dto.OperationCategory1.OperationCategory1Adapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum OperationCategory1 {
  CREATE("CREATE"),
  READ("READ"),
  UPDATE("UPDATE"),
  DELETE("DELETE");

  private final String value;

  OperationCategory1(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class OperationCategory1Adapter implements JsonbAdapter<OperationCategory1, JsonString> {
      @Override
      public JsonString adaptToJson(OperationCategory1 e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public OperationCategory1 adaptFromJson(JsonString value) throws Exception {
          for (OperationCategory1 b : OperationCategory1.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type OperationCategory1");
      }
  }
}
