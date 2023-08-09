/*
 *
 *
 * The version of the OpenAPI document:
 */

package mada.tests.e2e.opts.generator.operator_naming.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/employees/{userId}")
public interface DefaultApi {

  /**
   * infoGet.
   *
   * @param userId  (required)
   * @return String
   */
  @GET
  @Path("/info")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String infoGet(@PathParam("userId") @NotNull String userId);

  /**
   * photoGet.
   *
   * @param userId  (required)
   * @return String
   */
  @GET
  @Path("/photo")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String photoGet(@PathParam("userId") @NotNull String userId);
}
