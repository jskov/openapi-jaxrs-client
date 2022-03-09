/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.mp.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.mp.dto.ArraysDto;
import mada.tests.e2e.opts.generator.mp.dto.MapsDto;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@RegisterProvider(mada.tests.e2e.opts.generator.mp.DummyRegistratorBar.class)
@RegisterProvider(mada.tests.e2e.opts.generator.mp.DummyRegistratorFoo.class)
@RegisterRestClient(configKey = "mp-config-key")
@Path("/dtos/collections")
public interface Resource_DtosApi {

  /**
   * dtosCollectionsArrayGet.
   *
   * @return ArraysDto
   */
  @GET
  @Path("/array")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ArraysDto.class)
  ArraysDto dtosCollectionsArrayGet();

  /**
   * dtosCollectionsMapGet.
   *
   * @return MapsDto
   */
  @GET
  @Path("/map")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(MapsDto.class)
  MapsDto dtosCollectionsMapGet();
}
