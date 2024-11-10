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
 * InnerEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.opts.generator.unknown_enum.jsonb.dto.InnerEnum.InnerEnumAdapter.class)
@Schema(enumeration = {"I", "J", "unknown_default_open_api"}, type = SchemaType.STRING)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum InnerEnum {
    I("I"),
    J("J"),
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private final String value;

    InnerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class InnerEnumAdapter implements JsonbAdapter<InnerEnum, JsonString> {
        @Override
        public JsonString adaptToJson(InnerEnum e) throws Exception {
            return Json.createValue(String.valueOf(e.value));
        }

        @Override
        public InnerEnum adaptFromJson(JsonString value) throws Exception {
            for (InnerEnum b : InnerEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            return UNKNOWN_DEFAULT_OPEN_API;
        }
    }
}
