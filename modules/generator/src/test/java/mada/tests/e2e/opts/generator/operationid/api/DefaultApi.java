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
   * getInfo.
   *
   * @param userId  (required)
   * @return String
   */
  @GET
  @Path("/info")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String getInfo(@PathParam("userId") @NotNull String userId);

  /**
   * employeesUserIdNoOperationIdGet.
   *
   * @param userId  (required)
   * @return String
   */
  @GET
  @Path("/noOperationId")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String employeesUserIdNoOperationIdGet(@PathParam("userId") @NotNull String userId);

  /**
   * getPhoto.
   *
   * @param userId  (required)
   * @return String
   */
  @GET
  @Path("/photo")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String getPhoto(@PathParam("userId") @NotNull String userId);
}
