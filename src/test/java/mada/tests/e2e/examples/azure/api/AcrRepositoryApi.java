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
import mada.tests.e2e.examples.azure.dto.DeletedRepository;
import mada.tests.e2e.examples.azure.dto.Repositories;
import mada.tests.e2e.examples.azure.dto.RepositoryAttributes;
import mada.tests.e2e.examples.azure.dto.RepositoryChangeableAttributes;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/acr/v1")
public interface AcrRepositoryApi {

  /**
   * List repositories
   *
   * @param auth  (required)
   * @param last  (optional)
   * @param n  (optional)
   * @return Repositories
   */
  @GET
  @Path("/_catalog")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "Returns a list of repositories",
                 content = @Content(schema = @Schema(implementation = Repositories.class)))
  })
  Repositories Repository_GetList(@HeaderParam("Authorization") String auth, @QueryParam("last") String last, @QueryParam("n") short n);

  /**
   * Get repository attributes
   *
   * @param auth  (required)
   * @param name  (required)
   * @return RepositoryAttributes
   */
  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "Returns a list of attributes",
                 content = @Content(schema = @Schema(implementation = RepositoryAttributes.class)))
  })
  RepositoryAttributes Repository_GetAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name);

  /**
   * Delete the repository identified by &#x60;name&#x60;
   *
   * @param auth  (required)
   * @param name  (required)
   * @return AcrErrors
   */
  @DELETE
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "202", description = "The repository is deleted",
                 content = @Content(schema = @Schema(implementation = DeletedRepository.class)))
  })
  AcrErrors Repository_Delete(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name);

  /**
   * Update the attribute identified by &#x60;name&#x60; where &#x60;reference&#x60; is the name of the repository.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param dto  (optional)
   */
  @PATCH
  @Path("/{name}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "The attributes are updated")
  })
  void Repository_UpdateAttributes(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, RepositoryChangeableAttributes dto);
}
