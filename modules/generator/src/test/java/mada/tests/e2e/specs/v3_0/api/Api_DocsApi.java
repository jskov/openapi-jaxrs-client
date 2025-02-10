/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.api;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_0.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/docs")
public interface Api_DocsApi {

  /**
   * op summary? with punctuation
   * op description
   *
   * @return String
   */
  @GET
  @Path("/GET")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "op summary? with punctuation")
  String opId();

  /**
   * op is deprecated!
   *
   * @return String
   */
  @GET
  @Path("/deprecated")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "op is deprecated!")
  String apiDocsDeprecatedGet();

  /**
   * Javadoc start.
   * But multiple
   * lines of text.
   *
   * Last line.
   *
   * @return String
   */
  @GET
  @Path("/multi-line")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Javadoc start.\nBut multiple\nlines of text.\n\nLast line.")
  String apiDocsMultiLineGet();

  /**
   * apiDocsMultipleReturnTypesPost.
   *
   * @param dto  (optional)
   * @return List<Simple>
   */
  @POST
  @Path("/multiple-return-types")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The registered cluster",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY))),
    @APIResponse(responseCode = "400", description = "Validation errors",
                 content = @Content(schema = @Schema(implementation = Simple.class))),
    @APIResponse(responseCode = "401", description = "Unauthorized Error",
                 content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.TEXT_PLAIN)),
    @APIResponse(responseCode = "409", description = "Cluster already present",
                 content = @Content(schema = @Schema(implementation = Simple.class))),
    @APIResponse(responseCode = "500", description = "The internal error",
                 content = @Content(schema = @Schema(implementation = Simple.class)))
  })
  List<Simple> apiDocsMultipleReturnTypesPost(@Valid Simple dto);

  /**
   * op is missing punctuation.
   *
   * @param inPath path param description (not null)
   * @param query query param description (optional)
   * @param queryDeprecated deprecated query param description (optional)
   * @param item  (optional)
   * @param dto dto description (optional)
   * @return String
   */
  @GET
  @Path("/params/{in-path}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "op is missing punctuation")
  String apiDocsParamsInPathGet(@PathParam("in-path") @NotNull String inPath, @QueryParam("query") String query, @QueryParam("query-deprecated") String queryDeprecated, @HeaderParam("item") List<String> item, @Valid Simple dto);

  /**
   * Summary with "quote" 'quote'.
   * Description with "quote" 'quote'
   *
   * @return String
   */
  @GET
  @Path("/quoted")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Description with \"quote\" 'quote'",
                 content = @Content(schema = @Schema(implementation = String.class))),
    @APIResponse(responseCode = "400", description = "Description with \"quote\" 'quote'",
                 content = @Content(schema = @Schema(implementation = Simple.class)))
  })
  @Operation(summary = "Summary with \"quote\" 'quote'")
  String apiDocsQuotedGet();
}
