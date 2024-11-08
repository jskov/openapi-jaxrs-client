/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.line_ending.unix.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.line_ending.unix.dto.SpecialTypes;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/special-types")
public interface Resource_DtosApi {

    /**
     * dtosSpecialTypesGet.
     *
     * @return SpecialTypes
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(SpecialTypes.class)
    SpecialTypes dtosSpecialTypesGet();
}
