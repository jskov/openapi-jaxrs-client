/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.schema_naming.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.schema_naming.dto.DtoA;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos/schema")
public interface Resource_DtosApi {

    /**
     * dtosSchemaGet.
     *
     * @return DtoA
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(DtoA.class)
    DtoA dtosSchemaGet();
}
