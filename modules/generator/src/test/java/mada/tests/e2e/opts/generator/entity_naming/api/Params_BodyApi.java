/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.entity_naming.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.entity_naming.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/body")
public interface Params_BodyApi {

  /**
   * apiParamsBodyBooleanPrimitiveGet.
   *
   * @param boolean_
   * @return String
   */
  @GET
  @Path("/boolean-primitive")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyBooleanPrimitiveGet(boolean boolean_);

  /**
   * apiParamsBodyBooleanWrapperGet.
   *
   * @param boolean_
   * @return String
   */
  @GET
  @Path("/boolean-wrapper")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyBooleanWrapperGet(boolean boolean_);

  /**
   * apiParamsBodyDateGet.
   *
   * @param localDate  (optional)
   * @return String
   */
  @GET
  @Path("/date")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyDateGet(LocalDate localDate);

  /**
   * apiParamsBodyDateTimeGet.
   *
   * @param offsetDateTime  (optional)
   * @return String
   */
  @GET
  @Path("/date-time")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyDateTimeGet(OffsetDateTime offsetDateTime);

  /**
   * apiParamsBodyListGet.
   *
   * @param list_String_  (optional)
   * @return String
   */
  @GET
  @Path("/list")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyListGet(List<String> list_String_);

  /**
   * apiParamsBodyListSimpleGet.
   *
   * @param list_Simple_  (optional)
   * @return String
   */
  @GET
  @Path("/list-simple")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyListSimpleGet(@Valid List<Simple> list_Simple_);

  /**
   * apiParamsBodyMixedInPathGet.
   *
   * @param inPath  (not null)
   * @param query  (optional)
   * @param item  (optional)
   * @param simple  (optional)
   * @return String
   */
  @GET
  @Path("/mixed/{in-path}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyMixedInPathGet(@PathParam("in-path") @NotNull String inPath, @QueryParam("query") String query, @HeaderParam("item") List<String> item, @Valid Simple simple);

  /**
   * apiParamsBodySimpleGet.
   *
   * @param simple  (optional)
   * @return String
   */
  @GET
  @Path("/simple")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodySimpleGet(@Valid Simple simple);

  /**
   * apiParamsBodyTimeGet.
   *
   * @param localTime  (optional)
   * @return String
   */
  @GET
  @Path("/time")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsBodyTimeGet(LocalTime localTime);
}
