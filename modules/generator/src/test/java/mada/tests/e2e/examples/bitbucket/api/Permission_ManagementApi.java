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
import mada.tests.e2e.examples.bitbucket.dto.AdminPasswordUpdate;
import mada.tests.e2e.examples.bitbucket.dto.GroupAndUsers;
import mada.tests.e2e.examples.bitbucket.dto.GroupPickerContext;
import mada.tests.e2e.examples.bitbucket.dto.RestDetailedGroup;
import mada.tests.e2e.examples.bitbucket.dto.RestDetailedUser;
import mada.tests.e2e.examples.bitbucket.dto.RestErasedUser;
import mada.tests.e2e.examples.bitbucket.dto.RestUserDirectory;
import mada.tests.e2e.examples.bitbucket.dto.UserAndGroups;
import mada.tests.e2e.examples.bitbucket.dto.UserRename;
import mada.tests.e2e.examples.bitbucket.dto.UserUpdate;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroups;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsAddUsers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsAddUsers_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsAddUsers_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsMoreMembers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsMoreMembers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsMoreNonMembers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroupsMoreNonMembers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroups_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroups_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroups_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminGroups_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroups;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroupsNone;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroupsNone_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroups_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroups_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroups_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsGroups_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsersNone;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsersNone_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsers_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsers_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsers_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminPermissionsUsers_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUserDirectories_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersAddGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersAddGroups_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersAddGroups_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersCaptcha_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersCaptcha_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersCaptcha_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersCaptcha_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersCredentials_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersCredentials_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersCredentials_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersErasure_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersErasure_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersErasure_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersErasure_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersMoreMembers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersMoreMembers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersMoreNonMembers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersMoreNonMembers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersRemoveGroup_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersRemoveGroup_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersRemoveGroup_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersRename_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersRename_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsersRename_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsers_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsers_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsers_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestAdminUsers_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestGroups;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_403;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_409;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissions_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissions_404;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissions_409;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/latest")
public interface Permission_ManagementApi {

