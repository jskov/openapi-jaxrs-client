/*
 *
 *
 * The version of the OpenAPI document:
 */

package mada.tests.e2e.opts.generator.operationid.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/employees/{userId}")
public interface DefaultApi {

  /**
   * stupid_long_prefix_getInfo.
   *
   * @param userId  (required)
   * @return String
   */
  @GET
  @Path("/info")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String stupid_long_prefix_getInfo(@PathParam("userId") @NotNull String userId);

  /**
   * stupid_long_prefix_getPhoto.
   *
   * @param userId  (required)
   * @return String
   */
  @GET
  @Path("/photo")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String stupid_long_prefix_getPhoto(@PathParam("userId") @NotNull String userId);
}
