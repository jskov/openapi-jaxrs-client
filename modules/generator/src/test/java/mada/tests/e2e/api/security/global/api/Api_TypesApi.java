/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.api.security.global.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types/void")
public interface Api_TypesApi {

  /**
   * apiTypesVoidGet.
   *
   * @param auth  (not null)
   */
  @GET
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiTypesVoidGet(@HeaderParam("Authorization") @NotNull String auth);
}
