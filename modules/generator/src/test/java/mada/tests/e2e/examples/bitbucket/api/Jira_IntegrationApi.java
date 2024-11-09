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

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;
import mada.tests.e2e.examples.bitbucket.dto.RestCommentJiraIssue;
import mada.tests.e2e.examples.bitbucket.dto.RestEnhancedEntityLink;
import mada.tests.e2e.examples.bitbucket.dto.RestJiraIssue;
import mada.tests.e2e.examples.bitbucket.dto._ResponseJiraLatestCommentsCommentIdIssues_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseJiraLatestCommentsCommentIdIssues_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseJiraLatestIssuesIssueKeyCommits;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/jira/latest")
public interface Jira_IntegrationApi {

    /**
     * Create Jira Issue.
     *
     * Create a Jira issue and associate it with a comment on a pull request.
     * This resource can only be used with comments on a pull request. Attempting to call this resource with a different
     * type of comment (for example, a comment on a commit) will result in an error.
     * The authenticated user must have <strong>REPO_READ</strong> permission for the repository containing the comment
     * to call this resource.
     * The JSON structure for the create issue format is specified by Jira's REST v2 API.
     *
     * @param commentId     the comment to associate the created Jira issue to (not null)
     * @param applicationId id of the Jira server (optional)
     * @param dto           A String representation of the JSON format Jira create issue request see: <a href="https://docs.atlassian.com/jira/REST/server/#api/2/issue-createIssue">Jira REST API</a> (optional)
     * @return RestCommentJiraIssue
     */
    @POST
    @Path("/comments/{commentId}/issues")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The created Jira issue key and the associated comment ID",
                    content = @Content(schema = @Schema(implementation = RestCommentJiraIssue.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The specified application link ID does not match any linked Jira instance.",
                    content = @Content(schema = @Schema(implementation = _ResponseJiraLatestCommentsCommentIdIssues_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "Authentication with the Jira instance is required.",
                    content = @Content(schema = @Schema(implementation = _ResponseJiraLatestCommentsCommentIdIssues_401.class)))
    })
    @Operation(summary = "Create Jira Issue")
    RestCommentJiraIssue createIssue(@PathParam("commentId") @NotNull String commentId, @QueryParam("applicationId") String applicationId, String dto);

    /**
     * Get changesets for issue key.
     *
     * Retrieve a page of changesets associated with the given issue key.
     *
     * @param issueKey   The issue key to search by (not null)
     * @param maxChanges The maximum number of changes to retrieve for each changeset (optional)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseJiraLatestIssuesIssueKeyCommits
     */
    @GET
    @Path("/issues/{issueKey}/commits")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(_ResponseJiraLatestIssuesIssueKeyCommits.class)
    @Operation(summary = "Get changesets for issue key")
    _ResponseJiraLatestIssuesIssueKeyCommits getCommitsByIssueKey(@PathParam("issueKey") @NotNull String issueKey, @QueryParam("maxChanges") String maxChanges, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get entity link.
     *
     * Retrieves the enchanced primary entitylink
     * The authenticated user must have <strong>PROJECT_READ</strong> permission for the project having the primary
     * enhanced entitylink.
     *
     * @param projectKey The project key (not null)
     * @return RestEnhancedEntityLink
     */
    @GET
    @Path("/projects/{projectKey}/primary-enhanced-entitylink")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(RestEnhancedEntityLink.class)
    @Operation(summary = "Get entity link")
    RestEnhancedEntityLink getEnhancedEntityLinkForProject(@PathParam("projectKey") @NotNull String projectKey);

    /**
     * Get issues for a pull request.
     *
     * Retrieves Jira issue keys that are associated with the commits in the specified pull request. The number of
     * commits checked for issues is limited to a default of 100.
     *
     * @param projectKey     The project key (not null)
     * @param pullRequestId  The pull request id (not null)
     * @param repositorySlug The repository slug (not null)
     * @return List<RestJiraIssue>
     */
    @GET
    @Path("/projects/{projectKey}/repos/{repositorySlug}/pull-requests/{pullRequestId}/issues")
    @Produces("application/json;charset=UTF-8")
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A list of Jira issues keys for the pull request",
                    content = @Content(schema = @Schema(implementation = RestJiraIssue.class, type = SchemaType.ARRAY)))
    })
    @Operation(summary = "Get issues for a pull request")
    List<RestJiraIssue> getIssueKeysForPullRequest(@PathParam("projectKey") @NotNull String projectKey, @PathParam("pullRequestId") @NotNull String pullRequestId, @PathParam("repositorySlug") @NotNull String repositorySlug);
}
