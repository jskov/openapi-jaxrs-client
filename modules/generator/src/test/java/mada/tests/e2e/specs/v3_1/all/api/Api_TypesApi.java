/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_1.all.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types")
public interface Api_TypesApi {

  /**
   * Get Big Decimal.
   *
   * @return BigDecimal
   */
  @GET
  @Path("/big-decimal")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(BigDecimal.class)
  @Operation(summary = "Get Big Decimal")
  BigDecimal apiTypesBigDecimalGet();

  /**
   * Get Boolean.
   *
   * @return boolean
   */
  @GET
  @Path("/boolean")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Boolean.class)
  @Operation(summary = "Get Boolean")
  boolean apiTypesBooleanGet();

  /**
   * Get Byte.
   *
   * @return byte
   */
  @GET
  @Path("/byte")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Byte.class)
  @Operation(summary = "Get Byte")
  byte apiTypesByteGet();

  /**
   * Get Date.
   *
   * @return LocalDate
   */
  @GET
  @Path("/date")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(LocalDate.class)
  @Operation(summary = "Get Date")
  LocalDate apiTypesDateGet();

  /**
   * Get Date Time.
   *
   * @return OffsetDateTime
   */
  @GET
  @Path("/date-time")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(OffsetDateTime.class)
  @Operation(summary = "Get Date Time")
  OffsetDateTime apiTypesDateTimeGet();

  /**
   * Get Double.
   *
   * @return double
   */
  @GET
  @Path("/double")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Double.class)
  @Operation(summary = "Get Double")
  double apiTypesDoubleGet();

  /**
   * Get Float.
   *
   * @return float
   */
  @GET
  @Path("/float")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Float.class)
  @Operation(summary = "Get Float")
  float apiTypesFloatGet();

  /**
   * Get Input Stream.
   *
   * @return InputStream
   */
  @GET
  @Path("/input-stream")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @APIResponseSchema(InputStream.class)
  @Operation(summary = "Get Input Stream")
  InputStream apiTypesInputStreamGet();

  /**
   * Get Input Stream Jpeg.
   *
   * @return InputStream
   */
  @GET
  @Path("/input-stream-jpeg")
  @Produces("image/jpeg")
  @APIResponseSchema(InputStream.class)
  @Operation(summary = "Get Input Stream Jpeg")
  InputStream apiTypesInputStreamJpegGet();

  /**
   * Get Int.
   *
   * @return int
   */
  @GET
  @Path("/int")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Integer.class)
  @Operation(summary = "Get Int")
  int apiTypesIntGet();

  /**
   * Get List.
   *
   * @return List<Integer>
   */
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Integer.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get List")
  List<Integer> apiTypesListGet();

  /**
   * Get List Date.
   *
   * @return List<LocalDate>
   */
  @GET
  @Path("/list-date")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = LocalDate.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get List Date")
  List<LocalDate> apiTypesListDateGet();

  /**
   * Get List Date Time.
   *
   * @return List<OffsetDateTime>
   */
  @GET
  @Path("/list-datetime")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = OffsetDateTime.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get List Date Time")
  List<OffsetDateTime> apiTypesListDatetimeGet();

  /**
   * Get List Simple.
   *
   * @return List<Simple>
   */
  @GET
  @Path("/list-simple")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get List Simple")
  List<Simple> apiTypesListSimpleGet();

  /**
   * Get List Time.
   *
   * @return List<LocalTime>
   */
  @GET
  @Path("/list-time")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = LocalTime.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get List Time")
  List<LocalTime> apiTypesListTimeGet();

  /**
   * Get Long.
   *
   * @return long
   */
  @GET
  @Path("/long")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Long.class)
  @Operation(summary = "Get Long")
  long apiTypesLongGet();

  /**
   * Get Map.
   *
   * @return Map<String, String>
   */
  @GET
  @Path("/map")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = String.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get Map")
  Map<String, String> apiTypesMapGet();

  /**
   * Get Map Simple.
   *
   * @return Map<String, Simple>
   */
  @GET
  @Path("/map-simple")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get Map Simple")
  Map<String, Simple> apiTypesMapSimpleGet();

  /**
   * Get Set.
   *
   * @return Set<Integer>
   */
  @GET
  @Path("/set")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Integer.class, type = SchemaType.ARRAY, uniqueItems = true)))
  })
  @Operation(summary = "Get Set")
  Set<Integer> apiTypesSetGet();

  /**
   * Get Set Simple.
   *
   * @return Set<Simple>
   */
  @GET
  @Path("/set-simple")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY, uniqueItems = true)))
  })
  @Operation(summary = "Get Set Simple")
  Set<Simple> apiTypesSetSimpleGet();

  /**
   * Get Short.
   *
   * @return short
   */
  @GET
  @Path("/short")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Short.class)
  @Operation(summary = "Get Short")
  short apiTypesShortGet();

  /**
   * Get Simple.
   *
   * @return Simple
   */
  @GET
  @Path("/simple")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Simple.class)
  @Operation(summary = "Get Simple")
  Simple apiTypesSimpleGet();

  /**
   * Get String.
   *
   * @return String
   */
  @GET
  @Path("/string")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Get String")
  String apiTypesStringGet();

  /**
   * Get Time.
   *
   * @return LocalTime
   */
  @GET
  @Path("/time")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(LocalTime.class)
  @Operation(summary = "Get Time")
  LocalTime apiTypesTimeGet();

  /**
   * Get Void.
   */
  @GET
  @Path("/void")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  @Operation(summary = "Get Void")
  void apiTypesVoidGet();
}
