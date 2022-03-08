/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.validation.allof.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.validation.allof.dto.ProjectCreateDTO;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/allof/validation")
public interface Resource_DtosApi {

  /**
   * dtosAllofValidationGet.
   *
   * @return ProjectCreateDTO
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ProjectCreateDTO.class)
  ProjectCreateDTO dtosAllofValidationGet();
}
