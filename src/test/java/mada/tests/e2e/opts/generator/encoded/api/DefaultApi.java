/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.encoded.api;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface DefaultApi {

  /**
   * encodedEncodedGet.
   *
   * @param encoded  (required)
   * @return String
   */
  @GET
  @Path("encoded/{encoded}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String encodedEncodedGet(@PathParam("encoded") @Encoded @NotNull String encoded);

  /**
   * encodedEncodedRawRawGet.
   *
   * @param encoded  (required)
   * @param raw  (required)
   * @param query  (optional)
   * @param item  (optional)
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("encoded/{encoded}/raw/{raw}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String encodedEncodedRawRawGet(@PathParam("encoded") @Encoded @NotNull String encoded, @PathParam("raw") @NotNull String raw, @QueryParam("query") String query, @HeaderParam("item") List<String> item, String dto);

  /**
   * rawRawGet.
   *
   * @param raw  (required)
   * @param query  (optional)
   * @param item  (optional)
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("raw/{raw}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String rawRawGet(@PathParam("raw") @NotNull String raw, @QueryParam("query") String query, @HeaderParam("item") List<String> item, String dto);
}
