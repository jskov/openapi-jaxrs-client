package mada.tests.e2e.dto.oneof;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class KunderumLocalDateSerializer extends JsonSerializer<LocalDate> {
	@Override
	public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}
}
