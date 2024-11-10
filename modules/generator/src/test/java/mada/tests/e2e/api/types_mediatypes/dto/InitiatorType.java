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
 * InitiatorType
 */
@JsonbTypeAdapter(mada.tests.e2e.api.types_mediatypes.dto.InitiatorType.InitiatorTypeAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum InitiatorType {
  USER_ID("USER_ID"),
  SERVICE_USER("SERVICE_USER");

  private final String value;

  InitiatorType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class InitiatorTypeAdapter implements JsonbAdapter<InitiatorType, JsonString> {
      @Override
      public JsonString adaptToJson(InitiatorType e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public InitiatorType adaptFromJson(JsonString value) throws Exception {
          for (InitiatorType b : InitiatorType.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type InitiatorType");
      }
  }
}
