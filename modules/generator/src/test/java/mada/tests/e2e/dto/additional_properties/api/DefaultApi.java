/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.additional_properties.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.additional_properties.dto.Event_read;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/additional_properties")
public interface DefaultApi {

  /**
   * dtosAdditionalPropertiesGet.
   *
   * @return Event_read
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Event_read.class)
  Event_read dtosAdditionalPropertiesGet();
}
