/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.validation.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.validation.dto.Environment;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/validation/pathparam/{env}")
public interface Api_Bean_ValidationApi {

  /**
   * apiValidationPathparamEnvGet.
   *
   * @param env  (required)
   * @return String
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String apiValidationPathparamEnvGet(@PathParam("env") @NotNull Environment env);
}
