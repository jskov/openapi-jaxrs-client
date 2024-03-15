/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: 1.0.0+openapi_API_Version
 */

package mada.tests.e2e.dto.discriminator_invalid.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * IdentificationType
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.discriminator_invalid.dto.IdentificationType.IdentificationTypeAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum IdentificationType {
  PRIVATE("PRIVATE"),
  VIRK_PERSON("VIRK_PERSON"),
  SMS_MAIL("SMS_MAIL");

  private final String value;

  IdentificationType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class IdentificationTypeAdapter implements JsonbAdapter<IdentificationType, JsonString> {
      @Override
      public JsonString adaptToJson(IdentificationType e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public IdentificationType adaptFromJson(JsonString value) throws Exception {
          for (IdentificationType b : IdentificationType.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type IdentificationType");
      }
  }
}
