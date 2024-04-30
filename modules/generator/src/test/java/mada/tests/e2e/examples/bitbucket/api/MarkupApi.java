/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mada.tests.e2e.examples.bitbucket.dto.RestMarkup;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/latest/markup/preview")
public interface MarkupApi {

  /**
   * Preview markdown render.
   * Preview generated HTML for the given markdown content.

Only authenticated users may call this resource.
   *
   * @param htmlEscape (Optional) true if HTML should be escaped in the input markup, false otherwise. (optional)
   * @param urlMode (Optional) The mode to use when building URLs. One of: ABSOLUTE, RELATIVE or, CONFIGURED. By default this is RELATIVE. (optional)
   * @param includeHeadingId (Optional) true if headers should contain an ID based on the heading content. (optional)
   * @param hardwrap (Optional) Whether the markup implementation should convert newlines to breaks. By default this is false which reflects the standard markdown specification. (optional)
   * @param dto  (optional)
   * @return RestMarkup
   */
  @POST
  @Consumes(MediaType.WILDCARD)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "The rendered markdown.",
                 content = @Content(schema = @Schema(implementation = RestMarkup.class))),
    @APIResponse(responseCode = "400", description = "The markdown was invalid.",
                 content = @Content(schema = @Schema(implementation = Object.class))),
    @APIResponse(responseCode = "401", description = "The currently authenticated user has insufficient permissions preview rendered markdown.",
                 content = @Content(schema = @Schema(implementation = Object.class)))
  })
  @Operation(summary = "Preview markdown render")
  RestMarkup preview(@QueryParam("htmlEscape") String htmlEscape, @QueryParam("urlMode") String urlMode, @QueryParam("includeHeadingId") String includeHeadingId, @QueryParam("hardwrap") String hardwrap, String dto);
}
