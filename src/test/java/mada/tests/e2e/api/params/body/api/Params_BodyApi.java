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
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.params.body.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/body")
public interface Params_BodyApi {

  /**
   * apiParamsBodyBooleanPrimitiveGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/boolean-primitive")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyBooleanPrimitiveGet( boolean dto);

  /**
   * apiParamsBodyBooleanWrapperGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/boolean-wrapper")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyBooleanWrapperGet( boolean dto);

  /**
   * apiParamsBodyDateGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/date")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyDateGet( LocalDate dto);

  /**
   * apiParamsBodyDateTimeGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/date-time")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyDateTimeGet( OffsetDateTime dto);

  /**
   * apiParamsBodyListGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/list")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyListGet( List<String> dto);

  /**
   * apiParamsBodyListSimpleGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/list-simple")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyListSimpleGet( List<Simple> dto);

  /**
   * apiParamsBodyMixedInPathGet.
   *
   * @param inPath  (required)
   * @param query  (optional)
   * @param item  (optional)
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/mixed/{in-path}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyMixedInPathGet(@PathParam("in-path") @NotNull String inPath, @QueryParam("query") String query, @HeaderParam("item") List<String> item, Simple dto);

  /**
   * apiParamsBodySimpleGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/simple")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodySimpleGet( Simple dto);

  /**
   * apiParamsBodyTimeGet.
   *
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/time")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyTimeGet( LocalTime dto);
}
