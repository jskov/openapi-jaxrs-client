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
import mada.tests.e2e.examples.azure.dto.DeletedRepository;
import mada.tests.e2e.examples.azure.dto.Repositories;
import mada.tests.e2e.examples.azure.dto.RepositoryAttributes;
import mada.tests.e2e.examples.azure.dto.RepositoryChangeableAttributes;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/acr/v1")
public interface AcrRepositoryApi {

    /**
     * List repositories
     *
     * @param auth (not null)
     * @param last Query parameter for the last item in previous query. Result set will include values lexically after last.
     *             (optional)
     * @param n    query parameter for max number of items (optional)
     * @return Repositories
     */
    @GET
    @Path("/_catalog")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "Returns a list of repositories",
                    content = @Content(schema = @Schema(implementation = Repositories.class)))
    })
    Repositories Repository_GetList(@HeaderParam("Authorization") String auth, @QueryParam("last") String last, @QueryParam("n") short n);

    /**
     * Get repository attributes
     *
     * @param auth (not null)
     * @param name Name of the image (including the namespace) (not null)
     * @return RepositoryAttributes
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "Returns a list of attributes",
                    content = @Content(schema = @Schema(implementation = RepositoryAttributes.class)))
    })
    RepositoryAttributes Repository_GetAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name);

    /**
     * Delete the repository identified by `name`
     *
     * @param auth (not null)
     * @param name Name of the image (including the namespace) (not null)
     * @return AcrErrors
     */
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "202",
                    description = "The repository is deleted",
                    content = @Content(schema = @Schema(implementation = DeletedRepository.class)))
    })
    AcrErrors Repository_Delete(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name);

    /**
     * Update the attribute identified by `name` where `reference` is the name of the repository.
     *
     * @param auth (not null)
     * @param name Name of the image (including the namespace) (not null)
     * @param dto  Repository attribute value (optional)
     * @return AcrErrors
     */
    @PATCH
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(responseCode = "200", description = "The attributes are updated")
    })
    AcrErrors Repository_UpdateAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name,
            @Valid RepositoryChangeableAttributes dto);
}
