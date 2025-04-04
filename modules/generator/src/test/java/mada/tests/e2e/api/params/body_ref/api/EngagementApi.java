/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.api.params.body_ref.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.params.body_ref.dto.EngagementInput;
import mada.tests.e2e.api.params.body_ref.dto.ErrorMessage400;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/v1/customers/{customerId}/nameAndAddresses")
public interface EngagementApi {

  /**
   * v1CustomersCustomerIdNameAndAddressesPost.
   *
   * @param customerId Customer identification. (not null)
   * @param dto  (not null)
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "400", description = "Bad input from user",
                 content = @Content(schema = @Schema(implementation = ErrorMessage400.class)))
  })
  void v1CustomersCustomerIdNameAndAddressesPost(@PathParam("customerId") @NotNull String customerId, @NotNull @Valid EngagementInput dto);
}
