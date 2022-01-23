/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.params.path.api;

import javax.ws.rs.*;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/path")
public interface Params_PathApi {

  /**
   * apiParamsPathGET
   *
   * @return String
   */
  @GET
  @Produces("text/plain")
  String apiParamsPathGET();

  /**
   * apiParamsPathByteByteIdGET
   *
   * @param byteId  (optional)
   * @return String
   */
  @GET
  @Produces("text/plain")
  @Path("/byte/{byteId}")
  String apiParamsPathByteByteIdGET(@PathParam("byteId") byte byteId);

  /**
   * apiParamsPathIntIntIdGET
   *
   * @param intId  (optional)
   * @return String
   */
  @GET
  @Produces("text/plain")
  @Path("/int/{intId}")
  String apiParamsPathIntIntIdGET(@PathParam("intId") int intId);

  /**
   * apiParamsPathLongLongIdGET
   *
   * @param longId  (optional)
   * @return String
   */
  @GET
  @Produces("text/plain")
  @Path("/long/{longId}")
  String apiParamsPathLongLongIdGET(@PathParam("longId") long longId);

  /**
   * apiParamsPathShortShortIdGET
   *
   * @param shortId  (optional)
   * @return String
   */
  @GET
  @Produces("text/plain")
  @Path("/short/{shortId}")
  String apiParamsPathShortShortIdGET(@PathParam("shortId") short shortId);

  /**
   * apiParamsPathStringStringIdGET
   *
   * @param stringId  (optional)
   * @return String
   */
  @GET
  @Produces("text/plain")
  @Path("/string/{stringId}")
  String apiParamsPathStringStringIdGET(@PathParam("stringId") String stringId);
}
