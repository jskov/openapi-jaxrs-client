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
import mada.tests.e2e.specs.v3_1.all.dto.ImplAImplB;
import mada.tests.e2e.specs.v3_1.all.dto.SubASubB;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/interfaces")
public interface Api_InterfacesApi {

  /**
   * Get Interface.
   *
   * @return ImplAImplB
   */
  @GET
  @Path("/interface")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplAImplB.class)
  @Operation(summary = "Get Interface")
  ImplAImplB apiInterfacesInterfaceGet();

  /**
   * Get Interface List.
   *
   * @return ImplAImplB
   */
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplAImplB.class)
  @Operation(summary = "Get Interface List")
  ImplAImplB apiInterfacesListGet();

  /**
   * Get Super.
   *
   * @return SubASubB
   */
  @GET
  @Path("/super")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SubASubB.class)
  @Operation(summary = "Get Super")
  SubASubB apiInterfacesSuperGet();
}
