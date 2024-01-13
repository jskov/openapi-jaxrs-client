/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.property.order.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Environment
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.property.order.dto.Environment.EnvironmentAdapter.class)
@Schema(enumeration = {"test", "qa", "production"}, type = SchemaType.STRING)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum Environment {
  TEST("test"),
  QA("qa"),
  PRODUCTION("production");

  private final String value;

  Environment(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class EnvironmentAdapter implements JsonbAdapter<Environment, JsonString> {
      @Override
      public JsonString adaptToJson(Environment e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public Environment adaptFromJson(JsonString value) throws Exception {
          for (Environment b : Environment.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type Environment");
      }
  }
}
