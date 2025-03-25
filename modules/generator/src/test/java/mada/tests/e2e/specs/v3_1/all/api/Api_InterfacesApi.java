/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_1.all.dto.ImplA_ImplB;
import mada.tests.e2e.specs.v3_1.all.dto.SubA_SubB;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/interfaces")
public interface Api_InterfacesApi {

  /**
   * Get Interface.
   *
   * @return ImplA_ImplB
   */
  @GET
  @Path("/interface")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplA_ImplB.class)
  @Operation(summary = "Get Interface")
  ImplA_ImplB apiInterfacesInterfaceGet();

  /**
   * Get Interface List.
   *
   * @return ImplA_ImplB
   */
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplA_ImplB.class)
  @Operation(summary = "Get Interface List")
  ImplA_ImplB apiInterfacesListGet();

  /**
   * Get Super.
   *
   * @return SubA_SubB
   */
  @GET
  @Path("/super")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SubA_SubB.class)
  @Operation(summary = "Get Super")
  SubA_SubB apiInterfacesSuperGet();
}
