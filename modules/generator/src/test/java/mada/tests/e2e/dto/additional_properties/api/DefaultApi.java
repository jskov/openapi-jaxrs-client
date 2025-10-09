/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.additional_properties.api;

import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.additional_properties.dto.Event_read;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface DefaultApi {

  /**
   * dtosAdditionalPropertiesGet.
   *
   * @return Event_read
   */
  @GET
  @Path("dtos/additional_properties")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Event_read.class)
  Event_read dtosAdditionalPropertiesGet();

  /**
   * patchIncome.
   *
   * @param label  (not null)
   * @param ref
   * @param dto Only 'description' and 'isWorkingDraft' are allowed to be patched (not null)
   * @return Event_read
   */
  @PATCH
  @Path("kkt-income/incomes/{ref}/{label}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Event_read.class)
  Event_read patchIncome(@PathParam("label") @NotNull String label, @PathParam("ref") int ref, @NotNull Map<String, Object> dto);
}
