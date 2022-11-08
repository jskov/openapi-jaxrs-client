/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.jackson.custom_offset_dates.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _LocalDateJacksonDeserializer extends JsonDeserializer<LocalDate> {
  @Override
  public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    return LocalDate.parse(jsonParser.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
  }
}
