/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.external_types.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.external_types.dto.ArraysDto;
import mada.tests.e2e.opts.generator.external_types.p1.Simple;
import mada.tests.e2e.opts.generator.external_types.p2.MapsDto;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos")
public interface Resource_DtosApi {

  /**
   * dtosCollectionsArrayGet.
   *
   * @return ArraysDto
   */
  @GET
  @Path("/collections/array")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ArraysDto.class)
  ArraysDto dtosCollectionsArrayGet();

  /**
   * dtosCollectionsMapGet.
   *
   * @return MapsDto
   */
  @GET
  @Path("/collections/map")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(MapsDto.class)
  MapsDto dtosCollectionsMapGet();

  /**
   * dtosSuppressedPrimitiveTypeGet.
   *
   * @return List<Simple>
   */
  @GET
  @Path("/suppressedPrimitiveType")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "200", description = "OK",
                 content = @Content(schema = @Schema(implementation = Simple.class, type = SchemaType.ARRAY)))
  })
  List<Simple> dtosSuppressedPrimitiveTypeGet();
}
