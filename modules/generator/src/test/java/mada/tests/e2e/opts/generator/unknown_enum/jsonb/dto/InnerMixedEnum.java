/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * InnerMixedEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto.InnerMixedEnum.InnerMixedEnumAdapter.class)
@Schema(enumeration = { "MIXED_a", "mixed_B", "unknown_default_open_api" }, type = SchemaType.STRING)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum InnerMixedEnum {
    MIXED_A("MIXED_a"),
    MIXED_B("mixed_B"),
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private final String value;

    InnerMixedEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class InnerMixedEnumAdapter implements JsonbAdapter<InnerMixedEnum, JsonString> {
        @Override
        public JsonString adaptToJson(InnerMixedEnum e) throws Exception {
            return Json.createValue(String.valueOf(e.value));
        }

        @Override
        public InnerMixedEnum adaptFromJson(JsonString value) throws Exception {
            for (InnerMixedEnum b : InnerMixedEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            return UNKNOWN_DEFAULT_OPEN_API;
        }
    }
}
