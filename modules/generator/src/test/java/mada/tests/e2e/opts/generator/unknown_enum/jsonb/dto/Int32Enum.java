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
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Int32Enum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto.Int32Enum.Int32EnumAdapter.class)
@Schema(enumeration = {"1", "2", "-3", "2125323949"}, type = SchemaType.INTEGER, format = "int32")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum Int32Enum {
  NUMBER_1(1),
  NUMBER_2(2),
  NUMBER_NEG_3(-3),
  UNKNOWN_DEFAULT_OPEN_API(2125323949);

  private final int value;

  Int32Enum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class Int32EnumAdapter implements JsonbAdapter<Int32Enum, JsonString> {
      @Override
      public JsonString adaptToJson(Int32Enum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public Int32Enum adaptFromJson(JsonString value) throws Exception {
          for (Int32Enum b : Int32Enum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          return UNKNOWN_DEFAULT_OPEN_API;
      }
  }
}
