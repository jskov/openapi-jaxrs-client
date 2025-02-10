/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.property.order.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.property.order.dto.ValidationDto;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/validation")
public interface Resource_DtosApi {

  /**
   * dtosValidationGet.
   *
   * @return ValidationDto
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ValidationDto.class)
  ValidationDto dtosValidationGet();
}
