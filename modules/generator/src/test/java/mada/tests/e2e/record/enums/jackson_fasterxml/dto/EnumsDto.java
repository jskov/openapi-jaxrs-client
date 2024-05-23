/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.enums.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * EnumsDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record EnumsDto(
  @JsonProperty("external")
  @Valid
  ExternalEnum external,

  @JsonProperty("externalLower")
  @Valid
  ExternalLowerEnum externalLower,

  @JsonProperty("externalMixed")
  @Valid
  ExternalMixedEnum externalMixed,

  @JsonProperty("inner")
  @Valid
  InnerEnum inner,

  @JsonProperty("integerEnum")
  @Valid
  IntEnum integerEnum,

  @JsonProperty("lower")
  @Valid
  InnerLowerEnum lower,

  @JsonProperty("mixed")
  @Valid
  InnerMixedEnum mixed,

  @JsonProperty("propertyEnumString")
  PropertyEnumStringEnum propertyEnumString,

  @JsonProperty("stringIntegerEnum")
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

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PropertyEnumStringEnum fromValue(String value) {
      for (PropertyEnumStringEnum b : PropertyEnumStringEnum.values()) {
        if (Objects.equals(b.value, value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

}
