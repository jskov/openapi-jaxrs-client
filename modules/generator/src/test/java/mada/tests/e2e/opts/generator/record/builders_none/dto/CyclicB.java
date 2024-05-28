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
 * CyclicB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicB(
  @JsonbProperty("a")
  @Valid
  CyclicA a) {

}
