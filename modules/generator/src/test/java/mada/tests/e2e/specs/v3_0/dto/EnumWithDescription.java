/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.specs.v3_0.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * A = foo
 * B == bar
 * C : colon.
 */
@JsonbTypeAdapter(mada.tests.e2e.specs.v3_0.dto.EnumWithDescription.EnumWithDescriptionAdapter.class)
@Schema(description = "A = foo\nB == bar\nC : colon")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum EnumWithDescription {
  VALUE_A("VALUE_A"),
  VALUE_B("VALUE_B"),
  VALUE_C("VALUE_C");

  private final String value;

  EnumWithDescription(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class EnumWithDescriptionAdapter implements JsonbAdapter<EnumWithDescription, JsonString> {
      @Override
      public JsonString adaptToJson(EnumWithDescription e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public EnumWithDescription adaptFromJson(JsonString value) throws Exception {
          for (EnumWithDescription b : EnumWithDescription.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type EnumWithDescription");
      }
  }
}
