/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.validation_api.dto;

import java.util.Objects;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Environment
 */
@Schema(enumeration = {"test", "qa", "production"}, type = SchemaType.STRING)
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public enum Environment {
  TEST("test"),
  QA("qa"),
  PRODUCTION("production");

  private final String value;

  Environment(String value) {
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
  public static Environment fromValue(String value) {
    for (Environment b : Environment.values()) {
      if (Objects.equals(b.value, value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
