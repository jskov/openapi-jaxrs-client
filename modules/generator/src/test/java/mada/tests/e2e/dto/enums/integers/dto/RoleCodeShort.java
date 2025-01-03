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
@JsonbTypeAdapter(mada.tests.e2e.dto.enums.integers.dto.RoleCodeShort.RoleCodeShortAdapter.class)
@Schema(enumeration = {"0", "1"}, description = "Role for the customer refnr relation. 1=Owner, 0=Related, Unknown role.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum RoleCodeShort {
  NUMBER_0((short)0),
  NUMBER_1((short)1);

  private final short value;

  RoleCodeShort(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class RoleCodeShortAdapter implements JsonbAdapter<RoleCodeShort, JsonString> {
      @Override
      public JsonString adaptToJson(RoleCodeShort e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public RoleCodeShort adaptFromJson(JsonString value) throws Exception {
          for (RoleCodeShort b : RoleCodeShort.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RoleCodeShort");
      }
  }
}
