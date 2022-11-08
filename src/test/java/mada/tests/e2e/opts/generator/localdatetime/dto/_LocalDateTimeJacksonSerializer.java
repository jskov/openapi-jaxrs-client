/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.localdatetime.dto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _LocalDateTimeJacksonSerializer extends JsonSerializer<LocalDateTime> {
  @Override
  public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider)
           throws IOException, JsonProcessingException {
    jgen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }
}
