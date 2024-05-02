/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.types_special.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.types_special.dto.ResultApiTypesBitbucketArray;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types/bitbucket-array")
public interface Api_TypesApi {

  /**
   * apiTypesBitbucketArrayGet.
   *
   * @return ResultApiTypesBitbucketArray
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ResultApiTypesBitbucketArray.class)
  ResultApiTypesBitbucketArray apiTypesBitbucketArrayGet();
}
