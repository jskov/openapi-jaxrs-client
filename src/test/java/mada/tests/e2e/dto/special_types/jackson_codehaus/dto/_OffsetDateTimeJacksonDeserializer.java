/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.special_types.jackson_codehaus.dto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _OffsetDateTimeJacksonDeserializer extends JsonDeserializer<OffsetDateTime> {
  @Override
  public OffsetDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
           throws IOException, JsonProcessingException {
    String wireText = jp.getText();

    try {
      // This decodes with RFC3339/ISO-8601 (requires timezone offset)
      return OffsetDateTime.parse(wireText, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    } catch (DateTimeParseException e) {
      // If the above failed, assume it is because there is no timezone and try localtime.
      return LocalDateTime.parse(wireText, DateTimeFormatter.ISO_LOCAL_DATE_TIME).atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }
  }
}
