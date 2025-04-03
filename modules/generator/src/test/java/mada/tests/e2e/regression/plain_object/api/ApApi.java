/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.regression.plain_object.api;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.regression.plain_object.dto.Primitives;
import mada.tests.e2e.regression.plain_object.dto.Request;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface ApApi {

  /**
   * dtosPrimitivesGet.
   *
   * @return Primitives
   */
  @GET
  @Path("dtos/primitives")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Primitives.class)
  Primitives dtosPrimitivesGet();

  /**
   * ap_ta.
   *
   * @param dto dto description (optional)
   * @return Object
   */
  @PUT
  @Path("v1/ap/ag")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Object.class)
  Object ap_ta(@Valid Request dto);
}
