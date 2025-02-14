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
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/path")
public interface Params_PathApi {

  /**
   * No Args.
   *
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "No Args")
  String apiParamsPathGet();

  /**
   * With Byte.
   *
   * @param byteId
   * @return String
   */
  @GET
  @Path("/byte/{byteId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "With Byte")
  String apiParamsPathByteByteIdGet(@PathParam("byteId") byte byteId);

  /**
   * With Int.
   *
   * @param intId
   * @return String
   */
  @GET
  @Path("/int/{intId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "With Int")
  String apiParamsPathIntIntIdGet(@PathParam("intId") int intId);

  /**
   * With Long.
   *
   * @param longId
   * @return String
   */
  @GET
  @Path("/long/{longId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "With Long")
  String apiParamsPathLongLongIdGet(@PathParam("longId") long longId);

  /**
   * With Short.
   *
   * @param shortId
   * @return String
   */
  @GET
  @Path("/short/{shortId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "With Short")
  String apiParamsPathShortShortIdGet(@PathParam("shortId") short shortId);

  /**
   * With Str.
   *
   * @param stringId  (not null)
   * @return String
   */
  @GET
  @Path("/string/{stringId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "With Str")
  String apiParamsPathStringStringIdGet(@PathParam("stringId") @NotNull String stringId);
}
