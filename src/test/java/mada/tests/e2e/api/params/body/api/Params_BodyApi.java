/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.body.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.params.body.dto.Simple;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/body")
public interface Params_BodyApi {

  /**
   * apiParamsBodyBooleanPrimitiveGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-primitive")
  String apiParamsBodyBooleanPrimitiveGet(boolean dto);

  /**
   * apiParamsBodyBooleanWrapperGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-wrapper")
  String apiParamsBodyBooleanWrapperGet(boolean dto);

  /**
   * apiParamsBodyDateGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/date")
  String apiParamsBodyDateGet(LocalDate dto);

  /**
   * apiParamsBodyDateTimeGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/date-time")
  String apiParamsBodyDateTimeGet(OffsetDateTime dto);

  /**
   * apiParamsBodyListGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/list")
  String apiParamsBodyListGet(List<String> dto);

  /**
   * apiParamsBodyListSimpleGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/list-simple")
  String apiParamsBodyListSimpleGet(List<Simple> dto);

  /**
   * apiParamsBodyMixedInPathGet
   *
   * @param inPath  (required)
   * @param query  (optional)
   * @param item  (optional)
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/mixed/{in-path}")
  String apiParamsBodyMixedInPathGet(@PathParam("in-path") String inPath, @QueryParam("query") String query, @HeaderParam("item") List<String> item, Simple dto);

  /**
   * apiParamsBodySimpleGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/simple")
  String apiParamsBodySimpleGet(Simple dto);

  /**
   * apiParamsBodyTimeGet
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/time")
  String apiParamsBodyTimeGet(LocalTime dto);
}
