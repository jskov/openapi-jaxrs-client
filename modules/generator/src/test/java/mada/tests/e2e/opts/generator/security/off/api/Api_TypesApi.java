/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.security.off.api;

import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/security")
public interface Api_TypesApi {

  /**
   * apiSecurityOffGet.
   */
  @GET
  @Path("/off")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiSecurityOffGet();

  /**
   * apiSecurityOnGet.
   */
  @GET
  @Path("/on")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiSecurityOnGet();
}
