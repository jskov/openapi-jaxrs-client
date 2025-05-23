/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.anyof.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_1.anyof.dto.ImplA_ImplB;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/interfaces/list")
public interface Api_InterfacesApi {

  /**
   * Get Interface List.
   *
   * @return ImplA_ImplB
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplA_ImplB.class)
  @Operation(summary = "Get Interface List")
  ImplA_ImplB apiInterfacesListGet();
}
