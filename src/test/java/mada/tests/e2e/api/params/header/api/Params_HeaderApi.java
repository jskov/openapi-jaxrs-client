/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.header.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/header")
public interface Params_HeaderApi {

  /**
   * apiParamsHeaderBooleanPrimitiveGet
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-primitive")
  @APIResponseSchema(String.class)
  String apiParamsHeaderBooleanPrimitiveGet(@HeaderParam("flag") boolean flag);

  /**
   * apiParamsHeaderBooleanWrapperGet
   *
   * @param flag  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-wrapper")
  @APIResponseSchema(String.class)
  String apiParamsHeaderBooleanWrapperGet(@HeaderParam("flag") boolean flag);

  /**
   * apiParamsHeaderInvalidNameDashesGet
   *
   * @param invalidValue  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/invalid-name-dashes")
  @APIResponseSchema(String.class)
  String apiParamsHeaderInvalidNameDashesGet(@HeaderParam("invalid-value") boolean invalidValue);

  /**
   * apiParamsHeaderListGet
   *
   * @param item  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/list")
  @APIResponseSchema(String.class)
  String apiParamsHeaderListGet(@HeaderParam("item") List<String> item);

  /**
   * apiParamsHeaderMixedGet
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
  String apiParamsHeaderMixedGet(@HeaderParam("flag") boolean flag, @HeaderParam("item") List<String> item, @HeaderParam("name") String name);
}
