/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: 1.0.0+openapi_API_Version
 */

package mada.tests.e2e.dto.discriminator_invalid.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.discriminator_invalid.dto.Identification;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/id")
public interface DefaultApi {

    /**
     * getId.
     *
     * @return Identification
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "Returns id",
                    content = @Content(
                            schema = @Schema(implementation = Identification.class)))
    })
    Identification getId();
}
