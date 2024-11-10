/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.openapi_schema.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * ExternalLowerEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.openapi_schema.dto.ExternalLowerEnum.ExternalLowerEnumAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum ExternalLowerEnum {
  LOW_EXT_A("low_ext_a"),
  LOW_EXT_B("low_ext_b");

  private final String value;

  ExternalLowerEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class ExternalLowerEnumAdapter implements JsonbAdapter<ExternalLowerEnum, JsonString> {
      @Override
      public JsonString adaptToJson(ExternalLowerEnum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public ExternalLowerEnum adaptFromJson(JsonString value) throws Exception {
          for (ExternalLowerEnum b : ExternalLowerEnum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ExternalLowerEnum");
      }
  }
}
