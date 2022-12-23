/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.unknown_enum.jackson.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * IntEnum
 */
@Schema(enumeration = {"1", "2", "-3", "unknown_default_open_api"}, type = SchemaType.INTEGER, format = "int32")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum IntEnum {
  NUMBER_1(1),
  NUMBER_2(2),
  NUMBER_NEG_3(-3),
  NUMBER_unknown_default_open_api(unknown_default_open_api);

  private final int value;

  IntEnum(int value) {
    this.value = value;
  }

  @JsonValue
  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static IntEnum fromValue(int value) {
    for (IntEnum b : IntEnum.values()) {
      if (b.value == value) {
        return b;
      }
    }
    return NUMBER_unknown_default_open_api;
  }
}
