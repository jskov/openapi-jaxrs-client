/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.api.params.query.api;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/query")
public interface Params_QueryApi {

  /**
   * apiParamsQueryBooleanPrimitiveGet.
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Path("/boolean-primitive")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsQueryBooleanPrimitiveGet(@QueryParam("flag") boolean flag);

  /**
   * apiParamsQueryBooleanWrapperGet.
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Path("/boolean-wrapper")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsQueryBooleanWrapperGet(@QueryParam("flag") boolean flag);

  /**
   * apiParamsQueryDatesGet.
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
  String apiParamsQueryDatesGet(@QueryParam("date") LocalDate date, @QueryParam("date-time") OffsetDateTime dateTime, @QueryParam("time") String time);

  /**
   * apiParamsQueryListGet.
   *
   * @param item  (optional)
   * @return String
   */
  @GET
  @Path("/list")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsQueryListGet(@QueryParam("item") List<String> item);

  /**
   * apiParamsQueryMixedGet.
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
  String apiParamsQueryMixedGet(@QueryParam("flag") boolean flag, @QueryParam("item") List<String> item, @QueryParam("name") String name);
}
