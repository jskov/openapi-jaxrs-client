/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.cyclic.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.dto.cyclic.dto.CyclicA;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/cyclic")
public interface Resource_DtosApi {

    /**
     * dtosCyclicGet.
     *
     * @return CyclicA
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(CyclicA.class)
    CyclicA dtosCyclicGet();
}
