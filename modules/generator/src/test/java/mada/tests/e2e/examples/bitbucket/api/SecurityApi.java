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
import java.util.Set;
import mada.tests.e2e.examples.bitbucket.dto.ExampleCertificateMultipartFormData;
import mada.tests.e2e.examples.bitbucket.dto.RestGpgKey;
import mada.tests.e2e.examples.bitbucket.dto.RestRepositorySelector;
import mada.tests.e2e.examples.bitbucket.dto.RestSecretScanningAllowlistRule;
import mada.tests.e2e.examples.bitbucket.dto.RestSecretScanningAllowlistRuleSetRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestSecretScanningRule;
import mada.tests.e2e.examples.bitbucket.dto.RestSecretScanningRuleSetRequest;
import mada.tests.e2e.examples.bitbucket.dto.RestX509Certificate;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface SecurityApi {

  /**
   * Find repository secret scanning allowlist rules.
   * Find repository secret scanning allowlist rules by filtering.

Repository **Admin** is required
   *
   * @param filter Filter names by the provided text (optional)
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param order Order by (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/allowlist")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The request was not a correctly formed allowlist rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view repository rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find repository secret scanning allowlist rules")
  Object search_2(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create repository secret scanning allowlist rule.
   * Create a new repository secret scanning allowlist rule. Repository allowlist rules are used when scanning the given repository.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto Allowlist rule to create, either the line regular expression or the path regular expression must be present (not null)
   * @return RestSecretScanningAllowlistRule
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/allowlist")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningAllowlistRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed allowlist rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to create repository rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create repository secret scanning allowlist rule")
  RestSecretScanningAllowlistRule createAllowlistRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @NotNull @Valid RestSecretScanningAllowlistRuleSetRequest dto);

  /**
   * Get a repository secret scanning allowlist rule.
   * Get a repository secret scanning allowlist rule by ID.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The allowlist rule id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestSecretScanningAllowlistRule
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/allowlist/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested allowlist rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningAllowlistRule.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view repository allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The requested allowlist rule was not found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get a repository secret scanning allowlist rule")
  RestSecretScanningAllowlistRule getAllowlistRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Edit an existing repository secret scanning allowlist rule.
   * Edit a repository secret scanning allowlist rule.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The allowlist rule id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto  (not null)
   * @return RestSecretScanningAllowlistRule
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/allowlist/{id}")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated allowlist rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningAllowlistRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed allowlist rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to edit repository allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Edit an existing repository secret scanning allowlist rule")
  RestSecretScanningAllowlistRule editAllowlistRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug, @NotNull @Valid RestSecretScanningAllowlistRuleSetRequest dto);

  /**
   * Delete a repository secret scanning allowlist rule.
   * Delete a repository secret scanning allowlist rule with the provided ID.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The allowlist rule id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/allowlist/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "Empty response indicating that the allowlist rule was deleted"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to delete repository allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a repository secret scanning allowlist rule")
  void deleteAllowlistRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Get whether a repository is exempt.
   * Check whether a repository is exempt from secret scanning
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/exempt")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "True if the repository is exempt from secret scanning, false otherwise"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to check whether a repository is exempt from secret scanning",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get whether a repository is exempt")
  void isRepoExempt();

  /**
   * Exempt a repo from secret scanning.
   * Exempt a repository from being scanned for secrets

<strong>Deprecated since 8.6</strong>. Exemptions are now managed by scope.
Use POST /rest/api/1.0/secret-scanning/exempt for global scope
Use POST /rest/api/1.0/projects/{projectKey}/secret-scanning/exempt for the project scope
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/exempt")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An exempt repo was added"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to exempt a repository from secret scanning",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "At least one of specified repositories have already been previously made exempt.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Exempt a repo from secret scanning")
  void addExemptRepo();

  /**
   * Delete an exempt repository.
   * Remove a repository from being exempt from secret scanning
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/exempt")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "Empty response indicating that the exempt repository was deleted"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to delete an exempt repository",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete an exempt repository")
  void deleteExemptRepo();

  /**
   * Find repository secret scanning rules.
   * Find repository secret scanning rules by filtering.

Repository **Admin** is required
   *
   * @param filter Filter names by the provided text (optional)
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param order Order by (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/rules")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The request was not correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view repository rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find repository secret scanning rules")
  Object search_3(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create repository secret scanning rule.
   * Create a new repository secret scanning rule. Repository rules are used when scanning the given repository.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto Rule to create, either the line regular expression or the path regular expression must be present (not null)
   * @return RestSecretScanningRule
   */
  @POST
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/rules")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to create repository rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create repository secret scanning rule")
  RestSecretScanningRule createRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("repositorySlug") @NotNull String repositorySlug, @NotNull @Valid RestSecretScanningRuleSetRequest dto);

  /**
   * Get a repository secret scanning rule.
   * Get a repository secret scanning rule by ID.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The rule id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @return RestSecretScanningRule
   */
  @GET
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/rules/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view repository rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The requested rule was not found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get a repository secret scanning rule")
  RestSecretScanningRule getRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Edit an existing repository secret scanning rule.
   * Edit a repository secret scanning rule.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The rule id. (not null)
   * @param repositorySlug The repository slug. (not null)
   * @param dto  (not null)
   * @return RestSecretScanningRule
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/rules/{id}")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to edit repository rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Edit an existing repository secret scanning rule")
  RestSecretScanningRule editRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug, @NotNull @Valid RestSecretScanningRuleSetRequest dto);

  /**
   * Delete a repository secret scanning rule.
   * Delete a repository secret scanning rule with the provided ID.

Repository **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The rule id. (not null)
   * @param repositorySlug The repository slug. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/repos/{repositorySlug}/secret-scanning/rules/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "Empty response indicating that the rule was deleted"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to delete repository rules",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a repository secret scanning rule")
  void deleteRule_1(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @PathParam("repositorySlug") @NotNull String repositorySlug);

  /**
   * Find project secret scanning allowlist rules.
   * Find project secret scanning allowlist rules by filtering.

Project **Admin** is required
   *
   * @param filter Filter names by the provided text (optional)
   * @param projectKey The project key. (not null)
   * @param order Order by (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/projects/{projectKey}/secret-scanning/allowlist")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The request was not correctly formed allowlist rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view project allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find project secret scanning allowlist rules")
  Object searchAllowlistRule(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create project secret scanning allowlist rule.
   * Create a new project level secret scanning allowlist rule. Project allowlist rules are used when scanning all non exempt repositories in the provided project.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param dto Allowlist rule to create, either the line regular expression or the path regular expression must be present (not null)
   * @return RestSecretScanningAllowlistRule
   */
  @POST
  @Path("api/latest/projects/{projectKey}/secret-scanning/allowlist")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created allowlist rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningAllowlistRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed allowlist rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to create project allowlist rules.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create project secret scanning allowlist rule")
  RestSecretScanningAllowlistRule createAllowlistRule(@PathParam("projectKey") @NotNull String projectKey, @NotNull @Valid RestSecretScanningAllowlistRuleSetRequest dto);

  /**
   * Get a project secret scanning allowlist rule.
   * Get a project secret scanning allowlist rule by ID.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The allowlist rule id. (not null)
   * @return RestSecretScanningAllowlistRule
   */
  @GET
  @Path("api/latest/projects/{projectKey}/secret-scanning/allowlist/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested allowlist rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningAllowlistRule.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view project allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The requested allowlist rules was not found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get a project secret scanning allowlist rule")
  RestSecretScanningAllowlistRule getAllowlistRule(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

  /**
   * Edit an existing project secret scanning allowlist rule.
   * Edit a project secret scanning allowlist rule.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The allowlist rule id. (not null)
   * @param dto  (not null)
   * @return RestSecretScanningAllowlistRule
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/secret-scanning/allowlist/{id}")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated allowlist rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningAllowlistRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed allowlist rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to modify project allowlist rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Edit an existing project secret scanning allowlist rule")
  RestSecretScanningAllowlistRule editAllowlistRule(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @NotNull @Valid RestSecretScanningAllowlistRuleSetRequest dto);

  /**
   * Delete a project secret scanning allowlist rule.
   * Delete a project secret scanning allowlist rule with the provided ID.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The allowlist rule id. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/secret-scanning/allowlist/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "Empty response indicating that the rule was deleted, or not found at this location"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to delete project rules",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a project secret scanning allowlist rule")
  void deleteAllowlistRule(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

  /**
   * Find repos exempt from secret scanning for a project.
   * Find repositories exempt from secret scanning in a project
   *
   * @param order Order by project name followed by repository name either ascending or descending, defaults to ascending. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/projects/{projectKey}/secret-scanning/exempt")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of repositories",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to search exempt repositories for this project",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find repos exempt from secret scanning for a project")
  Object findExemptReposByProject(@QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Bulk exempt repos from secret scanning.
   * Bulk exempt a  list of repositories from being scanned for secrets. User must be have **PROJECT ADMIN** permissions.
   *
   * @param dto  (optional)
   */
  @POST
  @Path("api/latest/projects/{projectKey}/secret-scanning/exempt")
  @Consumes(MediaType.WILDCARD)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "All requested repositories were made exempt"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to exempt a repository from secret scanning. No repositories were made exempt.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Bulk exempt repos from secret scanning")
  void bulkAddExemptRepositories_1(@Valid Set<RestRepositorySelector> dto);

  /**
   * Find project secret scanning rules.
   * Find project secret scanning rules by filtering.

Project **Admin** is required
   *
   * @param filter Filter names by the provided text (optional)
   * @param projectKey The project key. (not null)
   * @param order Order by (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/projects/{projectKey}/secret-scanning/rules")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The request was not correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view project rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find project secret scanning rules")
  Object search_1(@QueryParam("filter") String filter, @PathParam("projectKey") @NotNull String projectKey, @QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create project secret scanning rule.
   * Create a new project level secret scanning rule. Project rules are used when scanning all non exempt repositories in the provided project.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param dto Rule to create, either the line regular expression or the path regular expression must be present (not null)
   * @return RestSecretScanningRule
   */
  @POST
  @Path("api/latest/projects/{projectKey}/secret-scanning/rules")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to create project rules.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create project secret scanning rule")
  RestSecretScanningRule createRule(@PathParam("projectKey") @NotNull String projectKey, @NotNull @Valid RestSecretScanningRuleSetRequest dto);

  /**
   * Get a project secret scanning rule.
   * Get a project secret scanning rule by ID.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The rule id. (not null)
   * @return RestSecretScanningRule
   */
  @GET
  @Path("api/latest/projects/{projectKey}/secret-scanning/rules/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to view project rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The requested rules was not found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get a project secret scanning rule")
  RestSecretScanningRule getRule(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

  /**
   * Edit an existing project secret scanning rule.
   * Edit a project secret scanning rule.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The rule id. (not null)
   * @param dto  (not null)
   * @return RestSecretScanningRule
   */
  @PUT
  @Path("api/latest/projects/{projectKey}/secret-scanning/rules/{id}")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to modify project rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Edit an existing project secret scanning rule")
  RestSecretScanningRule editRule(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id, @NotNull @Valid RestSecretScanningRuleSetRequest dto);

  /**
   * Delete a project secret scanning rule.
   * Delete a project secret scanning rule with the provided ID.

Project **Admin** is required
   *
   * @param projectKey The project key. (not null)
   * @param id The rule id. (not null)
   */
  @DELETE
  @Path("api/latest/projects/{projectKey}/secret-scanning/rules/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "Empty response indicating that the rule was deleted, or not found at this location"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to delete project rules",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a project secret scanning rule")
  void deleteRule(@PathParam("projectKey") @NotNull String projectKey, @PathParam("id") @NotNull String id);

  /**
   * Find all repos exempt from secret scan.
   * Find all repositories exempt from secret scanning
   *
   * @param order Order by project name followed by repository name either ascending or descending, defaults to ascending. (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/secret-scanning/exempt")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of repositories",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to search exempt repositories globally",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find all repos exempt from secret scan")
  Object findExemptReposByScope(@QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Bulk exempt repos from secret scanning.
   * Bulk exempt a  list of repositories from being scanned for secrets. User must be have global **ADMIN** permissions.
   *
   * @param dto  (optional)
   */
  @POST
  @Path("api/latest/secret-scanning/exempt")
  @Consumes(MediaType.WILDCARD)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "All requested repositories were made exempt"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to exempt a repository from secret scanning. No repositories were made exempt.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "409", description = "At least one of specified repositories have already been previously made exempt.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Bulk exempt repos from secret scanning")
  void bulkAddExemptRepositories(@Valid Set<RestRepositorySelector> dto);

  /**
   * Find global secret scanning rules.
   * Find global secret scanning rules by filtering.
   *
   * @param filter Filter by rule name (optional)
   * @param order Order by (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("api/latest/secret-scanning/rules")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Page of rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed search request, see returned error for more details.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to search global rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Find global secret scanning rules")
  Object search_4(@QueryParam("filter") String filter, @QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create global secret scanning rule.
   * Create a new global secret scanning rule. Global rules are used when scanning all non exempt repositories.
   *
   * @param dto Rule to create, either the line regular expression or the path regular expression must be present (not null)
   * @return RestSecretScanningRule
   */
  @POST
  @Path("api/latest/secret-scanning/rules")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The created rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to create global rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create global secret scanning rule")
  RestSecretScanningRule createRule_2(@NotNull @Valid RestSecretScanningRuleSetRequest dto);

  /**
   * Get a global secret scanning rule.
   * Get a global secret scanning rule by ID.
   *
   * @param id The rule id. (not null)
   * @return RestSecretScanningRule
   */
  @GET
  @Path("api/latest/secret-scanning/rules/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The requested rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to get global rules",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "The requested rule was not found",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get a global secret scanning rule")
  RestSecretScanningRule getRule_2(@PathParam("id") @NotNull String id);

  /**
   * Edit a global secret scanning rule.
   * Edit an existing global secret scanning rule
   *
   * @param id The rule id. (not null)
   * @param dto  (not null)
   * @return RestSecretScanningRule
   */
  @PUT
  @Path("api/latest/secret-scanning/rules/{id}")
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The updated rule",
                 content = @Content(schema = @Schema(implementation = RestSecretScanningRule.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a correctly formed rule. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to update global rules",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Edit a global secret scanning rule.")
  RestSecretScanningRule editRule_2(@PathParam("id") @NotNull String id, @NotNull @Valid RestSecretScanningRuleSetRequest dto);

  /**
   * Delete a global secret scanning rule.
   * Delete a global secret scanning rule with the provided ID
   *
   * @param id The rule id. (not null)
   */
  @DELETE
  @Path("api/latest/secret-scanning/rules/{id}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "Empty response indicating that the rule was deleted"),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to delete global rules",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a global secret scanning rule")
  void deleteRule_2(@PathParam("id") @NotNull String id);

  /**
   * Get all X.509 certificates
   * Get all X.509 certificates that have been added to the system.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @return RestX509Certificate
   */
  @GET
  @Path("api/latest/signing/x509-certificates")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A page of X.509 certificates",
                 content = @Content(schema = @Schema(implementation = RestX509Certificate.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to get X.509 certificates",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get all X.509 certificates")
  RestX509Certificate getAllCertificates();

  /**
   * Create an X.509 certificate
   * Create an X.509 certificate. This will add the given X.509 certificate to the system. Existing entries will not be overridden if an X.509 certificate already exists. Once added, an X.509 certificate cannot be updated.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @param dto The multipart form data containing the certificate in a form-field named 'certificate' (not null)
   * @return RestX509Certificate
   */
  @POST
  @Path("api/latest/signing/x509-certificates")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "The newly created X.509 certificate",
                 content = @Content(schema = @Schema(implementation = RestX509Certificate.class))),
    @APIResponse(responseCode = "400", description = "The request did not contain a valid X.509 certificate request. See returned error for more details",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to create X.509 certificates",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create an X.509 certificate")
  RestX509Certificate createCertificate(@NotNull @Valid ExampleCertificateMultipartFormData dto);

  /**
   * Update X.509 CRL entries
   * Update the certificate revocation list (CRL) entries for an issuer X.509 certificate in the system, identified by <code>id</code>. This will add any new revoked X.509 certificates that were issued by the given issuer X.509 certificate.

This endpoint will schedule a request to asynchronously perform the task. Please allow time for the task to complete as it will vary depending on how many CRLs there are to retrieve and process.

Note: CRL updates are scheduled to run every 24 hours. You may wish to trigger a refresh manually using this endpoint, otherwise, entries will be updated daily.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @param id The ID of the issuer certificate. (not null)
   */
  @PUT
  @Path("api/latest/signing/x509-certificates/crl/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successfully started processing CRLs."),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to update X.509 CRL entries",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "There is no X.509 certificate with the given ID",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Update X.509 CRL entries")
  void updateCertificateRevocationListEntries(@PathParam("id") @NotNull String id);

  /**
   * Delete an X.509 certificate
   * Delete an X.509 certificate specified by the given ID.

The authenticated user must have the <strong>ADMIN</strong> permission to call this resource.
   *
   * @param id The ID of the X.509 certificate. (not null)
   */
  @DELETE
  @Path("api/latest/signing/x509-certificates/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "An empty response if the X.509 certificate was successfully deleted",
                 content = @Content(schema = @Schema(implementation = RestX509Certificate.class))),
    @APIResponse(responseCode = "401", description = "The authenticated user is not permitted to delete X.509 certificates",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "404", description = "There is no X.509 certificate with the given ID",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Delete an X.509 certificate")
  void deleteCertificate(@PathParam("id") @NotNull String id);

  /**
   * Get all GPG keys.
   * Find all the keys for the currently authenticated user. Optionally, users with ADMIN and higher permissions may choose to specify the <code>user</code> parameter to retrieve GPG keys for another user.

Only authenticated users may call this endpoint.
   *
   * @param user The name of the user to get keys for (optional; requires ADMIN permission or higher). (optional)
   * @param start Start number for the page (inclusive). If not passed, first page is assumed. (optional)
   * @param limit Number of items to return. If not passed, a page size of 25 is used. (optional)
   * @return Object
   */
  @GET
  @Path("gpg/latest/keys")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Returns a paged response of of keys for the user.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to perform this operation.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Get all GPG keys")
  Object getKeysForUser(@QueryParam("user") String user, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);

  /**
   * Create a GPG key.
   * Add a GPG key to the authenticated user's account. Optionally, users with ADMIN and higher permissions may choose to specify the <code>user</code> parameter to add a GPG key for another user.

Only authenticated users may call this endpoint.
   *
   * @param user The name of the user to add a key for (optional; requires ADMIN permission or higher). (optional)
   * @param dto The request body. (optional)
   * @return RestGpgKey
   */
  @POST
  @Path("gpg/latest/keys")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Response contains the GPG key that was just created.",
                 content = @Content(schema = @Schema(implementation = RestGpgKey.class))),
    @APIResponse(responseCode = "400", description = "The request has failed validation.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to perform this operation.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Create a GPG key")
  RestGpgKey addKey(@QueryParam("user") String user, @Valid RestGpgKey dto);

  /**
   * Delete all GPG keys for user.
   * Delete all GPG keys for a supplied user.
   *
   * @param user The username of the user to delete the keys for. If no username is specified, the GPG keys will be deleted for the currently authenticated user. (optional)
   */
  @DELETE
  @Path("gpg/latest/keys")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The GPG keys matching the supplied <strong>user</strong> were deleted."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to delete the GPG keys. This is only possible when a <strong>user</strong> is explicitly supplied.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "404", description = "No user matches the supplied <strong>user</strong>.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete all GPG keys for user")
  void deleteForUser(@QueryParam("user") String user);

  /**
   * Delete a GPG key.
   * Delete the GPG key with the specified ID or Key Fingerprint.
   *
   * @param fingerprintOrId The GPG fingerprint or ID. (not null)
   */
  @DELETE
  @Path("gpg/latest/keys/{fingerprintOrId}")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "The key has been deleted successfully."),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions to perform this operation.",
                 content = @Content(schema = @Schema(implementation = Object.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Delete a GPG key")
  void deleteKey(@PathParam("fingerprintOrId") @NotNull String fingerprintOrId);
}
