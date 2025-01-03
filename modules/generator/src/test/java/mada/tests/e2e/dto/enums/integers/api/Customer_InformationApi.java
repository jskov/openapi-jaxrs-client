/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.dto.enums.integers.api;

import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v1/customers/engagements")
public interface Customer_InformationApi {

  /**
   * Get engagements (refNo) for a specific customer.
   */
  @GET
  @APIResponses({
    @APIResponse(responseCode = "200", description = "")
  })
  @Operation(summary = "Get engagements (refNo) for a specific customer.")
  void getCustomerEngagement();
}
