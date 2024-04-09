/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.security.individual.api;

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
   *
   * @param auth  (not null)
   */
  @GET
  @Path("/on")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiSecurityOnGet(@HeaderParam("Authorization") String auth);
}
