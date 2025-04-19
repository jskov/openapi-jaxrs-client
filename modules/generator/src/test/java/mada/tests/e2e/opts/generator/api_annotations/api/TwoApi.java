/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.api_annotations.api;

import javax.ws.rs.*;

@org.junit.jupiter.api.condition.DisabledIf(value = "value", disabledReason = "whatever\nwith breaks")
@org.junit.jupiter.api.condition.DisabledOnOs(architectures = "mos6502", disabledReason = "coz way too old")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/call/two")
public interface TwoApi {

  /**
   * callTwoGet.
   */
  @GET
  void callTwoGet();
}
