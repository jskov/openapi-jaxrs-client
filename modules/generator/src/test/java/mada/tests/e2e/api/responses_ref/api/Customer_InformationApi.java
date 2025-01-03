/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.api.responses_ref.api;

import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import mada.tests.e2e.api.responses_ref.dto.ErrorMessage400;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v1/customers/")
public interface Customer_InformationApi {

  /**
   * Get name and addresses for at specific customer.
   */
  @GET
  @APIResponses({
    @APIResponse(responseCode = "400", description = "")
  })
  @Operation(summary = "Get name and addresses for at specific customer")
  ErrorMessage400 getCustomerNameAndAddresses();
}
