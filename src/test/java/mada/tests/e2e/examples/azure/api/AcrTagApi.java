/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.examples.azure.dto.AcrErrors;
import mada.tests.e2e.examples.azure.dto.TagAttributes;
import mada.tests.e2e.examples.azure.dto.TagChangeableAttributes;
import mada.tests.e2e.examples.azure.dto.TagList;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/acr/v1/{name}/_tags")
public interface AcrTagApi {

  /**
   * List tags of a repository
   *
   * @param auth  (required)
   * @param name  (required)
   * @param last  (optional)
   * @param n  (optional)
   * @param orderby  (optional)
   * @param digest  (optional)
   * @return TagList
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "Tag details of a repository",
                 content = @Content(schema = @Schema(implementation = TagList.class)))
  })
  TagList Tag_GetList(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @QueryParam("last") String last, @QueryParam("n") short n, @QueryParam("orderby") String orderby, @QueryParam("digest") String digest);

  /**
   * Get tag attributes by tag
   *
   * @param auth  (required)
   * @param name  (required)
   * @param reference  (required)
   * @return TagAttributes
   */
  @GET
  @Path("/{reference}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "Tag attributes",
                 content = @Content(schema = @Schema(implementation = TagAttributes.class)))
  })
  TagAttributes Tag_GetAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference);

  /**
   * Delete tag
   *
   * @param auth  (required)
   * @param name  (required)
   * @param reference  (required)
   * @return AcrErrors
   */
  @DELETE
  @Path("/{reference}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "202", description = "The tag is deleted")
  })
  AcrErrors Tag_Delete(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference);

  /**
   * Update tag attributes
   *
   * @param auth  (required)
   * @param name  (required)
   * @param reference  (required)
   * @param dto  (optional)
   */
  @PATCH
  @Path("/{reference}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "The attributes are updated")
  })
  void Tag_UpdateAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference, TagChangeableAttributes dto);
}
