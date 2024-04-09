/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.validation_api.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.validation_api.dto.Environment;
import mada.tests.e2e.opts.generator.validation_api.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/validation")
public interface Api_Bean_ValidationApi {

  /**
   * apiValidationBodyPut.
   *
   * @param simple  (not null)
   * @return String
   */
  @PUT
  @Path("/body")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String apiValidationBodyPut(Simple simple);

  /**
   * apiValidationPathparamEnvGet.
   *
   * @param env  (not null)
   * @return String
   */
  @GET
  @Path("/pathparam/{env}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String apiValidationPathparamEnvGet(@PathParam("env") Environment env);
}
