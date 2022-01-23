/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.collection_import.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.collection_import.dto.Simple;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types/list-simple")
public interface Api_TypesApi {

  /**
   * apiTypesListSimpleGet
   *
   * @return List&lt;Simple&gt;
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  List<Simple> apiTypesListSimpleGet();
}