    /**
     * Get groups.
     *
     * Retrieve a page of groups.
     * The authenticated user must have <strong>LICENSED_USER</strong> permission or higher to call this resource.
     *
     * @param filter If specified only group names containing the supplied string will be returned. (optional)
     * @param start  Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit  Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminGroups
     */
    @GET
    @Path("/admin/groups")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of groups.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a licensed user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_401.class)))
    })
    @Operation(summary = "Get groups")
    _ResponseApiLatestAdminGroups getGroups_1(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Create group.
     *
     * Create a new group.
     * The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
     *
     * @param name Name of the group. (not null)
     * @return RestDetailedGroup
     */
    @POST
    @Path("/admin/groups")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The newly created group.",
                    content = @Content(schema = @Schema(implementation = RestDetailedGroup.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_401.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "A group with this name already exists.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_409.class)))
    })
    @Operation(summary = "Create group")
    RestDetailedGroup createGroup(@QueryParam("name") @NotNull String name);

    /**
     * Remove group.
     *
     * Deletes the specified group, removing them from the system. This also removes any permissions that may have been
     * granted to the group.
     * A user may not delete the last group that is granting them administrative permissions, or a group with greater
     * permissions than themselves.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param name The name identifying the group to delete. (not null)
     * @return RestDetailedGroup
     */
    @DELETE
    @Path("/admin/groups")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The deleted group.",
                    content = @Content(schema = @Schema(implementation = RestDetailedGroup.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_401.class))),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as the authenticated user has a lower permission level than the group being deleted.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_403.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified group does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_404.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would lower the authenticated user's permission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroups_409.class)))
    })
    @Operation(summary = "Remove group")
    RestDetailedGroup deleteGroup(@QueryParam("name") @NotNull String name);

    /**
     * Add multiple users to group.
     *
     * Add multiple users to a group.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param dto (optional)
     */
    @POST
    @Path("/admin/groups/add-users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "<em>All</em> the users were added to the group"),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsAddUsers_401.class))),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would exceed the server's licensing limit, or the groups permissions exceed the authenticated user's permission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsAddUsers_403.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user or group does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsAddUsers_404.class)))
    })
    @Operation(summary = "Add multiple users to group")
    void addUsersToGroup(@Valid GroupAndUsers dto);

    /**
     * Get group members.
     *
     * Retrieves a list of users that are members of a specified group. <p>The authenticated user must have the
     * <strong>LICENSED_USER</strong> permission to call this resource.
     *
     * @param filter  If specified only users with usernames, display names or email addresses containing the supplied string will be returned. (optional)
     * @param context The group which should be used to locate members. (not null)
     * @param start   Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit   Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminGroupsMoreMembers
     */
    @GET
    @Path("/admin/groups/more-members")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsMoreMembers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a licensed user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsMoreMembers_401.class)))
    })
    @Operation(summary = "Get group members")
    _ResponseApiLatestAdminGroupsMoreMembers findUsersInGroup(@QueryParam("filter") String filter, @QueryParam("context") @NotNull String context, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get members not in group.
     *
     * Retrieves a list of users that are <em>not</em> members of a specified group. <p>The authenticated user must have
     * the <strong>LICENSED_USER</strong> permission to call this resource.
     *
     * @param filter  If specified only users with usernames, display names or email addresses containing the supplied string will be returned. (optional)
     * @param context The group which should be used to locate members. (not null)
     * @param start   Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit   Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminGroupsMoreNonMembers
     */
    @GET
    @Path("/admin/groups/more-non-members")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsMoreNonMembers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a licensed user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminGroupsMoreNonMembers_401.class)))
    })
    @Operation(summary = "Get members not in group")
    _ResponseApiLatestAdminGroupsMoreNonMembers findUsersNotInGroup(@QueryParam("filter") String filter, @QueryParam("context") @NotNull String context, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get groups with a global permission.
     *
     * Retrieve a page of groups that have been granted at least one global permission.
     * The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
     *
     * @param filter If specified only group names containing the supplied string will be returned (optional)
     * @param start  Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit  Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminPermissionsGroups
     */
    @GET
    @Path("/admin/permissions/groups")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of groups and their highest global permissions.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_401.class)))
    })
    @Operation(summary = "Get groups with a global permission")
    _ResponseApiLatestAdminPermissionsGroups getGroupsWithAnyPermission(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Update global permission for group.
     *
     * Promote or demote a group's global permission level. Available global permissions are:
     * - LICENSED_USER - PROJECT_CREATE - ADMIN - SYS_ADMIN
     * See the <a href="https://confluence.atlassian.com/display/BitbucketServer/Global+permissions">Bitbucket Data
     * Center documentation</a> for a detailed explanation of what each permission entails.
     * The authenticated user must have:
     * - <strong>ADMIN</strong> permission or higher; and - the permission they are attempting to grant or higher; and -
     * greater or equal permissions than the current permission level of the group (a user may not demote the
     * permission level of a group with higher permissions than them)
     * to call this resource. In addition, a user may not demote a group's permission level if their own permission
     * level would be reduced as a result.
     *
     * @param name       The names of the groups (not null)
     * @param permission The permission to grant (not null)
     */
    @PUT
    @Path("/admin/permissions/groups")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The specified permission was granted to the specified user."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator or doesn't have the\nspecified permission they are attempting to grant.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would exceed the server's license limits.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified group does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would reduce the currently authenticated user's\npermission level or the currently authenticated user has a lower permission\nlevel than the group they are attempting to modify.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Update global permission for group")
    void setPermissionForGroups(@QueryParam("name") @NotNull List<String> name, @QueryParam("permission") @NotNull String permission);

    /**
     * Revoke all global permissions for group.
     *
     * Revoke all global permissions for a group.
     * The authenticated user must have:
     * - <strong>ADMIN</strong> permission or higher; and - greater or equal permissions than the current permission
     * level of the group (a user may not demote the     permission level of a group with higher permissions than them)
     * to call this resource. In addition, a user may not revoke a group's permissions if their own permission level
     * would be reduced as a result.
     *
     * @param name The name of the group (not null)
     */
    @DELETE
    @Path("/admin/permissions/groups")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All global permissions were revoked from the group."),
            @APIResponse(
                    responseCode = "401",
                    description = "TThe currently authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified group does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would reduce the currently authenticated user's\npermission level or the currently authenticated user has a lower permission\nlevel than the group they are attempting to modify.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroups_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke all global permissions for group")
    void revokePermissionsForGroup(@QueryParam("name") @NotNull String name);

    /**
     * Get groups with no global permission.
     *
     * Retrieve a page of groups that have no granted global permissions.
     * The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
     *
     * @param filter If specified only user names containing the supplied string will be returned (optional)
     * @param start  Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit  Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminPermissionsGroupsNone
     */
    @GET
    @Path("/admin/permissions/groups/none")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of groups that have not been granted any global permissions.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroupsNone.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsGroupsNone_401.class)))
    })
    @Operation(summary = "Get groups with no global permission")
    _ResponseApiLatestAdminPermissionsGroupsNone getGroupsWithoutAnyPermission(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get users with a global permission.
     *
     * Retrieve a page of users that have been granted at least one global permission.
     * The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
     *
     * @param filter If specified only user names containing the supplied string will be returned (optional)
     * @param start  Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit  Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminPermissionsUsers
     */
    @GET
    @Path("/admin/permissions/users")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users and their highest global permissions.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_401.class)))
    })
    @Operation(summary = "Get users with a global permission")
    _ResponseApiLatestAdminPermissionsUsers getUsersWithAnyPermission(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Update global permission for user.
     *
     * Promote or demote the global permission level of a user. Available global permissions are:
     * - LICENSED_USER - PROJECT_CREATE - ADMIN - SYS_ADMIN
     * See the <a href="https://confluence.atlassian.com/display/BitbucketServer/Global+permissions">Bitbucket Data
     * Center documentation</a> for a detailed explanation of what each permission entails.
     * The authenticated user must have:
     * - <strong>ADMIN</strong> permission or higher; and - the permission they are attempting to grant; and - greater
     * or equal permissions than the current permission level of the user (a user may not demote the     permission
     * level of a user with higher permissions than them)
     * to call this resource. In addition, a user may not demote their own permission level.
     *
     * @param name       The names of the users (not null)
     * @param permission The permission to grant (not null)
     */
    @PUT
    @Path("/admin/permissions/users")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The requested permission was granted."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator or doesn't have the\nspecified permission they are attempting to grant.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would exceed the server's license limits.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would reduce the currently authenticated user's\npermission level or the currently authenticated user has a lower permission\nlevel than the user they are attempting to modify.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Update global permission for user")
    void setPermissionForUsers(@QueryParam("name") @NotNull List<String> name, @QueryParam("permission") @NotNull String permission);

    /**
     * Revoke all global permissions for user.
     *
     * Revoke all global permissions for a user.
     * The authenticated user must have:
     * - <strong>ADMIN</strong> permission or higher; and - greater or equal permissions than the current permission
     * level of the user (a user may not demote the     permission level of a user with higher permissions than them)
     * to call this resource. In addition, a user may not demote their own permission level.
     *
     * @param name The name of the user (not null)
     */
    @DELETE
    @Path("/admin/permissions/users")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All global permissions were revoked from the user."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would reduce the currently authenticated user's\npermission level or the currently authenticated user has a lower permission\nlevel than the user they are attempting to modify.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsers_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke all global permissions for user")
    void revokePermissionsForUser(@QueryParam("name") @NotNull String name);

    /**
     * Get users with no global permission.
     *
     * Retrieve a page of users that have no granted global permissions.
     * The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
     *
     * @param filter If specified only user names containing the supplied string will be returned (optional)
     * @param start  Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit  Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminPermissionsUsersNone
     */
    @GET
    @Path("/admin/permissions/users/none")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users that have not been granted any global permissions.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsersNone.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminPermissionsUsersNone_401.class)))
    })
    @Operation(summary = "Get users with no global permission")
    _ResponseApiLatestAdminPermissionsUsersNone getUsersWithoutAnyPermission(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Get directories.
     *
     * Retrieve a list of active directories.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param includeInactive Set <code>true</code> to include inactive directories; otherwise, <code>false</code> to only return active directories. (optional)
     * @return RestUserDirectory
     */
    @GET
    @Path("/admin/user-directories")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A list of directories",
                    content = @Content(schema = @Schema(implementation = RestUserDirectory.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUserDirectories_401.class)))
    })
    @Operation(summary = "Get directories")
    RestUserDirectory getUserDirectories(@QueryParam("includeInactive") String includeInactive);

    /**
     * Get users.
     *
     * Retrieve a page of users.
     * The authenticated user must have the <strong>LICENSED_USER</strong> permission to call this resource.
     *
     * @param filter If specified only users with usernames, display name or email addresses containing the supplied string will be returned. (optional)
     * @param start  Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit  Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminUsers
     */
    @GET
    @Path("/admin/users")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a licensed user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_401.class)))
    })
    @Operation(summary = "Get users")
    _ResponseApiLatestAdminUsers getUsers_1(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Create user.
     *
     * Creates a new user from the assembled query parameters.
     * The default group can be used to control initial permissions for new users, such as granting users the ability to
     * login or providing read access to certain projects or repositories. If the user is not added to the default
     * group, they may not be able to login after their account is created until explicit permissions are configured.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param emailAddress      The e-mail address for the new user. (not null)
     * @param password          The password for the new user. Required if the <code>notify</code> parameter is not present or is set to <code>false</false> (optional)
     * @param addToDefaultGroup Set <code>true</code> to add the user to the default group, which can be used to grant them a set of initial permissions; otherwise, <code>false</code> to not add them to a group. (not null)
     * @param displayName       The display name for the new user. (not null)
     * @param name              The username for the new user. (not null)
     * @param notify            If present and not <code>false</code> instead of requiring a password, the create user will be notified via email their account has been created and requires a password to be reset. This option can only be used if a mail server has been configured. (not null)
     */
    @POST
    @Path("/admin/users")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The user was successfully created."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user is not an administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "Adding the user to the default group would exceed the server's license limit.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "Another user with the same name already exists.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Create user")
    void createUser(@QueryParam("emailAddress") @NotNull String emailAddress, @QueryParam("password") String password, @QueryParam("addToDefaultGroup") boolean addToDefaultGroup, @QueryParam("displayName") @NotNull String displayName, @QueryParam("name") @NotNull String name, @QueryParam("notify") boolean notify);

    /**
     * Update user details.
     *
     * Update a user's details.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param dto (optional)
     * @return RestDetailedUser
     */
    @PUT
    @Path("/admin/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The updated user.",
                    content = @Content(schema = @Schema(implementation = RestDetailedUser.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission or has a lower permission level than the user being updated.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_404.class)))
    })
    @Operation(summary = "Update user details")
    RestDetailedUser updateUserDetails(@Valid UserUpdate dto);

    /**
     * Remove user.
     *
     * Deletes the specified user, removing them from the system. This also removes any permissions that may have been
     * granted to the user.
     * A user may not delete themselves, and a user with <strong>ADMIN</strong> permissions may not delete a user with
     * <strong>SYS_ADMIN</strong>permissions.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param name The username identifying the user to delete. (not null)
     * @return RestDetailedUser
     */
    @DELETE
    @Path("/admin/users")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The deleted user.",
                    content = @Content(schema = @Schema(implementation = RestDetailedUser.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_401.class))),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as the authenticated user has a lower permission level than the user being deleted.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_403.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_404.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as a user can not delete themselves.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsers_409.class)))
    })
    @Operation(summary = "Remove user")
    RestDetailedUser deleteUser(@QueryParam("name") @NotNull String name);

    /**
     * Add user to groups.
     *
     * Add a user to one or more groups.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param dto (optional)
     */
    @POST
    @Path("/admin/users/add-groups")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The user was added to <em>all</em> the groups"),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersAddGroups_401.class))),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would exceed the server's licensing limit, or the groups permissions exceed the authenticated user's permission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersAddGroups_403.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user or group does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersAddGroups_404.class)))
    })
    @Operation(summary = "Add user to groups")
    void addUserToGroups(@Valid UserAndGroups dto);

    /**
     * Clear CAPTCHA for user.
     *
     * Clears any CAPTCHA challenge that may constrain the user with the supplied username when they authenticate.
     * Additionally any counter or metric that contributed towards the user being issued the CAPTCHA challenge (for
     * instance too many consecutive failed logins) will also be reset.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource, and may not clear
     * the CAPTCHA of a user with greater permissions than themselves.
     *
     * @param name The username (not null)
     */
    @DELETE
    @Path("/admin/users/captcha")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The CAPTCHA was successfully cleared."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersCaptcha_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersCaptcha_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as the authenticated user has a lower permission level than the user to clear captcha for.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersCaptcha_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersCaptcha_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Clear CAPTCHA for user")
    void clearUserCaptchaChallenge(@QueryParam("name") @NotNull String name);

    /**
     * Set password for user.
     *
     * Update a user's password.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource, and may not update
     * the password of a user with greater permissions than themselves.
     *
     * @param dto (optional)
     */
    @PUT
    @Path("/admin/users/credentials")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The user's password was successfully updated."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersCredentials_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission or has a lower permission level than the user having their password updated.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersCredentials_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersCredentials_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Set password for user")
    void updateUserPassword(@Valid AdminPasswordUpdate dto);

    /**
     * Check user removal.
     *
     * Validate if a user can be erased.
     * A username is only valid for erasure if it exists as the username of a deleted user. This endpoint will return an
     * appropriate error response if the supplied username is invalid for erasure.
     * This endpoint does <strong>not</strong> perform the actual user erasure, and will not modify the application in
     * any way.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param name The username of the user to validate erasability for. (not null)
     */
    @GET
    @Path("/admin/users/erasure")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "the user is erasable"),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed (e.g. if no username was supplied).",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission or has a lower permission level than the user being erased.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The requested username does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The requested username is the username of a not deleted user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Check user removal")
    void validateErasable(@QueryParam("name") @NotNull String name);

    /**
     * Erase user information.
     *
     * Erases personally identifying user data for a deleted user.
     * References in the application to the original username will be either removed or updated to a new non-identifying
     * username. Refer to the <a
     * href="https://confluence.atlassian.com/gdpr/bitbucket-right-to-erasure-949770560.html">support guide</a> for
     * details about what data is and isn't erased.
     * User erasure can only be performed on a deleted user. If the user has not been deleted first then this endpoint
     * will return a bad request and no erasure will be performed.
     * Erasing user data is <strong>irreversible</strong> and may lead to a degraded user experience. This method should
     * not be used as part of a standard user deletion and cleanup process.
     * Plugins can participate in user erasure by defining a <code>&lt;user-erasure-handler&gt;</code> module. If one or
     * more plugin modules fail, an error summary of the failing modules is returned.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param name The username identifying the user to erase. (not null)
     * @return RestErasedUser
     */
    @POST
    @Path("/admin/users/erasure")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The identifier of the erased user.",
                    content = @Content(schema = @Schema(implementation = RestErasedUser.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed (e.g. if no username was supplied).",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission or has a lower permission level than the user being erased.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The requested username does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_404.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "The requested username is the username of a not deleted user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersErasure_409.class)))
    })
    @Operation(summary = "Erase user information")
    RestErasedUser eraseUser(@QueryParam("name") @NotNull String name);

    /**
     * Get groups for user.
     *
     * Retrieves a list of users that are <em>not</em> members of a specified group. <p>The authenticated user must have
     * the <strong>LICENSED_USER</strong> permission to call this resource.
     *
     * @param filter  If specified only users with usernames, display names or email addresses containing the supplied string will be returned. (optional)
     * @param context The group which should be used to locate members. (not null)
     * @param start   Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit   Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminUsersMoreMembers
     */
    @GET
    @Path("/admin/users/more-members")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersMoreMembers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a licensed user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersMoreMembers_401.class)))
    })
    @Operation(summary = "Get groups for user")
    _ResponseApiLatestAdminUsersMoreMembers findGroupsForUser(@QueryParam("filter") String filter, @QueryParam("context") @NotNull String context, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Find other groups for user.
     *
     * Retrieves a list of groups the specified user is <em>not</em> a member of. <p>The authenticated user must have
     * the <strong>LICENSED_USER</strong> permission to call this resource.
     *
     * @param filter  If specified only groups with names containing the supplied string will be returned. (optional)
     * @param context The user which should be used to locate groups. (not null)
     * @param start   Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit   Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestAdminUsersMoreNonMembers
     */
    @GET
    @Path("/admin/users/more-non-members")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of groups.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersMoreNonMembers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a licensed user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersMoreNonMembers_401.class)))
    })
    @Operation(summary = "Find other groups for user")
    _ResponseApiLatestAdminUsersMoreNonMembers findOtherGroupsForUser(@QueryParam("filter") String filter, @QueryParam("context") @NotNull String context, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Remove user from group.
     *
     * Remove a user from a group. This is very similar to <code>groups/remove-user</code>, but with the
     * <em>context</em> and <em>itemName</em> attributes of the supplied request entity reversed. On the face of it this
     * may appear redundant, but it facilitates a specific UI component in the application.
     * In the request entity, the <em>context</em> attribute is the user and the <em>itemName</em> is the group.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param dto (optional)
     */
    @POST
    @Path("/admin/users/remove-group")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The user was removed from the group."),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersRemoveGroup_401.class))),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as the group has a higher permission level than the context user.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersRemoveGroup_403.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user or group does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersRemoveGroup_404.class)))
    })
    @Operation(summary = "Remove user from group")
    void removeGroupFromUser(@Valid GroupPickerContext dto);

    /**
     * Rename user.
     *
     * Rename a user.
     * The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
     *
     * @param dto (optional)
     * @return RestDetailedUser
     */
    @POST
    @Path("/admin/users/rename")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The renamed user.",
                    content = @Content(schema = @Schema(implementation = RestDetailedUser.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersRename_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The authenticated user does not have the <strong>ADMIN</strong> permission or has a lower permission level than the user being renamed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersRename_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified user does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestAdminUsersRename_404.class)))
    })
    @Operation(summary = "Rename user")
    RestDetailedUser renameUser(@Valid UserRename dto);

    /**
     * Get group names.
     *
     * Retrieve a page of group names.
     * The authenticated user must have <strong>LICENSED_USER</strong> permission or higher to call this resource.
     *
     * @param filter (optional)
     * @param start  Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit  Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestGroups
     */
    @GET
    @Path("/groups")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of group names.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestGroups.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a project administrator.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestGroups_401.class)))
    })
    @Operation(summary = "Get group names")
    _ResponseApiLatestGroups getGroups(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Revoke all repository permissions for users and groups.
     *
     * Revoke all permissions for the specified repository for the given groups and users.
     * The authenticated user must have <strong>PROJECT_ADMIN</strong> permission for the specified repository or a
     * higher global permission to call this resource.
     * In addition, a user may not revoke a group's permission if their own permission would be revoked as a result, nor
     * may they revoke their own permission unless they have a global permission that already implies that permission.
     *
     * @param projectKey     The project key. (not null)
     * @param user           The names of the users (optional)
     * @param repositorySlug The repository slug. (not null)
     * @param group          The names of the groups (optional)
     */
    @DELETE
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All repository permissions were revoked from the users and groups for the specified repository."),
            @APIResponse(
                    responseCode = "400",
                    description = "No permissions were revoked because the request was invalid. No users or groups were provided."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not an administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissions_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist, or one or more of the users or groups provided does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissions_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would revoke the currently authenticated user's permission on the repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissions_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke all repository permissions for users and groups")
    void revokePermissions_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("user") String user, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("group") String group);

    /**
     * Get groups with permission to repository.
     *
     * Retrieve a page of groups that have been granted at least one permission for the specified repository.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource.
     *
     * @param filter         If specified only group names containing the supplied string will be returned. (optional)
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups
     */
    @GET
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/groups")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of groups and their highest permissions for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_404.class)))
    })
    @Operation(summary = "Get groups with permission to repository")
    _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups getGroupsWithAnyPermission_2(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Update group repository permission.
     *
     * Promote or demote a group's permission level for the specified repository. Available repository permissions are:
     * - REPO_READ - REPO_WRITE - REPO_ADMIN
     * See the <a href="https://confluence.atlassian.com/display/BitbucketServer/Using+repository+permissions">Bitbucket
     * Data Center documentation</a> for a detailed explanation of what each permission entails.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource. In addition, a user may not demote a group's permission level
     * if their own permission level would be reduced as a result.
     *
     * @param projectKey     The project key. (not null)
     * @param name           The names of the groups. (not null)
     * @param permission     The permission to grant (not null)
     * @param repositorySlug The repository slug. (not null)
     */
    @PUT
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/groups")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The requested permission was granted."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would reduce the currently authenticated user's permission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Update group repository permission")
    void setPermissionForGroup(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") @NotNull List<String> name, @QueryParam("permission") @NotNull String permission, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Revoke group repository permission.
     *
     * Revoke all permissions for the specified repository for a group.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource.
     * In addition, a user may not revoke a group's permissions if it will reduce their own permission level.
     *
     * @param projectKey     The project key. (not null)
     * @param name           The name of the group. (not null)
     * @param repositorySlug The repository slug. (not null)
     */
    @DELETE
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/groups")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All repository permissions were revoked from the group for the specified repository."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would reduce the currently authenticated user's permission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroups_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke group repository permission")
    void revokePermissionsForGroup_2(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") @NotNull String name, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get groups without repository permission.
     *
     * Retrieve a page of groups that have no granted permissions for the specified repository.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource.
     *
     * @param filter         If specified only group names containing the supplied string will be returned. (optional)
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone
     */
    @GET
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/groups/none")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of groups that have not been granted any permissions for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone_404.class)))
    })
    @Operation(summary = "Get groups without repository permission")
    _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsGroupsNone getGroupsWithoutAnyPermission_2(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Search repository permissions.
     *
     * Search direct and implied permissions of users and groups. This endpoint returns a superset of the results
     * returned by the /users and /groups endpoints because it allows filtering by project and global permissions too.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project/global permission to call this resource.
     *
     * @param projectKey     The project key. (not null)
     * @param permission     Permissions to filter by. See the [permissions documentation](https://confluence.atlassian.com/display/BitbucketServer/Using+repository+permissions)for a detailed explanation of what each permission entails. This parameter can be specified multiple times to filter by more than one permission, and can contain repository, project, and global permissions.

 (optional)
     * @param filterText     Name of the user or group to filter the name of (optional)
     * @param type           Type of entity (user or group)Valid entity types are:

- USER- GROUP (optional)
     * @param repositorySlug The repository slug. (not null)
     */
    @GET
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/search")
    @Produces("application/json;charset=UTF-8")
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "default response")
    })
    @Operation(summary = "Search repository permissions")
    void searchPermissions_1(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("permission") String permission, @QueryParam("filterText") String filterText, @QueryParam("type") String type, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get users with permission to repository.
     *
     * Retrieve a page of users that have been granted at least one permission for the specified repository.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource.
     *
     * @param filter         If specified only user names containing the supplied string will be returned. (optional)
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers
     */
    @GET
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/users")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users and their highest permissions for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_404.class)))
    })
    @Operation(summary = "Get users with permission to repository")
    _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers getUsersWithAnyPermission_2(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

    /**
     * Update user repository permission.
     *
     * Promote or demote a user's permission level for the specified repository. Available repository permissions are:
     * - REPO_READ</li>- REPO_WRITE</li>- REPO_ADMIN</li></ul>See the <a
     * href="https://confluence.atlassian.com/display/BitbucketServer/Using+repository+permissions">Bitbucket Data
     * Center documentation</a> for a detailed explanation of what each permission entails.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource. In addition, a user may not reduce their own permission level
     * unless they have a project or global permission that already implies that permission.
     *
     * @param projectKey     The project key. (not null)
     * @param name           The names of the users. (not null)
     * @param permission     The permission to grant (not null)
     * @param repositorySlug The repository slug. (not null)
     */
    @PUT
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/users")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "The requested permission was granted."),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed or the specified permission does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_400.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "403",
                    description = "The action was disallowed as it would reduce the currently authenticated user's permission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_403.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_404.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Update user repository permission")
    void setPermissionForUser(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") @NotNull List<String> name, @QueryParam("permission") @NotNull String permission, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Revoke user repository permission.
     *
     * Revoke all permissions for the specified repository for a user.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource.
     * In addition, a user may not revoke their own repository permissions if they do not have a higher project or
     * global permission.
     *
     * @param projectKey     The project key. (not null)
     * @param name           The name of the user. (not null)
     * @param repositorySlug The repository slug. (not null)
     */
    @DELETE
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/users")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "All repository permissions were revoked from the user for the specified repository."),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_401.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_404.class), mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(
                    responseCode = "409",
                    description = "The action was disallowed as it would reduce the currently authenticated user's permission level.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsers_409.class), mediaType = MediaType.APPLICATION_JSON))
    })
    @Operation(summary = "Revoke user repository permission")
    void revokePermissionsForUser_2(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("name") @NotNull String name, @PathParam("repositorySlug") @NotNull String repositorySlug);

    /**
     * Get users without repository permission.
     *
     * Retrieve a page of <i>licensed</i> users that have no granted permissions for the specified repository.
     * The authenticated user must have <strong>REPO_ADMIN</strong> permission for the specified repository or a higher
     * project or global permission to call this resource.
     *
     * @param filter         If specified only user names containing the supplied string will be returned. (optional)
     * @param projectKey     The project key. (not null)
     * @param repositorySlug The repository slug. (not null)
     * @param start          Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit          Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone
     */
    @GET
    @Path("/projects/{projectKey}/repos/{repositorySlug}/permissions/users/none")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of users that have not been granted any permissions for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user is not a repository administrator for the specified repository.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone_401.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "The specified repository does not exist.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone_404.class)))
    })
    @Operation(summary = "Get users without repository permission")
    _ResponseApiLatestProjectsProjectKeyReposRepositorySlugPermissionsUsersNone getUsersWithoutPermission_1(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);
}
