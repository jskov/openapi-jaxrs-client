/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.unknown_enum.jackson.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * NumberEnum
 */
@Schema(enumeration = {"1", "2", "-3", "unknown_default_open_api"})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum NumberEnum {
  ___1(new BigDecimal("1")),
  ___2(new BigDecimal("2")),
  _3(new BigDecimal("-3")),
  UNKNOWN_DEFAULT_OPEN_API(new BigDecimal("2125323949"));

  private final BigDecimal value;

  NumberEnum(BigDecimal value) {
    this.value = value;
  }

  @JsonValue
  public BigDecimal getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static NumberEnum fromValue(BigDecimal value) {
    for (NumberEnum b : NumberEnum.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
