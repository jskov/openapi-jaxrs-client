/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.quarkus.reflection.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * SimpleEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.quarkus.reflection.dto.SimpleEnum.SimpleEnumAdapter.class)
@RegisterForReflection
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum SimpleEnum {
  YES("YES"),
  NO("NO");

  private final String value;

  SimpleEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class SimpleEnumAdapter implements JsonbAdapter<SimpleEnum, JsonString> {
      @Override
      public JsonString adaptToJson(SimpleEnum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public SimpleEnum adaptFromJson(JsonString value) throws Exception {
          for (SimpleEnum b : SimpleEnum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type SimpleEnum");
      }
  }
}
