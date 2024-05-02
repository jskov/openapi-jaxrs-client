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
import mada.tests.e2e.examples.bitbucket.dto.GroupPickerContext;
import mada.tests.e2e.examples.bitbucket.dto.RestBranch;
import mada.tests.e2e.examples.bitbucket.dto.RestBuildStatus;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestParticipant;
import mada.tests.e2e.examples.bitbucket.dto.UserPickerContext;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsAddUser_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsAddUser_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsAddUser_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsRemoveUser_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsRemoveUser_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsRemoveUser_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersAddGroup_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersAddGroup_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersAddGroup_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranchesDefault_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranchesDefault_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdTasksCount_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdTasks_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestTasksTaskId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestTasks_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBuildStatusLatestCommitsCommitId;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBuildStatusLatestCommitsCommitId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBuildStatusLatestCommitsCommitId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_404;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface DeprecatedApi {

  /**
   * Add user to group.
   * <strong>Deprecated since 2.10</strong>. Use /rest/users/add-groups instead.

Add a user to a group.

In the request entity, the <em>context</em> attribute is the group and the <em>itemName</em> is the user.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @param dto  (optional)
   */
  @POST
  @Path("api/latest/admin/groups/add-user")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The user was added to the group."),
    @APIResponse(responseCode = "401", description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsAddUser_401.class))),
    @APIResponse(responseCode = "403", description = "The action was disallowed as it would exceed the server's licensing limit, or the groups permissions exceed the authenticated user's permission level.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsAddUser_403.class))),
    @APIResponse(responseCode = "404", description = "The specified user or group does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsAddUser_404.class)))
  })
  @Operation(summary = "Add user to group")
  void addUserToGroup(@Valid UserPickerContext dto);

  /**
   * Remove user from group.
   * <strong>Deprecated since 2.10</strong>. Use /rest/users/remove-groups instead.

Remove a user from a group.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.

In the request entity, the <em>context</em> attribute is the group and the <em>itemName</em> is the user.
   *
   * @param dto  (optional)
   */
  @POST
  @Path("api/latest/admin/groups/remove-user")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The user was removed from the group."),
    @APIResponse(responseCode = "401", description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsRemoveUser_401.class))),
    @APIResponse(responseCode = "403", description = "The action was disallowed as the group has a higher permission level than the context user.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsRemoveUser_403.class))),
    @APIResponse(responseCode = "404", description = "The specified user or group does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsRemoveUser_404.class)))
  })
  @Operation(summary = "Remove user from group")
  void removeUserFromGroup(@Valid UserPickerContext dto);

  /**
   * Add user to group.
   * <strong>Deprecated since 2.10</strong>. Use /rest/users/add-groups instead.

Add a user to a group. This is very similar to <code>groups/add-user</code>, but with the <em>context</em> and <em>itemName</em> attributes of the supplied request entity reversed. On the face of it this may appear redundant, but it facilitates a specific UI component in the application.

In the request entity, the <em>context</em> attribute is the user and the <em>itemName</em> is the group.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @param dto  (optional)
   */
  @POST
  @Path("api/latest/admin/users/add-group")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The user was added to the group"),
    @APIResponse(responseCode = "401", description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersAddGroup_401.class))),
    @APIResponse(responseCode = "403", description = "The action was disallowed as it would exceed the server's licensing limit, or the groups permissions exceed the authenticated user's permission level.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersAddGroup_403.class))),
    @APIResponse(responseCode = "404", description = "The specified user or group does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersAddGroup_404.class)))
  })
  @Operation(summary = "Add user to group")
  void addGroupToUser(@Valid GroupPickerContext dto);

  /**
   * Get default branch.
   * Retrieves the repository's default branch, if it has been created. If the repository is empty, 204 No Content will be returned. For non-empty repositories, if the configured default branch has not yet been created a 404 Not Found will be returned.

This URL is deprecated. Callers should use <code>GET /projects/{key}/repos/{slug}/default-branch</code> instead, which allows retrieving the <i>configured</i> default branch even if the ref has not been created yet.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestBranch
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/branches/default")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The configured default branch for the repository.",
                 content = @Content(schema = @Schema(implementation = RestBranch.class))),
    @APIResponse(responseCode = "204", description = "The repository is empty, and has no default branch."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to read the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranchesDefault_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist, or its configured default branch does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranchesDefault_404.class)))
  })
  @Operation(summary = "Get default branch")
  RestBranch getDefaultBranch_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update default branch.
   * Update the default branch of a repository.

This URL is deprecated. Callers should use <code>PUT /projects/{key}/repos/{slug}/default-branch</code> instead.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The branch to set as default (optional)
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/branches/default")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The operation was successful."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranchesDefault_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranchesDefault_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Update default branch")
  void setDefaultBranch_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestBranch dto);

  /**
   * Approve pull request.
   * Approve a pull request as the current user. Implicitly adds the user as a participant if they are not already.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.

<strong>Deprecated since 4.2</strong>. Use /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants/{userSlug} instead
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestPullRequestParticipant
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/approve")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Details of the new participant.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestParticipant.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_404.class))),
    @APIResponse(responseCode = "409", description = "The pull request is not open.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_409.class)))
  })
  @Operation(summary = "Approve pull request")
  RestPullRequestParticipant approve(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Unapprove pull request.
   * Remove approval from a pull request as the current user. This does not remove the user as a participant.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.

<strong>Deprecated since 4.2</strong>. Use /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants/{userSlug} instead
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestPullRequestParticipant
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/approve")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Details of the updated participant.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestParticipant.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist or the current user is not a participant on the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_404.class))),
    @APIResponse(responseCode = "409", description = "The pull request is not open.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdApprove_409.class)))
  })
  @Operation(summary = "Unapprove pull request")
  RestPullRequestParticipant withdrawApproval(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Unassign pull request participant.
   * Unassigns a participant from the REVIEWER role they may have been given in a pull request.

If the participant has no explicit role this method has no effect.

Afterwards, the user will still remain a participant in the pull request but their role will be reduced to PARTICIPANT. This is because once made a participant of a pull request, a user will forever remain a participant. Only their role may be altered.

The authenticated user must have <strong>REPO_WRITE</strong> permission for the repository that this pull request targets to call this resource.

<strong>Deprecated since 4.2</strong>. Use /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants/{userSlug} instead.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param username  (optional)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The update completed."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "Removing reviewers isn't supported on archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Unassign pull request participant")
  void unassignParticipantRole_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("username") String username);

  /**
   * Get pull request tasks.
   * Retrieve the tasks associated with a pull request.

**Removed in 8.0**. Tasks are now managed using Comments with BLOCKER severity. Use /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments instead

**Deprecated since 7.2, changed to 404 in 8.0, remove in 9.0.** Use /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments instead
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/tasks")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "404", description = "This endpoint has been removed as tasks are now managed using Comments with severity BLOCKER.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdTasks_404.class)))
  })
  @Operation(summary = "Get pull request tasks")
  void getPullRequestTasks(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get pull request task count.
   * Retrieve the total number of OPEN and RESOLVED tasks associated with a pull request.

<strong>Deprecated since 7.2</strong>. Tasks are now managed using Comments with BLOCKER severity. Use /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments?count=true instead.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/tasks/count")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "404", description = "This endpoint has been removed as tasks are now managed using Comments with severity BLOCKER.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdTasksCount_404.class)))
  })
  @Operation(summary = "Get pull request task count")
  void countPullRequestTasks(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Create task.
   * Create a new task.

<strong>Removed in 8.0</strong>. Tasks are now managed using Comments with severity BLOCKER. Call <code>POST /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments</code> instead,passing the attribute 'severity' set to 'BLOCKER'.
   */
  @POST
  @Path("api/latest/tasks")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "404", description = "This endpoint has been removed as tasks are now managed using Comments with severity BLOCKER.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestTasks_404.class)))
  })
  @Operation(summary = "Create task")
  void createTask();

  /**
   * Get task.
   * Retrieve an existing task.

<strong>Removed in 8.0</strong>. Tasks are now managed using Comments with BLOCKER severity. Call <code>GET /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId} </code>instead. @deprecated since 7.2, changed to 404 in 8.0, remove in 9.0. Call GET /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId} instead.
   *
   * @param taskId the id identifying the task (not null)
   */
  @GET
  @Path("api/latest/tasks/{taskId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "404", description = "This endpoint has been removed as tasks are now managed using Comments with severity BLOCKER.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestTasksTaskId_404.class)))
  })
  @Operation(summary = "Get task")
  void getTask(@PathParam("taskId") @NotNull String taskId);

  /**
   * Update task.
   * Update an existing task.

 <strong>Removed in 8.0</strong>.  Tasks are now managed using Comments with BLOCKER severity.  Call <code>PUT /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId} </code> instead.  To resolve a task, pass the attribute 'state' set to 'RESOLVED'.  @deprecated since 7.2, changed to 404 in 8.0, remove in 9.0. Call <code>PUT  /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}
</code> instead.

 As of Stash 3.3, only the state and text of a task can be updated.

 Updating the state of a task is allowed for any user having <em>READ</em> access to the repository.  However only the task's creator, the context's author or an admin of the context's repository can update the task's text. (For a pull request task, those are the task's creator, the pull request's author or an admin on the repository containing the pull request). Additionally the task's text cannot be updated if it has been resolved.
   *
   * @param taskId the id identifying the task to update (not null)
   */
  @PUT
  @Path("api/latest/tasks/{taskId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "404", description = "This endpoint has been removed as tasks are now managed using Comments with severity BLOCKER.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestTasksTaskId_404.class)))
  })
  @Operation(summary = "Update task")
  void updateTask(@PathParam("taskId") @NotNull String taskId);

  /**
   * Delete task.
   * Delete a task.

<strong>Removed in 8.0</strong>. Tasks are now managed using Comments with BLOCKER severity. Call <code>DELETE /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}</code>instead. @deprecated since 7.2, changed to 404 in 8.0, remove in 9.0. Call DELETE /rest/api/1.0/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId} instead.

Note that only the task's creator, the context's author or an admin of the context's repository can delete a task. (For a pull request task, those are the task's creator, the pull request's author or an admin on the repository containing the pull request). Additionally a task cannot be deleted if it has already been resolved.
   *
   * @param taskId the id identifying the task to delete (not null)
   */
  @DELETE
  @Path("api/latest/tasks/{taskId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "404", description = "This endpoint has been removed as tasks are now managed using Comments with severity BLOCKER.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestTasksTaskId_404.class)))
  })
  @Operation(summary = "Delete task")
  void deleteTask(@PathParam("taskId") @NotNull String taskId);

  /**
   * Get build statuses for commit.
   * Gets build statuses associated with a commit.

<strong>Deprecated in 7.14, please use the repository based builds resource instead.</strong>
   *
   * @param orderBy How the results should be ordered. Options are NEWEST, OLDEST, STATUS (optional)
   * @param commitId Full SHA1 of the commit (ex: <code>e00cf62997a027bbf785614a93e2e55bb331d268</code>) (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseBuildStatusLatestCommitsCommitId
   */
  @GET
  @Path("build-status/latest/commits/{commitId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A Page of build statuses associated with the commit <br /> (limited to the most recent 100 build statuses associated with the commit)",
                 content = @Content(schema = @Schema(implementation = _ResponseBuildStatusLatestCommitsCommitId.class))),
    @APIResponse(responseCode = "401", description = "The user is not authenticated or does not have the <b>LICENSED</b> permission.",
                 content = @Content(schema = @Schema(implementation = _ResponseBuildStatusLatestCommitsCommitId_401.class)))
  })
  @Operation(summary = "Get build statuses for commit")
  _ResponseBuildStatusLatestCommitsCommitId getBuildStatus(@QueryParam("orderBy") String orderBy, @PathParam("commitId") @NotNull String commitId, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create build status for commit.
   * Associates a build status with a commit.The <code>state</code>, the <code>key</code> and the <code>url</code> fields are mandatory. The <code>name</code> and<code>description</code> fields are optional.All fields (mandatory or optional) are limited to 255 characters, except for the <code>url</code>,which is limited to 450 characters.Supported values for the <code>state</code> are <code>SUCCESSFUL</code>, <code>FAILED</code>and <code>INPROGRESS</code>.The authenticated user must have <strong>LICENSED</strong> permission or higher to call this resource.

<strong>Deprecated in 7.14, please use the repository based builds resource instead.</strong>
   *
   * @param commitId full SHA1 of the commit (not null)
   * @param dto build status to associate with the commit (optional)
   */
  @POST
  @Path("build-status/latest/commits/{commitId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response if the build status was successfully stored"),
    @APIResponse(responseCode = "400", description = "An error message if the <code>commitId</code> is not a full 40-characters SHA1, if the build status has a missing mandatory field or if the fields are too large",
                 content = @Content(schema = @Schema(implementation = _ResponseBuildStatusLatestCommitsCommitId_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The user is not authenticated or does not have the <strong>LICENSED</strong> permission",
                 content = @Content(schema = @Schema(implementation = _ResponseBuildStatusLatestCommitsCommitId_401.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Create build status for commit")
  void addBuildStatus(@PathParam("commitId") @NotNull String commitId, @Valid RestBuildStatus dto);

  /**
   * Get comment likes.
   * Get a page of users who liked a commit comment in the specified repository, identified by <code>commitId</code> and <code>commentId</code>.

The authenticated user must have the **REPO_READ** (or higher) permission for the specified repository to access this resource.

<strong>Deprecated in 8.0 to be removed in 9.0.</strong>
   *
   * @param projectKey The project key. (not null)
   * @param commentId  (not null)
   * @param commitId The commit id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes
   */
  @GET
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}/likes")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of users who liked the specified comment",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user does not have sufficient permission (<code>REPO_READ</code>) to query the comment likes",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository, commit or comment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_404.class)))
  })
  @Operation(summary = "Get comment likes")
  _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes getLikers(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull long commentId, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Like a commit comment.
   * Like a commit comment in the specified repository, identified by <code>commitId</code> and <code>commentId</code>.

The authenticated user must have the <strong>REPO_READ</strong> (or higher) permission for the specified repository to access this resource.

<strong>Deprecated in 8.0 to be removed in 9.0.</strong> Likes have been replaced with reactions. For backwards compatibility, the <pre>thumbsup</pre> reaction is treated as a like.
   *
   * @param projectKey The project key. (not null)
   * @param commentId  (not null)
   * @param commitId The commit id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @POST
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}/likes")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No content response indicating that the request succeeded"),
    @APIResponse(responseCode = "400", description = "The currently authenticated user is the comment author",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user does not have sufficient permission",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository, commit or comment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Like a commit comment")
  void like(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull long commentId, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Unlike a commit comment.
   * Unlike a commit comment in the specified repository, identified by <code>commitId</code> and <code>commentId</code>.

The authenticated user must have the <strong>REPO_READ</strong> (or higher) permission for the specified repository to access this resource.

<strong>Deprecated in 8.0 to be removed in 9.0.</strong> Likes have been replaced with reactions. For backwards compatibility, the <pre>thumbsup</pre> reaction is treated as a like.
   *
   * @param projectKey The project key. (not null)
   * @param commentId  (not null)
   * @param commitId The commit id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}/likes")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No content response indicating that the request succeeded"),
    @APIResponse(responseCode = "400", description = "The currently authenticated user is the comment author",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user does not have sufficient permission",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository, commit or comment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentIdLikes_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Unlike a commit comment")
  void unlike(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull long commentId, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get pull request comment likes.
   * Get a page of users who liked a pull request comment in the specified repository, identified by <code>pullRequestId</code> and <code>commentId</code>.

The authenticated user must have the <strong>REPO_READ</strong> (or higher) permission for the specified repository to access this resource.

**Deprecated in 8.0 to be removed in 9.0.**
   *
   * @param projectKey The project key. (not null)
   * @param commentId The comment id. (not null)
   * @param pullRequestId The pull request id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes
   */
  @GET
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}/likes")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of users who liked the specified comment",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user does not have sufficient permission (<code>REPO_READ</code>) to query the comment likes",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository, pull request or comment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_404.class)))
  })
  @Operation(summary = "Get pull request comment likes")
  _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes getLikers_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Like a pull request comment.
   * Like a pull request comment in the specified repository, identified by <code>pullRequestId</code> and <code>commentId</code>. The like will be recorded against the requesting user.

