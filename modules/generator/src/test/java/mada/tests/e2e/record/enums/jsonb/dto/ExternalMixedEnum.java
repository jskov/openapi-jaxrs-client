/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.enums.jsonb.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ExternalMixedEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.record.enums.jsonb.dto.ExternalMixedEnum.ExternalMixedEnumAdapter.class)
@Schema(enumeration = {"low_EXT_a", "low_ext_B"}, type = SchemaType.STRING)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum ExternalMixedEnum {
    LOW_EXT_A("low_EXT_a"),
    LOW_EXT_B("low_ext_B");

    private final String value;

    ExternalMixedEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class ExternalMixedEnumAdapter implements JsonbAdapter<ExternalMixedEnum, JsonString> {
        @Override
        public JsonString adaptToJson(ExternalMixedEnum e) throws Exception {
            return Json.createValue(String.valueOf(e.value));
        }

        @Override
        public ExternalMixedEnum adaptFromJson(JsonString value) throws Exception {
            for (ExternalMixedEnum b : ExternalMixedEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ExternalMixedEnum");
        }
    }
}
