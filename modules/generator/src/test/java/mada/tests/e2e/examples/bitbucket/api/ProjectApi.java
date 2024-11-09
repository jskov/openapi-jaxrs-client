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
import mada.tests.e2e.examples.bitbucket.dto.ExampleAvatarMultipartFormData;
import mada.tests.e2e.examples.bitbucket.dto.ExampleSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoDeclineSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoDeclineSettingsRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeProjectSettingsRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeRestrictedSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestBranch;
import mada.tests.e2e.examples.bitbucket.dto.RestDetailedInvocation;
import mada.tests.e2e.examples.bitbucket.dto.RestHookScriptConfig;
import mada.tests.e2e.examples.bitbucket.dto.RestHookScriptTriggers;
import mada.tests.e2e.examples.bitbucket.dto.RestInvocationHistory;
import mada.tests.e2e.examples.bitbucket.dto.RestMinimalRef;
import mada.tests.e2e.examples.bitbucket.dto.RestPermitted;
import mada.tests.e2e.examples.bitbucket.dto.RestProject;
import mada.tests.e2e.examples.bitbucket.dto.RestProjectSettingsRestriction;
import mada.tests.e2e.examples.bitbucket.dto.RestProjectSettingsRestrictionRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestPullRequestSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestRefRestriction;
import mada.tests.e2e.examples.bitbucket.dto.RestRepository;
import mada.tests.e2e.examples.bitbucket.dto.RestRepositoryHook;
import mada.tests.e2e.examples.bitbucket.dto.RestRestrictionRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestWebhook;
import mada.tests.e2e.examples.bitbucket.dto.RestWebhookCredentials;
import mada.tests.e2e.examples.bitbucket.dto.RestWebhookRequestResponse;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestHooksHookKeyAvatar_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestHooksHookKeyAvatar_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjects;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyAvatar_png_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyAvatar_png_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyHookScripts;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyHookScripts_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyHookScripts_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroups;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroupsNone_202;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroupsNone_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroupsNone_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroups_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroups_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroups_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsGroups_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsersNone;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsersNone_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsersNone_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsers_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsers_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsers_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissionsUsers_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissions_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissions_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyPermissions_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyRepos;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugContributing_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugContributing_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDefaultBranch_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugDefaultBranch_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLicense_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugLicense_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugReadme_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugReadme_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRecreate_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRecreate_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRecreate_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlug_204;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlug_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlug_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlug_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlug_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlug_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyRepos_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyRepos_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyRepos_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyRepos_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsAutoDecline_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsAutoDecline_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsAutoDecline_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsAutoMerge_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsAutoMerge_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsAutoMerge_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooks;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKey_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooksHookKey_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooks_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsHooks_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestrictionAll;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestrictionAll_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestrictionAll_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestrictionAll_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestriction_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestriction_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestriction_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeySettingsRestriction_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksTest_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksTest_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdLatest_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdLatest_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatisticsSummary_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatisticsSummary_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatistics_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatistics_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooks_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooks_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyWebhooks_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKey_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKey_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKey_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKey_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjects_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjects_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjects_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_404;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface ProjectApi {

    /**
     * Get project avatar.
     *
     * Retrieve the avatar for the project matching the supplied <strong>moduleKey</strong>.
     *
     * @param hookKey The complete module key of the hook module. (not null)
     * @param version (optional) Version used for HTTP caching only - any non-blank version will result in a large max-age Cache-Control header. Note that this does not affect the Last-Modified header. (optional)
     */
    @GET
    @Path("api/latest/hooks/{hookKey}/avatar")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The avatar of the project matching the supplied <strong>moduleKey</strong>."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestHooksHookKeyAvatar_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestHooksHookKeyAvatar_404.class)))
    })
    @Operation(summary = "Get project avatar")
    void getAvatar(@PathParam("hookKey") @NotNull String hookKey, @QueryParam("version") String version);

    /**
     * Get projects.
     *
     * Retrieve a page of projects.
     * Only projects for which the authenticated user has the <strong>PROJECT_VIEW</strong> permission will be returned.
     *
     * @param name       Name to filter by. (optional)
     * @param permission Permission to filter by (optional)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjects
     */
    @GET
    @Path("api/latest/projects")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of projects.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjects.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The permission level is unknown or not related to projects.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjects_400.class)))
    })
    @Operation(summary = "Get projects")
    _ResponseApiLatestProjects getProjects(@QueryParam("name") String name, @QueryParam("permission") String permission, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Create a new project.
     *
     * Create a new project.
     * To include a custom avatar for the project, the project definition should contain an additional attribute with
     * the key <code>avatar</code> and the value a data URI containing Base64-encoded image data. The URI should be in
     * the following format: <pre>    data:(content type, e.g. image/png);base64,(data) </pre>If the data is not
     * Base64-encoded, or if a character set is defined in the URI, or the URI is otherwise invalid, <em>project
     * creation will fail</em>.
     * The authenticated user must have <strong>PROJECT_CREATE</strong> permission to call this resource.
     *
     * @param dto The project. (optional)
     * @return RestProject
     */
    @POST
    @Path("api/latest/projects")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "201",
                    description = "The newly created project.",
                    content = @Content(schema = @Schema(implementation = RestProject.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The currently authenticated user has insufficient permissions to update the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjects_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create a project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjects_401.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "The project key or name is already in use.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjects_409.class)))
    })
    @Operation(summary = "Create a new project")
    RestProject createProject(@Valid RestProject dto);

    /**
     * Get a project.
     *
     * Retrieve the project matching the supplied <strong>projectKey</strong>.
     * The authenticated user must have <strong>PROJECT_VIEW</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @return RestProject
     */
    @GET
    @Path("api/latest/projects/{projectKey}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The project matching the supplied <strong>projectKey</strong>.",
                    content = @Content(schema = @Schema(implementation = RestProject.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_404.class)))
    })
    @Operation(summary = "Get a project")
    RestProject getProject(@PathParam("projectKey") @NotNull String projectKey);

    /**
     * Update project.
     *
     * Update the project matching the <strong>projectKey</strong> supplied in the resource path.
     * To include a custom avatar for the updated project, the project definition should contain an additional attribute
     * with the key <code>avatar</code> and the value a data URI containing Base64-encoded image data. The URI should be
     * in the following format: ```    data:(content type, e.g. image/png);base64,(data)```
     * If the data is not Base64-encoded, or if a character set is defined in the URI, or the URI is otherwise invalid,
     * <em>project creation will fail</em>.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param dto        Project parameters to update. (optional)
     * @return RestProject
     */
    @PUT
    @Path("api/latest/projects/{projectKey}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The updated project. The project's key <strong>was not</strong> updated.",
                    content = @Content(schema = @Schema(implementation = RestProject.class))),
            @APIResponse(
                    responseCode = "201",
                    description = "The updated project. The project's key <strong>was</strong> updated.",
                    content = @Content(schema = @Schema(implementation = RestProject.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The project was not updated due to a validation error.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to update the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_404.class)))
    })
    @Operation(summary = "Update project")
    RestProject updateProject(@PathParam("projectKey") @NotNull String projectKey, @Valid RestProject dto);

    /**
     * Delete project.
     *
     * Delete the project matching the supplied <strong>projectKey</strong>.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The project matching the supplied <strong>projectKey</strong> was deleted."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The project can not be deleted as it contains repositories.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKey_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete project")
    void deleteProject(@PathParam("projectKey") @NotNull String projectKey);

    /**
     * Get avatar for project.
     *
     * Retrieve the avatar for the project matching the supplied <strong>projectKey</strong>.
     * The authenticated user must have <strong>PROJECT_VIEW</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param s          The desired size of the image. The server will return an image as close as possible to the specified size. (optional)
     */
    @GET
    @Path("api/latest/projects/{projectKey}/avatar.png")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The avatar of the project matching the supplied <strong>projectKey</strong>."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyAvatar_png_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyAvatar_png_404.class)))
    })
    @Operation(summary = "Get avatar for project")
    void getProjectAvatar(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("s") String s);

    /**
     * Update project avatar.
     *
     * Update the avatar for the project matching the supplied <strong>projectKey</strong>.
     * This resource accepts POST multipart form data, containing a single image in a form-field named 'avatar'.
     * There are configurable server limits on both the dimensions (1024x1024 pixels by default) and uploaded file size
     * (1MB by default). Several different image formats are supported, but <strong>PNG</strong> and
     * <strong>JPEG</strong> are preferred due to the file size limit.
     * This resource has Cross-Site Request Forgery (XSRF) protection. To allow the request to pass the XSRF check the
     * caller needs to send an <code>X-Atlassian-Token</code> HTTP header with the value <code>no-check</code>.
     * An example <a href="http://curl.haxx.se/">curl</a> request to upload an image name 'avatar.png' would be: ```curl
     * -X POST -u username:password -H "X-Atlassian-Token: no-check"
     * http://example.com/rest/api/1.0/projects/STASH/avatar.png -F avatar=@avatar.png ```
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param dto        The mutlipart form data containing the file. (optional)
     */
    @POST
    @Path("api/latest/projects/{projectKey}/avatar.png")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "201",
                    description = "The avatar was uploaded successfully."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to update the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyAvatar_png_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyAvatar_png_404.class)))
    })
    @Operation(summary = "Update project avatar")
    void uploadAvatar(@PathParam("projectKey") @NotNull String projectKey, @Valid ExampleAvatarMultipartFormData dto);

    /**
     * Get configured hook scripts.
     *
     * Return a page of hook scripts configured for the specified project.
     * This endpoint requires **PROJECT_ADMIN** permission.
     *
     * @param projectKey The project key. (not null)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyHookScripts
     */
    @GET
    @Path("api/latest/projects/{projectKey}/hook-scripts")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of hook scripts.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScripts.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScripts_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScripts_404.class)))
    })
    @Operation(summary = "Get configured hook scripts")
    _ResponseApiLatestProjectsProjectKeyHookScripts getConfigurations(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Create/update a hook script.
     *
     * Creates/updates the hook script configuration for the provided hook script and project.
     * This endpoint requires **PROJECT_ADMIN** permission.
     *
     * @param projectKey The project key. (not null)
     * @param scriptId   The ID of the hook script (not null)
     * @param dto        The hook triggers for which the hook script should be run (optional)
     * @return RestHookScriptConfig
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/hook-scripts/{scriptId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The updated hook script.",
                    content = @Content(schema = @Schema(implementation = RestHookScriptConfig.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The hook script was not created/updated due to a validation error.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The project key supplied does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_404.class)))
    })
    @Operation(summary = "Create/update a hook script")
    RestHookScriptConfig setConfiguration(@PathParam("projectKey") @NotNull String projectKey, @PathParam("scriptId") @NotNull String scriptId, @Valid RestHookScriptTriggers dto);

    /**
     * Remove a hook script.
     *
     * Removes the hook script from the set of hook scripts configured to run in all repositories under the project.
     * This endpoint requires **PROJECT_ADMIN** permission.
     *
     * @param projectKey The project key. (not null)
     * @param scriptId   The ID of the hook script (not null)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/hook-scripts/{scriptId}")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The hook script was successfully deleted."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to view the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The project key or hook script ID supplied does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyHookScriptsScriptId_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Remove a hook script")
    void removeConfiguration(@PathParam("projectKey") @NotNull String projectKey, @PathParam("scriptId") @NotNull String scriptId);

    /**
     * Revoke project permissions.
     *
     * Revoke all permissions for the specified project for the given groups and users.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     * In addition, a user may not revoke a group's permission if their own permission would be revoked as a result, nor
     * may they revoke their own permission unless they have a global permission that already implies that permission.
     *
     * @param projectKey The project key (not null)
     * @param user       The names of the users (optional)
     * @param group      The names of the groups (optional)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/permissions")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All project permissions were revoked from the users and groups for the specified project."),
            @APIResponse(
                    responseCode = "400",
                    description = "No permissions were revoked because the request was invalid. No users or groups were provided."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specifiedspecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissions_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist, or one or more of the users or groups provided does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissions_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would revoke the currently authenticated user's permission on the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissions_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke project permissions")
    void revokePermissions(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("user") String user, @QueryParam("group") String group);

    /**
     * Get groups with permission to project.
     *
     * Retrieve a page of groups that have been granted at least one permission for the specified project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     *
     * @param filter     If specified only group names containing the supplied string will be returned (optional)
     * @param projectKey The project key (not null)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyPermissionsGroups
     */
    @GET
    @Path("api/latest/projects/{projectKey}/permissions/groups")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of groups and their highest permissions for the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a project administrator for the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_404.class)))
    })
    @Operation(summary = "Get groups with permission to project")
    _ResponseApiLatestProjectsProjectKeyPermissionsGroups getGroupsWithAnyPermission_1(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Update group project permission.
     *
     * Promote or demote a group's permission level for the specified project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource. In addition, a user may not demote a group's permission level if
     * theirown permission level would be reduced as a result.
     *
     * @param projectKey The project key (not null)
     * @param name       The names of the groups (optional)
     * @param permission The permission to grant.See the [permissions documentation](https://confluence.atlassian.com/display/BitbucketServer/Using+project+permissions)for a detailed explanation of what each permission entails. Available project permissions are:

- PROJECT_READ
- PROJECT_WRITE
- PROJECT_ADMIN


 (optional)
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/permissions/groups")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The requested permission was granted."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specifiedspecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would reduce the currently authenticated user'spermission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Update group project permission")
    void setPermissionForGroups_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") String name, @QueryParam("permission") String permission);

    /**
     * Revoke group project permission.
     *
     * Revoke all permissions for the specified project for a group.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     * In addition, a user may not revoke a group's permissions if it will reduce their own permission level.
     *
     * @param projectKey The project key (not null)
     * @param name       The name of the group (optional)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/permissions/groups")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All project permissions were revoked from the group for the specified project."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specifiedspecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = " The action was disallowed as it would reduce the currently authenticated user'spermission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroups_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke group project permission")
    void revokePermissionsForGroup_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") String name);

    /**
     * Get groups without project permission.
     *
     * Retrieve a page of groups that have no granted permissions for the specified project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     *
     * @param filter     If specified only group names containing the supplied string will be returned (optional)
     * @param projectKey The project key (not null)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     */
    @GET
    @Path("api/latest/projects/{projectKey}/permissions/groups/none")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "202",
                    description = "A page of groups that have not been granted any permissions for the specifiedproject.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroupsNone_202.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a project administrator for thespecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroupsNone_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsGroupsNone_404.class)))
    })
    @Operation(summary = "Get groups without project permission")
    void getGroupsWithoutAnyPermission_1(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Search project permissions.
     *
     * Search direct and implied permissions of principals (users and groups). This endpoint returns a superset of the
     * results returned by the /users and /groups endpoints because it allows filtering by global permissions too.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     *
     * @param projectKey The project key (not null)
     * @param permission Permissions to filter by. See the [permissions documentation](https://confluence.atlassian.com/display/BitbucketServer/Using+project+permissions)for a detailed explanation of what each permission entails. This parameter can be specified multiple times to filter by more than one permission, and can contain global and project permissions.

 (optional)
     * @param filterText Name of the user or group to filter the name of (optional)
     * @param type       Type of entity (user or group)Valid entity types are:

- USER- GROUP (optional)
     */
    @GET
    @Path("api/latest/projects/{projectKey}/permissions/search")
    @Produces("application/json;charset=UTF-8")
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "default response")
    })
    @Operation(summary = "Search project permissions")
    void searchPermissions(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("permission") String permission, @QueryParam("filterText") String filterText, @QueryParam("type") String type);

    /**
     * Get users with permission to project.
     *
     * Retrieve a page of users that have been granted at least one permission for the specified project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     *
     * @param filter     If specified only user names containing the supplied string will be returned (optional)
     * @param projectKey The project key (not null)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyPermissionsUsers
     */
    @GET
    @Path("api/latest/projects/{projectKey}/permissions/users")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users and their highest permissions for the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a project administrator for thespecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_404.class)))
    })
    @Operation(summary = "Get users with permission to project")
    _ResponseApiLatestProjectsProjectKeyPermissionsUsers getUsersWithAnyPermission_1(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Update user project permission.
     *
     * Promote or demote a user's permission level for the specified project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource. In addition, a user may not reduce their own permission level unless
     * they have a global permission that already implies that permission.
     *
     * @param projectKey The project key (not null)
     * @param name       The names of the users (optional)
     * @param permission The permission to grant.See the [permissions documentation](https://confluence.atlassian.com/display/BitbucketServer/Using+project+permissions)for a detailed explanation of what each permission entails. Available project permissions are:

- PROJECT_READ
- PROJECT_WRITE
- PROJECT_ADMIN


 (optional)
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/permissions/users")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The requested permission was granted."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specifiedspecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would reduce the currently authenticated user'spermission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Update user project permission")
    void setPermissionForUsers_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") String name, @QueryParam("permission") String permission);

    /**
     * Revoke user project permission.
     *
     * Revoke all permissions for the specified project for a user.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     * In addition, a user may not revoke their own project permissions if they do not have a higher global permission.
     *
     * @param projectKey The project key (not null)
     * @param name       The name of the user (optional)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/permissions/users")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All project permissions were revoked from the user for the specified project."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specifiedspecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = " The action was disallowed as it would reduce the currently authenticated user'spermission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsers_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke user project permission")
    void revokePermissionsForUser_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") String name);

    /**
     * Get users without project permission.
     *
     * Retrieve a page of <i>licensed</i> users that have no granted permissions for the specified project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     *
     * @param filter     If specified only user names containing the supplied string will be returned (optional)
     * @param projectKey The project key (not null)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyPermissionsUsersNone
     */
    @GET
    @Path("api/latest/projects/{projectKey}/permissions/users/none")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users that have not been granted any permissions for the specified project",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsersNone.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a project administrator for thespecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsersNone_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsUsersNone_404.class)))
    })
    @Operation(summary = "Get users without project permission")
    _ResponseApiLatestProjectsProjectKeyPermissionsUsersNone getUsersWithoutPermission(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Check default project permission.
     *
     * Check whether the specified permission is the default permission (granted to all users) for a project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     *
     * @param projectKey The project key (not null)
     * @param permission The permission to grant. Available project permissions are:

- PROJECT_READ
- PROJECT_WRITE
- PROJECT_ADMIN


 (not null)
     * @return RestPermitted
     */
    @GET
    @Path("api/latest/projects/{projectKey}/permissions/{permission}/all")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A simple entity indicating whether the specified permission is the defaultpermission for this project.",
                    content = @Content(schema = @Schema(implementation = RestPermitted.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specifiedspecified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_401.class))),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would reduce the currently authenticated user'spermission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_403.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_404.class)))
    })
    @Operation(summary = "Check default project permission")
    RestPermitted hasAllUserPermission(@PathParam("projectKey") @NotNull String projectKey, @PathParam("permission") @NotNull String permission);

    /**
     * Grant project permission.
     *
     * Grant or revoke a project permission to all users, i.e. set the default permission.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project or a higher
     * global permission to call this resource.
     *
     * @param allow      <em>true</em> to grant the specified permission to all users, or <em>false</em> to revoke it (optional)
     * @param projectKey The project key (not null)
     * @param permission The permission to grant. Available project permissions are:

- PROJECT_READ
- PROJECT_WRITE
- PROJECT_ADMIN


 (not null)
     */
    @POST
    @Path("api/latest/projects/{projectKey}/permissions/{permission}/all")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The requested permission was successfully granted or revoked."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyPermissionsPermissionAll_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Grant project permission")
    void modifyAllUserPermission(@QueryParam("allow") String allow, @PathParam("projectKey") @NotNull String projectKey, @PathParam("permission") @NotNull String permission);

    /**
     * Get repositories for project.
     *
     * Retrieve repositories from the project corresponding to the supplied <strong>projectKey</strong>.
     * The authenticated user must have <strong>PROJECT_READ</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyRepos
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The repositories matching the supplied <strong>projectKey</strong>.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyRepos.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to see the specified project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyRepos_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyRepos_404.class)))
    })
    @Operation(summary = "Get repositories for project")
    _ResponseApiLatestProjectsProjectKeyRepos getRepositories(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Create repository.
     *
     * Create a new repository. Requires an existing project in which this repository will be created. The only
     * parameters which will be used are name and scmId.
     * The authenticated user must have <strong>REPO_CREATE</strong> permission or higher, for the context project to
     * call this resource.
     *
     * @param projectKey The project key. (not null)
     * @param dto        The repository (optional)
     * @return RestRepository
     */
    @POST
    @Path("api/latest/projects/{projectKey}/repos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "201",
                    description = "The newly created repository.",
                    content = @Content(schema = @Schema(implementation = RestRepository.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The repository was not created due to a validation error.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyRepos_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create a repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyRepos_401.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "A repository with same name already exists.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyRepos_409.class)))
    })
    @Operation(summary = "Create repository")
    RestRepository createRepository(@PathParam("projectKey") @NotNull String projectKey, @Valid RestRepository dto);

    /**
     * Get repository.
     *
     * Retrieve the repository matching the supplied <strong>projectKey</strong> and <strong>repositorySlug</strong>.
     * The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this
     * resource.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @return RestRepository
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The repository which matches the supplied <strong>projectKey</strong> and <strong>repositorySlug</strong>.",
                    content = @Content(schema = @Schema(implementation = RestRepository.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to see the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_404.class)))
    })
    @Operation(summary = "Get repository")
    RestRepository getRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Fork repository.
     *
     * Create a new repository forked from an existing repository.
     * The JSON body for this <code>POST</code> is not required to contain <i>any</i> properties. Even the name may be
     * omitted. The following properties will be used, if provided:
     * - <code>"name":"Fork name"</code> - Specifies the forked repository's name   - Defaults to the name of the origin
     * repository if not specified - <code>"defaultBranch":"main"</code> - Specifies the forked repository's default
     * branch   - Defaults to the origin repository's default branch if not specified -
     * <code>"project":{"key":"TARGET_KEY"}</code> - Specifies the forked repository's target project by key   -
     * Defaults to the current user's personal project if not specified
     * The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository and
     * <strong>PROJECT_ADMIN</strong> on the target project to call this resource. Note that users <i>always</i> have
     * <b>PROJECT_ADMIN</b> permission on their personal projects.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param dto            The rest fork. (optional)
     * @return RestRepository
     */
    @POST
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "201",
                    description = "The newly created fork.",
                    content = @Content(schema = @Schema(implementation = RestRepository.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "A validation error prevented the fork from being created. Possible validation errors include: The name or slug for the fork collides with another repository in the target project; an SCM type was specified in the JSON body; a project was specified in the JSON body without a \"key\" property.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create a fork.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist, or, if a target project was specified, the target project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_404.class)))
    })
    @Operation(summary = "Fork repository")
    RestRepository forkRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestRepository dto);

    /**
     * Update repository.
     *
     * Update the repository matching the <strong>repositorySlug</strong> supplied in the resource path.
     * The repository's slug is derived from its name. If the name changes the slug may also change.
     * This resource can be used to change the repository's default branch by specifying a new default branch in the
     * request. For example: <code>"defaultBranch":"main"</code>
     * This resource can be used to move the repository to a different project by specifying a new project in the
     * request. For example: <code>"project":{"key":"NEW_KEY"}</code>
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this
     * resource.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param dto            The updated repository. (optional)
     * @return RestRepository
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "201",
                    description = "The updated repository.",
                    content = @Content(schema = @Schema(implementation = RestRepository.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The repository was not updated due to a validation error.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to update a repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_401.class))),
            @APIResponse(
                    responseCode = "403",
                    description = "Cannot archive repository because it has open pull requests.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_403.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_404.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "A repository with the same name as the target already exists, or the repository is archived.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_409.class)))
    })
    @Operation(summary = "Update repository")
    RestRepository updateRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestRepository dto);

    /**
     * Delete repository.
     *
     * Schedule the repository matching the supplied <strong>projectKey</strong> and <strong>repositorySlug</strong> to
     * be deleted.
     * The authenticated user must have sufficient permissions specified by the repository delete policy to call this
     * resource. The default permission required is <strong>REPO_ADMIN</strong> permission.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "202",
                    description = "The repository has been scheduled for deletion."),
            @APIResponse(
                    responseCode = "204",
                    description = "No repository matching the supplied <strong>projectKey</strong> and <strong>repositorySlug</strong> was found.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_204.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete the repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlug_401.class)))
    })
    @Operation(summary = "Delete repository")
    void deleteRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get repository contributing guidelines.
     *
     * Retrieves the contributing guidelines for the repository, if they've been defined.
     * This checks the repository for a CONTRIBUTING file, optionally with an md or txt extension, and, if found,
     * streams it. By default, the <i>raw content</i> of the file is streamed. Appending <code>?markup</code> to the URL
     * will stream an HTML-rendered version instead.
     * The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this
     * resource.
     *
     * @param projectKey       The project key. (not null)
     * @param at               A specific commit or ref to retrieve the guidelines at, or the default branch if not specified (optional)
     * @param markup           If present or <code>"true"</code>, triggers the raw content to be markup-rendered and returned as HTML; otherwise, if not specified, or any value other than <code>"true"</code>, the content is streamed without markup (optional)
     * @param htmlEscape       (Optional) true if HTML should be escaped in the input markup, false otherwise. If not specified, the value of the <code>markup.render.html.escape</code> property, which is <code>true</code> by default, will be used (optional)
     * @param includeHeadingId (Optional) true if headings should contain an ID based on the heading content. If not specified, the value of the <code>markup.render.headerids</code> property, which is false by default, will be used (optional)
     * @param hardwrap         (Optional) Whether the markup implementation should convert newlines to breaks. If not specified, the value of the <code>markup.render.hardwrap</code> property, which is <code>true</code> by default, will be used (optional)
     * @param repositorySlug   The repository slug. (not null)
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/contributing")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The contributing guidelines for the repository."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to read the repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugContributing_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugContributing_404.class)))
    })
    @Operation(summary = "Get repository contributing guidelines")
    void streamContributing(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @QueryParam("markup") String markup, @QueryParam("htmlEscape") String htmlEscape, @QueryParam("includeHeadingId") String includeHeadingId, @QueryParam("hardwrap") String hardwrap, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get repository default branch.
     *
     * Retrieves the repository's <i>configured</i> default branch.
     * Every repository has a <i>configured</i> default branch, but that branch may not actually <i>exist</i> in the
     * repository. For example, a newly-created repository will have a configured default branch even though no branches
     * have been pushed yet.
     * The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this
     * resource.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @return RestMinimalRef
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/default-branch")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The configured default branch for the repository.",
                    content = @Content(schema = @Schema(implementation = RestMinimalRef.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to read the repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDefaultBranch_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist, or its configured default branch does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDefaultBranch_404.class)))
    })
    @Operation(summary = "Get repository default branch")
    RestMinimalRef getDefaultBranch_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Update default branch for repository.
     *
     * Update the default branch of a repository.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository to call this
     * resource.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param dto            The branch to set as default (optional)
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/default-branch")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The default branch was updated."),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have permission to modify the default branch.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDefaultBranch_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugDefaultBranch_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Update default branch for repository")
    void setDefaultBranch_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestBranch dto);

    /**
     * Get repository forks.
     *
     * Retrieve repositories which have been forked from this one. Unlike #getRelatedRepositories(Repository,
     * PageRequest) related repositories, this only looks at a given repository's direct forks. If those forks have
     * themselves been the origin of more forks, such "grandchildren" repositories will not be retrieved.
     * Only repositories to which the authenticated user has <b>REPO_READ</b> permission will be included, even if other
     * repositories have been forked from this one.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/forks")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of repositories related to the request repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to see the request repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The request repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks_404.class)))
    })
    @Operation(summary = "Get repository forks")
    _ResponseApiLatestProjectsProjectKeyReposRepositorySlugForks getForkedRepositories(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get repository license.
     *
     * Retrieves the license for the repository, if it's been defined.
     * This checks the repository for a <pre>LICENSE</pre> file, optionally with an <pre>md</pre> or
     * <pre>txt</pre>extension, and, if found, streams it. By default, the <i>raw content</i> of the file is streamed.
     * Appending <pre>?markup</pre> to the URL will stream an HTML-rendered version instead.
     * The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this
     * resource.
     *
     * @param projectKey       The project key. (not null)
     * @param at               A specific commit or ref to retrieve the guidelines at, or the default branch if not specified (optional)
     * @param markup           If present or <code>"true"</code>, triggers the raw content to be markup-rendered and returned as HTML; otherwise, if not specified, or any value other than <code>"true"</code>, the content is streamed without markup (optional)
     * @param htmlEscape       (Optional) true if HTML should be escaped in the input markup, false otherwise. If not specified, the value of the <code>markup.render.html.escape</code> property, which is <code>true</code> by default, will be used (optional)
     * @param includeHeadingId (Optional) true if headings should contain an ID based on the heading content. If not specified, the value of the <code>markup.render.headerids</code> property, which is false by default, will be used (optional)
     * @param hardwrap         (Optional) Whether the markup implementation should convert newlines to breaks. If not specified, the value of the <code>markup.render.hardwrap</code> property, which is <code>true</code> by default, will be used (optional)
     * @param repositorySlug   The repository slug. (not null)
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/license")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The license for the repository."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to read the repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLicense_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugLicense_404.class)))
    })
    @Operation(summary = "Get repository license")
    void streamLicense(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @QueryParam("markup") String markup, @QueryParam("htmlEscape") String htmlEscape, @QueryParam("includeHeadingId") String includeHeadingId, @QueryParam("hardwrap") String hardwrap, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get repository readme.
     *
     * Retrieves the README for the repository, if it's been defined.
     * This checks the repository for a <pre>README</pre> file, optionally with an <pre>md</pre> or
     * <pre>txt</pre>extension, and, if found, streams it. By default, the <i>raw content</i> of the file is streamed.
     * Appending <pre>?markup</pre> to the URL will stream an HTML-rendered version instead. Note that, when streaming
     * HTML, relative URLs in the README will not work if applied relative to this URL.
     * The authenticated user must have <strong>REPO_READ</strong> permission for the specified repository to call this
     * resource.
     *
     * @param projectKey       The project key. (not null)
     * @param at               A specific commit or ref to retrieve the guidelines at, or the default branch if not specified (optional)
     * @param markup           If present or <code>"true"</code>, triggers the raw content to be markup-rendered and returned as HTML; otherwise, if not specified, or any value other than <code>"true"</code>, the content is streamed without markup (optional)
     * @param htmlEscape       (Optional) true if HTML should be escaped in the input markup, false otherwise. If not specified, the value of the <code>markup.render.html.escape</code> property, which is <code>true</code> by default, will be used (optional)
     * @param includeHeadingId (Optional) true if headings should contain an ID based on the heading content. If not specified, the value of the <code>markup.render.headerids</code> property, which is false by default, will be used (optional)
     * @param hardwrap         (Optional) Whether the markup implementation should convert newlines to breaks. If not specified, the value of the <code>markup.render.hardwrap</code> property, which is <code>true</code> by default, will be used (optional)
     * @param repositorySlug   The repository slug. (not null)
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/readme")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The README for the repository."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to read the repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugReadme_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugReadme_404.class)))
    })
    @Operation(summary = "Get repository readme")
    void streamReadme(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("at") String at, @QueryParam("markup") String markup, @QueryParam("htmlEscape") String htmlEscape, @QueryParam("includeHeadingId") String includeHeadingId, @QueryParam("hardwrap") String hardwrap, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Retry repository creation.
     *
     * If a create or fork operation fails, calling this method will clean up the broken repository and try again. The
     * repository must be in an INITIALISATION_FAILED state.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @return RestRepository
     */
    @POST
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/recreate")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The newly created repository.",
                    content = @Content(schema = @Schema(implementation = RestRepository.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The repository was not created due to a validation error.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRecreate_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create a repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRecreate_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRecreate_404.class)))
    })
    @Operation(summary = "Retry repository creation")
    RestRepository retryCreateRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get related repository.
     *
     * Retrieve repositories which are related to this one. Related repositories are from the same
     * Repository#getHierarchyId() hierarchy as this repository.
     * Only repositories to which the authenticated user has <b>REPO_READ</b> permission will be included, even if more
     * repositories are part of this repository's hierarchy.
     *
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated
     */
    @GET
    @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/related")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of repositories related to the request repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to see the request repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The request repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated_404.class)))
    })
    @Operation(summary = "Get related repository")
    _ResponseApiLatestProjectsProjectKeyReposRepositorySlugRelated getRelatedRepositories(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get enforcing project setting.
     *
     * Get a specified project settings restriction for the given namespace, feature key and component key. Note that
     * not providing the component key will **not** return restrictions for the namespace and feature key with a
     * component key set.
     * The authenticated user must have **PROJECT_VIEW** permission for the target project to retrieve a settings
     * restriction.
     *
     * @param projectKey   The project key. (not null)
     * @param namespace    The namespace used to identify the provider of the feature (not null)
     * @param componentKey The component key to uniquely identify individually restrictable subcomponents of a feature within the provided feature key and namespace (optional)
     * @param featureKey   The feature key to uniquely identify the feature within the provided namespace (not null)
     * @return RestProjectSettingsRestriction
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings-restriction")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The settings restriction associated with the provided namespace and feature key",
                    content = @Content(schema = @Schema(implementation = RestProjectSettingsRestriction.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The settings restriction could not be retrieved because the provided parameters were invalid. Possible issues include:\n\n- The namespace was not provided, or longer than 255 characters\n- The featureKey was not provided, or longer than 255 characters\n- The provided componentKey was fewer than 2 characters, or longer than 255 characters",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve a settings restriction",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project, or settings restriction does not exist",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_404.class)))
    })
    @Operation(summary = "Get enforcing project setting")
    RestProjectSettingsRestriction get_7(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("namespace") @NotNull String namespace, @QueryParam("componentKey") String componentKey, @QueryParam("featureKey") @NotNull String featureKey);

    /**
     * Enforce project restriction.
     *
     * Create a new project settings restriction for the given project.
     * The authenticated user must have **PROJECT_ADMIN** permission for the target project to create a settings
     * restriction.
     *
     * @param projectKey The project key. (not null)
     * @param dto        The project settings restriction to create (not null)
     * @return RestProjectSettingsRestriction
     */
    @POST
    @Path("api/latest/projects/{projectKey}/settings-restriction")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The settings restriction was successfully created",
                    content = @Content(schema = @Schema(implementation = RestProjectSettingsRestriction.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The settings restriction was not created because the request was invalid. Possible issues include:\n\n- The namespace was not provided, or longer than 255 characters\n- The featureKey was not provided, or longer than 255 characters\n- The provided componentKey was fewer than 2 characters, or longer than 255 characters",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create a settings restriction",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_404.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "A settings restriction with the same namespace, featureKey and componentKey already exists on this project",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_409.class)))
    })
    @Operation(summary = "Enforce project restriction")
    RestProjectSettingsRestriction create_3(@PathParam("projectKey") @NotNull String projectKey, @NotNull @Valid RestProjectSettingsRestrictionRequest dto);

    /**
     * Stop enforcing project restriction.
     *
     * Delete a specified project settings restriction.
     * If a restriction does not exist for the specified project, namespace, featureKey, and componentKey, the request
     * will be ignored and a 204 response will be returned.
     * The authenticated user must have **PROJECT_ADMIN** permission for the target project to delete a settings
     * restriction.
     *
     * @param projectKey   The project key. (not null)
     * @param namespace    A namespace used to identify the provider of the feature (not null)
     * @param componentKey A key to uniquely identify individually restrictable subcomponents of a feature within the provided feature key and namespace (optional)
     * @param featureKey   A key to uniquely identify the feature within the provided namespace (not null)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/settings-restriction")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The specified settings restriction was successfully deleted or there were no existing restrictions that match the specified criteria."),
            @APIResponse(
                    responseCode = "400",
                    description = "The settings restriction was not deleted because the request was invalid. Possible issues include:\n\n- The namespace was not provided, or longer than 255 characters\n- The featureKey was not provided, or longer than 255 characters\n- The provided componentKey was fewer than 2 characters, or longer than 255 characters",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete a settings restriction",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestriction_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Stop enforcing project restriction")
    void delete_9(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("namespace") @NotNull String namespace, @QueryParam("componentKey") String componentKey, @QueryParam("featureKey") @NotNull String featureKey);

    /**
     * Get all enforcing project settings.
     *
     * Get all project settings restrictions for the given namespace and feature key, including those with a component
     * key set.
     * The authenticated user must have **PROJECT_VIEW** permission for the target project to retrieve a settings
     * restrictions.
     *
     * @param projectKey The project key. (not null)
     * @param namespace  A namespace used to identify the provider of the feature (not null)
     * @param featureKey A key to uniquely identify the feature within the provided namespace (not null)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeySettingsRestrictionAll
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings-restriction/all")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of settings restrictions associated with the provided namespace and feature key",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestrictionAll.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The settings restrictions could not be retrieved because the provided parameters were invalid. Possible issues include:\n\n- The namespace was not provided, or longer than 255 characters\n- The featureKey was not provided, or longer than 255 characters",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestrictionAll_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve project settings restrictions",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestrictionAll_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsRestrictionAll_404.class)))
    })
    @Operation(summary = "Get all enforcing project settings")
    _ResponseApiLatestProjectsProjectKeySettingsRestrictionAll getAll(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("namespace") @NotNull String namespace, @QueryParam("featureKey") @NotNull String featureKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get auto decline settings.
     *
     * Retrieves the auto decline settings for the supplied project. Default settings are returned if no explicit
     * settings have been set for the project.
     *
     * @param projectKey The project key (not null)
     * @return RestAutoDeclineSettings
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings/auto-decline")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The auto decline settings",
                    content = @Content(schema = @Schema(implementation = RestAutoDeclineSettings.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve the auto decline settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoDecline_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoDecline_404.class)))
    })
    @Operation(summary = "Get auto decline settings")
    RestAutoDeclineSettings getAutoDeclineSettings(@PathParam("projectKey") @NotNull String projectKey);

    /**
     * Create/Update auto decline settings.
     *
     * Creates or updates the auto decline settings for the supplied project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for this project to call the resource.
     *
     * @param projectKey The project key (not null)
     * @param dto        The settings to create or update (optional)
     * @return RestAutoDeclineSettings
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/settings/auto-decline")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The auto decline settings",
                    content = @Content(schema = @Schema(implementation = RestAutoDeclineSettings.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "inactivityWeeks was not one of 1, 2, 4, 8, or, 12, or the enabled parameter was not included in the request.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoDecline_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create or update the auto decline settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoDecline_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoDecline_404.class)))
    })
    @Operation(summary = "Create/Update auto decline settings")
    RestAutoDeclineSettings setAutoDeclineSettings(@PathParam("projectKey") @NotNull String projectKey, @Valid RestAutoDeclineSettingsRequest dto);

    /**
     * Delete auto decline settings.
     *
     * Delete auto decline settings for the supplied project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for this project to call the resource.
     *
     * @param projectKey The project key (not null)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/settings/auto-decline")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The auto decline settings have been deleted successfully."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete the auto decline settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoDecline_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoDecline_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete auto decline settings")
    void deleteAutoDeclineSettings(@PathParam("projectKey") @NotNull String projectKey);

    /**
     * Get pull request auto-merge settings.
     *
     * Retrieves the pull request auto-merge settings for the supplied project. Default settings will be returned if no
     * explicit settings have been set for the project
     * The authenticated user must have <strong>PROJECT_VIEW</strong> permission for this project to call the resource.
     *
     * @param projectKey The project key (not null)
     * @return RestAutoMergeRestrictedSettings
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings/auto-merge")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The pull request auto-merge settings",
                    content = @Content(schema = @Schema(implementation = RestAutoMergeRestrictedSettings.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve the pull request auto-merge settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoMerge_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoMerge_404.class)))
    })
    @Operation(summary = "Get pull request auto-merge settings")
    RestAutoMergeRestrictedSettings get_4(@PathParam("projectKey") @NotNull String projectKey);

    /**
     * Create or update the pull request auto-merge settings.
     *
     * Creates or updates the pull request auto-merge settings for the supplied project, and applies the restriction
     * action specified in the request.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for this project to call the resource.
     *
     * @param projectKey The project key (not null)
     * @param dto        The settings to create or update (optional)
     * @return RestAutoMergeRestrictedSettings
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/settings/auto-merge")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The pull request auto-merge settings",
                    content = @Content(schema = @Schema(implementation = RestAutoMergeRestrictedSettings.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The 'enabled' and 'restrictionAction' fields were not provided correctly.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoMerge_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create or update the pull request auto-merge settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoMerge_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoMerge_404.class)))
    })
    @Operation(summary = "Create or update the pull request auto-merge settings")
    RestAutoMergeRestrictedSettings set(@PathParam("projectKey") @NotNull String projectKey, @Valid RestAutoMergeProjectSettingsRequest dto);

    /**
     * Delete pull request auto-merge settings.
     *
     * Deletes pull request auto-merge settings for the supplied project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for this project to call the resource.
     *
     * @param projectKey The project key (not null)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/settings/auto-merge")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The pull request auto-merge settings"),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete the pull request auto-merge settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoMerge_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsAutoMerge_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete pull request auto-merge settings")
    void delete_4(@PathParam("projectKey") @NotNull String projectKey);

    /**
     * Get repository hooks.
     *
     * Retrieve a page of repository hooks for this project.
     * The authenticated user must have <strong>PROJECT_READ</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param type       The optional type to filter by. (optional)
     * @param start      Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit      Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeySettingsHooks
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings/hooks")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of repository hooks with their associated enabled state.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooks.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve the hooks.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooks_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooks_404.class)))
    })
    @Operation(summary = "Get repository hooks")
    _ResponseApiLatestProjectsProjectKeySettingsHooks getRepositoryHooks(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("type") String type, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get a repository hook.
     *
     * Retrieve a repository hook for this project.
     * The authenticated user must have <strong>PROJECT_READ</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param hookKey    The hook key. (not null)
     * @return RestRepositoryHook
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings/hooks/{hookKey}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "Returns the repository hooks with their associated enabled state for the supplied hookKey.",
                    content = @Content(schema = @Schema(implementation = RestRepositoryHook.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to enable the hook.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKey_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository hook does not exist for the given project, or the project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKey_404.class)))
    })
    @Operation(summary = "Get a repository hook")
    RestRepositoryHook getRepositoryHook(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey);

    /**
     * Enable repository hook.
     *
     * Enable a repository hook for this project and optionally apply new configuration.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     * A JSON document may be provided to use as the settings for the hook. These structure and validity of the document
     * is decided by the plugin providing the hook.
     *
     * @param projectKey    The project key. (not null)
     * @param hookKey       The hook key. (not null)
     * @param contentLength The content length. (optional)
     * @return RestRepositoryHook
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/settings/hooks/{hookKey}/enabled")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The repository hooks with their associated enabled state for the supplied hookKey.",
                    content = @Content(schema = @Schema(implementation = RestRepositoryHook.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The settings specified are invalid.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to enable the hook.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project or hook does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_404.class)))
    })
    @Operation(summary = "Enable repository hook")
    RestRepositoryHook enableHook(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @HeaderParam("Content-Length") long contentLength);

    /**
     * Disable repository hook.
     *
     * Disable a repository hook for this project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param hookKey    The hook key. (not null)
     * @return RestRepositoryHook
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/settings/hooks/{hookKey}/enabled")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The repository hooks with their associated enabled state for the supplied hookKey.",
                    content = @Content(schema = @Schema(implementation = RestRepositoryHook.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to disable the hook.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project or hook does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeyEnabled_404.class)))
    })
    @Operation(summary = "Disable repository hook")
    RestRepositoryHook disableHook(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey);

    /**
     * Get repository hook settings.
     *
     * Retrieve the settings for a repository hook for this project.
     * The authenticated user must have <strong>PROJECT_READ</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param hookKey    The hook key. (not null)
     * @return ExampleSettings
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings/hooks/{hookKey}/settings")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The settings for the hook.",
                    content = @Content(schema = @Schema(implementation = ExampleSettings.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve the hook settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project or hook does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_404.class)))
    })
    @Operation(summary = "Get repository hook settings")
    ExampleSettings getSettings(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey);

    /**
     * Update repository hook settings.
     *
     * Modify the settings for a repository hook for this project.
     * The service will reject any settings which are too large, the current limit is 32KB once serialized.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     * A JSON document can be provided to use as the settings for the hook. These structure and validity of the document
     * is decided by the plugin providing the hook.
     *
     * @param projectKey The project key. (not null)
     * @param hookKey    The complete module key of the hook module. (not null)
     * @param dto        The raw settings. (optional)
     * @return ExampleSettings
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/settings/hooks/{hookKey}/settings")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The settings for the hook.",
                    content = @Content(schema = @Schema(implementation = ExampleSettings.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The settings specified are invalid.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to modify the hook settings.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project or hook does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsHooksHookKeySettings_404.class)))
    })
    @Operation(summary = "Update repository hook settings")
    ExampleSettings setSettings(@PathParam("projectKey") @NotNull String projectKey, @PathParam("hookKey") @NotNull String hookKey, @Valid ExampleSettings dto);

    /**
     * Get merge strategy.
     *
     * Retrieve the merge strategy configuration for this project and SCM.
     * The authenticated user must have <strong>PROJECT_READ</strong> permission for the context repository to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param scmId      The SCM to get strategies for. (not null)
     * @return RestPullRequestSettings
     */
    @GET
    @Path("api/latest/projects/{projectKey}/settings/pull-requests/{scmId}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The merge configuration of the request project.",
                    content = @Content(schema = @Schema(implementation = RestPullRequestSettings.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to see the request repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The request repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_404.class)))
    })
    @Operation(summary = "Get merge strategy")
    RestPullRequestSettings getPullRequestSettings(@PathParam("projectKey") @NotNull String projectKey, @PathParam("scmId") @NotNull String scmId);

    /**
     * Update merge strategy.
     *
     * Update the pull request merge strategy configuration for this project and SCM.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the context repository to call
     * this resource.
     * Only the strategies provided will be enabled, the default must be set and included in the set of strategies.
     * An explicitly set pull request merge strategy configuration can be deleted by POSTing a document with an empty
     * "mergeConfig" attribute. i.e: <pre>{     "mergeConfig": {} } </pre>
     * Upon completion of this request, the effective configuration will be the configuration explicitly set for the
     * SCM, or if no such explicit configuration is set then the default configuration will be used.
     *
     * @param projectKey The project key. (not null)
     * @param scmId      The SCM to get strategies for. (not null)
     * @param dto        The settings. (optional)
     * @return RestPullRequestSettings
     */
    @POST
    @Path("api/latest/projects/{projectKey}/settings/pull-requests/{scmId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The merge configuration of the request project.",
                    content = @Content(schema = @Schema(implementation = RestPullRequestSettings.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The repository pull request merge strategies were not updated due to a validation error.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to administrate the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeySettingsPullRequestsScmId_404.class)))
    })
    @Operation(summary = "Update merge strategy")
    RestPullRequestSettings updatePullRequestSettings(@PathParam("projectKey") @NotNull String projectKey, @PathParam("scmId") @NotNull String scmId, @Valid RestPullRequestSettings dto);

    /**
     * Find webhooks.
     *
     * Find webhooks in this project.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param event      List of <code>com.atlassian.webhooks.WebhookEvent</code> IDs to filter for (optional)
     * @param statistics <code>true</code> if statistics should be provided for all found webhooks (optional)
     */
    @GET
    @Path("api/latest/projects/{projectKey}/webhooks")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of webhooks."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to find webhooks in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooks_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooks_404.class)))
    })
    @Operation(summary = "Find webhooks")
    void findWebhooks(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("event") String event, @QueryParam("statistics") boolean statistics);

    /**
     * Create webhook.
     *
     * Create a webhook for the project specified via the URL.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param dto        The webhook to be created for this project. (optional)
     * @return RestWebhook
     */
    @POST
    @Path("api/latest/projects/{projectKey}/webhooks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A created webhook.",
                    content = @Content(schema = @Schema(implementation = RestWebhook.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The webhook parameters were invalid or not supplied.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooks_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to create webhooks in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooks_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooks_404.class)))
    })
    @Operation(summary = "Create webhook")
    RestWebhook createWebhook(@PathParam("projectKey") @NotNull String projectKey, @Valid RestWebhook dto);

    /**
     * Test webhook.
     *
     * Test connectivity to a specific endpoint.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey              The project key. (not null)
     * @param webhookId               (optional)
     * @param sslVerificationRequired (optional)
     * @param url                     The url in which to connect to (optional)
     * @param dto                     Basic authentication credentials, if required. (optional)
     * @return RestWebhookRequestResponse
     */
    @POST
    @Path("api/latest/projects/{projectKey}/webhooks/test")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A webhook.",
                    content = @Content(schema = @Schema(implementation = RestWebhookRequestResponse.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to test a connection.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksTest_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksTest_404.class)))
    })
    @Operation(summary = "Test webhook")
    RestWebhookRequestResponse testWebhook(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("webhookId") int webhookId, @QueryParam("sslVerificationRequired") boolean sslVerificationRequired, @QueryParam("url") String url, @Valid RestWebhookCredentials dto);

    /**
     * Get webhook.
     *
     * Get a webhook by ID.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param webhookId  ID of the webhook (not null)
     * @param statistics <code>true</code> if statistics should be provided for the webhook (optional)
     * @return RestWebhook
     */
    @GET
    @Path("api/latest/projects/{projectKey}/webhooks/{webhookId}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A webhook.",
                    content = @Content(schema = @Schema(implementation = RestWebhook.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to get a webhook in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The project does not exist, or the webhook does not exist in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_404.class)))
    })
    @Operation(summary = "Get webhook")
    RestWebhook getWebhook(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @QueryParam("statistics") String statistics);

    /**
     * Update webhook.
     *
     * Update an existing webhook.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param webhookId  Id of the existing webhook (not null)
     * @param dto        The representation of the updated values for the webhook (optional)
     * @return RestWebhook
     */
    @PUT
    @Path("api/latest/projects/{projectKey}/webhooks/{webhookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A webhook.",
                    content = @Content(schema = @Schema(implementation = RestWebhook.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to update a webhook in this project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The project does not exist, or the webhook does not exist in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_404.class)))
    })
    @Operation(summary = "Update webhook")
    RestWebhook updateWebhook(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @Valid RestWebhook dto);

    /**
     * Delete webhook.
     *
     * Delete a webhook for the project specified via the URL.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param webhookId  The ID of the webhook to be deleted. (not null)
     */
    @DELETE
    @Path("api/latest/projects/{projectKey}/webhooks/{webhookId}")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The webhook for the project has been deleted."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to delete webhooks in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist, or webhook does not exist in this project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookId_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete webhook")
    void deleteWebhook(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId);

    /**
     * Get last webhook invocation details.
     *
     * Get the latest invocations for a specific webhook.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param webhookId  ID of the webhook (not null)
     * @param event      The string ID of a specific event to retrieve the last invocation for. (optional)
     * @param outcome    The outcome to filter for. Can be SUCCESS, FAILURE, ERROR. None specified means that the all will be considered (optional)
     * @return RestDetailedInvocation
     */
    @GET
    @Path("api/latest/projects/{projectKey}/webhooks/{webhookId}/latest")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A webhook invocation dataset.",
                    content = @Content(schema = @Schema(implementation = RestDetailedInvocation.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to get webhook invocations in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdLatest_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist, or the webhook does not exist in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdLatest_404.class)))
    })
    @Operation(summary = "Get last webhook invocation details")
    RestDetailedInvocation getLatestInvocation(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @QueryParam("event") String event, @QueryParam("outcome") String outcome);

    /**
     * Get webhook statistics.
     *
     * Get the statistics for a specific webhook.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param webhookId  ID of the webhook (not null)
     * @param event      The string ID of a specific event to retrieve the last invocation for. May be empty, in which case all events are considered (optional)
     * @return RestInvocationHistory
     */
    @GET
    @Path("api/latest/projects/{projectKey}/webhooks/{webhookId}/statistics")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A webhook invocation dataset.",
                    content = @Content(schema = @Schema(implementation = RestInvocationHistory.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to get webhook statistics in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatistics_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified project does not exist, or the webhook does not exist in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatistics_404.class)))
    })
    @Operation(summary = "Get webhook statistics")
    RestInvocationHistory getStatistics(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId, @QueryParam("event") String event);

    /**
     * Get webhook statistics summary.
     *
     * Get the statistics summary for a specific webhook.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified project to call this
     * resource.
     *
     * @param projectKey The project key. (not null)
     * @param webhookId  ID of the webhook (not null)
     * @return RestInvocationHistory
     */
    @GET
    @Path("api/latest/projects/{projectKey}/webhooks/{webhookId}/statistics/summary")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A webhook invocation dataset.",
                    content = @Content(schema = @Schema(implementation = RestInvocationHistory.class))),
            @APIResponse(
                    responseCode = "204",
                    description = "No webhook invocations exist."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to get webhook statistics summary in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatisticsSummary_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The project does not exist, or the webhook does not exist in the project.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyWebhooksWebhookIdStatisticsSummary_404.class)))
    })
    @Operation(summary = "Get webhook statistics summary")
    RestInvocationHistory getStatisticsSummary(@PathParam("projectKey") @NotNull String projectKey, @PathParam("webhookId") @NotNull String webhookId);

    /**
     * Search for ref restrictions.
     *
     * Search for restrictions using the supplied parameters.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission or higher to call this resource. Only
     * authenticated users may call this resource.
     *
     * @param projectKey  The project key. (not null)
     * @param matcherType Matcher type to filter on (optional)
     * @param matcherId   Matcher id to filter on. Requires the matcherType parameter to be specified also. (optional)
     * @param type        Types of restrictions to filter on. (optional)
     * @param start       Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit       Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions
     */
    @GET
    @Path("branch-permissions/latest/projects/{projectKey}/restrictions")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A response containing a page of restrictions.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request has failed validation.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not permitted to get restrictions on the provided project",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "No restriction exists for the provided ID.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_404.class)))
    })
    @Operation(summary = "Search for ref restrictions")
    _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions getRestrictions(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("matcherType") String matcherType, @QueryParam("matcherId") String matcherId, @QueryParam("type") String type, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Create multiple ref restrictions.
     *
     * Allows creating multiple restrictions at once.
     *
     * @param projectKey The project key. (not null)
     * @param dto        The request containing a list of the details of the restrictions to create. (optional)
     * @return RestRefRestriction
     */
    @POST
    @Path("branch-permissions/latest/projects/{projectKey}/restrictions")
    @Consumes("application/vnd.atl.bitbucket.bulk+json")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "Response contains the ref restriction that was just created.",
                    content = @Content(schema = @Schema(implementation = RestRefRestriction.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request has failed validation.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to perform this operation.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictions_401.class)))
    })
    @Operation(summary = "Create multiple ref restrictions")
    RestRefRestriction createRestrictions(@PathParam("projectKey") @NotNull String projectKey, @Valid List<RestRestrictionRequest> dto);

    /**
     * Get a ref restriction.
     *
     * Returns a restriction as specified by a restriction id.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission or higher to call this resource. Only
     * authenticated users may call this resource.
     *
     * @param projectKey The project key. (not null)
     * @param id         The restriction id. (not null)
     * @return RestRefRestriction
     */
    @GET
    @Path("branch-permissions/latest/projects/{projectKey}/restrictions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A response containing the restriction.",
                    content = @Content(schema = @Schema(implementation = RestRefRestriction.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request has failed validation.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not permitted to get restrictions on the provided project",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "No restriction exists for the provided ID.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_404.class)))
    })
    @Operation(summary = "Get a ref restriction")
    RestRefRestriction getRestriction(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

    /**
     * Delete a ref restriction.
     *
     * Deletes a restriction as specified by a restriction id.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission or higher to call this resource. Only
     * authenticated users may call this resource.
     *
     * @param projectKey The project key. (not null)
     * @param id         The restriction id. (not null)
     */
    @DELETE
    @Path("branch-permissions/latest/projects/{projectKey}/restrictions/{id}")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "An empty response indicating that the operation was successful"),
            @APIResponse(
                    responseCode = "400",
                    description = "The request has failed validation.",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not permitted to delete restrictions on the provided project",
                    content = @Content(schema = @Schema(implementation = _ResponseBranchPermissionsLatestProjectsProjectKeyRestrictionsId_401.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Delete a ref restriction")
    void deleteRestriction(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);
}
