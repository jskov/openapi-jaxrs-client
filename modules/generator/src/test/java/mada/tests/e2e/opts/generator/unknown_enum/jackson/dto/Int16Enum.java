/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.unknown_enum.jackson.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Int16Enum
 */
@Schema(enumeration = {"1", "2", "-3", "-8531"})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum Int16Enum {
  NUMBER_1((short)1),
  NUMBER_2((short)2),
  NUMBER_NEG_3((short)-3),
  UNKNOWN_DEFAULT_OPEN_API((short)-8531);

  private final short value;

  Int16Enum(short value) {
    this.value = value;
  }

  @JsonValue
  public short getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Int16Enum fromValue(short value) {
    for (Int16Enum b : Int16Enum.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
