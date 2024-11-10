/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jsonb.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * The values are digits, but the type is string. So will not be handled as integers, but are invalid Java identifiers.
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.enums.jsonb.dto.StringIntEnum.StringIntEnumAdapter.class)
@Schema(
        enumeration = { "1", "2", "-3" },
        type = SchemaType.STRING,
        description = "The values are digits, but the type is string. So will not be handled as integers, but are invalid Java identifiers.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum StringIntEnum {
    NUMBER_1("1"),
    NUMBER_2("2"),
    NUMBER_NEG_3("-3");

    private final String value;

    StringIntEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class StringIntEnumAdapter implements JsonbAdapter<StringIntEnum, JsonString> {
        @Override
        public JsonString adaptToJson(StringIntEnum e) throws Exception {
            return Json.createValue(String.valueOf(e.value));
        }

        @Override
        public StringIntEnum adaptFromJson(JsonString value) throws Exception {
            for (StringIntEnum b : StringIntEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StringIntEnum");
        }
    }
}
