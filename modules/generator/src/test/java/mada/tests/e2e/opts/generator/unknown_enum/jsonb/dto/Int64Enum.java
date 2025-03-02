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
 * Int64Enum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto.Int64Enum.Int64EnumAdapter.class)
@Schema(enumeration = {"1", "2", "-3", "9128196858096508589"})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum Int64Enum {
  NUMBER_1(1L),
  NUMBER_2(2L),
  NUMBER_NEG_3(-3L),
  UNKNOWN_DEFAULT_OPEN_API(9128196858096508589L);

  private final long value;

  Int64Enum(long value) {
    this.value = value;
  }

  public long getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class Int64EnumAdapter implements JsonbAdapter<Int64Enum, JsonString> {
      @Override
      public JsonString adaptToJson(Int64Enum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public Int64Enum adaptFromJson(JsonString value) throws Exception {
          for (Int64Enum b : Int64Enum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          return UNKNOWN_DEFAULT_OPEN_API;
      }
  }
}
