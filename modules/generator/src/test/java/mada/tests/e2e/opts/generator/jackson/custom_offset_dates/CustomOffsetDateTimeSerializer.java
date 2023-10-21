/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.jackson.custom_offset_dates;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class CustomOffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {
	@Override
	public void serialize(OffsetDateTime value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeString(value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
	}
}
