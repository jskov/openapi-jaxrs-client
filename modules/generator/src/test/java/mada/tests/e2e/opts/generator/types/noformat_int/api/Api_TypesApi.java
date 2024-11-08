/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.types.noformat_int.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/types")
public interface Api_TypesApi {

    /**
     * apiTypesInt32Get.
     *
     * @return int
     */
    @GET
    @Path("/int32")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(Integer.class)
    int apiTypesInt32Get();

    /**
     * apiTypesInt64Get.
     *
     * @return long
     */
    @GET
    @Path("/int64")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(Long.class)
    long apiTypesInt64Get();

    /**
     * apiTypesNoformatGet.
     *
     * @return int
     */
    @GET
    @Path("/noformat")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(Integer.class)
    int apiTypesNoformatGet();
}
