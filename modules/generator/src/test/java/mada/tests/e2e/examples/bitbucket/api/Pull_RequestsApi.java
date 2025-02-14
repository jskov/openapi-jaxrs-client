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
import mada.tests.e2e.examples.bitbucket.dto.RestApplicationUser;
import mada.tests.e2e.examples.bitbucket.dto.RestApplySuggestionRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeProcessingResult;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestChange;
import mada.tests.e2e.examples.bitbucket.dto.RestComment;
import mada.tests.e2e.examples.bitbucket.dto.RestCommit;
import mada.tests.e2e.examples.bitbucket.dto.RestCommitMessageSuggestion;
import mada.tests.e2e.examples.bitbucket.dto.RestDefaultReviewersRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestErrors;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestAssignParticipantRoleRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestAssignStatusRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestCondition;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestDeclineRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestDeleteRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestFinishReviewRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestMergeConfig;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestMergeRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestMergeability;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestParticipant;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestRebaseRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestRebaseResult;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestRebaseability;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestReopenRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestReviewerGroup;
import mada.tests.e2e.examples.bitbucket.dto.RestUserReaction;
import mada.tests.e2e.examples.bitbucket.dto._RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPullRequestsScmId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPullRequestsScmId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPullRequestsScmId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPullRequestsScmId_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdChanges_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdChanges_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommitMessageSuggestion_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommitMessageSuggestion_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDecline_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDecline_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDecline_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMergeBase_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReopen_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReopen_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReopen_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdWatch_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdWatch_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_patch_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_patch_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroups;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseDefaultReviewersLatestProjectsProjectKeyConditionId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseDefaultReviewersLatestProjectsProjectKeyConditionId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseDefaultReviewersLatestProjectsProjectKeyCondition_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugCondition_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_409;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface Pull_RequestsApi {

  /**
   * Get merge strategies.
   * Retrieve the merge strategies available for this instance.

The user must be authenticated to call this resource.
   *
   * @param scmId the id of the scm to get strategies for (not null)
   * @return RestPullRequestMergeConfig
   */
  @GET
  @Path("api/latest/admin/pull-requests/{scmId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The merge configuration of this instance.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestMergeConfig.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to see the request repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPullRequestsScmId_401.class))),
    @APIResponse(responseCode = "404", description = "The request repository does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPullRequestsScmId_404.class)))
  })
  @Operation(summary = "Get merge strategies")
  RestPullRequestMergeConfig getMergeConfig(@PathParam("scmId") @NotNull String scmId);

  /**
   * Update merge strategies.
   * Update the pull request merge strategies for the context repository.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.

Only the strategies provided will be enabled, only one may be set to default

The commit message template will not be updated if not provided, and will be deleted if the `commitMessageTemplate` attribute is empty, i.e: `commitMessageTemplate: {}`.

An explicitly set pull request merge strategy configuration can be deleted by POSTing a document with an empty `mergeConfig` attribute. i.e:
```
{
    "mergeConfig": {}
}
```

Upon completion of this request, the effective configuration will be the default configuration.
   *
   * @param scmId the id of the scm to get strategies for (not null)
   * @param dto the settings (optional)
   * @return RestPullRequestMergeConfig
   */
  @POST
  @Path("api/latest/admin/pull-requests/{scmId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The repository pull request merge strategies for the context repository.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestMergeConfig.class))),
    @APIResponse(responseCode = "400", description = "The repository pull request merge strategies were not updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPullRequestsScmId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to administrate thespecified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPullRequestsScmId_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPullRequestsScmId_404.class))),
    @APIResponse(responseCode = "409", description = "Setting or deleting merge configurations isn't supported on archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPullRequestsScmId_409.class)))
  })
  @Operation(summary = "Update merge strategies")
  RestPullRequestMergeConfig setMergeConfig(@PathParam("scmId") @NotNull String scmId, @Valid RestPullRequestSettings dto);

  /**
   * Get repository pull requests containing commit.
   * Retrieve a page of pull requests in the current repository that contain the given commit.

The user must be authenticated and have access to the specified repository to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commitId the commit ID (not null)
   * @param repositorySlug The repository slug (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/pull-requests")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Return a page of pull requests in the current repository containing the given commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to see the request repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests_401.class))),
    @APIResponse(responseCode = "404", description = "The request repository does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests_404.class)))
  })
  @Operation(summary = "Get repository pull requests containing commit")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdPullRequests getPullRequests(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Search pull request participants.
   * Retrieve a page of participant users for all the pull requests to or from the specified repository.

Optionally clients can specify following filters.
   *
   * @param filter (optional) Return only users, whose username, name or email address <i>contain</i> the filter value (optional)
   * @param projectKey The project key. (not null)
   * @param role (optional) The role associated with the pull request participant. This must be one of AUTHOR, REVIEWER, or PARTICIPANT (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param direction (optional), Defaults to <strong>INCOMING</strong>) the direction relative to the specified repository. Either <strong>INCOMING</strong> or <strong>OUTGOING</strong>. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/participants")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of users that match the search criteria.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants_404.class)))
  })
  @Operation(summary = "Search pull request participants")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugParticipants search(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("role") String role, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("direction") String direction, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get pull requests for repository.
   * Retrieve a page of pull requests to or from the specified repository.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.  Optionally clients can specify PR participant filters. Each filter has a mandatory username.N parameter, and the optional role.N and approved.N parameters.

- username.N - the "root" of a single participant filter, where "N" is a natural number   starting from 1. This allows clients to specify multiple participant filters, by providing consecutive   filters as username.1, username.2 etc. Note that the filters numbering has to start   with 1 and be continuous for all filters to be processed. The total allowed number of participant   filters is 10 and all filters exceeding that limit will be dropped.
- role.N(optional) the role associated with username.N.   This must be one of AUTHOR, REVIEWER, or PARTICIPANT
- approved.N (optional) the approved status associated with username.N.   That is whether username.N has approved the PR. Either true, or false

   *
   * @param withAttributes (optional) defaults to true, whether to return additional pull request attributes (optional)
   * @param projectKey The project key. (not null)
   * @param at (optional) a <i>fully-qualified</i> branch ID to find pull requests to or from, such as refs/heads/master (optional)
   * @param withProperties (optional) defaults to true, whether to return additional pull request properties (optional)
   * @param draft (optional) If specified, only pull requests matching the supplied draft status will be returned. (optional)
   * @param filterText (optional) If specified, only pull requests where the title or description contains the supplied string will be returned. (optional)
   * @param state (optional, defaults to <strong>OPEN</strong>). Supply <strong>ALL</strong> to return pull request in any state. If a state is supplied only pull requests in the specified state will be returned. Either <strong>OPEN</strong>, <strong>DECLINED</strong> or <strong>MERGED</strong>. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param order (optional, defaults to <strong>NEWEST</strong>) the order to return pull requests in, either <strong>OLDEST</strong> (as in: "oldest first") or <strong>NEWEST</strong>. (optional)
   * @param direction (optional, defaults to <strong>INCOMING</strong>) the direction relative to the specified repository. Either <strong>INCOMING</strong> or <strong>OUTGOING</strong>. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of pull requests that match the search criteria.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_404.class)))
  })
  @Operation(summary = "Get pull requests for repository")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests getPage(@QueryParam("withAttributes") String withAttributes, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @QueryParam("withProperties") String withProperties, @QueryParam("draft") String draft, @QueryParam("filterText") String filterText, @QueryParam("state") String state, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("order") String order, @QueryParam("direction") String direction, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create pull request.
   * Create a new pull request from a source branch or tag to a target branch. The source and target may be in the same repository, or different ones. (Note that different repositories must belong to the same <code>Repository#getHierarchyId()</code> hierarchy.)

The <code>fromRef</code> may be a branch or a tag. The <code>toRef</code> is required to be a branch. Tags are not allowed as targets because tags are intended to be immutable and should not be changed after they are created.

The authenticated user must have <strong>REPO_READ</strong> permission for the <code>fromRef</code> and <code>toRef</code> repositories to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The pull request data (optional)
   * @return RestPullRequest
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequest.class))),
    @APIResponse(responseCode = "400", description = "The pull request entity supplied in the request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to create a pull request between the two specified repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_401.class))),
    @APIResponse(responseCode = "404", description = "One of the specified repositories or branches does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_404.class))),
    @APIResponse(responseCode = "409", description = "One of the following error cases occurred (check the error message for more details): \n\n- There was a problem resolving one or more reviewers.\n- The specified branches were the same.\n- The <em>to</em> branch is already up-to-date with all the commits on the     <em>from</em> branch.\n- A pull request between the two branches already exists.\n- The <em>to</em> repository is archived.\n",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequests_409.class)))
  })
  @Operation(summary = "Create pull request")
  RestPullRequest create(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequest dto);

  /**
   * Get pull request.
   * Retrieve a pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestPullRequest
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The specified pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequest.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_404.class)))
  })
  @Operation(summary = "Get pull request")
  RestPullRequest get_3(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update pull request metadata.
   * Update the title, description, reviewers, destination branch or draft status of an existing pull request.

**Note:** the <em>reviewers</em> list may be updated using this resource. However the <em>author</em> and <em>participants</em> list may not.

The authenticated user must either:

- be the author of the pull request and have the <strong>REPO_READ</strong> permission for the repository that this pull request targets; or
- have the <strong>REPO_WRITE</strong> permission for the repository that this pull request targets


to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The updated pull request (optional)
   * @return RestPullRequest
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequest.class))),
    @APIResponse(responseCode = "400", description = "One of the following error cases occurred (check the error message for more details): \n\n- The request tried to modify the <em>author</em> or <em>participants</em>.\n- The pull request's version attribute was not specified.\n- A reviewer's username was not specified.\n- The toRef ID value was incorrectly left blank\n",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_401.class))),
    @APIResponse(responseCode = "404", description = "One of the specified repositories or branches does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_404.class))),
    @APIResponse(responseCode = "409", description = "One of the following error cases occurred (check the error message for more details): \n\n- The specified version is out of date.\n- One of the reviewers could not be added to the pull request.\n- If updating the destination branch:    - There is already an open pull request with an identical to branch\n   - The from and new to branch <i>are</i> the same\n   - The new destination branch up-to-date is up-to-date with all of                 changes from the from branch, resulting in a pull request with                 nothing to merge            \n- The <em>to</em> repository is archived.\n",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_409.class)))
  })
  @Operation(summary = "Update pull request metadata")
  RestPullRequest update(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequest dto);

  /**
   * Delete pull request.
   * Deletes a pull request.

To call this resource, users must be authenticated and have permission to view the pull request. Additionally, they must:

- be the pull request author, if the system is configured to allow authors to delete their own   pull requests (this is the default) OR
- have repository administrator permission for the repository the pull request is targeting


A body containing the version of the pull request must be provided with this request.

`{ "version": 1 }`
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto A body containing the version of the pull request (optional)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The pull request was deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "Deleting pull requests isn't supported on archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete pull request")
  void delete_3(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequestDeleteRequest dto);

  /**
   * Stream raw pull request diff.
   * Streams the raw diff for a pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param contextLines The number of context lines to include around added/removed lines in the diff (optional)
   * @param whitespace optional whitespace flag which can be set to <code>ignore-all</code> (optional)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}.diff")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A raw diff for the specified pull request."),
    @APIResponse(responseCode = "400", description = "The currently authenticated user has insufficient permissions to view the specified pull request."),
    @APIResponse(responseCode = "404", description = "The pull request does not exist.")
  })
  @Operation(summary = "Stream raw pull request diff")
  void streamRawDiff_2(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("contextLines") String contextLines, @QueryParam("whitespace") String whitespace, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Stream pull request as patch.
   * Streams a patch representing a pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}.patch")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A patch representing the specified pull request."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to access the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_patch_401.class))),
    @APIResponse(responseCode = "404", description = "The pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestId_patch_404.class)))
  })
  @Operation(summary = "Stream pull request as patch")
  void streamPatch_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get pull request activity.
   * Retrieve a page of activity associated with a pull request.

Activity items include comments, approvals, rescopes (i.e. adding and removing of commits), merges and more.

Different types of activity items may be introduced in newer versions of Stash or by user installed plugins, so clients should be flexible enough to handle unexpected entity shapes in the returned page.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param fromType (required if <strong>fromId</strong> is present) the type of the activity item specified by <strong>fromId</strong> (either <strong>COMMENT</strong> or <strong>ACTIVITY</strong>) (optional)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param fromId (optional) the ID of the activity item to use as the first item in the returned page (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/activities")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of activity relating to the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities_404.class)))
  })
  @Operation(summary = "Get pull request activity")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdActivities getActivities(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("fromType") String fromType, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("fromId") String fromId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get auto-merge request for pull request.
   * Returns an auto-merge request for the pull request, if requested.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestAutoMergeRequest
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/auto-merge")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The auto-merge request.",
                 content = @Content(schema = @Schema(implementation = RestAutoMergeRequest.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_404.class)))
  })
  @Operation(summary = "Get auto-merge request for pull request")
  RestAutoMergeRequest getAutoMergeRequest(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Auto-merge pull request.
   * Requests the system to try merging the pull request if auto-merge was requested on it.

The authenticated user must have <strong>REPO_WRITE</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestAutoMergeProcessingResult
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/auto-merge")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The result of trying to auto-merge the pull request.",
                 content = @Content(schema = @Schema(implementation = RestAutoMergeProcessingResult.class))),
    @APIResponse(responseCode = "400", description = "An auto-merge request was not submitted for this pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to modify the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_401.class))),
    @APIResponse(responseCode = "403", description = "The auto-merge setting is not enabled for the repository that this pull request targets.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_403.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_404.class)))
  })
  @Operation(summary = "Auto-merge pull request")
  RestAutoMergeProcessingResult tryAutoMerge(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Cancel auto-merge for pull request.
   * Cancels a request to auto-merge the pull request, if the pull request was not merged yet.

The authenticated user must have <strong>REPO_WRITE</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/auto-merge")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The auto-merge request was cancelled."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to modify the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "The specified pull request is not open.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdAutoMerge_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Cancel auto-merge for pull request")
  void cancelAutoMerge(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Search pull request comments.
   * Gets comments matching the given set of field values for the specified pull request. (Note this does <b>not</b> perform any kind of searching for comments by their text).

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param count If true only the count of the comments by state will be returned (and not the body of the comments). (optional)
   * @param state  (optional)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param states (optional). If supplied, only comments with a state in the given list will be returned. The state can be OPEN or RESOLVED. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of Comments from the supplied pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_404.class)))
  })
  @Operation(summary = "Search pull request comments")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments getComments_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("count") String count, @QueryParam("state") List<String> state, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("states") String states, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Add new blocker comment.
   * Add a new blocker comment.

Comments can be added in a few places by setting different attributes:

General pull request blocker comment:
```

{
     "text": "A task on a pull request."
}
```

Blocker reply to a comment:

```

{
     "text": "This reply is a task.",
     "parent": {
         "id": 1
     }
}
```

General blocker file comment:

```

{
     "text": "A blocker comment on a file.",
     "anchor": {
         "diffType": "RANGE",
         "fromHash": "6df3858eeb9a53a911cd17e66a9174d44ffb02cd",
         "path": "path/to/file",
         "srcPath": "path/to/file",
         "toHash": "04c7c5c931b9418ca7b66f51fe934d0bd9b2ba4b"
     }
 }
```

Blocker file line comment:

```

{
     "text": "A task on a particular line within a file.",
     "anchor": {
         "diffType": "COMMIT",
         "line": 1,
         "lineType": "CONTEXT",
         "fileType": "FROM",
         "fromHash": "6df3858eeb9a53a911cd17e66a9174d44ffb02cd",
         "path": "path/to/file",
         "srcPath": "path/to/file",
         "toHash": "04c7c5c931b9418ca7b66f51fe934d0bd9b2ba4b"
     }
 }
```

For file and line comments, 'path' refers to the path of the file to which the comment should be applied and 'srcPath' refers to the path the that file used to have (only required for copies and moves). Also, fromHash and toHash refer to the sinceId / untilId (respectively) used to produce the diff on which the comment was added. Finally diffType refers to the type of diff the comment was added on. For backwards compatibility purposes if no diffType is provided and no fromHash/toHash pair is provided the diffType will be resolved to 'EFFECTIVE'. In any other cases the diffType is REQUIRED.

For line comments, 'line' refers to the line in the diff that the comment should apply to. 'lineType' refers to the type of diff hunk, which can be:

- 'ADDED' - for an added line;
- 'REMOVED' - for a removed line; or
- 'CONTEXT' - for a line that was unmodified but is in the vicinity of the diff.

'fileType' refers to the file of the diff to which the anchor should be attached - which is of relevance when displaying the diff in a side-by-side way. Currently the supported values are:

- 'FROM' - the source file of the diff
 - 'TO' - the destination file of the diff


If the current user is not a participant the user is added as a watcher of the pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The comment to add. (optional)
   * @return RestComment
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "400", description = "The comment was not created due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request, create a comment or watch the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, pull request or parent comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_404.class))),
    @APIResponse(responseCode = "409", description = "The new created name already exists or adding, deleting, or editing comments isn't supported on archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerComments_409.class)))
  })
  @Operation(summary = "Add new blocker comment")
  RestComment createComment_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestComment dto);

  /**
   * Get pull request comment.
   * Retrieves a pull request comment.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The ID of the comment to retrieve (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestComment
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments/{commentId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, pull request or comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_404.class)))
  })
  @Operation(summary = "Get pull request comment")
  RestComment getComment_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update pull request comment.
   * Update a comment, with the following restrictions:

- only the author of the comment may update the <i>text</i> of the comment
- only the author of the comment, the author of the pull request or repository admins and above may update   the other fields of a comment


Convert a comment to a task or vice versa.

Comments can be converted to tasks by setting the 'severity' attribute to 'BLOCKER':
```

{
"severity": "BLOCKER"
}

```

Tasks can be converted to comments by setting the 'severity' attribute to 'NORMAL': ```

{
"severity": "NORMAL"
}

```

Resolve a blocker comment.

Blocker comments can be resolved by setting the 'state' attribute to 'RESOLVED': ```

{
"state": "RESOLVED"
}
```

<strong>Note:</strong> the supplied JSON object must contain a <code>version</code> that must match the server's version of the comment or the update will fail. To determine the current version of the comment, the comment should be fetched from the server prior to the update. Look for the 'version' attribute in the returned JSON structure.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The ID of the comment to retrieve. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The comment to add. (optional)
   * @return RestComment
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments/{commentId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly updated comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "400", description = "The comment was not updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request, update a comment or watch the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, pull request or comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_404.class))),
    @APIResponse(responseCode = "409", description = "The comment version supplied does not match the current version or the repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_409.class)))
  })
  @Operation(summary = "Update pull request comment")
  RestComment updateComment_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestComment dto);

  /**
   * Delete pull request comment.
   * Delete a pull request comment. Anyone can delete their own comment. Only users with <strong>REPO_ADMIN</strong> and above may delete comments created by other users.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The ID of the comment to retrieve. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param version The expected version of the comment. This must match the server's version of the comment or the delete will fail. To determine the current version of the comment, the comment should be fetched from the server prior to the delete. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/blocker-comments/{commentId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The operation was successful."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "The comment has replies, the version supplied does not match the current version or the repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdBlockerCommentsCommentId_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete pull request comment")
  void deleteComment_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Gets pull request changes.
   * Gets changes for the specified PullRequest.

If the changeScope query parameter is set to 'UNREVIEWED', the application will attempt to stream unreviewed changes based on the lastReviewedCommit of the current user, which are the changes between the lastReviewedCommit and the latest commit of the source branch. The current user is considered to <i>not</i> have any unreviewed changes for the pull request when the lastReviewedCommit is either null (everything is unreviewed, so all changes are streamed), equal to the latest commit of the source branch (everything is reviewed), or no longer on the source branch (the source branch has been rebased). In these cases, the application will fall back to streaming all changes (the default), which is the effective diff for the pull request. The type of changes streamed can be determined by the changeScope parameter included in the properties map of the response.

Note: This resource is currently <i>not paged</i>. The server will return at most one page. The server will truncate the number of changes to either the request's page limit or an internal maximum, whichever is smaller. The start parameter of the page request is also ignored.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param sinceId The since commit hash to stream changes for a RANGE arbitrary change scope (optional)
   * @param changeScope UNREVIEWED to stream the unreviewed changes for the current user (if they exist); RANGE to stream changes between two arbitrary commits (requires 'sinceId' and 'untilId'); otherwise ALL to stream all changes (the default) (optional)
   * @param untilId The until commit hash to stream changes for a RANGE arbitrary change scope (optional)
   * @param pullRequestId The pull request ID. (not null)
   * @param withComments true to apply comment counts in the changes (the default); otherwise, false to stream changes without comment counts (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return RestChange
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/changes")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of unreviewed Changes for the current user from the supplied pull request, including the unreviewedCommits in the properties map.",
                 content = @Content(schema = @Schema(implementation = RestChange.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdChanges_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdChanges_404.class)))
  })
  @Operation(summary = "Gets pull request changes")
  RestChange streamChanges_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("sinceId") String sinceId, @QueryParam("changeScope") String changeScope, @QueryParam("untilId") String untilId, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("withComments") String withComments, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get pull request comments for path.
   * Gets comments for the specified pull request and path.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param path The path to stream comments for a given path (not null)
   * @param projectKey The project key. (not null)
   * @param fromHash The from commit hash to stream comments for a RANGE or COMMIT arbitrary change scope (optional)
   * @param anchorState ACTIVE to stream the active comments; ORPHANED to stream the orphaned comments; ALL to stream both the active and the orphaned comments; (optional)
   * @param diffType  (optional)
   * @param toHash The to commit hash to stream comments for a RANGE or COMMIT arbitrary change scope (optional)
   * @param state  (optional)
   * @param pullRequestId The pull request ID. (not null)
   * @param diffTypes EFFECTIVE to stream the comments related to the effective diff of the pull request; RANGE to stream comments related to a commit range between two arbitrary commits (requires 'fromHash' and 'toHash'); COMMIT to stream comments related to a commit between two arbitrary commits (requires 'fromHash' and 'toHash') (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param states (optional). If supplied, only comments with a state in the given list will be returned. The state can be OPEN or RESOLVED. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of Comments from the supplied pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_404.class)))
  })
  @Operation(summary = "Get pull request comments for path")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments getComments_2(@QueryParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("fromHash") String fromHash, @QueryParam("anchorState") String anchorState, @QueryParam("diffType") List<String> diffType, @QueryParam("toHash") String toHash, @QueryParam("state") List<String> state, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("diffTypes") String diffTypes, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("states") String states, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Add pull request comment.
   * Add a new comment.

Comments can be added in a few places by setting different attributes: </p>General pull request comment:
 <pre> {
   "text": "An insightful general comment on a pull request."
 }
 </pre> Reply to a comment:  <pre> {
   "text": "A measured reply.",
   "parent": {
      "id": 1
    }
 }
 </pre> General file comment:  <pre> {
   "text": "An insightful general comment on a file.",
   "anchor": {
      "diffType": "RANGE",
      "fromHash": "6df3858eeb9a53a911cd17e66a9174d44ffb02cd",
      "path": "path/to/file",
      "srcPath": "path/to/file",
      "toHash": "04c7c5c931b9418ca7b66f51fe934d0bd9b2ba4b"
   }
 }
 </pre> File line comment:  <pre> {
   "text": "A pithy comment on a particular line within a file.",
   "anchor": {
      "diffType": "COMMIT",
      "line": 1,
      "lineType": "CONTEXT",
      "fileType": "FROM",
      "fromHash": "6df3858eeb9a53a911cd17e66a9174d44ffb02cd",
      "path": "path/to/file",
      "srcPath": "path/to/file",
      "toHash": "04c7c5c931b9418ca7b66f51fe934d0bd9b2ba4b"
    }
 }
 </pre>

 Add a new task.

Tasks are just comments with the attribute 'severity' set to 'BLOCKER':

General pull request task:  <pre> {
   "text": "A task on a pull request.",
   "severity": "BLOCKER"
 }
 </pre>

 Add a pending comment.

Pending comments are just comments with the attribute 'state' set to 'PENDING':

Pending comment: <pre> {
   "text": "This is a pending comment",
   "state": "PENDING"
 }
 </pre>

For file and line comments, 'path' refers to the path of the file to which the comment should be applied and 'srcPath' refers to the path the that file used to have (only required for copies and moves). Also, fromHash and toHash refer to the sinceId / untilId (respectively) used to produce the diff on which the comment was added. Finally diffType refers to the type of diff the comment was added on. For backwards compatibility purposes if no diffType is provided and no fromHash/toHash pair is provided the diffType will be resolved to 'EFFECTIVE'. In any other cases the diffType is REQUIRED.

For line comments, 'line' refers to the line in the diff that the comment should apply to. 'lineType' refers to the type of diff hunk, which can be:

- 'ADDED' - for an added line;
- 'REMOVED' - for a removed line; or
- 'CONTEXT' - for a line that was unmodified but is in the vicinity of the diff.
</ul>'fileType' refers to the file of the diff to which the anchor should be attached - which is of relevance when displaying the diff in a side-by-side way. Currently the supported values are:

- 'FROM' - the source file of the diff
- 'TO' - the destination file of the diff
</ul>If the current user is not a participant the user is added as a watcher of the pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The comment to add (optional)
   * @return RestComment
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "400", description = "The comment was not created due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request, create a comment or watch the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, pull request or parent comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_404.class))),
    @APIResponse(responseCode = "409", description = "Adding, deleting, or editing comments isn't supported on archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdComments_409.class)))
  })
  @Operation(summary = "Add pull request comment")
  RestComment createComment_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestComment dto);

  /**
   * Get a pull request comment.
   * Retrieves a pull request comment.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The ID of the comment to retrieve. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestComment
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, pull request or comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_404.class)))
  })
  @Operation(summary = "Get a pull request comment")
  RestComment getComment_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update pull request comment.
   * Update a comment, with the following restrictions:

- only the author of the comment may update the <i>text</i> of the comment
- only the author of the comment, the author of the pull request or repository admins and above may update the other fields of a comment
</ul>

Convert a comment to a task or vice versa.

Comments can be converted to tasks by setting the 'severity' attribute to 'BLOCKER':
 <pre> {
 "severity": "BLOCKER"
 }
 </pre>

Tasks can be converted to comments by setting the 'severity' attribute to 'NORMAL':  <pre> {
 "severity": "NORMAL"
 }
 </pre>

Resolve a task.

Tasks can be resolved by setting the 'state' attribute to 'RESOLVED':  <pre> {
 "state": "RESOLVED"
 }
 </pre>

<strong>Note:</strong> the supplied JSON object must contain a <code>version</code> that must match the server's version of the comment or the update will fail. To determine the current version of the comment, the comment should be fetched from the server prior to the update. Look for the 'version' attribute in the returned JSON structure.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The ID of the comment to retrieve. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The updated comment (optional)
   * @return RestComment
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly updated comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "400", description = "The comment was not updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request, update a comment or watch the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, pull request or comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_404.class))),
    @APIResponse(responseCode = "409", description = "The comment version supplied does not match the current version or the repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_409.class)))
  })
  @Operation(summary = "Update pull request comment")
  RestComment updateComment_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestComment dto);

  /**
   * Delete a pull request comment.
   * Delete a pull request comment. Anyone can delete their own comment. Only users with <strong>REPO_ADMIN</strong> and above may delete comments created by other users.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The ID of the comment to retrieve. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param version The expected version of the comment. This must match the server's version of the comment or the delete will fail. To determine the current version of the comment, the comment should be fetched from the server prior to the delete. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The operation was successful."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "The comment has replies, the version supplied does not match the current version or the repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentId_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a pull request comment")
  void deleteComment_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Apply pull request suggestion.
   * Apply a suggestion contained within a comment.
   *
   * @param projectKey The project key. (not null)
   * @param commentId The ID of the comment to retrieve. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto A request containing other parameters required to apply a suggestion - The given versions/hashes must match the server's version/hashes or the suggestion application will fail (in order to avoid applying the suggestion to the wrong place (optional)
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}/apply-suggestion")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating the suggestion has been applied."),
    @APIResponse(responseCode = "400", description = "The suggestion was not applied due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to apply the suggestion.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, pull request or parent comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "There was an error applying the suggestion to the source branch. It must be applied manually.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommentsCommentIdApplySuggestion_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Apply pull request suggestion")
  void applySuggestion(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestApplySuggestionRequest dto);

  /**
   * Get commit message suggestion.
   * Retrieve a suggested commit message for the given Pull Request.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request to generate the suggestion for (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestCommitMessageSuggestion
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/commit-message-suggestion")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The suggested commit message",
                 content = @Content(schema = @Schema(implementation = RestCommitMessageSuggestion.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommitMessageSuggestion_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommitMessageSuggestion_404.class)))
  })
  @Operation(summary = "Get commit message suggestion")
  RestCommitMessageSuggestion getCommitMessageSuggestion(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get pull request commits.
   * Retrieve commits for the specified pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param avatarScheme The desired scheme for the avatar URL. If the parameter is not present URLs will use the same scheme as this request (optional)
   * @param projectKey The project key. (not null)
   * @param withCounts If set to true, the service will add "authorCount" and "totalCount" at the end of the page. "authorCount" is the number of different authors and "totalCount" is the total number of commits. (optional)
   * @param pullRequestId ID of the pullrequest, part of the path (not null)
   * @param avatarSize If present the service adds avatar URLs for commit authors. Should be an integer specifying the desired size in pixels. If the parameter is not present, avatar URLs will not be setCOMMIT to stream comments related to a commit between two arbitrary commits (requires 'fromHash' and 'toHash') (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/commits")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of commits from the supplied pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits_404.class)))
  })
  @Operation(summary = "Get pull request commits")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdCommits getCommits_1(@QueryParam("avatarScheme") String avatarScheme, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("withCounts") String withCounts, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("avatarSize") String avatarSize, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Decline pull request.
   * Decline a pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pullrequest ID provided by the path (not null)
   * @param version The current version of the pull request. If the server's version isn't the same as the specified version the operation will fail. To determine the current version of the pull request it should be fetched from the server prior to this operation. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The body holder (optional)
   * @return RestPullRequest
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/decline")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The pull request was declined.",
                 content = @Content(schema = @Schema(implementation = RestPullRequest.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDecline_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDecline_404.class))),
    @APIResponse(responseCode = "409", description = "The pull request is not OPEN or has been updated since the version specified by the request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDecline_409.class)))
  })
  @Operation(summary = "Decline pull request")
  RestPullRequest decline(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequestDeclineRequest dto);

  /**
   * Stream a diff within a pull request.
   * Streams a diff within a pull request.

If the specified file has been copied, moved or renamed, the <code>srcPath</code> must also be specified to produce the correct diff.

To stream a raw text representation of the diff, this endpoint can be called with the request header 'Accept: text/plain'.

Note: This RESTful endpoint is currently <i>not paged</i>. The server will internally apply a hard cap to the streamed lines, and it is not possible to request subsequent pages if that cap is exceeded.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param avatarScheme The security scheme for avatar URLs. If the scheme is not present then it is inherited from the request. It can be set to "https" to force the use of secure URLs. Not applicable if streaming raw diff (optional)
   * @param path The path to the file which should be diffed (optional) (not null)
   * @param projectKey The project key. (not null)
   * @param contextLines The number of context lines to include around added/removed lines in the diff (optional)
   * @param sinceId The since commit hash to stream a diff between two arbitrary hashes (optional)
   * @param srcPath The previous path to the file, if the file has been copied, moved or renamed (optional)
   * @param diffType The type of diff being requested. When withComments is true this works as a hint to the system to attach the correct set of comments to the diff. Not applicable if streaming raw diff (optional)
   * @param untilId The until commit hash to stream a diff between two arbitrary hashes (optional)
   * @param pullRequestId The pull request ID. (not null)
   * @param whitespace Optional whitespace flag which can be set to <code>ignore-all</code> (optional)
   * @param withComments <code>true</code> to embed comments in the diff (the default); otherwise, <code>false</code> to stream the diff without comments. Not applicable if streaming raw diff (optional)
   * @param avatarSize If present the service adds avatar URLs for comment authors where the provided value specifies the desired avatar size in pixels. Not applicable if streaming raw diff (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/diff/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of differences from a pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath.class))),
    @APIResponse(responseCode = "400", description = "If the request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath_404.class)))
  })
  @Operation(summary = "Stream a diff within a pull request")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdDiffPath streamDiff_2(@QueryParam("avatarScheme") String avatarScheme, @PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("contextLines") String contextLines, @QueryParam("sinceId") String sinceId, @QueryParam("srcPath") String srcPath, @QueryParam("diffType") String diffType, @QueryParam("untilId") String untilId, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("whitespace") String whitespace, @QueryParam("withComments") String withComments, @QueryParam("avatarSize") String avatarSize, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Test if pull request can be merged.
   * Test whether a pull request can be merged.

A pull request may not be merged if:

- there are conflicts that need to be manually resolved before merging; and/or
- one or more merge checks have vetoed the merge.


The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestPullRequestMergeability
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/merge")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The mergeability status of the pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestMergeability.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_404.class))),
    @APIResponse(responseCode = "409", description = "The specified pull request is not open.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_409.class)))
  })
  @Operation(summary = "Test if pull request can be merged")
  RestPullRequestMergeability canMerge(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Merge pull request.
   * Merge the specified pull request immediately or set the pull request to auto-merge when all the merge checks pass by setting <strong>autoMerge</strong> field in the request body.

The authenticated user must have <strong>REPO_WRITE</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param version The current version of the pull request. If the server's version isn't the same as the specified version the operation will fail. To determine the current version of the pull request it should be fetched from the server prior to this operation. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The body holder (optional)
   * @return RestPullRequest
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/merge")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The merged pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequest.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to merge the specified pull request",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_401.class))),
    @APIResponse(responseCode = "403", description = "The auto-merge setting is not enabled for the repository that this pull request targets.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_403.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_404.class))),
    @APIResponse(responseCode = "409", description = "One of the following error cases occurred (check the error message for more details): \n\n- The pull request has conflicts.\n- A merge check vetoed the merge.\n- The specified version is out of date.\n- The specified pull request is not open.\n- The <em>to</em> repository is archived.\n",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMerge_409.class)))
  })
  @Operation(summary = "Merge pull request")
  RestPullRequest merge(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequestMergeRequest dto);

  /**
   * Get the common ancestor between the latest commits of the source and target branches of the pull request.
   * Returns the best common ancestor between the latest commits of the source and target branches of the pull request.

If more than one best common ancestor exists, only one will be returned. It is unspecified which will be returned.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestCommit
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/merge-base")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The common ancestor of the latest commits in the source and target branches of this pull request",
                 content = @Content(schema = @Schema(implementation = RestCommit.class))),
    @APIResponse(responseCode = "204", description = "No common parent between exist"),
    @APIResponse(responseCode = "404", description = "The project, repository, or pull request does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdMergeBase_404.class)))
  })
  @Operation(summary = "Get the common ancestor between the latest commits of the source and target branches of the pull request")
  RestCommit getMergeBase_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get pull request participants.
   * Retrieves a page of the participants for a given pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Details of the participants in this pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_404.class)))
  })
  @Operation(summary = "Get pull request participants")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants listParticipants(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Assign pull request participant role.
   * Assigns a participant to an explicit role in pull request. Currently only the REVIEWER role may be assigned.

If the user is not yet a participant in the pull request, they are made one and assigned the supplied role.

If the user is already a participant in the pull request, their previous role is replaced with the supplied role unless they are already assigned the AUTHOR role which cannot be changed and will result in a Bad Request (400) response code.

The authenticated user must have <strong>REPO_WRITE</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The participant to be added to the pull request, includes the user and their role (not null)
   * @return RestPullRequestParticipant
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Details of the participants in this pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestParticipant.class))),
    @APIResponse(responseCode = "400", description = "The request does not have the username and role, or is attempting an invalid assignment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_404.class))),
    @APIResponse(responseCode = "409", description = "Adding reviewers isn't supported on archived repositories",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipants_409.class)))
  })
  @Operation(summary = "Assign pull request participant role")
  RestPullRequestParticipant assignParticipantRole(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @NotNull @Valid RestPullRequestAssignParticipantRoleRequest dto);

  /**
   * Change pull request status.
   * Change the current user's status for a pull request. Implicitly adds the user as a participant if they are not already. If the current user is the author, this method will fail.

The possible values for {@code status} are <strong>UNAPPROVED</strong>, <strong>NEEDS_WORK</strong> (which is referred to as "Requested changes" in the frontend from 8.10 onward), or <strong>APPROVED</strong>.

If the new {@code status} is <strong>NEEDS_WORK</strong> or <strong>APPROVED</strong> then the {@code lastReviewedCommit} for the participant will be updated to the latest commit of the source branch of the pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param userSlug The slug for the user changing their status (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param version The current version of the pull request. If the server's version isn't the same as the specified version the operation will fail. To determine the current version of the pull request it should be fetched from the server prior to this operation. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The participant representing the status to set, includes the status of the participant (not null)
   * @return RestPullRequestParticipant
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants/{userSlug}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Details of the new participant.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestParticipant.class))),
    @APIResponse(responseCode = "400", description = "The specified status was invalid or the currently authenticated user is the author of the PR and cannot have its status updated.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_404.class))),
    @APIResponse(responseCode = "409", description = "The pull request is not open, or has been updated since the version specified by the request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_409.class)))
  })
  @Operation(summary = "Change pull request status")
  RestPullRequestParticipant updateStatus(@PathParam("projectKey") @NotNull String projectKey, @PathParam("userSlug") @NotNull String userSlug, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug, @NotNull @Valid RestPullRequestAssignStatusRequest dto);

  /**
   * Unassign pull request participant.
   * Unassigns a participant from the REVIEWER role they may have been given in a pull request.

If the participant has no explicit role this method has no effect.

Afterwards, the user will still remain a participant in the pull request but their role will be reduced to PARTICIPANT. This is because once made a participant of a pull request, a user will forever remain a participant. Only their role may be altered.

The authenticated user must have <strong>REPO_WRITE</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param userSlug The slug for the user being unassigned (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/participants/{userSlug}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The update completed."),
    @APIResponse(responseCode = "400", description = "The request does not have the username.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "Removing reviewers isn't supported on archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdParticipantsUserSlug_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Unassign pull request participant")
  void unassignParticipantRole(@PathParam("projectKey") @NotNull String projectKey, @PathParam("userSlug") @NotNull String userSlug, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Re-open pull request.
   * Re-open a declined pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository (not null)
   * @param version The current version of the pull request. If the server's version isn't the same as the specified version the operation will fail. To determine the current version of the pull request it should be fetched from the server prior to this operation. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The body holder (optional)
   * @return RestPullRequest
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/reopen")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The merged pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequest.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to reopen the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReopen_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReopen_404.class))),
    @APIResponse(responseCode = "409", description = "One of the following error cases occurred (check the error message for more details): \n\n- The pull request is not in a declined state.\n- The specified version is out of date.\n- The <em>to</em> repository is archived.\n",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReopen_409.class)))
  })
  @Operation(summary = "Re-open pull request")
  RestPullRequest reopen(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequestReopenRequest dto);

  /**
   * Get pull request comment thread.
   * Get the <code>CommentThread</code> threads which have <code>Comment</code> comments that have a <code>CommentState#PENDING</code> pending state and are part of the pull request review for the authenticated user.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/review")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of Comments from the supplied pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository or pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_404.class)))
  })
  @Operation(summary = "Get pull request comment thread")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview getReview(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Complete pull request review.
   * Complete a review on a pull request.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param version The current version of the pull request. If the server's version isn't the same as the specified version the operation will fail. To determine the current version of the pull request it should be fetched from the server prior to this operation. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The REST request which contains comment text and participant status (optional)
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/review")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Getting back the number of published comments and completing the review on a pull request."),
    @APIResponse(responseCode = "400", description = "The request is invalid when there is no request body provided, or the participant status in the request is invalid.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request, update a comment or watch the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_401.class))),
    @APIResponse(responseCode = "404", description = "There is no pull request review for the user to finish.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_404.class))),
    @APIResponse(responseCode = "409", description = "The pull request has been updated since the version specified by the request, or reviews cannot be made on pull requests in archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_409.class)))
  })
  @Operation(summary = "Complete pull request review")
  void finishReview(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequestFinishReviewRequest dto);

  /**
   * Discard pull request review.
   * Discard a pull request review for the authenticated user.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/review")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The pull request review has been discarded."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to discard the the pull request review",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified pull request or repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdReview_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Discard pull request review")
  void discardReview(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Watch pull request.
   * Add the authenticated user as a watcher for the specified pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/watch")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The user is now watching the pull request."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdWatch_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdWatch_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Watch pull request")
  void watch_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Stop watching pull request.
   * Remove the authenticated user as a watcher for the specified pull request.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The pull request ID. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/watch")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The user is no longer watching the pull request."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdWatch_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdWatch_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Stop watching pull request")
  void unwatch_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get all reviewer groups.
   * Retrieve a page of reviewer groups of a given scope.

The authenticated user must have <b>REPO_READ</b> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/reviewer-groups")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A `page` of reviewer group(s) of the provided scope and its inherited scope.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_401.class))),
    @APIResponse(responseCode = "404", description = "The repository scope supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_404.class)))
  })
  @Operation(summary = "Get all reviewer groups")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups getReviewerGroups_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create reviewer group.
   * Create a reviewer group.

The authenticated user must have <b>REPO_ADMIN</b> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The request containing the details of the reviewer group. (optional)
   * @return RestReviewerGroup
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/reviewer-groups")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created reviewer group.",
                 content = @Content(schema = @Schema(implementation = RestReviewerGroup.class))),
    @APIResponse(responseCode = "400", description = "The request is missing a reviewer group name.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_401.class))),
    @APIResponse(responseCode = "404", description = "The repository scope supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_404.class))),
    @APIResponse(responseCode = "409", description = "The new created name already exists.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroups_409.class)))
  })
  @Operation(summary = "Create reviewer group")
  RestReviewerGroup create_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestReviewerGroup dto);

  /**
   * Get reviewer group.
   * Retrieve a reviewer group.

The authenticated user must have <b>REPO_READ</b> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the reviewer group to be retrieved (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestReviewerGroup
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/reviewer-groups/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The reviewer group.",
                 content = @Content(schema = @Schema(implementation = RestReviewerGroup.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_401.class))),
    @APIResponse(responseCode = "404", description = "The ID supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_404.class)))
  })
  @Operation(summary = "Get reviewer group")
  RestReviewerGroup getReviewerGroup_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update reviewer group attributes.
   * Update the attributes of a reviewer group.

The authenticated user must have <b>REPO_ADMIN</b> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the reviewer group to be updated (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The request containing the attributes of the reviewer group to be updated. Only the attributes to be updated need to be present in this object. (optional)
   * @return RestReviewerGroup
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/reviewer-groups/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated reviewer group.",
                 content = @Content(schema = @Schema(implementation = RestReviewerGroup.class))),
    @APIResponse(responseCode = "400", description = "The updated attribute does not meet the requirements. E.g. the name exceeds 50 characters, setting name to blank.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_401.class))),
    @APIResponse(responseCode = "404", description = "The repository scope supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_404.class))),
    @APIResponse(responseCode = "409", description = "The new updated name already exists.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_409.class)))
  })
  @Operation(summary = "Update reviewer group attributes")
  RestReviewerGroup update_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestReviewerGroup dto);

  /**
   * Delete reviewer group.
   * Deletes a reviewer group.

The authenticated user must have <b>REPO_ADMIN</b> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the reviewer group to be deleted (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/reviewer-groups/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The operation was successful"),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the reviewer group in this repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied reviewer group ID.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsReviewerGroupsId_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete reviewer group")
  void delete_7(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get reviewer group users.
   * Retrieve a list of the users of a reviewer group.

This does not return all the users of the group, only the users who are licensed and have <b>REPO_READ</b> permission for the specified repository.

The authenticated user must have <b>REPO_READ</b> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the reviewer group to be retrieved (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return List<RestApplicationUser>
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/reviewer-groups/{id}/users")
  @Produces("application/json;charset=UTF-8")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The list of users of a reviewer group.",
                 content = @Content(schema = @Schema(implementation = RestApplicationUser.class, type = SchemaType.ARRAY))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = RestErrors.class))),
    @APIResponse(responseCode = "404", description = "The ID supplied does not exist.d",
                 content = @Content(schema = @Schema(implementation = RestErrors.class)))
  })
  @Operation(summary = "Get reviewer group users")
  List<RestApplicationUser> getUsers(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get all reviewer groups.
   * Retrieve a page of reviewer groups of a given scope.

The authenticated user must have <b>PROJECT_READ</b> permission for the specified project to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups
   */
  @GET
  @Path("api/latest/projects/{projectKey}/settings/reviewer-groups")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of reviewer group(s) of the provided scope.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the project.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_401.class))),
    @APIResponse(responseCode = "404", description = "The project scope supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_404.class)))
  })
  @Operation(summary = "Get all reviewer groups")
  _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups getReviewerGroups(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create reviewer group.
   * Create a reviewer group.

The authenticated user must have <b>PROJECT_ADMIN</b> permission for the specified project to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param dto The reviewer group to be create (optional)
   * @return RestReviewerGroup
   */
  @POST
  @Path("api/latest/projects/{projectKey}/settings/reviewer-groups")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created reviewer group.",
                 content = @Content(schema = @Schema(implementation = RestReviewerGroup.class))),
    @APIResponse(responseCode = "400", description = "The request is missing a reviewer group name.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the project.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_401.class))),
    @APIResponse(responseCode = "404", description = "The project scope supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_404.class))),
    @APIResponse(responseCode = "409", description = "The new created name already exists.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroups_409.class)))
  })
  @Operation(summary = "Create reviewer group")
  RestReviewerGroup create_1(@PathParam("projectKey") @NotNull String projectKey, @Valid RestReviewerGroup dto);

  /**
   * Get reviewer group.
   * Retrieve a reviewer group.

The authenticated user must have <b>PROJECT_READ</b> permission for the specified project to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the reviewer group to be retrieved (not null)
   * @return RestReviewerGroup
   */
  @GET
  @Path("api/latest/projects/{projectKey}/settings/reviewer-groups/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The reviewer group.",
                 content = @Content(schema = @Schema(implementation = RestReviewerGroup.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the project.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_401.class))),
    @APIResponse(responseCode = "404", description = "The ID supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_404.class)))
  })
  @Operation(summary = "Get reviewer group")
  RestReviewerGroup getReviewerGroup(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

  /**
   * Update reviewer group attributes.
   * Update the attributes of a reviewer group.

The authenticated user must have <b>PROJECT_READ</b> permission for the specified project to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the reviewer group to be updated (not null)
   * @param dto The request containing the attributes of the reviewer group to be updated. Only the attributes to be updated need to be present in this object. (optional)
   * @return RestReviewerGroup
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/settings/reviewer-groups/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of changes.",
                 content = @Content(schema = @Schema(implementation = RestReviewerGroup.class))),
    @APIResponse(responseCode = "400", description = "The updated attribute does not meet the requirements. E.g. the name exceeds 50 characters, setting name to blank.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the project.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_401.class))),
    @APIResponse(responseCode = "404", description = "The project scope supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_404.class))),
    @APIResponse(responseCode = "409", description = "The new updated name already exists.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_409.class)))
  })
  @Operation(summary = "Update reviewer group attributes")
  RestReviewerGroup update_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @Valid RestReviewerGroup dto);

  /**
   * Delete reviewer group.
   * Deletes a reviewer group.

The authenticated user must have <b>PROJECT_ADMIN</b> permission for the specified project to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the reviewer group to be deleted (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/settings/reviewer-groups/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The operation was successful."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the reviewer group in this project.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied reviewer group ID.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsReviewerGroupsId_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete reviewer group")
  void delete_6(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

  /**
   * React to a PR comment.
   * Add an emoticon reaction to a pull request comment
   *
   * @param projectKey The project key. (not null)
   * @param commentId The comment id. (not null)
   * @param pullRequestId The pull request id. (not null)
   * @param emoticon The emoticon to add (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestUserReaction
   */
  @PUT
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}/reactions/{emoticon}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(RestUserReaction.class)
  @Operation(summary = "React to a PR comment")
  RestUserReaction react_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("emoticon") @NotNull String emoticon, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Remove a reaction from a PR comment.
   * Remove an emoticon reaction from a pull request comment
   *
   * @param projectKey The project key. (not null)
   * @param commentId The comment id. (not null)
   * @param pullRequestId The pull request id. (not null)
   * @param emoticon The emoticon to remove (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/comments/{commentId}/reactions/{emoticon}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The added reaction")
  })
  @Operation(summary = "Remove a reaction from a PR comment")
  void unReact_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("emoticon") @NotNull String emoticon, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Create default reviewer.
   * Create a default reviewer pull request condition for the given project.
   *
   * @param projectKey The project key. (not null)
   * @param dto The details needed to create a default reviewer pull request condition. (optional)
   * @return RestPullRequestCondition
   */
  @POST
  @Path("default-reviewers/latest/projects/{projectKey}/condition")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The default reviewer pull request condition that was created.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestCondition.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseDefaultReviewersLatestProjectsProjectKeyCondition_400.class)))
  })
  @Operation(summary = "Create default reviewer")
  RestPullRequestCondition createPullRequestCondition(@PathParam("projectKey") @NotNull String projectKey, @Valid RestDefaultReviewersRequest dto);

  /**
   * Update the default reviewer.
   * Update the default reviewer pull request condition for the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the pull request condition. (not null)
   * @param dto The new details for the default reviewer pull request condition. (optional)
   * @return RestPullRequestCondition
   */
  @PUT
  @Path("default-reviewers/latest/projects/{projectKey}/condition/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated default reviewer pull request condition.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestCondition.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed",
                 content = @Content(schema = @Schema(implementation = _ResponseDefaultReviewersLatestProjectsProjectKeyConditionId_400.class)))
  })
  @Operation(summary = "Update the default reviewer")
  RestPullRequestCondition updatePullRequestCondition(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @Valid RestDefaultReviewersRequest dto);

  /**
   * Remove default reviewer.
   * Delete the default reviewer pull request condition associated with the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the pull request condition. (not null)
   */
  @DELETE
  @Path("default-reviewers/latest/projects/{projectKey}/condition/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the pull request condition was deleted."),
    @APIResponse(responseCode = "404", description = "An empty response indicating a pull request condition with the given ID could not be found.",
                 content = @Content(schema = @Schema(implementation = _ResponseDefaultReviewersLatestProjectsProjectKeyConditionId_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Remove default reviewer")
  void deletePullRequestCondition(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

  /**
   * Get default reviewers.
   * Return a page of default reviewer pull request conditions that have been configured for this project.
   *
   * @param projectKey The project key. (not null)
   * @return List<RestPullRequestCondition>
   */
  @GET
  @Path("default-reviewers/latest/projects/{projectKey}/conditions")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The default reviewer pull request conditions associated with the given project.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestCondition.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get default reviewers")
  List<RestPullRequestCondition> getPullRequestConditions(@PathParam("projectKey") @NotNull String projectKey);

  /**
   * Create default reviewers condition.
   * Create a default reviewer pull request condition for the given repository.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The details needed to create a default reviewer pull request condition. (optional)
   * @return RestPullRequestCondition
   */
  @POST
  @Path("default-reviewers/latest/projects/{projectKey}/repos/{repositorySlug}/condition")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The default reviewer pull request condition that was created.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestCondition.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugCondition_400.class)))
  })
  @Operation(summary = "Create default reviewers condition")
  RestPullRequestCondition createPullRequestCondition_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestDefaultReviewersRequest dto);

  /**
   * Update a default reviewer condition.
   * Update the default reviewer pull request condition for the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param id The ID of the pull request condition (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto  (optional)
   * @return RestPullRequestCondition
   */
  @PUT
  @Path("default-reviewers/latest/projects/{projectKey}/repos/{repositorySlug}/condition/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated default reviewer pull request condition.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestCondition.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId_400.class)))
  })
  @Operation(summary = "Update a default reviewer condition")
  RestPullRequestCondition updatePullRequestCondition_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId dto);

  /**
   * Delete a default reviewer condition.
   * Delete the default reviewer pull request condition associated with the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param id
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("default-reviewers/latest/projects/{projectKey}/repos/{repositorySlug}/condition/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the pull request condition was deleted"),
    @APIResponse(responseCode = "404", description = "An empty response indicating a pull request condition with the given ID could not be found.",
                 content = @Content(schema = @Schema(implementation = _ResponseDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a default reviewer condition")
  void deletePullRequestCondition_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") int id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get configured default reviewers.
   * Return a page of default reviewer pull request conditions that have been configured for this repository.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return List<RestPullRequestCondition>
   */
  @GET
  @Path("default-reviewers/latest/projects/{projectKey}/repos/{repositorySlug}/conditions")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The default reviewer pull request conditions associated with the given repository.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestCondition.class, type = SchemaType.ARRAY)))
  })
  @Operation(summary = "Get configured default reviewers")
  List<RestPullRequestCondition> getPullRequestConditions_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get required reviewers for PR creation.
   * Return a set of users who are required reviewers for pull requests created from the given source repository and ref to the given target ref in this repository.
   *
   * @param targetRepoId The ID of the repository in which the target ref exists (optional)
   * @param projectKey The project key. (not null)
   * @param sourceRepoId The ID of the repository in which the source ref exists (optional)
   * @param sourceRefId The ID of the source ref (optional)
   * @param targetRefId The ID of the target ref (optional)
   * @param repositorySlug The repository slug. (not null)
   * @return List<RestPullRequestCondition>
   */
  @GET
  @Path("default-reviewers/latest/projects/{projectKey}/repos/{repositorySlug}/reviewers")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The default reviewer pull request conditions associated with the given repository.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestCondition.class, type = SchemaType.ARRAY))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = RestErrors.class)))
  })
  @Operation(summary = "Get required reviewers for PR creation")
  List<RestPullRequestCondition> getReviewers(@QueryParam("targetRepoId") String targetRepoId, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("sourceRepoId") String sourceRepoId, @QueryParam("sourceRefId") String sourceRefId, @QueryParam("targetRefId") String targetRefId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Check PR rebase precondition.
   * Checks preconditions to determine whether the pull request can be rebased.

Some of the preconditions are:

- The pull request is between Git repositories
- The pull request is currently open
- The pull request's {@link PullRequest#getFromRef "from" ref} is a <i>branch</i>
   - In other words, the qualified ID for the "from" ref must start with <code>refs/heads/</code>
   - Tags, and other non-standard refs, cannot be rebased
- The current user has an e-mail address
   - Pull requests cannot be rebased anonymously
   - `git rebase` records the current user as the committer for the rebased commits, which        requires a name and e-mail address
- The current user has <i>write</i> access to the {@link PullRequest#getFromRef "from" ref}'s repository
   - Note that in order to <i>view</i> a pull request a user is only required to have <i>read</i>      access to the {@link PullRequest#getToRef toRef}'s repository, so just because a user can <i>see</i>      a pull request does not mean they can request a rebase


This list is not exhaustive, and the exact set of preconditions applied can be extended by third-party add-ons.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestPullRequestRebaseability
   */
  @GET
  @Path("git/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/rebase")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The rebaseability status of the pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestRebaseability.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_404.class)))
  })
  @Operation(summary = "Check PR rebase precondition")
  RestPullRequestRebaseability canRebase(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Rebase pull request.
   * Rebases the specified pull request, rewriting the incoming commits to start from the tip commit of the pull request's target branch. <i>This operation alters the pull request's source branch and cannot be undone.</i>

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that this pull request targets <i>and</i> <strong>REPO_WRITE</strong> permission for the pull request's source repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param pullRequestId The ID of the pull request within the repository. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The pull request rebase request. (optional)
   * @return RestPullRequestRebaseResult
   */
  @POST
  @Path("git/latest/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/rebase")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The merged pull request.",
                 content = @Content(schema = @Schema(implementation = RestPullRequestRebaseResult.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request and/or to update its source branch.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or pull request does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_404.class))),
    @APIResponse(responseCode = "409", description = "Any of the following error cases occurred (check the error message for more details):\n\n- The rebase encountered conflicts.\n- The rebase discarded all of the incoming commits and would have left the pull request empty\n- A <tt>PreRepositoryHook</tt> vetoed the rebase.\n- The specified version is out of date.\n- The specified pull request is not open.\n- The target repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugPullRequestsPullRequestIdRebase_409.class)))
  })
  @Operation(summary = "Rebase pull request")
  RestPullRequestRebaseResult rebase(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestPullRequestRebaseRequest dto);
}
