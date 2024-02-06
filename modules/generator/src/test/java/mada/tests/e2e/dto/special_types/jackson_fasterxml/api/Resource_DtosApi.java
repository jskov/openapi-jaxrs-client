/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.special_types.jackson_fasterxml.api;

import java.util.UUID;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.special_types.jackson_fasterxml.dto.SpecialTypes;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface Resource_DtosApi {

  /**
   * apiUuidQueryGet.
   *
   * @param roomId  (optional)
   * @return SpecialTypes
   */
  @GET
  @Path("api/uuid/query")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SpecialTypes.class)
  SpecialTypes apiUuidQueryGet(@QueryParam("roomId") UUID roomId);

  /**
   * dtosSpecialTypesGet.
   *
   * @return SpecialTypes
   */
  @GET
  @Path("dtos/special-types")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SpecialTypes.class)
  SpecialTypes dtosSpecialTypesGet();
}
