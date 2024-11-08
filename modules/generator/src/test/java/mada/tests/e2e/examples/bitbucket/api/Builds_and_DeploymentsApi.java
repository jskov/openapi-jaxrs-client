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
import mada.tests.e2e.examples.bitbucket.dto.RestBuildStats;
import mada.tests.e2e.examples.bitbucket.dto.RestBuildStatus;
import mada.tests.e2e.examples.bitbucket.dto.RestBuildStatusSetRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestBulkAddInsightAnnotationRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestDeployment;
import mada.tests.e2e.examples.bitbucket.dto.RestDeploymentSetRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestInsightAnnotationsResponse;
import mada.tests.e2e.examples.bitbucket.dto.RestInsightReport;
import mada.tests.e2e.examples.bitbucket.dto.RestMultipleBuildStats;
import mada.tests.e2e.examples.bitbucket.dto.RestRequiredBuildCondition;
import mada.tests.e2e.examples.bitbucket.dto.RestRequiredBuildConditionSetRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestSetInsightReportRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestSingleAddInsightAnnotationRequest;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBuildStatusLatestCommitsStatsCommitId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBuildStatusLatestCommitsStats_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdAnnotations_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdAnnotations_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotationsExternalId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotationsExternalId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditionId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditionId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugCondition_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugCondition_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditions;
import mada.tests.e2e.examples.bitbucket.dto._ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditions_401;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface Builds_and_DeploymentsApi {

    /**
     * Get a specific build status. Get a specific build status.
     * 
     * 
     * The authenticated user must have **REPO_READ** permission for the provided repository.The request can also be made
     * with anonymous 2-legged OAuth.<br>
     * Since 7.14
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            the key of the build status (optional)
     * @return RestBuildStatus
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/builds")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The build status associated with the provided commit and key",
                    content = @Content(schema = @Schema(implementation = RestBuildStatus.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request has failed validation",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions this repository",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository, commit or build status does not exist",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_404.class)))
    })
    @Operation(summary = "Get a specific build status")
    RestBuildStatus get(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("key") String key);

    /**
     * Store a build status. Store a build status.
     * 
     * 
     * The authenticated user must have **REPO_READ** permission for the repository that this build status is for. The
     * request can also be made with anonymous 2-legged OAuth.
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param dto            The contents of the build status request are: These fields are **required**:
     * 
     * 
     *                       - **key**: The string referring to this branch plan/job - **state**: The build status state,
     *                       one of: "SUCCESSFUL", "FAILED", "INPROGRESS", "CANCELLED", "UNKNOWN" - **url**: URL referring
     *                       to the build result page in the CI tool.
     * 
     * 
     *                       These fields are optional:
     * 
     * 
     *                       - **buildNumber** (optional): A unique identifier for this particular run of a plan< -
     *                       **dateAdded** (optional): milliseconds since epoch. If not provided current date is used. -
     *                       **description** (optional): Describes the build result - **duration** (optional): Duration of a
     *                       completed build in milliseconds. - **name** (optional): A short string that describes the build
     *                       plan - **parent** (optional): The identifier for the plan or job that ran the branch plan that
     *                       produced this build status. - **ref** (optional): The fully qualified git reference e.g.
     *                       refs/heads/master. - **testResults** (optional): A summary of the passed, failed and skipped
     *                       tests. (optional)
     */
    @POST
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/builds")
    @Consumes(MediaType.WILDCARD)
    @APIResponses({
            @APIResponse(responseCode = "204", description = "The build status was posted"),
            @APIResponse(
                    responseCode = "400",
                    description = "The build status was not added as the request was invalid. This could be because of a number of things:\n\n\n- an invalid commit hash was provided\n- build key was blank or longer than 255 characters\n- invalid branch was provided\n- invalid state was provided\n- build status url was blank or longer than 450 characters\n\nThe specifics will be included in the error message.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_400.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to push a build status to this repository",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_401.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_404.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Store a build status")
    void add(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestBuildStatusSetRequest dto);

    /**
     * Delete a specific build status. Delete a specific build status.
     * 
     * The authenticated user must have **REPO_ADMIN** permission for the provided repository.
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            the key of the build status (optional)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/builds")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The build status associated with the provided commit and key has been deleted"),
            @APIResponse(
                    responseCode = "400",
                    description = "The request has failed validation",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_400.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions this repository",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_401.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdBuilds_404.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete a specific build status")
    void delete(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("key") String key);

    /**
     * Get a deployment. Get the deployment matching the specified Repository, key, environmentKey and
     * deploymentSequenceNumber.
     * 
     * The user must have REPO_READ.
     *
     * @param projectKey               The project key (not null)
     * @param deploymentSequenceNumber the sequence number of the deployment, as detailed by the query param (optional)
     * @param commitId                 the commitId that was deployed as indicated by the query parameter (not null)
     * @param repositorySlug           The repository slug (not null)
     * @param key                      the key of the deployment, as detailed by the query parameter (optional)
     * @param environmentKey           the key of the environment, as detailed by the query parameter (optional)
     * @return RestDeployment
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/deployments")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The deployment",
                    content = @Content(schema = @Schema(implementation = RestDeployment.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "could not get the deployment because the request was invalid",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the repository",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository or deployment does not exist",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_404.class)))
    })
    @Operation(summary = "Get a deployment")
    RestDeployment get_1(@PathParam("projectKey") @NotNull String projectKey,
            @QueryParam("deploymentSequenceNumber") String deploymentSequenceNumber, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("key") String key,
            @QueryParam("environmentKey") String environmentKey);

    /**
     * Create or update a deployment. Create or update a deployment.
     * 
     * The authenticated user must have REPO_READ permission for the repository.
     *
     * @param projectKey     The project key (not null)
     * @param commitId       the commitId that was deployed as indicated by the path (not null)
     * @param repositorySlug The repository slug (not null)
     * @param dto            the details of the deployment to create, as detailed by the request body (optional)
     * @return RestDeployment
     */
    @POST
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/deployments")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The deployment was created",
                    content = @Content(schema = @Schema(implementation = RestDeployment.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "the deployment was not created because the request was invalid",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the repository",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_404.class)))
    })
    @Operation(summary = "Create or update a deployment")
    RestDeployment createOrUpdateDeployment(@PathParam("projectKey") @NotNull String projectKey,
            @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @Valid RestDeploymentSetRequest dto);

    /**
     * Delete a deployment. Delete the deployment matching the specified Repository, key, environmentKey and
     * deploymentSequenceNumber.
     * 
     * The user must have REPO_ADMIN.
     *
     * @param projectKey               The project key (not null)
     * @param deploymentSequenceNumber the sequence number of the deployment, as detailed by the query parameter (optional)
     * @param commitId                 the commitId that was deployed as indicated by the path (not null)
     * @param repositorySlug           The repository slug (not null)
     * @param key                      the key of the deployment, as detailed by the query parameter (optional)
     * @param environmentKey           the key of the environment, as detailed by the query parameter (optional)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/deployments")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "the request has been processed"),
            @APIResponse(
                    responseCode = "400",
                    description = "the deployment was not deleted because the request was invalid",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_400.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete a deployment",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_401.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdDeployments_404.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete a deployment")
    void delete_1(@PathParam("projectKey") @NotNull String projectKey,
            @QueryParam("deploymentSequenceNumber") String deploymentSequenceNumber, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("key") String key,
            @QueryParam("environmentKey") String environmentKey);

    /**
     * Get build status statistics for multiple commits. Produces a list of the build statistics for multiple commits.
     * Commits <em>without any builds associated with them</em> will not be returned.<br>
     * For example if the commit <code>e00cf62997a027bbf785614a93e2e55bb331d268</code> does not have any build statuses
     * associated with it, it will not be present in the response.
     *
     * @param dto full SHA1 of each commit (optional)
     * @return RestMultipleBuildStats
     */
    @POST
    @Path("build-status/latest/commits/stats")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The number of successful/failed/in-progress/cancelled/unknown builds for each commit (with the caveat that the commits <em>without any builds associated with them</em> will not be present in the response)",
                    content = @Content(schema = @Schema(implementation = RestMultipleBuildStats.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The user is not authenticated or does not have the <strong>LICENSED</strong> permission",
                    content = @Content(schema = @Schema(implementation = _ResponseBuildStatusLatestCommitsStats_401.class)))
    })
    @Operation(summary = "Get build status statistics for multiple commits")
    RestMultipleBuildStats getMultipleBuildStatusStats(List<String> dto);

    /**
     * Get build status statistics for commit. Gets statistics regarding the builds associated with a commit
     *
     * @param includeUnique include a unique build result if there is either only one failed build, only one in-progress
     *                      build or only one successful build (optional)
     * @param commitId      full SHA1 of the commit (not null)
     * @return RestBuildStats
     */
    @GET
    @Path("build-status/latest/commits/stats/{commitId}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The number of successful/failed/in-progress/cancelled/unknown builds for the commit",
                    content = @Content(schema = @Schema(implementation = RestBuildStats.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The user is not authenticated or does not have the <b>LICENSED</b> permission.",
                    content = @Content(schema = @Schema(implementation = _ResponseBuildStatusLatestCommitsStatsCommitId_401.class)))
    })
    @Operation(summary = "Get build status statistics for commit")
    RestBuildStats getBuildStatusStats(@QueryParam("includeUnique") boolean includeUnique, @PathParam("commitId") @NotNull String commitId);

    /**
     * Get Code Insights annotations for a commit. Get annotations for the given commit ID, filtered by any query parameters
     * given.
     *
     * @param severity       Return only annotations that have one of the given severities. Can be specified more than once
     *                       to filter by more than one severity. Valid severities are <code>LOW</code>, <code>MEDIUM</code>
     *                       and <code>HIGH</code>. (optional)
     * @param path           Return only annotations that appear on one of the provided paths. Can be specified more than
     *                       once to filter by more than one path. (optional)
     * @param projectKey     The project key. (not null)
     * @param externalId     Return only annotations that have one of the provided external IDs. Can be specified more than
     *                       once to filter by more than one external ID. (optional)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param type           Return only annotations that have one of the given types. Can be specified more than once to
     *                       filter by multiple types. Valid types are <code>BUG</code>, <code>CODE_SMELL</code>, and
     *                       <code>VULNERABILITY</code>. (optional)
     * @param repositorySlug The repository slug. (not null)
     * @param key            Return only annotations that belong to one of the provided report keys. Can be specified more
     *                       than once to filter by more than one report (optional)
     * @return RestInsightAnnotationsResponse
     */
    @GET
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/annotations")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The requested annotations.",
                    content = @Content(schema = @Schema(implementation = RestInsightAnnotationsResponse.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions (<code>REPO_READ</code>) to get insight annotations.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdAnnotations_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository, commit, or report does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdAnnotations_404.class)))
    })
    @Operation(summary = "Get Code Insights annotations for a commit")
    RestInsightAnnotationsResponse getAnnotations(@QueryParam("severity") String severity, @QueryParam("path") String path,
            @PathParam("projectKey") @NotNull String projectKey, @QueryParam("externalId") String externalId,
            @PathParam("commitId") @NotNull String commitId, @QueryParam("type") String type,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("key") String key);

    /**
     * Get all Code Insights reports for a commit. Retrieve all reports for the given commit.
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports
     */
    @GET
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of reports",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions (<code>REPO_READ</code>) to get insight reports.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository or commit does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports_404.class)))
    })
    @Operation(summary = "Get all Code Insights reports for a commit")
    _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReports getReports(
            @PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start,
            @QueryParam("limit") BigDecimal limit);

    /**
     * Get a Code Insights report. Retrieve the specified report.
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            The report key. (not null)
     * @return RestInsightReport
     */
    @GET
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The specified report.",
                    content = @Content(schema = @Schema(implementation = RestInsightReport.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions (<code>REPO_READ needed</code>) to get insight reports.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository, commit, or report does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_404.class)))
    })
    @Operation(summary = "Get a Code Insights report")
    RestInsightReport getACodeInsightsReport(@PathParam("projectKey") @NotNull String projectKey,
            @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @PathParam("key") @NotNull String key);

    /**
     * Create a Code Insights report. Create a new insight report, or replace the existing one if a report already exists
     * for the given repository, commit, and report key. A request to replace an existing report will be rejected if the
     * authenticated user was not the creator of the specified report.
     * 
     * The report key should be a unique string chosen by the reporter and should be unique enough not to potentially clash
     * with report keys from other reporters. We recommend using reverse DNS namespacing or a similar standard to ensure
     * that collision is avoided.
     * <h1>Report parameters</h1>
     * <table summary="Report parameters">
     * <tr>
     * <th>Parameter</th>
     * <th>Description</th>
     * <th>Required?</th>
     * <th>Restrictions</th>
     * <th>Type</th>
     * </tr>
     * <tr>
     * <td>title</td>
     * <td>A short string representing the name of the report</td>
     * <td>Yes</td>
     * <td>Max length: 450 characters (but we recommend that it is shorter so that the display is nicer)</td>
     * <td>String</td>
     * </tr>
     * <tr>
     * <td>details</td>
     * <td>A string to describe the purpose of the report. This string may contain escaped newlines and if it does it will
     * display the content accordingly.</td>
     * <td>No</td>
     * <td>Max length: 2000 characters</td>
     * <td>String</td>
     * </tr>
     * <tr>
     * <td>result</td>
     * <td>Indicates whether the report is in a passed or failed state</td>
     * <td>No</td>
     * <td>One of: PASS, FAIL</td>
     * <td>String</td>
     * </tr>
     * <tr>
     * <td>data</td>
     * <td>An array of data fields (described below) to display information on the report</td>
     * <td>No</td>
     * <td>Maximum 6 data fields</td>
     * <td>Array</td>
     * </tr>
     * <tr>
     * <td>reporter</td>
     * <td>A string to describe the tool or company who created the report</td>
     * <td>No</td>
     * <td>Max length: 450 characters</td>
     * <td>String</td>
     * </tr>
     * <tr>
     * <td>link</td>
     * <td>A URL linking to the results of the report in an external tool.</td>
     * <td>No</td>
     * <td>Must be a valid http or https URL</td>
     * <td>String</td>
     * </tr>
     * <tr>
     * <td>logoUrl</td>
     * <td>A URL to the report logo. If none is provided, the default insights logo will be used.</td>
     * <td>No</td>
     * <td>Must be a valid http or https URL</td>
     * <td>String</td>
     * </tr>
     * </table>
     * <h1>Data parameters</h1>The data field on the report is an array with at most 6 data fields (JSON maps) containing
     * information that is to be displayed on the report (see the request example).
     * <table summary="Data parameters">
     * <tr>
     * <th>Parameter</th>
     * <th>Description</th>
     * <th>Type</th>
     * </tr>
     * <tr>
     * <td>title</td>
     * <td>A string describing what this data field represents</td>
     * <td>String</td>
     * </tr>
     * <tr>
     * <td>type</td>
     * <td>The type of data contained in the value field. If not provided, then the value will be detected as a boolean,
     * number or string. One of: BOOLEAN, DATE, DURATION, LINK, NUMBER, PERCENTAGE, TEXT</td>
     * <td>String</td>
     * </tr>
     * <tr>
     * <td>value</td>
     * <td>A value based on the type provided. Either a raw value (string, number or boolean) or a map. See below.</td>
     * </tr>
     * </table>
     * <table summary="Types">
     * <tr>
     * <th>Type Field</th>
     * <th>Value Field Type</th>
     * <th>Value Field Display</th>
     * </tr>
     * <tr>
     * <td>None/Omitted</td>
     * <td>Number, String or Boolean (not an array or object)</td>
     * <td>Plain text</td>
     * </tr>
     * <tr>
     * <td>BOOLEAN</td>
     * <td>Boolean</td>
     * <td>The value will be read as a JSON boolean and displayed as 'Yes' or 'No'.</td>
     * </tr>
     * <tr>
     * <td>DATE</td>
     * <td>Number</td>
     * <td>The value will be read as a JSON number in the form of a Unix timestamp (milliseconds) and will be displayed as a
     * relative date if the date is less than one week ago, otherwise it will be displayed as an absolute date.</td>
     * </tr>
     * <tr>
     * <td>DURATION</td>
     * <td>Number</td>
     * <td>The value will be read as a JSON number in milliseconds and will be displayed in a human readable duration
     * format.</td>
     * </tr>
     * <tr>
     * <td>LINK</td>
     * <td>Object: {"linktext": "Link text here", "href": "https://link.to.annotation/in/external/tool"}</td>
     * <td>The value will be read as a JSON object containing the fields "linktext" and "href" and will be displayed as a
     * clickable link on the report.</td>
     * </tr>
     * <tr>
     * <td>NUMBER</td>
     * <td>Number</td>
     * <td>The value will be read as a JSON number and large numbers will be displayed in a human readable format (e.g.
     * 14.3k).</td>
     * </tr>
     * <tr>
     * <td>PERCENTAGE</td>
     * <td>Number (between 0 and 100)</td>
     * <td>The value will be read as a JSON number between 0 and 100 and will be displayed with a percentage sign.</td>
     * </tr>
     * <tr>
     * <td>TEXT</td>
     * <td>String</td>
     * <td>The value will be read as a JSON string and will be displayed as-is</td>
     * </tr>
     * </table>
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            A unique string representing the report as chosen by the reporter. This should be unique enough
     *                       to not clash with other report's keys. To do this, we recommend namespacing the key using
     *                       reverse DNS (not null)
     * @param dto            The request object containing the details of the report to create (see example). (optional)
     * @return RestInsightReport
     */
    @PUT
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports/{key}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The created report.",
                    content = @Content(schema = @Schema(implementation = RestInsightReport.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "One of the following error cases occurred (check the error message for more details):\n\n- The request does not contain a report title.\n- The data field contains unsupported objects.\n- The request does not contain a report key/\n- The provided commit hash is invalid, according to  the validation rules mentioned for the commitId above.\n",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not permitted to create an insight report or authentication failed.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_401.class)))
    })
    @Operation(summary = "Create a Code Insights report")
    RestInsightReport setACodeInsightsReport(@PathParam("projectKey") @NotNull String projectKey,
            @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @PathParam("key") @NotNull String key, @Valid RestSetInsightReportRequest dto);

    /**
     * Delete a Code Insights report. Delete a report for the given commit. Also deletes any annotations associated with
     * this report.
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            The key of the report to which this annotation belongs. (not null)
     */
    @DELETE
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports/{key}")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "The report and associated annotations were successfully deleted."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete insight reports or was not the author (<code>REPO_READ</code> for author otherwise <code>REPO_ADMIN</code>).",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_401.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository, commit or report does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKey_404.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete a Code Insights report")
    void deleteACodeInsightsReport(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @PathParam("key") @NotNull String key);

    /**
     * Get Code Insights annotations for a report. Retrieve the specified report's annotations.
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            The report key. (not null)
     * @return RestInsightAnnotationsResponse
     */
    @GET
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports/{key}/annotations")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The specified annotations.",
                    content = @Content(schema = @Schema(implementation = RestInsightAnnotationsResponse.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions (<code>REPO_READ needed</code>) to get insight reports.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository, commit, or report does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_404.class)))
    })
    @Operation(summary = "Get Code Insights annotations for a report")
    RestInsightAnnotationsResponse getAnnotations_1(@PathParam("projectKey") @NotNull String projectKey,
            @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @PathParam("key") @NotNull String key);

    /**
     * Add Code Insights annotations. Add annotations to the given report. The request should be a JSON object mapping the
     * string "annotations" to an array of maps containing the annotation data, as described below. See also the example
     * request.
     * 
     * A few things to note:- Annotations are an extension of a report, so a report must first exist in order to post
     * annotations. Annotations are posted separately from the report, and can be posted in bulk using this endpoint. - Only
     * the annotations that are on lines changed in the unified diff will be displayed. This means it is likely not all
     * annotations posted will be displayed on the pull request It also means that if the user is viewing a side-by-side
     * diff, commit diff or iterative review diff they will not be able to view the annotations. - A report cannot have more
     * than 1000 annotations by default, however this property is congurable at an instance level. If the request would
     * result in more than the maximum number of annotations being stored then the entire request is rejected and no new
     * annotations are stored. - There is no de-duplication of annotations on Bitbucket so be sure that reruns of builds
     * will first delete the report and annotations before creating them.
     * 
     * # Annotation parameters
     * 
     * |Parameter|Description|Required?|Restrictions|Type| |--- |--- |--- |--- |--- | |path|The path of the file on which
     * this annotation should be placed. This is the path of the filerelative to the git repository. If no path is provided,
     * then it will appear in the overview modalon all pull requests where the tip of the branch is the given commit,
     * regardless of which files weremodified.|No||String| |line|The line number that the annotation should belong to. If no
     * line number is provided, then it willdefault to 0 and in a pull request it will appear at the top of the file
     * specified by the path field.|No|Non-negative integer|Integer| |message|The message to display to users|Yes|The
     * maximum length accepted is 2000 characters, however the user interface may truncate this valuefor display purposes.
     * We recommend that the message is short and succinct, with further detailsavailable to the user if needed on the page
     * linked to by the the annotation link.|String| |severity|The severity of the annotation|Yes|One of: LOW, MEDIUM,
     * HIGH|String| |link|An http or https URL representing the location of the annotation in the external tool|No||String|
     * |type|The type of annotation posted|No|One of: VULNERABILITY, CODE_SMELL, BUG|String| |externalId|If the caller
     * requires a link to get or modify this annotation, then an ID must be provided. It isnot used or required by
     * Bitbucket, but only by the annotation creator for updating or deleting thisspecific annotation.|No|A string value
     * shorter than 450 characters|String|
     *
     * @param projectKey     The project key. (not null)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            The key of the report to which this annotation belongs. (not null)
     * @param dto            The annotations to add. (optional)
     */
    @POST
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports/{key}/annotations")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(responseCode = "204", description = "An empty response indicating that the request succeeded."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not the author of the report, or the author no longer has sufficient permissions (<code>REPO_READ</code>).",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_401.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository, commit, or report does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_404.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Add Code Insights annotations")
    void addAnnotations(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull String commitId,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @PathParam("key") @NotNull String key,
            @Valid RestBulkAddInsightAnnotationRequest dto);

    /**
     * Delete Code Insights annotations. Delete annotations for a given report that match the given external IDs, or all
     * annotations if no external IDs are provided.
     *
     * @param projectKey     The project key. (not null)
     * @param externalId     The external IDs for the annotations that are to be deleted. Can be specified more than once to
     *                       delete by more than one external ID, or can be unspecified to delete all annotations.
     *                       (optional)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            The key of the report to which this annotation belongs. (not null)
     */
    @DELETE
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports/{key}/annotations")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "The annotations were successfully deleted."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete insight reports or was not the author (<code>REPO_READ</code> for author otherwise <code>REPO_ADMIN</code>).",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_401.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository, commit or report does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotations_404.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete Code Insights annotations")
    void deleteAnnotations(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("externalId") String externalId,
            @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @PathParam("key") @NotNull String key);

    /**
     * Create or replace a Code Insights annotation. Create an annotation with the given external ID, or replace it if it
     * already exists. A request to replace an existing annotation will be rejected if the authenticated user was not the
     * creator of the specified report.
     *
     * @param projectKey     The project key. (not null)
     * @param externalId     The external ID of the annotation that is to be updated or created (not null)
     * @param commitId       The commit ID on which to record the annotation. This must be a full 40 character commit hash.
     *                       (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param key            The key of the report to which this annotation belongs (not null)
     * @param dto            The new annotation that is to replace the existing one. (optional)
     */
    @PUT
    @Path("insights/latest/projects/{projectKey}/repos/{repositorySlug}/commits/{commitId}/reports/{key}/annotations/{externalId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(responseCode = "204", description = "No content, indicating that the request succeeded."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not the author of the report, or the author no longer has sufficient permissions (<code>REPO_READ</code>).",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotationsExternalId_401.class),
                            mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, repository, commit, report or annotation does not exist.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseInsightsLatestProjectsProjectKeyReposRepositorySlugCommitsCommitIdReportsKeyAnnotationsExternalId_404.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Create or replace a Code Insights annotation")
    void setAnnotation(@PathParam("projectKey") @NotNull String projectKey, @PathParam("externalId") @NotNull String externalId,
            @PathParam("commitId") @NotNull String commitId, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @PathParam("key") @NotNull String key, @Valid RestSingleAddInsightAnnotationRequest dto);

    /**
     * Create a required builds merge check. Create a required build merge check for the given repository.
     * 
     * The authenticated user must have **REPO_ADMIN** permission for the target repository to register a required build
     * merge check.
     * 
     * The contents of the required build merge check request are:
     * 
     * These fields are **required**:
     * 
     * - **buildParentKeys**: A non-empty list of build parent keys that require green builds for this merge check to pass -
     * **refMatcher.id**: The value to match refs against in the target branch - **refMatcher.type.id**: The type of ref
     * matcher, one of: "ANY_REF", "BRANCH", "PATTERN", "MODEL_CATEGORY" or "MODEL_BRANCH"
     * 
     * 
     * These fields are optional:
     * 
     * - **exemptRefMatcher.id** The value to exempt refs in the source branch from this check -
     * **exemptRefMatcher.type.id**: The type of exempt ref matcher, one of: "ANY_REF", "BRANCH", "PATTERN",
     * "MODEL_CATEGORY" or "MODEL_BRANCH"
     *
     * 
     * 
     * 
     * @param projectKey     The project that the repository belongs to (not null)
     * @param repositorySlug The repository being used (not null)
     * @param dto            The request specifying the required build parent keys, ref matcher and exemption matcher
     *                       (optional)
     * @return RestRequiredBuildCondition
     */
    @POST
    @Path("required-builds/latest/projects/{projectKey}/repos/{repositorySlug}/condition")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A response containing the newly created required build merge check.",
                    content = @Content(schema = @Schema(implementation = RestRequiredBuildCondition.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed. This could be caused because:\n\n- The build parent key list is empty\n- Either of the provided ref matchers is of an unrecognized type\n- Either of the provided ref matchers could not be created with the provided type and id\n\n\n",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugCondition_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create a required build merge check in this repository.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugCondition_401.class)))
    })
    @Operation(summary = "Create a required builds merge check")
    RestRequiredBuildCondition createRequiredBuildsMergeCheck(@PathParam("projectKey") @NotNull String projectKey,
            @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestRequiredBuildConditionSetRequest dto);

    /**
     * Update a required builds merge check. Update the required builds merge check for the given ID.
     * 
     * The authenticated user must have **REPO_ADMIN** permission for the target repository to update a required build merge
     * check.
     * 
     * The contents of the required build merge check request are:
     * 
     * These fields are **required**:
     * 
     * - **buildParentKeys**: A non-empty list of build parent keys that require green builds for this merge check to pass -
     * **refMatcher.id**: The value to match refs against in the target branch - **refMatcher.type.id**: The type of ref
     * matcher, one of: "ANY_REF", "BRANCH", "PATTERN", "MODEL_CATEGORY" or "MODEL_BRANCH"
     * 
     * 
     * These fields are optional:
     * 
     * - **exemptRefMatcher.id** The value to exempt refs in the source branch from this check -
     * **exemptRefMatcher.type.id**: The type of exempt ref matcher, one of: "ANY_REF", "BRANCH", "PATTERN",
     * "MODEL_CATEGORY" or "MODEL_BRANCH"
     *
     * 
     * 
     * 
     * @param projectKey     The project that the repository belongs to (not null)
     * @param id             (not null)
     * @param repositorySlug The repository being used (not null)
     * @param dto            The request specifying the required build parent keys, ref matcher and exemption matcher
     *                       (optional)
     * @return RestRequiredBuildCondition
     */
    @PUT
    @Path("required-builds/latest/projects/{projectKey}/repos/{repositorySlug}/condition/{id}")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The details needed to update a required build merge check.",
                    content = @Content(schema = @Schema(implementation = RestRequiredBuildCondition.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed. This could be caused because:\n\n- The build parent key list is empty\n- Either of the provided ref matchers is of an unrecognized type\n- Either of the provided ref matchers could not be created with the provided type and id\n\n\n",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditionId_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create a required build merge check in this repository.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditionId_401.class)))
    })
    @Operation(summary = "Update a required builds merge check")
    RestRequiredBuildCondition updateRequiredBuildsMergeCheck(@PathParam("projectKey") @NotNull String projectKey,
            @PathParam("id") @NotNull long id, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @Valid RestRequiredBuildConditionSetRequest dto);

    /**
     * Delete a required builds merge check. Deletes a required build existing merge check, given it's ID.
     * 
     * The authenticated user must have **REPO_ADMIN** permission for the target repository to delete a required build merge
     * check.
     *
     * @param projectKey     The project that the repository belongs to (not null)
     * @param id             (not null)
     * @param repositorySlug The repository being used (not null)
     */
    @DELETE
    @Path("required-builds/latest/projects/{projectKey}/repos/{repositorySlug}/condition/{id}")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "An empty response indicating the merge check was successfully deleted, or was never present."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete a required build merge check in this repository.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditionId_401.class),
                            mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete a required builds merge check")
    void deleteRequiredBuildsMergeCheck(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull long id,
            @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get required builds merge checks. Returns a page of required build merge checks that have been configured for this
     * repository.
     * 
     * The authenticated user must have **REPO_READ** permission for the target repository to request a page of required
     * build merge checks.
     *
     * @param projectKey     The project that the repository belongs to (not null)
     * @param repositorySlug The repository being used (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditions
     */
    @GET
    @Path("required-builds/latest/projects/{projectKey}/repos/{repositorySlug}/conditions")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The required build merge checks associated with the provided repository.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditions.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to request a page of required build merge checks in this repository.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditions_401.class)))
    })
    @Operation(summary = "Get required builds merge checks")
    _ResponseRequiredBuildsLatestProjectsProjectKeyReposRepositorySlugConditions getPageOfRequiredBuildsMergeChecks(
            @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug,
            @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);
}
