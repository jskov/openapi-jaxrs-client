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
import mada.tests.e2e.api.interfaces.dto.ImplAImplB;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/interfaces")
public interface Api_InterfacesApi {

  /**
   * apiInterfacesInterfaceGet.
   *
   * @return ImplAImplB
   */
  @GET
  @Path("/interface")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplAImplB.class)
  ImplAImplB apiInterfacesInterfaceGet();

  /**
   * apiInterfacesListGet.
   *
   * @return ImplAImplB
   */
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ImplAImplB.class)
  ImplAImplB apiInterfacesListGet();
}
