/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.external_types.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.external_types.dto.ArraysDto;
import mada.tests.e2e.opts.generator.external_types.p2.MapsDto;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
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