The authenticated user must have the <strong>REPO_READ</strong> (or higher) permission for the specified repository to access this resource.

**Deprecated in 8.0 to be removed in 9.0.** Likes have been replaced with reactions. For backwards compatibility, the <pre>thumbsup</pre> reaction is treated as a like.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The comment id. (not null)
   * @param pullRequestId The pull request id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @POST
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}/likes")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No content response indicating that the request succeeded"),
    @APIResponse(responseCode = "401", description = "he currently authenticated user does not have sufficient permission (<code>REPO_READ</code>)",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository, pull request or comment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Like a pull request comment")
  void like_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Unlike a pull request comment.
   * Unlike a pull request comment in the specified repository, identified by <code>pullRequestId</code> and <code>commentId</code>.

The authenticated user must have the <strong>REPO_READ</strong> (or higher) permission for the specified repository to access this resource.

**Deprecated in 8.0 to be removed in 9.0.** Likes have been replaced with reactions. For backwards compatibility, the <pre>thumbsup</pre> reaction is treated as a like.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The comment id. (not null)
   * @param pullRequestId The pull request id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}/likes")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No content response indicating that the request succeeded"),
    @APIResponse(responseCode = "400", description = "The currently authenticated user is the comment author",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user does not have sufficient permission (<code>REPO_READ</code>)",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository, pull request or comment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseCommentLikesLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdLikes_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Unlike a pull request comment")
  void unlike_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * On disable of mirror addon.
   * This REST endpoint is retained for backwards compatibility only. It is a no-op. Starting from 4.6.0, mirrors no longer specify a disabled lifecycle callback in their addon descriptor. Prior to 4.6.0, this was the callback method that was called when the mirroring atlassian-connect add-on has been disabled in the upstream server identified by <code> upstreamId</code>.
   *
   * @param upstreamId the upstream server ID to retrieve settings for (not null)
   */
  @POST
  @Path("mirroring/latest/upstreamServers/{upstreamId}/addon/disabled")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that callback has been processed")
  })
  @Operation(summary = "On disable of mirror addon")
  void onAddonDisabled(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * On enabled of mirror addon.
   * This REST endpoint is retained for backwards compatibility only. It is a no-op. Starting from 4.6.0, mirrors no longer specify an enabled lifecycle callback in their addon descriptor. Prior
to 4.6.0, this was the callback method that was called when the mirroring atlassian-connect add-on has been
enabled in the upstream server identified by <code>upstreamId</code>.
   *
   * @param upstreamId the upstream server ID to retrieve settings for (not null)
   */
  @POST
  @Path("mirroring/latest/upstreamServers/{upstreamId}/addon/enabled")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that callback has been processed")
  })
  @Operation(summary = "On enabled of mirror addon")
  void onAddonEnabled(@PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Get upstream settings.
   * This method is no longer supported
   *
   * @param upstreamRepoId  (not null)
   * @param level the level of synchronization to perform (optional)
   * @param upstreamId the upstream server ID to retrieve settings for (not null)
   */
  @POST
  @Path("mirroring/latest/upstreamServers/{upstreamId}/repos/{upstreamRepoId}/synchronization")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "410", description = "this operation is no longer supported")
  })
  @Operation(summary = "Get upstream settings")
  void synchronizeRepositoryWithUpstream(@PathParam("upstreamRepoId") @NotNull String upstreamRepoId, @QueryParam("level") String level, @PathParam("upstreamId") @NotNull String upstreamId);

  /**
   * Change upstream settings.
   * This method is no longer supported
   *
   * @param level  (optional)
   * @param upstreamId the upstream server ID to retrieve settings for (not null)
   */
  @POST
  @Path("mirroring/latest/upstreamServers/{upstreamId}/synchronization")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "410", description = "this operation is no longer supported")
  })
  @Operation(summary = "Change upstream settings")
  void synchronizeWithUpstream(@QueryParam("level") String level, @PathParam("upstreamId") @NotNull String upstreamId);
}
