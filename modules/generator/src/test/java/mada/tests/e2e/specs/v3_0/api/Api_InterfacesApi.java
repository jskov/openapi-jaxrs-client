/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_0.dto.ImplA_ImplB;
import mada.tests.e2e.specs.v3_0.dto.SubA_SubB;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/interfaces")
public interface Api_InterfacesApi {

  /**
   * apiInterfacesInterfaceGet.
   *
   * @return ImplA_ImplB
   */
  @GET
  @Path("/interface")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplA_ImplB.class)
  ImplA_ImplB apiInterfacesInterfaceGet();

  /**
   * apiInterfacesListGet.
   *
   * @return ImplA_ImplB
   */
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplA_ImplB.class)
  ImplA_ImplB apiInterfacesListGet();

  /**
   * apiInterfacesSuperGet.
   *
   * @return SubA_SubB
   */
  @GET
  @Path("/super")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SubA_SubB.class)
  SubA_SubB apiInterfacesSuperGet();
}
