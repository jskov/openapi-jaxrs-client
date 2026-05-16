/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.record.empty.dto;

import javax.json.bind.annotation.JsonbProperty;
import org.jspecify.annotations.Nullable;

/**
 * NotEmpty
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record NotEmpty(
  @JsonbProperty("a")
  @Nullable
  String a) {

}
