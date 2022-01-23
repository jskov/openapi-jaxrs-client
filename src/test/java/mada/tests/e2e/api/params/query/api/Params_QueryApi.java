/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.query.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/query")
public interface Params_QueryApi {

  /**
   * apiParamsQueryBooleanPrimitiveGet
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-primitive")
  String apiParamsQueryBooleanPrimitiveGet(@QueryParam("flag") boolean flag);

  /**
   * apiParamsQueryBooleanWrapperGet
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-wrapper")
  String apiParamsQueryBooleanWrapperGet(@QueryParam("flag") boolean flag);

  /**
   * apiParamsQueryListGet
   *
   * @param item  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/list")
  String apiParamsQueryListGet(@QueryParam("item") List<String> item);

  /**
   * apiParamsQueryMixedGet
   *
   * @param flag  (optional)
   * @param item  (optional)
   * @param name  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/mixed")
  String apiParamsQueryMixedGet(@QueryParam("flag") boolean flag, @QueryParam("item") List<String> item, @QueryParam("name") String name);
}
