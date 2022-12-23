/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.unknown_enum.jackson.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ExternalLowerEnum
 */
@Schema(enumeration = {"low_ext_a", "low_ext_b", "unknown_default_open_api"}, type = SchemaType.STRING)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum ExternalLowerEnum {
  LOW_EXT_A("low_ext_a"),
  LOW_EXT_B("low_ext_b"),
  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private final String value;

  ExternalLowerEnum(String value) {
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
  public static ExternalLowerEnum fromValue(String value) {
    for (ExternalLowerEnum b : ExternalLowerEnum.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}
