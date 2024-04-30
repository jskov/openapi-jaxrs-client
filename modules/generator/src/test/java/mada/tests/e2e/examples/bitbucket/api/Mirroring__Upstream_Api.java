/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import mada.tests.e2e.examples.bitbucket.dto.EnrichedRepository;
import mada.tests.e2e.examples.bitbucket.dto.RestAnalyticsSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestApplicationUserWithPermissions;
import mada.tests.e2e.examples.bitbucket.dto.RestAuthenticationRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestMirrorAuthToken;
import mada.tests.e2e.examples.bitbucket.dto.RestMirrorServer;
import mada.tests.e2e.examples.bitbucket.dto.RestMirrorUpgradeRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestMirroredRepositoryDescriptor;
import mada.tests.e2e.examples.bitbucket.dto.RestMirroringRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestProject;
import mada.tests.e2e.examples.bitbucket.dto.RestRepositoryMirrorEvent;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/mirroring/latest")
public interface Mirroring__Upstream_Api {

  /**
   * Get preferred mirror.
   * Retrieves the current user's preferred mirror server
   *
   * @return RestMirrorServer
   */
  @GET
  @Path("/account/settings/preferred-mirror")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the preferred mirror server",
                 content = @Content(schema = @Schema(implementation = RestMirrorServer.class))),
    @APIResponse(responseCode = "404", description = "The user's preferred mirror server could not be found.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get preferred mirror")
  RestMirrorServer getPreferredMirrorId();

  /**
   * Set preferred mirror.
   * Sets the mirror specified by a mirror ID as the current user's preferred mirror
   *
   * @param dto the mirror ID (optional)
   */
  @POST
  @Path("/account/settings/preferred-mirror")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "an empty response indicating that the user setting has been updated"),
    @APIResponse(responseCode = "404", description = "The mirror could not be found.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Set preferred mirror")
  void setPreferredMirrorId(String dto);

  /**
   * Remove preferred mirror.
   * Removes the current user's preferred mirror
   */
  @DELETE
  @Path("/account/settings/preferred-mirror")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "an empty response indicating that the user setting has been updated")
  })
  @Operation(summary = "Remove preferred mirror")
  void deletePreferredMirrorId();

  /**
   * Get analytics settings from upstream.
   * Gets the analytics settings from the mirroring upstream
   *
   * @return RestAnalyticsSettings
   */
  @GET
  @Path("/analyticsSettings")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(RestAnalyticsSettings.class)
  @Operation(summary = "Get analytics settings from upstream")
  RestAnalyticsSettings analyticsSettings();

  /**
   * Authenticate on behalf of a user.
   * Authenticates on behalf of a user. Used by mirrors to check the credentials supplied to them by users. If successful a user and their effective permissions are returned as follows -

* For SSH credentials - all the effective user permissions are returned.
* For all other credentials - the highest global permission is returned along with highest repository permission if repository ID is also provided in the request.

Currently only username/password, bearer token and SSH credentials are supported.
   *
   * @param dto  (optional)
   * @return RestApplicationUserWithPermissions
   */
  @POST
  @Path("/authenticate")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The user for the supplied credentials and their effective permissions}.",
                 content = @Content(schema = @Schema(implementation = RestApplicationUserWithPermissions.class))),
    @APIResponse(responseCode = "400", description = "If the supplied credentials are incomplete or not understood.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = " The currently authenticated user is not permitted to authenticate on behalf of users or authentication with the supplied user credentials failed for some reason",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Authenticate on behalf of a user")
  RestApplicationUserWithPermissions authenticate(@Valid RestAuthenticationRequest dto);

  /**
   * Get all mirrors.
   * Returns a list of mirrors
   *
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("/mirrorServers")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Object.class)
  @Operation(summary = "Get all mirrors")
  Object listMirrors(@QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get mirror by ID.
   * Returns the mirror specified by a mirror ID
   *
   * @param mirrorId the mirror ID (not null)
   * @return RestMirrorServer
   */
  @GET
  @Path("/mirrorServers/{mirrorId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the mirror",
                 content = @Content(schema = @Schema(implementation = RestMirrorServer.class))),
    @APIResponse(responseCode = "404", description = "The mirror could not be found.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get mirror by ID")
  RestMirrorServer getMirror(@PathParam("mirrorId") @NotNull String mirrorId);

  /**
   * Upgrade add-on for a mirror.
   * Upgrades the add-on for the mirror server in question This endpoint can only be called by the mirror instance or system administrators<br>Since 5.8
   *
   * @param mirrorId the ID of the mirror to upgrade (not null)
   * @param dto  (optional)
   * @return RestMirrorServer
   */
  @PUT
  @Path("/mirrorServers/{mirrorId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(RestMirrorServer.class)
  @Operation(summary = "Upgrade add-on for a mirror")
  RestMirrorServer upgrade(@PathParam("mirrorId") @NotNull String mirrorId, @Valid RestMirrorUpgradeRequest dto);

  /**
   * Delete mirror by ID.
   * Removes a mirror, disabling all access and notifications for the mirror server in question
   *
   * @param mirrorId the ID of the mirror to remove (not null)
   */
  @DELETE
  @Path("/mirrorServers/{mirrorId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "an empty response indicating that the mirror has been removed")
  })
  @Operation(summary = "Delete mirror by ID")
  void remove(@PathParam("mirrorId") @NotNull String mirrorId);

  /**
   * Publish RepositoryMirrorEvent.
   * Publishes a RepositoryMirrorEvent on the event queue.
   *
   * @param mirrorId the server id of the mirror that raised this event (not null)
   * @param dto  (optional)
   */
  @POST
  @Path("/mirrorServers/{mirrorId}/events")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The event was successfully placed on the queue"),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Publish RepositoryMirrorEvent")
  void publishEvent(@PathParam("mirrorId") @NotNull String mirrorId, @Valid RestRepositoryMirrorEvent dto);

  /**
   * Get mirror auth token.
   * Returns an authentication token for the mirror server in question
   *
   * @param mirrorId the mirror ID (not null)
   * @return RestMirrorAuthToken
   */
  @GET
  @Path("/mirrorServers/{mirrorId}/token")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the mirror auth token",
                 content = @Content(schema = @Schema(implementation = RestMirrorAuthToken.class))),
    @APIResponse(responseCode = "404", description = "The mirror could not be found.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get mirror auth token")
  RestMirrorAuthToken getAuthToken(@PathParam("mirrorId") @NotNull String mirrorId);

  /**
   * Get HTML for remote-connect web-panel on mirror.
   * Gets the rendered HTML that is needed to get the remote connect web-panel on the mirror.
   *
   * @param mirrorId  (not null)
   */
  @GET
  @Path("/mirrorServers/{mirrorId}/webPanels/config")
  @Produces("text/html")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response")
  })
  @Operation(summary = "Get HTML for remote-connect web-panel on mirror")
  void getPanelHtml(@PathParam("mirrorId") @NotNull String mirrorId);

  /**
   * Get project.
   * Returns the requested project using its primary key ID.<br> Since 6.7
   *
   * @param projectId the ID of the requested project (not null)
   * @return RestProject
   */
  @GET
  @Path("/projects/{projectId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The project with the specified ID",
                 content = @Content(schema = @Schema(implementation = RestProject.class))),
    @APIResponse(responseCode = "404", description = "Project not found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get project")
  RestProject getProjectById(@PathParam("projectId") @NotNull String projectId);

  /**
   * Get hashes for repositories in project.
   * Returns a page of repositories for a given project, enriched with a content hash
   *
   * @param includeDefaultBranch includes defaultBranchId in the response, if <code>true</code>. Default value is <code>false</code> (optional)
   * @param projectId the id of the requested project (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("/projects/{projectId}/repos")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of repositories with content hashes",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "409", description = "Mirroring is not available",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get hashes for repositories in project")
  Object getAllReposForProject(@QueryParam("includeDefaultBranch") String includeDefaultBranch, @PathParam("projectId") @NotNull String projectId, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get content hashes for repositories.
   * Returns a page of repositories enriched with a content hash and default branch
   *
   * @param includeDefaultBranch includes defaultBranchId for each repository in the response, if <code>true</code>. Default value is <code>false</code>. (optional)
   * @return EnrichedRepository
   */
  @GET
  @Path("/repos")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of repositories with content hashes and default branch",
                 content = @Content(schema = @Schema(implementation = EnrichedRepository.class))),
    @APIResponse(responseCode = "409", description = "Mirroring is not available",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get content hashes for repositories")
  EnrichedRepository getAllContentHashes(@QueryParam("includeDefaultBranch") String includeDefaultBranch);

  /**
   * Get content hash for a repository.
   * Returns a repository enriched with a content hash and default branch
   *
   * @param repoId the ID of the requested repository (not null)
   * @param includeDefaultBranch  (optional)
   * @return EnrichedRepository
   */
  @GET
  @Path("/repos/{repoId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The repository with the specified repoId",
                 content = @Content(schema = @Schema(implementation = EnrichedRepository.class))),
    @APIResponse(responseCode = "404", description = "Repository not found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get content hash for a repository")
  EnrichedRepository getContentHashById(@PathParam("repoId") @NotNull String repoId, @QueryParam("includeDefaultBranch") boolean includeDefaultBranch);

  /**
   * Get mirrors for repository.
   * Returns a page of mirrors for a repository. This resource will return <strong>all mirrors</strong> along with authorized links to the mirror's repository REST resource. To determine if a repository is available on the mirror, the returned URL needs to be called.
   *
   * @param repoId the ID of the requested repository (not null)
   * @return RestMirroredRepositoryDescriptor
   */
  @GET
  @Path("/repos/{repoId}/mirrors")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The mirrored repository descriptor",
                 content = @Content(schema = @Schema(implementation = RestMirroredRepositoryDescriptor.class))),
    @APIResponse(responseCode = "409", description = "Mirroring is not available",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get mirrors for repository")
  RestMirroredRepositoryDescriptor getRepositoryMirrors(@PathParam("repoId") @NotNull String repoId);

  /**
   * Get mirroring requests.
   * Retrieves a mirroring request
   *
   * @param state (optional) the request state to filter on (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("/requests")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Object.class)
  @Operation(summary = "Get mirroring requests")
  Object listRequests(@QueryParam("state") String state, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create a mirroring request.
   * Creates a new mirroring request
   *
   * @param dto  (optional)
   * @return RestMirroringRequest
   */
  @POST
  @Path("/requests")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created mirroring request",
                 content = @Content(schema = @Schema(implementation = RestMirroringRequest.class))),
    @APIResponse(responseCode = "409", description = "The request was invalid or missing",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create a mirroring request")
  RestMirroringRequest register(@Valid RestMirroringRequest dto);

  /**
   * Get a mirroring request.
   * Retrieves a mirroring request
   *
   * @param mirroringRequestId the ID of the mirroring request to retrieve (not null)
   * @return RestMirroringRequest
   */
  @GET
  @Path("/requests/{mirroringRequestId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The mirroring request",
                 content = @Content(schema = @Schema(implementation = RestMirroringRequest.class))),
    @APIResponse(responseCode = "409", description = "The request could not be found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get a mirroring request")
  RestMirroringRequest getMirroringRequest(@PathParam("mirroringRequestId") @NotNull String mirroringRequestId);

  /**
   * Delete a mirroring request.
   * Deletes a mirroring request
   *
   * @param mirroringRequestId the ID of the mirroring request to delete (not null)
   */
  @DELETE
  @Path("/requests/{mirroringRequestId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The request was deleted"),
    @APIResponse(responseCode = "409", description = "The request could not be found",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a mirroring request")
  void deleteMirroringRequest(@PathParam("mirroringRequestId") @NotNull String mirroringRequestId);

  /**
   * Accept a mirroring request.
   * Accepts a mirroring request
   *
   * @param mirroringRequestId the ID of the request to accept (not null)
   * @return RestMirrorServer
   */
  @POST
  @Path("/requests/{mirroringRequestId}/accept")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The accepted mirror server",
                 content = @Content(schema = @Schema(implementation = RestMirrorServer.class))),
    @APIResponse(responseCode = "409", description = "The request could not be found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Accept a mirroring request")
  RestMirrorServer accept(@PathParam("mirroringRequestId") @NotNull String mirroringRequestId);

  /**
   * Reject a mirroring request.
   * Rejects a mirroring request
   *
   * @param mirroringRequestId the ID of the request to reject (not null)
   * @return RestMirrorServer
   */
  @POST
  @Path("/requests/{mirroringRequestId}/reject")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The rejected mirror server",
                 content = @Content(schema = @Schema(implementation = RestMirrorServer.class))),
    @APIResponse(responseCode = "409", description = "The request could not be found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Reject a mirroring request")
  RestMirrorServer reject(@PathParam("mirroringRequestId") @NotNull String mirroringRequestId);
}
