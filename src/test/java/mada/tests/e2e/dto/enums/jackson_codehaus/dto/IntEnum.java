/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jackson_codehaus.dto;

import java.util.Objects;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * IntEnum
 */
@Schema(enumeration = {"1", "2", "-3"}, type = SchemaType.INTEGER, format = "int32")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum IntEnum {
  NUMBER_1(1),
  NUMBER_2(2),
  NUMBER_NEG_3(-3);

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
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
