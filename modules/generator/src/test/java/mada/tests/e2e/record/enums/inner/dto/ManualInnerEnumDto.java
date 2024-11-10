/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.enums.inner.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * ManualInnerEnumDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record ManualInnerEnumDto(
        @JsonbProperty("numberType") @JsonbTypeAdapter(mada.tests.e2e.record.enums.inner.dto.ManualInnerEnumDto.NumberTypeEnum.NumberTypeEnumAdapter.class) @Nullable NumberTypeEnum numberType,

        @JsonbProperty("receiver") @Nullable String receiver,

        @JsonbProperty("stringType") @JsonbTypeAdapter(mada.tests.e2e.record.enums.inner.dto.ManualInnerEnumDto.StringTypeEnum.StringTypeEnumAdapter.class) @Schema(
                description = "This selects transport form.\nEMAIL = this is an email\nSMS : this is an SMS") @Nullable StringTypeEnum stringType) {

    @Schema(enumeration = { "1", "2" }, type = SchemaType.INTEGER, format = "int32")
    public enum NumberTypeEnum {
        NUMBER_1(1),
        NUMBER_2(2);

        private final int value;

        NumberTypeEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class NumberTypeEnumAdapter implements JsonbAdapter<NumberTypeEnum, JsonString> {
            @Override
            public JsonString adaptToJson(NumberTypeEnum e) throws Exception {
                return Json.createValue(String.valueOf(e.value));
            }

            @Override
            public NumberTypeEnum adaptFromJson(JsonString value) throws Exception {
                for (NumberTypeEnum b : NumberTypeEnum.values()) {
                    if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                        return b;
                    }
                }
                throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type NumberTypeEnum");
            }
        }
    }

    /**
     * This selects transport form. EMAIL = this is an email SMS : this is an SMS
     */
    public enum StringTypeEnum {
        EMAIL("EMAIL"),
        SMS("SMS");

        private final String value;

        StringTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class StringTypeEnumAdapter implements JsonbAdapter<StringTypeEnum, JsonString> {
            @Override
            public JsonString adaptToJson(StringTypeEnum e) throws Exception {
                return Json.createValue(String.valueOf(e.value));
            }

            @Override
            public StringTypeEnum adaptFromJson(JsonString value) throws Exception {
                for (StringTypeEnum b : StringTypeEnum.values()) {
                    if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                        return b;
                    }
                }
                throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StringTypeEnum");
            }
        }
    }

}
