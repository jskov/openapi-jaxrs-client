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
 * Int64Enum
 */
@Schema(enumeration = {"1", "2", "-3", "9128196858096508589"})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum Int64Enum {
  ___1(1L),
  ___2(2L),
  _3(-3L),
  UNKNOWN_DEFAULT_OPEN_API(9128196858096508589L);

  private final long value;

  Int64Enum(long value) {
    this.value = value;
  }

  @JsonValue
  public long getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Int64Enum fromValue(long value) {
    for (Int64Enum b : Int64Enum.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
