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
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

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
  @APIResponseSchema(String.class)
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
  @APIResponseSchema(String.class)
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
  @APIResponseSchema(String.class)
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
  @APIResponseSchema(String.class)
  String apiParamsQueryMixedGet(@QueryParam("flag") boolean flag, @QueryParam("item") List<String> item, @QueryParam("name") String name);
}
