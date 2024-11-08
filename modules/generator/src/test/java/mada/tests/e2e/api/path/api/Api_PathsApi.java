/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.path.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/hyphen-path/hyphen-method")
public interface Api_PathsApi {

    /**
     * hyphenPathHyphenMethodGet.
     *
     * @return String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(String.class)
    String hyphenPathHyphenMethodGet();
}
