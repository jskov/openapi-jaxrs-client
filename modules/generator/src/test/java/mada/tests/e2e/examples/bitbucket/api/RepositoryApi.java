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
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;
import mada.tests.e2e.examples.bitbucket.dto.ExampleFiles;
import mada.tests.e2e.examples.bitbucket.dto.ExampleMultipartFormData;
import mada.tests.e2e.examples.bitbucket.dto.ExampleSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestAttachmentMetadata;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoDeclineSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoDeclineSettingsRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeRestrictedSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeSettingsRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestBranch;
import mada.tests.e2e.examples.bitbucket.dto.RestBranchCreateRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestBranchDeleteRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestComment;
import mada.tests.e2e.examples.bitbucket.dto.RestCommit;
import mada.tests.e2e.examples.bitbucket.dto.RestCreateBranchRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestCreateTagRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestDetailedInvocation;
import mada.tests.e2e.examples.bitbucket.dto.RestDiff;
import mada.tests.e2e.examples.bitbucket.dto.RestGitTagCreateRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestHookScriptConfig;
import mada.tests.e2e.examples.bitbucket.dto.RestHookScriptTriggers;
import mada.tests.e2e.examples.bitbucket.dto.RestInvocationHistory;
import mada.tests.e2e.examples.bitbucket.dto.RestLabel;
import mada.tests.e2e.examples.bitbucket.dto.RestRefRestriction;
import mada.tests.e2e.examples.bitbucket.dto.RestRefSyncRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestRefSyncStatus;
import mada.tests.e2e.examples.bitbucket.dto.RestRejectedRef;
import mada.tests.e2e.examples.bitbucket.dto.RestRepository;
import mada.tests.e2e.examples.bitbucket.dto.RestRepositoryHook;
import mada.tests.e2e.examples.bitbucket.dto.RestRepositoryPullRequestSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestRestrictionRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestTag;
import mada.tests.e2e.examples.bitbucket.dto.RestUserReaction;
import mada.tests.e2e.examples.bitbucket.dto.RestWebhook;
import mada.tests.e2e.examples.bitbucket.dto.RestWebhookCredentials;
import mada.tests.e2e.examples.bitbucket.dto.RestWebhookRequestResponse;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProfileRecentRepos;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProfileRecentRepos_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProfileRecentRepos_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugArchive_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugArchive_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugArchive_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowse_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowse_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowse_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDiffPath_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDiffPath_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDiffPath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdMergeBase_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdMergeBase_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdWatch_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdWatch_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareChanges;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareChanges_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareCommits;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareCommits_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareDiffPath;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareDiffPath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiffPath_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiffPath_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiffPath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiff_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiff_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiff_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabelsLabelName_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabelsLabelName_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModifiedPath_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModifiedPath_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModifiedPath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModified_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModified_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModified_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPatch_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPatch_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPatch_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRawPath_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRawPath_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRawPath_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeyEnabled_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeyEnabled_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugTagsName_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugTagsName_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWatch_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWatch_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksSearch_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksSearch_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksTest_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksTest_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdLatest_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdLatest_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatisticsSummary_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatisticsSummary_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatistics_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatistics_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestRepos;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestRepos_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranchesInfoCommitId;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranchesInfoCommitId_500;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugTagsName_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugTagsName_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugTagsName_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugTags_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseGitLatestProjectsProjectKeyReposRepositorySlugTags_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_501;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_404;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface RepositoryApi {

  /**
   * Get recently accessed repositories.
   * Retrieve a page of recently accessed repositories for the currently authenticated user.

Repositories are ordered from most recently to least recently accessed. <p>Only authenticated users may call this resource.
   *
   * @param permission (optional) If specified, it must be a valid repository permission level name and will limit the resulting repository list to ones that the requesting user has the specified permission level to. If not specified, the default <code>REPO_READ</code> permission level will be assumed. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProfileRecentRepos
   */
  @GET
  @Path("api/latest/profile/recent/repos")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of recently accessed repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProfileRecentRepos.class))),
    @APIResponse(responseCode = "400", description = "The permission level is unknown or not related to repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProfileRecentRepos_400.class))),
    @APIResponse(responseCode = "401", description = "The request is unauthenticated.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProfileRecentRepos_401.class)))
  })
  @Operation(summary = "Get recently accessed repositories")
  _ResponseApiLatestProfileRecentRepos getRepositoriesRecentlyAccessed(@QueryParam("permission") String permission, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Stream archive of repository.
   * Streams an archive of the repository's contents at the requested commit. If no `at=` commit is requested, an archive of the default branch is streamed.

The <code>filename=</code> query parameter may be used to specify the exact filename to include in the "Content-Disposition" header. If an explicit filename is not provided, one will be automatically generated based on what is being archived. Its format depends on the at= value:

- No <code>at=</code> commit:     &lt;slug&gt;-&lt;default-branch-name&gt;@&lt;commit&gt;.&lt;format&gt;;     e.g. example-master@43c2f8a0fe8.zip
- <code>at=</code>sha: &lt;slug&gt;-&lt;at&gt;.&lt;format&gt;; e.g.     example-09bcbb00100cfbb5310fb6834a1d5ce6cac253e9.tar.gz
- <code>at=</code>branchOrTag: &lt;slug&gt;-&lt;branchOrTag&gt;@&lt;commit&gt;.&lt;format&gt;;     e.g. example-feature@bbb225f16e1.tar

    - If the branch or tag is qualified (e.g. refs/heads/master, the short name         (master) will be included in the filename
    - If the branch or tag's <i>short name</i> includes slashes (e.g. release/4.6),         they will be converted to hyphens in the filename (release-4.5)




Archives may be requested in the following formats by adding the <code>format=</code> query parameter:

- zip: A zip file using standard compression (Default)
- tar: An uncompressed tarball
- tar.gz or tgz: A GZip-compressed tarball


The contents of the archive may be filtered by using the <code>path=</code> query parameter to specify paths to include. <code>path=</code> may be specified multiple times to include multiple paths.

The <code>prefix=</code> query parameter may be used to define a directory (or multiple directories) where the archive's contents should be placed. If the prefix does not end with /, one will be added automatically. The prefix is <i>always</i> treated as a directory; it is not possible to use it to prepend characters to the entries in the archive.

Archives of public repositories may be streamed by any authenticated or anonymous user. Streaming archives for non-public repositories requires an <i>authenticated user</i> with at least <b>REPO_READ</b> permission.
   *
   * @param path Paths to include in the streamed archive; may be repeated to include multiple paths (optional)
   * @param projectKey The project key. (not null)
   * @param filename A filename to include the "Content-Disposition" header (optional)
   * @param at The commit to stream an archive of; if not supplied, an archive of the default branch is streamed (optional)
   * @param prefix A prefix to apply to all entries in the streamed archive; if the supplied prefix does not end with a trailing /, one will be added automatically (optional)
   * @param format The format to stream the archive in; must be one of: zip, tar, tar.gz or tgz (optional)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/archive")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "An archive or the requested commit, in zip, tar or gzipped-tar format."),
    @APIResponse(responseCode = "400", description = "The requested format is not supported.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugArchive_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugArchive_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist or does not contain the at commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugArchive_404.class)))
  })
  @Operation(summary = "Stream archive of repository")
  void getArchive(@QueryParam("path") String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("filename") String filename, @QueryParam("at") String at, @QueryParam("prefix") String prefix, @QueryParam("format") String format, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get an attachment.
   * Retrieve the attachment.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository that is associated to the attachment.

Range requests (see IETF RFC7233) are supported. However only a single range issupported. If multiple ranges are passed the ranges will be ignored and the entire content will be returned in the response.
   *
   * @param projectKey The project key (not null)
   * @param userAgent  (optional)
   * @param attachmentId the attachment ID (not null)
   * @param range  (optional)
   * @param repositorySlug The repository slug (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/attachments/{attachmentId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "the attachment"),
    @APIResponse(responseCode = "206", description = "the requested range of bytes from the attachment"),
    @APIResponse(responseCode = "401", description = "the user is currently not authenticated",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentId_401.class))),
    @APIResponse(responseCode = "404", description = "The attachment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentId_404.class)))
  })
  @Operation(summary = "Get an attachment")
  void getAttachment(@PathParam("projectKey") @NotNull String projectKey, @HeaderParam("User-Agent") String userAgent, @PathParam("attachmentId") @NotNull String attachmentId, @HeaderParam("Range") String range, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Delete an attachment.
   * Delete an attachment.

The user must be authenticated and have <strong>REPO_ADMIN</strong> permission for the specified repository.
   *
   * @param projectKey The project key (not null)
   * @param attachmentId the attachment ID (not null)
   * @param repositorySlug The repository slug (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/attachments/{attachmentId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = ""),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the attachment",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The attachment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentId_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete an attachment")
  void deleteAttachment(@PathParam("projectKey") @NotNull String projectKey, @PathParam("attachmentId") @NotNull String attachmentId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get attachment metadata.
   * Retrieve the attachment metadata.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository that is associated to the attachment that has the attachment metadata.
   *
   * @param projectKey The project key (not null)
   * @param attachmentId the attachment ID (not null)
   * @param repositorySlug The repository slug (not null)
   * @return RestAttachmentMetadata
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/attachments/{attachmentId}/metadata")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The attachment metadata",
                 content = @Content(schema = @Schema(implementation = RestAttachmentMetadata.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the attachment metadata",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_401.class))),
    @APIResponse(responseCode = "404", description = "The attachment or the attachment metadata does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_404.class)))
  })
  @Operation(summary = "Get attachment metadata")
  RestAttachmentMetadata getAttachmentMetadata(@PathParam("projectKey") @NotNull String projectKey, @PathParam("attachmentId") @NotNull String attachmentId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Save attachment metadata.
   * Save attachment metadata.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository that is associated to the attachment that has the attachment metadata.
   *
   * @param projectKey The project key (not null)
   * @param attachmentId the attachment ID (not null)
   * @param repositorySlug The repository slug (not null)
   * @param dto The attachment metadata can be any valid JSON content (optional)
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/attachments/{attachmentId}/metadata")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The attachment metadata"),
    @APIResponse(responseCode = "400", description = "The supplied content is not valid JSON",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to save theattachment metadata",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or the attachment does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_404.class)))
  })
  @Operation(summary = "Save attachment metadata")
  void saveAttachmentMetadata(@PathParam("projectKey") @NotNull String projectKey, @PathParam("attachmentId") @NotNull String attachmentId, @PathParam("repositorySlug") @NotNull String repositorySlug, String dto);

  /**
   * Delete attachment metadata.
   * Delete attachment metadata.

The user must be authenticated and have <strong>REPO_ADMIN</strong> permission for the specified repository.
   *
   * @param projectKey The project key (not null)
   * @param attachmentId the attachment ID (not null)
   * @param repositorySlug The repository slug (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/attachments/{attachmentId}/metadata")
  @APIResponses({
    @APIResponse(responseCode = "204", description = ""),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete theattachment metadata",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The attachment or the attachment metadata does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugAttachmentsAttachmentIdMetadata_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete attachment metadata")
  void deleteAttachmentMetadata(@PathParam("projectKey") @NotNull String projectKey, @PathParam("attachmentId") @NotNull String attachmentId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Find branches.
   * Retrieve the branches matching the supplied <strong>filterText</strong> param.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param boostMatches Controls whether exact and prefix matches will be boosted to the top (optional)
   * @param projectKey The project key. (not null)
   * @param orderBy Ordering of refs either ALPHABETICAL (by name) or MODIFICATION (last updated) (optional)
   * @param details Whether to retrieve plugin-provided metadata about each branch (optional)
   * @param filterText The text to match on (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param base Base branch or tag to compare each branch to (for the metadata providers that uses that information (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/branches")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The branches matching the supplied <strong>filterText</strong>.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to read the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches_404.class)))
  })
  @Operation(summary = "Find branches")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches getBranches(@QueryParam("boostMatches") boolean boostMatches, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("orderBy") String orderBy, @QueryParam("details") boolean details, @QueryParam("filterText") String filterText, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("base") String base, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create branch.
   * Creates a branch using the information provided in the RestCreateBranchRequest request

The authenticated user must have <strong>REPO_WRITE</strong> permission for the context repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The request to create a branch containing a <strong>name</strong>, <strong>startPoint</strong>, and optionally a <strong>message</strong> (optional)
   * @return RestBranch
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/branches")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created branch.",
                 content = @Content(schema = @Schema(implementation = RestBranch.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to write to the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBranches_404.class)))
  })
  @Operation(summary = "Create branch")
  RestBranch createBranchForRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestCreateBranchRequest dto);

  /**
   * Get file content at revision.
   * Retrieve a page of content for a file path at a specified revision.

Responses from this endpoint vary widely depending on the query parameters. The example JSON is for a request that does not use size, type, blame or noContent.

1. size will return a response like {"size":10000}
2. type will return a response like {"type":"FILE"}, where possible values are    "DIRECTORY", "FILE" and "SUBMODULE"
3. blame <i>without</i> noContent will include blame for the lines of    content returned on the page
4. blame <i>with</i> noContent will omit file contents and only return    blame for the requested lines
5. noContent without blame is ignored and does nothing


The various parameters are "processed" in the above order. That means ?size=true&amp;type=truewill return a size response, not a type one; the type parameter will be ignored.

The blame and noContent query parameters are handled differently from size and type. For blame and noContent, the <i>presence</i> of the parameter implies "true" if no value is specified; size and and type both require an explicit=true or they're treated as "false".

- ?blame is the same as ?blame=true
- ?blame&amp;noContent is the same as ?blame=true&amp;noContent=true
- ?size is the same as ?size=false
- ?type is the same as ?type=false


The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param noContent If blame&amp;noContent only the blame is retrieved instead of the contents (optional)
   * @param projectKey The project key. (not null)
   * @param at The commit ID or ref to retrieve the content for (optional)
   * @param size If true only the size will be returned for the file path instead of the contents (optional)
   * @param blame If present and not equal to 'false', the blame will be returned for the file as well (optional)
   * @param type If true only the type will be returned for the file path instead of the contents (optional)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/browse")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of contents from a file."),
    @APIResponse(responseCode = "400", description = "The path parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowse_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowse_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowse_404.class)))
  })
  @Operation(summary = "Get file content at revision")
  void getContent(@QueryParam("noContent") String noContent, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @QueryParam("size") String size, @QueryParam("blame") String blame, @QueryParam("type") String type, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get file content.
   * Retrieve a page of content for a file path at a specified revision.

Responses from this endpoint vary widely depending on the query parameters. The example JSON is for a request that does not use size, type, blame or noContent.

1. size will return a response like {"size":10000}
2. type will return a response like {"type":"FILE"}, where possible values are    "DIRECTORY", "FILE" and "SUBMODULE"
3. blame <i>without</i> noContent will include blame for the lines of    content returned on the page
4. blame <i>with</i> noContent will omit file contents and only return    blame for the requested lines
5. noContent without blame is ignored and does nothing


The various parameters are "processed" in the above order. That means ?size=true&amp;type=truewill return a size response, not a type one; the type parameter will be ignored.

The blame and noContent query parameters are handled differently from size and type. For blame and noContent, the <i>presence</i> of the parameter implies "true" if no value is specified; size and and type both require an explicit=true or they're treated as "false".

- ?blame is the same as ?blame=true
- ?blame&amp;noContent is the same as ?blame=true&amp;noContent=true
- ?size is the same as ?size=false
- ?type is the same as ?type=false


The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param noContent If blame&amp;noContent only the blame is retrieved instead of the contents (optional)
   * @param path The file path to retrieve content from (not null)
   * @param projectKey The project key. (not null)
   * @param at The commit ID or ref to retrieve the content for (optional)
   * @param size If true only the size will be returned for the file path instead of the contents (optional)
   * @param blame If present and not equal to 'false', the blame will be returned for the file as well (optional)
   * @param type If true only the type will be returned for the file path instead of the contents (optional)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/browse/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of contents from a file."),
    @APIResponse(responseCode = "400", description = "The path or until parameters were not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_404.class)))
  })
  @Operation(summary = "Get file content")
  void getContent_1(@QueryParam("noContent") String noContent, @PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @QueryParam("size") String size, @QueryParam("blame") String blame, @QueryParam("type") String type, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Edit file.
   * Update the content of path, on the given repository and branch.

This resource accepts PUT multipart form data, containing the file in a form-field named content.

An example <a href="http://curl.haxx.se/">curl</a> request to update 'README.md' would be:

```curl -X PUT -u username:password -F content=@README.md  -F 'message=Updated using file-edit REST API' -F branch=master -F  sourceCommitId=5636641a50b  http://example.com/rest/api/latest/projects/PROJECT_1/repos/repo_1/browse/README.md ```

- branch:  the branch on which the path should be modified or created
- content: the full content of the file at path
- message: the message associated with this change, to be used as the commit message. Or null if the default message should be used.
- sourceCommitId: the commit ID of the file before it was edited, used to identify if content has changed. Or null if this is a new file


The file can be updated or created on a new branch. In this case, the sourceBranch parameter should be provided to identify the starting point for the new branch and the branch parameter identifies the branch to create the new commit on.
   *
   * @param path The path of the file that is to be modified or created (not null)
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The multipart form data containing the file (optional)
   * @return RestCommit
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/browse/{path}")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly created commit.",
                 content = @Content(schema = @Schema(implementation = RestCommit.class))),
    @APIResponse(responseCode = "400", description = "There are validation errors, e.g. The branch or content parameters were not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user does not have write permission for the given repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_401.class))),
    @APIResponse(responseCode = "403", description = "The request was authenticated using a project or repository access token, which does not have a valid user associated with it",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_403.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_404.class))),
    @APIResponse(responseCode = "409", description = "The file already exists when trying to create a file, or the given content does not modify the file, or the file has changed since the given sourceCommitId, or the repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugBrowsePath_409.class)))
  })
  @Operation(summary = "Edit file")
  RestCommit editFile(@PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid ExampleMultipartFormData dto);

  /**
   * Get changes made in commit.
   * Retrieve a page of changes made in a specified commit.

<strong>Note:</strong> The implementation will apply a hard cap ({@code page.max.changes}) and it is not possible to request subsequent content when that cap is exceeded.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param until The commit to retrieve changes for (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param since The commit to which <code>until</code> should be compared to produce a page of changes. If not specified the commit's first parent is assumed (if one exists) (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/changes")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of changes",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges.class))),
    @APIResponse(responseCode = "400", description = "The until parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or the since or until parameters supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges_404.class)))
  })
  @Operation(summary = "Get changes made in commit")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugChanges getChanges_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("until") String until, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get commits.
   * Retrieve a page of commits from a given starting commit or "between" two commits. If no explicit commit is specified, the tip of the repository's default branch is assumed. commits may be identified by branch or tag name or by ID. A path may be supplied to restrict the returned commits to only those which affect that path.

The authenticated user must have <b>REPO_READ</b> permission for the specified repository to call this resource.
   *
   * @param avatarScheme The desired scheme for the avatar URL. If the parameter is not present URLs will use the same scheme as this request (optional)
   * @param path An optional path to filter commits by (optional)
   * @param projectKey The project key (not null)
   * @param withCounts Optionally include the total number of commits and total number of unique authors (optional)
   * @param followRenames If <code>true</code>, the commit history of the specified file will be followed past renames. Only valid for a path to a single file. (optional)
   * @param until The commit ID (SHA1) or ref (inclusively) to retrieve commits before (optional)
   * @param avatarSize If present the service adds avatar URLs for commit authors. Should be an integer specifying the desired size in pixels. If the parameter is not present, avatar URLs will not be set (optional)
   * @param repositorySlug The repository slug (not null)
   * @param since The commit ID or ref (exclusively) to retrieve commits after (optional)
   * @param merges If present, controls how merge commits should be filtered. Can be either <code>exclude</code>, to exclude merge commits, <code>include</code>, to include both merge commits and non-merge commits or <code>only</code>, to only return merge commits. (optional)
   * @param ignoreMissing <code>true</code> to ignore missing commits, <code>false</code> otherwise (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of commits",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits.class))),
    @APIResponse(responseCode = "400", description = "One of the supplied commit IDs or refs was invalid.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits_404.class)))
  })
  @Operation(summary = "Get commits")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommits getCommits(@QueryParam("avatarScheme") String avatarScheme, @QueryParam("path") String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("withCounts") String withCounts, @QueryParam("followRenames") String followRenames, @QueryParam("until") String until, @QueryParam("avatarSize") String avatarSize, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since, @QueryParam("merges") String merges, @QueryParam("ignoreMissing") String ignoreMissing, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get commit by ID.
   * Retrieve a single commit <i>identified by its ID</i>. In general, that ID is a SHA1. <u>From 2.11, ref names like "refs/heads/master" are no longer accepted by this resource.</u>

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param path An optional path to filter the commit by. If supplied the details returned <i>may not</i> be for the specified commit. Instead, starting from the specified commit, they will be the details for the first commit affecting the specified path. (optional)
   * @param projectKey The project key (not null)
   * @param commitId The commit ID to retrieve (not null)
   * @param repositorySlug The repository slug (not null)
   * @return RestCommit
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A commit",
                 content = @Content(schema = @Schema(implementation = RestCommit.class))),
    @APIResponse(responseCode = "400", description = "The supplied commit ID was invalid",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitId_400.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitId_404.class)))
  })
  @Operation(summary = "Get commit by ID")
  RestCommit getCommit(@QueryParam("path") String path, @PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get changes in commit.
   * Retrieve a page of changes made in a specified commit.

 <strong>Note:</strong> The implementation will apply a hard cap (<code>page.max.changes</code>) and it is not possible to request subsequent content when that cap is exceeded.

 The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commitId The commit to retrieve changes for (not null)
   * @param withComments <code>true</code> to apply comment counts in the changes (the default); otherwise, <code>false</code> to stream changes without comment counts (optional)
   * @param repositorySlug The repository slug (not null)
   * @param since The commit to which <code>until</code> should be compared to produce a page of changes. If not specified the commit's first parent is assumed (if one exists) (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/changes")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of changes",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges.class))),
    @APIResponse(responseCode = "400", description = "The until parameter was not supplied",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges_401.class))),
    @APIResponse(responseCode = "404", description = "The repository or the since or until parameters supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges_404.class)))
  })
  @Operation(summary = "Get changes in commit")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdChanges getChanges(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @QueryParam("withComments") String withComments, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Search for commit comments.
   * Retrieves the commit discussion comments that match the specified search criteria.

It is possible to retrieve commit discussion comments that are anchored to a range of commits by providing the sinceId that the comments anchored from.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that the commit is in to call this resource.
   *
   * @param path The path to the file on which comments were made (optional)
   * @param projectKey The project key (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param repositorySlug The repository slug (not null)
   * @param since For a merge commit, a parent can be provided to specify which diff the comments are on. For a commit range, a sinceId can be provided to specify where the comments are anchored from. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of comments that match the search criteria",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the comment",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, or commit. The missing entity will be specified in the error details.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_404.class)))
  })
  @Operation(summary = "Search for commit comments")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments getComments(@QueryParam("path") String path, @PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Add a new commit comment.
   * Add a new comment.

Comments can be added in a few places by setting different attributes:

General commit comment:

```{
      "text": "An insightful general comment on a commit."
}

</pre>
Reply to a comment:
<pre>{
      "text": "A measured reply.",
      "parent": {
          "id": 1
      }
}
</pre>
General file comment:
<pre>{
      "text": "An insightful general comment on a file.",
      "anchor": {
          "diffType": "COMMIT",
          "fromHash": "6df3858eeb9a53a911cd17e66a9174d44ffb02cd",
          "path": "path/to/file",
          "srcPath": "path/to/file",
          "toHash": "04c7c5c931b9418ca7b66f51fe934d0bd9b2ba4b"
      }
}
</pre>
File line comment:
<pre>{
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
```

Note: general file comments are an experimental feature and may change in the near future!

For file and line comments, 'path' refers to the path of the file to which the comment should be applied and 'srcPath' refers to the path the that file used to have (only required for copies and moves). Also, fromHash and toHash refer to the sinceId / untilId (respectively) used to produce the diff on which the comment was added. Finally diffType refers to the type of diff the comment was added on.

For line comments, 'line' refers to the line in the diff that the comment should apply to. 'lineType' refers to the type of diff hunk, which can be:- 'ADDED' - for an added line;</li>- 'REMOVED' - for a removed line; or</li>- 'CONTEXT' - for a line that was unmodified but is in the vicinity of the diff.</li>'fileType' refers to the file of the diff to which the anchor should be attached - which is of relevance when displaying the diff in a side-by-side way. Currently the supported values are:- 'FROM' - the source file of the diff</li>- 'TO' - the destination file of the diff</li>If the current user is not a participant the user is added as one and updated to watch the commit.

The authenticated user must have REPO_READ permission for the repository that the commit is in to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param repositorySlug The repository slug (not null)
   * @param since For a merge commit, a parent can be provided to specify which diff the comments should be on. For a commit range, a sinceId can be provided to specify where the comments should be anchored from. (optional)
   * @param dto the comment (optional)
   * @return RestComment
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "400", description = "The comment was not created due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the commit, create a comment or watch the commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, commit or parent comment. The missing entity will be specified in the error details.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_404.class))),
    @APIResponse(responseCode = "409", description = "Adding, deleting, or editing comments isn't supported on archived repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdComments_409.class)))
  })
  @Operation(summary = "Add a new commit comment")
  RestComment createComment(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since, @Valid RestComment dto);

  /**
   * Get a commit comment.
   * Retrieves a commit discussion comment.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that the commit is in to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commentId The ID of the comment to retrieve (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param repositorySlug The repository slug (not null)
   * @return RestComment
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the comment",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, commit or comment. The missing entity will be specified in the error details.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_404.class)))
  })
  @Operation(summary = "Get a commit comment")
  RestComment getComment(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update a commit comment.
   * Update a comment, with the following restrictions:

- only the author of the comment may update the <i>text</i> of the comment
- only the author of the comment or repository admins and above may update the other   fields of a comment


<strong>Note:</strong> the supplied supplied JSON object must contain a <code>version</code> that must match the server's version of the comment or the update will fail. To determine the current version of the comment, the comment should be fetched from the server prior to the update. Look for the 'version' attribute in the returned JSON structure.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that the commit is in to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commentId The ID of the comment to retrieve (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param repositorySlug The repository slug (not null)
   * @param dto The comment to update (optional)
   * @return RestComment
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly updated comment.",
                 content = @Content(schema = @Schema(implementation = RestComment.class))),
    @APIResponse(responseCode = "400", description = "The comment was not updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the commit, update the comment or watch the commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_401.class))),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository, commit or comment. The missing entity will be specified in the error details.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_404.class))),
    @APIResponse(responseCode = "409", description = "The comment version supplied does not match the current version or the repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_409.class)))
  })
  @Operation(summary = "Update a commit comment")
  RestComment updateComment(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestComment dto);

  /**
   * Delete a commit comment.
   * Delete a commit comment. Anyone can delete their own comment. Only users with <strong>REPO_ADMIN</strong> and above may delete comments created by other users. Comments which have replies <i>may not be deleted</i>, regardless of the user's granted permissions.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository that the commit is in to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commentId the comment (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param version The expected version of the comment. This must match the server's version of the comment or the delete will fail. To determine the current version of the comment, the comment should be fetched from the server prior to the delete. Look for the 'version' attribute in the returned JSON structure. (optional)
   * @param repositorySlug The repository slug (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The operation was successful"),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the comment.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied project, repository or commit. The missing entity will be specified in the error details.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_404.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "The comment has replies, the version supplied does not match the comment's current version or the repository is archived.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdCommentsCommentId_409.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a commit comment")
  void deleteComment(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("commitId") @NotNull String commitId, @QueryParam("version") String version, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get diff between revisions.
   * Retrieve the diff between two provided revisions.

To stream a raw text representation of the diff, this endpoint can be called with the request header 'Accept: text/plain'.

Note:</strong> This resource is currently <i>not paged</i>. The server will internally apply a hard cap to the streamed lines, and it is not possible to request subsequent pages if that cap is exceeded. In the event that the cap is reached, the diff will be cut short and one or more {@code truncated} flags will be set to true on the "segments", "hunks" and "diffs" properties, as well as the top-level object, in the returned JSON response.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param srcPath The source path for the file, if it was copied, moved or renamed (optional)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param avatarSize If present the service adds avatar URLs for comment authors where the provided value specifies the desired avatar size in pixels. Not applicable if streaming raw diff (optional)
   * @param repositorySlug The repository slug (not null)
   * @param filter Text used to filter files and lines (optional). Not applicable if streaming raw diff (optional)
   * @param avatarScheme The security scheme for avatar URLs. If the scheme is not present then it is inherited from the request. It can be set to "https" to force the use of secure URLs. Not applicable if streaming raw diff (optional)
   * @param path The path to the file which should be diffed (optional) (not null)
   * @param projectKey The project key (not null)
   * @param contextLines The number of context lines to include around added/removed lines in the diff.Not applicable if streaming raw diff (optional)
   * @param autoSrcPath <code>true</code> to automatically try to find the source path when it's not provided, <code>false</code> otherwise. Requires the path to be provided. (optional)
   * @param whitespace Optional whitespace flag which can be set to ignore-all (optional)
   * @param withComments <code>true</code> to embed comments in the diff (the default); otherwise <code>false</code> to stream the diff without comments. Not applicable if streaming raw diff (optional)
   * @param since The base revision to diff from. If omitted the parent revision of the until revision is used (optional)
   * @return RestDiff
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/diff/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A diff between two revisions.",
                 content = @Content(schema = @Schema(implementation = RestDiff.class))),
    @APIResponse(responseCode = "400", description = "The until parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDiffPath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDiffPath_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDiffPath_404.class)))
  })
  @Operation(summary = "Get diff between revisions")
  RestDiff streamDiff(@QueryParam("srcPath") String srcPath, @PathParam("commitId") @NotNull String commitId, @QueryParam("avatarSize") String avatarSize, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("filter") String filter, @QueryParam("avatarScheme") String avatarScheme, @PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("contextLines") String contextLines, @QueryParam("autoSrcPath") String autoSrcPath, @QueryParam("whitespace") String whitespace, @QueryParam("withComments") String withComments, @QueryParam("since") String since);

  /**
   * Get the common ancestor between two commits.
   * Returns the best common ancestor between two commits.

If more than one best common ancestor exists, only one will be returned. It is unspecified which will be returned.
   *
   * @param projectKey The project key (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param otherCommitId The other commit id to calculate the merge-base on (optional)
   * @param repositorySlug The repository slug (not null)
   * @return RestCommit
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/merge-base")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The common ancestor of the two given commits",
                 content = @Content(schema = @Schema(implementation = RestCommit.class))),
    @APIResponse(responseCode = "204", description = "No common parent between the two commits exist"),
    @APIResponse(responseCode = "400", description = "The supplied commit ID(s) was/were invalid",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdMergeBase_400.class))),
    @APIResponse(responseCode = "404", description = "The project, repository, or commit(s) does not exist",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdMergeBase_404.class)))
  })
  @Operation(summary = "Get the common ancestor between two commits")
  RestCommit getMergeBase(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @QueryParam("otherCommitId") String otherCommitId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Watch commit.
   * Add the authenticated user as a watcher for the specified commit.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository containing the commit to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param repositorySlug The repository slug (not null)
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/watch")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The user is now watching the commit."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdWatch_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified project, repository or commit does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdWatch_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Watch commit")
  void watch(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Stop watching commit.
   * Remove the authenticated user as a watcher for the specified commit.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository containing the commit to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param commitId The <i>full ID</i> of the commit within the repository (not null)
   * @param repositorySlug The repository slug (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/watch")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The user is no longer watching the commit."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the pull request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdWatch_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified project, repository or commit does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdWatch_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Stop watching commit")
  void unwatch(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Compare commits.
   * Gets the file changes available in the <code> from</code> commit but not in the <code> to</code> commit.


If either the <code> from</code> or <code> to</code> commit are not specified, they will be replaced by the default branch of their containing repository.
   *
   * @param projectKey The project key. (not null)
   * @param fromRepo an optional parameter specifying the source repository containing the source commit if that commit is not present in the current repository; the repository can be specified by either its ID <em>fromRepo=42</em> or by its project key plus its repo slug separated by a slash: <em>fromRepo=projectKey/repoSlug</em> (optional)
   * @param from the source commit (can be a partial/full commit ID or qualified/unqualified ref name) (optional)
   * @param to the target commit (can be a partial/full commit ID or qualified/unqualified ref name) (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareChanges
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/compare/changes")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of changes.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareChanges.class))),
    @APIResponse(responseCode = "404", description = "The source repository,target repository, or commit does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareChanges_404.class)))
  })
  @Operation(summary = "Compare commits")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareChanges streamChanges(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("fromRepo") String fromRepo, @QueryParam("from") String from, @QueryParam("to") String to, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get accessible commits.
   * Gets the commits accessible from the <code>from</code> commit but not in the <code>to</code> commit.

If either the <code>from</code> or <code>to</code> commit are not specified, they will be replaced by the default branch of their containing repository.
   *
   * @param projectKey The project key. (not null)
   * @param fromRepo an optional parameter specifying the source repository containing the source commit if that commit is not present in the current repository; the repository can be specified by either its ID <em>fromRepo=42</em> or by its project key plus its repo slug separated by a slash: <em>fromRepo=projectKey/repoSlug</em> (optional)
   * @param from the source commit (can be a partial/full commit ID or qualified/unqualified ref name) (optional)
   * @param to the target commit (can be a partial/full commit ID or qualified/unqualified ref name) (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareCommits
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/compare/commits")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of commits.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareCommits.class))),
    @APIResponse(responseCode = "404", description = "The source repository,target repository, or commit does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareCommits_404.class)))
  })
  @Operation(summary = "Get accessible commits")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareCommits streamCommits(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("fromRepo") String fromRepo, @QueryParam("from") String from, @QueryParam("to") String to, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get diff between commits.
   * Gets a diff of the changes available in the <code>from</code> commit but not in the <code> to</code> commit.

If either the <code> from</code> or <code> to</code> commit are not specified, they will be replaced by the default branch of their containing repository.
   *
   * @param path the path to the file to diff (optional) (not null)
   * @param projectKey The project key. (not null)
   * @param contextLines an optional number of context lines to include around each added or removed lines in the diff (optional)
   * @param fromRepo an optional parameter specifying the source repository containing the source commit if that commit is not present in the current repository; the repository can be specified by either its ID <em>fromRepo=42</em> or by its project key plus its repo slug separated by a slash: <em>fromRepo=projectKey/repoSlug</em> (optional)
   * @param srcPath source path (optional)
   * @param from the source commit (can be a partial/full commit ID or qualified/unqualified ref name) (optional)
   * @param to the target commit (can be a partial/full commit ID or qualified/unqualified ref name) (optional)
   * @param whitespace an optional whitespace flag which can be set to <code>ignore-all</code> (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareDiffPath
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/compare/diff{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The diff of the changes.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareDiffPath.class))),
    @APIResponse(responseCode = "404", description = "The source repository,target repository, or commit does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareDiffPath_404.class)))
  })
  @Operation(summary = "Get diff between commits")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCompareDiffPath streamDiff_1(@PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("contextLines") String contextLines, @QueryParam("fromRepo") String fromRepo, @QueryParam("srcPath") String srcPath, @QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("whitespace") String whitespace, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get raw diff for path.
   * Stream the raw diff between two provided revisions.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param contextLines The number of context lines to include around added/removed lines in the diff (optional)
   * @param srcPath The source path for the file, if it was copied, moved or renamed (optional)
   * @param until The target revision to diff to (required) (optional)
   * @param whitespace Optional whitespace flag which can be set to <code>ignore-all</code> (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param since The base revision to diff from. If omitted the parent revision of the until revision is used (optional)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/diff")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A raw diff between two revisions."),
    @APIResponse(responseCode = "400", description = "The path parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiff_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiff_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiff_404.class)))
  })
  @Operation(summary = "Get raw diff for path")
  void streamRawDiff(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("contextLines") String contextLines, @QueryParam("srcPath") String srcPath, @QueryParam("until") String until, @QueryParam("whitespace") String whitespace, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since);

  /**
   * Get raw diff for path.
   * Stream the raw diff between two provided revisions.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param path The path to the file which should be diffed (required) (not null)
   * @param projectKey The project key. (not null)
   * @param contextLines The number of context lines to include around added/removed lines in the diff (optional)
   * @param srcPath The source path for the file, if it was copied, moved or renamed (optional)
   * @param until The target revision to diff to (required) (optional)
   * @param whitespace Optional whitespace flag which can be set to <code>ignore-all</code> (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param since The base revision to diff from. If omitted the parent revision of the until revision is used (optional)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/diff/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A raw diff between two revisions."),
    @APIResponse(responseCode = "400", description = "The until parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiffPath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiffPath_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDiffPath_404.class)))
  })
  @Operation(summary = "Get raw diff for path")
  void streamRawDiff_1(@PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("contextLines") String contextLines, @QueryParam("srcPath") String srcPath, @QueryParam("until") String until, @QueryParam("whitespace") String whitespace, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since);

  /**
   * Get files in directory.
   * Retrieve a page of files from particular directory of a repository. The search is done recursively, so all files from any sub-directory of the specified directory will be returned.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param at The commit ID or ref (e.g. a branch or tag) to list the files at. If not specified the default branch will be used instead. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/files")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of files.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles.class))),
    @APIResponse(responseCode = "400", description = "The path parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles_401.class))),
    @APIResponse(responseCode = "404", description = "The path requested does not exist at the supplied commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles_404.class)))
  })
  @Operation(summary = "Get files in directory")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFiles streamFiles(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get files in directory.
   * Retrieve a page of files from particular directory of a repository. The search is done recursively, so all files from any sub-directory of the specified directory will be returned.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param path The directory to list files for. (not null)
   * @param projectKey The project key. (not null)
   * @param at The commit ID or ref (e.g. a branch or tag) to list the files at. If not specified the default branch will be used instead. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/files/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of files.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath.class))),
    @APIResponse(responseCode = "400", description = "The path requested is not a directory at the supplied commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath_401.class))),
    @APIResponse(responseCode = "404", description = "The path requested does not exist at the supplied commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath_404.class)))
  })
  @Operation(summary = "Get files in directory")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugFilesPath streamFiles_1(@PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get hook scripts.
   * Return a page of hook scripts configured for the specified repository.

This endpoint requires **REPO_ADMIN** permission.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/hook-scripts")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of hook scripts.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts_404.class)))
  })
  @Operation(summary = "Get hook scripts")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScripts getConfigurations_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create/update a hook script.
   * Creates/updates the hook script configuration for the provided hook script and repository.

This endpoint requires **REPO_ADMIN** permission.
   *
   * @param projectKey The project key. (not null)
   * @param scriptId The ID of the hook script (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The hook triggers for which the hook script should be run (optional)
   * @return RestHookScriptConfig
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/hook-scripts/{scriptId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated hook script.",
                 content = @Content(schema = @Schema(implementation = RestHookScriptConfig.class))),
    @APIResponse(responseCode = "400", description = "The hook script was not created/updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_401.class))),
    @APIResponse(responseCode = "404", description = "The repository slug supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_404.class)))
  })
  @Operation(summary = "Create/update a hook script")
  RestHookScriptConfig setConfiguration_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("scriptId") @NotNull String scriptId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestHookScriptTriggers dto);

  /**
   * Remove a hook script.
   * Removes the hook script from the set of hook scripts configured to run in the repository.

This endpoint requires **REPO_ADMIN** permission.
   *
   * @param projectKey The project key. (not null)
   * @param scriptId The ID of the hook script (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/hook-scripts/{scriptId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The hook script was successfully deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The repository slug or hook script ID supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugHookScriptsScriptId_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Remove a hook script")
  void removeConfiguration_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("scriptId") @NotNull String scriptId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get repository labels.
   * Get all labels applied to the given repository.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestLabel
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/labels")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The applied label.",
                 content = @Content(schema = @Schema(implementation = RestLabel.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the labels.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_404.class)))
  })
  @Operation(summary = "Get repository labels")
  RestLabel getAllLabelsForRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Add repository label.
   * Applies a label to the repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The label to apply (optional)
   * @return RestLabel
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/labels")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The applied label.",
                 content = @Content(schema = @Schema(implementation = RestLabel.class))),
    @APIResponse(responseCode = "400", description = "A validation error prevented the label from being created or applied. Possible validation errors include: The name of the label contains uppercase characters, the name is smaller than 3 characters or longer than 50 characters, the label contains other characters than a-z 0-9 and - or the label is already applied to the given repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to apply a label.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabels_404.class)))
  })
  @Operation(summary = "Add repository label")
  RestLabel addLabel(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestLabel dto);

  /**
   * Remove repository label.
   * Remove label that is applied to the given repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository.
   *
   * @param projectKey The project key. (not null)
   * @param labelName The label to remove (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/labels/{labelName}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the label is no longer associated to the repository."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to remove the label.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabelsLabelName_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLabelsLabelName_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Remove repository label")
  void removeLabel(@PathParam("projectKey") @NotNull String projectKey, @PathParam("labelName") @NotNull String labelName, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Stream files.
   * Streams files from the repository's root with the last commit to modify each file. Commit modifications are traversed starting from the <code>at</code> commit or, if not specified, from the tip of the default branch.

Unless the repository is public, the authenticated user must have <b>REPO_READ</b> access to call this resource.
   *
   * @param projectKey The project key (not null)
   * @param at The commit to use as the starting point when listing files and calculating modifications (optional)
   * @param repositorySlug The repository slug (not null)
   * @return ExampleFiles
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/last-modified")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A map of files to the last commit that modified them, and the latest commit to the repository (by nature, any commit to a repository modifies its root).",
                 content = @Content(schema = @Schema(implementation = ExampleFiles.class))),
    @APIResponse(responseCode = "400", description = "No <code>at</code> commit was specified. When streaming modifications, an explicit starting commit must be supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModified_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModified_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist or does not contain the <code>at</code> commit.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModified_404.class)))
  })
  @Operation(summary = "Stream files")
  ExampleFiles stream(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Stream files with last modified commit in path.
   * Streams files in the requested <code>path</code> with the last commit to modify each file. Commit modifications are traversed starting from the <code>at</code> commit or, if not specified, from the tip of the default branch.

Unless the repository is public, the authenticated user must have <b>REPO_READ</b> access to call this resource.
   *
   * @param path The path within the repository whose files should be streamed (not null)
   * @param projectKey The project key (not null)
   * @param at The commit to use as the starting point when listing files and calculating modifications (optional)
   * @param repositorySlug The repository slug (not null)
   * @return ExampleFiles
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/last-modified/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A map of files to the last commit that modified them, and the latest commit to update the requested path.",
                 content = @Content(schema = @Schema(implementation = ExampleFiles.class))),
    @APIResponse(responseCode = "400", description = "No <code>at</code> commit was specified. When streaming modifications, an explicit starting commit must be supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModifiedPath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModifiedPath_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist or does not contain the <code>at</code> commit, or the <code>at</code> commit does not contain the requested path.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLastModifiedPath_404.class)))
  })
  @Operation(summary = "Stream files with last modified commit in path")
  ExampleFiles stream_1(@PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get patch content at revision.
   * Retrieve the patch content for a repository at a specified revision.

Cache headers are added to the response (only if full commit hashes are used, not in the case of short hashes).

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param until The target revision from which to generate the patch (required) (optional)
   * @param allAncestors indicates whether or not to generate a patch which includes all the ancestors of the 'until' revision. If true, the value provided by 'since' is ignored. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param since The base revision from which to generate the patch. This is only applicable when 'allAncestors' is false. If omitted the patch will represent one single commit, the 'until'. (optional)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/patch")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The patch contents from a repository."),
    @APIResponse(responseCode = "400", description = "The until parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPatch_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPatch_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPatch_404.class)))
  })
  @Operation(summary = "Get patch content at revision")
  void streamPatch(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("until") String until, @QueryParam("allAncestors") String allAncestors, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("since") String since);

  /**
   * Get raw content of a file at revision.
   * Retrieve the raw content for a file path at a specified revision.

The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this resource.
   *
   * @param path The file path to retrieve content from (not null)
   * @param projectKey The project key. (not null)
   * @param at A specific commit or ref to retrieve the raw content at, or the default branch if not specified (optional)
   * @param markup If present or "true", triggers the raw content to be markup-rendered and returned as HTML; otherwise, if not specified, or any value other than "true", the content is streamed without markup (optional)
   * @param htmlEscape (Optional) true if HTML should be escaped in the input markup, false otherwise. If not specified, the value of the markup.render.html.escape property, which is true by default, will be used (optional)
   * @param includeHeadingId (Optional) true if headings should contain an ID based on the heading content. If not specified, the value of the markup.render.headerids property, which is false by default, will be used (optional)
   * @param hardwrap (Optional) Whether the markup implementation should convert newlines to breaks. If not specified, the value of the markup.render.hardwrap property, which is true by default, will be used (optional)
   * @param repositorySlug The repository slug. (not null)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/raw/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The raw contents from a file."),
    @APIResponse(responseCode = "400", description = "The path parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRawPath_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRawPath_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRawPath_404.class)))
  })
  @Operation(summary = "Get raw content of a file at revision")
  void streamRaw(@PathParam("path") @NotNull String path, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @QueryParam("markup") String markup, @QueryParam("htmlEscape") String htmlEscape, @QueryParam("includeHeadingId") String includeHeadingId, @QueryParam("hardwrap") String hardwrap, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get ref change activity.
   * Retrieve a page of repository ref change activity.

The authenticated user must have <strong>REPO_ADMIN</strong> permission to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param ref (optional) exact match for a ref ID to filter ref change activity for (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/ref-change-activities")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of ref change activity.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities.class))),
    @APIResponse(responseCode = "401", description = "The user is currently not authenticated or the user does not have REPO_ADMIN permission.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities_404.class)))
  })
  @Operation(summary = "Get ref change activity")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivities getRefChangeActivity(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("ref") String ref, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get branches with ref change activities for repository.
   * Retrieve a page of branches with ref change activities for a specific repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param filterText (optional) Partial match for a ref ID to filter minimal refs for (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/ref-change-activities/branches")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of branches with ref change activities.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches.class))),
    @APIResponse(responseCode = "401", description = "The user is currently not authenticated or the user does not have REPO_ADMIN permission.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches_404.class)))
  })
  @Operation(summary = "Get branches with ref change activities for repository")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRefChangeActivitiesBranches findBranches(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("filterText") String filterText, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get auto decline settings.
   * Retrieves the auto decline settings for the supplied repository. Project settings will be returned if no explicit settings have been set for the repository. In the case that there are no project settings, the default settings will be returned.

The authenticated user must have <strong>REPO_READ</strong> permission for this repository to call the resource.
   *
   * @param projectKey The project key (not null)
   * @param repositorySlug The repository slug (not null)
   * @return RestAutoDeclineSettings
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/auto-decline")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The auto decline settings",
                 content = @Content(schema = @Schema(implementation = RestAutoDeclineSettings.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the auto decline settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_404.class)))
  })
  @Operation(summary = "Get auto decline settings")
  RestAutoDeclineSettings getAutoDeclineSettings_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Create auto decline settings.
   * Creates or updates the auto decline settings for the supplied repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for this repository to call the resource
   *
   * @param projectKey The project key (not null)
   * @param repositorySlug The repository slug (not null)
   * @param dto The settings to create or update (optional)
   * @return RestAutoDeclineSettings
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/auto-decline")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The auto decline settings",
                 content = @Content(schema = @Schema(implementation = RestAutoDeclineSettings.class))),
    @APIResponse(responseCode = "400", description = "inactivityWeeks was not one of 1, 2, 4, 8, or, 12, or the enabled parameter was not included in the request.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to create or update the auto decline settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_404.class)))
  })
  @Operation(summary = "Create auto decline settings")
  RestAutoDeclineSettings setAutoDeclineSettings_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestAutoDeclineSettingsRequest dto);

  /**
   * Delete auto decline settings.
   * Delete auto decline settings for the supplied repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for this repository to call the resource.
   *
   * @param projectKey The project key (not null)
   * @param repositorySlug The repository slug (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/auto-decline")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The auto decline settings have been deleted successfully."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the auto decline settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoDecline_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete auto decline settings")
  void deleteAutoDeclineSettings_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get pull request auto-merge settings.
   * Retrieves the pull request auto-merge settings for the supplied repository. Project settings will be returned if no explicit settings have been set for the repository. In the case that there are no project settings, the default settings will be returned. If the repository's project has restricted its auto-merge settings, then the settings of the project will be returned.

The authenticated user must have <strong>REPO_READ</strong> permission for this repository to call the resource.
   *
   * @param projectKey The project key (not null)
   * @param repositorySlug The repository slug (not null)
   * @return RestAutoMergeRestrictedSettings
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/auto-merge")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The pull request auto-merge settings",
                 content = @Content(schema = @Schema(implementation = RestAutoMergeRestrictedSettings.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the pull request auto-merge settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_404.class)))
  })
  @Operation(summary = "Get pull request auto-merge settings")
  RestAutoMergeRestrictedSettings get_5(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Create or update the pull request auto-merge settings.
   * Creates or updates the pull request auto-merge settings for the supplied repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for this repository to call the resource.
   *
   * @param projectKey The project key (not null)
   * @param repositorySlug The repository slug (not null)
   * @param dto The settings to create or update (optional)
   * @return RestAutoMergeRestrictedSettings
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/auto-merge")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The pull request auto-merge settings",
                 content = @Content(schema = @Schema(implementation = RestAutoMergeRestrictedSettings.class))),
    @APIResponse(responseCode = "400", description = "The 'enabled' field was not provided correctly.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to create or update the pull request auto-merge settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_401.class))),
    @APIResponse(responseCode = "403", description = "The pull request auto-merge settings cannot be modified due to a restriction enforced by the supplied repository's project.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_403.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_404.class)))
  })
  @Operation(summary = "Create or update the pull request auto-merge settings")
  RestAutoMergeRestrictedSettings set_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestAutoMergeSettingsRequest dto);

  /**
   * Delete pull request auto-merge settings.
   * Deletes pull request auto-merge settings for the supplied repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for this repository to call the resource.
   *
   * @param projectKey The project key (not null)
   * @param repositorySlug The repository slug (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/auto-merge")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The pull request auto-merge settings"),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the pull request auto-merge settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "403", description = "The pull request auto-merge settings cannot be modified due to a restriction enforced by the supplied repository's project.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_403.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsAutoMerge_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete pull request auto-merge settings")
  void delete_5(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get repository hooks.
   * Retrieve a page of repository hooks for this repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param type The optional type to filter by. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/hooks")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of repository hooks with their associated enabled state.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the hooks.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks_404.class)))
  })
  @Operation(summary = "Get repository hooks")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooks getRepositoryHooks_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("type") String type, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get repository hook.
   * Retrieve a repository hook for this repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param hookKey The hook key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestRepositoryHook
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/hooks/{hookKey}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The repository hooks with their associated enabled state for the supplied hookKey.",
                 content = @Content(schema = @Schema(implementation = RestRepositoryHook.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the hook.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository hook does not exist for the given repository, or the repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_404.class)))
  })
  @Operation(summary = "Get repository hook")
  RestRepositoryHook getRepositoryHook_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Delete repository hook.
   * Delete repository hook configuration for the supplied <strong>hookKey</strong> and <strong>repositorySlug</strong>

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param hookKey The hook key. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/hooks/{hookKey}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The hook configuration matching the supplied <strong>hookKey</strong> and <strong>repositorySlug</strong> was deleted"),
    @APIResponse(responseCode = "400", description = "The settings specified are invalid.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the hook.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository or hook does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKey_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete repository hook")
  void deleteRepositoryHook(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Enable repository hook.
   * Enable a repository hook for this repository and optionally apply new configuration.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.

A JSON document may be provided to use as the settings for the hook. These structure and validity of the document is decided by the plugin providing the hook.
   *
   * @param projectKey The project key. (not null)
   * @param hookKey The hook key. (not null)
   * @param contentLength The content length. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @return RestRepositoryHook
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/hooks/{hookKey}/enabled")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The repository hooks with their associated enabled state for the supplied hookKey.",
                 content = @Content(schema = @Schema(implementation = RestRepositoryHook.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to enable the hook.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeyEnabled_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or hook does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeyEnabled_404.class)))
  })
  @Operation(summary = "Enable repository hook")
  RestRepositoryHook enableHook_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @HeaderParam("Content-Length") String contentLength, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Disable repository hook.
   * Disable a repository hook for this repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param hookKey The hook key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestRepositoryHook
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/hooks/{hookKey}/enabled")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The repository hooks with their associated enabled state for the supplied hookKey.",
                 content = @Content(schema = @Schema(implementation = RestRepositoryHook.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to disable the hook.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeyEnabled_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or hook does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeyEnabled_404.class)))
  })
  @Operation(summary = "Disable repository hook")
  RestRepositoryHook disableHook_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get repository hook settings.
   * Retrieve the settings for a repository hook for this repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param hookKey The hook key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return ExampleSettings
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/hooks/{hookKey}/settings")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The settings for the hook.",
                 content = @Content(schema = @Schema(implementation = ExampleSettings.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the hook settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or hook does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_404.class)))
  })
  @Operation(summary = "Get repository hook settings")
  ExampleSettings getSettings_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update repository hook settings.
   * Modify the settings for a repository hook for this repository.

The service will reject any settings which are too large, the current limit is 32KB once serialized.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.

A JSON document can be provided to use as the settings for the hook. These structure and validity of the document is decided by the plugin providing the hook.
   *
   * @param projectKey The project key. (not null)
   * @param hookKey The hook key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The raw settings. (optional)
   * @return ExampleSettings
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/hooks/{hookKey}/settings")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The settings for the hook.",
                 content = @Content(schema = @Schema(implementation = ExampleSettings.class))),
    @APIResponse(responseCode = "400", description = "The settings specified are invalid.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to modify the hook settings.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or hook does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsHooksHookKeySettings_404.class)))
  })
  @Operation(summary = "Update repository hook settings")
  ExampleSettings setSettings_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid ExampleSettings dto);

  /**
   * Get pull request settings.
   * Retrieve the pull request settings for the context repository.

The authenticated user must have <strong>REPO_READ</strong> permission for the context repository to call this resource.

This resource will call all RestFragments that are registered with the key <strong>bitbucket.repository.settings.pullRequests</strong>. If any fragment fails validations by returning a non-empty Map of errors, then no fragments will execute.

The property keys for the settings that are bundled with the application are

- mergeConfig - the merge strategy configuration for pull requests
- requiredApprovers - (Deprecated, please use com.atlassian.bitbucket.server.bundled-hooks.requiredApproversMergeHook instead) the number of approvals required on a pull request for it to be mergeable, or 0 if the merge check is disabled
- com.atlassian.bitbucket.server.bundled-hooks.requiredApproversMergeHook - the merge check configuration for required approvers
- requiredAllApprovers - whether or not all approvers must approve a pull request for it to be mergeable
- requiredAllTasksComplete - whether or not all tasks on a pull request need to be completed for it to be mergeable
- requiredSuccessfulBuilds - (Deprecated, please use com.atlassian.bitbucket.server.bitbucket-build.requiredBuildsMergeCheck instead) the number of successful builds on a pull request for it to be mergeable, or 0 if the merge check is disabled
- com.atlassian.bitbucket.server.bitbucket-build.requiredBuildsMergeCheck - the merge check configuration for required builds



   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestRepositoryPullRequestSettings
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/pull-requests")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The repository pull request settings for the context repository.",
                 content = @Content(schema = @Schema(implementation = RestRepositoryPullRequestSettings.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to see the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_404.class)))
  })
  @Operation(summary = "Get pull request settings")
  RestRepositoryPullRequestSettings getPullRequestSettings_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update pull request settings.
   * Update the pull request settings for the context repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the context repository to call this resource.

This resource will call all RestFragments that are registered with the key <strong>bitbucket.repository.settings.pullRequests</strong>. If any fragment fails validations by returning a non-empty Map of errors, then no fragments will execute.

Only the settings that should be updated need to be included in the request.

The property keys for the settings that are bundled with the application are

- mergeConfig - the merge strategy configuration for pull requests
- requiredApprovers - (Deprecated, please use com.atlassian.bitbucket.server.bundled-hooks.requiredApproversMergeHook instead) the number of approvals required on a pull request for it to be mergeable, or 0 to disable the merge check
- com.atlassian.bitbucket.server.bundled-hooks.requiredApproversMergeHook - a json map containing the keys 'enabled' (a boolean to enable or disable this merge check) and 'count' (an integer to set the number of required approvals)
- requiredAllApprovers - whether or not all approvers must approve a pull request for it to be mergeable
- requiredAllTasksComplete - whether or not all tasks on a pull request need to be completed for it to be mergeable
- requiredSuccessfulBuilds - (Deprecated, please use com.atlassian.bitbucket.server.bitbucket-build.requiredBuildsMergeCheck instead) the number of successful builds on a pull request for it to be mergeable, or 0 to disable the merge check
- com.atlassian.bitbucket.server.bitbucket-build.requiredBuildsMergeCheck - a json map containing the keys 'enabled' (a boolean to enable or disable this merge check) and 'count' (an integer to set the number of required builds)


<strong>Merge strategy configuration deletion:</strong>

An explicitly set pull request merge strategy configuration can be deleted by POSTing a document with an empty "mergeConfig" attribute. i.e:


```{
    "mergeConfig": {
    }
}
```

Upon completion of this request, the effective configuration will be:

- The configuration set for this repository's SCM type as set at the project level, if present, otherwise
- the configuration set for this repository's SCM type as set at the instance level, if present, otherwise
- the default configuration for this repository's SCM type



   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The updated settings. (optional)
   * @return RestRepositoryPullRequestSettings
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/settings/pull-requests")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The repository pull request settings for the context repository.",
                 content = @Content(schema = @Schema(implementation = RestRepositoryPullRequestSettings.class))),
    @APIResponse(responseCode = "400", description = "The repository pull request settings were not updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to see the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugSettingsPullRequests_404.class)))
  })
  @Operation(summary = "Update pull request settings")
  RestRepositoryPullRequestSettings updatePullRequestSettings_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestRepositoryPullRequestSettings dto);

  /**
   * Find tag.
   * Retrieve the tags matching the supplied <strong>filterText</strong> param.

The authenticated user must have <strong>REPO_READ</strong> permission for the context repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param orderBy Ordering of refs either ALPHABETICAL (by name) or MODIFICATION (last updated) (optional)
   * @param filterText The text to match on. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/tags")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The tags matching the supplied <strong>filterText</strong>.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to read the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags_404.class)))
  })
  @Operation(summary = "Find tag")
  _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags getTags(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("orderBy") String orderBy, @QueryParam("filterText") String filterText, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create tag.
   * Creates a tag using the information provided in the RestCreateTagRequest request

The authenticated user must have <strong>REPO_WRITE</strong> permission for the context repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The request to create a tag containing a <strong>name</strong>, <strong>startPoint</strong>, and optionally a <strong>message</strong> (optional)
   * @return RestTag
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/tags")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created tag.",
                 content = @Content(schema = @Schema(implementation = RestTag.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to write to the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTags_404.class)))
  })
  @Operation(summary = "Create tag")
  RestTag createTagForRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestCreateTagRequest dto);

  /**
   * Get tag.
   * Retrieve a tag in the specified repository.

The authenticated user must have <strong>REPO_READ</strong> permission for the context repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param name The name of the tag to be retrieved. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestTag
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/tags/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The tag which matches the supplied <strong>name</strong>.",
                 content = @Content(schema = @Schema(implementation = RestTag.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to read the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTagsName_401.class))),
    @APIResponse(responseCode = "404", description = "The specified tag does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugTagsName_404.class)))
  })
  @Operation(summary = "Get tag")
  RestTag getTag(@PathParam("projectKey") @NotNull String projectKey, @PathParam("name") @NotNull String name, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Watch repository.
   * Add the authenticated user as a watcher for the specified repository.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The repository to watch. (optional)
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/watch")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The user is now watching the repository."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWatch_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWatch_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Watch repository")
  void watch_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestRepository dto);

  /**
   * Stop watching repository.
   * Remove the authenticated user as a watcher for the specified repository.

The authenticated user must have <strong>REPO_READ</strong> permission for the repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/watch")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The user is no longer watching the repository."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWatch_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWatch_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Stop watching repository")
  void unwatch_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Find webhooks.
   * Find webhooks in this repository.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param event List of <code>com.atlassian.webhooks.WebhookEvent</code> IDs to filter for (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param statistics <code>true</code> if statistics should be provided for all found webhooks (optional)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of webhooks."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to find webhooks in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_404.class)))
  })
  @Operation(summary = "Find webhooks")
  void findWebhooks_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("event") String event, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("statistics") boolean statistics);

  /**
   * Create webhook.
   * Create a webhook for the repository specified via the URL.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The webhook to be created for this repository. (optional)
   * @return RestWebhook
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A created webhook.",
                 content = @Content(schema = @Schema(implementation = RestWebhook.class))),
    @APIResponse(responseCode = "400", description = "The webhook parameters were invalid or not supplied.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to create webhooks in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooks_404.class)))
  })
  @Operation(summary = "Create webhook")
  RestWebhook createWebhook_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestWebhook dto);

  /**
   * Search webhooks.
   * Search webhooks in this repository and parent project. This endpoint returns a superset of the results returned by the /webhooks endpoint because it allows filtering by project scope too, not just repository webhooks.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param scopeType Scopes to filter by. This parameter can be specified once e.g. "scopeType=repository", or twice e.g. "scopeType=repository&scopeType=project", to filter by more than one scope level.  (optional)
   * @param event List of <code>com.atlassian.webhooks.WebhookEvent</code> ids to filter for (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param statistics <code>true</code> if statistics should be provided for all found webhooks (optional)
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/search")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of webhooks."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to find webhooks in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksSearch_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksSearch_404.class)))
  })
  @Operation(summary = "Search webhooks")
  void searchWebhooks(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("scopeType") String scopeType, @QueryParam("event") String event, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("statistics") boolean statistics);

  /**
   * Test webhook.
   * Test connectivity to a specific endpoint.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param webhookId  (optional)
   * @param sslVerificationRequired Whether SSL verification is required for the specified webhook URL. Default value is  <code>true</code>. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param url The url in which to connect to (optional)
   * @param dto Basic authentication credentials, if required. (optional)
   * @return RestWebhookRequestResponse
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/test")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A webhook.",
                 content = @Content(schema = @Schema(implementation = RestWebhookRequestResponse.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to test a connection.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksTest_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksTest_404.class)))
  })
  @Operation(summary = "Test webhook")
  RestWebhookRequestResponse testWebhook_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("webhookId") int webhookId, @QueryParam("sslVerificationRequired") String sslVerificationRequired, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("url") String url, @Valid RestWebhookCredentials dto);

  /**
   * Get webhook.
   * Get a webhook by ID.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param webhookId ID of the webhook (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param statistics <code>true</code> if statistics should be provided for the webhook (optional)
   * @return RestWebhook
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/{webhookId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A webhook.",
                 content = @Content(schema = @Schema(implementation = RestWebhook.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to get a webhook in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist, or the webhook does not exist in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_404.class)))
  })
  @Operation(summary = "Get webhook")
  RestWebhook getWebhook_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("statistics") String statistics);

  /**
   * Update webhook.
   * Update an existing webhook.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param webhookId Id of the existing webhook (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The representation of the updated values for the webhook (optional)
   * @return RestWebhook
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/{webhookId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A webhook.",
                 content = @Content(schema = @Schema(implementation = RestWebhook.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update a webhook in this repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist, or the webhook does not exist in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_404.class)))
  })
  @Operation(summary = "Update webhook")
  RestWebhook updateWebhook_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestWebhook dto);

  /**
   * Delete webhook.
   * Delete a webhook for the repository specified via the URL.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param webhookId The ID of the webhook to be deleted. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/{webhookId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The webhook for the repository has been deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete webhooks in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist, or webhook does not exist in this repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookId_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete webhook")
  void deleteWebhook_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get last webhook invocation details.
   * Get the latest invocations for a specific webhook.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param webhookId ID of the webhook (not null)
   * @param event The string ID of a specific event to retrieve the last invocation for. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param outcome The outcome to filter for. Can be SUCCESS, FAILURE, ERROR. None specified means that the all will be considered (optional)
   * @return RestDetailedInvocation
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/{webhookId}/latest")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A webhook invocation dataset.",
                 content = @Content(schema = @Schema(implementation = RestDetailedInvocation.class))),
    @APIResponse(responseCode = "204", description = "No webhook invocations exist."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to get webhook invocations in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdLatest_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist, or the webhook does not exist in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdLatest_404.class)))
  })
  @Operation(summary = "Get last webhook invocation details")
  RestDetailedInvocation getLatestInvocation_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @QueryParam("event") String event, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("outcome") String outcome);

  /**
   * Get webhook statistics.
   * Get the statistics for a specific webhook.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param webhookId ID of the webhook (not null)
   * @param event The string ID of a specific event to retrieve the last invocation for. May be empty, in which case all events are considered (optional)
   * @param repositorySlug The repository slug. (not null)
   * @return RestInvocationHistory
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/{webhookId}/statistics")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A webhook invocation dataset.",
                 content = @Content(schema = @Schema(implementation = RestInvocationHistory.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to get webhook statistics in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatistics_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist, or the webhook does not exist in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatistics_404.class)))
  })
  @Operation(summary = "Get webhook statistics")
  RestInvocationHistory getStatistics_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @QueryParam("event") String event, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get webhook statistics summary.
   * Get the statistics summary for a specific webhook.

The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param webhookId ID of the webhook (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestInvocationHistory
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/webhooks/{webhookId}/statistics/summary")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A webhook invocation dataset.",
                 content = @Content(schema = @Schema(implementation = RestInvocationHistory.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to get webhook statistics summary in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatisticsSummary_401.class))),
    @APIResponse(responseCode = "404", description = "The repository does not exist, or the webhook does not exist in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugWebhooksWebhookIdStatisticsSummary_404.class)))
  })
  @Operation(summary = "Get webhook statistics summary")
  RestInvocationHistory getStatisticsSummary_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Search for repositories.
   * Retrieve a page of repositories based on query parameters that control the search. See the documentation of the parameters for more details.

This resource is anonymously accessible.

<b>Note on permissions.</b> In absence of the <code>permission</code> query parameter the implicit 'read' permission is assumed. Please note that this permission is lower than the <tt>REPO_READ</tt> permission rather than being equal to it. The implicit 'read' permission for a given repository is assigned to any user that has any of the higher permissions, such as <tt>REPO_READ</tt>, as well as to anonymous users if the repository is marked as public. The important implication of the above is that an anonymous request to this resource with a permission level <tt>REPO_READ</tt> is guaranteed to receive an empty list of repositories as a result. For anonymous requests it is therefore recommended to not specify the <tt>permission</tt> parameter at all.
   *
   * @param archived (optional) if specified, this will limit the resulting repository list to ones whose are <tt>ACTIVE</tt>, <tt>ARCHIVED</tt> or <tt>ALL</tt> for both. The match performed is case-insensitive. This filter defaults to <tt>ACTIVE</tt> when not set. <em>Available since 8.0</em> (optional)
   * @param projectname (optional) if specified, this will limit the resulting repository list to ones whose project's name matches this parameter's value. The match performed is case-insensitive and any leading and/or trailing whitespace characters on the <code>projectname</code> parameter will be stripped. (optional)
   * @param projectkey (optional) if specified, this will limit the resulting repository list to ones whose project's key matches this parameter's value. The match performed is case-insensitive and any leading  and/or trailing whitespace characters on the <code>projectKey</code> parameter will be stripped. <em>Available since 8.0</em> (optional)
   * @param visibility (optional) if specified, this will limit the resulting repository list based on the repositories visibility. Valid values are <em>public</em> or <em>private</em>. (optional)
   * @param name (optional) if specified, this will limit the resulting repository list to ones whose name matches this parameter's value. The match performed is case-insensitive and any leading and/or trailing whitespace characters on the <code>name</code> parameter will be stripped. (optional)
   * @param permission (optional) if specified, it must be a valid repository permission level name and will limit the resulting repository list to ones that the requesting user has the specified permission level to. If not specified, the default implicit 'read' permission level will be assumed. The currently supported explicit permission values are <tt>REPO_READ</tt>, <tt>REPO_WRITE</tt> and <tt>REPO_ADMIN</tt>. (optional)
   * @param state (optional) if specified, it must be a valid repository state name and will limit the resulting repository list to ones that are in the specified state. The currently supported explicit state values are <tt>AVAILABLE</tt>, <tt>INITIALISING</tt> and <tt>INITIALISATION_FAILED</tt>.<br> <em>Available since 5.13</em> (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseApiLatestRepos
   */
  @GET
  @Path("api/latest/repos")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of repositories.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestRepos.class))),
    @APIResponse(responseCode = "400", description = "The <code>visibility</code> parameter contains an invalid value.",
                 content = @Content(schema = @Schema(implementation = _ResponseApiLatestRepos_400.class)))
  })
  @Operation(summary = "Search for repositories")
  _ResponseApiLatestRepos getRepositories_1(@QueryParam("archived") String archived, @QueryParam("projectname") String projectname, @QueryParam("projectkey") String projectkey, @QueryParam("visibility") String visibility, @QueryParam("name") String name, @QueryParam("permission") String permission, @QueryParam("state") String state, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Search for ref restrictions.
   * Search for restrictions using the supplied parameters.

The authenticated user must have <strong>REPO_ADMIN</strong> permission or higher to call this resource. Only authenticated users may call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param matcherType Matcher type to filter on (optional)
   * @param matcherId Matcher id to filter on. Requires the matcherType parameter to be specified also. (optional)
   * @param type Types of restrictions to filter on. (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions
   */
  @GET
  @Path("branch-permissions/latest/projects/{projectKey}/repos/{repositorySlug}/restrictions")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing a page of restrictions.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions.class))),
    @APIResponse(responseCode = "400", description = "The request has failed validation.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get restrictions on the provided project",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_401.class))),
    @APIResponse(responseCode = "404", description = "No restriction exists for the provided ID.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_404.class)))
  })
  @Operation(summary = "Search for ref restrictions")
  _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions getRestrictions_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("matcherType") String matcherType, @QueryParam("matcherId") String matcherId, @QueryParam("type") String type, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create multiple ref restrictions.
   * Allows creating multiple restrictions at once.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The request containing a list of the details of the restrictions to create. (optional)
   * @return RestRefRestriction
   */
  @POST
  @Path("branch-permissions/latest/projects/{projectKey}/repos/{repositorySlug}/restrictions")
  @Consumes("application/vnd.atl.bitbucket.bulk+json")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Response contains the ref restriction that was just created.",
                 content = @Content(schema = @Schema(implementation = RestRefRestriction.class))),
    @APIResponse(responseCode = "400", description = "The request has failed validation.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to perform this operation.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictions_401.class)))
  })
  @Operation(summary = "Create multiple ref restrictions")
  RestRefRestriction createRestrictions_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid List<RestRestrictionRequest> dto);

  /**
   * Get a ref restriction.
   * Returns a restriction as specified by a restriction id.

The authenticated user must have <strong>REPO_ADMIN</strong> permission or higher to call this resource. Only authenticated users may call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The restriction id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestRefRestriction
   */
  @GET
  @Path("branch-permissions/latest/projects/{projectKey}/repos/{repositorySlug}/restrictions/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the restriction.",
                 content = @Content(schema = @Schema(implementation = RestRefRestriction.class))),
    @APIResponse(responseCode = "400", description = "The request has failed validation.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get restrictions on the provided project",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_401.class))),
    @APIResponse(responseCode = "404", description = "No restriction exists for the provided ID.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_404.class)))
  })
  @Operation(summary = "Get a ref restriction")
  RestRefRestriction getRestriction_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Delete a ref restriction.
   * Deletes a restriction as specified by a restriction id.

