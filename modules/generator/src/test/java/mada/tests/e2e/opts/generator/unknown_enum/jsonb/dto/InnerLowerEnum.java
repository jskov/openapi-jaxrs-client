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
 * InnerLowerEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto.InnerLowerEnum.InnerLowerEnumAdapter.class)
@Schema(enumeration = {"lower_a", "lower_b", "unknown_default_open_api"}, type = SchemaType.STRING)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum InnerLowerEnum {
    LOWER_A("lower_a"),
    LOWER_B("lower_b"),
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private final String value;

    InnerLowerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class InnerLowerEnumAdapter implements JsonbAdapter<InnerLowerEnum, JsonString> {
        @Override
        public JsonString adaptToJson(InnerLowerEnum e) throws Exception {
            return Json.createValue(String.valueOf(e.value));
        }

        @Override
        public InnerLowerEnum adaptFromJson(JsonString value) throws Exception {
            for (InnerLowerEnum b : InnerLowerEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            return UNKNOWN_DEFAULT_OPEN_API;
        }
    }
}
