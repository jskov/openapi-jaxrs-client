/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.validation.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.validation.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/validation/body")
public interface Api_Bean_Validation_BodyApi {

  /**
   * apiValidationBodyPut.
   *
   * @param dto  (required)
   * @return String
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String apiValidationBodyPut(@NotNull @Valid Simple dto);
}
