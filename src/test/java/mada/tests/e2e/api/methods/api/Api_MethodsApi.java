/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.methods.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/methods")
public interface Api_MethodsApi {

  /**
   * apiMethodsDELETEDelete
   *
   * @param dto  (optional)
   * @return void
   */
  @DELETE
  @Path("/DELETE")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiMethodsDELETEDelete(String dto);

  /**
   * apiMethodsGETGet
   *
   * @return String
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/GET")
  @APIResponseSchema(String.class)
  String apiMethodsGETGet();

  /**
   * apiMethodsHEADHead
   *
   * @return String
   */
  @HEAD
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/HEAD")
  @APIResponseSchema(String.class)
  String apiMethodsHEADHead();

  /**
   * apiMethodsPOSTPost
   *
   * @param dto  (optional)
   * @return String
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/POST")
  @APIResponseSchema(String.class)
  String apiMethodsPOSTPost(String dto);

  /**
   * apiMethodsPUTPut
   *
   * @param dto  (optional)
   * @return String
   */
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/PUT")
  @APIResponseSchema(String.class)
  String apiMethodsPUTPut(String dto);
}
