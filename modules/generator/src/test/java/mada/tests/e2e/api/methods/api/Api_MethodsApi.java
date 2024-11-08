/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.methods.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/methods")
public interface Api_MethodsApi {

    /**
     * apiMethodsDELETEDelete.
     *
     * @param dto (optional)
     */
    @DELETE
    @Path("/DELETE")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(responseCode = "204", description = "No Content")
    })
    void apiMethodsDELETEDelete(String dto);

    /**
     * apiMethodsGETGet.
     *
     * @return String
     */
    @GET
    @Path("/GET")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(String.class)
    String apiMethodsGETGet();

    /**
     * apiMethodsHEADHead.
     *
     * @return String
     */
    @HEAD
    @Path("/HEAD")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(String.class)
    String apiMethodsHEADHead();

    /**
     * apiMethodsPOSTPost.
     *
     * @param dto (optional)
     * @return String
     */
    @POST
    @Path("/POST")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(String.class)
    String apiMethodsPOSTPost(String dto);

    /**
     * apiMethodsPUTPut.
     *
     * @param dto (optional)
     * @return String
     */
    @PUT
    @Path("/PUT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(String.class)
    String apiMethodsPUTPut(String dto);
}
