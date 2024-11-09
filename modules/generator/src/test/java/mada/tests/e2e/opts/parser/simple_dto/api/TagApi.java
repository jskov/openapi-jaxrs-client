/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.simple_dto.api;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.parser.simple_dto.dto.NoPropsDto;
import mada.tests.e2e.opts.parser.simple_dto.dto.PropDto;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/add")
public interface TagApi {

    /**
     * addPost.
     *
     * @param auth (not null)
     * @param dto  (optional)
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "Success")
    })
    void addPost(@HeaderParam("Authorization") String auth, @Valid PropDto dto);

    /**
     * addPut.
     *
     * @param auth (not null)
     * @param dto  (optional)
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "Success")
    })
    void addPut(@HeaderParam("Authorization") String auth, @Valid NoPropsDto dto);
}
