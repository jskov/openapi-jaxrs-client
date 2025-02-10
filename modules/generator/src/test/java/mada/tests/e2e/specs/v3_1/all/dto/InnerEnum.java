/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * InnerEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.specs.v3_1.all.dto.InnerEnum.InnerEnumAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum InnerEnum {
  I("I"),
  J("J");

  private final String value;

  InnerEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class InnerEnumAdapter implements JsonbAdapter<InnerEnum, JsonString> {
      @Override
      public JsonString adaptToJson(InnerEnum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public InnerEnum adaptFromJson(JsonString value) throws Exception {
          for (InnerEnum b : InnerEnum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type InnerEnum");
      }
  }
}
