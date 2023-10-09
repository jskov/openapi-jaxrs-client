/*
 * Naked Object Test
 *
 * The version of the OpenAPI document: v1
 */

package mada.tests.e2e.regression.plain_object.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.regression.plain_object.dto.Request;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v1/ap/ag")
public interface ApApi {

  /**
   * ap_ta.
   *
   * @param dto  (required)
   * @return Object
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Object.class)
  Object ap_ta(@NotNull @Valid Request dto);
}
