/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_1.all.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/body")
public interface Params_BodyApi {

  /**
   * Query Boolean Primitive.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/boolean-primitive")
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Boolean Primitive")
  String apiParamsBodyBooleanPrimitiveGet(boolean dto);

  /**
   * Query Boolean Wrapper.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/boolean-wrapper")
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Boolean Wrapper")
  String apiParamsBodyBooleanWrapperGet(boolean dto);

  /**
   * Query Date.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/date")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Date")
  String apiParamsBodyDateGet(@NotNull LocalDate dto);

  /**
   * Query Date Time.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/date-time")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Date Time")
  String apiParamsBodyDateTimeGet(@NotNull OffsetDateTime dto);

  /**
   * Get Stream.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/inputstream")
  @Consumes(MediaType.APPLICATION_OCTET_STREAM)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Get Stream")
  String apiParamsBodyInputstreamGet(@NotNull InputStream dto);

  /**
   * Query List.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/list")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query List")
  String apiParamsBodyListGet(@NotNull List<String> dto);

  /**
   * Query List Simple.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/list-simple")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query List Simple")
  String apiParamsBodyListSimpleGet(@NotNull @Valid List<Simple> dto);

  /**
   * Query List.
   *
   * @param inPath  (not null)
   * @param query  (optional)
   * @param item  (optional)
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/mixed/{in-path}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query List")
  String apiParamsBodyMixedInPathGet(@PathParam("in-path") @NotNull String inPath, @QueryParam("query") String query, @HeaderParam("item") List<String> item, @NotNull @Valid Simple dto);

  /**
   * Rename Entity Param.
   *
   * @param dto  (optional)
   * @param dtoEntity  (not null)
   * @return String
   */
  @GET
  @Path("/rename-entity-param/{dto}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Rename Entity Param")
  String apiParamsBodyRenameEntityParamDtoGet(@QueryParam("dto") String dto, @NotNull @Valid Simple dtoEntity);

  /**
   * Query Simple.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/simple")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Simple")
  String apiParamsBodySimpleGet(@NotNull @Valid Simple dto);

  /**
   * Query Time.
   *
   * @param dto  (not null)
   * @return String
   */
  @GET
  @Path("/time")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Time")
  String apiParamsBodyTimeGet(@NotNull LocalTime dto);
}
