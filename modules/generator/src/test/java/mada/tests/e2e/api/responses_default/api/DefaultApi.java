/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.api.responses_default.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface DefaultApi {

  /**
   * getDefault.
   *
   * @return String
   */
  @GET
  @Path("getDefault")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response",
                 content = @Content(schema = @Schema(implementation = String.class)))
  })
  String getDefault();

  /**
   * getNoOutputType.
   *
   * @param foo  (not null)
   */
  @GET
  @Path("getNoOutputType")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response")
  })
  void getNoOutputType(@PathParam("foo") @NotNull String foo);

  /**
   * getOk.
   *
   * @return String
   */
  @GET
  @Path("getOk")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response",
                 content = @Content(schema = @Schema(implementation = Boolean.class))),
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = String.class)))
  })
  String getOk();

  /**
   * getOkWithTypeFromDefault.
   *
   * @return String
   */
  @GET
  @Path("getOkWithTypeFromDefault")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response",
                 content = @Content(schema = @Schema(implementation = String.class))),
    @APIResponse(responseCode = "200", description = "OK")
  })
  String getOkWithTypeFromDefault();

  /**
   * getOkWithVoid.
   */
  @GET
  @Path("getOkWithVoid")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK")
  })
  void getOkWithVoid();
}
