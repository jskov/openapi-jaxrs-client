package mada.tests.e2e.dto.oneof;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class KunderumLocalDateDeserializer extends JsonDeserializer<LocalDate> {
	@Override
	public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
		return LocalDate.parse(jsonParser.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
	}
}