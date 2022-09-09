/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions_doc.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.parser.collisions_doc.dto.Collisions;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/collision")
public interface Resource_DtosApi {

  /**
   * dtosCollisionGet.
   *
   * @return Collisions
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Collisions.class)
  Collisions dtosCollisionGet();
}
