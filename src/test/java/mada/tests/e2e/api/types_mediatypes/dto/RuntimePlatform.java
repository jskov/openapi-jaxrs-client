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
 * RuntimePlatform
 */
@JsonbTypeAdapter(mada.tests.e2e.api.types_mediatypes.dto.RuntimePlatform.RuntimePlatformAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum RuntimePlatform {
  POSEIDON("POSEIDON");

  private final String value;

  RuntimePlatform(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class RuntimePlatformAdapter implements JsonbAdapter<RuntimePlatform, JsonString> {
      @Override
      public JsonString adaptToJson(RuntimePlatform e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public RuntimePlatform adaptFromJson(JsonString value) throws Exception {
          for (RuntimePlatform b : RuntimePlatform.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RuntimePlatform");
      }
  }
}
