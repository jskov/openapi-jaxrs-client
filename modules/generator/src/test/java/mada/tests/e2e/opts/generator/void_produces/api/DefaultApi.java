/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.void_produces.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/methods")
public interface DefaultApi {

    /**
     * apiMethodsDELETEDelete.
     *
     * @param dto (optional)
     */
    @DELETE
    @Path("/DELETE")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.WILDCARD)
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
}
