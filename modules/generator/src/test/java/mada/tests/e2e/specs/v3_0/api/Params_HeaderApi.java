/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/header")
public interface Params_HeaderApi {

  /**
   * apiParamsHeaderBooleanPrimitiveGet.
   *
   * @param flag
   * @return String
   */
  @GET
  @Path("/boolean-primitive")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsHeaderBooleanPrimitiveGet(@HeaderParam("flag") boolean flag);

  /**
   * apiParamsHeaderBooleanWrapperGet.
   *
   * @param flag
   * @return String
   */
  @GET
  @Path("/boolean-wrapper")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsHeaderBooleanWrapperGet(@HeaderParam("flag") boolean flag);

  /**
   * apiParamsHeaderInvalidNameDashesGet.
   *
   * @param invalidValue
   * @return String
   */
  @GET
  @Path("/invalid-name-dashes")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsHeaderInvalidNameDashesGet(@HeaderParam("invalid-value") boolean invalidValue);

  /**
   * apiParamsHeaderListGet.
   *
   * @param item  (optional)
   * @return String
   */
  @GET
  @Path("/list")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsHeaderListGet(@HeaderParam("item") List<String> item);

  /**
   * apiParamsHeaderMixedGet.
   *
   * @param flag
   * @param item  (optional)
   * @param name  (optional)
   * @return String
   */
  @GET
  @Path("/mixed")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsHeaderMixedGet(@HeaderParam("flag") boolean flag, @HeaderParam("item") List<String> item, @HeaderParam("name") String name);
}
