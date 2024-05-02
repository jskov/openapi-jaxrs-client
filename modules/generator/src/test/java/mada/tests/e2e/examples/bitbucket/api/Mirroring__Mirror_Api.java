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
import java.util.List;
import mada.tests.e2e.examples.bitbucket.dto.RestClusterNode;
import mada.tests.e2e.examples.bitbucket.dto.RestErrors;
import mada.tests.e2e.examples.bitbucket.dto.RestMirroredRepository;
import mada.tests.e2e.examples.bitbucket.dto.RestRefSyncQueue;
import mada.tests.e2e.examples.bitbucket.dto.RestSyncProgress;
import mada.tests.e2e.examples.bitbucket.dto.RestUpstreamServer;
import mada.tests.e2e.examples.bitbucket.dto.RestUpstreamSettings;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestMeshConfigRefresh_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestSupportInfoRepoSyncStatus;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestUpstreamServers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestUpstreamServersUpstreamIdProgress_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestUpstreamServersUpstreamIdReposUpstreamRepoId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestUpstreamServersUpstreamIdSettingsMode_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestUpstreamServersUpstreamIdSettingsMode_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestUpstreamServersUpstreamIdSettings_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseMirroringLatestUpstreamServersUpstreamId_404;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/mirroring/latest")
public interface Mirroring__Mirror_Api {

