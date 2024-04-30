/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Can take a value of access_token_refresh_token, or access_token, or refresh_token.
 */
@JsonbTypeAdapter(mada.tests.e2e.examples.azure.dto.FormData_Grant_type.FormData_Grant_typeAdapter.class)
@Schema(enumeration = {"access_token_refresh_token", "access_token", "refresh_token"}, type = SchemaType.STRING, description = "Can take a value of access_token_refresh_token, or access_token, or refresh_token")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum FormData_Grant_type {
  ACCESS_TOKEN_REFRESH_TOKEN("access_token_refresh_token"),
  ACCESS_TOKEN("access_token"),
  REFRESH_TOKEN("refresh_token");

  private final String value;

  FormData_Grant_type(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class FormData_Grant_typeAdapter implements JsonbAdapter<FormData_Grant_type, JsonString> {
      @Override
      public JsonString adaptToJson(FormData_Grant_type e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public FormData_Grant_type adaptFromJson(JsonString value) throws Exception {
          for (FormData_Grant_type b : FormData_Grant_type.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type FormData_Grant_type");
      }
  }
}
