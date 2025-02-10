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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * description text enum.
 */
@JsonbTypeAdapter(mada.tests.e2e.specs.v3_0.dto.SimpleEnumSchema.SimpleEnumSchemaAdapter.class)
@Schema(description = "description text enum")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum SimpleEnumSchema {
  YES("YES"),
  NO("NO");

  private final String value;

  SimpleEnumSchema(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class SimpleEnumSchemaAdapter implements JsonbAdapter<SimpleEnumSchema, JsonString> {
      @Override
      public JsonString adaptToJson(SimpleEnumSchema e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public SimpleEnumSchema adaptFromJson(JsonString value) throws Exception {
          for (SimpleEnumSchema b : SimpleEnumSchema.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type SimpleEnumSchema");
      }
  }
}
