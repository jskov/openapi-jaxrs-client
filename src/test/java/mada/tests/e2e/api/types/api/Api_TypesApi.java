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
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

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
  @APIResponseSchema(BigDecimal.class)
  BigDecimal apiTypesBigDecimalGet();

  /**
   * apiTypesBooleanGet
   *
   * @return boolean
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/boolean")
  @APIResponseSchema(Boolean.class)
  boolean apiTypesBooleanGet();

  /**
   * apiTypesByteGet
   *
   * @return byte
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/byte")
  @APIResponseSchema(Byte.class)
  byte apiTypesByteGet();

  /**
   * apiTypesDateGet
   *
   * @return LocalDate
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/date")
  @APIResponseSchema(LocalDate.class)
  LocalDate apiTypesDateGet();

  /**
   * apiTypesDateTimeGet
   *
   * @return OffsetDateTime
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/date-time")
  @APIResponseSchema(OffsetDateTime.class)
  OffsetDateTime apiTypesDateTimeGet();

  /**
   * apiTypesDoubleGet
   *
   * @return double
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/double")
  @APIResponseSchema(Double.class)
  double apiTypesDoubleGet();

  /**
   * apiTypesFloatGet
   *
   * @return float
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/float")
  @APIResponseSchema(Float.class)
  float apiTypesFloatGet();

  /**
   * apiTypesIntGet
   *
   * @return int
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/int")
  @APIResponseSchema(Integer.class)
  int apiTypesIntGet();

  /**
   * apiTypesListGet
   *
   * @return List&lt;Integer&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Integer.class, type = SchemaType.ARRAY)))
  })
  List<Integer> apiTypesListGet();

  /**
   * apiTypesListDateGet
   *
   * @return List&lt;LocalDate&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-date")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = LocalDate.class, type = SchemaType.ARRAY)))
  })
  List<LocalDate> apiTypesListDateGet();

  /**
   * apiTypesListDatetimeGet
   *
   * @return List&lt;OffsetDateTime&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-datetime")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = OffsetDateTime.class, type = SchemaType.ARRAY)))
  })
  List<OffsetDateTime> apiTypesListDatetimeGet();

  /**
   * apiTypesListSimpleGet
   *
   * @return List&lt;Simple&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-simple")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY)))
  })
  List<Simple> apiTypesListSimpleGet();

  /**
   * apiTypesListTimeGet
   *
   * @return List&lt;LocalTime&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-time")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = LocalTime.class, type = SchemaType.ARRAY)))
  })
  List<LocalTime> apiTypesListTimeGet();

  /**
   * apiTypesLongGet
   *
   * @return long
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/long")
  @APIResponseSchema(Long.class)
  long apiTypesLongGet();

  /**
   * apiTypesMapGet
   *
   * @return Map&lt;String, String&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/map")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = String.class, type = SchemaType.ARRAY)))
  })
  Map<String, String> apiTypesMapGet();

  /**
   * apiTypesMapSimpleGet
   *
   * @return Map&lt;String, Simple&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/map-simple")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY)))
  })
  Map<String, Simple> apiTypesMapSimpleGet();

  /**
   * apiTypesSetGet
   *
   * @return Set&lt;Integer&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/set")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Integer.class, type = SchemaType.ARRAY, uniqueItems = true)))
  })
  Set<Integer> apiTypesSetGet();

  /**
   * apiTypesSetSimpleGet
   *
   * @return Set&lt;Simple&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/set-simple")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY, uniqueItems = true)))
  })
  Set<Simple> apiTypesSetSimpleGet();

  /**
   * apiTypesShortGet
   *
   * @return short
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/short")
  @APIResponseSchema(Short.class)
  short apiTypesShortGet();

  /**
   * apiTypesSimpleGet
   *
   * @return Simple
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/simple")
  @APIResponseSchema(Simple.class)
  Simple apiTypesSimpleGet();

  /**
   * apiTypesStringGet
   *
   * @return String
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/string")
  @APIResponseSchema(String.class)
  String apiTypesStringGet();

  /**
   * apiTypesTimeGet
   *
   * @return LocalTime
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/time")
  @APIResponseSchema(LocalTime.class)
  LocalTime apiTypesTimeGet();

  /**
   * apiTypesVoidGet
   *
   * @return void
   */
  @GET
  @Path("/void")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiTypesVoidGet();
}
