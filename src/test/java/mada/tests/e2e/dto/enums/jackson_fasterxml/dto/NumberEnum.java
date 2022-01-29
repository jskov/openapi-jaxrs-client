/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * NumberEnum
 */
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public enum NumberEnum {
  NUMBER_1(1),
  NUMBER_2(2);

  private final int value;

  NumberEnum(int value) {
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
  public static NumberEnum fromValue(int value) {
    for (NumberEnum b : NumberEnum.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
