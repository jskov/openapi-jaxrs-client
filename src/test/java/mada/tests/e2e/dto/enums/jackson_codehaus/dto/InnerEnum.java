/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jackson_codehaus.dto;

import java.util.Objects;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * InnerEnum
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum InnerEnum {
  I("I"),
  J("J");

  private final String value;

  InnerEnum(String value) {
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
  public static InnerEnum fromValue(String value) {
    for (InnerEnum b : InnerEnum.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
