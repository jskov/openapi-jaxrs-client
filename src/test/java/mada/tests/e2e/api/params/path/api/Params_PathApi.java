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
  String apiParamsPathGet();

  /**
   * apiParamsPathByteByteIdGet
   *
   * @param byteId  (required)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/byte/{byteId}")
  String apiParamsPathByteByteIdGet(@PathParam("byteId") byte byteId);

  /**
   * apiParamsPathIntIntIdGet
   *
   * @param intId  (required)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/int/{intId}")
  String apiParamsPathIntIntIdGet(@PathParam("intId") int intId);

  /**
   * apiParamsPathLongLongIdGet
   *
   * @param longId  (required)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/long/{longId}")
  String apiParamsPathLongLongIdGet(@PathParam("longId") long longId);

  /**
   * apiParamsPathShortShortIdGet
   *
   * @param shortId  (required)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/short/{shortId}")
  String apiParamsPathShortShortIdGet(@PathParam("shortId") short shortId);

  /**
   * apiParamsPathStringStringIdGet
   *
   * @param stringId  (required)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/string/{stringId}")
  String apiParamsPathStringStringIdGet(@PathParam("stringId") String stringId);
}
