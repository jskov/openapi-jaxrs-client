/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.record.cyclic.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.jspecify.annotations.Nullable;

/**
 * CyclicB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicB(
  @JsonbProperty("a")
  @Valid
  @Nullable
  CyclicA a) {

}
