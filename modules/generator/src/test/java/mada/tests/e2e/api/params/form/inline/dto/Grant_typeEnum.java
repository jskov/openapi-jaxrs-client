/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.api.params.form.inline.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Grant type is expected to be refresh_token
 */
@JsonbTypeAdapter(mada.tests.e2e.api.params.form.inline.dto.Grant_typeEnum.Grant_typeAdapter.class)
@Schema(enumeration = { "refresh_token" }, type = SchemaType.STRING)
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public enum Grant_typeEnum {
    REFRESH_TOKEN("refresh_token");

    private final String value;

    Grant_typeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class Grant_typeAdapter implements JsonbAdapter<Grant_typeEnum, JsonString> {
        @Override
        public JsonString adaptToJson(Grant_typeEnum e) throws Exception {
            return Json.createValue(String.valueOf(e.value));
        }

        @Override
        public Grant_typeEnum adaptFromJson(JsonString value) throws Exception {
            for (Grant_typeEnum b : Grant_typeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type Grant_type");
        }
    }
}
