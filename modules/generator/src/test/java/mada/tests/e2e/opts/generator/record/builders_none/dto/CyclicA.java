/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.record.builders_none.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * CyclicA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicA(
  @JsonbProperty("b")
  @Valid
  CyclicB b) {

}
