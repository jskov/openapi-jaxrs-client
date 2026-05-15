/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.validation.jakarta.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/free-form-object/typeless")
public interface DefaultApi {

  /**
   * freeFormObjectTypelessPut.
   *
   * @param dto  (not null)
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  void freeFormObjectTypelessPut(@NotNull Map<String, Object> dto);
}
