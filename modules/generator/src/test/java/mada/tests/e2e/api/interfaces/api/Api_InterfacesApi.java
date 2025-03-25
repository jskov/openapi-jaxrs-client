/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.api.interfaces.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.interfaces.dto.BadNameImplB_BadName_ImplA_ImplA_ImplB;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/interfaces")
public interface Api_InterfacesApi {

  /**
   * apiInterfacesInterfaceGet.
   *
   * @return BadNameImplB_BadName_ImplA_ImplA_ImplB
   */
  @GET
  @Path("/interface")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(BadNameImplB_BadName_ImplA_ImplA_ImplB.class)
  BadNameImplB_BadName_ImplA_ImplA_ImplB apiInterfacesInterfaceGet();

  /**
   * apiInterfacesListGet.
   *
   * @return BadNameImplB_BadName_ImplA_ImplA_ImplB
   */
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(BadNameImplB_BadName_ImplA_ImplA_ImplB.class)
  BadNameImplB_BadName_ImplA_ImplA_ImplB apiInterfacesListGet();
}
