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
 * Int32Enum
 */
@Schema(enumeration = {"1", "2", "-3", "2125323949"}, type = SchemaType.INTEGER, format = "int32")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum Int32Enum {
  NUMBER_1(1),
  NUMBER_2(2),
  NUMBER_NEG_3(-3),
  UNKNOWN_DEFAULT_OPEN_API(2125323949);

  private final int value;

  Int32Enum(int value) {
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
  public static Int32Enum fromValue(int value) {
    for (Int32Enum b : Int32Enum.values()) {
      if (b.value == value) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
