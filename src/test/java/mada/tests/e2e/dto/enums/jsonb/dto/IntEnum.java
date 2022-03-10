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
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * IntEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.enums.jsonb.dto.IntEnum.IntEnumAdapter.class)
@Schema(enumeration = {"1", "2"}, type = SchemaType.INTEGER, format = "int32")
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public enum IntEnum {
  NUMBER_1(1),
  NUMBER_2(2);

  private final int value;

  IntEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class IntEnumAdapter implements JsonbAdapter<IntEnum, JsonString> {
      @Override
      public JsonString adaptToJson(IntEnum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public IntEnum adaptFromJson(JsonString value) throws Exception {
          for (IntEnum b : IntEnum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type IntEnum");
      }
  }
}
