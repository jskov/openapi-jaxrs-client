/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.path.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/path")
public interface Params_PathApi {

  /**
   * apiParamsPathGet
   *
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsPathGet();

  /**
   * apiParamsPathByteByteIdGet
   *
   * @param byteId  (required)
   * @return String
   */
  @GET
  @Path("/byte/{byteId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsPathByteByteIdGet(@PathParam("byteId") byte byteId);

  /**
   * apiParamsPathIntIntIdGet
   *
   * @param intId  (required)
   * @return String
   */
  @GET
  @Path("/int/{intId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsPathIntIntIdGet(@PathParam("intId") int intId);

  /**
   * apiParamsPathLongLongIdGet
   *
   * @param longId  (required)
   * @return String
   */
  @GET
  @Path("/long/{longId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsPathLongLongIdGet(@PathParam("longId") long longId);

  /**
   * apiParamsPathShortShortIdGet
   *
   * @param shortId  (required)
   * @return String
   */
  @GET
  @Path("/short/{shortId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsPathShortShortIdGet(@PathParam("shortId") short shortId);

  /**
   * apiParamsPathStringStringIdGet
   *
   * @param stringId  (required)
   * @return String
   */
  @GET
  @Path("/string/{stringId}")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsPathStringStringIdGet(@PathParam("stringId") String stringId);
}
