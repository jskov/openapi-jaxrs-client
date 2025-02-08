/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.specs.v3_0.api;

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
import mada.tests.e2e.specs.v3_0.dto.Simple;
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
   * apiTypesBigDecimalGet.
   *
   * @return BigDecimal
   */
  @GET
  @Path("/big-decimal")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(BigDecimal.class)
  BigDecimal apiTypesBigDecimalGet();

  /**
   * apiTypesBooleanGet.
   *
   * @return boolean
   */
  @GET
  @Path("/boolean")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Boolean.class)
  boolean apiTypesBooleanGet();

  /**
   * apiTypesByteGet.
   *
   * @return byte
   */
  @GET
  @Path("/byte")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Byte.class)
  byte apiTypesByteGet();

  /**
   * apiTypesDateGet.
   *
   * @return LocalDate
   */
  @GET
  @Path("/date")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(LocalDate.class)
  LocalDate apiTypesDateGet();

  /**
   * apiTypesDateTimeGet.
   *
   * @return OffsetDateTime
   */
  @GET
  @Path("/date-time")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(OffsetDateTime.class)
  OffsetDateTime apiTypesDateTimeGet();

  /**
   * apiTypesDoubleGet.
   *
   * @return double
   */
  @GET
  @Path("/double")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Double.class)
  double apiTypesDoubleGet();

  /**
   * apiTypesFloatGet.
   *
   * @return float
   */
  @GET
  @Path("/float")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Float.class)
  float apiTypesFloatGet();

  /**
   * apiTypesInputStreamGet.
   *
   * @return InputStream
   */
  @GET
  @Path("/input-stream")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @APIResponseSchema(InputStream.class)
  InputStream apiTypesInputStreamGet();

  /**
   * apiTypesInputStreamJpegGet.
   *
   * @return InputStream
   */
  @GET
  @Path("/input-stream-jpeg")
  @Produces("image/jpeg")
  @APIResponseSchema(InputStream.class)
  InputStream apiTypesInputStreamJpegGet();

  /**
   * apiTypesIntGet.
   *
   * @return int
   */
  @GET
  @Path("/int")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Integer.class)
  int apiTypesIntGet();

  /**
   * apiTypesListGet.
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
  List<Integer> apiTypesListGet();

  /**
   * apiTypesListDateGet.
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
  List<LocalDate> apiTypesListDateGet();

  /**
   * apiTypesListDatetimeGet.
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
  List<OffsetDateTime> apiTypesListDatetimeGet();

  /**
   * apiTypesListSimpleGet.
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
  List<Simple> apiTypesListSimpleGet();

  /**
   * apiTypesListTimeGet.
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
  List<LocalTime> apiTypesListTimeGet();

  /**
   * apiTypesLongGet.
   *
   * @return long
   */
  @GET
  @Path("/long")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Long.class)
  long apiTypesLongGet();

  /**
   * apiTypesMapGet.
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
  Map<String, String> apiTypesMapGet();

  /**
   * apiTypesMapSimpleGet.
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
  Map<String, Simple> apiTypesMapSimpleGet();

  /**
   * apiTypesSetGet.
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
  Set<Integer> apiTypesSetGet();

  /**
   * apiTypesSetSimpleGet.
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
  Set<Simple> apiTypesSetSimpleGet();

  /**
   * apiTypesShortGet.
   *
   * @return short
   */
  @GET
  @Path("/short")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Short.class)
  short apiTypesShortGet();

  /**
   * apiTypesSimpleGet.
   *
   * @return Simple
   */
  @GET
  @Path("/simple")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Simple.class)
  Simple apiTypesSimpleGet();

  /**
   * apiTypesStringGet.
   *
   * @return String
   */
  @GET
  @Path("/string")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String apiTypesStringGet();

  /**
   * apiTypesTimeGet.
   *
   * @return LocalTime
   */
  @GET
  @Path("/time")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(LocalTime.class)
  LocalTime apiTypesTimeGet();

  /**
   * apiTypesVoidGet.
   */
  @GET
  @Path("/void")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void apiTypesVoidGet();
}
