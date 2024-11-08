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
import mada.tests.e2e.examples.azure.dto.AcrManifests;
import mada.tests.e2e.examples.azure.dto.ManifestAttributes;
import mada.tests.e2e.examples.azure.dto.ManifestChangeableAttributes;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/acr/v1/{name}/_manifests")
public interface AcrManifestApi {

    /**
     * List manifests of a repository
     *
     * @param auth    (not null)
     * @param name    Name of the image (including the namespace) (not null)
     * @param last    Query parameter for the last item in previous query. Result set will include values lexically after
     *                last. (optional)
     * @param n       query parameter for max number of items (optional)
     * @param orderby orderby query parameter (optional)
     * @return AcrManifests
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
                    description = "Returns a list of manifests",
                    content = @Content(schema = @Schema(implementation = AcrManifests.class)))
    })
    AcrManifests Manifests_GetList(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name,
            @QueryParam("last") String last, @QueryParam("n") short n, @QueryParam("orderby") String orderby);

    /**
     * Get manifest attributes
     *
     * @param auth      (not null)
     * @param name      Name of the image (including the namespace) (not null)
     * @param reference A tag or a digest, pointing to a specific image (not null)
     * @return ManifestAttributes
     */
    @GET
    @Path("/{reference}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "List of attributes",
                    content = @Content(schema = @Schema(implementation = ManifestAttributes.class)))
    })
    ManifestAttributes Manifests_GetAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name,
            @PathParam("reference") @NotNull String reference);

    /**
     * Update attributes of a manifest
     *
     * @param auth      (not null)
     * @param name      Name of the image (including the namespace) (not null)
     * @param reference A tag or a digest, pointing to a specific image (not null)
     * @param dto       Manifest attribute value (optional)
     * @return AcrErrors
     */
    @PATCH
    @Path("/{reference}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(responseCode = "200", description = "The attributes are updated")
    })
    AcrErrors Manifests_UpdateAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name,
            @PathParam("reference") @NotNull String reference, @Valid ManifestChangeableAttributes dto);
}
