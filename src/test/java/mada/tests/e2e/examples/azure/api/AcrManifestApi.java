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
import mada.tests.e2e.examples.azure.dto.AcrManifests;
import mada.tests.e2e.examples.azure.dto.ManifestAttributes;
import mada.tests.e2e.examples.azure.dto.ManifestChangeableAttributes;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/acr/v1/{name}/_manifests")
public interface AcrManifestApi {

  /**
   * List manifests of a repository
   *
   * @param auth  (required)
   * @param name  (required)
   * @param last  (optional)
   * @param n  (optional)
   * @param orderby  (optional)
   * @return AcrManifests
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "Returns a list of manifests",
                 content = @Content(schema = @Schema(implementation = AcrManifests.class)))
  })
  AcrManifests Manifests_GetList(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @QueryParam("last") String last, @QueryParam("n") short n, @QueryParam("orderby") String orderby);

  /**
   * Get manifest attributes
   *
   * @param auth  (required)
   * @param name  (required)
   * @param reference  (required)
   * @return ManifestAttributes
   */
  @GET
  @Path("/{reference}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "List of attributes",
                 content = @Content(schema = @Schema(implementation = ManifestAttributes.class)))
  })
  ManifestAttributes Manifests_GetAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference);

  /**
   * Update attributes of a manifest
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
  void Manifests_UpdateAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference, ManifestChangeableAttributes dto);
}
