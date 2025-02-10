/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/methods")
public interface Api_MethodsApi {

  /**
   * Delete.
   *
   * @param dto  (not null)
   */
  @DELETE
  @Path("/DELETE")
  @Consumes(MediaType.TEXT_PLAIN)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  @Operation(summary = "Delete")
  void apiMethodsDELETEDelete(@NotNull String dto);

  /**
   * Get.
   *
   * @return String
   */
  @GET
  @Path("/GET")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Get")
  String apiMethodsGETGet();

  /**
   * Head.
   *
   * @return String
   */
  @HEAD
  @Path("/HEAD")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Head")
  String apiMethodsHEADHead();

  /**
   * Post.
   *
   * @param dto  (not null)
   * @return String
   */
  @POST
  @Path("/POST")
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Post")
  String apiMethodsPOSTPost(@NotNull String dto);

  /**
   * Put.
   *
   * @param dto  (not null)
   * @return String
   */
  @PUT
  @Path("/PUT")
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Put")
  String apiMethodsPUTPut(@NotNull String dto);
}
