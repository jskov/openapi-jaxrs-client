/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.regression.response_description.api;

import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/whatever")
public interface TasksApi {

  /**
   * Delete a task.
   * Delete a task.
   *
   * @param auth  (not null)
   */
  @DELETE
  @APIResponses({
    @APIResponse(responseCode = "204", description = "")
  })
  @Operation(summary = "Delete a task.")
  void deleteTask(@HeaderParam("Authorization") String auth);
}
