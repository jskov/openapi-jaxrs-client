/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/header")
public interface Params_HeaderApi {

  /**
   * Query Boolean Primitive.
   *
   * @param flag
   * @return String
   */
  @GET
  @Path("/boolean-primitive")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Boolean Primitive")
  String apiParamsHeaderBooleanPrimitiveGet(@HeaderParam("flag") boolean flag);

  /**
   * Query Boolean Wrapper.
   *
   * @param flag
   * @return String
   */
  @GET
  @Path("/boolean-wrapper")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query Boolean Wrapper")
  String apiParamsHeaderBooleanWrapperGet(@HeaderParam("flag") boolean flag);

  /**
   * Param Needs Renaming.
   *
   * @param invalidValue
   * @return String
   */
  @GET
  @Path("/invalid-name-dashes")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Param Needs Renaming")
  String apiParamsHeaderInvalidNameDashesGet(@HeaderParam("invalid-value") boolean invalidValue);

  /**
   * Query List.
   *
   * @param item  (optional)
   * @return String
   */
  @GET
  @Path("/list")
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  @Operation(summary = "Query List")
  String apiParamsHeaderListGet(@HeaderParam("item") List<String> item);

  /**
   * Query List.
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
  @Operation(summary = "Query List")
  String apiParamsHeaderMixedGet(@HeaderParam("flag") boolean flag, @HeaderParam("item") List<String> item, @HeaderParam("name") String name);
}
