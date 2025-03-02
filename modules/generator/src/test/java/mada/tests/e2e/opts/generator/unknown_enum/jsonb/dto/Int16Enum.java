/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Int16Enum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto.Int16Enum.Int16EnumAdapter.class)
@Schema(enumeration = {"1", "2", "-3", "-8531"})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum Int16Enum {
  NUMBER_1((short)1),
  NUMBER_2((short)2),
  NUMBER_NEG_3((short)-3),
  UNKNOWN_DEFAULT_OPEN_API((short)-8531);

  private final short value;

  Int16Enum(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class Int16EnumAdapter implements JsonbAdapter<Int16Enum, JsonString> {
      @Override
      public JsonString adaptToJson(Int16Enum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public Int16Enum adaptFromJson(JsonString value) throws Exception {
          for (Int16Enum b : Int16Enum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          return UNKNOWN_DEFAULT_OPEN_API;
      }
  }
}
