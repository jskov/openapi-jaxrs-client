/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.api;

import javax.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@RegisterRestClient(configKey = "kfaService")
@Path("/ping")
public interface DefaultApi {

  /**
   * ping.
   *
   * @return String
   */
  @GET
  @Produces("*/*")
  @APIResponseSchema(String.class)
  String ping();
}
