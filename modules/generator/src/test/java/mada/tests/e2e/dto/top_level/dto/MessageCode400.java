/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.top_level.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Message codes defined for HTTP Error code.
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.top_level.dto.MessageCode400.MessageCode400Adapter.class)
@Schema(description = "Message codes defined for HTTP Error code.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum MessageCode400 {
  BAD_REQUEST("BAD_REQUEST");

  private final String value;

  MessageCode400(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class MessageCode400Adapter implements JsonbAdapter<MessageCode400, JsonString> {
      @Override
      public JsonString adaptToJson(MessageCode400 e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public MessageCode400 adaptFromJson(JsonString value) throws Exception {
          for (MessageCode400 b : MessageCode400.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type MessageCode400");
      }
  }
}
