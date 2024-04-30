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
import mada.tests.e2e.examples.bitbucket.dto.ExampleAvatarMultipartFormData;
import mada.tests.e2e.examples.bitbucket.dto.ExamplePostMultipartFormData;
import mada.tests.e2e.examples.bitbucket.dto.ExamplePreviewMigration;
import mada.tests.e2e.examples.bitbucket.dto.ExamplePutMultipartFormData;
import mada.tests.e2e.examples.bitbucket.dto.ExampleSettingsMap;
import mada.tests.e2e.examples.bitbucket.dto.RestAnnouncementBanner;
import mada.tests.e2e.examples.bitbucket.dto.RestApplicationProperties;
import mada.tests.e2e.examples.bitbucket.dto.RestApplicationUser;
import mada.tests.e2e.examples.bitbucket.dto.RestBitbucketLicense;
import mada.tests.e2e.examples.bitbucket.dto.RestBulkUserRateLimitSettingsUpdateRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestClusterInformation;
import mada.tests.e2e.examples.bitbucket.dto.RestErrors;
import mada.tests.e2e.examples.bitbucket.dto.RestExportRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestHookScript;
import mada.tests.e2e.examples.bitbucket.dto.RestImportRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestJob;
import mada.tests.e2e.examples.bitbucket.dto.RestLabel;
import mada.tests.e2e.examples.bitbucket.dto.RestLogLevel;
import mada.tests.e2e.examples.bitbucket.dto.RestMailConfiguration;
import mada.tests.e2e.examples.bitbucket.dto.RestMeshConnectivityReport;
import mada.tests.e2e.examples.bitbucket.dto.RestMeshMigrationRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestMeshMigrationSummary;
import mada.tests.e2e.examples.bitbucket.dto.RestMeshNode;
import mada.tests.e2e.examples.bitbucket.dto.RestNamedLink;
import mada.tests.e2e.examples.bitbucket.dto.RestRateLimitSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestRepositoryPolicy;
import mada.tests.e2e.examples.bitbucket.dto.RestScopesExample;
import mada.tests.e2e.examples.bitbucket.dto.RestSshKeySettings;
import mada.tests.e2e.examples.bitbucket.dto.RestUserRateLimitSettings;
import mada.tests.e2e.examples.bitbucket.dto.RestUserRateLimitSettingsUpdateRequest;
import mada.tests.e2e.examples.bitbucket.dto.UserPasswordUpdate;
import mada.tests.e2e.examples.bitbucket.dto.UserUpdate;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface System_MaintenanceApi {

  /**
   * Get global SSH key settings.
   * Gets the global settings that enforce the maximum expiry of SSH keys and restrictions on SSH key types.
   *
   * @return RestSshKeySettings
   */
  @GET
  @Path("admin")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The global ssh key settings configuration.",
                 content = @Content(schema = @Schema(implementation = RestSshKeySettings.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the ssh keys global settings configuration.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get global SSH key settings")
  RestSshKeySettings getGlobalSettings();

  /**
   * Update global SSH key settings.
   * Updates the global settings that enforces the maximum expiry of SSH keys and restrictions on SSH key types.
   *
   * @param dto A request containing expiry length to be set for SSH keys and a list of SSH key type restrictions. (optional)
   */
  @PUT
  @Path("admin")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The ssh key global settings were updated."),
    @APIResponse(responseCode = "400", description = "The request was invalid, which may be due to:\n\n\n- attempted to set expiry to less than 1 day\n- attempted to set expiry using partial days\n- attempted to set a restriction on a key type which was invalid\n\n\nThe exact reason for the error will be provided in the error message.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update these settings.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Update global SSH key settings")
  void updateGlobalSettings(@Valid RestSshKeySettings dto);

  /**
   * Get supported SSH key algorithms and lengths.
   * Retrieves a list of all supported SSH key algorithms and lengths.
   */
  @GET
  @Path("admin/supported-key-types")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A list of supported SSH key algorithms and lengths."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve this list.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get supported SSH key algorithms and lengths")
  void getSupportedKeyTypes();

  /**
   * Get announcement banner.
   * Gets the announcement banner, if one exists and is available to the user
   *
   * @return RestAnnouncementBanner
   */
  @GET
  @Path("api/latest/admin/banner")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested banner",
                 content = @Content(schema = @Schema(implementation = RestAnnouncementBanner.class))),
    @APIResponse(responseCode = "204", description = "There is no banner to display"),
    @APIResponse(responseCode = "401", description = "The user does not have permission to access the banner service through this endpoint",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get announcement banner")
  RestAnnouncementBanner getBanner();

  /**
   * Update/Set announcement banner.
   * Sets the announcement banner with the provided JSON.
Only users authenticated as Admins may call this resource
   *
   * @param dto  (optional)
   */
  @PUT
  @Path("api/latest/admin/banner")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The banner was set successfully"),
    @APIResponse(responseCode = "400", description = "There was malformed or incorrect data in the provided JSON",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The user does not have permission to access the banner service through this endpoint",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Update/Set announcement banner")
  void setBanner(Object dto);

  /**
   * Delete announcement banner.
   * Deletes a banner, if one is present in the database.
   */
  @DELETE
  @Path("api/latest/admin/banner")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The query executed successfully, whether a banner was deleted or not"),
    @APIResponse(responseCode = "401", description = "The user does not have permission to access the banner service through this endpoint",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete announcement banner")
  void deleteBanner();

  /**
   * Get cluster node information.
   * Gets information about the nodes that currently make up the stash cluster.

The authenticated user must have the <strong>SYS_ADMIN</strong> permission to call this resource.
   *
   * @return RestClusterInformation
   */
  @GET
  @Path("api/latest/admin/cluster")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing information about the cluster",
                 content = @Content(schema = @Schema(implementation = RestClusterInformation.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the cluster information.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get cluster node information")
  RestClusterInformation getInformation();

  /**
   * Get the default branch.
   * Retrieves the configured global default branch, which is used when creating new repositories if an explicit default branch is not specified.

The user must be authenticated to call this resource.
   */
  @GET
  @Path("api/latest/admin/default-branch")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The configured global default branch."),
    @APIResponse(responseCode = "404", description = "No global default branch has been configured.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get the default branch")
  void getDefaultBranch();

  /**
   * Update/Set default branch.
   * Configures the global default branch, which is used when creating new repositories if an explicit default branch is not specified.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.
   *
   * @param dto  (optional)
   */
  @PUT
  @Path("api/latest/admin/default-branch")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The default branch has been set."),
    @APIResponse(responseCode = "401", description = "The current user does not have sufficient permissions to configure the global default branch.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Update/Set default branch")
  void setDefaultBranch(Object dto);

  /**
   * Clear default branch.
   * Clears the global default branch, which is used when creating new repositories if an explicit default branch is not specified, if one has been configured.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.
   */
  @DELETE
  @Path("api/latest/admin/default-branch")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The default branch has been cleared."),
    @APIResponse(responseCode = "401", description = "The current user does not have sufficient permissions to clear the global default branch.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Clear default branch")
  void clearDefaultBranch();

  /**
   * Get the control plane PEM.
   * Obtain the control plane PEM.

The authenticated user must have **SYS_ADMIN** permission.
   */
  @GET
  @Path("api/latest/admin/git/mesh/config/control-plane.pem")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The control plane PEM."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = RestErrors.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Get the control plane PEM")
  void getControlPlanePublicKey();

  /**
   * Generate Mesh connectivity report.
   * Generates a connectivity report between the Bitbucket node(s) and the Mesh node(s).

The authenticated user must have **SYS_ADMIN** permission.
   *
   * @return RestMeshConnectivityReport
   */
  @GET
  @Path("api/latest/admin/git/mesh/diagnostics/connectivity")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The connectivity report between the Bitbucket node(s) and Mesh node(s).",
                 content = @Content(schema = @Schema(implementation = RestMeshConnectivityReport.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Generate Mesh connectivity report")
  RestMeshConnectivityReport connectivity();

  /**
   * Get all registered Mesh nodes.
   * Get all the registered Mesh nodes.

The authenticated user must have **SYS_ADMIN** permission.
   *
   * @return RestMeshNode
   */
  @GET
  @Path("api/latest/admin/git/mesh/nodes")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The list of registered Mesh nodes.",
                 content = @Content(schema = @Schema(implementation = RestMeshNode.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get all registered Mesh nodes")
  RestMeshNode getAllRegisteredMeshNodes();

  /**
   * Register new Mesh node.
   * Register a new Mesh node.

The authenticated user must have **SYS_ADMIN** permission.
   *
   * @param dto The request specifying the new Mesh node. (optional)
   * @return RestMeshNode
   */
  @POST
  @Path("api/latest/admin/git/mesh/nodes")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly registered Mesh node.",
                 content = @Content(schema = @Schema(implementation = RestMeshNode.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Register new Mesh node")
  RestMeshNode registerNewMeshNode(@Valid RestMeshNode dto);

  /**
   * Get Mesh node.
   * Get the registered Mesh node that matches the supplied ID.

The authenticated user must have **SYS_ADMIN** permission.
   *
   * @param id The ID of the Mesh node. (not null)
   * @return RestMeshNode
   */
  @GET
  @Path("api/latest/admin/git/mesh/nodes/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The Mesh node that matches the ID.",
                 content = @Content(schema = @Schema(implementation = RestMeshNode.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The Mesh node does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get Mesh node")
  RestMeshNode getRegisteredMeshNodeById(@PathParam("id") @NotNull String id);

  /**
   * Update Mesh node.
   * Update a Mesh node.

The authenticated user must have **SYS_ADMIN** permission.
   *
   * @param id The ID of the Mesh node to update. (not null)
   * @param dto The request specifying the updated Mesh node. (optional)
   * @return RestMeshNode
   */
  @PUT
  @Path("api/latest/admin/git/mesh/nodes/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated Mesh node.",
                 content = @Content(schema = @Schema(implementation = RestMeshNode.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update Mesh node")
  RestMeshNode updateMeshNode(@PathParam("id") @NotNull String id, @Valid RestMeshNode dto);

  /**
   * Delete Mesh node.
   * Delete a Mesh node

The authenticated user must have **SYS_ADMIN** permission.
   *
   * @param force  (optional)
   * @param id  (not null)
   */
  @DELETE
  @Path("api/latest/admin/git/mesh/nodes/{id}")
  @Produces("application/json;charset=UTF-8")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response")
  })
  @Operation(summary = "Delete Mesh node")
  void delete_2(@QueryParam("force") boolean force, @PathParam("id") @NotNull long id);

  /**
   * Get support zips for all Mesh nodes.
   * Get the support zips for all the Mesh nodes.

The authenticated user must have **SYS_ADMIN** permission.
   */
  @GET
  @Path("api/latest/admin/git/mesh/support-zips")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The support zips for all the Mesh nodes."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = RestErrors.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Get support zips for all Mesh nodes")
  void getSupportZips();

  /**
   * Get support zip for node.
   * Get the support zip for the Mesh node that matches the specified ID.

The authenticated user must have **SYS_ADMIN** permission.
   *
   * @param id The ID of the Mesh node. (not null)
   */
  @GET
  @Path("api/latest/admin/git/mesh/support-zips/{id}")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The support zip for the Mesh node that matches the ID."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = RestErrors.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The Mesh node does not exist.",
                 content = @Content(schema = @Schema(implementation = RestErrors.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Get support zip for node")
  void getSupportZip(@PathParam("id") @NotNull String id);

  /**
   * Get license details.
   * Retrieves details about the current license, as well as the current status of the system with regards to the installed license. The status includes the current number of users applied toward the license limit, as well as any status messages about the license (warnings about expiry or user counts exceeding license limits).

The authenticated user must have <b>ADMIN</b> permission. Unauthenticated users, and non-administrators, are not permitted to access license details.
   *
   * @return RestBitbucketLicense
   */
  @GET
  @Path("api/latest/admin/license")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The currently-installed license.",
                 content = @Content(schema = @Schema(implementation = RestBitbucketLicense.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the license, or the request is anonymous.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "No license has been installed.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get license details")
  RestBitbucketLicense get_2();

  /**
   * Update license.
   * Decodes the provided encoded license and sets it as the active license. If no license was provided, a 400 is returned. If the license cannot be decoded, or cannot be applied, a 409 is returned. Some possible reasons a license may not be applied include:

- It is for a different product
- It is already expired


Otherwise, if the license is updated successfully, details for the new license are returned with a 200 response.

<b>Warning</b>: It is possible to downgrade the license during update, applying a license with a lower number of permitted users. If the number of currently-licensed users exceeds the limits of the new license, pushing will be disabled until the licensed user count is brought into compliance with the new license.

The authenticated user must have <b>SYS_ADMIN</b> permission. <b>ADMIN</b> users may <i>view</i> the current license details, but they may not <i>update</i> the license.
   *
   * @param dto a JSON payload containing the encoded license to apply (optional)
   * @return RestBitbucketLicense
   */
  @POST
  @Path("api/latest/admin/license")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly-installed license.",
                 content = @Content(schema = @Schema(implementation = RestBitbucketLicense.class))),
    @APIResponse(responseCode = "400", description = "No encoded license was provided in the JSON body for the POST.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the license.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "409", description = "The encoded license could not be decoded, or it is not valid for use on this server. Some possible reasons a license may not be applied include: it may be for a different product, it may have already expired, or this Bitbucket version doesn't support Server licenses.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update license")
  RestBitbucketLicense updateLicense(@Valid RestBitbucketLicense dto);

  /**
   * Get mail configuration.
   * Retrieves the current mail configuration.

The authenticated user must have the <strong>SYS_ADMIN</strong> permission to call this resource.
   *
   * @return RestMailConfiguration
   */
  @GET
  @Path("api/latest/admin/mail-server")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The mail configuration",
                 content = @Content(schema = @Schema(implementation = RestMailConfiguration.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the mail configuration.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The mail server hasn't been configured",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get mail configuration")
  RestMailConfiguration getMailConfig();

  /**
   * Update mail configuration.
   * Updates the mail configuration.

The authenticated user must have the <strong>SYS_ADMIN</strong> permission to call this resource.
   *
   * @param dto  (optional)
   * @return RestMailConfiguration
   */
  @PUT
  @Path("api/latest/admin/mail-server")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated mail configuration.",
                 content = @Content(schema = @Schema(implementation = RestMailConfiguration.class))),
    @APIResponse(responseCode = "400", description = "The mail configuration was not updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update themail configuration.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update mail configuration")
  RestMailConfiguration setMailConfig(Object dto);

  /**
   * Delete mail configuration.
   * Deletes the current mail configuration.

The authenticated user must have the <strong>SYS_ADMIN</strong> permission to call this resource.
   */
  @DELETE
  @Path("api/latest/admin/mail-server")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The mail configuration was successfully deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the mail server configuration.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete mail configuration")
  void deleteMailConfig();

  /**
   * Get server mail address.
   * Retrieves the server email address
   */
  @GET
  @Path("api/latest/admin/mail-server/sender-address")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The server email address"),
    @APIResponse(responseCode = "401", description = "he currently authenticated user has insufficient permissions to retrieve the server email address.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get server mail address")
  void getSenderAddress();

  /**
   * Update server mail address.
   * Updates the server email address

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @param dto  (optional)
   */
  @PUT
  @Path("api/latest/admin/mail-server/sender-address")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The from address used in notification emails"),
    @APIResponse(responseCode = "400", description = "The server email address was not updated due to a validation error.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the server email address.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update server mail address")
  void setSenderAddress(String dto);

  /**
   * Update mail configuration.
   * Clears the server email address.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   */
  @DELETE
  @Path("api/latest/admin/mail-server/sender-address")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "he server email address was successfully cleared."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions toclear the server email address.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Update mail configuration")
  void clearSenderAddress();

  /**
   * Get rate limit history.
   * Retrieves the recent rate limit history for the instance.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @param order An optional sort category to arrange the results in descending order (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/admin/rate-limit/history")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing a page of aggregated counters for users who have been recently rate limited.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The sort query parameter is invalid.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve rate limit history.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get rate limit history")
  Object getHistory(@QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get rate limit settings.
   * Retrieves the rate limit settings for the instance.

The user must be authenticated to call this resource.
   *
   * @return RestRateLimitSettings
   */
  @GET
  @Path("api/latest/admin/rate-limit/settings")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the rate limit plugin settings for the instance.",
                 content = @Content(schema = @Schema(implementation = RestRateLimitSettings.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve rate limit settings.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get rate limit settings")
  RestRateLimitSettings getSettings_2();

  /**
   * Set rate limit.
   * Sets the rate limit settings for the instance.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.
   *
   * @param dto Sets the rate limit settings for the instance.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource. (optional)
   * @return RestRateLimitSettings
   */
  @PUT
  @Path("api/latest/admin/rate-limit/settings")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the updated rate limit plugin settings for the instance.",
                 content = @Content(schema = @Schema(implementation = RestRateLimitSettings.class))),
    @APIResponse(responseCode = "400", description = "One of the following error cases occurred (check the error message for more details):\n\n- The request is empty\n- The enabled field of the request is not a boolean\n- The defaultSettings field of the request does not contain both capacity and fillRate\n- The capacity and fillRate are not positive integers\n\n\n",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to set rate limit settings.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Set rate limit")
  RestRateLimitSettings setSettings_2(@Valid RestRateLimitSettings dto);

  /**
   * Get rate limit settings for user.
   * Retrieves the user-specific rate limit settings for the given user.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.
   *
   * @param filter Optional filter (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/admin/rate-limit/settings/users")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing all the user-specific rate limit settings filtered by the optional filter.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve rate limit settings.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get rate limit settings for user")
  Object getAllRateLimitSettings(@QueryParam("filter") String filter, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Set rate limit settings for users.
   * Sets the given rate limit settings for the given users.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.
   *
   * @param dto  (optional)
   * @return RestUserRateLimitSettings
   */
  @POST
  @Path("api/latest/admin/rate-limit/settings/users")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the updated user settings.",
                 content = @Content(schema = @Schema(implementation = RestUserRateLimitSettings.class))),
    @APIResponse(responseCode = "400", description = "One of the following valid state error cases occurred (check the error message for more details):\n\n- The request is empty\n- No users are provided in the request\n- One or more of the users are invalid\n- Whitelisted is false or not provided, and no settings are provided either\n- Whitelisted is false or not provided, settings are provided,   but do not contain both capacity and fillRate\n- Whitelisted is false or not provided, settings are provided,   but capacity and fillRate are not positive integers\n- Whitelisted is true, and settings are provided (only one must be provided)\n",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to set user settings.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Set rate limit settings for users")
  RestUserRateLimitSettings set_2(@Valid RestBulkUserRateLimitSettingsUpdateRequest dto);

  /**
   * Get user specific rate limit settings.
   * Retrieves the user-specific rate limit settings for the given user.

To call this resource, the user must be authenticated and either have <strong>ADMIN</strong> permission or be the same user as the one whose settings are requested. A user with <strong>ADMIN</strong> permission cannot get the settings of a user with <strong>SYS_ADMIN</strong> permission.
   *
   * @param userSlug The user slug. (not null)
   * @return RestUserRateLimitSettings
   */
  @GET
  @Path("api/latest/admin/rate-limit/settings/users/{userSlug}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the user-specific rate limit settings for the given user.",
                 content = @Content(schema = @Schema(implementation = RestUserRateLimitSettings.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve rate limit settings.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user does not exist, or has no settings.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get user specific rate limit settings")
  RestUserRateLimitSettings get_6(@PathParam("userSlug") @NotNull String userSlug);

  /**
   * Set rate limit settings for user.
   * Sets the given rate limit settings for the given user.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.
   *
   * @param userSlug The user slug. (not null)
   * @param dto  (optional)
   * @return RestUserRateLimitSettings
   */
  @PUT
  @Path("api/latest/admin/rate-limit/settings/users/{userSlug}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the updated user settings",
                 content = @Content(schema = @Schema(implementation = RestUserRateLimitSettings.class))),
    @APIResponse(responseCode = "400", description = "One of the following valid state error cases occurred (check the error message for more details):\n\n- The request is empty\n- Whitelisted is false or not provided, and no settings are provided either\n- Whitelisted is false or not provided, settings are provided,   but do not contain both capacity and fillRate\n- Whitelisted is false or not provided, settings are provided,   but capacity and fillRate are not positive integers\n- Whitelisted is true, and settings are provided (only one must be provided)\n\n\n",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to set user settings.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Set rate limit settings for user")
  RestUserRateLimitSettings set_3(@PathParam("userSlug") @NotNull String userSlug, @Valid RestUserRateLimitSettingsUpdateRequest dto);

  /**
   * Delete user specific rate limit settings.
   * Deletes the user-specific rate limit settings for the given user.

The authenticated user must have <strong>ADMIN</strong> permission to call this resource.
   *
   * @param userSlug The user slug. (not null)
   */
  @DELETE
  @Path("api/latest/admin/rate-limit/settings/users/{userSlug}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the user settings have been deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve rate limit settings.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified user does not exist, or has no settings.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete user specific rate limit settings")
  void delete_8(@PathParam("userSlug") @NotNull String userSlug);

  /**
   * Get application properties.
   * Retrieve version information and other application properties.

No authentication is required to call this resource.
   *
   * @return RestApplicationProperties
   */
  @GET
  @Path("api/latest/application-properties")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(RestApplicationProperties.class)
  @Operation(summary = "Get application properties")
  RestApplicationProperties getApplicationProperties();

  /**
   * Create a new hook script.
   * Create a new hook script.

This endpoint requires **SYS_ADMIN** permission.
   *
   * @param dto The multipart form data containing the hook script (optional)
   * @return RestHookScript
   */
  @POST
  @Path("api/latest/hook-scripts")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly created hook script.",
                 content = @Content(schema = @Schema(implementation = RestHookScript.class))),
    @APIResponse(responseCode = "400", description = "The hook script was not created due to a validation error.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create a new hook script")
  RestHookScript createHookScript(@Valid ExamplePostMultipartFormData dto);

  /**
   * Get a hook script.
   * Retrieves a hook script by ID.
   *
   * @param scriptId The ID of the hook script to retrieve (not null)
   * @return RestHookScript
   */
  @GET
  @Path("api/latest/hook-scripts/{scriptId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The hook script.",
                 content = @Content(schema = @Schema(implementation = RestHookScript.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The hook script ID supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get a hook script")
  RestHookScript getHookScript(@PathParam("scriptId") @NotNull String scriptId);

  /**
   * Update a hook script.
   * Updates a hook script.

This endpoint requires **SYS_ADMIN** permission.
   *
   * @param scriptId The ID of the hook script (not null)
   * @param dto The multipart form data containing the hook script (optional)
   * @return RestHookScript
   */
  @PUT
  @Path("api/latest/hook-scripts/{scriptId}")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated hook script.",
                 content = @Content(schema = @Schema(implementation = RestHookScript.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The hook script ID supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "409", description = "A hook script with the same name already exists.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "422", description = "One or more fields to update must be specified: content, description and/or name.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update a hook script")
  RestHookScript updateHookScript(@PathParam("scriptId") @NotNull String scriptId, @Valid ExamplePutMultipartFormData dto);

  /**
   * Delete a hook script.
   * Deletes a registered hook script.

This endpoint requires **SYS_ADMIN** permission.
   *
   * @param scriptId The ID of the hook script to delete (not null)
   */
  @DELETE
  @Path("api/latest/hook-scripts/{scriptId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The hook script was deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "Unable to find the supplied hook script ID.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a hook script.")
  void deleteHookScript(@PathParam("scriptId") @NotNull String scriptId);

  /**
   * Get hook script content.
   * Retrieves the hook script content.

This endpoint requires **SYS_ADMIN** permission.
   *
   * @param scriptId The ID of the hook script (not null)
   */
  @GET
  @Path("api/latest/hook-scripts/{scriptId}/content")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The hook script content."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The hook script ID supplied does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get hook script content")
  void read(@PathParam("scriptId") @NotNull String scriptId);

  /**
   * Get all labels.
   * Returns a paged response of all the labels in the system.

The user needs to be authenticated to use this resource.
   *
   * @param prefix (optional) prefix to filter the labels on. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/labels")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of returned labels.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The user is currently not authenticated.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get all labels")
  Object getLabels(@QueryParam("prefix") String prefix, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get label.
   * Returns a label.

The user needs to be authenticated to use this resource.
   *
   * @param labelName the label name (not null)
   * @return RestLabel
   */
  @GET
  @Path("api/latest/labels/{labelName}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The label.",
                 content = @Content(schema = @Schema(implementation = RestLabel.class))),
    @APIResponse(responseCode = "401", description = "The user is currently not authenticated.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified label does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get label")
  RestLabel getLabel(@PathParam("labelName") @NotNull String labelName);

  /**
   * Get labelables for label.
   * Returns a page of labelables for a given label.

Only labelables that the authenticated user has view access to will be returned.
   *
   * @param type  the type of labelables to be returned. Supported values: REPOSITORY (optional)
   * @param labelName The page of labelables. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/labels/{labelName}/labeled")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The page of labelables.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The type of labelable is incorrect, correct values are REPOSITORY.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the labelables",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified label does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get labelables for label")
  Object getLabelables(@QueryParam("type") String type, @PathParam("labelName") @NotNull String labelName, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get current log level.
   * Retrieve the current log level for a given logger.

The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
   *
   * @param loggerName The name of the logger. (not null)
   * @return RestLogLevel
   */
  @GET
  @Path("api/latest/logs/logger/{loggerName}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The log level of the logger.",
                 content = @Content(schema = @Schema(implementation = RestLogLevel.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the log level.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get current log level")
  RestLogLevel getLevel(@PathParam("loggerName") @NotNull String loggerName);

  /**
   * Set log level.
   * Set the current log level for a given logger.

The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
   *
   * @param levelName The level to set the logger to. Either TRACE, DEBUG, INFO, WARN or ERROR (not null)
   * @param loggerName The name of the logger. (not null)
   */
  @PUT
  @Path("api/latest/logs/logger/{loggerName}/{levelName}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The log level was successfully changed."),
    @APIResponse(responseCode = "400", description = "The log level was invalid.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to set the log level.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Set log level")
  void setLevel(@PathParam("levelName") @NotNull String levelName, @PathParam("loggerName") @NotNull String loggerName);

  /**
   * Get root log level.
   *  Retrieve the current log level for the root logger.

The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
   *
   * @return RestLogLevel
   */
  @GET
  @Path("api/latest/logs/rootLogger")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The log level of the logger.",
                 content = @Content(schema = @Schema(implementation = RestLogLevel.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the log level.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get root log level")
  RestLogLevel getRootLevel();

  /**
   * Set root log level.
   * Set the current log level for the root logger.

The authenticated user must have <strong>ADMIN</strong> permission or higher to call this resource.
   *
   * @param levelName the level to set the logger to. Either TRACE, DEBUG, INFO, WARN or ERROR (not null)
   */
  @PUT
  @Path("api/latest/logs/rootLogger/{levelName}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The log level was successfully changed."),
    @APIResponse(responseCode = "400", description = "The log level was invalid.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to set the log level.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Set root log level")
  void setRootLevel(@PathParam("levelName") @NotNull String levelName);

  /**
   * Start export job.
   * Starts a background job that exports the selected repositories.

Only 2 concurrent exports are supported _per cluster node_. If a request ends up on a node that is already running that many export jobs, the request will be rejected and an error returned.

The response includes a description of the job that has been started, and its ID can be used to query these details again, including the current progress, warnings and errors that occurred while processing the job, and to interrupt and cancel the execution of this job.

The request to start an export is similar to the one for previewing an export. Additionally, it accepts an optional parameter, `exportLocation`, which can be used to specify a _relative_ path within `data/migration/export` in the shared home directory. No locations outside of that directory will be accepted for exports.

There are essentially three ways to select repositories for export. Regardless of which you use, a few general rules apply:

- You can supply a list of selectors. The selection will be additive.
- Repositories that are selected more than once due to overlapping selectors will be de-duplicated and effectively exported only once.
- For every selected repository, its full fork hierarchy will be considered selected, even if parts of that hierarchy would otherwise not be matched by the provided selectors. For example, when you explicitly select a single repository only, but that repository is a fork, then its origin will be exported (and eventually imported), too.

Now, a single repository can be selected like this:

```



{
      "projectKey": "PRJ",
      "slug": "my-repo"
}

```

Second, all repositories in a specific project can be selected like this:

```



{
      "projectKey": "PRJ",
      "slug": *"
}

```

And third, all projects and repositories in the system would be selected like this:

```



{
      "projectKey": "*",
      "slug": *"
}

```

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param dto The request (optional)
   * @return RestJob
   */
  @POST
  @Path("api/latest/migration/exports")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Details about the export job.",
                 content = @Content(schema = @Schema(implementation = RestJob.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to start anexport",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "503", description = "The export could not be started because the limit of concurrent migration jobs has been reached.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Start export job")
  RestJob startExport(@Valid RestExportRequest dto);

  /**
   * Preview export.
   * Enumerates the projects and repositories that would be exported for a given export request.

All affected repositories will be enumerated explicitly, and while projects are listed as individual items in responses from this endpoint, their presence does not imply that all their repositories are included.

While this endpoint can be used to verify that all selectors in the request apply as intended, it should be noted that a subsequent, actual export might contain a different set of repositories, as they might have been added or deleted in the meantime.

Note that the overall response from this endpoint can become very large when a lot of repositories end up in the selection. This is why the server is streaming the response while it is being generated (as opposed to creating it in memory and then sending it all at once) and it can be consumed in a streaming way, too.

Also, due to the potential size of the response, projects and repositories are listed with fewer details than in other REST responses.

For a more detailed description of selectors, see the endpoint documentation for starting an export.

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param dto the export request (optional)
   * @return RestScopesExample
   */
  @POST
  @Path("api/latest/migration/exports/preview")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The effectively selected projects and repositories.",
                 content = @Content(schema = @Schema(implementation = RestScopesExample.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to generate a preview.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Preview export")
  RestScopesExample previewExport(@Valid RestExportRequest dto);

  /**
   * Get export job details.
   * Gets the details, including the current status and progress, of the export job identified by the given ID.

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param jobId the ID of the job (not null)
   * @return RestJob
   */
  @GET
  @Path("api/latest/migration/exports/{jobId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The job, including status and progress information.",
                 content = @Content(schema = @Schema(implementation = RestJob.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve information about this job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified job does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get export job details")
  RestJob getExportJob(@PathParam("jobId") @NotNull String jobId);

  /**
   * Cancel export job.
   * Requests the cancellation of an export job.

The request to cancel a job will be processed successfully if the job is actually still running. If it has already finished (successfully or with errors) or if it has already been canceled before, then an error will be returned.

There might be a small delay between accepting the request and actually cancelling the job. In most cases, the delay will be close to instantaneously. In the unlikely case of communication issues across a cluster, it can however take a few seconds to cancel a job.

A client should always actively query the job status to confirm that a job has been successfully canceled.

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param jobId the ID of the job to cancel (not null)
   */
  @POST
  @Path("api/latest/migration/exports/{jobId}/cancel")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The job has successfully been marked for cancellation"),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to cancel this job.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified job does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "The job was in a state that does not allow cancellation, e.g. it has already finished.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Cancel export job")
  void cancelExportJob(@PathParam("jobId") @NotNull String jobId);

  /**
   * Get job messages.
   * Gets the messages generated by the job.

Without any filter, all messages will be returned, but the response can optionally be filtered for the following severities. The severity parameter can be repeated to include multiple severities in one response.

- INFO
- WARN
- ERROR

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param severity The severity to include in the results (optional)
   * @param jobId The ID of the job (not null)
   * @param subject The subject (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/migration/exports/{jobId}/messages")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The messages generated by this job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve information about this job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified job does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get job messages")
  Object getExportJobMessages(@QueryParam("severity") String severity, @PathParam("jobId") @NotNull String jobId, @QueryParam("subject") String subject, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Start import job.
   * Starts a background job that imports the specified archive.

Only 1 import at a time is supported _per cluster_. If another request is made while an import is already running, the request will be rejected and an error returned.

The path in the request must point to a valid archive file. The file must be located within the `data/migration/import` directory in the shared home directory.

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param dto The request (optional)
   * @return RestJob
   */
  @POST
  @Path("api/latest/migration/imports")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Details about the export job.",
                 content = @Content(schema = @Schema(implementation = RestJob.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to start an import.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "503", description = "The import could not be started because the limit of concurrent migration jobs has been reached.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Start import job")
  RestJob startImport(@Valid RestImportRequest dto);

  /**
   * Get import job status.
   * Gets the details, including the current status and progress, of the import job identified by the given ID.

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param jobId The ID of the job (not null)
   * @return RestJob
   */
  @GET
  @Path("api/latest/migration/imports/{jobId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The job, including status and progress information.",
                 content = @Content(schema = @Schema(implementation = RestJob.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve information about this job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified job does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get import job status")
  RestJob getImportJob(@PathParam("jobId") @NotNull String jobId);

  /**
   * Cancel import job.
   * Requests the cancellation of an import job.

The request to cancel a job will be processed successfully if the job is actually still running. If it has already finished (successfully or with errors) or if it has already been canceled before, then an error will be returned.

Note that import jobs are not canceled as instantaneously as export jobs. Rather, once the request has been accepted, there are a number of checkpoints at which the job will actually apply it and stop. This is to keep the system in a reasonably consistent state:

- After the current fork hierarchy has been imported and verified.
- Before the next repository is imported.
- Before the next pull request is imported.

A client should always actively query the job status to confirm that a job has been successfully canceled.

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param jobId the ID of the job to cancel (not null)
   */
  @POST
  @Path("api/latest/migration/imports/{jobId}/cancel")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The job has successfully been marked for cancellation."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to cancel this job.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified job does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "The job was in a state that does not allow cancellation, e.g. it has already finished.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Cancel import job")
  void cancelImportJob(@PathParam("jobId") @NotNull String jobId);

  /**
   * Get import job messages.
   * Gets the messages generated by the job.

Without any filter, all messages will be returned, but the response can optionally be filtered for the following severities. The severity parameter can be repeated to include multiple severities in one response.

- INFO
- WARN
- ERROR

The authenticated user must have **ADMIN** permission or higher to call this resource.
   *
   * @param severity The severity to include in the results (optional)
   * @param jobId The ID of the job (not null)
   * @param subject The subject (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/migration/imports/{jobId}/messages")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The messages generated by this job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve information about this job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified job does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get import job messages")
  Object getImportJobMessages(@QueryParam("severity") String severity, @PathParam("jobId") @NotNull String jobId, @QueryParam("subject") String subject, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Start Mesh migration job.
   * Starts a background job that migrates selected projects/repositories to Mesh.

Only 1 job is supported _per cluster_.

The response includes a description of the job that has been started, and its ID can be used to query these details again, including the current progress, and to interrupt and cancel the execution of this job.

The request to start a migration is similar to the one for previewing a migration.

There are essentially three ways to select repositories for migration. Regardless of which you use, a few general rules apply:

    - You can supply a list of repository IDs and project IDs. The selection will be additive. All repositories     in the system are migrated if both lists are empty.     - Repositories that are selected more than once due to overlapping IDs will be de-duplicated and     effectively migrated only once.     - For every selected repository, its full fork hierarchy will be considered selected, even if parts of that     hierarchy would otherwise not be matched by the provided IDs. For example, when you explicitly     select a single repository only, but that repository is a fork, then its origin will be migrated too.

Now, a single repository can be selected like this:

```

     {
     "repositoryIds": [1]
     }
```

Multiple repositories can be selected like this:



```

     {
     "repositoryIds": [1, 2]
     }
```

Second, all repositories in a specific project can be selected like this:



```

     {
     "projectIds": [1]
     }
```

And third, all projects and repositories in the system would be selected like this:



```

     {
     "projectIds": [],
     "repositoryIds": []
     }
```

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param dto  (optional)
   * @return RestJob
   */
  @POST
  @Path("api/latest/migration/mesh")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The started job",
                 content = @Content(schema = @Schema(implementation = RestJob.class))),
    @APIResponse(responseCode = "400", description = "The migration request failed one/more validation checks.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "503", description = "A migration job is already in progress",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Start Mesh migration job")
  RestJob startMeshMigration(Object dto);

  /**
   * Preview Mesh migration.
   * Enumerates the projects and repositories that would be migrated for a given request.

All affected repositories will be enumerated explicitly, and while projects are listed as individual items in responses from this endpoint, their presence does not imply that all their repositories are included.

While this endpoint can be used to verify that all selectors in the request apply as intended, it should be noted that a subsequent, actual export might contain a different set of repositories, as they might have been added or deleted in the meantime.

Note that the overall response from this endpoint can become very large when a lot of repositories end up in the selection. This is why the server is streaming the response while it is being generated (as opposed to creating it in memory and then sending it all at once) and it can be consumed in a streaming way, too.

Also, due to the potential size of the response, projects and repositories are listed with fewer details than in other REST responses.

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param dto The export request (optional)
   * @return ExamplePreviewMigration
   */
  @POST
  @Path("api/latest/migration/mesh/preview")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Enumeration of projects and repositories that would be migrated for a given request.",
                 content = @Content(schema = @Schema(implementation = ExamplePreviewMigration.class))),
    @APIResponse(responseCode = "400", description = "The request was invalid or missing.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Preview Mesh migration")
  ExamplePreviewMigration previewMeshMigration(@Valid RestMeshMigrationRequest dto);

  /**
   * Find repositories by Mesh migration state.
   * Searches for repositories in the system matching the specified criteria and enriches their MeshMigrationQueueState migration state if a migration is currently in progress.

The currently active migration can optionally be specified by passing a migrationId, if known. If this isn't passed, an attempt is made to locate the active migration and its ID is used.

If a migration is currently active, only repositories that are a part of the migration are filtered and returned. Otherwise, all repositories in the systems are filtered and returned.

Filtering by state is ignored when no migration is currently in progress. In such a case, results are not enriched with their MeshMigrationQueueState migration state.

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param migrationId (optional) The currently active migration job. If not passed, this is looked up internally. (optional)
   * @param projectKey (optional) The project key. Can be specified more than once to filter by more than one project. (optional)
   * @param name (optional) The repository name (optional)
   * @param state (optional) If a migration is active, the MeshMigrationQueueState state to filter results by. Can be specified more than once to filter by more than one state. (optional)
   * @param remote (optional) Whether the repository has been fully migrated to Mesh. If not present, all repositories are considered regardless of where they're located. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/migration/mesh/repos")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of repositories matching the specified criteria.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "No migration job with the given ID exists.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find repositories by Mesh migration state")
  Object searchMeshMigrationRepos(@QueryParam("migrationId") String migrationId, @QueryParam("projectKey") String projectKey, @QueryParam("name") String name, @QueryParam("state") String state, @QueryParam("remote") String remote, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get all Mesh migration job summaries.
   * Retrieve a page of Mesh migration job summaries. Jobs are ordered by when they were started, newest first.

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/migration/mesh/summaries")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The summary of the migration job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get all Mesh migration job summaries")
  Object getAllMeshMigrationSummaries(@QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get summary for Mesh migration job.
   * Gets the summary, including the queue status and progress, of the currently active Mesh migration job.

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @return RestMeshMigrationSummary
   */
  @GET
  @Path("api/latest/migration/mesh/summary")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The summary of the currently active migration job.",
                 content = @Content(schema = @Schema(implementation = RestMeshMigrationSummary.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "No active migration job found.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get summary for Mesh migration job")
  RestMeshMigrationSummary getActiveMeshMigrationSummary();

  /**
   * Get Mesh migration job details.
   * Gets the details, including the current status and progress, of the job identified by the given ID.

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param jobId The ID of the job (not null)
   */
  @GET
  @Path("api/latest/migration/mesh/{jobId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The details of the migration job."),
    @APIResponse(responseCode = "400", description = "The job ID parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified job ID does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get Mesh migration job details")
  void getMeshMigrationJob(@PathParam("jobId") @NotNull String jobId);

  /**
   * Cancel Mesh migration job.
   * Requests the cancellation of a migration job.

The request to cancel a job will be processed successfully if the job is actually still running. If it has already finished (successfully or with errors) or if it has already been canceled before, then an error will be returned.

There might be a small delay between accepting the request and actually cancelling the job. In most cases, the delay will be close to instantaneously. In the unlikely case of communication issues across a cluster, it can however take a few seconds to cancel a job.

A client should always actively query the job status to confirm that a job has been successfully canceled.

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param jobId The ID of the job to cancel (not null)
   */
  @POST
  @Path("api/latest/migration/mesh/{jobId}/cancel")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The migration job was successfully marked for cancellation."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified job ID does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "The migration job has already been canceled or finished.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Cancel Mesh migration job")
  void cancelMeshMigrationJob(@PathParam("jobId") @NotNull String jobId);

  /**
   * Get Mesh migration job messages.
   * Gets the messages generated by the job.

Without any filter, all messages will be returned, but the response can optionally be filtered for the following severities. The severity parameter can be repeated to include multiple severities in one response.

     - INFO
     - WARN
     - ERROR


The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param severity The severity to include in the results (optional)
   * @param jobId The ID of the job (not null)
   * @param subject The subject (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/migration/mesh/{jobId}/messages")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The details of the migration job.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The job ID parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified job ID does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get Mesh migration job messages")
  Object getMeshMigrationJobMessages(@QueryParam("severity") String severity, @PathParam("jobId") @NotNull String jobId, @QueryParam("subject") String subject, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Get Mesh migration job summary.
   * Gets the summary, including the queue status and progress, of a Mesh migration job.

The authenticated user must have **SYS_ADMIN** permission to call this resource.
   *
   * @param jobId The ID of the job (not null)
   * @return RestMeshMigrationSummary
   */
  @GET
  @Path("api/latest/migration/mesh/{jobId}/summary")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The summary of the migration job.",
                 content = @Content(schema = @Schema(implementation = RestMeshMigrationSummary.class))),
    @APIResponse(responseCode = "400", description = "The job ID parameter was not supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to call this resource.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified job ID does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get Mesh migration job summary")
  RestMeshMigrationSummary getMeshMigrationJobSummary(@PathParam("jobId") @NotNull String jobId);

  /**
   * Get all users.
   * Retrieve a page of users, optionally run through provided filters.


Only authenticated users may call this resource.
### Permission Filters


The following three sub-sections list parameters supported for permission filters (where <code>[root]</code> is
the root permission filter name, e.g. <code>permission</code>, <code>permission.1</code> etc.) depending on the
permission resource. The system determines which filter to apply (Global, Project or Repository permission)
based on the `[root]` permission value. E.g. <code>ADMIN</code> is a global permission,
<code>PROJECT_ADMIN</code> is a project permission and <code>REPO_ADMIN</code> is a repository permission. Note
that the parameters for a given resource will be looked up in the order as they are listed below, that is e.g.
for a project resource, if both <code>projectId</code> and <code>projectKey</code> are provided, the system will
use <code>projectId</code> for the lookup.
<h4>Global permissions</h4>


The permission value under <code>[root]</code> is the only required and recognized parameter, as global
permissions do not apply to a specific resource.


Example valid filter: <code>permission=ADMIN</code>.
<h4>Project permissions</h4>


- <code>[root]</code>- specifies the project permission
- <code>[root].projectId</code> - specifies the project ID to lookup the project by
- <code>[root].projectKey</code> - specifies the project key to lookup the project by


Example valid filter: <code>permission.1=PROJECT_ADMIN&amp;permission.1.projectKey=TEST_PROJECT</code>.
#### Repository permissions


- <code>[root]</code>- specifies the repository permission
- <code>[root].projectId</code> - specifies the repository ID to lookup the repository by
- <code>[root].projectKey</code> and <code>[root].repositorySlug</code>- specifies the project key and     repository slug to lookup the repository by; both values <i>need to</i> be provided for this look up to be     triggered


Example valid filter: <code>permission.2=REPO_ADMIN&amp;permission.2.projectKey=TEST_PROJECT&amp;permission.2.repositorySlug=test_repo</code>.
   *
   * @param filter Return only users, whose username, name or email address <i>contain</i> the <code> filter</code> value (optional)
   * @param permission_N The "root" of a single permission filter, similar to the <code>permission</code> parameter, where "N" is a natural number starting from 1. This allows clients to specify multiple permission filters, by providing consecutive filters as <code>permission.1</code>, <code>permission.2</code> etc. Note that the filters numbering has to start with 1 and be continuous for all filters to be processed. The total allowed number of permission filters is 50 and all filters exceeding that limit will be dropped. See the section "Permission Filters" above for more details on how the permission filters are processed. (optional)
   * @param permission The "root" of a permission filter, whose value must be a valid global, project, or repository permission. Additional filter parameters referring to this filter that specify the resource (project or repository) to apply the filter to must be prefixed with <code>permission.</code>. See the section "Permission Filters" above for more details. (optional)
   * @param group return only users who are members of the given group (optional)
   * @return RestApplicationUser
   */
  @GET
  @Path("api/latest/users")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of users.",
                 content = @Content(schema = @Schema(implementation = RestApplicationUser.class))),
    @APIResponse(responseCode = "400", description = "The search request was invalid, which may happen for multiple reasons, among\nothers:\n\n\n- permission filter for project/repository permission with no parameters specifying the project or     repository to apply the filter to\n- invalid permission name\n- permission filter for a project/repository permission pointing to a non-existent project or repository\n\n\nThe exact reason for the error and - in most cases - the request parameter name that had invalid value - will be\nprovided in the error message.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "Authentication failed or was not attempted.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get all users")
  RestApplicationUser getUsers_2(@QueryParam("filter") String filter, @QueryParam("permission.N") String permission_N, @QueryParam("permission") String permission, @QueryParam("group") String group);

  /**
   * Update user details.
   * Update the currently authenticated user's details. The update will always be applied to the currently authenticated user.
   *
   * @param dto The user update details (optional)
   * @return RestApplicationUser
   */
  @PUT
  @Path("api/latest/users")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated user.",
                 content = @Content(schema = @Schema(implementation = RestApplicationUser.class))),
    @APIResponse(responseCode = "400", description = "The request was malformed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "Authentication failed or was not attempted.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update user details")
  RestApplicationUser updateUserDetails_1(@Valid UserUpdate dto);

  /**
   * Set password.
   * Update the currently authenticated user's password.
   *
   * @param dto The password update details (optional)
   */
  @PUT
  @Path("api/latest/users/credentials")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The user's password was successfully updated."),
    @APIResponse(responseCode = "400", description = "The request was malformed or the old password was incorrect.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "401", description = "Authentication failed or was not attempted.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Set password")
  void updateUserPassword_1(@Valid UserPasswordUpdate dto);

  /**
   * Get user.
   * Retrieve the user matching the supplied <strong>userSlug</strong>.
   *
   * @param userSlug The user slug (not null)
   * @return RestApplicationUser
   */
  @GET
  @Path("api/latest/users/{userSlug}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The user matching the supplied <strong>userSlug</strong>. Note, this may\n<i>not</i> be the user's username, always use the <strong>user.slug</strong> property.",
                 content = @Content(schema = @Schema(implementation = RestApplicationUser.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to view the user.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get user")
  RestApplicationUser getUser(@PathParam("userSlug") @NotNull String userSlug);

  /**
   * Update user avatar.
   * Update the avatar for the user with the supplied <strong>slug</strong>.


This resource accepts POST multipart form data, containing a single image in a form-field named 'avatar'.


There are configurable server limits on both the dimensions (1024x1024 pixels by default) and uploaded
file size (1MB by default). Several different image formats are supported, but <strong>PNG</strong> and
<strong>JPEG</strong> are preferred due to the file size limit.


This resource has Cross-Site Request Forgery (XSRF) protection. To allow the request to
pass the XSRF check the caller needs to send an <code>X-Atlassian-Token</code> HTTP header with the
value <code>no-check</code>.


An example <a href="http://curl.haxx.se/">curl</a> request to upload an image name 'avatar.png' would be:
```
curl -X POST -u username:password -H "X-Atlassian-Token: no-check" http://example.com/rest/api/latest/users/jdoe/avatar.png -F avatar=@avatar.png
```


Users are always allowed to update their own avatar. To update someone else's avatar the authenticated user must
have global <strong>ADMIN</strong> permission, or global <strong>SYS_ADMIN</strong> permission to update a
<strong>SYS_ADMIN</strong> user's avatar.
   *
   * @param xAtlassianToken This resource has Cross-Site Request Forgery (XSRF) protection. To allow the request to pass the XSRF check the caller needs to send an <code>X-Atlassian-Token</code> HTTP header with the value <code>no-check</code>. (optional)
   * @param userSlug The user slug (not null)
   * @param dto Multipart form data containing a single image in a form-field named 'avatar'. (optional)
   */
  @POST
  @Path("api/latest/users/{userSlug}/avatar.png")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The avatar was uploaded successfully."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to update the avatar.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified user does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Update user avatar")
  void uploadAvatar_1(@HeaderParam("X-Atlassian-Token") String xAtlassianToken, @PathParam("userSlug") @NotNull String userSlug, @Valid ExampleAvatarMultipartFormData dto);

  /**
   * Delete user avatar.
   * Delete the avatar associated to a user.


Users are always allowed to delete their own avatar. To delete someone else's avatar the authenticated user must
have global <strong>ADMIN</strong> permission, or global <strong>SYS_ADMIN</strong> permission to update a
<strong>SYS_ADMIN</strong> user's avatar.
   *
   * @param userSlug The user slug (not null)
   * @return RestNamedLink
   */
  @DELETE
  @Path("api/latest/users/{userSlug}/avatar.png")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The new avatar URL if the local avatar was successfully deleted or did not exist",
                 content = @Content(schema = @Schema(implementation = RestNamedLink.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user has insufficient permissions to delete the specified avatar.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Delete user avatar")
  RestNamedLink deleteAvatar(@PathParam("userSlug") @NotNull String userSlug);

  /**
   * Get user settings.
   * Retrieve a map of user setting key values for a specific user identified by the user slug.
   *
   * @param userSlug The user slug. (not null)
   * @return ExampleSettingsMap
   */
  @GET
  @Path("api/latest/users/{userSlug}/settings")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The user settings for the specified user slug.",
                 content = @Content(schema = @Schema(implementation = ExampleSettingsMap.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user does not have permission to view the settings of this user.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified project, repository, commit, or report does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get user settings")
  ExampleSettingsMap getUserSettings(@PathParam("userSlug") @NotNull String userSlug);

  /**
   * Update user settings.
   * Update the entries of a map of user setting key/values for a specific user identified by the user slug.
   *
   * @param userSlug The user slug. (not null)
   * @param dto A map with the UserSettings entries which must be updated. (optional)
   */
  @POST
  @Path("api/latest/users/{userSlug}/settings")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The UserSettings were updated successfully"),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not a project administrator.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Update user settings")
  void updateSettings(@PathParam("userSlug") @NotNull String userSlug, @Valid ExampleSettingsMap dto);

  /**
   * Dismiss retention config notification.
   * Dismisses the retention config review notification displayed by the audit plugin for the user that's currently logged in.
   */
  @DELETE
  @Path("audit/latest/notification-settings/retention-config-review")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A blank response"),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to dismiss the notification.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Dismiss retention config notification")
  void dismissRetentionConfigReviewNotification();

  /**
   * Get repository archive policy.
   * Retrieves the repository archive policy for the instance.

The user must be authenticated to access this resource.
   *
   * @return RestRepositoryPolicy
   */
  @GET
  @Path("policies/latest/admin/repos/archive")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the repository archive policy for the instance",
                 content = @Content(schema = @Schema(implementation = RestRepositoryPolicy.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the repository archive policy",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get repository archive policy")
  RestRepositoryPolicy getRepositoryArchivePolicy();

  /**
   * Update repository archive policy.
   * Sets the repository archive policy for the instance.

The authenticated user must have <b>SYS_ADMIN</b> permission.
   *
   * @param dto The request containing the details of the policy. (optional)
   * @return RestRepositoryPolicy
   */
  @PUT
  @Path("policies/latest/admin/repos/archive")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the repository archive policy for the instance",
                 content = @Content(schema = @Schema(implementation = RestRepositoryPolicy.class))),
    @APIResponse(responseCode = "400", description = "The permission was invalid or does not exist",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to set the repository archive policy",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update repository archive policy")
  RestRepositoryPolicy setRepositoryArchivePolicy(@Valid RestRepositoryPolicy dto);

  /**
   * Get repository delete policy.
   * Retrieves the repository delete policy for the instance.

The user must be authenticated to access this resource.
   *
   * @return RestRepositoryPolicy
   */
  @GET
  @Path("policies/latest/admin/repos/delete")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the repository delete policy for the instance",
                 content = @Content(schema = @Schema(implementation = RestRepositoryPolicy.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the repository delete policy",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get repository delete policy")
  RestRepositoryPolicy getRepositoryDeletePolicy();

  /**
   * Update the repository delete policy.
   * Sets the repository delete policy for the instance.

The authenticated user must have <b>SYS_ADMIN</b> permission.
   *
   * @param dto The request containing the details of the policy. (optional)
   * @return RestRepositoryPolicy
   */
  @PUT
  @Path("policies/latest/admin/repos/delete")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the repository delete policy for the instance",
                 content = @Content(schema = @Schema(implementation = RestRepositoryPolicy.class))),
    @APIResponse(responseCode = "400", description = "The permission was invalid or does not exist",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to set the repository delete policy",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update the repository delete policy")
  RestRepositoryPolicy setRepositoryDeletePolicy(@Valid RestRepositoryPolicy dto);
}
