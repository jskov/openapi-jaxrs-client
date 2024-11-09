/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.default_api.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/methods")
public interface FooBarApi {

    /**
     * apiMethodsDELETEDelete.
     *
     * @param dto (optional)
     */
    @DELETE
    @Path("/DELETE")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "No Content")
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
}
