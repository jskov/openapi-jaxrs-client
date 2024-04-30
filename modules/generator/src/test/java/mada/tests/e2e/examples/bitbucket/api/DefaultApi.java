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

import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/latest/inbox/pull-requests")
public interface DefaultApi {

  /**
   * Get pull requests in inbox.
   * Returns a page of pull requests in the user's inbox.
   *
   * @param role  (optional)
   * @param limit  (optional)
   * @param start  (optional)
   */
  @GET
  @Produces("application/json;charset=UTF-8")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response")
  })
  @Operation(summary = "Get pull requests in inbox")
  void getPullRequests_2(@QueryParam("role") String role, @QueryParam("limit") int limit, @QueryParam("start") int start);

  /**
   * Get total number of pull requests in inbox.
   * Returns the total number of pull requests in the user's inbox
   */
  @GET
  @Path("/count")
  @Produces("application/json;charset=UTF-8")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response")
  })
  @Operation(summary = "Get total number of pull requests in inbox")
  void getPullRequestCount();
}
