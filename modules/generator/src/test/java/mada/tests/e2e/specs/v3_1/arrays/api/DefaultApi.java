/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.arrays.api;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_1.arrays.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/docs/multiple-return-types")
public interface DefaultApi {

  /**
   * apiDocsMultipleReturnTypesPost.
   *
   * @param dto  (not null)
   * @return List<Simple>
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The registered cluster",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY)))
  })
  List<Simple> apiDocsMultipleReturnTypesPost(@NotNull @Valid Simple dto);
}
