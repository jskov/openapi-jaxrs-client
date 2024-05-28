/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.enums.jsonb.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * EnumsDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record EnumsDto(
  @JsonbProperty("external")
  @Valid
  ExternalEnum external,

  @JsonbProperty("externalLower")
  @Valid
  ExternalLowerEnum externalLower,

  @JsonbProperty("externalMixed")
  @Valid
  ExternalMixedEnum externalMixed,

  @JsonbProperty("inner")
  @Valid
  InnerEnum inner,

  @JsonbProperty("integerEnum")
  @Valid
  IntEnum integerEnum,

  @JsonbProperty("lower")
  @Valid
  InnerLowerEnum lower,

  @JsonbProperty("mixed")
  @Valid
  InnerMixedEnum mixed,

  @JsonbProperty("propertyEnumString")
  @JsonbTypeAdapter(mada.tests.e2e.record.enums.jsonb.dto.EnumsDto.PropertyEnumStringEnum.PropertyEnumStringEnumAdapter.class)
  PropertyEnumStringEnum propertyEnumString,

  @JsonbProperty("stringIntegerEnum")
  @Valid
  StringIntEnum stringIntegerEnum) {


  @Schema(enumeration = {"O", "M", "nexT"}, type = SchemaType.STRING)
  public enum PropertyEnumStringEnum {
    O("O"),
    M("M"),
    NEXT("nexT");

    private final String value;

    PropertyEnumStringEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class PropertyEnumStringEnumAdapter implements JsonbAdapter<PropertyEnumStringEnum, JsonString> {
      @Override
      public JsonString adaptToJson(PropertyEnumStringEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public PropertyEnumStringEnum adaptFromJson(JsonString value) throws Exception {
        for (PropertyEnumStringEnum b : PropertyEnumStringEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type PropertyEnumStringEnum");
      }
    }
  }

}
