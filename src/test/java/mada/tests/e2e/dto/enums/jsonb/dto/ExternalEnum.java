/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jsonb.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * ExternalEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.enums.jsonb.dto.ExternalEnum.ExternalEnumAdapter.class)
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public enum ExternalEnum {
  E("E"),
  F("F");

  private final String value;

  ExternalEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class ExternalEnumAdapter implements JsonbAdapter<ExternalEnum, JsonString> {
      @Override
      public JsonString adaptToJson(ExternalEnum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public ExternalEnum adaptFromJson(JsonString value) throws Exception {
          for (ExternalEnum b : ExternalEnum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ExternalEnum");
      }
  }
}
