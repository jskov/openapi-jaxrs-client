/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.dto.enums.integers.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Role for the customer refnr relation. 1=Owner, 0=Related, Unknown role.
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.enums.integers.dto.RoleCodeLong.RoleCodeLongAdapter.class)
@Schema(enumeration = {"0", "1"}, description = "Role for the customer refnr relation. 1=Owner, 0=Related, Unknown role.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum RoleCodeLong {
  NUMBER_0(0L),
  NUMBER_1(1L);

  private final long value;

  RoleCodeLong(long value) {
    this.value = value;
  }

  public long getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class RoleCodeLongAdapter implements JsonbAdapter<RoleCodeLong, JsonString> {
      @Override
      public JsonString adaptToJson(RoleCodeLong e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public RoleCodeLong adaptFromJson(JsonString value) throws Exception {
          for (RoleCodeLong b : RoleCodeLong.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RoleCodeLong");
      }
  }
}
