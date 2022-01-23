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

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types")
public interface Api_TypesApi {

  /**
   * apiTypesListTimeGet
   *
   * @return List&lt;LocalTime&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list-time")
  List<LocalTime> apiTypesListTimeGet();

  /**
   * apiTypesTimeGet
   *
   * @return LocalTime
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/time")
  LocalTime apiTypesTimeGet();
}
