/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.types_time.api;

import java.time.LocalTime;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types")
public interface Api_TypesApi {

  /**
   * apiTypesListTimeGet.
   *
   * @return List&lt;LocalTime&gt;
   */
  @GET
  @Path("/list-time")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = LocalTime.class, type = SchemaType.ARRAY)))
  })
  List<LocalTime> apiTypesListTimeGet();

  /**
   * apiTypesTimeGet.
   *
   * @return LocalTime
   */
  @GET
  @Path("/time")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(LocalTime.class)
  LocalTime apiTypesTimeGet();
}
