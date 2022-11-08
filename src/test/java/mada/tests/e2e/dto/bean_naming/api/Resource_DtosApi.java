/*
 *
 *
 * The version of the OpenAPI document:
 */

package mada.tests.e2e.dto.bean_naming.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.bean_naming.dto.BeanNaming;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/bean-naming")
public interface Resource_DtosApi {

  /**
   * dtosBeanNamingGet.
   *
   * @return BeanNaming
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(BeanNaming.class)
  BeanNaming dtosBeanNamingGet();
}
