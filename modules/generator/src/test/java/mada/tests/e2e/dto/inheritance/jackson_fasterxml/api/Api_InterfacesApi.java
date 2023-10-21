/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.inheritance.jackson_fasterxml.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

import mada.tests.e2e.dto.inheritance.jackson_fasterxml.dto.SubASubB;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/interfaces/super")
public interface Api_InterfacesApi {

  /**
   * apiInterfacesSuperGet.
   *
   * @return SubASubB
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SubASubB.class)
  SubASubB apiInterfacesSuperGet();
}
