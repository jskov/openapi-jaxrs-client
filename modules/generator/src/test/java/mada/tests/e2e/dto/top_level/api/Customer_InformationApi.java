/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.top_level.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v1/customers/{customerId}/nameAndAddresses")
public interface Customer_InformationApi {

  /**
   * Get name and addresses for at specific customer.
   *
   * @param customerId Customer identification. (not null)
   */
  @GET
  @APIResponses({
    @APIResponse(responseCode = "200", description = ""),
    @APIResponse(responseCode = "400", description = ""),
    @APIResponse(responseCode = "401", description = ""),
    @APIResponse(responseCode = "500", description = ""),
    @APIResponse(responseCode = "503", description = "")
  })
  @Operation(summary = "Get name and addresses for at specific customer")
  void getCustomerNameAndAddresses(@PathParam("customerId") @NotNull String customerId);
}
