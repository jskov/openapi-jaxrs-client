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
import mada.tests.e2e.examples.bitbucket.dto.RestAccessToken;
import mada.tests.e2e.examples.bitbucket.dto.RestAccessTokenRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestRawAccessToken;
import mada.tests.e2e.examples.bitbucket.dto.RestSshAccessKey;
import mada.tests.e2e.examples.bitbucket.dto.RestSshKey;
import mada.tests.e2e.examples.bitbucket.dto.RestSshSettings;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface AuthenticationApi {

  /**
   * Get project HTTP tokens.
   * Get all access tokens associated with the given project.
   *
   * @param projectKey The project key. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("access-tokens/latest/projects/{projectKey}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing a page of access tokens and associated details.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get access tokens for this project or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified project does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get project HTTP tokens")
  Object getAllAccessTokens(@PathParam("projectKey") @NotNull String projectKey, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create project HTTP token.
   * Create an access token for the project according to the given request.
   *
   * @param projectKey The project key. (not null)
   * @param dto The request containing the details of the access token to create. (optional)
   * @return RestRawAccessToken
   */
  @PUT
  @Path("access-tokens/latest/projects/{projectKey}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the raw access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestRawAccessToken.class))),
    @APIResponse(responseCode = "400", description = "One of the following error cases occurred (check the error message for more details).\n\n- The request does not contain a token name\n- The request does not contain a list of permissions, or the list of permissions is empty\n- One of the provided permission levels are unknown\n- The project already has the maximum number of tokens\n",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to create an access token for this project or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified project does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create project HTTP token")
  RestRawAccessToken createAccessToken_1(@PathParam("projectKey") @NotNull String projectKey, @Valid RestAccessTokenRequest dto);

  /**
   * Get repository HTTP tokens.
   * Get all access tokens associated with the given repository.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("access-tokens/latest/projects/{projectKey}/repos/{repositorySlug}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing a page of access tokens and associated details.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get access tokens for this repository or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get repository HTTP tokens")
  Object getAllAccessTokens_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create repository HTTP token.
   * Create an access token for the repository according to the given request.
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The request containing the details of the access token to create. (optional)
   * @return RestRawAccessToken
   */
  @PUT
  @Path("access-tokens/latest/projects/{projectKey}/repos/{repositorySlug}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the raw access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestRawAccessToken.class))),
    @APIResponse(responseCode = "400", description = "One of the following error cases occurred (check the error message for more details).\n\n- The request does not contain a token name- The request does not contain a list of permissions, or the list of permissions is empty- One of the provided permission levels are unknown- The repository already has the maximum number of tokens",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to create an access token for this repository or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create repository HTTP token")
  RestRawAccessToken createAccessToken_2(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestAccessTokenRequest dto);

  /**
   * Get HTTP token by ID.
   * Get the access token identified by the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param tokenId The token id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestAccessToken
   */
  @GET
  @Path("access-tokens/latest/projects/{projectKey}/repos/{repositorySlug}/{tokenId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestAccessToken.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get access tokens on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user or token does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get HTTP token by ID")
  RestAccessToken getById_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("tokenId") @NotNull String tokenId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update HTTP token.
   * Modify an access token according to the given request. Any fields not specified will not be altered.
   *
   * @param projectKey The project key. (not null)
   * @param tokenId The token id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto The request containing the details of the access token to modify (optional)
   * @return RestAccessToken
   */
  @POST
  @Path("access-tokens/latest/projects/{projectKey}/repos/{repositorySlug}/{tokenId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the updated access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestAccessToken.class))),
    @APIResponse(responseCode = "400", description = "One of the provided permission levels are unknown.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to update an access token on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update HTTP token")
  RestAccessToken updateAccessToken_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("tokenId") @NotNull String tokenId, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestAccessTokenRequest dto);

  /**
   * Delete a HTTP token.
   * Delete the access token identified by the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param tokenId The token id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("access-tokens/latest/projects/{projectKey}/repos/{repositorySlug}/{tokenId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the token has been deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to delete an access token on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified user or token does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a HTTP token")
  void deleteById_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("tokenId") @NotNull String tokenId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get HTTP token by ID.
   * Get the access token identified by the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param tokenId The token id. (not null)
   * @return RestAccessToken
   */
  @GET
  @Path("access-tokens/latest/projects/{projectKey}/{tokenId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestAccessToken.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get access tokens on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user or token does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get HTTP token by ID")
  RestAccessToken getById(@PathParam("projectKey") @NotNull String projectKey, @PathParam("tokenId") @NotNull String tokenId);

  /**
   * Update HTTP token.
   * Modify an access token according to the given request. Any fields not specified will not be altered.
   *
   * @param projectKey The project key. (not null)
   * @param tokenId The token id. (not null)
   * @param dto The request containing the details of the access token to modify (optional)
   * @return RestAccessToken
   */
  @POST
  @Path("access-tokens/latest/projects/{projectKey}/{tokenId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the updated access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestAccessToken.class))),
    @APIResponse(responseCode = "400", description = "One of the provided permission levels are unknown.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to update an access token on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update HTTP token")
  RestAccessToken updateAccessToken(@PathParam("projectKey") @NotNull String projectKey, @PathParam("tokenId") @NotNull String tokenId, @Valid RestAccessTokenRequest dto);

  /**
   * Delete a HTTP token.
   * Delete the access token identified by the given ID.
   *
   * @param projectKey The project key. (not null)
   * @param tokenId The token id. (not null)
   */
  @DELETE
  @Path("access-tokens/latest/projects/{projectKey}/{tokenId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the token has been deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to delete an access token on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified user or token does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a HTTP token")
  void deleteById(@PathParam("projectKey") @NotNull String projectKey, @PathParam("tokenId") @NotNull String tokenId);

  /**
   * Get personal HTTP tokens.
   * Get all access tokens associated with the given user.
   *
   * @param userSlug The user slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("access-tokens/latest/users/{userSlug}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing a page of access tokens and associated details.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get access tokens on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get personal HTTP tokens")
  Object getAllAccessTokens_2(@PathParam("userSlug") @NotNull String userSlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create personal HTTP token.
   * Create an access token for the user according to the given request.
   *
   * @param userSlug The user slug. (not null)
   * @param dto The request containing the details of the access token to create. (optional)
   * @return RestRawAccessToken
   */
  @PUT
  @Path("access-tokens/latest/users/{userSlug}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the raw access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestRawAccessToken.class))),
    @APIResponse(responseCode = "400", description = "One of the following error cases occurred (check the error message for more details).\n\n- The request does not contain a token name\n- The request does not contain a list of permissions, or the list of permissions is empty\n- One of the provided permission levels are unknown\n- The user already has their maximum number of tokens\n",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to create an access token on behalf of this user or authentication failed",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create personal HTTP token")
  RestRawAccessToken createAccessToken_3(@PathParam("userSlug") @NotNull String userSlug, @Valid RestAccessTokenRequest dto);

  /**
   * Get HTTP token by ID.
   * Get the access token identified by the given ID.
   *
   * @param tokenId The token id. (not null)
   * @param userSlug The user slug. (not null)
   * @return RestAccessToken
   */
  @GET
  @Path("access-tokens/latest/users/{userSlug}/{tokenId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestAccessToken.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to get access tokens on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified user or token does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get HTTP token by ID")
  RestAccessToken getById_2(@PathParam("tokenId") @NotNull String tokenId, @PathParam("userSlug") @NotNull String userSlug);

  /**
   * Update HTTP token.
   * Modify an access token according to the given request. Any fields not specified will not be altered.
   *
   * @param tokenId The token id. (not null)
   * @param userSlug The user slug. (not null)
   * @param dto The request containing the details of the access token to modify (optional)
   * @return RestAccessToken
   */
  @POST
  @Path("access-tokens/latest/users/{userSlug}/{tokenId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A response containing the updated access token and associated details.",
                 content = @Content(schema = @Schema(implementation = RestAccessToken.class))),
    @APIResponse(responseCode = "400", description = "One of the provided permission levels are unknown.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to update an access token on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update HTTP token")
  RestAccessToken updateAccessToken_2(@PathParam("tokenId") @NotNull String tokenId, @PathParam("userSlug") @NotNull String userSlug, @Valid RestAccessTokenRequest dto);

  /**
   * Delete a HTTP token.
   * Delete the access token identified by the given ID.
   *
   * @param tokenId The token id. (not null)
   * @param userSlug The user slug. (not null)
   */
  @DELETE
  @Path("access-tokens/latest/users/{userSlug}/{tokenId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response indicating that the token has been deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user is not permitted to delete an access token on behalf of this user or authentication failed.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "The specified user or token does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a HTTP token")
  void deleteById_2(@PathParam("tokenId") @NotNull String tokenId, @PathParam("userSlug") @NotNull String userSlug);

  /**
   * Get repository SSH keys.
   * Retrieves the access keys for the repository identified in the URL.
   *
   * @param filter If specified only SSH access keys with a label prefixed with the supplied string will be returned (optional)
   * @param effective Controls whether SSH access keys configured at the project level should be included in the results or not. When set to <code>true</code> all keys that have <em>access</em> to the repository (including project level keys) are included in the results. When set to <code>false</code>, only access keys configured for the specified <code>repository</code> are considered. Default is <code>false</code>. (optional)
   * @param projectKey The project key. (not null)
   * @param minimumPermission If specified only SSH access keys with at least the supplied permission will be returned. Default is <code>Permission.REPO_READ</code>. (optional)
   * @param permission  (optional)
   * @param repositorySlug The repository slug. (not null)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("keys/latest/projects/{projectKey}/repos/{repositorySlug}/ssh")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A single page of access keys for the repository.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the access keys for this repository",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get repository SSH keys")
  Object getForRepository_1(@QueryParam("filter") String filter, @QueryParam("effective") String effective, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("minimumPermission") String minimumPermission, @QueryParam("permission") String permission, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Add repository SSH key.
   * Register a new SSH key and grants access to the repository identified in the URL.
   *
   * @param projectKey The project key (not null)
   * @param repositorySlug The repository slug (not null)
   * @param dto  (optional)
   * @return RestSshAccessKey
   */
  @POST
  @Path("keys/latest/projects/{projectKey}/repos/{repositorySlug}/ssh")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created access key.",
                 content = @Content(schema = @Schema(implementation = RestSshAccessKey.class))),
    @APIResponse(responseCode = "400", description = "The current request contains invalid or missing values.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to add an access key to the repository.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Add repository SSH key")
  RestSshAccessKey addForRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @Valid RestSshAccessKey dto);

  /**
   * Get repository SSH key.
   * Retrieves the access key for the SSH key with id <code>keyId</code> on the repository identified in the URL.
   *
   * @param projectKey The project key (not null)
   * @param keyId The key id (not null)
   * @param repositorySlug The repository slug (not null)
   * @return RestSshAccessKey
   */
  @GET
  @Path("keys/latest/projects/{projectKey}/repos/{repositorySlug}/ssh/{keyId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The access key for the repository and SSH key with ID <code>keyId</code>.",
                 content = @Content(schema = @Schema(implementation = RestSshAccessKey.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the access keys for this repository.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or key does not exist or the key does not have access on the repository.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get repository SSH key")
  RestSshAccessKey getForRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("keyId") @NotNull String keyId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Revoke repository SSH key.
   * Remove an existing access key for the repository identified in the URL. If the same SSH key is used as an access key for multiple projects or repositories, only the access to the repository identified in the URL will be revoked.
   *
   * @param projectKey The project key (not null)
   * @param keyId The key id (not null)
   * @param repositorySlug The repository slug (not null)
   */
  @DELETE
  @Path("keys/latest/projects/{projectKey}/repos/{repositorySlug}/ssh/{keyId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The access key was deleted (or none was found matching the given id)."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to remove access keys for this repository",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Revoke repository SSH key")
  void revokeForRepository(@PathParam("projectKey") @NotNull String projectKey, @PathParam("keyId") @NotNull String keyId, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Update repository SSH key permission.
   * Updates the permission granted to the specified SSH key to the repository identified in the URL.
   *
   * @param projectKey The project key (not null)
   * @param keyId The newly created access key (not null)
   * @param permission The new permission to be granted to the SSH key (not null)
   * @param repositorySlug The repository slug (not null)
   * @return RestSshAccessKey
   */
  @PUT
  @Path("keys/latest/projects/{projectKey}/repos/{repositorySlug}/ssh/{keyId}/permission/{permission}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly created access key.",
                 content = @Content(schema = @Schema(implementation = RestSshAccessKey.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions on the repository to edit its access keys.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified repository does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update repository SSH key permission")
  RestSshAccessKey updatePermission_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("keyId") @NotNull String keyId, @PathParam("permission") @NotNull String permission, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get SSH key.
   * Retrieves the access keys for the project identified in the URL.
   *
   * @param filter If specified only SSH access keys with a label prefixed with the supplied string will be returned. (optional)
   * @param projectKey The project key (not null)
   * @param permission If specified only SSH access keys with at least the supplied permission will be returned Default is PROJECT_READ. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("keys/latest/projects/{projectKey}/ssh")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A single page of access keys associated with the project.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the access keys for this project.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified project does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get SSH key")
  Object getSshKeysForProject(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("permission") String permission, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Add project SSH key.
   * Register a new SSH key and grants access to the project identified in the URL.
   *
   * @param projectKey The project key (not null)
   * @param dto  (optional)
   * @return RestSshAccessKey
   */
  @POST
  @Path("keys/latest/projects/{projectKey}/ssh")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created access key.",
                 content = @Content(schema = @Schema(implementation = RestSshAccessKey.class))),
    @APIResponse(responseCode = "400", description = "The current request contains invalid or missing values.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to add an access key to the project.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified project does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Add project SSH key")
  RestSshAccessKey addForProject(@PathParam("projectKey") @NotNull String projectKey, @Valid RestSshAccessKey dto);

  /**
   * Get project SSH key.
   * Retrieves the access key for the SSH key with id <code>keyId</code> on the project identified in the URL.
   *
   * @param projectKey The project key (not null)
   * @param keyId The key id (not null)
   * @return RestSshAccessKey
   */
  @GET
  @Path("keys/latest/projects/{projectKey}/ssh/{keyId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The access key for the repository and SSH key with ID <code>keyId</code>.",
                 content = @Content(schema = @Schema(implementation = RestSshAccessKey.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to retrieve the access keys for this repository.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified repository or key does not exist or the key does not have access on the repository.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get project SSH key")
  RestSshAccessKey getForProject(@PathParam("projectKey") @NotNull String projectKey, @PathParam("keyId") @NotNull String keyId);

  /**
   * Revoke project SSH key.
   * Remove an existing access key for the project identified in the URL. If the same SSH key is used as an access key for multiple projects or repositories, only the access to the project identified in the URL will be revoked.
   *
   * @param projectKey The project key (not null)
   * @param keyId The key id (not null)
   */
  @DELETE
  @Path("keys/latest/projects/{projectKey}/ssh/{keyId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The access key was deleted (or none was found matching the given id)."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to remove access keys for this project.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Revoke project SSH key")
  void revokeForProject(@PathParam("projectKey") @NotNull String projectKey, @PathParam("keyId") @NotNull String keyId);

  /**
   * Update project SSH key permission.
   * Updates the permission granted to the specified SSH key to the project identified in the URL.
   *
   * @param projectKey The project key (not null)
   * @param keyId The newly created access key (not null)
   * @param permission The new permission to be granted to the SSH key (not null)
   * @return RestSshAccessKey
   */
  @PUT
  @Path("keys/latest/projects/{projectKey}/ssh/{keyId}/permission/{permission}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The newly created access key.",
                 content = @Content(schema = @Schema(implementation = RestSshAccessKey.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions on the project to edit its access keys.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The specified project does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update project SSH key permission")
  RestSshAccessKey updatePermission(@PathParam("projectKey") @NotNull String projectKey, @PathParam("keyId") @NotNull String keyId, @PathParam("permission") @NotNull String permission);

  /**
   * Revoke project SSH key.
   * Remove an existing access key for the projects and repositories in the submitted entity. If the same SSH key is used as an access key for multiple projects or repositories not supplied, only the access to the projects or repositories identified will be revoked.
   *
   * @param keyId The identifier of the SSH key (not null)
   * @param dto  (optional)
   */
  @DELETE
  @Path("keys/latest/ssh/{keyId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The access keys were deleted (or none was found matching the given id and repositories or projects)."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to remove access keys for one or more of the specified projects or repositories.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "On or more of the specified repositories or projects does not exist or the key itself does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Revoke project SSH key")
  void revokeMany(@PathParam("keyId") @NotNull String keyId, Object dto);

  /**
   * Get project SSH keys.
   * Retrieves all project-related access keys for the SSH key with id <code>keyId</code>. If the current user is not an admin any of the projects the key provides access to, none are returned.
   *
   * @param keyId  (not null)
   */
  @GET
  @Path("keys/latest/ssh/{keyId}/projects")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The SSH key with ID <code>keyId</code>."),
    @APIResponse(responseCode = "404", description = "The specified key does not exist",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get project SSH keys")
  void getForProjects(@PathParam("keyId") @NotNull int keyId);

  /**
   * Get repository SSH key.
   * Retrieves all repository-related access keys for the SSH key with id <code>keyId</code>. If the current user is not an admin of any of the projects the key provides access to, none are returned.
   *
   * @param keyId The key id (not null)
   * @param withRestrictions Include the readOnly field. The `readOnly` field is contextual for the user making the request. `readOnly` returns true if there is a restriction and the user does not have`PROJECT_ADMIN` access for the repository the key is associated with. (optional)
   */
  @GET
  @Path("keys/latest/ssh/{keyId}/repos")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The SSH key with ID <code>keyId</code>."),
    @APIResponse(responseCode = "404", description = "The specified key does not exist.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get repository SSH key")
  void getForRepositories(@PathParam("keyId") @NotNull String keyId, @QueryParam("withRestrictions") String withRestrictions);

  /**
   * Get SSH keys for user.
   * Retrieve a page of SSH keys.
   *
   * @param userName the username of the user to retrieve the keys for. If no username is specified, the SSH keys will be retrieved for the current authenticated user. (optional)
   * @param user  (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("ssh/latest/keys")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of SSH keys.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissionsto retrieve the SSH keys. This is only possible when a<strong>user</strong> is explicitly supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "No user matches the supplied <strong>user</strong>",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get SSH keys for user")
  Object getSshKeys(@QueryParam("userName") String userName, @QueryParam("user") String user, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Add SSH key for user.
   * Add a new SSH key to a supplied user.
   *
   * @param user the username of the user to add the SSH key for. If no username is specified, the SSH key will be added for the current authenticated user. (optional)
   * @param dto  (optional)
   * @return RestSshKey
   */
  @POST
  @Path("ssh/latest/keys")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created SSH key.",
                 content = @Content(schema = @Schema(implementation = RestSshKey.class))),
    @APIResponse(responseCode = "400", description = "The SSH key was not created because the key was not a valid RSA/DSA/ECDSA/Ed25519 key of a supported length.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "Either there is no authenticated user or the currently authenticated user has insufficient permissions to add an SSH key. The latter is only possible when a <strong>user</strong> is explicitly supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "No user matches the supplied <strong>user</strong>",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "409", description = "The SSH key already exists on the system.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Add SSH key for user")
  RestSshKey addSshKey(@QueryParam("user") @Valid RestSshKey user, Object dto);

  /**
   * Delete all user SSH key.
   * Delete all SSH keys for a supplied user.
   *
   * @param userName the username of the user to delete the keys for. If no username is specified, the SSH keys will be deleted for the current authenticated user. (optional)
   * @param user  (optional)
   */
  @DELETE
  @Path("ssh/latest/keys")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The SSH keys matching the supplied <strong>user</strong> were deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the SSH keys. This is only possible when a <strong>user</strong> is explicitly supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "No user matches the supplied <strong>user</strong>",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete all user SSH key")
  void deleteSshKeys(@QueryParam("userName") String userName, @QueryParam("user") String user);

  /**
   * Get SSH key for user by keyId.
   * Retrieve an SSH key by keyId
   *
   * @param keyId the ID of the key to retrieve. (not null)
   * @return RestSshKey
   */
  @GET
  @Path("ssh/latest/keys/{keyId}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "An SSH key.",
                 content = @Content(schema = @Schema(implementation = RestSshKey.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissionsto retrieve the SSH key. This is only possible when a<strong>keyId</strong> is explicitly supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "No SSH key matches the supplied <strong>keyId</strong>",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get SSH key for user by keyId")
  RestSshKey getSshKey(@PathParam("keyId") @NotNull String keyId);

  /**
   * Remove SSH key.
   * Delete an SSH key.
   *
   * @param keyId the id of the key to delete. (not null)
   */
  @DELETE
  @Path("ssh/latest/keys/{keyId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The SSH key matching the supplied <strong>id</strong> was deleted or did not exist."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the SSH key.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Remove SSH key")
  void deleteSshKey(@PathParam("keyId") @NotNull String keyId);

  /**
   * Get SSH settings.
   * Gets the SSH settings from the upstream.
   *
   * @return RestSshSettings
   */
  @GET
  @Path("ssh/latest/settings")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The ssh settings from upstream",
                 content = @Content(schema = @Schema(implementation = RestSshSettings.class))),
    @APIResponse(responseCode = "401", description = "The request was not authenticated",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get SSH settings")
  RestSshSettings sshSettings();
}
