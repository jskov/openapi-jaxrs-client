/*
 * x
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.void200to204.api;

import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/slet")
public interface DefaultApi {

  /**
   * sletDelete.
   *
   * @param kri  (optional)
   * @param kro  (optional)
   */
  @DELETE
  @APIResponses({
    @APIResponse(responseCode = "204", description = "No Content")
  })
  void sletDelete(@QueryParam("kri") String kri, @QueryParam("kro") String kro);
}
