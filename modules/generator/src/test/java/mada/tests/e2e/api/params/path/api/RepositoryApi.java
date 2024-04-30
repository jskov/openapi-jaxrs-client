/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.path.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/branch-utils/latest/projects/{projectKey}/repos/{repositorySlug}/branches/info/{commitId}")
public interface RepositoryApi {

  /**
   * Get branch.
   * Gets the branch information associated with a single commit from a given repository.
   *
   * @param projectKey The project key. (not null)
   * @param commitId  (not null)
   */
  @GET
  @Operation(summary = "Get branch")
  void findByCommit(@PathParam("projectKey") @NotNull String projectKey, @PathParam("commitId") @NotNull @Size(max = 40) String commitId);
}
