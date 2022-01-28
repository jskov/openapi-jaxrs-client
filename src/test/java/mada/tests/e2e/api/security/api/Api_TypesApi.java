/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.security.api;

import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types/void")
public interface Api_TypesApi {

  /**
   * apiTypesVoidGet
   *
   * @param auth  (required)
   * @return void
   */
  @GET
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiTypesVoidGet(@HeaderParam("Authorization") String auth);
}
