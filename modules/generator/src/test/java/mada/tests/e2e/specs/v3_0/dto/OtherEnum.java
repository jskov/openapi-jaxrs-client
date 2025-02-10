/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * OtherEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.specs.v3_0.dto.OtherEnum.OtherEnumAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum OtherEnum {
  PROP_A("PROP_A"),
  PROP_B("PROP_B");

  private final String value;

  OtherEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class OtherEnumAdapter implements JsonbAdapter<OtherEnum, JsonString> {
      @Override
      public JsonString adaptToJson(OtherEnum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public OtherEnum adaptFromJson(JsonString value) throws Exception {
          for (OtherEnum b : OtherEnum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type OtherEnum");
      }
  }
}
