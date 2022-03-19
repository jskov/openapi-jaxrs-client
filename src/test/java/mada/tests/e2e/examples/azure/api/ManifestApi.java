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
import mada.tests.e2e.examples.azure.dto.Manifest;
import mada.tests.e2e.examples.azure.dto.ManifestWrapper;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v2/{name}/manifests/{reference}")
public interface ManifestApi {

  /**
   * Get the manifest identified by &#x60;name&#x60; and &#x60;reference&#x60; where &#x60;reference&#x60; can be a tag or digest.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param reference  (required)
   * @param accept  (optional)
   * @return ManifestWrapper
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "Returns the requested manifest file in a larger combined group",
                 content = @Content(schema = @Schema(implementation = ManifestWrapper.class)))
  })
  ManifestWrapper Manifests_Get(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference, @HeaderParam("accept") String accept);

  /**
   * Put the manifest identified by &#x60;name&#x60; and &#x60;reference&#x60; where &#x60;reference&#x60; can be a tag or digest.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param reference  (required)
   * @param dto  (required)
   * @return AcrErrors
   */
  @PUT
  @Consumes("application/vnd.docker.distribution.manifest.v2+json")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "201", description = "The manifest is updated",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  AcrErrors Manifests_Create(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference, @NotNull Manifest dto);

  /**
   * Delete the manifest identified by &#x60;name&#x60; and &#x60;reference&#x60;. Note that a manifest can _only_ be deleted by &#x60;digest&#x60;.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param reference  (required)
   * @return AcrErrors
   */
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "202", description = "The manifest has been deleted")
  })
  AcrErrors Manifests_Delete(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("reference") @NotNull String reference);
}
