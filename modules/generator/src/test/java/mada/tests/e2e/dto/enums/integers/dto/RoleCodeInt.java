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
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Role for the customer refnr relation. 1=Owner, 0=Related, Unknown role.
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.enums.integers.dto.RoleCodeInt.RoleCodeIntAdapter.class)
@Schema(enumeration = {"0", "1"}, type = SchemaType.INTEGER, format = "int32", description = "Role for the customer refnr relation. 1=Owner, 0=Related, Unknown role.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum RoleCodeInt {
  NUMBER_0(0),
  NUMBER_1(1);

  private final int value;

  RoleCodeInt(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class RoleCodeIntAdapter implements JsonbAdapter<RoleCodeInt, JsonString> {
      @Override
      public JsonString adaptToJson(RoleCodeInt e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public RoleCodeInt adaptFromJson(JsonString value) throws Exception {
          for (RoleCodeInt b : RoleCodeInt.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RoleCodeInt");
      }
  }
}