The authenticated user must have <strong>REPO_ADMIN</strong> permission or higher to call this resource. Only authenticated users may call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param id The restriction id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("branch-permissions/latest/projects/{projectKey}/repos/{repositorySlug}/restrictions/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the operation was successful"),
    @APIResponse(responseCode = "400", description = "The request has failed validation.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to delete restrictions on the provided project",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyReposRepositorySlugRestrictionsId_401.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a ref restriction")
  void deleteRestriction_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Create branch.
   *  Creates a branch in the specified repository.


The authenticated user must have an effective <strong>REPO_WRITE</strong> permission to call this resource. If
branch permissions are set up in the repository, the authenticated user must also have access to the branch name
that is to be created.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto  (not null)
   * @return RestBranch
   */
  @POST
  @Path("branch-utils/latest/projects/{projectKey}/repos/{repositorySlug}/branches")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "JSON representation of the newly created branch",
                 content = @Content(schema = @Schema(implementation = RestBranch.class))),
    @APIResponse(responseCode = "400", description = "The branch was not created because the request was invalid, e.g. the provided\nref name already existed in the repository, or was not a valid ref name in the\nrepository",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to create a branch. This could be due to insufficient repository permissions, or lack of branch permission for the provided ref name",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_401.class))),
    @APIResponse(responseCode = "409", description = "The branch name overlapped with an existing branch",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_409.class)))
  })
  @Operation(summary = "Create branch")
  RestBranch createBranch(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @NotNull @Valid RestBranchCreateRequest dto);

  /**
   * Delete branch.
   *  Deletes a branch in the specified repository.


 If the branch does not exist, this operation will not raise an error. In other words after calling this resource
 and receiving a 204 response the branch provided in the request is guaranteed to not exist in the specified
 repository any more, regardless of its existence beforehand.


 The optional 'endPoint' parameter of the request may contain a commit ID that the provided ref name is
 expected to point to. Should the ref point to a different commit ID, a 400 response will be returned with
 appropriate error details.


 The authenticated user must have an effective <strong>REPO_WRITE</strong> permission to call this resource. If
 branch permissions are set up in the repository, the authenticated user must also have access to the branch name
 that is to be deleted.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto Branch delete request (optional)
   */
  @DELETE
  @Path("branch-utils/latest/projects/{projectKey}/repos/{repositorySlug}/branches")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the branch no longer exists in the repository"),
    @APIResponse(responseCode = "400", description = "The branch was not deleted because the request was invalid, e.g. no ref name\nto delete was provided, or the provided ref name points to the default branch\nin the repository that cannot be deleted",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete a\nbranch. This could be due to insufficient repository permissions, or lack of\nbranch permission for the provided ref name.",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranches_401.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete branch")
  void deleteBranch(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestBranchDeleteRequest dto);

  /**
   * Get branch.
   * Gets the branch information associated with a single commit from a given repository.
   *
   * @param projectKey The project key. (not null)
   * @param commitId  (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranchesInfoCommitId
   */
  @GET
  @Path("branch-utils/latest/projects/{projectKey}/repos/{repositorySlug}/branches/info/{commitId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of branch refs associated with the commit",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranchesInfoCommitId.class))),
    @APIResponse(responseCode = "500", description = "The request has timed out processing the branch request",
                 content = @Content(schema = @Schema(implementation = _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranchesInfoCommitId_500.class)))
  })
  @Operation(summary = "Get branch")
  _ResponseBranchUtilsLatestProjectsProjectKeyReposRepositorySlugBranchesInfoCommitId findByCommit(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull @Size(max = 40) String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * React to a comment.
   * Add an emoticon reaction to a comment
   *
   * @param projectKey The project key. (not null)
   * @param commentId The comment id (not null)
   * @param commitId The commit id (not null)
   * @param emoticon The emoticon to add (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestUserReaction
   */
  @PUT
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}/reactions/{emoticon}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(RestUserReaction.class)
  @Operation(summary = "React to a comment")
  RestUserReaction react(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("commitId") @NotNull String commitId, @PathParam("emoticon") @NotNull String emoticon, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Remove a reaction from comment.
   * Remove an emoticon reaction from a comment
   *
   * @param projectKey The project key. (not null)
   * @param commentId The comment id (not null)
   * @param commitId The commit id (not null)
   * @param emoticon The emoticon to remove (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("comment-likes/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/comments/{commentId}/reactions/{emoticon}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The added reaction")
  })
  @Operation(summary = "Remove a reaction from comment")
  void unReact(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commentId") @NotNull String commentId, @PathParam("commitId") @NotNull String commitId, @PathParam("emoticon") @NotNull String emoticon, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Create tag.
   * Creates a tag in the specified repository.

The authenticated user must have an effective <strong>REPO_WRITE</strong> permission to call this resource.

'LIGHTWEIGHT' and 'ANNOTATED' are the two type of tags that can be created. The 'startPoint' can either be a ref or a 'commit'.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The create git tag request. (optional)
   * @return RestTag
   */
  @POST
  @Path("git/latest/projects/{projectKey}/repos/{repositorySlug}/tags")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "A JSON representation of the newly created tag.",
                 content = @Content(schema = @Schema(implementation = RestTag.class))),
    @APIResponse(responseCode = "400", description = "The tag was not created because the request was invalid, e.g. the provided ref name already existed in the repository, or was not a valid ref name in the repository, or the start point is invalid.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugTags_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to create a tag. This could be due to insufficient repository permissions.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugTags_401.class)))
  })
  @Operation(summary = "Create tag")
  RestTag createTag(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestGitTagCreateRequest dto);

  /**
   * Delete tag.
   * Deletes a tag in the specified repository.

The authenticated user must have an effective <strong>REPO_WRITE</strong> permission to call this resource.
   *
   * @param projectKey The project key. (not null)
   * @param name The name of the tag to be deleted. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("git/latest/projects/{projectKey}/repos/{repositorySlug}/tags/{name}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the tag no longer exists in the repository."),
    @APIResponse(responseCode = "400", description = "The tag was not deleted because repository is either empty, or is not a git repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugTagsName_400.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete a tag. This could be due to insufficient repository permissions.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugTagsName_401.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "If the tag doesn't exist in the repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseGitLatestProjectsProjectKeyReposRepositorySlugTagsName_404.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete tag")
  void deleteTag(@PathParam("projectKey") @NotNull String projectKey, @PathParam("name") @NotNull String name, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get synchronization status.
   * Retrieves the synchronization status for the specified repository. In addition to listing refs which cannot be synchronized, if any, the status also provides the timestamp for the most recent synchronization and indicates whether synchronization is available and enabled. If "?at" is specified in the URL, the synchronization status for the specified ref is returned, rather than the complete repository status.

The authenticated user must have <b>REPO_READ</b> permission for the repository, or it must be public if the request is anonymous. Additionally, after synchronization is enabled for a repository, meaning synchronization was available at that time, permission changes and other actions can cause it to become unavailable. Even when synchronization is enabled, if it is no longer available for the repository it will not be performed.
   *
   * @param projectKey The project key. (not null)
   * @param at Retrieves the synchronization status for the specified ref within the repository, rather than for the entire repository (optional)
   * @param repositorySlug The repository slug. (not null)
   * @return RestRefSyncStatus
   */
  @GET
  @Path("sync/latest/projects/{projectKey}/repos/{repositorySlug}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Synchronization status for the specified repository, or specific ref within that repository.",
                 content = @Content(schema = @Schema(implementation = RestRefSyncStatus.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the repository, or the repository is not public if the request is anonymous.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_404.class)))
  })
  @Operation(summary = "Get synchronization status")
  RestRefSyncStatus getStatus(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Disable synchronization.
   * Enables or disables synchronization for the specified repository. When synchronization is enabled, branches within the repository are immediately synchronized and the status is updated with the outcome. That initial synchronization is performed before the REST request returns, allowing it to return the updated status.

The authenticated user must have <b>REPO_ADMIN</b> permission for the specified repository. Anonymous users cannot manage synchronization, even on public repositories. Additionally, synchronization must be available for the specified repository. Synchronization is only available if:

- The repository is a fork, since its origin is used as upstream
- The owning user still has access to the fork's origin,  if the repository is a <i>personalfork</i>
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto  (optional)
   * @return RestRefSyncStatus
   */
  @POST
  @Path("sync/latest/projects/{projectKey}/repos/{repositorySlug}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated synchronization status for the repository, after enabling synchronization. 204 NO CONTENT is returned instead after disabling synchronization.",
                 content = @Content(schema = @Schema(implementation = RestRefSyncStatus.class))),
    @APIResponse(responseCode = "204", description = "Synchronization has successfully been disabled. 200 OK, with updated status information, is returned instead after enabling synchronization."),
    @APIResponse(responseCode = "400", description = "The JSON payload for the request did not define the \"enabled\" property.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to manage synchronization in the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlug_404.class)))
  })
  @Operation(summary = "Disable synchronization")
  RestRefSyncStatus setEnabled(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestRefSyncStatus dto);

  /**
   * Manual synchronization.
   * Allows developers to apply a manual operation to bring a ref back in sync with upstream when it becomes out of sync due to conflicting changes. The following actions are supported:

- <tt>MERGE</tt>: Merges in commits from the upstream ref. After applying this action, the   synchronized ref will be <tt>AHEAD</tt> (as it still includes commits that do not exist   upstream.
   - This action is only supported for <tt>DIVERGED</tt> refs
   - If a "commitMessage" is provided in the context, it will be used on the merge commit.      Otherwise a default message is used.
- <tt>DISCARD</tt>: <i>Throws away</i> local changes in favour of those made upstream. This is a   <i>destructive</i> operation where commits in the local repository are lost.
   - No context entries are supported for this action
   - If the upstream ref has been deleted, the local ref is deleted as well
   - Otherwise, the local ref is updated to reference the same commit as upstream, even if      the update is not fast-forward (similar to a forced push)


The authenticated user must have <b>REPO_WRITE</b> permission for the specified repository. Anonymous users cannot synchronize refs, even on public repositories. Additionally, synchronization must be <i>enabled</i> and <i>available</i> for the specified repository.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto  (optional)
   * @return RestRejectedRef
   */
  @POST
  @Path("sync/latest/projects/{projectKey}/repos/{repositorySlug}/synchronize")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested action was successfully performed, and has updated the ref's state, but the ref if is still not in sync with upstream. For example, after applying the <tt>MERGE</tt> action, the ref will still be <tt>AHEAD</tt> of upstream. If the action brings the ref in sync with upstream, 204 NO CONTENT is returned instead.",
                 content = @Content(schema = @Schema(implementation = RestRejectedRef.class))),
    @APIResponse(responseCode = "204", description = "The requested action was successfully performed and the ref is now in sync with upstream. If the action updates the ref but does not bring it in sync with upstream, 200 OK is returned instead."),
    @APIResponse(responseCode = "400", description = "The requested synchronization action was not understood.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_400.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update refs within the specified repository.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_401.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_404.class))),
    @APIResponse(responseCode = "409", description = "Synchronization is not available or enabled for the specified repository, or the ref is already in sync with upstream.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_409.class))),
    @APIResponse(responseCode = "501", description = "The requested synchronization action was understood by the server, but the mechanism to apply it has not been implemented.",
                 content = @Content(schema = @Schema(implementation = _ResponseSyncLatestProjectsProjectKeyReposRepositorySlugSynchronize_501.class)))
  })
  @Operation(summary = "Manual synchronization")
  RestRejectedRef synchronize(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestRefSyncRequest dto);
}
