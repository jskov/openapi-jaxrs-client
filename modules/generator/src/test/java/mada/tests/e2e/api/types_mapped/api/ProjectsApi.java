/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.types_mapped.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.types_mapped.dto.ProjectDTO;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface ProjectsApi {

  /**
   * projectIdGet.
   *
   * @return String
   */
  @GET
  @Path("projectId")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String projectIdGet();

  /**
   * projectsGet.
   *
   * @return List<ProjectDTO>
   */
  @GET
  @Path("projects")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = ProjectDTO.class, type = SchemaType.ARRAY)))
  })
  List<ProjectDTO> projectsGet();
}
