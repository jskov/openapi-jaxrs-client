/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/query")
public interface Params_QueryApi {

  /**
   * Query Boolean Primitive.
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Path("/boolean-primitive")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Boolean Primitive")
  String apiParamsQueryBooleanPrimitiveGet(@QueryParam("flag") boolean flag);

  /**
   * Query Boolean Wrapper.
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Path("/boolean-wrapper")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Boolean Wrapper")
  String apiParamsQueryBooleanWrapperGet(@QueryParam("flag") boolean flag);

  /**
   * Query Date.
   *
   * @param date  (optional)
   * @param dateTime  (optional)
   * @param time  (optional)
   * @return String
   */
  @GET
  @Path("/dates")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Date")
  String apiParamsQueryDatesGet(@QueryParam("date") LocalDate date, @QueryParam("date-time") OffsetDateTime dateTime, @QueryParam("time") String time);

  /**
   * Query List.
   *
   * @param item  (optional)
   * @return String
   */
  @GET
  @Path("/list")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query List")
  String apiParamsQueryListGet(@QueryParam("item") List<String> item);

  /**
   * Query List.
   *
   * @param flag  (optional)
   * @param item  (optional)
   * @param name  (optional)
   * @return String
   */
  @GET
  @Path("/mixed")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query List")
  String apiParamsQueryMixedGet(@QueryParam("flag") boolean flag, @QueryParam("item") List<String> item, @QueryParam("name") String name);
}
