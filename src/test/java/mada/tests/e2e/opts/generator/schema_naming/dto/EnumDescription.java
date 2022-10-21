/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.schema_naming.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * an enum.
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.schema_naming.dto.EnumDescription.EnumDescriptionAdapter.class)
@Schema(name = "MostValuedEnum", description = "an enum")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum EnumDescription {
  VALUE_A("VALUE_A"),
  VALUE_B("VALUE_B"),
  VALUE_C("VALUE_C");

  private final String value;

  EnumDescription(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class EnumDescriptionAdapter implements JsonbAdapter<EnumDescription, JsonString> {
      @Override
      public JsonString adaptToJson(EnumDescription e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public EnumDescription adaptFromJson(JsonString value) throws Exception {
          for (EnumDescription b : EnumDescription.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type EnumDescription");
      }
  }
}
