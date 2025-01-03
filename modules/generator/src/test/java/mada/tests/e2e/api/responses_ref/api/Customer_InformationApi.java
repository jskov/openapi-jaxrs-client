/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.api.responses_ref.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.responses_ref.dto.CustomerDetailsResponse;
import mada.tests.e2e.api.responses_ref.dto.ErrorMessage400;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v1/customers/")
public interface Customer_InformationApi {

  /**
   * Get name and addresses for at specific customer.
   *
   * @return CustomerDetailsResponse
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Valid respose for get customer details.\n",
                 content = @Content(schema = @Schema(implementation = CustomerDetailsResponse.class))),
    @APIResponse(responseCode = "400", description = "Bad input from user",
                 content = @Content(schema = @Schema(implementation = ErrorMessage400.class)))
  })
  @Operation(summary = "Get name and addresses for at specific customer")
  CustomerDetailsResponse getCustomerNameAndAddresses();
}
