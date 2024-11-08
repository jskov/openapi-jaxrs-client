/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mada.tests.e2e.examples.azure.dto.AcrErrors;
import mada.tests.e2e.examples.azure.dto.Manifest;
import mada.tests.e2e.examples.azure.dto.ManifestWrapper;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v2/{name}/manifests/{reference}")
public interface ManifestApi {

    /**
     * Get the manifest identified by `name` and `reference` where `reference` can be a tag or digest.
     *
     * @param auth      (not null)
     * @param name      Name of the image (including the namespace) (not null)
     * @param reference A tag or a digest, pointing to a specific image (not null)
     * @param accept    Accept header string delimited by comma. For example,
     *                  application/vnd.docker.distribution.manifest.v2+json (optional)
     * @return ManifestWrapper
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "Returns the requested manifest file in a larger combined group",
                    content = @Content(schema = @Schema(implementation = ManifestWrapper.class)))
    })
    ManifestWrapper Manifests_Get(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name,
            @PathParam("reference") @NotNull String reference, @HeaderParam("accept") String accept);

    /**
     * Put the manifest identified by `name` and `reference` where `reference` can be a tag or digest.
     *
     * @param auth      (not null)
     * @param name      Name of the image (including the namespace) (not null)
     * @param reference A tag or a digest, pointing to a specific image (not null)
     * @param dto       Manifest body, can take v1 or v2 values depending on accept header (not null)
     * @return Object
     */
    @PUT
    @Consumes("application/vnd.docker.distribution.manifest.v2+json")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "201",
                    description = "The manifest is updated",
                    content = @Content(schema = @Schema(implementation = Object.class)))
    })
    Object Manifests_Create(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name,
            @PathParam("reference") @NotNull String reference, @NotNull @Valid Manifest dto);

    /**
     * Delete the manifest identified by `name` and `reference`. Note that a manifest can _only_ be deleted by `digest`.
     *
     * @param auth      (not null)
     * @param name      Name of the image (including the namespace) (not null)
     * @param reference A tag or a digest, pointing to a specific image (not null)
     * @return AcrErrors
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(responseCode = "202", description = "The manifest has been deleted")
    })
    AcrErrors Manifests_Delete(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name,
            @PathParam("reference") @NotNull String reference);
}
