/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/hyphen-path/hyphen-method")
public interface Api_PathsApi {

  /**
   * Get.
   *
   * @return String
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  @Operation(summary = "Get")
  String hyphenPathHyphenMethodGet();
}
