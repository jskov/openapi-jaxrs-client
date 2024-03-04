/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/ping")
public interface DefaultApi {

  /**
   * ping.
   *
   * @return String
   */
  @GET
  @Produces(MediaType.WILDCARD)
  @APIResponseSchema(String.class)
  String ping();
}