  /**
   * Refresh sidecar configuration.
   * Refreshes configuration of the sidecar running on each node in the farm
   */
  @POST
  @Path("/mesh/config/refresh")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The configuration of the sidecar running on each node in the farm has been refreshed"),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to refresh sidecar configuration.",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestMeshConfigRefresh_401.class)))
  })
  @Operation(summary = "Refresh sidecar configuration")
  void refresh();

  /**
   * Get items in ref changes queue.
   * Retrieves a list of up to <code>plugin.mirroring.farm.max.ref.change.queue.dump.size</code> items currently in the ref changes queue. The ref changes queue is an internal component of every mirror farm, and is shared between all nodes. When the contents of an upstream repository changes, an item is added to this queue so that the mirror farm nodes know to synchronize. The mirror farm constantly polls and removes items from this queue for processing, so it is empty most of the time.
   *
   * @return RestRefSyncQueue
   */
  @GET
  @Path("/supportInfo/refChangesQueue")
  @Produces("application/json;charset=UTF-8")
  @APIResponseSchema(RestRefSyncQueue.class)
  @Operation(summary = "Get items in ref changes queue")
  RestRefSyncQueue getRefChangesQueue();

  /**
   * Get total number of items in ref changes queue.
   * Retrieves the total number of items currently in the ref changes queue
   */
  @GET
  @Path("/supportInfo/refChangesQueue/count")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The total number of items currently in the ref changes queue")
  })
  @Operation(summary = "Get total number of items in ref changes queue")
  void getRefChangesQueueCount();

  /**
   * Get sync status of repositories.
   * Retrieves a page of sync statuses of the repositories on this mirror node
   *
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseMirroringLatestSupportInfoRepoSyncStatus
   */
  @GET
  @Path("/supportInfo/repoSyncStatus")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(_ResponseMirroringLatestSupportInfoRepoSyncStatus.class)
  @Operation(summary = "Get sync status of repositories")
  _ResponseMirroringLatestSupportInfoRepoSyncStatus getRepoSyncStatus(@QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get upstream servers.
   * Retrieves a page of upstream servers
   *
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseMirroringLatestUpstreamServers
   */
  @GET
  @Path("/upstreamServers")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(_ResponseMirroringLatestUpstreamServers.class)
  @Operation(summary = "Get upstream servers")
  _ResponseMirroringLatestUpstreamServers listUpstreamServers(@QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get upstream server by ID.
   * Retrieves upstream server details by ID.
   *
   * @param upstreamId The upstream server ID to retrieve settings for. (not null)
   * @return RestUpstreamServer
   */
  @GET
  @Path("/upstreamServers/{upstreamId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The upstream server.",
                 content = @Content(schema = @Schema(implementation = RestUpstreamServer.class))),
    @APIResponse(responseCode = "404", description = "The upstream server could not be found",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestUpstreamServersUpstreamId_404.class)))
  })
  @Operation(summary = "Get upstream server by ID")
  RestUpstreamServer getUpstreamServer(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Get farm nodes.
   * Retrieves the list of farm nodes in this cluster
   *
   * @param upstreamId the upstream server ID to retrieve settings for (not null)
   * @return List<RestClusterNode>
   */
  @GET
  @Path("/upstreamServers/{upstreamId}/farmNodes")
  @Produces("application/json;charset=UTF-8")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The list of farm nodes",
                 content = @Content(schema = @Schema(implementation = RestClusterNode.class, type = SchemaType.ARRAY))),
    @APIResponse(responseCode = "404", description = "The upstream server could not be found",
                 content = @Content(schema = @Schema(implementation = RestErrors.class)))
  })
  @Operation(summary = "Get farm nodes")
  List<RestClusterNode> getFarmNodes(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Get synchronization progress state.
   *  Retrieves synchronization progress state for the specified upstream server.If there's no progress to report, this resource will return <pre><code> {"discovering":false,"syncedRepos":0,"totalRepos":0}</code></pre> If there are repositories in the process of synchronizing, but the precise number hasn't been discovered yet, this resource will return: <pre><code> {"discovering":true,"syncedRepos":3,"totalRepos":100}</code></pre> If there is progress to report and the total number of repositories is known, this resource will return: <pre> <code> {"discovering":false,"syncedRepos":242,"totalRepos":1071}</code> </pre>
   *
   * @param upstreamId the upstream server ID to retrieve settings for (not null)
   * @return RestSyncProgress
   */
  @GET
  @Path("/upstreamServers/{upstreamId}/progress")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the synchronization progress state",
                 content = @Content(schema = @Schema(implementation = RestSyncProgress.class))),
    @APIResponse(responseCode = "404", description = "The upstream server could not be found.",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestUpstreamServersUpstreamIdProgress_404.class)))
  })
  @Operation(summary = "Get synchronization progress state")
  RestSyncProgress getSynchronizationProgress(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Get clone URLs.
   * Retrieves all available clone urls for the specified repository.
   *
   * @param upstreamRepoId the repository ID (not null)
   * @param upstreamId the upstream server ID (not null)
   * @return RestMirroredRepository
   */
  @GET
  @Path("/upstreamServers/{upstreamId}/repos/{upstreamRepoId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The mirrored repository's information.",
                 content = @Content(schema = @Schema(implementation = RestMirroredRepository.class))),
    @APIResponse(responseCode = "404", description = "The upstream server or the repository could not be found.",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestUpstreamServersUpstreamIdReposUpstreamRepoId_404.class)))
  })
  @Operation(summary = "Get clone URLs")
  RestMirroredRepository getMirroredRepository(@PathParam("upstreamRepoId") @NotNull String upstreamRepoId, @PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Get upstream settings.
   * Retrieves upstream settings
   *
   * @param upstreamId  (not null)
   * @return RestUpstreamSettings
   */
  @GET
  @Path("/upstreamServers/{upstreamId}/settings")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the mirror settings",
                 content = @Content(schema = @Schema(implementation = RestUpstreamSettings.class))),
    @APIResponse(responseCode = "404", description = "The upstream server could not be found.",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestUpstreamServersUpstreamIdSettings_404.class)))
  })
  @Operation(summary = "Get upstream settings")
  RestUpstreamSettings getMirrorSettings(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Update upstream settings.
   * Sets the settings for the specified upstream
   *
   * @param upstreamId  (not null)
   * @param dto the mirror settings to update to (optional)
   * @return RestUpstreamSettings
   */
  @PUT
  @Path("/upstreamServers/{upstreamId}/settings")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the updated mirror settings",
                 content = @Content(schema = @Schema(implementation = RestUpstreamSettings.class))),
    @APIResponse(responseCode = "404", description = "The upstream server could not be found.",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestUpstreamServersUpstreamIdSettings_404.class)))
  })
  @Operation(summary = "Update upstream settings")
  RestUpstreamSettings setMirrorSettings(@PathParam("upstreamId") @NotNull String upstreamId, @Valid RestUpstreamSettings dto);

  /**
   * Get mirror mode.
   * Gets the current mirror mode for the specified upstream
   *
   * @param upstreamId  (not null)
   */
  @GET
  @Path("/upstreamServers/{upstreamId}/settings/mode")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the current mirror mode"),
    @APIResponse(responseCode = "404", description = "The upstream server could not be found.",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestUpstreamServersUpstreamIdSettingsMode_404.class)))
  })
  @Operation(summary = "Get mirror mode")
  void getMirrorMode(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Update mirror mode.
   * Sets the mirror mode for the specified upstream
   *
   * @param upstreamId  (not null)
   * @param dto  (optional)
   */
  @PUT
  @Path("/upstreamServers/{upstreamId}/settings/mode")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the mode to set"),
    @APIResponse(responseCode = "400", description = "The provided mode is invalid",
                 content = @Content(schema = @Schema(implementation = _ResponseMirroringLatestUpstreamServersUpstreamIdSettingsMode_400.class)))
  })
  @Operation(summary = "Update mirror mode")
  void setMirrorMode(@PathParam("upstreamId") @NotNull String upstreamId, String dto);

  /**
   * Get mirrored project IDs.
   * Returns the IDs of the projects that the mirror is configured to mirror
   *
   * @param upstreamId  (not null)
   */
  @GET
  @Path("/upstreamServers/{upstreamId}/settings/projects")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the currently mirrored project IDs")
  })
  @Operation(summary = "Get mirrored project IDs")
  void getMirroredProjects(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Add multiple projects to be mirrored.
   * Configures the mirror to mirror the provided projects
   *
   * @param upstreamId  (not null)
   * @param dto  (optional)
   */
  @POST
  @Path("/upstreamServers/{upstreamId}/settings/projects")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the currently mirrored project IDs")
  })
  @Operation(summary = "Add multiple projects to be mirrored")
  void startMirroringProjects(@PathParam("upstreamId") @NotNull String upstreamId, List<String> dto);

  /**
   * Stop mirroring projects.
   * Configures the mirror to no longer mirror the provided projects
   *
   * @param upstreamId  (not null)
   * @param dto  (optional)
   */
  @DELETE
  @Path("/upstreamServers/{upstreamId}/settings/projects")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "the request has been processed")
  })
  @Operation(summary = "Stop mirroring projects")
  void stopMirroringProjects(@PathParam("upstreamId") @NotNull String upstreamId, List<String> dto);

  /**
   * Add project to be mirrored.
   * Configures the mirror to mirror the provided project
   *
   * @param upstreamId  (not null)
   * @param projectId  (not null)
   */
  @POST
  @Path("/upstreamServers/{upstreamId}/settings/projects/{projectId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the currently mirrored project IDs")
  })
  @Operation(summary = "Add project to be mirrored")
  void startMirroringProject(@PathParam("upstreamId") @NotNull String upstreamId, @PathParam("projectId") @NotNull String projectId);

  /**
   * Stop mirroring project.
   * Configures the mirror to no longer mirror the provided project
   *
   * @param upstreamId  (not null)
   * @param projectId the project ID to stop mirroring (not null)
   */
  @DELETE
  @Path("/upstreamServers/{upstreamId}/settings/projects/{projectId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "the request has been processed")
  })
  @Operation(summary = "Stop mirroring project")
  void stopMirroringProject(@PathParam("upstreamId") @NotNull String upstreamId, @PathParam("projectId") @NotNull String projectId);
}
