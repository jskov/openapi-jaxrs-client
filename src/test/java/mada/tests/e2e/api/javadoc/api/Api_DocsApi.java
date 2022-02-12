/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.javadoc.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.javadoc.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/docs")
public interface Api_DocsApi {

  /**
   * op summary.
   * op description
   *
   * @return String
   */
  @GET
  @Path("/GET")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String opId();

  /**
   * op is deprecated.
   *
   * @return String
   */
  @GET
  @Path("/deprecated")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(String.class)
  String apiDocsDeprecatedGet();

  /**
   * apiDocsParamsInPathGet.
   *
   * @param inPath  (required)
   * @param query  (optional)
   * @param queryDeprecated  (optional)
   * @param item  (optional)
   * @param dto  (optional)
   * @return String
   */
  @GET
  @Path("/params/{in-path}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiDocsParamsInPathGet(@PathParam("in-path") String inPath, @QueryParam("query") String query, @QueryParam("query-deprecated") String queryDeprecated, @HeaderParam("item") List<String> item, Simple dto);
}
