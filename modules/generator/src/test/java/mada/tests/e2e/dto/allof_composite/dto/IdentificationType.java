/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * IdentificationType
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum IdentificationType {
  VIRK_PERSON("VIRK_PERSON"),
  SMS_MAIL("SMS_MAIL");

  private final String value;

  IdentificationType(String value) {
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
  public static IdentificationType fromValue(String value) {
    for (IdentificationType b : IdentificationType.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
