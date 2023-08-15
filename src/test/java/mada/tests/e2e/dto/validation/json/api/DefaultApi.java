/*
 * Some title Api
 *
 * The version of the OpenAPI document: v1
 */

package mada.tests.e2e.dto.validation.json.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.validation.json.dto.Request;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/Test/Calc")
public interface DefaultApi {

  /**
   * TBD.
   * NA
   *
   * @param dto  (required)
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "204", description = "OK")
  })
  @Operation(summary = "TBD.")
  void Calcit(@NotNull @Valid Request dto);
}
