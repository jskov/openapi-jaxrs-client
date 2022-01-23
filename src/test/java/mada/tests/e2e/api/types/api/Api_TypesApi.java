/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.types.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.types.dto.Simple;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types")
public interface Api_TypesApi {

  /**
   * apiTypesBigDecimalGet
   *
   * @return BigDecimal
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/big-decimal")
  BigDecimal apiTypesBigDecimalGet();

  /**
   * apiTypesBooleanGet
   *
   * @return boolean
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/boolean")
  boolean apiTypesBooleanGet();

  /**
   * apiTypesByteGet
   *
   * @return byte
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/byte")
  byte apiTypesByteGet();

  /**
   * apiTypesDateGet
   *
   * @return LocalDate
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/date")
  LocalDate apiTypesDateGet();

  /**
   * apiTypesDateTimeGet
   *
   * @return OffsetDateTime
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/date-time")
  OffsetDateTime apiTypesDateTimeGet();

  /**
   * apiTypesDoubleGet
   *
   * @return double
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/double")
  double apiTypesDoubleGet();

  /**
   * apiTypesFloatGet
   *
   * @return float
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/float")
  float apiTypesFloatGet();

  /**
   * apiTypesIntGet
   *
   * @return int
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/int")
  int apiTypesIntGet();

  /**
   * apiTypesListGet
   *
   * @return List&lt;Integer&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  List<Integer> apiTypesListGet();

  /**
   * apiTypesListDateGet
   *
   * @return List&lt;LocalDate&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-date")
  List<LocalDate> apiTypesListDateGet();

  /**
   * apiTypesListDatetimeGet
   *
   * @return List&lt;OffsetDateTime&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-datetime")
  List<OffsetDateTime> apiTypesListDatetimeGet();

  /**
   * apiTypesListSimpleGet
   *
   * @return List&lt;Simple&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-simple")
  List<Simple> apiTypesListSimpleGet();

  /**
   * apiTypesListTimeGet
   *
   * @return List&lt;LocalTime&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-time")
  List<LocalTime> apiTypesListTimeGet();

  /**
   * apiTypesLongGet
   *
   * @return long
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/long")
  long apiTypesLongGet();

  /**
   * apiTypesMapGet
   *
   * @return Map&lt;String, String&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/map")
  Map<String, String> apiTypesMapGet();

  /**
   * apiTypesMapSimpleGet
   *
   * @return Map&lt;String, Simple&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/map-simple")
  Map<String, Simple> apiTypesMapSimpleGet();

  /**
   * apiTypesSetGet
   *
   * @return Set&lt;Integer&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/set")
  Set<Integer> apiTypesSetGet();

  /**
   * apiTypesSetSimpleGet
   *
   * @return Set&lt;Simple&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/set-simple")
  Set<Simple> apiTypesSetSimpleGet();

  /**
   * apiTypesShortGet
   *
   * @return short
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/short")
  short apiTypesShortGet();

  /**
   * apiTypesSimpleGet
   *
   * @return Simple
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/simple")
  Simple apiTypesSimpleGet();

  /**
   * apiTypesStringGet
   *
   * @return String
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/string")
  String apiTypesStringGet();

  /**
   * apiTypesTimeGet
   *
   * @return LocalTime
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/time")
  LocalTime apiTypesTimeGet();

  /**
   * apiTypesVoidGet
   *
   * @return void
   */
  @GET
  @Path("/void")
  void apiTypesVoidGet();
}
