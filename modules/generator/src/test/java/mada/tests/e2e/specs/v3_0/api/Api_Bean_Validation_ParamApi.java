/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_0.dto.Environment;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/validation/param/path/{env}")
public interface Api_Bean_Validation_ParamApi {

  /**
   * apiValidationParamPathEnvGet.
   *
   * @param env  (not null)
   * @return String
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String apiValidationParamPathEnvGet(@PathParam("env") @NotNull @Valid Environment env);
}
