/*
 * 
 *
 * The version of the OpenAPI document: 
 */

package mada.tests.e2e.opts.generator.inputstream.api;

import java.io.InputStream;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface DefaultApi {

  /**
   * getPhoto.
   *
   * @param userId  (required)
   * @param size  (optional)
   * @return List&lt;Byte&gt;
   */
  @GET
  @Path("employees/{userId}/photo")
  @Produces("image/jpeg")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "default response",
                 content = @Content(schema = @Schema(implementation = Byte.class, type = SchemaType.ARRAY)))
  })
  InputStream getPhoto(@PathParam("userId") @NotNull String userId, @QueryParam("size") String size);
}
